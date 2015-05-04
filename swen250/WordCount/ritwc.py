"""
Jon O'Brien
SWEN 250-01 Personal SE
Python Word Count in Git
fileinput.input() to do stdout
| program to program
> program to file


import fileinput
fileinput.input()
"""
import fileinput
import sys

def wordCount():
	lines = 0
	words = 0
	chars = 0
	
	info = []
	for line in sys.stdin:

		separated = line.split()
		lines += 1
		words += len(separated)
		chars += len(line)
	print(lines, words, chars)
wordCount()



