/* linked.h - linked defines */

/* Below is a variation on the linked list activity. 

Instead of having an integer as the linked list payload, we have a string. 

Implement the other functions to this specification. 
*/

struct node {
	char* data_str;
  	struct node* next;
};

extern struct node* head;  /* declare global variable head */

/*
 * External declarations for linked functions.
 * 
*/

extern int length();
extern void push(char* data_str);
extern char* pop();
extern void appendNode(char* data); 
extern struct node* copyList(); 
extern void printList();

