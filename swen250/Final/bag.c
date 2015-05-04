#include "bag.h"
#include <stdio.h>

struct node *first = NULL ;		/* initially the list is empty */


/* make_node
 * 
 * Creates a new node: with (a COPY of) a string, a count of 1, and NULL next 
 * link.
 *
 * Hint: strlen returns the length of a string, which is helpful for calculating
 * how much memory to allocate for the strig copy
 */

struct node *make_node(char *value) {
	struct node *np  = (struct node*)malloc(sizeof(struct node));
    np->value = (char*)malloc(strlen(value)+1);
    strncpy( np->value, value, strlen(value)+1);
    np->count = 1;
    np->next = NULL;
	return np ;
}

/* insert_value
 * 
 * Traverse the linked list looking for a node matching the provided
 * string. We stop when (a) we find a matching string or (b) we hit the
 * end of the list. 
 *
 * Case (a) increments the node count and returns.
 * Case (b) insert a new node with count 1, via calling make_node
 *
 * Hint: strcmp(a,b) == 0 when strings a and b are equal
 */

void insert_value(char *value) {
    struct node *current;
    current = first;
    int found = 0;
    /* while still traversing the list */
    while (current != NULL) {
        /* if the strings are equal, increment count */
        if (strcmp(current->value, value) == 0) {
            current->count++;
            /* you found the value in the list */
            found = 1;
        }
        /*move to the next node */
        current = current->next;
    }
    /*otherwise the strings are different, make a new node at front */
    if (found == 0) {
        struct node* new = make_node(value);
        new->next = first;
        first = new;
     }

}
//**********************************
//broken
//**********************************

        //else {
            //make_node(value);
         
        /*   struct node *new  = (struct node*)malloc(sizeof(struct node));
            new->value = (char*)malloc(strlen(value)+1);
            strncpy( new->value, value, strlen(value)+1);
            new->next = first;
            new->count = 1;
            //new->value = *value; 
    */
    
   //     }//else end

//******************************



/* total_count
 *
 * Traverse the linked list totaling the number of items.
 *
 * Case (a) returns the total count of all items in the bag
 * Case (b) return 0 if the list is empty
 */


unsigned int total_count() {
	int count = 0;
    /* make a traversal node pointer and assign to front of list */
    struct node *current;
    current = first;
    /* if list empty, return 0 */
    if(current == NULL) {
        return 0;
    }
    else {
        while(current != NULL) {
            count += current->count;
            current = current->next;
        }

        /* move to next node */
       // current = current->next;
    }
	return count;
}

/* remove_value
 * 
 * Traverse the nexted list looking for a node matching the provided
 * string. We stop when (a) we find a matching string or (b) we hit the
 * end of the list 
 *
 * Case (a) decrements the node count (no lower than 0);
 * Case (b) simply returns.
 *
 * Note that when the count reaches 0 the node is NOT removed from the list.
 *
 */

void remove_value(char *value) {
	/* YOUR CODE HERE */

}


/* garbage_collect
 *
 * Remove and free all zero-count strings from the bag
 *
 * Traverse the list looking for a node that has a count of 0 or less. 
 * Re-assign pointers so that the linked list integrity remains intact. 
 * Free all unused memory.
 *
 * Hint: keep an extra pointer to the PREVIOUS item in the list
 */
void garbage_collect(){

//this should work, but untested for time constraints
//edit: only frees value, and segfaults/core dumps
/*
    struct node *current;
    struct node *old;
    current = first;
    while (current->next != NULL) {
        //if (current->value == patients->id) {
        //free buffers/nodes
            current=current->next;
            while(current->next != NULL){
                old=current;
                current=old->next;
                //free(old->count);
                free(old->value);
            }
            break;
        }
        current = current->next;
  */      
}

/* print_bag
 * 
 * Traverse the list and print it out. 
 * Delimited by tabs and newlines.
 *
 * You do not need to edit this function.
 *
 */
void print_bag(){
	struct node* walker = first;
	while(walker != NULL){
		printf("\t%s\t%i\n", walker->value, walker->count);
		walker = walker->next;
	}
}
