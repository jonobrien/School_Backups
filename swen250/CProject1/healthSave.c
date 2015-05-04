/*
* Health Monitoring System
*/

#include <stdio.h>
#include <ctype.h>
#define MAXPATIENTS 5   //max number of patients
#define MAXREADINGS 10  //max number of lines (circular buffer)
#define MAXTYPES 5      //max number of input types
#define MAXTIME 8       //clock values

/* One health type reading: timestamp + actual value */
typedef struct{
	char timestamp[MAXTIME+1];
	int value;
}Element;

/* Circular buffer of health type readings */
typedef struct{
	int start;	/* index of oldest reading */
	int end;	/* index of most current reading */
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

    /* initialize health data records for each patient */
    for( i=0; i < MAXPATIENTS; i++ ){
        record[i].id = i + 1;
        for( j=0; j < MAXTYPES; j++ ){
            record[i].buffer[j].start = 0;
	        record[i].buffer[j].end = 0;
        }
    }

    printf("Welcome to the Health Monitoring System\n\n");

    int idx = 0;
    int nchar = getchar();
    int location = 0;
    int r = 0;
    char csv_line[MAXREADINGS];//array of field of the csv line
    for (idx; idx < MAXTYPES; idx ++) {
        while (nchar != EOF) {
            csv_line[location] = nchar;
            nchar = getchar();
            location++;
        }
        csv_line[location] = '\0';//the fields are now separated by nulls in the array
    }
//    printf("outside the for loop for making fields, now onto assigning values");
    
    //for loop to assign id numbers to record Chart
    int it = 0;
    
    printf("\ncsv_line: %s\n", csv_line);
    printf("type character %d", csv_line[17]);
    printf("\ncsv_line[16] %d\n", csv_line[16]);
    printf("\nrecord[1]...value %d\n", record[1].buffer[1].reading[1].value);


    for(it; it < MAXPATIENTS; it++) {
        //record[csv_line[0]].buffer[csv_line[0]].reading[csv_line[0]].value = csv_line[17];//1 is a null
        //printf("%d", record[csv_line[0]].buffer[csv_line[0]].reading[csv_line[0]].value);

        r = record[1].buffer[1].reading[1].value;
        r = csv_line[0];
       printf("%d\n",  r);
    }
//printf("%d", r);

    printf("assign fields to variables for use in the struct");
    char next;
    int index = 0;
    int tsi = 0;
    int id = csv_line[0];
    //check to ensure it gets the correct field in csv_line
    while ((next = getchar()) != ',' || '\n') {
        record[id].buffer[id].reading[id].timestamp[tsi] = next;
        tsi++;
        next = getchar();
        index++;
    }
    //type casts for 3rd field in csv


/*
*  YOUR CODE GOES HERE:
*  (1) Read a csv line of health data from stdin 
*  (2) Parse csv line into appropriate fields
*  (3) Store health data in patient record or print if requested
*  (4) Continue (1)-(3) until EOF
*/


/* A new struct to hold all of the values from the csv file */
//typedef struct {
//   int iD;
//    char *time[MAXTIME + 1];
//    int value;
//    int type;
//}csv_input;
//
/* Declare an instance of the struct, and assign pointers for its values */
//csv_input aLine;
//    int *idptr;
//    char timeval[MAXTIME + 1];
//    int *valueptr;
//    int *typeptr;
//
/*Note: because the time char is already a pointer, I did not make another
 one for it but instead dereferenced the pointer I was given */
//idptr = &aLine.iD;
//int jx = 0; /* iterator variable */
//for( jx ; jx < MAXTIME; jx++) {
//    *aLine.time[jx] = &timeval[jx];//set dereferenced pointer to address at index jx
//}
//
//valueptr = &aLine.value;
//typeptr = &aLine.type;
//
/* Get the Patient ID */
//*idptr = getchar();
//
//printf("%c", aLine.iD); /* a test to see if my pointers worked and the correct value was read */
//
/*Skip the first comma */
//int next;                          //do I need to go back and get the first part of the csv line?
//next = getchar();
//

/* get the timestamp */            //do I need to do this for every aspect of the csv line?
//int ix = 0;
//for( ix ; ix < MAXTIME; ix++) {
//    while ((next = getchar()) != ',') {
//        timeval[ix] = next;
  //      printf("%s", aLine.time[i]); /* print the time info for the initialized struct instance */
//     }
//}


printf("\nEnd of Input\n");

}

