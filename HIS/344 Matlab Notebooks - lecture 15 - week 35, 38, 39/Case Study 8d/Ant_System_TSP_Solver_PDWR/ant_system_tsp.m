function [popt, fopt, stat] = ant_system_tsp(map_fct, stopeval, varargin)
% [popt, fopt, stat] = ant_system_tsp(map_fct, stopeval, varargin)
%
% Implemenetation of an Ant System algorithm for solving TSP problems
%
% Input:
% - map            - A city map, which is a matrix of 2D city coordinates
% - stopeval       - The number of function evaluations used
%                    by the optimization algorithm
%
% Options:
% - m              - The number of ants (default: 100)
% - rho            - The evaporation rate (default: 0.1)
% - alpha          - The pheromone influence parameter (default: 1)
% - beta           - The heuristic influence parameter (default: 3)
% - visualization  - Visualize the run of the algorithm (default: true)
%
% Output:
% - popt           - A vector containing the optimal path
% - fopt           - The length of the optimal path
% - stat           - A MATLAB struct containing algorithm
%                    specific output statistics
%
% Author: Johannes W. Kruisselbrink
% Last modified: October 20, 2011

	% Parse the inputs
	p = inputParser;
	p.addRequired('map_fct');
	p.addRequired('stopeval');
	p.addOptional('m', 100);
	p.addOptional('rho', .1);
	p.addOptional('alpha', 1);
	p.addOptional('beta', 3);
	p.addOptional('visualization', true);
	p.parse(map_fct, stopeval, varargin{:});

	% Set the algorithm parameters
	m = p.Results.m;
	rho = p.Results.rho;
	alpha = p.Results.alpha;
	beta = p.Results.beta;
	visualization = p.Results.visualization;

	% Obtain the map from the function handle
	map = feval(map_fct);

	% The number of cities
	l = length(map(:,1));

	% Compute a reference path using the nearest neighbor method
	[path_nn, C_nn] = nn_shortest_path_tsp(map);

	% Compute distance matrix
	dmat = -1 * ones(l,l);
	for i = 1:l
		dmat(i,:) = sqrt(sum((map(i * ones(l,1),:) - map).^2, 2));
	end

	% Initialize pheromones and heuristics
	pheromones = ones(l,l) * m ./ C_nn;
	heuristics = ones(l,l) ./ (1e-10 * eye(l) + dmat);
	heuristics(1:l+1:l*l) = 0;

	% Statistics administration
	evalcount = 0;
	fopt = Inf;
	stat.histf = zeros(1, stopeval);

	% Ant System Optimization Loop
	while evalcount < stopeval

		% Reset the ant paths
		path = NaN(m,l);

		% Pre-compute the startnodes of the ants
		startnode = ceil(rand(1,m) * l);

		% Pre-compute the product of the pheromones and heuristics (for efficiency)
		pheromones_heuristics_product = pheromones.^alpha .* heuristics.^beta;

		% Construct new paths for the ants
		for k = 1:m

			curnode = startnode(k);
			path(k,1) = curnode;

			% Maintain a private pheromones and heuristics matrix (update it w.r.t. the tabu-list)
			private_pheromones_heuristics_product = pheromones_heuristics_product;
			private_pheromones_heuristics_product(:,curnode) = 0;

			for j = 2:l

				% Compute the step probabilities
				current_node_attraction_scores = private_pheromones_heuristics_product(curnode,:);
				step_probabilities = current_node_attraction_scores ./ sum(current_node_attraction_scores);

				% Draw the next node proportional to the step probabilities
				cumsum_step_probabilities = cumsum(step_probabilities);
				r = rand() * cumsum_step_probabilities(l);
				curnode = 1;
				while (cumsum_step_probabilities(curnode) < r)
					curnode = curnode + 1;
				end
				path(k,j) = curnode;

				% Update the tabu-list: set the probabilities for this node to zero
				private_pheromones_heuristics_product(:,curnode) = 0;

			end

		end

		% Compute fitness
		for k = 1:m
			C(k) = tsp_evaluate_tour(map, path(k,:));

			% Statistics administration
			evalcount = evalcount + 1;
			stat.histf(evalcount) = fopt;

		end

		% Statistics administration
		[fopt, optindex] = min(C);
		popt = path(optindex, :);

		% Update pheromones
		new_pheromones = zeros(l,l);
		for k = 1:m
			for j = 1:l-1
				new_pheromones(path(k,j), path(k,j+1)) = new_pheromones(path(k,j), path(k,mod(j,l) + 1)) + (1 / C(k));
			end
		end
		pheromones = (1 - rho) * pheromones + new_pheromones;

		% Plot statistics
		if (visualization)
			clf

			subplot(2,2,1)
			plot(stat.histf(1:evalcount))
			hold on
			plot([1:evalcount], C_nn * ones(1,evalcount), '-.r')
			grid on
			hold off
			title('Tour length')

			subplot(2,2,2)
			plot_path(map, popt, [func2str(map_fct), '.png'])
			title('Currently optimal tour')

			subplot(2,2,3)
			image(256 * ((pheromones - min(min(pheromones))) / (max(max(pheromones)) - min(min(pheromones)))));
			title('Pheromone matrix')

			subplot(2,2,4)
			image(256 * ((heuristics - min(min(heuristics))) / (max(max(heuristics)) - min(min(heuristics)))));
			title('Heuristic desirability matrix')

			drawnow()

		end

	end

end
