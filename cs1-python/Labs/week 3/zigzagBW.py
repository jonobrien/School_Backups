"""
Author; Jon O'Brien
Due date: 9/17/13
lab: ZigZag - week 3
description: this program recursively draws zigzags using the turtle module.



"""


import turtle
from turtle import*


speed(0) # completes the function quickly


def Drawzigzag(size, depth):
    """the turtle module draws some zigzags and keeps the segments drawn at a fixed
    90 degree angle compared to the alternating 45 and 90 of the color program.
    There is a recursive call to draw each zigzag segment and the basecase prevents
    infinite recursion.
     
    pre-conditions:  The turtle is pen down,facing right.
    
    post-conditions: The turtle is pen down, facing right.

    """
    
    if (depth==0): # basecase
        return
    lt(90)
    fd(size/2) # initial zigzag
    rt(90)
    fd(size)

    Drawzigzag(size/2,depth-1) # recursive call
    
    back(size)
    lt(90)
    back(size)
    lt(90)
    fd(size)
    
    Drawzigzag(size/2, depth-1)
    
    back(size)
    rt(90)
    fd(size/2)
    rt(90)
    

def main():
    """calls for depth and then calls the Drawzigzag function and completes the drawing with recursion and the basecase.
    
    preconditions: nothing is drawn, the turtle is in default starting orientation and position.
    
    post-conditions: the drawing is complete and the turtle has returned to the default position.

    """

    depth=int(input("depth please."))
    
    Drawzigzag(100,depth) # calls the function to draw the required turtle drawing.

main()
