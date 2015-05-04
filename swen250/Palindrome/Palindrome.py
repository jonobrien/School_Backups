""" Jon O'Brien
n O'Brien
2/3/14
palindrome.py

This file will take an input file from standard input and go through
every line, printing lines that are palindromes; based on whitespace
and non-letter characters.
"""

import sys

def is_palindrome(string):
    front = 0
    back = -1
    for char in string:
        if string[front] == string[back]:
            #checks for same letter on string and moves pointers accordingly.
            advance(front)
            retreat(back)
        else:
            return("")
    return(string)

def advance(front):
    #moves front pointer for palindrome checking on string.
    front += 1
    return front

def retreat(back):
    #moves rear pointer for palindrome checking on string.
    back -= 1
    return back

def main():
    string = ""
    data = sys.stdin
    for line in data:
        formattedLine = ''.join(e for e in line if e.isalnum()).lower()
        #takes input lines and removes special characters and makes
        #uppercase characters into lowercase characters.
        for char in formattedLine:
            if char.isalpha():
            #removes any numbers and forms strings of just letters
                string += char
            else:
                pass

        print(is_palindrome(string))
        string = ""

main()

