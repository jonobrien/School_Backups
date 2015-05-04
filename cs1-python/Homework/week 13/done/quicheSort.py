"""
assignment: quicheSort - homework 13
version: python3
author: Sean Strout
author: <<< Jon O'Brien >>>
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
import qsPivotFirst
import qsPivotMedian3

def quicheSortRec(lst, limit):
    """
    A non in-place, depth limited quickSort, using median-of-3 pivot.
    Once the limit drops to 0, it uses heapSort instead.
    """
    if lst == []:
        return lst
    
    if limit==0:
        return heapSort.heapSort(lst)
    else:
        pivot= qsPivotMedian3.medianOf3(lst)        #  select the first element as the pivot
        less, same, more = qsPivotFirst.partition(pivot, lst)
        return quicheSortRec(less,limit-1) + same + quicheSortRec(more,limit-1)           
   

def quicheSort(lst):
    """
    The main routine called to do the sort.  It should call the
    recursive routine with the correct values in order to perform
    the sort
    """
    if len(lst)== 0:
        return list()
    else:
        limit = int (math.log(len(lst),2))
        return quicheSortRec(lst,limit)
    
       
if __name__ == "__main__":
     testSorts.run('quicheSort')


