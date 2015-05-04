"""
file: qsPivotFirst.py
version: python3
author: Sean Strout
author: <<< YOUR NAME HERE >>>
purpose: Implementation of the quicheSort algorithm (not in place),
    It first uses quickSort, using the median-of-3 pivot, until it
    reaches a recursion limit bounded by int(math.log(N,2)).
    Here, N is the length of the initial list to sort.
    Once it reaches that depth limit, it switches to using heapSort instead of
    quicksort.
"""

import heapSort             # heapSort
import math                 # log2 (for quicksort depth limit)
import testSorts            # run (for individual test run)

def quicheSortRec(lst, limit):
    """
    A non in-place, depth limited quickSort, using median-of-3 pivot.
    Once the limit drops to 0, it uses heapSort instead.
    """
    return None

def quicheSort(lst):
    """
    The main routine called to do the sort.  It should call the
    recursive routine with the correct values in order to perform
    the sort
    """
    return []
       
if __name__ == "__main__":
    testSorts.run('quicheSort')


