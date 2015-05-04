/******************************************************************************
 * Header file for Linkes Lists, Version 1.1
 * Author: Juan C. Cockburn (9/21/2013, 2/26/2014)
 * Revised: your name and date
******************************************************************************/
#ifndef _LINKED_LISTS_H_
#define _LINKED_LISTS_H_

/******************************************************************************
 * The "MyData" structure below must be defined according to the
 * payload of your linked list.
******************************************************************************/
typedef struct MyData
  {
	int position;
	char *word;

  } MyData;

/**************  Nothing else in the module needs to be modified *************/

/******************************************************************************
 * Structure for doubly linked list nodes
 ******************************************************************************/
typedef struct LinkedListNodes
  {
   /* The user information field */
   MyData *Payload;
   /* Link pointers */
   struct LinkedListNodes *Next;
   struct LinkedListNodes *Previous;
  } LinkedListNodes;

/******************************************************************************
 * Structure for doubly linked list (keeps "state" of linked list)
 ******************************************************************************/
typedef struct LinkedLists
  {
   /* Current number of elements in the list */
   int NumElements;
   /* Pointer to the head of the list, possibly NULL */
   struct LinkedListNodes *FrontPtr;
   /* Pointer to the end of the list, possibly NULL */
   struct LinkedListNodes *BackPtr;
  } LinkedLists;

/******************************************************************************
* Initialize doubly linked list data structure
******************************************************************************/
void InitLinkedList(LinkedLists *ListPtr);

/******************************************************************************
* Add a node (e.g., data record) to the front of the list.
******************************************************************************/
void AddToFrontOfLinkedList(LinkedLists *ListPtr, MyData *DataPtr);

/******************************************************************************
* Add node (e.g., data record) to the back of the list.
******************************************************************************/
void AddToBackOfLinkedList(LinkedLists *ListPtr, MyData *DataPtr);

/******************************************************************************
* Remove node (and return) a record from the front of the list 
* must 'work' on an empty lists by returning NULL
******************************************************************************/
MyData *RemoveFromFrontOfLinkedList(LinkedLists *ListPtr);

/******************************************************************************
* Remove node (and return) a record from the back of the list 
 * must 'work' on an empty list by returning NULL
******************************************************************************/
MyData *RemoveFromBackOfLinkedList(LinkedLists *ListPtr);

/******************************************************************************
* De-allocate the linked list and reset the struct fields as if the
* list was empty.
******************************************************************************/
void DestroyLinkedList(LinkedLists *ListPtr);

/******************************************************************************
* Iterate through provided list and confirm / deny that word's existance
* in the doubly linked list
******************************************************************************/
void SearchList(LinkedLists *ListPtr, char *searchWord);


#endif /* _LINKED_LISTS_H_ */
