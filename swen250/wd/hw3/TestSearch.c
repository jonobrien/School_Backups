#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "LinkedLists.h"

#define WORDSTOSEARCH (4)


int main(int argc, char *argv[]){

	/* Check to make ure there are no additional cmdline args */
	if(argc==3){

		/* Declare FILE variable for the words to store in the list */
		FILE* inputFile;

		/* Declare FILE variable for the words to search for */
		FILE* searchFile;

		/* Attempt to open files provided in command line args */
		inputFile=fopen(argv[1],"r");
		searchFile=fopen(argv[2],"r");

		/* Check to make sure both files were opened properly */
		if((inputFile==NULL)||(searchFile==NULL)){

			/* Send message to stderr, and return 2 to OS */
			fprintf(stderr,"One of the files cannot be opend\n");
			return 2;

		}else{
			/* File was opened properly, perform calculations */

			printf("Generating List...\n");

			/* Declare a looping variable to iterate through file */
			int looper;

			/* Declare int to keep track of location in file */
			int position=0;

			/* Declare LinkedLists variable */
			LinkedLists list;

			/* Initialize Doubly Linked List */
			InitLinkedList(&list);

			/* Declare variable to determine continuing of scanning */
			int continueScan=1;

			while(continueScan==1){

				/* declare new char array */
				char newWord[99];

				/* scan, assign, and check for newWord */
				if(fscanf(inputFile, "%s", newWord)==1){

					/* Allocate memory for data node */
					MyData *data=(MyData *)malloc(sizeof(MyData));

					/* Allocate memory inside data node for word */
					data->word=(char *)malloc(99);

					/* Copy scanned word into space in data node */
					strcpy(data->word, newWord);

					/* Set position of data node */
					data->position=position;

					/* Add node ot back of list */
					AddToBackOfLinkedList(&list,data);

					/* Increment position */
					position++;

				}else{
					/* Scan was not successful, done reading */
					continueScan=0;

				}


			}
			/* End scanning */

			printf("List Generated!\n");


			char searchWord[99];

			for(looper=0;looper<WORDSTOSEARCH;looper++){

				fscanf(searchFile, "%s", searchWord);

				SearchList(&list, searchWord);

			}


		}
		/* End check for file unable to be opened */



	}else{

		/* Send message to stderr, and return 1 to OS */
		fprintf(stderr, "\nUsage: %s american-english-words.txt <WordsToSearchFor>.txt\n\n", argv[0]);	


	}
	/* End check for proper # of cmdline args */

	/* Program completed successfully, return 0 to OS */
	return 0;

}
/* end main method */
