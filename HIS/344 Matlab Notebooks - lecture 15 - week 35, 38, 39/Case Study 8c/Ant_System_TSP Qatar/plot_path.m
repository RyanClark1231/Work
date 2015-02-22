function [] = plot_path(M, p, mapfile)
% [] = plot_path(M, p, mapfile)
%
% Plots a map with city coordinates.
%
% Input:
% - M              - A city map, which is a matrix of 2D city coordinates
% - p              - A path, being a sequence of city-indexes in order of traversal
% - mapfile        - Optional: An image file of the map
%
% Output:
%
% Author: Johannes W. Kruisselbrink
% Last modified: November 6, 2009

	if (nargin > 2 && exist(mapfile,'file'))
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

	plot(x, y,'kd','MarkerFaceColor','b','MarkerSize',3)
	hold on
	plot([x(p); x(p(1))],[y(p); y(p(1))],'r-');
	hold off

end
