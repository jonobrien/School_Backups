"""
Auhor: Jon O'Brien
Lab: store locator


"""
import time
import math


"""
def quickSelect(lst,k):
    count = 0
    largeList = []
    smallList = []
    pivot = (len(lst//2))
    for element in lst:
        if element < pivot:
             smallerList.append(element)
    m = len(smallerList)
    for element2 in lst:
        if element2 > pivot:
             largerList.append(element)
    count = 0
    for element3 in lst:
        pass
"""


##             
##    if lst != []:
##        for indx in lst:
##            if lst[indx] == pivot:
##                 smallList.append(lst(indx))
##            elif lst[indx] > pivot:
##                 largeList.append(lst(indx))
##            else:
##                count+= 1
##    m = len(smallList)
##
##    if k >= m and k < m + count:
##        return pivot
##    elif  m > k
##        return quickSelect(smallList, k)
##    else:
##        return quickSelect(largeList, k - m - count)
##    count += 1




    

##          
##def quickSelect(lst,k):
##    """
##    'docstring'
##    """
##    if len(lst)!=0:
##        pivot=lst[(len(lst)//2)]
##        smallerList = []
##        largerList=[]
##    for k in lst:
##        if k<pivot:
##            smallerList.append(k)
##    for k in lst:
##        if k>pivot:
##            largerList.append(k)
##    m = len(smallerList)
##    count=len(lst)-len(smallerList)-len(largerList)
##
##    if k >= m and k < m + count:
##        return pivot
##    elif  m > k:
##        return quickSelect(smallerList, k)
##    else:
##        return quickSelect(largerList, k - m - count)
##


def     quickSelect(lst,k):
    if lst == []:
        pass
    else:
        pivot = lst[len(lst)//2]
        smallerList = []
        largerList = []
        count = 0
        for el in lst:
            if el <pivot:
                smallerList.append(el)
            elif el >pivot:
                largerList.append(el)
            else:
                count += 1
        m = len(smallerList)
        if k >= m and k<m+count:
            return pivot
        elif m > k:
            return quickSelect(smallerList,k)
        else:
            return quickSelect(largerList,k-m-count)



def main():
    lst = [1,2,4,5,6,3,4,8,99,23,4,1,65,32]
    current = time.clock()
    print(quickSelect(lst, 0))
    current2 = time.clock()
    aaa = current2-current
    print(aaa)
main()









