/**********************************************************************
 * Program used to take digital values and correct them so that they
 * fall within a tighter tolerance to the linear model achieved
 * when converting physical values to digital values.
 **********************************************************************/
#include <stdio.h>
#include <math.h>

/* Typemark for 16-bit Digital numbers */
typedef short int DigitalValues;

/* main program to correct the digital values produced by
 * the compiled device.
 */
int main(int argc, char *argv[]){


	DigitalValues DigitalValue=0;


	/* Scan in values from stdin */
	while(scanf("%hd", &DigitalValue) != EOF){

		fprintf(stdout,"Value: %hd\n", DigitalValue);

	}


	return 0;
}
/* End main method */
