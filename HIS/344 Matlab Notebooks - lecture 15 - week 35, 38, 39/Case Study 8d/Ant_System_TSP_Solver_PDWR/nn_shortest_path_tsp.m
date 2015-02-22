function [nn_path, path_length] = nn_shortest_path_tsp(M)
% [nn_path, path_length] = nn_shortest_path_tsp(M)
%
% Applies the nearest neighbor method to compute an efficient
% path for the TSP problem with the city coordinates M.
%
% Input:
% - M              - A city map, which is a matrix of 2D city coordinates
%
% Output:
% - nn_path        - A vector containing the optimal path
% - path_length    - The length of the optimal path
%
% Author: Johannes W. Kruisselbrink
% Last modified: November 6, 2009

	% The number of cities
	l = length(M(:,1));

	% Compute distance matrix
	dmat = -1 * ones(l,l);
	for k = 1:l
		dmat(k,:) = sqrt(sum((M(k * ones(l,1),:) - M).^2, 2));
	end

	% Initialize tabu list and path
	tabu_list = ones(1,l);
	nn_path = zeros(1,l);

	% Perform nearest neighbor path finding loop
	current_node = 1;
	nn_path(1) = current_node;
	tabu_list(current_node) = inf;
	for j = 2:l
		[nearest, nearest_index] = min(tabu_list .* dmat(current_node, :));
		next_node = nearest_index;
		current_node = next_node;
		nn_path(j) = current_node;
		tabu_list(current_node) = inf;
	end

	% Compute path length
	path_length = tsp_evaluate_tour(M, nn_path);

end