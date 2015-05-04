#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "InvPend.h"


void derivativeSystem(double t, double *x, double *u, double *dx){

	dx[0]=x[2];
	dx[1]=x[3];

	x3derivative(t,x,u,dx);

	x4derivative(t,x,u,dx);

}


void x3derivative(double t, double *x, double *u, double *dx){

	/* calculate seperate a,b,c,d terms. Add divide a,b,c sum by d */
	double a,b,c,d;

	a= GC * MP * sin(x[1]) * cos(x[1]);
	b= LP * MP * x[3] * x[3] * sin(x[1]);
	c= (1/LP) * cos(x[1]) * u[1];
	d= MP * cos(x[1]) * cos(x[1]) - (MP + MC);

	dx[2]=(a-b-u[0]+c)/d;

}

void x4derivative(double t, double *x, double *u, double *dx){

	/* Calculate seperate a,b,c,d, and e terms */
	double a,b,c,d,e;

	a= -GC * (MP + MC) * sin(x[1]);
	b= LP * MP * x[3] * x[3] * sin(x[1]) * cos(x[1]);
	c= cos(x[1]) * u[0];
	d= ((MP + MC)/(LP * MP)) * u[1];
	e= LP * MP * cos(x[1]) * cos(x[1]) - (MP + MC);

	dx[3]=(a+b+c+d)/e;
}

