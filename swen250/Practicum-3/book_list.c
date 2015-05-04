#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

//authored by SE dept of RIT, edited by Jon O'Brien 4-30-14
//Practicum-3 in C

#define MAXBOOKS (5)	/* max books in the book_list structure */
#define MAXTITLE (30)	/* max characters in a book title */
#define MAXCHARS (2)	/* max characters for an input rating */ 

/*
 * Data structure declarations.
 *      Book is a structure holding a book title and rating.
 */

typedef struct{
        char   title[MAXTITLE+1]; /* book title (NUL-terminated) */
        int    rating;            /* (1 <= rating <= 5) */
} Book ;


/*
 * Global data structure definitions:
 * These variables are accessible to all functions in this file:
 *      book_list is the array of books we're working with.
 *      num_books is the number of books in the list.
 */

Book book_list[MAXBOOKS];       /* the book collection */
int  num_books = 0 ;            /* number of books in the list */


/*  DO NOT EDIT
 *  Function hardcoded to read one book entry line from stdin.
 *		Returns the two fields passed as strings: title and rating
 *		If input is complete (EOF), function returns -1, otherwise 0.
 *		Assumes properly formatted book entry: <title,rating\n>, no blank lines
*/
 int read_book( char title[], char rating[]){
	 int c;
	 int i = 0;
	 int status = 0;
	 c = getchar();	
	 if( c != EOF && c != '\n' ){
		while( c != ',' ){
			title[i++] = c;
			c = getchar();
		}
		title[i] = '\0';
		i = 0;
		c = getchar();
		while( c != EOF && c!= '\n' ){
			rating[i++] = c;
			c = getchar();
		}
		rating[i] = '\0';
	 }
	 if ( c == EOF )
		status = -1;
	 return status;
}

/*  DO NOT EDIT
 *  Print the book_list structure 
*/
void print_books(){
	int i =0;
	for( i = 0; i < num_books ; i++ ){
		printf("%i %s\n",book_list[i].rating, book_list[i].title);
		}
	}
	
/*
 *  Add a new book title and its rating to the book_list
 *  You may assume title is not NULL, the string it points to is not
 *  too long, and 1 <= rating <= 5
 *  Returns
 *    (1) if the book was added.
 *    (0) if there was no more room in book list.
 *
 *  HINT: use strcpy when adding a new title to the book_list
 */
int add_book( char title[], int rating ){
	int status = 0;
    int i = 0;
    if (num_books < MAXBOOKS) {
        book_list[num_books].rating = rating;
        /* my implementation of strcpy, works on sample data */
        for (i = 0; i < MAXTITLE; i ++) {
            book_list[num_books].title[i] = title[i]; 
        }
    ++num_books; /* increment num_books. */
    status = 1; /* book was added */
    }
	return status;
}


/*
 *  Return the mean (average) of all the book ratings.
 *  If the list is empty, return 0.0.
 */
double mean_rating(){
    double mean = 0.0 ;     /* mean rating */
    int totalRat = 0; /* the total count for book ratings */
    int i = 0; /* index */
    double tempNum = num_books+0.0;
    /* if there are books */
    if (num_books > 0) { 
        for (i = 0; i < num_books; i++) {
            /* accumulate total rating */
            totalRat = totalRat + book_list[i].rating; 
        }
        /* calculate mean */
        mean = totalRat/tempNum;
    } 
    return mean;
}

/* 
 *  Swap the book_list entries at positions 'i' and 'j'.
 *  Called by sort functions.
 *  You may assume 0 <= i < num_books and 0 <= j < num_books.
 *
 *  HINT: stuctures of the same type may be assigned to each other
 */
void swap( int i, int j ){

    Book tempList[3]; /* temporary instance of struct for swapping */
    tempList[0] = book_list[i];
    tempList[1] = book_list[j];
    /* use the struct instance to swap the books */
    book_list[i] = tempList[1];
    book_list[j] = tempList[0];
}

/* 
 *  Sort the book_list structure by rating in descending order (5 to 1).
 */
void sort_by_rating(){
    int i; /* index of book in list */
    int j; /* second index of book in list */
    
    for (i = 0; i < num_books; i++) {
        for (j = i; j < num_books; j++) {
            /* swap the books according to rating in descending order */
            if (book_list[i].rating < book_list[j].rating) {
                swap(i,j);
            }
        }
    }
}

/* 
 *  Sort the book_list structure by title in ascending order (A-Z).
 *
 *  HINT: Use strcmp() from the string.h library
 */
void sort_by_title() {

	/* same code as sorting by rating, except strcmp is used, and title vs rating is used to compare */
    int i;
    int j;
    for (i = 0; i < num_books; i++) {
        for (j = i; j < num_books; j++) {
            /* sort by title in ascending order, if books have titles */
            if (strcmp(book_list[i].title, book_list[j].title) > 0) {
                swap(i,j);
            }
         }
     }
}


int main(){

	char in_title[MAXTITLE+1];
	char in_rating[MAXCHARS+1];

	/*
	 *  (1) - Use read_book to get a book entry from stdin
	 *	(2) - Populate the book_list structure with the new entry
	 *	(3) - Continue (1) & (2) until EOF from stdin
	 *	(4) - Print the book_list structure as read from stdin
	 *  (5) - Compute and print the mean value of all book ratings
	 *	(6) - Sort and print the book_list structure based on ratings- high (5) to low(1)
	 *	(7) - Sort and print the book_list structure based on title (A-Z)
	 *
	*/

	/* read until EOF and add books to struct */
	while(read_book(in_title,in_rating) !=-1) { /* EOF = -1 */
        int tempI = in_rating[0]-48; /* convert ascii to int */
        add_book(in_title,tempI); /* add to the list */
    }
    
    printf("\nBooks as entered:\n");
	print_books();

    printf("\nMean rating = %.1f\n",mean_rating());
    
    sort_by_rating();    
    printf("\nBooks sorted by rating:\n");
    print_books();
    
    sort_by_title();
    printf("\nBooks sorted by title:\n");
    print_books();
    printf("\n");
    /* new-line at the end to add formatting aesthetics */
	return 0;
	}

