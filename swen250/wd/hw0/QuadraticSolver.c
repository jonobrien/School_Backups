/*********************************************************************/
/* Josh Woodward                                                     */
/* jdw6359@rit.edu                                                   */
/* Applied Programming CMPE-380                                      */
/* Spring 2151?                                                      */
/*                                                                   */
/* Homework Zero                                                     */
/*                                                                   */
/* Program to find the roots of a quadratic equation of the form     */
/*  a2 x^2 + a1 x + a0 = =                                           */
/* Input: The coefficients of the quadratic (from the command line)  */
/*        coefficients must be in order; a2, a1, and then a0.        */
/* Output: The equation and provides its roots ( real or complex)    */
/*********************************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* Simple macros to define indeces of quadratic coeffieiencs - kind of obscure  */
#define A2 (2)
#define A1 (1)
#define A0 (0)

int main (int argc, char *argv[]){
	/* Text string indicating the version of the program */
	char *Version="v0.1_2014";

	/* Loop index variable */
	int Index;

	/* Return code for OS */
	int RC=0;

	/* Coefficients of polynomial: values from the command line */
	/* Polynomial=A2 x^2 + A1 x + A0 where */
	/* A2 =Coeff[2], A1=Coeff[1], and A0=Coeff[0] */
	float Coefficient[3];

	/* Discriminant of the equation: indicates real or complex roots */
	float Discriminant;

	/* Real roots of equation */
	float Root_1, Root_2;

	/* Complex roots of the equation */
	float Real, Imaginary;

	/* Print title and version of program */
	printf("Quadratic Equation Solver, %s\n", Version);

	/* Check for enough command line arguments */
	if(argc >=4){
		for(Index=2;Index>=0;Index--){
			Coefficient[Index]=atof(argv[3-Index]);
		}/* end for index */
 
		/* Show user equation to be solved (for verification) */
		printf("Equation to be solved: %f * x^2 + %f * x + %f = 0\n",
		Coefficient[A2], Coefficient[A1], Coefficient[A0]);

		/* Calculate Discriminant */
		Discriminant=Coefficient[A1]*Coefficient[A1]
				-4.0 * Coefficient[A2] * Coefficient[A0];


		/* Check for real or complex roots */
		if(Discriminant < 0.0){
			/* Complex Roots */
			Real=-Coefficient[A1] / (2.0 * Coefficient[A2]);
			Imaginary=sqrt(-Discriminant)/(2.0 * Coefficient[A2]);

			/* Print Complex Results */
			printf("The quadratic has complex roots: %f +/ j%f\n",
				Real, Imaginary);
		}else{
			/* Real Roots */
			Root_1=(sqrt(Discriminant) - Coefficient[A1])
				/ (2.0 * Coefficient[A2]);
			Root_2=(-sqrt(Discriminant) - Coefficient[A1])
				/ (2.0 * Coefficient[A2]);

			/* Print Real Roots */
			printf ("The quadratic has real roots: %f and %f\n",
				Root_1, Root_2);

		} /* end discriminant check */


	}else{
		/* too few command line arguments */
		printf("Usage: QuadraticSolver a b c\n");

		/* Invocation Error: return -1 to OS */
		RC=-1;

	} /* end argc check */

	return (RC);

}/* end main() */
