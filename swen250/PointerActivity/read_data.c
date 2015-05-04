/*
 * Implementation of the read_data module.
 *
 * See read_data.h for a description of the read_data function's
 * specification.
 *
 * Note that the parameter declarations in this module must be
 * compatible with those in the read_data.h header file.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "read_data.h"

#define MAXINPUT (25) //max number of characters

void read_data( char *C, int *I, double *D ) {
	int i =0; //index for array being input
    int c = 0; //index for temp array
    int nchar; //next character
    char delimiter = '$'; //separates input values
    char input[MAXINPUT + 1]; //input array
    char temp1[MAXINPUT + 1]; //temporary array for conversions
    char temp2[MAXINPUT + 1]; //second temporary array for conversions
    
    while ((nchar = getchar()) != EOF) {
        input[i] = nchar;
        i++;
    }


    //check if first character input is followed by delimiter
    i = 1;
    if(input[i] == delimiter) {
        //store the first character
        *C = input[i - 1];
        i++;
    }

    //loop through input array and find delimiter
    while(input[i] != delimiter) {
        temp1[c] = input[i];
        i++;
        c++;
    }
    *I = atoi(temp1);//integer is found
    i++;
    c = 0;
    
    //loop through input array and find delimiter
    while(input[i] != delimiter) {
        temp2[c] = input[i];
        i++;
        c++;
    }
    *D = atof(temp2);//double has been found

	
}
