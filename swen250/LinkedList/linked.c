
/* linked - linked list functions
*/

#include <stdio.h>
#include <stdlib.h>
#include "linked.h"
	

/************************************************************
 length - return length of a list
 ************************************************************/
int length() {
  int count = 0;	// number of nodes in the list
  struct node* walker = head;  // starting point to "walk" the list
  while( walker != NULL ){     // done when we reach the node pointing to NULL
     walker = walker->next;    // advance walker to the next node in the list
     count++;		       
     }
  return count;
}


/************************************************************
 push - add new node at beginning of list
 ************************************************************/
void push(int data) {
  struct node* newNode;  // newNode is a pointer to the node being added

  // allocate memory from the heap to hold one node
  newNode = (struct node*)malloc(sizeof(struct node));
  
  // initialize the new node's data value to int value passed in
  newNode->data = data;

  // initalize the new node's next link to point where head was pointing
  newNode->next = head;   // note that both are pointers to struct node

  // update the head of the list to point to the new node's address
  head = newNode;

}

/************************************************************
 pop - delete node at beginning of non-empty list and return its data
 ************************************************************/
int pop() {
  int val;
  struct node* next;

  if( head != NULL){   // don't pop an empty list!
    val = head->data;  // grab the value and next pointer from
    next = head->next; // first node before we deallocate it

    free( head );      // release memory for first node
    head = NULL; /*zero pointer to be safe */
    head = next;       // now have a new head node to point to
    }
  return(val);
}

/************************************************************
 appendNode - add new node at end of list
 ************************************************************/
void appendNode(int data) {
 
  struct node* walker;
  struct node* newNode;

  newNode = (struct node*)malloc(sizeof(struct node));
  newNode->data = data;
  newNode->next = NULL;

  if( head == NULL )
    head = newNode;
  else
    walker = head;
    while( walker->next != NULL )
       walker = walker->next;
    walker->next = newNode;
}

/************************************************************
 copyList - return new copy of list
 ************************************************************/
struct node* copyList(struct node* starter) {
    struct node* current = starter; /* current node in original list */
    struct node* newHead = NULL; /* head node for new list */
    struct node* newCurrent = NULL; /* current node in new list */
    
    while (current != NULL) {
        struct node* newNode; /* new node in list */
        newNode = malloc(sizeof(struct node));
        newNode->data = current->data; /* reassign data */
        newNode->next = NULL;
        
        if (newHead == NULL) {
            newHead = newNode;
            newCurrent = newHead;
        }
        else {
            newCurrent->next = newNode;
            newCurrent = newCurrent->next;
        }
        current = current->next;

    }
    return newHead;
}


/************************************************************
 printList - print linked list as "List: < 2, 5, 6 >" (example)
 ************************************************************/
void printList(struct node* start) {
  struct node* current;
 
  printf("List: < ");
  
  //current = head;       // starting point for walking the list
  current = start;
    while( current != NULL ){
     printf("%d ", current->data);
     current = current->next;
     }
  printf(" >\n");
}

