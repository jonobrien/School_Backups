#!/usr/local/bin/python3

"""
Author: Jon O'Brien
Due Date: 11/9/13
Assignment: linked list homework




File: myListRec.py
Author: Sean Strout <sps@cs.rit.edu>
Language: Python 3
Description:  A recursive implementation of a node based singly linked list
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
    
    return '[' + toStringRec(lst.head) + ']'

   
def toStringRec(node):
    """
    Converts our linked list into a string form that is similar to Python's
    printed list.
    
    Restrictions: Intended for internal use (not for client)
    Parameters:
        node (Node or EmptyNode) - The current node in the list
    Returns:
        A string representation of the list (e.g. '[1,2,3]')
    """
    
    if isinstance(node, EmptyNode):
        return ''
    elif isinstance(node.next, EmptyNode):
        return str(node.data)
    else:
        return str(node.data) + ', ' + toStringRec(node.next)


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
        appendRec(lst.head, value)
        
    lst.size += 1
        
def appendRec(node, value):
    """
    Add a node containing the data to the end of the list.  This is the 
    helper function intended to be called directly by the client. 

    Restrictions: Intended for internal use (not for client)
    Parameters:
        node (Node or EmptyNode) - The current node in the list
        value (any type) - The data to append to the end of the list
    Returns:
        None
    """
    if isinstance(node.next, EmptyNode):
        node.next = mkNode(value, EmptyNode())
    else:
        appendRec(node.next, value)
                       

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
        insertRec(lst.head, index-1, value)
        
    lst.size += 1
        
def insertRec(node, index, value):
    """
    Insert a new element before the index.
    
    Restrictions: Intended for internal use (not for client)
    Parameters:
        node (Node or EmptyNode) - The current node in the list
        index (int) - The 0 based index to insert before
        value (any type) - The data to be inserted into the list
    Returns:
        A Node representing the head of the list
    """
    
    if index == 0:
        node.next = mkNode(value, node.next)
    else:
        insertRec(node.next, index-1, value)
        
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
        
    return getRec(lst.head, index)
    
def getRec(node, index):
    """
    Returns the element that is at index in the list.
    
    Restrictions: Intended for internal use (not for client)
    Parameters:
        head (Node or EmptyNode) - The head of the list
        index (int) - The 0 based index to get    
    Returns:
        A Node (or Empty Node) representing the head of the list    
    """    
    
    if index == 0:
        return node.data
    else:
        return getRec(node.next, index-1)
        
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

    setRec(lst.head, index, value)

def setRec(node, index, value):
    """
    Sets the element that is at index in the list to the value.

    Parameters:
        node (Node) - the current node 
        index (int) - The 0 based index to set
        value (any type)   
    Preconditions:
        0 <= index <= lst.size, raises IndexError exception   
    Returns:
        None
    """    
    
    if index == 0:
        node.data = value
    else:
        return setRec(node.next, index-1, value)
        
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
    
    lst.cursor = EmptyNode()
    if index == 0:
        value = lst.head.data
        lst.head = lst.head.next
    else:
        value = popRec(lst.head, index-1)
    
    lst.size -=1
    return value
        
def popRec(node, index):
    """
    Remove the element at index.
    
    Restrictions: Intended for internal use (not for client)
    Parameters:
        node (Node or EmptyNode) - The current node in the list
        index (int) - The 0 based index to remove   
    Returns:
        The value (any type) being popped
    """
    if index == 0:
        value = node.next.data
        node.next = node.next.next
        return value
    else:
        return popRec(node.next, index-1)
        
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
    return indexRec(lst.head, value, 0)
        
def indexRec(node, value, index):
    """
    Returns the index of the first occurrence of a value in the list
    
    Restrictions: Intended for internal use (not for client)
    Parameters:
        node (Node or EmptyNode) - The current node in the list
        value (any type) - The data being searched for 
    Preconditions:
        value exists in list, otherwise raises ValueError exception
    Returns:
        The index (int) of value or None if value is not present in the list
    """    
    
    if isinstance(node, EmptyNode):
        raise ValueError(str(value) + " is not in list")
    elif node.data == value:
        return index
    else:
       return indexRec(node.next, value, index+1)






def myListToPyList(lst):
    """
    This function takes the parameter of the list, and uses it to return and
    the calculations from the called helper function MyListToPyListRec().
      The lst.head is a node which is used in the helper function, the
      empty list returned as a parameter for the helper function
      is used for the beginning of the pylist.
    """
    return myListToPyListRec(lst.head,[])


def myListToPyListRec(node,pylist):
    """
    This function takes the parameter of the node and pylist that are passed
    from the main myListToPyList() function.  This function check for the
    node to be an emptyNode, the end of the list, and otherwise it adds the
    data of that node to the pylist.  This recurses over each node until the
    emptyNode is reached, then it returns the pylist.  
    """
    if isinstance(node,EmptyNode):
        return pylist
    else:
        pylist.append(node.data)
        return myListToPyListRec(node.next,pylist)


def countRec(head,value):
    """
    This function takes the parameters of the head and the value.  The head is
    the beginning of the list and the function compares that node's data
    with the value requested in the value parameter and recurses either adding
    one or not, and then repeating the check until each node has had its data
    checked against the value.  This count is returned into the
    main count() function.
    """
    if isinstance(head,None_Node):
        return
    else:
        if head.data == value:
            return 1 + countRec(head.next,value)
        else:
            return 0 + countRec(head.next,value)


def count(lst, value):
    """
    This function takes the parameters of the lst and value and returns and
    calls the count recursive function to find the number of times an object
    is in the list. which is calculated in the helper function countRec().
    """
    return countRec(lst.head,value)


def pyListToMyList(pylist):
    """
    This function takes the parameter of the pylist and uses it in the return
    and call of the recursive function PyListToMyListRec() that does
    the calculations for the conversion of the pylist into a node-based
    list.  The pylist becomes a node in the myList and the myList
    is initiated with a parameter call to the maker function to start its
    creation.
    """
    return pyListToMyListRec(pylist,mkMyList())


def pyListToMyListRec(node,myList):
    """
    This function takes the parameters of node and myList.  The node is checked
    if empty and if it is, the list is returned, otherwise the node is appended
    onto the node list and returned with the rest of the list as myList
    to recursively create the list.
    """
    if node == []:
        return myList
    else:
        append(myList,node[0])
        return pyListToMyListRec(node[1:],myList)


def remove(lst,value):
    
    """
    This function takes the parameters of the list and value in that list.
    The cursor is initalized for the test function to work properly.  Then
    the function tests if the data contained in the node is equal to the
    value being searched for.  The head node attribute is reassigned to
    the next node and the size of the list is decremented.  The helper
    function RemoveRec() is called in the return and the parameters passed to
    it are the head of the list of nodes and the value being removed.
    """
    lst.cursor=mkEmptyNode()
    if lst.head.data == value:
        lst.head=lst.head.next
        lst.size -= 1
        return True
    else:
        return removeRec(lst.head,value)


def removeRec(node,value):
    """
    This function takes the parameters of the nodes and the value being removed
    and checks the node being an emptyNode, if this is true, then False is
    returned.  Otherwise the next data value in a node is checked if not equal
    to the value that is being tested for and if not equal to, recurses to the
    next node, if that becomes true then the node is skipped and removed with
    the else statement, then True is returned.

    """
    if isinstance(node.next,EmptyNode):
        return False
    elif node.next.data != value:
        return removeRec(node.next,value)
    else:
        node.next = node.next.next
        return True




