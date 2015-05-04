#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

#define FALSE (0)
#define TRUE  (1)

int main() {
	int tot_chars = 0 ;	/* total characters */
	int tot_lines = 0 ;	/* total lines */
	int tot_words = 0 ;	/* total words */
    int nchar; /* number of the character being read in from file */
    int isSpace = 0; /* is there whitespace at that character?  */
	
    while((nchar = getchar()) != EOF) { /* get characters and go until end. */
          /* if newline, space, tab: */
        if (isspace(nchar)) {
              /* if newline: */
            if (nchar == '\n') 
                ++tot_lines;
              /* if space or tab: */
            if (!isSpace)
                ++tot_words;
              /* set character as a space */
            isSpace = 1;
           /* not a space */
        } else 
            isSpace = 0;
          /* always increment character count */
        ++tot_chars;  
    }
     /* prints out the numbers in the proper formatting */
    printf(" %d %d %d\n",tot_lines, tot_words, tot_chars);
    return 0 ;

}


