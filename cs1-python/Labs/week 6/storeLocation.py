"""
Author: Jon O'Brien
Due date: 10/8/13
Lab: Week 6 - store selector

    This program finds the median of a list using the simplistic median approach.  Time and math
    modules are imported to the program.  There is an input file that is converted to a list
    and sorted with insertionSort().  The median (optimal store location) of the list is
    calculated, along with the runtime, and total distance to the optimal location from
    the other store locations.  These values are printed at the end of the program.
    
"""

from math import *
import time
             
def insertionSort(lst): 
    """
    This function takes the list and sorts it using the insertion method.  This involves using a
    for loop and while loop to use the index of the range of values in the list to swap around
    the values of the list to create a sorted list of values and this sorted list is used in the
    remainder of the program.
    """
    for indx in range(1,len(lst)):
        compare = indx - 1 # element we are comparing the sorted element to.
        sort = lst[indx] # elements that we are sorting in the list.

        while(compare >= 0 and lst[compare] > sort):
            lst[compare + 1] = lst[compare]
            compare = compare - 1
        lst[compare + 1] = sort

    #print(lst)


def median(lst):
    """
    This function takes the list and creates the value of Optimal Location which is printed
    at the end of the program.  An if/else statement determines even or odd for length of the
    string and calculates the value of the optimal location, which is returned at the end of
    the function, and printed at the end of the program.
    """
    insertionSort(lst)
    #print(lst)
    if len(lst) % 2 == 1:
        i = (len(lst)//2)
        return lst[i]
    else:
        i = (len(lst)//2)
        return ((lst[i] + lst[i-1]) /2)

def totalDistance(lst):
    """
    This function uses a for loop to accumulate the total distance, which is printed at the
    end of the program.  the list is input and each value in the list is added to the
    accumulator. This total is returned at the end of the function and printed at the end of
    the program.
    """
    total = 0
    x = median(lst)
    for num in lst:
        total += abs(num-x)
    return total

def main():
    """
    This function calls for an input file name, creates the list from the file, records the
    time it takes to create the sorted list.  The function prints out the optimal store location,
    total distance to the optimal location and the runtime taken to create outputs.  This runs
    the whole program.

    """
    filename = input("input file:") #testDataSet10K.txt
    file = open(filename)
    lst = []
    
    for line in file: #makes list
        thing = line.split()
        lst.append(int(thing[1]))
    current2 = time.clock() #start time
    print("Optimal Location:",median(lst))
    current = time.clock() # end time, before adding total distance,
                           # per handout instructions.
    print("Total Distance:",totalDistance(lst))
    aaa = current - current2 # total runtime
    print("Time:",aaa)
    
main()   
            
