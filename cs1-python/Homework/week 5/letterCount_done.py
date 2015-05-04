"""
Author: Jon O'Brien
due date: 9/28/13
assignment: LetterCount.py

description:  This program was designed to take an inputted file, read over the strings 
 in the file for an inputted charcter and output the lines that character is
 on, along with the total number of counted times this character appears in the
 strings of the chosen file.

 This program uses a recursive function to identify the number of times an inputted
 character appears in lines of the file input.  There is a second function with a for
 loop that accumulates the counted amount of characters in the inputted file.

 The program receives input for a character to search the file for, and the name of the
 file being searched through.  The output consists of the lines that the specified
 character is found on, followed by the total count of times the character appears.
"""





def countLetterFile(char, textFileName):
    """
    This function requires input for the file being read from and the character being
    searched for, calls the count_LetterString() function to perform its task.
    It uses a for loop to print out the lines that contain the character
    and the total count of the number of times the character appears in the file.
    """
    count = 0
    countAgain = 0

    for line in open(textFileName):                 # uses each line in the open file to search.
        countAgain = count_LetterString(char, line) # uses count_letterString() to count the character
        count += countAgain                         # accumulates the number of times the character appears.
        if countAgain == 0:
            pass
        else:
            print(line.strip("\n"))
    return count



def count_LetterString(char, strng):
    """
    This function uses recursion to take an inputted string and accumulate the number
    of times the required character appears in the given string.  Uses if/elif/else
    statements to define what to do with the head or tail of the string.
    """
    if strng == "":                                    # basecase, empty strings return zero.
        return 0
    elif strng[0] == char:                             # checks the head of the string.
        return 1 + count_LetterString(char, strng[1:]) # accumulates the number of appearances.
    else:
        new_string = strng[1:]                         # uses the tail of the string.
        return count_LetterString(char,new_string)



def main():
    """
    The main() function asks for user input for a character to search an inputted file for.
    Then the program is run and it prints out the number of characters found along with the
    lines the character is found in.  Uses the countLetterFile() function to do the work.
    """

    char = input("enter character:")
    textFileName = input("enter filename:")                                   # some.txt, in the same directory
                                                                              # as the program is run from.
    print("Total count of ", char, "is", countLetterFile(char, textFileName)) # prints character and lines associated.


main()
