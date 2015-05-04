from myNode import *
class myList():
    #encapsulates our list
    __slots__=('head','size')

def mkMyList():
    #make empty list
    lst=myList()
    lst.head=mkEmptyNode()
    lst.size=0
    return lst
#append to our list recursively

def append(lst,value):
    #special case is list is empty
    if(isinstance(lst.head,EmptyNode)):#allowa us to compare an object and see if
        newnode=mkNode(value,mkEmptyNode())  #it is a certain type or not
        lst.head=newnode #reassigns head after making a node
        lst.size +=1
    else:
        appendRec(lst.head,value)
        lst.size +=1

def appendRec(node,value):
    if(isinstance(node.next,EmptyNode)):
        newnode=mkNode(value,mkEmptyNode()) #points to next of NN
        node.next=newnode # connects to data set, then march to next node
    else:
        appendRec(node.next,value)

def toString(lst): #from code online maybe.....
    pass

def appendIter(lst,value):
    if(isinstance(lst.head,EmptyNode)):
        newnode=mkNode(value,mkEmptyNode)
        lst.head=newnode
        lst.size+=1
    else:
        cur=lst.head
        while(isinstance(cur.next,EmptyNode)):
            cur=cur.next
        newnode=mkNode(value,mkEmptyNode())
        cur.next=newnode#connect to to the newly created node being input
        lst.size+=1
        
def insert(lst,value,idx): #insert value into arbitrary location
    #error checking
    if (idx<0 or idx>lst.size):
        raise ValueError("index out of range")




def testAppend():
    lst=mkMyList()
    for i in range(4):
        append(lst,i)
        
    
