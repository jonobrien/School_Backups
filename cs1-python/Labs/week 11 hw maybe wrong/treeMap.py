"""
Author: Jon O'Brien
Due Date: 11/16/17
Assignment: Binary Search Tree

This program makes a binary search tree, which is searchable and
objects can be inserted into it.
"""

class EmptyMap():
    """

    """
    __slots__ = ()

class nonEmptyMap():
    """

    """
    __slots__= ("right", "left", "key", "value")
    
def mkEmptyMap():
    """

    """
    return EmptyMap()

def mknonEmptyMap(left,key,value,right):
    """

    """
    nonEmpty=nonEmptyMap()
    nonEmpty.left=left
    nonEmpty.key=key
    nonEmpty.value=value
    nonEmpty.right=right
    return nonEmpty


def mapInsert1(key, value, map1):
    if isinstance(map1, EmptyMap):
        return mknonEmptyMap(mkEmptyMap(), key, value, mkEmptyMap())
    elif isinstance(map1,nonEmptyMap):
        if key<map1.key:
            map1.left = mapInsert1(key,value,map1)
            return map1.left
        else:
            map1.right=mapInsert1(key,map1)
            return map1.right



def mapToString(map1):
    str1=''
    if isinstance(map1,EmptyMap):
        return str1
    elif isinstance(map1,nonEmptyMap):
        return mapToString(map1.left)+ str(map1.key) + '' + mapToString(map1.right)


def mapSearch(key,map1):
    pass
    


def main():
    print(mapInsert1(1,100,mkEmptyMap()).value)
    yolo = mapInsert1(3,5,mkEmptyMap())
    print(isinstance(mapToString(yolo),str))




main()




















