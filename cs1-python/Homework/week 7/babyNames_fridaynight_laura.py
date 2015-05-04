"""
Author; Jon O'Brien
Date: 10/12/13
Assignment: Baby name - week 7

"""

class  entry():
    """
    This class takes the given items of the list and makes the split list.
    """
    __slots__ = ("name","gender","occ")


def mkEntry(name, gen, occ):
    """
    This function assigns the class items.
    """
    kid = entry()
    kid.name = name
    kid.gender = gen
    kid.occ = occ
    return kid


def makeList(fileName):
    """
    This function opens the file, splits the file into a list, and splits the 3 items to put into the class.
    """
    lst = []
    for line in open(fileName):
        splitLst = line.split(",")
        m = mkEntry(splitLst[0], splitLst[1], int(splitLst[2]))
        lst.append(m)
    return lst





def insertionSort(lst): # increment i
    for idx in range(0,20):
        
        print("FOR")#test
        mark = idx - 1
        temp = lst[idx]
        
        while(mark>= 0 and int(lst[mark].occ) > int(temp.occ)):
            print("in while")#test
            lst[mark + 1] = lst[mark]
        lst[mark + 1] = temp
    return lst
        #print("This dude in this list is a " + lst[i].gender +
         #     " named " + lst[i].name + " who's name has a popularity of " + lst[i].count)




def main():
    """

    """
    fileName = input("enter year:")
    fileName = "names/yob"+ fileName +".txt"
    lst = []
    for line in open(fileName):
        splitList = (line.split(","))
        kid = entry()
        kid.name = splitList[0]
        kid.gender = splitList[1]
        kid.occ = splitList[2]
        lst.append(kid)
    
    
    bigLst = makeList(fileName) # goes into insertionSort
    print("into insertion")
    lst = insertionSort(lst)
    print(lst)



main()

def readFile(fileName):
    *read file line by line*
    babyList=[]
    line=line.split(",")
    b=Baby(line[1],line[2],line[3])
    babyList.append(b)


def compare(b1,b2):
    if b1.frequency>b2.frequency:
        return 1
    elif b1.frequency<b2.frequency:
        return -1
    else: # other things you compare to(name,gender)
        
        
        



























    

