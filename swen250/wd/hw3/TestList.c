#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "LinkedLists.h"


int main(int argc, char *argv[]){

	/* Check to make sure there are no additional cmdline args */
	if(argc==2){

		/* Declare FILE variable */
		FILE* inputFile;

		/* Attempt to open file provided in commange line arg */
		inputFile=fopen(argv[1],"r");

		/* Check to make sure file was opened properly */
		if(inputFile==NULL){

			/* Send message to stderr, and return 2 to OS */
			fprintf(stderr,"File cannot be opened\n");
			return 2;

		}else{
			/* File was opened properly, perform calculations */

			printf("\nGenerating List...\n");

			/* Declare a looping variable */
			int looper=0;

			/* Declare int to keep track of location in file */
			int position=0;

			/* Declare LinkedLists variable */
			LinkedLists list;

			/* Initialize Doubly Linked List with associated */
			InitLinkedList(&list);

			/* Declare variable to determine to continue scanning */
			int continueScan =1;

			while(continueScan==1){

				/* declare char array */
				char newWord[99];

				/* scan, assign, and check for newWord */
				if(fscanf(inputFile, "%s", newWord)==1){

					/* Allocate memory for data node */
					MyData *data=(MyData *)malloc(sizeof(MyData));

					/* Allocate memory inside data node for string */
					data->word=(char *)malloc(99);

					/* Copy scanned word into space in data node */
					strcpy(data->word, newWord);

					/* Set position of data node */
					data->position=position;

					/* Add node to back of list */
					AddToBackOfLinkedList(&list, data);

					/* Increment position */
					position++;

				}else{
					/* Scan was not successful, done reading from file */

					continueScan=0;
				}

			}
			/* end scanning */

			/* The number of nodes in the list is <position> + 1 */
			printf("There are %d words in the input file\n",(position+1));

			printf("List Generated!\n");

			/* Declare a pointer to LinkedListNode */
			LinkedListNodes *node=(LinkedListNodes *)malloc(sizeof(LinkedListNodes));

			/* Declare a pointer to MyData */
			MyData *dataElement=(MyData *)malloc(sizeof(MyData));

			/* set node equal to front of list */
			node=list.FrontPtr;

			printf("\nDisplaying Contents Of First Four List Nodes!\n\n");

			for(looper=0;looper<4;looper++){

				/* Set dataElement equal to the data we are storing in this node */
				dataElement=node->Payload;

				printf("%s is at position %d in the list.\n",dataElement->word, dataElement->position);

				/* Move to the next node */
				node=node->Next;

			}

			/* Set LinkedList Node equal to back of list */
			node=list.BackPtr;

			printf("\nDisplaying Contents of Last Four List Nodes!\n\n");

			for(looper=0;looper<4;looper++){

				/* Set dataElement equal to the data we are storing in this node */
				dataElement=node->Payload;

				printf("%s is at position %d in the list.\n", dataElement->word, dataElement->position);

				/* Move to the previous node */
				node=node->Previous;

			}

		}/* End check for successful opening of file */

	}else{

		/* Send message to stderr, and return 1 to OS */
		fprintf(stderr,"\nUsage: %s <TextFile>.txt\n\n", argv[0]);
		return 1;

	}
	/* End check for correct # of cmdline args */

	/* Program completed successfully, return 0 to OS */
	return 0;

}

