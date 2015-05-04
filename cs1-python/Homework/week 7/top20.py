"""
Author: Jon O'Brien
Date: 10/12/13
Assignment: Homework Week 7 - top20 baby names

This program takes an input file, the year of list of names that are most
popular, 20 names in total, sorted female then male dependent on the number of times each name
was counted, and then by gender and then sorted by alphabetically if necessary to output the final
list of 20 most common baby names for the desired year.


"""


class kidInfo():
    """
    This class: kidInto() holds the objects/variables in it including the name, gender,
    and count from the input file.

    """
    __slots__ = ("name","gender","count")



def mkKidInfo(name,gen,con):
    """
    This function: mkKidInfo() stores all of the parts of the list once they are
    split and puts them into the class to become one object

    """
    kid = kidInfo()
    kid.name = name
    kid.gender = gen
    kid.count = con
    return kid



def getNames(filename):
    """
    This function: getNames() splits the list that comes from the imported file and sets
    the elements for use.  Using a for loop splits the line and makes the setup for later

    """
    kidList = []
    for line in open(filename): #opens file
        lst1 = line.split(",")
        m = mkKidInfo(lst1[0],lst1[1],int(lst1[2])) #elements in
        kidList.append(m)
    return kidList



def isHigher(kid1,kid2):
    """
    This function is a helper for findHigher, isHigher() compares the two counts,
    number of occurences then gender.  Utilizing if/elif/else statements to compare the
    different elements and sort through the different baby names in the lists.

    """
    if kid1.count > kid2.count:
        return kid1
    elif kid1.count < kid2.count:  # these statements compare elements for sorting
        return kid2
    else:
        if kid1.gender == "F": #female or male
            return kid1
        else:
            return kid2


    print(kid1 , kid2)

    

def findHighest(inputArray):
    """
    This function: findHighest() places the highest element in the list through
    the isHigher() function then places it in the output in the top20() function. A for
    loop is used to accomplish this method.

    """
    highestIndex = 0
    for curr in range(len(inputArray)):
        if inputArray[highestIndex] != isHigher(inputArray[highestIndex],inputArray[curr]):
            highestIndex = curr

    return highestIndex



def top20(kidList):
    """
    This function: top20() places only the top 20 most popular baby names into the
    outputted list once it goes through the findHighest() function, and subsequent isHigher()
    function as well. After top20() removes the number using the .pop() call, it is
    prevented from looping over the highest number constantly.  This is done by use of a
    for loop and .append and ,pop calls that help to form the correct list of baby names.

    """
    output = []
    for num in range(20): #the first 20 names
        highest = findHighest(kidList)
        output.append(kidList[highest])
        kidList.pop(highest) #removes the highest element to prevent infinite loops
    return output




def printOutput(output):
    """
    THis function: printOutput() takes all of the information from the make function and the
    class, and outputs it into the final printed list with proper sorting and placement of
    elements required for the baby name lists.  This method is done by use of a for loop
    and print statement to go through each element accordingly.
    """
    for i in output:
        print(i.name,"("+i.gender +"):",i.count) #prints the list


        

def main():
    """
    This function: Main() takes the user inputted file, goes through the getNames()
    function, puts them in order after comparisons, and iterates 20 times from
    the greatest to least amount of names sorted by number counted, gender, and aphabetically
    to correctly output the final sorted list of 20 most common baby names in the desired year.
    There 

    """
    filename = input("Enter year: ")
    filename = "names/yob"+filename +".txt" #only have to type 'year'
    kidList = getNames(filename) # splits the list into 3 elements
    output = top20(kidList)
    printOutput(output)  
main()
