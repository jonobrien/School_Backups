#include <stdio.h>
#include <stdlib.h>
#include "health.h"


/*
* health_util.c - Helper functions for the Health Monitoring System
*
* Add any optional helper function declarations here, define 
* the functions after the required functions below.
*
* static void myOptionalFunc();   // EXAMPLE 
*
*/
void updateCircularBuffer(CBuffptr buffer);


/*
* addPatient: check-in a new patient
*   (1) allocate a new Chart for the patient
*   (2) initialize the chart with the passed patientID
*   (3) new patients are inserted at the start of the patient list
*
* (note that the variable patientList is globally accessible)
*/
void addPatient( int patientID ){
    
    Chartptr patientsChart;
    patientsChart = getChart(patientID);

    /* if ID not found, add new patient */
    if(patientsChart == NULL) {
        Chartptr newChart;
        
        /* allocate/initialize new patient data */
        newChart            = (Chartptr)malloc(sizeof(Chart));
        newChart->id        = patientID;
        newChart->buffer    = NULL;
    
        /* insert new patient info list */
        newChart->next      = patientList;
        patientList         = newChart;
    } 
  } //end of addPatient



/*
* addHealthType: add a new health type buffer for a given patient
*	(1) allocate a new CircularBuffer
*	(2) initialize the buffer
* 	(3) link it to the existing patient's Chart
*/
void addHealthType( int patientID, int newType ){    

    Chartptr patientsChart;
    CBuffptr typeBuffer;
    patientsChart = getChart(patientID);
    typeBuffer = getHealthType(patientID, newType);

    // if patient was found and type buffer wasn't found, add new type buffer
    if (patientsChart != NULL && typeBuffer == NULL) {
        CBuffptr newChart;

        // allocate and initialize new type buffer
        newChart        = (CBuffptr)malloc(sizeof(CircularBuffer));
        newChart->type  = newType;
        newChart->next  = NULL;
        newChart->start = 0;
        newChart->end   = 0;

        // insert new health type into patient chart
        newChart->next        = patientsChart->buffer;
        patientsChart->buffer = newChart;
    }
}//end of addHealthType


/*
*  getChart: given a patientID, return a pointer to their Chart
*/
Chartptr getChart( int patientID ){

    Chartptr foundChart = NULL; /* pointer to chart struct */
    foundChart = patientList;

    /* find the patient ID's chart */
    while(foundChart != NULL) {

        /* if the ID being searched for is found, return it */
        if (foundChart->id == patientID) {
            return foundChart;
        }
        /* continue to next patient ID */
        foundChart = foundChart -> next; 
    }
    return foundChart;
}//end of getChart


/* 
*  getHealthType: given a patientID & healthType, return a pointer 
*  to the CircularBuffer for that type. If the health type does NOT exist 
*  for that patient, return NULL
*/
CBuffptr getHealthType( int patientID, int healthType ){

    CBuffptr foundType = NULL;
    Chartptr patientsChart;
    patientsChart = getChart(patientID);

    if (patientsChart != NULL) {
        /* foundType is the buffer */
        foundType = patientsChart->buffer;
        while (foundType != NULL) {
         
            /* if the type being searched for is found, return it */
            if (foundType->type == healthType) {
                return foundType;
            }
            /* continue to the next type */
            foundType = foundType->next;
        }
    }
    return foundType;
}//end of getHealthType



/*
*  addHealthReading: given a pointer to CircularBuffer, add the passed
*  timestamp and health data type reading to the buffer
*/
void addHealthReading( CBuffptr buffer, char* timestamp, int reading ){
    if (buffer != NULL) {
        (*buffer).reading[buffer->end].value = reading;
        strncpy((*buffer).reading[buffer->end].timestamp, timestamp, MAXTIME);
        updateCircularBuffer(buffer);
    }
}//end of addHealthReading



/*
*  removePatient: check-out an existing patient
*	  (1) delete the patient's Chart & accompanying 
*         health data readings.
*     (2) update the list of current patients
*/
void removePatient( int patientID ){
    int i, count;
    Chartptr patientsChart;
    Chartptr previousChart;
    Chartptr currentChart;
    CBuffptr healthTypeBuffer;
    CBuffptr allHealthTypeBuffers[MAXREADINGS];
    //CBuffptr currentBuffer;
    //CBuffptr oldBuffer;
	// printf("Patient ID: %d\n",patientID);


    // if patient was found, remove the patient
    patientsChart = getChart(patientID);
    if (patientsChart != NULL) {
        healthTypeBuffer = patientsChart->buffer;

        if (healthTypeBuffer != NULL) {
            // gather all the heath type buffers
            count = 0;
            for (i = 0; i < MAXREADINGS && healthTypeBuffer != NULL; ++i) {
                allHealthTypeBuffers[i] = healthTypeBuffer;
                healthTypeBuffer = healthTypeBuffer->next;
                count++;
            }
            // free all the health type buffers
            for (i = 0; i < count; ++i) {
                free(allHealthTypeBuffers[i]);
                //allHealthTypeBuffers[i] = NULL;//make null for reset
                //doesn't work
            }
        }
        // find the chart before specified patient chart
        //currentChart = patientList;

	    // printf("Id of current chart: %d\n", currentChart->id);
	    // printf("ID of patient chart: %d\n", patientsChart->id);


        /*while (currentChart != NULL) {
		if (currentChart->id == patientsChart->id) {
		//free buffers
			currentBuffer=currentChart->buffer;
			while(currentBuffer!=NULL){
				oldBuffer=currentBuffer;
				currentBuffer=oldBuffer->next;
				//free(oldBuffer);
			}
			break;
		}
		else {
			currentChart = currentChart->next;
		}

        } */



   }//end patient null check
}//end of removePatient

 
/*
* Optional helper functions defined starting here:
* static void myOptionalFunc(){ }  // EXAMPLE
*/

/* updateCircularBuffer: updates the healthType buffer when there are more
    readings to add to the charts for a particular type/ID */
void updateCircularBuffer(CBuffptr buffer) {
    if (buffer->end == MAXREADINGS - 1 && buffer->start == 0) {
        buffer->start++;
        buffer->end = 0;
    } else if (buffer->start == MAXREADINGS - 1) {
        buffer->start = 0;
        buffer->end++;
    } else if (buffer->end < buffer->start) {
        buffer->start++;
        buffer->end++;
    } else {
        buffer->end++;
    }
}//end of updateCircularBuffer

