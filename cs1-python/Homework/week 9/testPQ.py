from myPriorityQueue import *
import task #fixed
q=mkPriorityQueue()
insert(q,mkTask("Task1",5))
insert(q,mkTask("Task2",7))
t=frontMax(q) #fixed
print("Highest priority task is",t.name,"with priority",t.priority)
t=backMin(q)
print("Lowest priority task is",t.name,"with priority",t.priority)
while not emptyQueue(q):
    t=frontMax(q)
    removeMax(q)
