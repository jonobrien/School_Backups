/*
 * Skeleton implementation for the activity to parse and print
 * CSV formatted files read from standard input.
 */

#include <stdlib.h>
#include <stdio.h>

/*
 * Boolean here - just so we don't have to import a text file.
 */

typedef enum { false, true } bool ;

#define MAX_FIELDS	(15)	/* maximum fields on a CSV input line */
#define MAX_CHARS	(20)	/* maximum characters in any one field */

/*
 * Just an array of characters representing a single filed.
*/

typedef char f_string[MAX_CHARS+1] ;	/* string for each field */

/*
 * A parsed CSV line, with the number of fields and upto MAX_FIELDS themselves.
*/

typedef struct {
	int nfields ;				/* 0 => end of file */
	f_string field[MAX_FIELDS] ;		/* array of strings for fields */
} csv_line ;

/*
 * Returns true iff the character 'ch' ends a field. That is, ch is end of file,
 * a comma, or a newline.
 */

bool is_end_of_field(char ch) {
	return (ch == ',') || (ch == '\n') || (ch == EOF) ;
}

/*
 * Return the minimum of two integers.
 */

int min(int x, int y) {
	return x < y ? x : y ;
}

/*
 * Read the next field from standard input. Returns the value of getchar() that
 * stopped (terminated) the field.
 */

int get_field(f_string field) {
/**BEGIN_SOLN**/
	int i ;
	int next_char ;

	next_char = getchar() ;
	for ( i = 0 ; ! is_end_of_field(next_char) ; ++i ) {
		field[i] = next_char ;
		next_char = getchar() ;
	}

	field[i] = '\0' ;
	return next_char ;
/**END_SOLN**/
}

/*
 * Read in a CSV line. No error checking is done on the number of fields or
 * the size of any one field.
 * On return, the fields have been filled in (and properly NUL-terminated), and
 * nfields is the count of the number of valid fields.
 * nfields == 0 means end of file was encountered.
 */

csv_line get_line() {
/**BEGIN_SOLN**/
	csv_line line ;
	int fi = 0 ;	/* index of current field in line */
	int stop_ch ;	/* character that terminated the last field */

	stop_ch = get_field(line.field[fi++]) ;
	while ( stop_ch == ',' ) {
		stop_ch = get_field(line.field[fi++]) ;
	}

	line.nfields = (stop_ch == EOF) ? 0 : fi ;
	return line ;
/**END_SOLN**/
}

/*
 * Print a CSV line, associating the header fields with the
 * data line fields.
 * The minimum of the number of fields in the header and the data
 * determines how many fields are printed.
 */

void print_csv(csv_line header, csv_line data) {
/**BEGIN_SOLN**/
	int i ;
	int nfields = min(header.nfields, data.nfields) ;

	for ( i = 0 ; i < nfields ; ++i ) {
		printf("%s = %s\n", header.field[i], data.field[i]) ;
	}
/**END_SOLN**/
}

/*
 * Driver - read a CSV line for the header then read and print data lines
 * until end of file.
 */

int main() {
	csv_line header ;
	csv_line current ;

	header = get_line() ;
	current = get_line() ;

	while ( current.nfields > 0 ) {
		print_csv(header, current) ;
		current = get_line() ;
	}

	return 0 ;
}
