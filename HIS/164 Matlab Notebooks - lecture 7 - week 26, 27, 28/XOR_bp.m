
% ==================
% Filename: XOR_bp.m
% ==================
%
%       This program solves XOR by using brack-propogation, by using this
%       it can source the errors in the results and adjust the relative
%       weights accordingly until there are no longer any errors. To do
%       this it will first calculate the outputs as with the previous
%       single-layer perceptron, from this you can calculate the weight
%       correction for the ouput-layer by using the error-gradient, you can
%       then use the weight correction to update the weights for the output
%       layer. This processes is repeated for the hidden layer also this
%       processes is then repeated until the error is sufficiently small,
%       in this program it is 0.001 or until the maximum number of epochs
%       have been reached.
%
%
rand('seed',8353);

echo on;

% ==========================
% Back-propagation algorithm
% ==========================

% ============================================================================
% Reference: Negnevitsky, M., "Artificial Intelligence: A Guide to Intelligent  
%            Systems", 3rd edn. Addison Wesley, Harlow, England, 2011.
%            Sec. 6.4 Multilayer neural networks
% ============================================================================

% =============================================================
% Problem: The three-layer back-propagation network is required  
%          to perform logical operation Exclusive-OR.
% =============================================================

% Hit any key to define four 2-element input vectors denoted by "p". 
pause 

p=[1 0 1 0;1 1 0 0]

% Hit any key to define four 1-element target vectors denoted by "t". 
pause

t=[0 1 1 0]

% Hit any key to plot the input and target vectors
pause

figure
plotpv(p,t);
hold on;

% Hit any key to define the network architecture.
pause 

s1=2; %Two neurons in the hidden layer
s2=1; %One neuron in the output layer

% Hit any key to create the network and initialise its weights and biases.
pause 

net = newff(p,t,s1,{'tansig','purelin'},'traingd');
net.divideFcn = '';

% Hit any key to set up the frequency of the training progress to be displayed, 
% maximum number of epochs, acceptable error, and learning rate. 
pause

net.trainParam.show=1;      % Number of epochs between showing the progress
net.trainParam.epochs=1000; % Maximum number of epochs
net.trainParam.goal=0.001;  % Performance goal
net.trainParam.lr=0.1;      % Learning rate

% Hit any key to train the back-propagation network. 
pause 

[net,tr]=train(net,p,t);

% Hit any key to see whether the network has learned the XOR operation.
pause 

p
t
a=sim(net,p)

echo off
disp('end of XOR_bp')