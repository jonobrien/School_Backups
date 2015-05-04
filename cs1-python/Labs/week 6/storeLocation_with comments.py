"""
Author: Jon O'Brien
Due date: 10/8/13
Lab - week 6 - store selector

    storeLocation.py
    selectMedian.py
    report.txt

    This program finds the median of a list using the simplistic median approach.
    
"""

from math import *
import time
             #list file: http://www.cs.rit.edu/~csci141/pub/Labs/06/testDataSet10K.txt
def insertionSort(lst): #https://mycourses.rit.edu/d2l/le/content/469300/viewContent/2670072/View
    """
    docstring here!
    """
    for indx in range(1,len(lst)):
        compare = indx - 1 # element we are comparing the sorted element to.
        sort = lst[indx] # elements that we are sorting in the list.

    while(compare >= 0 and lst[compare] > sort):
        lst[compare + 1] = lst[compare]
        compare = compare - 1
    lst[compare + 1] = sort


def median(lst):
    """
    docstring here!
    """
    insertionSort(lst)
    if len(lst) % 2 == 1:
        i = (len(lst)//2)
        return lst[i]
    else:
        i = (len(lst)//2)
        return (lst[i] + lst[i-1] /2)
##
##def distance(lst):   #distance
##    distance = 0
##    middle = median(lst) #of 10k maybe
##    for i in range(len(lst)):
##        a = fabs(median(lst) - lst[i])
##        distance = distance + a
##    return distance

def distance(lst):
    total = 0
    x = median(lst)
    for num in lst:
        total += abs(num-x)
    return total

def main():
    filename = input("testDataSet10K.txt") #testDataSet10K
    file = open(filename)
    lst = []
    current2 = time.clock()
    for line in file:
        if line [10] == " ":
            thing = line.split(line[11:])
            y = int(line[11:])
            lst.append(y)
        elif line[11] ==  " ":
            thing = line.split(line[12:])
            y = int(line[12:])
            lst.append(y)
        elif line[12] == " ":
            thing = line.split(line[13:])
            y = int(line[13:])
            lst.append(y)
    print(median(lst))
    print(distance(lst))
    current = time.clock()
    aaa = current - current2
    print(aaa)
    
main()   
            





##
##print(median([1,2,3,5,4])) #[lst = open(10K.txt#trying to set the 10k file into a list))
##print(distance([2,4,6,8,10]))
##    
