"""
Author: Jon O'Brien
Due Date: 11/12/13
Assignment: Wacky Wheel of Fortune
"""

class EmptyListNode():
    """
    a class that represents an empty list object
    """
    __slots__ = ()

class ListNode():
    """
    a class that represents a list with a data, next, and previous slot
    """
    __slots__=('data','next','prev')

class List():
    """
    a class for a list with the cursor and size slots

    """
    __slots__=('cursor','size')

def mkList():
    """
    a helpet function to hold a lst object for the list class.  takes attributes
    for cursor and size, returns the object.

    """
    lst=List()
    lst.cursor=mkEmptyListNode()
    lst.size=0
    return lst

def mkNode(data,prev,next):
    """
    a helper function to hold a node object for a list node class.  takes
    attributes for data, next, and previous.  returns a node object.

    """
    node=ListNode()
    node.data=data
    node.next=next
    node.prev=prev
    return node

def mkEmptyListNode():
    """
    a helper function for the empty list node class.  returns an empty list
    node object.
    """
    return EmptyListNode()

def backward(lst):
    lst.cursor = lst.cursor.prev
    return lst.cursor

def forward(lst):
    """
    moves the cursor forward and reassigns the value.  This is returned
    """
    lst.cursor = lst.cursor.next
    return lst.cursor

def getNext(lst):
    """
    returns the next item on the wheel
    """
    return lst.cursor.next

def getPrev(lst):
    """
    returns the previous item on the wheel
    """
    return lst.cursor.prev


def printList(lst):
    front=lst.cursor
    final = "" + str(front)
    forward(lst)
    while (lst.cursor.data != front):
        final +="'" + str(lst.cursor.data)
        forward(lst)
        final += ""
        print(final)

def size( lst ):
    """
returns a size attribute for the wheel to be utilized by the list class
    """
    return lst.size

def add(lst,value):
    """
    adds items to the lists according to their values and
    reassigns the node accordingly.
    """
    if lst.size==0:
        newnode = mkNode(value, EmptyListNode(), EmptyListNode())
        lst.cursor = newnode
        lst.cursor.next = newnode
        lst.cursor.prev = newnode
        lst.size+=1
        return

    else:
        newnode = mkNode(value,lst.cursor,lst.cursor.next)
        
        lst.cursor.next.prev=newnode
        lst.cursor.next=newnode
        lst.size+=1
        return

def remove(lst):
    lst.cursor.prev.next=lst.cursor.next
    lst.cursor.next.prev=lst.cursor.prev
    lst.cursor=lst.cursor.prev
    lst.size-=1
    return lst.cursor
    
