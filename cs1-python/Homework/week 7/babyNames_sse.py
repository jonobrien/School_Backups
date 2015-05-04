"""
Author; Jon O'Brien
Date: 10/12/13
Assignment: Baby name - week 7



"""
##
##def compare(kidA,kidB): #returns top most item in list
##    if(kidA.count>kidB.count):
##        return kidA
##    elif(kidA.count<kidB.count):
##        return kidB
##    else:
##        if(kidA.gender == "F"):
##            return kidA
##        else:
##            return kidB






class  kidInfo():
    """

    """
    __slots__ = ("name","gender","count")

def mkKidInfo(name, gen, con):
    """

    """
    kid = kidInfo()
    kid.name = name
    kid.gender = gen
    kid.count = con
    return kid

def selectionSort(lst):
    """
    This function uses a for loop to take the unsorted list created from the input file
    and print out the sorted list after comapring the different elements and properly sorting
    the elements contained in the file.
    """
    for i in range(20):
        current = lst[i]
        minimumItem = current
        for j in range (i+1, len(lst)-1):
            if lst[j].count < minimumItem.count:
                minimumItem = lst[j]
        lst[i], lst[minimumIndex] = lst[minimumIndex], lst[i]
        print("This dude in this list is a " + lst[i].gender +
              " named " + lst[i].name + " who's name has a popularity of " + lst[i].count)

def makeList(fileName):
    """

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
    fileName = "names/yob"+ fileName +".txt" #plusses don't add spaces, commas do
    lst=[]
    for line in open(fileName):
        lst.append(line.split(","))
        print("done")
    #top20Names(lst)
kidList = makeList(fileName) # goes into selection sort
kidList = selectionSort(kidList)


main()












    


def insewrtionsort(lst):
    pass




#def top20F(lst):
    for i in range(0,len(lst)):
        if i < 20:
            print(lst[i])
        else:
            print("nope")
            return







