"""
assignment: quicheSort - homework 13
file: qsPivotMedian3.py
version: python3
author: Sean Strout
author: <<< Jon O'Brien >>>
purpose: Implementation of the quick-sort algorithm (not in-place).  The 
    pivot is chosen always to be the median-of-3 (the median of
    the first, middle and last values)
"""

import testSorts  # run (for individual test run)
import qsPivotFirst


def medianOf3(lst):
    """
    From a lst of unordered data, find and return the the median value from
    the first, middle and last values.
    """
    f=[]
    start=lst[0]
    mid=lst[len(lst)//2]
    end=lst[len(lst)-1]
    f.append(start)
    f.append(mid)
    f.append(end)
    f.sort()
    return f[1]
    
def quickSort(lst):
    """
    quickSort: List(lst) -> List(result)
        Where the return 'result' is a totally ordered 'lst'.
        It uses the median-of-3 to select the pivot

    e.g.  quickSort([1,8,5,3,4]) == [1,3,4,5,8]
    """
    if len(lst) <= 0:
        return lst
    less, same, more = qsPivotFirst.partition(medianOf3(lst), lst)
    
    return quickSort(less) + same + quickSort(more)
    
   
if __name__ == "__main__":
    testSorts.run('qsPivotMedian3')
