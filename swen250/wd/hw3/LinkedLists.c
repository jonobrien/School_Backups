#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "LinkedLists.h"


void InitLinkedList(LinkedLists *ListPtr){

	/* Set NumElements to zero */
	ListPtr-> NumElements=0;

	/* Set FrontPtr to Null */
	ListPtr->FrontPtr=NULL;

	/* Set BackPtr to Null */
	ListPtr->BackPtr=NULL;

}

void AddToFrontOfLinkedList(LinkedLists *ListPtr, MyData *DataPtr){

	/* Create LinkedList Node */
	LinkedListNodes *node=(LinkedListNodes *)malloc(sizeof(LinkedListNodes));

	/* Set node payload pointer to DataPtr */
	node->Payload=DataPtr;



	/* Check to see if the Linked List is empty */
	if(ListPtr->NumElements==0){

		/* Set both front and back pointers to the new element */
		ListPtr->FrontPtr=node;
		ListPtr->BackPtr=node;

		/* Set the new elements next to Null */
		node->Next=NULL;

	}else{

		/* Get a temporary handle on the previous head */
		LinkedListNodes *TempNode=ListPtr->FrontPtr;

		/* Set the Front Pointer of the Linked List to the new element*/
		ListPtr->FrontPtr=node;

		/* Set new node's next to temp node */
		node->Next=TempNode;

		/* Set Temp Node's previous to new node */
		TempNode->Previous=node;

	}

	/* Set the node's previous to null */
	node->Previous=NULL;

	/* Increment the number of elements in the list */
	ListPtr->NumElements++;

}


void AddToBackOfLinkedList(LinkedLists *ListPtr, MyData *DataPtr){

	/* Create LinkedList Node */
	LinkedListNodes *node=(LinkedListNodes *)malloc(sizeof(LinkedListNodes));

	/* Set node payload pointer to DataPtr */
	node->Payload=DataPtr;

	if(ListPtr->NumElements==0){

		/* Set both the front and back list pointers to the new element */
		ListPtr->FrontPtr=node;
		ListPtr->BackPtr=node;

		/* Set the new elements next to null */
		node->Next=NULL;

	}else{

		/* Get a temporary pointer to the old back of list */
		LinkedListNodes *TempNode=ListPtr->BackPtr;

		/* Set back of list to new */
		ListPtr->BackPtr=node;

		/* Set temp's next to new node */
		TempNode->Next=node;

		/* Set new node's previous to temp */
		node->Previous=TempNode;

	}

	/* Set the back node's next to null */
	node->Next=NULL;

	/* Increment the number of elements in the linked list */
	ListPtr->NumElements++;

}



MyData *RemoveFromFrontOfLinkedList(LinkedLists *ListPtr){


	/* Declare pointer to linked list node */
	LinkedListNodes *NodePtr;

	/* Declare a pointer to list element to be returned */
	MyData *DataPtr;

	/* Assign pointer to node being removed */
	NodePtr=ListPtr->FrontPtr;

	/* Check to see if the Front of the list is nulll */
	if(NodePtr==NULL){

		/* No elements can be removed, return null */
		return NULL;

	}else{

		/* Assign dataptr to the data being removed and returned */
		DataPtr=NodePtr->Payload;

		/* Set the front pointer to the next element in the list */
		ListPtr->FrontPtr=NodePtr->Next;

		/* Check to see if the new front of the list is null */
		if(ListPtr->FrontPtr==NULL){
			/* Do nothing, cannot set attribute of NULL */

		}else{

			/* Detatch the node from being removed from the front of the list */
			ListPtr->FrontPtr->Previous=NULL;
		}

		/* Free the node previously at the front of the list */
		free(NodePtr);

		/* Decrement the number of elements in the list */
		ListPtr->NumElements--;

		printf("%s\n", DataPtr->word);

		/* Return pointer to the data */
		return DataPtr;

	}

	printf("Remove From Front Of List Ended!\n");
}

MyData *RemoveFromBackOfLinkedList(LinkedLists *ListPtr){

	printf("Remove From Back Of List Called!\n");

	/* Declare pointer to linked list node */
	LinkedListNodes *NodePtr;

	/* Declare a pointer to list element to be returned */
	MyData *DataPtr;

	/* Assign pointer to node being removed */
	NodePtr=ListPtr->BackPtr;

	/* Check to see if the Back of the list is null */
	if(NodePtr==NULL){

		/* No elements can be removed, return null */
		return NULL;

	}else{

		/* Assign dataptr to the data being removed and returned */
		DataPtr=NodePtr->Payload;

		/* Set the back pointer to the previous element in the list */
		ListPtr->BackPtr=NodePtr->Previous;

		/* Check to see if new back node is null */
		if(ListPtr->BackPtr==NULL){
			/* Do nothing, cannot set attribute of NULL */

		}else{

			/* Detatch the node from being removed from the back of the list */
			ListPtr->BackPtr->Next=NULL;
		}

		/* Free the node previously at the back of the list */
		free(NodePtr);

		/* Decrement the number of items in the list */
		ListPtr->NumElements--;

		/* Return pointer to data */
		return DataPtr;

	}

	printf("Remove From Back Of List Ended!\n");



}


void DestroyLinkedList(LinkedLists *ListPtr){

}


void SearchList(LinkedLists *ListPtr, char *searchWord){

	printf("\nSearching for word <%s> in the list....\n", searchWord);

	/* Allocate memory for node variable */
	LinkedListNodes *node=(LinkedListNodes *)malloc(sizeof(LinkedListNodes));

	/* Allocate memory for node payload */
	MyData *data=(MyData *)malloc(sizeof(MyData));

	/* Set node equal to the front of the list */
	node=ListPtr->FrontPtr;

	/* Variable set to 1 if there is a match */
	int matched=0;

	/* Move throught the list until the node is null */
	while(node!=NULL){

		/* Set data equal to the current node's payload */
		data=node->Payload;

		/* compare the current word with the word being searched for */
		if(strcmp(data->word, searchWord)==0){

			printf("Word <%s> found in position #%d of the list\n", searchWord, data->position);
			matched=1;
		}

		/* Advance the node to the next node in the list */
		node=node->Next;
	}

	/* Match was never found and match was never set to 1, alert user */
	if(matched==0){
		printf("Word <%s> not found in the list\n", searchWord);
	}
}

