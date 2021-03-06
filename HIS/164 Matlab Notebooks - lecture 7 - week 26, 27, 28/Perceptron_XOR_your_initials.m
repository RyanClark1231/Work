% ==========================
% Filename: Perceptron_XOR.m
% ==========================
%
% Two witnesses that I (id 9999999) considered, ran and examined the output of the code.  
%   Demonstrated to Paul Raynor 27-01-14  
%   Demonstrated to A.N. Other (student id 9999999) 26-01-14 
%
%   My comments: 
%               As the exclusive-OR problem is not linearly seperable it
%               therefore cannot be solved by a single layer perceptron
%               using only two dimension this meatn that I had to change this program so
%               that it created a plane in 3D space so that the 0's and 1's
%               could be seperated
%
%               To do this I first had to add a Z-dimension to the input
%               vector, I calculated the values for this by multiplying the
%               X input vector by the Y input vector, I also had to add the
%               limits for the Z dimension to the graph.
%
%               I added another input to the perceptron by changing
%               net=newp([0 1; 0 1], 1) to net=newp([0 1; 0 1; 0 1], 1)
%               and also changed the w variable so that it would generate 3
%               input weights instead of just 2
%
%               I also changed the adaption from a predefined length for-loop
%               to a while loop that will terminate when there are no
%               longer any errors, these are converted to postitive
%               integers by squaring them (SSE)
%
%
echo on;
%
% ====================================================================
% The perceptron: an attempt to learn linearly non-separable functions
% ====================================================================

% ============================================================================
% Reference: Negnevitsky, M., "Artificial Intelligence: A Guide to Intelligent  
%            Systems", 3rd edn. Addison Wesley, Harlow, England, 2011.
%            Sec. 6.3 The perceptron
% ============================================================================

% ===========================================================================
% Problem: Two-input perceptron is required to perform logical operation XOR.
% ===========================================================================

% Hit any key to define four 2-element input vectors denoted by "p". 
pause 

p=[0 0 1 1; 0 1 0 1; 0 0 0 1]
%inputs are 00 01 10 11
% Hit any key to define four 1-element target vectors denoted by "t". 
pause 

t=[0 1 1 0]
% targets are  0 1 1 0 (XOR)

% Hit any key to plot the input and target vectors.
% V is the graph limits
v=[-2 3 -2 3 -2 3];

plotpv(p,t,v);

% Hit any key to create the perceptron and set its initial weights to random 
% numbers in the range [0, 1]. The perceptron's threshold is set to zero.
pause
%create a new perceptron (RxQ matrix of representative input vectors, SxQ matrix of representative target vectors)
net=newp([0 1;0 1; 0 1],1);
w=(rands(3))';

net.IW{1,1,1}=w;
net.b{1}=0;
%Plot input target vectors
plotpv(p,t,v);
%Plot line
linehandle=plotpc(net.IW{1},net.b{1});

% Hit any key to train the perceptron for one pass and plot the classification line. 
% The training will be stoped after 10 passes.
pause
E = 1;
while E > 0;
   
   [net,Y,E]=adapt(net,p,t);
   linehandle=plotpc(net.IW{1},net.b{1},linehandle);
   E = sum(E.^2)
   
end;

% Hit any key to see that the perceptron has not learned the XOR operation.
pause

p=[1;1;1]
a=sim(net,p)

% Hit any key to continue.
pause

p=[0;1;0]
a=sim(net,p)

% Hit any key to continue.
pause

p=[1;0;0]
a=sim(net,p)

% Hit any key to continue.
pause

p=[0;0;0]
a=sim(net,p)
   
echo off
disp('end of Perceptron_XOR')