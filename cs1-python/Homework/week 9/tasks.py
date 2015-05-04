"""
Author: Jon O'Brien
date: 11/2/13
assignment: priority queue

This program takes the sorting method from the priority queue functions in
myPriorityQueue.py and assigns the objects a priority attribute through a
class and helper function to initialize the objects.
"""


from myPriorityQueue import *
from random import *


class Task():
    """
    creates a class with slots for name and priority, assists with the sorting
    and creation of the priority queue by giving the priority to each object.

    """
    __slots__ = ("name","priority")

def mkTask(myName,myPriority):
    """
    creates and retuns a newly initialized task object
    """
    t=Task()
    t.name=myName
    t.priority=myPriority
    return t




def test():
    """
    This function tests the priority queue functions and different possibilities
    that may arise in the queue.  The priorities are printed to check for
    proper sorting of the objects and insertion of them throughout based on their
    priority values.  Prints the lowest and highest priority objects.

    """
    q = mkPriorityQueue()
    insert(q, mkTask("cat", randint(1,100)))
    insert(q, mkTask("Task2", 9))
    insert(q, mkTask("Task4", 2))
    insert(q, mkTask("Task5", 1))
    insert(q, mkTask("Task6", 4))
    insert(q, mkTask("Task7", 4))
    insert(q, mkTask("Task8", 6))
    insert(q, mkTask("Task9", 8))
    insert(q, mkTask("Task10", 0))



    t = frontMax(q)
    print("Highest priority task is", t.name, "with priority",t.priority)
    t = backMin(q)
    print("Lowest priority task is", t.name, "with priority", t.priority)
    while not emptyQueue(q):
        t = frontMax(q)
        print(t.priority)
        removeMax(q)
#test()
