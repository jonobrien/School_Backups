/*
* Health Monitoring System
*/

#include <stdio.h>
#include <ctype.h>

#define MAXPATIENTS 5
#define MAXREADINGS 10
#define MAXTYPES 5
#define MAXTIME 8

/* One health type reading: timestamp + actual value */
typedef struct{
	char timestamp[MAXTIME+1];
	int value;
}Element;

/* Circular buffer of health type readings */
typedef struct{
	//int start;	/* index of oldest reading */
	//int end;	/* index of most current reading */

	int numReadings;/*the number of readings for the type*/
    Element reading[MAXREADINGS];
}CircularBuffer;

/* Patient's health chart: ID + multiple health type readings */
typedef struct{
	int id;
	CircularBuffer buffer[MAXTYPES];
}Chart;


/*
* Health records for all patients defined here.
* The variable record is visible to all functions
* in this file, i.e. it is global.
*/
Chart record[MAXPATIENTS];	

void main(){
int i, j;
printf("Welcome to the Health Monitoring System\n\n");

/* initialize health data records for each patient */

for( i = 0; i < MAXPATIENTS; i++ ){
    record[i].id = i + 1;
    for( j = 0; j < MAXTYPES; j++ ){
        record[i].buffer[j].numReadings = 0;
	    //record[i].buffer[j].end = 0;
        }
    }
j = 0;
/* local variables for passing to print or to addToChart later */
while (j == 0) {
    if (getchar() == EOF) {
        break;
    }
    
    int iD;
    char time[MAXTIME + 1];
    int type;
    int value;

    //takes input from stdin, assigns values locally
    scanf("%d %s %d %d", &iD, &time, &type, &value);

    if (type != 6) {
        record[iD].buffer[type-1].numReadings += 1;//increment reading totals
    
        for (i = 0; i < MAXPATIENTS; i++) {
            record[iD].buffer[type-1].reading[(record[iD].buffer[type-1].numReadings-1)%MAXREADINGS].timestamp[i]=time[i];//reassign values for time
    }
    record[iD].buffer[type-1].reading[(record[iD].buffer[type-1].numReadings-1)%MAXREADINGS].value = value;//reassign value for value
    
    }
    else {//type is 6, therefore print
        print(iD);
    }
}//while loop

//if(getchar() == EOF){
//    printf("\nEnd of Input\n");
//    break;
//}

printf("\nEnd of Input\n");




}//main

//prints readings for the current patient
void print(int iD) {
    int ix, jx;
    printf("--------------------------------------------------\n");
    printf("Readings for Patient ID = %d are:\n",iD);
    for(ix = 0;ix < 5; ix++) {
        if(ix == 0) {
            printf("Temperature:\n");
        }
        if(ix == 1) {
            printf("Heart Rate:\n");
        }
        if(ix == 2) {
            printf("Systolic Pressure:\n");
        }
        if(ix == 3) {
            printf("Diastolic Pressure:\n");
        }
        if(ix == 4) {
            printf("Respiration Rate:\n");
        }
        if(record[iD].buffer[ix].numReadings == 0) {
            printf("<none>\n");
        }
        else {
            if(ix != 0) {
                if(record[iD].buffer[ix].numReadings < MAXREADINGS) {
                    for(jx = 0;jx < record[iD].buffer[ix].numReadings; jx++) {
                        printf("%s: %d\n",record[iD].buffer[ix].reading[jx].timestamp,record[iD].buffer[ix].reading[jx].value);
                    }
                }
                else {
                    for(jx = 0;jx < MAXREADINGS; jx++) {
                        printf("%s: %d\n",record[iD].buffer[ix].reading[jx].timestamp,record[iD].buffer[ix].reading[jx].value);
                    }
                }
            }
            else {
                if(record[iD].buffer[ix].numReadings < MAXREADINGS) {
                    for(jx = 0;jx < record[iD].buffer[ix].numReadings; jx++) {
                        printf("%s: %.1f\n",record[iD].buffer[ix].reading[jx].timestamp,record[iD].buffer[ix].reading[jx].value/10.0);
                    }
                }
                else {
                    for(jx = 0;jx < MAXREADINGS; jx++) {
                        printf("%s: %.1f\n",record[iD].buffer[ix].reading[jx].timestamp,record[iD].buffer[ix].reading[jx].value/10.0);
                    }
                }
            }
        }
    }
    printf("--------------------------------------------------\n");
}//print





///take input from stdin, delimited by commas, assign locally
//printf("id :%d:\n time :%s:\n type :%d:\n value :%d:\n", iD,time,type,value);
// the : and \n are for testing


/*
//int next =4; 
int next = getchar();
iD = (next - 48);
printf("iD should be good now, 5,4,3,2,1:   %d\n", iD);
while ((next = getchar()) != ',') {
    time[ix] = next;//fill the time array with data between commas
    ix++;
}
time[ix] = '\0';
printf("time should match second field %s\n",time);

next = getchar();//now move down the line for type field
while ((next = getchar()) != ',') {
    if (next == 32) {
        next = getchar();//skip spaces
        type = next;
    }
}  */
//printf("hopefully an integer for type working here, a 9:  %d\n", type);

/* fscanf(int, string, int, double);
would give be the formatting i need to stop this getchar() 
%d int 
%s 
%lf double

fscanf(stdin, "%g, %g", &a, &b)

*/


/*
*  YOUR CODE GOES HERE:
*  (1) Read a csv line of health data from stdin 
*  (2) Parse csv line into appropriate fields
*  (3) Store health data in patient record or print if requested
*  (4) Continue (1)-(3) until EOF
*/

	


//printf("\nEnd of Input\n");

//}



