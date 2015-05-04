"""
Author: Jon O'Brien
Assignment: Homework Week 7
'''The class hold the objects variables in it including the name, gender, and
count'''
"""
class kidInfo():
    __slots__ = ("name","gender","count")

'''The mkKidInfo function stores all of the parts of the list once they are
split and puts them into the class to become one object'''
def mkKidInfo(name,gen,con):
    kid = kidInfo()
    kid.name = name
    kid.gender = gen
    kid.count = con
    return kid

'''getNames function splits the list that comes form the filename'''
def getNames(filename):
    kidList = []
    for line in open(filename):
        lst1 = line.split(",")
        m = mkKidInfo(lst1[0],lst1[1],int(lst1[2]))
        kidList.append(m)
    return kidList

'''def selection_sort(lst):

    for fillPlace in range(20):
        ixMax = fillPlace
        
        for nextPlace in range(fillPlace,len(lst)-1):
            if lst[nextPlace].count > lst[ixMax].count:
                ixMax = nextPlace
        temp = lst[fillPlace]
        lst[fillPlace] = lst[ixMax]
        lst[ixMax] = temp
    return lst'''
'''Helper function isHigher compares the two counts one number of occurences
then gender'''
def isHigher(kidA,kidB):
    if kidA.count > kidB.count:
        return kidA
    elif kidA.count < kidB.count:
        return kidB
    else:
        if kidA.gender == "F":
            return kidA
        else:
            return kidB

    print(kidA , kidB)
'''find Highest places the highest in the list through the is higher function
then places it in the output in top 20'''
def findHighest(inputArray):
    highestIndex = 0
    for curr in range(len(inputArray)):
        if inputArray[highestIndex] != isHigher(inputArray[highestIndex],inputArray[curr]):
            highestIndex = curr

    return highestIndex

'''top20 places only the top 20 most popular baby names into the output list
once it goes through the findHighest function. After it removes the number so
it wont loop over the hgihest number constantly'''
def top20(kidList):
    output = []
    for num in range(20):
        highest = findHighest(kidList)
        output.append(kidList[highest])
        kidList.pop(highest)
    return output
'''print output takes all of the information from the make function and prints
it out'''
def printOutput(output):
    for i in output:
        print(i.name,"("+i.gender +"):",i.count)
'''Main takes the user input, goes through the get name function, puts them in order
and the slection sort output and iterates 20 times from the greatest to least amount of
names with the other parts of itself'''
def main():
    filename = input("Enter year: ")
    filename = "names/yob"+filename +".txt"
    kidList = getNames(filename) # splits the list up into the 3 elements
    output = top20(kidList)
    #kidList = selection_sort(kidList)#sorts the numbers from greatest to least 20 times
    printOutput(output)  
main()
