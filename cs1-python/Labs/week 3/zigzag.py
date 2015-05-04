"""
Author: Jon O'Brien
Due Date 9/17/13
Lab: ZigZag - week 3
Description:  This program recursively draws zigzags with alternating green
                and red crosses, and alternating 45 and 90 degree angles for the segments.

"""



import turtle
from turtle import*

speed(0)  # makes the program complete quickly


def Drawzigzag(size, depth):
    """the turtle module draws some zigzags and rotates them at alternating
    45 and 90 degree angles.  The color of the zigzag is chosen by an if statement
    that is repeated after the recursive call.  There is an if statement
    basecase that prevents the program for continuing recursively
    to infinity.  

    pre-conditions:  The turtle is pen down,facing right.
    
    post-conditions: The turtle is pen down, facing right.

    """
    

    
    
    if (depth==0):  # basecase
        return
    else:
        
        if (depth%2==1):   # odd
            turtle.pencolor("red")
        else:    # even
            pencolor("green")
    
        lt(90)
        fd(size/2)
        rt(90)      # draws the initial zigzag
        fd(size)
        lt(45)
    
        Drawzigzag(size/2,depth-1) # recursive call

        if (depth%2==1):   # odd
            turtle.pencolor("red")
        else:    # even
            pencolor("green")
        
        rt(45)
        back(size)
        rt(90)
        fd(size)
        rt(90)
        fd(size)
        lt(45)
        Drawzigzag(size/2, depth-1)
    
        if (depth%2==1):      # odd
            turtle.pencolor("red")
        else:     # even 
            pencolor("green")
    
        rt(45)
        back(size)
        rt(90)
        fd(size/2)
        rt(90)



def main():
    """calls for depth and then calls the Drawzigzag function and completes the drawing with color and
    tilted segments.
    
    preconditions: nothing is drawn, the turtle is in default starting orientation and position.
    
    post-conditions: the drawing is complete and the turtle has returned to the default position.

    """
    depth = int(input("depth please."))
    
    Drawzigzag(100, depth) # calls te function to draw the required turtle drawing.

main()
