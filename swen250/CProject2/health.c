#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "health.h"


#define MAXTYPES 5

/*
* Main function for the Health Monitoring System. Primarily responsible for
* processing input of csv lines and printing as required. Data structures are
* maintained using the helper functions in health_util.c
* 
*/
void checkInPatient();              /* function to check in a patient */
void checkOutPatient();             /* function to delete  a patient */
void resetpatient();                /* function to reset patient to null */
void printPatients(int patientID);  /* function to print everything */

Chartptr patientList = NULL;        /* Define global variable patientList (declared in health.h) */
								    /* patientList is globaaly accessible in health_util.c    */

int id = 0;
int value = 0;
int type = 0;
char timestamp[MAXTIME];
const char Break[52] = "--------------------------------------------------\n";
const char* HEALTH_DATA_TYPES[] = {"Temperature:", 
                                   "Heart Rate:", 
                                   "Systolic Pressure:",
                                   "Diastolic Pressure:", 
                                   "Respiration Rate:"} ;


void main(){

    printf("Welcome to the Health Monitoring System\n\n");

/*
*  (1) Read an input csv line from stdin 
*/

    while (scanf("%d, %[^,], %d, %d", &id, timestamp, &type, &value) != EOF) {
        //printf("%d, %s, %d, %d", iD, time, type, value);
        
        //printf("\ninside while loop.\n");
        if (type == 6) {
        //    printf("type 6\n");
            printPatients(id);
        }
        else if (type == 7) {
        //    printf("type 7\n");
            checkInPatient();
        }
        /*else if (type == 8) {         //level 7 material
        //    printf("type 8\n");
            checkOutPatient();
        }*/

        else if (type == 9) {
        //    printf("type 9\n");
            addHealthType(id, value);
        }
        /*else if (type == 0) {         //level 7 material
        //    printf("type 0\n");
            resetPatient();
            
        }*/

        else {
        //    printf("addHealthReading\n");
            addHealthReading(getHealthType(id, type), timestamp, value);
        }
    }
    printf("\nEnd of input\n");
    
/* (2) Parse csv line into appropriate fields*/
/*  (3) Take action based on input type:
*  		 - Check-in or check-out a patient with a given ID
*        - Add a new health data type for a given patient
*        - Store health data in patient record or print if requested
*  (4) Continue (1)-(3) until EOF
*/

}//end of main


void checkInPatient() {
    addPatient(id);
    printf("%s", Break);
    printf("%s: Patient ID = %d checking in\n", timestamp, id);
    printf("%s", Break);
}

void checkOutPatient() {
    printf("%s", Break);
    printf("%s: Patient ID = %d checking out\n", timestamp, id);
    printf("%s", Break);
    removePatient(id);
}

/*void resetPatient() {
    printf("%s", Break);
    printf("%s: Patient ID = %d reset data\n", timestamp, id);
    printf("%s", Break);
    removePatient(id);
}*/

void printPatients(int patientID) {
    // printf("patient id = %d\n",patientID);

Chartptr patientsChart;
    patientsChart = getChart(patientID);
    // printf("\ninside print\n");
    if (patientsChart != NULL) {
    // printf("\ninside first null if\n");
        int i, j;
        CBuffptr healthTypeBuffer;

        printf("%s", Break);
        printf("Readings for Patient ID = %d are:\n", patientID);

        // loops though each health data type and prints their readings
        for (i = 0; i < MAXTYPES; ++i) {
            printf("%s\n", HEALTH_DATA_TYPES[i]);
            healthTypeBuffer = getHealthType(patientID, i + 1);

            if (healthTypeBuffer == NULL) {
                printf("<none>\n");
            } 
            else {
                for (j = healthTypeBuffer->start; j != healthTypeBuffer->end; ++j) {
                    if (j == MAXREADINGS) {
                        j = 0;
                    }//brackets added
                    if (healthTypeBuffer->type == 1) {
                        printf("%s: %0.1f\n", healthTypeBuffer->reading[j].timestamp, 
                                           healthTypeBuffer->reading[j].value  / 10.0 );
                    } else {
                        printf("%s: %d\n", healthTypeBuffer->reading[j].timestamp, 
                                           healthTypeBuffer->reading[j].value);
                    }
                }
            }
        }
        printf("%s", Break);
    }//if commented
}/* end of file bracket */

