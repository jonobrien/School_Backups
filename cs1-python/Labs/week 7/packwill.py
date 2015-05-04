"""
Author: Jon O'Brien
Due Date: 10/22/13
Lab: Week 7 - Two Dimensional Bin Packing
 
This program takes an input file and converts the list of integers into a usable list,
reverse sorts the list, creates a 2-D list, and inputs a certain block size based on the
input size of the requested bin dimension.  The row index, column index, and size are determined
by the block size.  the number of free spaces are accumulated and output, along with a list
of unused blocks from the original list that do not fit in the specified 2-D list asked for.
This program also takes a test file of one optimal and one sub-optimal list of blocks
and outputs the results from those as well, if requested for the input file, "blocks1.txt"
or "blocks2.txt" optimal and sub-optimal results.
"""

def isSpaceFree(bn, r, c, s):
    """
    This function takes parameters of the block list list(bn), the row(r),
    the column(c), and the size(s) of the block to input and check for
    free spaces to place the block in the bin correctly. Using a nested
    for loop, the function checks for every row and column to be free
    and returns a boolean.
    """
    
    if len(bn[0]) < r + int(s) or len(bn) < c + int(s):
        return False
    for row in range(r, r+int(s)):
        for col in range(c, c+int(s)):
            if bn[row][col] != 0:
                return False
    return True
 

def fileToSortedList(filename): 
    """
    This function takes the parameter of the filename. This function then
    creates the list of individual elements, the block sizes and then reverses
    that list of block sizes, for a reverse sorted list. The elements are
    strings, converted to integers when used by the function calls respectively.
    """
    
    lst = []
    for line in open(filename):
        lst += line.strip().split() #makes list
 
    lst = sorted(lst, reverse=True)
    return lst
 
 

def displayBin(bn):
    """
    This function takes the parameter of the list of blocks. This function then
    makes the bin initially according to the dimension specified by the user input
    and creates that number of rows and columns.  This is done by using a nested
    for loop for each column and row and printing that respectively after
    completion of the loop.
    """
    
    for row in range(len(bn)):
        for col in range(len(bn[0])):
            print(bn[row][col], end = " ") #prints the list without brackets/commas
        
        print()
 

def createBin(bn, s, r, c):
    """
    This function takes the parameters of the bin list(bn), the size of the
    block(s), the rows(r) and the columns(c).  The function creates the list
    for each block based on the requested block size, and separates the blocks
    based on their size and iterates using nested for loops line by line and
    column by column.
    """
    
    for row in range(int(s)):
        for col in range(int(s)):
            bn[r+row][c+col] = s

def findfreeSpaces(bn, s): 
    """
    This function takes parameters of the list of blocks(bn) and the size of the
    current block(s). The function then uses a nested for loop to determine
    the column and row of the free spaces by iterating over each row and column
    and determining if there are locations where a block may or may not fit.
    A boolean is returned based on a free space in the bin list.
    """
    
    for row in range(len(bn)):
        for col in range(len(bn[0])):
            if isSpaceFree(bn, row, col, s) == True:
                return row, col
    return -1
 

def listToBin(bn, lst):
    """
    This function takes parameters of the block list(bn) and the list of 
    blocks from the file(lst). This function finds the number of unused blocks
    and makes a separate list of these blocks after checking for free spaces
    these blocks could fit in and after confirming that there are no spaces the
    blocks can fit, returns that list.
    """
    
    unusedBlocks = []
    for row in range(len(lst)):
        if findfreeSpaces(bn, lst[row]) == -1:
            unusedBlocks.append(lst[row])
        else:
            r, c = findfreeSpaces(bn, lst[row])
            createBin(bn, lst[row], r, c)
    return unusedBlocks
 
 
def freeSpaces1(bn): 
    """
    This function takes the parameter of the list of blocks.  The function then accumulates
    the total number of free spaces in the list after sorting the code and putting in the blocks.
    this is done through a nested for loop and accumulation fo the free Spaces variable, which is
    returned and printed in main().
    
    """
    
    freeSpaces = 0
    for r in range(len(bn)):
        for c in range(len(bn[0])):
            if bn[r][c] == 0 or bn[r][c] == '0':  #checks for free spaces to accumulate
                freeSpaces += 1
    return freeSpaces
               

def main():
    """
    This function calls for the dimension of the bin to be printed, calls all the functions to complete
    the above operations, and prints out the list of unused blocks, and number of free spaces after
    sorting and inputting the blocks into the list/bin.  The list of blocks is made in main() through the
    nested for loop below and that is used throughout the functions being called.  This original list of
    blocks is kept separate from the list of unused blocks that is printed at the end of the program.
    """
    
    dimension = int(input("Enter square bin dimension: "))    
    bn = [[0 for c in range(dimension)] for r in range(dimension)] 
    blockFile = input("Block File is: ")
    blockList = fileToSortedList(blockFile)
    unusedBlocks = listToBin(bn, blockList) #keeps track of unused blocks
    freeSpaces = freeSpaces1(bn) #counts number of open bin slots after completion
    displayBin(bn)
    print("Free Spaces:", freeSpaces)
    print("Unpacked Blocks:", unusedBlocks)
    
main()


