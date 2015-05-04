#include <stdlib.h>
#include <stdio.h>
#include <string.h>



#define MAXLINE 80   /* maximum input line size */

/* function declarations */
int readline( char line[], int max );
void copy( char to[], char from[] );

/* print longest input line */

int main()
{
	int len;	       	   /* current line length */
	char line[MAXLINE];    /* current input line */
    char longest[MAXLINE] = "";
    int lastlength = 0;

	while ( (len = readline( line, MAXLINE )) > 0 ) {
		if(len > lastlength) {
            lastlength = len;
            copy(longest,line);//make the new longest line copy
        }
    }
    printf("The longest line is: %s", longest);
	return 0;
}


/* readline: read a line into s, return length */
int readline( char s[], int lim )
{
    int i;
    if(fgets(s,MAXLINE,stdin) == NULL) {
        return 0;
    }
    i = strlen(s)-1;
	return i;//returned defined variable
}

/* copy: copy 'from' into 'to'; assume to is big enough */
void copy( char to[], char from[] )
{
    int i;
    for(i=0; i < strlen(from); i++) {
        to[i] = from[i];//redefine arrays
    }
    
}



