"""
Auhor: Jon O'Brien
Lab: store locator


"""
import time
import math

def quickSelect(lst,k):
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

def findMedian(lst):
    """
    docstring here
    """
    if lst == []:
        pass
    if len(lst)%2 == 0: #if even, avg 2 medians
        a = quickSelect(lst,(len(lst)//2)-1)
        b = quickSelect(lst,len(lst)//2)
        print(a,b)
        return (a+b)/2
    else:           #odd
        return quickSelect(lst,len(lst)//2)
    
def totalDistance(lst):
    total = 0
    x = findMedian(lst)
    for num in lst:
        total += abs(num-x)
    return total

def main():
    filename = input("testDataSet10K.txt") #testDataSet10K
    file = open(filename)
    lst = []
    
    for line in file: #makes list
        thing = line.split()
        lst.append(int(thing[1]))
    current2 = time.clock()
    lst = []
    print("selectMedian.py:")
    
    print("Optimal Distance:",findMedian(lst))
    current = time.clock()
    print("Total Distance:",totalDistance(lst))
    aaa = current - current2
    print("Time:",aaa)


main()









