#include <stdio.h>
#include <stdlib.h>

#include "ODEsolvers.h"


void calc_input(double *input,double *xVals,double time){

	input[0]=(3.16 * xVals[0])+(51.90 * xVals[1])+(5.64 * xVals[2])+(10.88 * xVals[3]);

	if((time>=12.0)&&(time<=12.5)){
		input[1]=1.01;
	}else{
		input[1]=0;
	}

}




void eu(int neqn, double t0, double *x0, double *u0, double step, func4arg f){

	/* Declare derivative vector */
	double dx[4];

	/* Make call to derivativeSystem to solve for the deriv values */
	f(t0,x0,u0,dx);

	x0[0]=x0[0]+(step * dx[0]);
	x0[1]=x0[1]+(step * dx[1]);
	x0[2]=x0[2]+(step * dx[2]);
	x0[3]=x0[3]+(step * dx[3]);

}

void rk2(int neqn, double t0, double *x0, double *u0, double step, func4arg f){

	/* Declare derivative vectors */
	double dx[4];

	double tempx1[4],tempx2[4];

	int i;
	/* Make call to derivativeSystemt solve for deriv values */
	f(t0,x0,u0,dx);

	for(i=0;i<4;i++){
		tempx1[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx1,t0+step);
	f(t0+step,tempx1,u0,dx);

	for(i=0;i<4;i++){
		tempx2[i]=x0[i]+(step * dx[i]);
	}

	for(i=0;i<4;i++){
		double addition;
		addition=step * ((.5 * tempx1[i]) + (.5 * tempx2[i]));

		x0[i]=x0[i]+addition;

	}


}

void rk3(int neqn, double t0, double *x0, double *u0, double step, func4arg f){

	double dx[4],tempx1[4],tempx2[4],tempx3[4];

	int i;

	f(t0,x0,u0,dx);
	for(i=0;i<4;i++){
		tempx1[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx1,t0);
	f(t0,tempx1,u0,dx);

	for(i=0;i<4;i++){
		tempx2[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx2,t0);
	f(t0,tempx2,u0,dx);
	for(i=0;i<4;i++){
		tempx3[i]=x0[i]+(step * dx[i]);
	}

	for(i=0;i<4;i++){
		double addition;
		addition=step * ((.333333 * tempx1[i]) + (.333333 * tempx2[i]) + (.333333 * tempx3[i]));

		x0[i]=x0[i]+addition;
	}
}

void rk4(int neqn, double t0, double *x0, double *u0, double step, func4arg f){

	double dx[4],tempx1[4],tempx2[4],tempx3[4], tempx4[4];

	int i;

	f(t0,x0,u0,dx);
	for(i=0;i<4;i++){
		tempx1[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx1,t0);
	f(t0,tempx1,u0,dx);

	for(i=0;i<4;i++){
		tempx2[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx2,t0);
	f(t0,tempx2,u0,dx);
	for(i=0;i<4;i++){
		tempx3[i]=x0[i]+(step * dx[i]);
	}

	calc_input(u0,tempx3,t0);
	f(t0,tempx3,u0,dx);
	for(i=0;i<4;i++){
		tempx4[i]=x0[i]+(step * dx[i]);
	}

	for(i=0;i<4;i++){
		double addition;
		addition=step * ((.25 * tempx1[i]) + (.25* tempx2[i]) + (.25 * tempx3[i]) + (.25 * tempx4[i]));

		x0[i]=x0[i]+addition;
	}

}

