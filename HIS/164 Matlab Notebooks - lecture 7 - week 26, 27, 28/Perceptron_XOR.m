% ==========================
% Filename: Perceptron_XOR.m
% ==========================
%
%       This program demonstrates that you cannot seperate the XOR into 
%       two definitive regions in two dimensions using a single layer
%       perceptron and therefore is not linearlly seperable, to be able to
%       solve this problem you would have to add another dimension which
%       allow you to draw a plane between the two regions concerned.
%
%
echo on;
%
%
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

p=[0 0 1 1; 0 1 0 1]
%inputs are 00 01 10 11
% Hit any key to define four 1-element target vectors denoted by "t". 
pause 

t=[0 1 1 0]
% targets are  0 1 1 0 (XOR)

% Hit any key to plot the input and target vectors.
% V is the graph limits
v=[-2 3 -2 3];

plotpv(p,t,v);

% Hit any key to create the perceptron and set its initial weights to random 
% numbers in the range [0, 1]. The perceptron's threshold is set to zero.
pause
%create a new perceptron (RxQ matrix of representative input vectors, SxQ matrix of representative target vectors)
net=newp([0 1;0 1],1);
w=(rands(2))';

net.IW{1,1}=w;
net.b{1}=0;
%Plot input target vectors
plotpv(p,t,v);
%Plot line
linehandle=plotpc(net.IW{1},net.b{1});

% Hit any key to train the perceptron for one pass and plot the classification line. 
% The training will be stoped after 10 passes.
pause

for i=1:10;
   
   [net,Y,E]=adapt(net,p,t);
   linehandle=plotpc(net.IW{1},net.b{1},linehandle);
  
end;

% Hit any key to see that the perceptron has not learned the XOR operation.
pause

p=[1;1]
a=sim(net,p)

% Hit any key to continue.
pause

p=[0;1]
a=sim(net,p)

% Hit any key to continue.
pause

p=[1;0]
a=sim(net,p)

% Hit any key to continue.
pause

p=[0;0]
a=sim(net,p)
   
echo off
disp('end of Perceptron_XOR')