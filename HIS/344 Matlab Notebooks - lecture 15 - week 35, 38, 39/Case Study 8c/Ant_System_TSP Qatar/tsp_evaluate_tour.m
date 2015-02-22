function path_length = tsp_evaluate_tour(M, tour)
% path_length = tsp_evaluate_tour(M, tour)
%
% Given city coordinates M and a path p, this
% function computes the path length using euclidean
% distance.
%
% Input:
% - M              - A city map, which is a matrix of 2D city coordinates
% - tour           - A candidate tour
%
% Output:
% - path_length    - The length of the tour
%
% Author: Johannes W. Kruisselbrink
% Last modified: October 20, 2011

	% Check that tour is permutation of all cities
	num_cities = size(M,1);
	if (length(tour) ~= num_cities || sum(sort(tour) - [1:num_cities]) ~= 0)
		error('Supplied tour does not visit all cities or contains double visits!');
	end

	l = length(tour);
	path_length = 0;
	for i=1:l
		path_length = path_length + sqrt(sum((M(tour(i),:) - M(tour(mod(i,l) + 1),:)).^2));
	end
end
 