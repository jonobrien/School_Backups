"""



"""
"""
def sortList(line, char):
    if char


def selectionSort():
    for char in open(file)
    sortAgain = sortList(line, char)


"""






"""

def selectionSort(lst,file):
"""
'docstring'
"""
    for line in open(file):
        print(line.strip)
        n=len(file)
        for i in range (0, n-1):
            minIndex = i
            for j in range (i+1, n):
                if(lst[j] < lst[minIndex]):
                    minIndex = j

            if minIndex != i:
                lst[i], lst[minIndex] = lst[minIndex], lst[i]

"""


def selectionSort(lst):
    
    for fillPlace in range ( 0, len(lst),1):
        ixMin = fillPlace
        print(lst, "outer for loop")
        for nextPlace in range (fillPlace + 1, (len(lst)),1):
            if lst[nextPlace] < lst[ixMin]:
                ixMin = fillPlace
        lst[fillPlace], lst[ixMin] = lst[ixMin], lst[fillPlace]
        print(lst)
    print(lst)


def main():
    """
    docstring
    """
    textFileName = input("enter file name")
    lst = []
    for line in open(textFileName):
        lst.append(int(line))
    print(lst)
    selectionSort(lst)
    """
    print(selectionSort(lst,file))
    """
main()















