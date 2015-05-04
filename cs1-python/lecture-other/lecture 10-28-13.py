def top(myStack):
    return myStack.data
    #if stack is empty, we'll allow program to fail, called raising an exception
    if myStack==None:
    raise indexError("some message") # rasie is a keyword, index error, is one error
    #some message is printed to display


def pop(myStack): #removes top element and returns modified stack
    #check for error
    if emptyStack(myStack):
        raise indexError("empty")
    return myStack.next #reference to next element in stack, moves on...


def push(myStack,el): #want to return new stack with updated elements
    #takes reference and points to new data
    newNode=mkNode(el,myStack) #need to return new top of stack
    return newNode


def emptyStack(myStack)#has to return boolean value and if empty, None, return True, false
    #respectively
    return myStack==None


def size(myStack):
    count=0
    while(not isinstance (myStack,noneNode):
          count=count+1
          myStack=myStack.next#continues as long as the node you are checking, is not the
          #last node because the last one is noneNode type

def sizeRec():
          if (instance(myStack,noneNode)):#instance or isinstance????
              return 0
          else:
              return 1+size(myStack.next


















































