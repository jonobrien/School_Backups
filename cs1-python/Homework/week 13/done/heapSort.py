"""
assignment: quicheSort - homework 13
file: heapSort.py
version: python3
author: Sean Strout
author: <<< Jon O'Brien >>
purpose: Implementation of the heapsort algorithm, not
    in-place, (lst is unmodified and a new sorted one is returned)
"""

import arrayHeap    # mkHeap (for adding/removing from heap)
import testSorts    # run (for individual test run)

def heapSort(lst):
    """
    heapSort(List(Orderable)) -> List(Ordered)
        performs a heapsort on 'lst' returning a new sorted list
    Postcondition: the argument lst is not modified
    """
    t=len(lst)
    i= arrayHeap.mkHeap(t,arrayHeap.less)
    r=[]
    for elem in lst:
        arrayHeap.add(i, elem)
    for el in range(len(lst)):
        r.append(arrayHeap.removeMin(i))
    return r

if __name__ == "__main__":
    testSorts.run('heapSort')
