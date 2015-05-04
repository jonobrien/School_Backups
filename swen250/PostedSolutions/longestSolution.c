#include <stdlib.h>
#include <stdio.h>

#define MAXLINE 80   /* maximum input line size */

/* function declarations */ 
int readline( char line[], int max );
void copy( char to[], char from[] );

/* print longest input line */

int main()
{
	int len;		     /* current line length */
	int max; 			 /* maxiumum length entered */
	char longest[MAXLINE]; /* longest line saved here */
	char line[MAXLINE];    /* current input line */
     
	max = 0;
	while ( (len = readline( line, MAXLINE )) > 0 ) {
		if( len > max ){
		    max = len;
			copy( longest, line);
			}
		}
	if( max > 0 )        /* there was a line input */
        printf("%s", longest);
	return 0;
}

/* readline: read a line into s, return length */
int readline( char s[], int lim )
{
    int c, i;
    for( i=0; i<lim-1 && (c=getchar()) != EOF && c !='\n'; i++)
        s[i] = c;
    if ( c == '\n') {
        s[i] = c;
	    i++;
	}
	s[i] = '\0';
	return i;
}

/* copy: copy 'from' into 'to'; assume to is big enough */
void copy( char to[], char from[] )
{
    int i = 0;
	while((to[i] = from[i]) != '\0')
	    ++i;
}



