function [] = plot_map(M, mapfile)
% [] = plot_map(M, mapfile)
%
% Plots a map with city coordinates.
%
% Input:
% - M              - A city map, which is a matrix of 2D city coordinates
% - mapfile        - Optional: An image file of the map
%
% Output:
%
% Author: Johannes W. Kruisselbrink
% Last modified: October 21, 2011

	if (nargin > 1 && exist(mapfile,'file'))
		A = imread(mapfile, 'png');
		image(A)
		axis off
		axis image
		max_x = max(get(gca, 'xlim'));
		max_y = max(get(gca, 'ylim'));
		x = 0 + max_x * ((M(:,2) - min(M(:,2))) / (max(M(:,2)) - min(M(:,2))));
		y = max_y - max_y * ((M(:,1) - min(M(:,1))) / (max(M(:,1)) - min(M(:,1))));
		hold on
	else
		x = max(M(:,2)) - M(:,2);
		y = max(M(:,1)) - M(:,1);
	end

	plot(x, y,'kd','MarkerFaceColor','b','MarkerSize',3);

end