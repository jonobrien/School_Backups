"""
Auhor: Jon O'Brien
Date: 10/8/13
Lab: Week 6 - store selector

     This program takes the quickselect algorithm and outputs the optimal location and
total distance as if sorting the list, from the input text file.  Time and math modules are
imported.  The optimal location is calculated through using quickselect and
the ,one or two values calculated, depending on the list being even or odd.  The total
distance of all stores is calculated and accumulated over the running of the for loop.
The time is calculated after creating the list and before printing the total distance.
"""
import time
import math

def quickSelect(lst,k):
    """
    This function takes the input list from main() and the k parameter from findMedian() and
    returns the Kth smallest number in a list, that does not have to be sorted.  There is
    an if/else statement about handling an empty string, and a for loop using the pivot
    and creating the smaller and larger lists for finding the Kth value in the list.  Returns
    an integer for the function.

    """
    if lst == []:
        pass
    else:
        pivot = lst[len(lst)//2]
        smallerList = []
        largerList = []
        count = 0
        for element in lst:
            if element <pivot:
                smallerList.append(element)
            elif element >pivot:
                largerList.append(element)
            else:
                count += 1
        m = len(smallerList)
        if k >= m and k<m+count:
            return pivot
        elif m > k:
            return quickSelect(smallerList,k)
        else:
            return quickSelect(largerList,k-m-count)

def findMedian(lst):
    """
    This function takes the list and creates the value of Optimal Location which is printed
    at the end of the program.  An if statement determines even or odd for length of the
    string and calculates the value using quickSelect() for the distance.  The optimal
    Location.
    """

    if len(lst)%2 == 0: #if even, avg 2 medians
        a = quickSelect(lst,(len(lst)//2)-1)
        b = quickSelect(lst,len(lst)//2)
        return (a+b)/2
    else:    #odd
        return quickSelect(lst,len(lst)//2)
    
def totalDistance(lst):
    """
    This function uses a for loop to accumulate the total distance, which is printed at the
    end of the program.  the list is input and each value in the list is added to the
    accumulator.  The findMedian() function is used to show the distance from  the optimal
    store location.  This total is returned at the end of the function.
    """
    total = 0
    x = findMedian(lst)
    for num in lst:
        total += abs(num-x)
    return total

def main():
    """
    This function calls for an input file name, creates the list from the file, records the
    time it takes to create the sorted list, and prints out the optimal store location,
    total distances to the optimal location and the runtime taken to create outputs.

    """
    filename = input("input file:") #testDataSet10K.txt
    file = open(filename)
    lst = []
    for line in file: #makes list
        thing = line.split()
        lst.append(int(thing[1]))
    
    current = time.clock() # start time
    print("Optimal Location:",findMedian(lst))
    current2 = time.clock() # end time
    print("Total Distance:",totalDistance(lst))
    aaa = current2 - current # total runtime
    print("Time:",aaa)


main()









