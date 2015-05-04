#!/usr/local/bin/python3

"""
Author: Jon O'Brien
Due Date: 11/9/13
Assignment: linked list homework




File: myListRec.py
Author: Sean Strout <sps@cs.rit.edu>
Language: Python 3
Description:  An iterative implementation of a node based single linked list
data structure.
Purpose: LECTURE VERSION
"""

from myNode import *

###########################################################
# LINKED LIST CLASS DEFINITION                                
###########################################################

class MyList():
    """A class that encapsulates a node based linked list"""
    __slots__ = ('head', 'size', 'cursor')
    
###########################################################
# LINKED LIST CLASS BUILDER                                
###########################################################

def mkMyList():
    """
    Constructs and returns an empty list.

    Parameters:
        None
    Returns: 
        An empty list
    """
    
    lst = MyList()
    lst.head = mkEmptyNode()
    lst.size = 0
    lst.cursor = mkEmptyNode()
    return lst
    
###########################################################
# LINKED LIST CURSOR FUNCTIONS                                
###########################################################    
    
def reset(lst):
    """
    Resets the cursor to the start of the list
    
    Paramters:
        lst (MyList) - the linked list
    Returns:
        None
    """
    
    lst.cursor = lst.head
    
def hasNext(lst):
    """
    Returns True if the list has more elements.
    
    Paramters:
        lst (MyList) - the linked list
    Returns:
        True (bool) if the cursor is value
    """
        
    return not isinstance(lst.cursor, EmptyNode)    
    
def next(lst):
    """
    Returns the next element in the iteration.
    
    Paramters:
        lst (MyList) - the linked list
    Preconditions:
        If cursor is invalid, raises an IndexError exception
    Returns:
        The value (any type) referenced by the cursor
    """
    
    if isinstance(lst.cursor, EmptyNode):
        raise IndexError("cursor is invalid")
    
    val = lst.cursor.data
    lst.cursor = lst.cursor.next
    return val
    
###########################################################
# LINKED LIST FUNCTIONS                                
###########################################################
    
def clear(lst):
    """
    Make a list empty.
    Parameters:
        lst (MyList) - the linked list
    Returns:
        None
    """
    
    lst.head = mkEmptyNode()
    lst.size = 0
    lst.cursor = mkEmptyNode()
    
def toString(lst):
    """
    Converts our linked list into a string form that is similar to Python's
    printed list. 
    
    Parameters:
        lst (MyList) - The linked list
    Returns:
        A string representation of the list (e.g. '[1,2,3]')
    """
    
    result = '['
    curr = lst.head
    while not isinstance(curr, EmptyNode):
        if isinstance(curr.next, EmptyNode):
            result +=  str(curr.data)
        else:
            result += str(curr.data) + ', ' 
        curr = curr.next
    result += ']'
    
    return result
                                        
def append(lst, value):
    """
    Add a node containing the value to the end of the list. 

    Parameters:
        lst (MyList) - The linked list
        value (any type) - The data to append to the end of the list
    Returns:
        None
    """
    
    if isinstance(lst.head, EmptyNode):
        lst.head = mkNode(value, EmptyNode())
    else:
        curr = lst.head
        while not isinstance(curr.next, EmptyNode):
            curr = curr.next
        curr.next = mkNode(value, EmptyNode())
    
    lst.size += 1
            
def insertAt(lst, index, value):
    """
    Insert a new element before the index.

    Parameters:
        lst (MyList) - The list to insert value into
        index (int) - The 0 based index to insert before
        value (any type) - The data to be inserted into the list
    Preconditions:
            0 <= index <= lst.size, raises IndexError exception
    Returns:
        None
    """

    if index < 0 or index > lst.size:
        raise IndexError(str(index) + ' is out of range.')

    if index == 0:
        lst.head = mkNode(value, lst.head)
    else:
        prev = lst.head
        while index > 1:
            prev = prev.next
            index -= 1
        prev.next = mkNode(value, prev.next)
        
    lst.size += 1
    
def get(lst, index):
    """
    Returns the element that is at index in the list.

    Parameters:
        lst (MyList) - The list to insert value into
        index (int) - The 0 based index to get   
    Preconditions:
        0 <= index <= lst.size, raises IndexError exception   
    Returns:
        None
    """

    if index < 0 or index >= lst.size:
        raise IndexError(str(index) + ' is out of range.')

    curr = lst.head
    while index > 0:
        curr = curr.next
        index -= 1
    return curr.data
    
