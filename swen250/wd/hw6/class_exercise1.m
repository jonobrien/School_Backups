%% Class Exercise 1: Least Squares Fitting with Matlab
 % Requires: data1.txt file contains data
 % Revised: JCCK 4/3/2014
 % Notes:   This code should also work in Octave
 
  close all
  clc

%% Load Data For Problem 1
    load -ascii data1.txt
    x=data1(:,1);  
    y=data1(:,2);
    n = length(x); % find #of data points
    
%% Plot data
    plot(x,y,'sq');
    title('Experimental Dataset #1')
       
%% Linear Fit
 % Form A and b
   A=[ones(n,1) x];
   b=y;
 % Solve
   x_ls=A\b;
 % polynomial 
   f=flipud(x_ls)'
   
%% Plot linear fit over current figure
  hold on
  plot(x,polyval(f,x),'-r')
  hold off
