
#include <stdio.h>
#include <stdlib.h>
#include "linked.h"
	
struct node* head = NULL;

void main() {
	int value;
	//struct node* head = NULL;
    struct node* copy = NULL;	
	push(2);
	push(3);
	push(5);
	value = pop();
    printf("value = %s\n", value);
	printf("Length of list = %d\n", length());
	printList(head);
	appendNode(8);
	printList(head);
    printf("Length of list = %d\n", length());
    copy = copyList(head);
    printList(copy);
	// add additional tests here....
	
}
