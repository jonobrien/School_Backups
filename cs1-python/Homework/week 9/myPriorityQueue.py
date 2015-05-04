"""
Author: Jon O'Brien
date: 11/2/13
assignment: priority queue

myPriorityQueue takes the queue and sorts it based on priorities that are assigned
to each initialized object.  There is a class and helper function for the objects,
a function to take the objects and sort them based on the attributes and that is
imported to tasks.py.  myNode is also imported for use in the queue construction.
"""

from myNode import *

class myPriorityQueue():
    """
    creates a class with slots for front, back and size.  This is helped by the
    helper function and is used in tasks to sort the queue.

    """
    __slots__ = ( 'front', 'back', 'size' )
    
def mkPriorityQueue():
    """
    This function creates and returns a newly initialized myPriorityQueue object.

    """
    q = myPriorityQueue()
    q.front = NONE_NODE
    q.back = NONE_NODE
    q.size = 0
    return q

def insert(queue,element):
    """
    This function takes the priority queue and an element and inserts the element into the queue
    depending on the priority.

    """
    if emptyQueue(queue):
        newnode = mkNode(element, NONE_NODE)
        queue.front = newnode
        queue.back = newnode
    else:
        previous = None
        current = queue.front
        while(current != NONE_NODE and current.data.priority >= element.priority):
            previous = current
            current = current.next
        if previous == None:
            queue.front = mkNode(element,queue.front)
        else:
            previous.next = mkNode(element,current)
            if current == NONE_NODE:
                queue.back = previous.next
    queue.size += 1
                   

   
def removeMax(queue):
    """Remove the front element from the queue (returns None)"""
    if emptyQueue(queue):
        raise IndexError("dequeue on empty queue") 
    queue.front = queue.front.next
    
    if emptyQueue(queue):
        queue.back = NONE_NODE
    queue.size -= 1
    
def frontMax(queue):
    """Access and return the first element in the queue without removing it"""
    if emptyQueue(queue):
        raise IndexError("front on empty queue") 
    return queue.front.data
    
def backMin(queue):
    """Access and return the last element in the queue without removing it"""
    if emptyQueue(queue):
        raise IndexError("back on empty queue") 
    return queue.back.data
    
def emptyQueue(queue):
    """Is the queue empty?"""
    return queue.front == NONE_NODE


