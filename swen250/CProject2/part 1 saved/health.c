



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
    int numReadings; /*the number of readings for this type*/
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

void main()
{
    printf("Welcome to the Health Monitoring System\n\n");
    int i, j;

    /* initialize health data records for each patient */
    for( i=0; i < MAXPATIENTS; i++ )
    {
        record[i].id = i + 1;
        for( j=0; j < MAXTYPES; j++ )
        {
            record[i].buffer[j].numReadings=0;
        }
    }
    j = 0;
    /* reads a line and places the values into their respective positions*/
    while (j == 0)
    {
    //if (getchar() == EOF) {
    //    break;
    //}
        int type;
        int value;
        char time[9];
        int iD;
        scanf("%d, %s %d, %d",&iD,&time,&type,&value);
        if (type != 6)
        {
            record[iD].buffer[type - 1].numReadings += 1;
            for(i = 0;i < 8; i++)
            {
                record[iD].buffer[type - 1].reading[(record[iD].buffer[type - 1].numReadings - 1)%MAXREADINGS].timestamp[i]=time[i];//assign time
            }
            record[iD].buffer[type - 1].reading[(record[iD].buffer[type - 1].numReadings - 1)%MAXREADINGS].value=value;//assign value
        }
        else
        {
        print(iD);
        //if (getchar() == EOF) {
        //    break;
        //}
        //print(patient);
        }
    if (getchar() == EOF) {
        //printf("End of input\n");
        //j = -1;
        break;//break out when EOF is sent from stdin
        }
    }
    printf("End of input\n");
}
/*Prints the readings for the current patient*/
void print(int iD)
{
    int i, j;
    printf("--------------------------------------------------\n");
    printf("Readings for Patient ID = %d are:\n",iD);
    for(i = 0;i < 5; i++)
    {//for every type
        if(i == 0)
        {
            printf("Temperature:\n");
        }
        if(i == 1)
        {
            printf("Heart Rate:\n");
        }
        if(i == 2)
        {
            printf("Systolic Pressure:\n");
        }
        if(i == 3)
        {
            printf("Diastolic Pressure:\n");
        }
        if(i == 4)
        {
            printf("Respiration Rate:\n");
        }
        if(record[iD].buffer[i].numReadings == 0)
        {
            printf("<none>\n");
        }
        else
        {
            if(i != 0)
            {
                if(record[iD].buffer[i].numReadings<MAXREADINGS)
                {
                    for(j = 0;j < record[iD].buffer[i].numReadings;j++)
                    {
                        printf("%s: %d\n",record[iD].buffer[i].reading[j].timestamp,record[iD].buffer[i].reading[j].value);
                    }
                }
                else
                {
                    for(j = 0;j < MAXREADINGS; j++)
                    {
                        printf("%s: %d\n",record[iD].buffer[i].reading[j].timestamp,record[iD].buffer[i].reading[j].value);
                    }
                }
            }
            else
            {
                if(record[iD].buffer[i].numReadings < MAXREADINGS)
                {
                    for(j = 0;j < record[iD].buffer[i].numReadings; j++)
                    {
                        printf("%s: %.1f\n",record[iD].buffer[i].reading[j].timestamp,record[iD].buffer[i].reading[j].value/10.0);
                    }
                }
                else
                {
                    for(j = 0;j < MAXREADINGS; j++)
                    {
                        printf("%s: %.1f\n",record[iD].buffer[i].reading[j].timestamp,record[iD].buffer[i].reading[j].value/10.0);
                    }
                }
            }
        }
    }
    printf("--------------------------------------------------\n");
}