def set(lst, index, value):
    """
    Sets the element that is at index in the list to the value.

    Parameters:
        lst (MyList) - The list to insert value into
        index (int) - The 0 based index to set
        value (any type)   
    Preconditions:
        0 <= index <= lst.size, raises IndexError exception   
    Returns:
        None
    """

    if index < 0 or index >= lst.size:
        raise IndexError(str(index) + ' is out of range.')

    curr = lst.head
    while index > 0:
        curr = curr.next
        index -= 1
    curr.data = value
    
def pop(lst, index):
    """
    Remove and return the element at index.

    Parameters:
        lst (MyList) - The list to insert value into
        index (int) - The 0 based index to remove   
    Preconditions:
        0 <= index <= lst.size, raises IndexError exception   
    Returns:
        The value (any type) being popped
    """

    if index < 0 or index >= lst.size:
        raise IndexError(str(index) + ' is out of range.')

    lst.cursor = mkEmptyNode()
    if index == 0:
        value = lst.head.data
        lst.head = lst.head.next
    else:
        prev = lst.head
        while index > 1:
            prev = prev.next
            index -= 1
        value = prev.next.data
        prev.next = prev.next.next

    lst.size -=1
    return value

def index(lst, value):
    """
    Returns the index of the first occurrence of a value in the list

    Parameters:
        lst (MyList) - The list to insert value into
        value (any type) - The data being searched for 
    Preconditions:
        value exists in list, otherwise raises ValueError exception
    Returns:
        The index (int) of value or None if value is not present in the list
    """
    
    pos = 0
    curr = lst.head
    while not isinstance(curr, EmptyNode):
        if curr.data == value:
            return pos
        pos += 1
        curr = curr.next
        
    raise ValueError(str(value) + " is not present in the list")








def count(lst, value):
    """
    This function takes the paramters for the list and the value being counted.
    Then the count is accumulated in a while loop that checks for the current
    node not being an EmptyNode.  The node being checked is iterated over each
    consecutive node until this while loop is broken out of.  The count is
    returned at the end of the function.
    """
    c=0
    curr=lst.head
    while not isinstance (curr,EmptyNode):
        if curr.data == value:
            c+=1
        curr=curr.next
    return c


def myListToPyList(lst):
    """
    This function takes the list parameter.  Then this function converts the
    node list into a python list.  This is done by assigning pylist to a
    built-in list.  A while not loop is checked if the current node is not an
    EmptyNode, in the loop the curent nodes' data is appended to the python
    list and the current node is iterated over until the emptyNode is reached.
    Then the finished and constructed python list is returned.
    """
    pylst=list()
    curr=lst.head
    while not isinstance(curr,EmptyNode):
        pylst.append(curr.data)
        curr=curr.next
    return pylst

def pyListToMyList(pylst):
    """
    This function takes the pylist as a parameter.  It converts the pylist
    into a node list called MyList.  The node list is initiated and a for
    loop is used to take every value in the pylist and append it to a node
    in the node list objects.  The node based list is returned at the
    completion of the function to convert the list into a MyList.

    """
    MyList=mkMyList()
    for val in pylst:
        append(MyList, val)
    return MyList


def remove(lst,value):
    """
    Remove takes parameters of list and value.  It searches through the nodes
    and removes the selected value from the list.  This is done with a while
    not loop that checks if the current node is not an emptyNode.  In this
    loop, the data of the node is tested if equal to the value and the head
    is reassigned to the next node until the value is found, that is,
    iterated over each node, and returned true.  Otherwise the node with
    the data that equals the value is reassigned until the value is found
    and the size is decremented by one until the value is located.  When
    the while not loop is broken out of, False is returned.
    """
    curr=lst.head
    lst.cursor=mkEmptyNode()
    
    while not isinstance(curr,EmptyNode):
        if lst.head.data==value:
            lst.head=lst.head.next
            return True

        elif curr.next.data==value: #starting to skip object
            curr.next=curr.next.next #reassigns to not skipped object
            lst.size-=1
            return True
        curr=curr.next
    return False
            
