"""
Author; Jon O'Brien
Date: 10/12/13
Assignment: Baby name - week 7

"""


class  kidInfo():
    """
    This class takes the given items of the list and makes the split list.
    """
    __slots__ = ("name","gender","count")


def mkKidInfo(name, gen, con):
    """
    This function assigns the class items.
    """
    kid = kidInfo()
    kid.name = name
    kid.gender = gen
    kid.count = con
    return kid


##
##def selectionSort(lst):
##    """
##    This function uses a for loop to take the unsorted list created from the input file
##    and print out the sorted list after comapring the different elements and properly sorting
##    the elements contained in the file.
##    """
##    for i in range(20):
##        current = lst[i]
##        minimumItem = current
##        for j in range (i+1, len(lst)-1):
##            if lst[j].count < minimumItem.count:
##                minimumItem = lst[j]
##        lst[i], lst.index(minimumItem) = lst.index(minimumItem), lst[i] # swapping to move up the largest name occurrances
##        print("This dude in this list is a " + lst[i].gender +
##              " named " + lst[i].name + " who's name has a popularity of " + lst[i].count)
##

def nameSelection(lst1,fileName):
    makeList(fileName)

    for line in kidList:
        mkKidInfo(0,20)
        
        

def makeList(fileName):
    """
    This function opens the file, splits the file into a list, and splits the 3 items to put into the class.
    """
    kidList = []
    for line in open(fileName):
        lst1 = line.split(",")
        m = mkKidInfo(lst1[0], lst1[1],int(lst1[2]))
        kidList.append(m)
    return kidList


def main():
    """

    """
    fileName = input("enter year:")
    fileName = "names/yob"+fileName +".txt"  
    lst=[]
    lst1 = []
##    for line in open(fileName):
##        lst.append(line.split(","))
    
    kidList = nameSelection(lst1,fileName) # goes into selection sort
    print(kidList)
##    kidList = selectionSort(kidList)


main()

