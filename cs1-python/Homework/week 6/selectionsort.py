"""
Author: Jon O'Brien
Due: 10/5/13
Assignment: selectionSort.py

This program takes an input file, reads the lines of unsorted integers, and
prints out the sorted list on a single line.  There is a selectionSort()
function that does the sorting and comparisons with a for loop, and main()
function that calls for the input file name and creates the list for selectionSort()
to use to sort properly.  The list is printed when completed.  the Program was tested by editing
the input file with different variations of unsorted lists to test for different outcomes.

***

Questions:

1.  Insertionsort performs better in lists that are almost sorted.  This would be a list such as
[0,1,2,3,5,4,6] or [2,4,8,10,6] and there are only a few elements our of place, as opposed to a list
that was random, or reversed or already sorted.

2.  Selectionsort performs worse than insertionsort because selectionsort reads through each element
for each comparison, with a big O of n squared, compared to insertionsort that does not compare each
individual element to each other individual element.

3.  Selectionsort moves every element every time, compared to every element contained in that list,
n squared times. With a list of [0,2,1] each element will be compared to the others to check for
an equality and this will take more computation compared to insertionsort.  Selectionsort moves elements
the number of times there are for elements in the list.


"""


def selectionSort(lst):
    """
    This function uses a for loop to take the unsorted list created from the input file
    and print out the sorted list after comapring the different elements and properly sorting
    the elements contained in the file.
    """
    
    for i in range(0, len(lst)-1):
        minimumIndex = i
        for j in range (i+1, len(lst)):
            if lst[j] < lst[minimumIndex]:
                minimumIndex = j
        lst[i], lst[minimumIndex] = lst[minimumIndex], lst[i]
    print(lst)


def main():
    """
    This function takes an input file, creates a list out of the lines contained in it, and calls
    selectionsort to do the work of comparing the elements and printing the list out after sorting it.
    The list is printed out before and after sorting is conducted.
    """
    
    textFileName = input("enter file name")
    lst = []
    for line in open(textFileName):
        lst.append(int(line))
    print(lst)
    selectionSort(lst)

main()















