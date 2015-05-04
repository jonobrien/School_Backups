"""
Author: Jon O'Brien
Due Date: 11/16/13
Assignment: TreeMap.py - Binary Search Tree

This program creates a binary search tree and is able to print out the
corresponding tree with its nodes of pointers and values for each node.
This program makes classes for the tree and an empty tree along with equal
helper functions to initialize the nodes for the tree and the resulting leaf
nodes.  Recursion is used to search for a particular key and its value, to
convert the tree to a string, and to insert new nodes into the tree.
"""


class EmptyMap():
    """
    This class defines an empty tree, with zero slots.  The helper function
    makes instances of empty nodes used to determine the end of the tree.
    """
    
    __slots__ = ()


class NonEmptyMap():
    """
    This class defines a non-empty tree, with slots for left, right, the key
    and the value.  This is used to store the instances of information from
    the helper function.
    """

    __slots__ = ( 'left','key' ,'value', 'right' )


def mkEmptyMap():
     """
    This function makes the empty tree instanced objects.  These objects
    are returned to the class EmptyMap() and are used in the construction
    of the tree.
    """
     
     return EmptyMap()
    

def mkNonEmptyMap(left,key,value,right):
    """
    This function takes parameters of the left, key, value, and right, and
    makes the instanced objects to help construct the tree when an object is
    not empty and has a left, right, and key/value pair of information that can
    be used to point to data and/or the next leaf in the tree that is
    constructed.  The node is returned after the function is run.
    """
    
    node = NonEmptyMap()
    node.left = left
    node.key = key
    node.value = value
    node.right = right
    return node


def mapInsert(key, val, map1):
    """
    This function takes parameters of the key, value, and tree, and uses those
    to allow for insertion of a new node into the tree.  The function checks
    if the tree is if an empty tree type, and if it is, the non-empty tree is
    constructed and returned.  Otherwise if the tree has nodes, then there are
    more checks performed upon it.  If the key being inserted is less than the
    key at that node, then the new node is assigned to the tree with the
    inserted key and value.  The new node is returned after the reassignment.
    """
    
    if isinstance( map1, EmptyMap ):
       return mkNonEmptyMap(mkEmptyMap(), key,val, mkEmptyMap())


    elif isinstance( map1, NonEmptyMap):
        if key < map1.key: 
            map1.left= mapInsert(key, val, map1.left)
            return map1
        else:
            map1.right= mapInsert(key ,val, map1.right)
            return map1
        

def mapToString(map1):
    """
    This function takes the tree as a parameter.  It is used in this function
    to convert the tree to a string that shows the nodes and their pointers
    and values contained within them.  This is done using type checking with
    the isinstance(variable, type) check.  The string of nodes that represents
    the tree/map is returned.
    """
    
    str1="_"
    if isinstance(map1, EmptyMap):
        return str1
    elif isinstance(map1, NonEmptyMap):
        return "(" + mapToString(map1.left)+", "+ str(map1.key)+ \
               "->" +str(map1.value)+", "+ mapToString(map1.right)+")"
        

def mapSearch(key,map1):
    """
    This function takes the key and tree as a parameter.  The function then
    uses type checking with isinstance(variable,type) to look through the
    tree and compare the nodes to the one that is being searched for. When the
    key is found, the value is returned and this is done recursively.
    """
    if isinstance( map1, EmptyMap):
        return None
    elif isinstance(map1,NonEmptyMap):
        if key< map1.key:
            return mapSearch(key, map1.left)
        elif key> map1.key:
            return mapSearch(key, map1.right)
        else:
            return map1.value
       
