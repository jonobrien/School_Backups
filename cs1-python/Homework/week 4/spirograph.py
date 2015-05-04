"""
Author: Jon O'Brien
Due Date: 9/21/13
Assignment: Spirograph.py
"""



from turtle import *
import math

speed(0)



def spiro(p):
    """This function runs a while loop that draws the spirals that creates the image
    of the spirograph.  This function defines variables used in the x and y equations
    for the coordinates of (x,y) that the turtle pen moves to when iterating between
    0 and 2pi for t.

    preconditions:  The turtle is down, facing east.
    post conditions: Tue turtle is down, in a new coordinate position, facing east
    """
    
    t=0
    r = 4       #int(input("The radius of the fixed circle"))
    R = 100     #int(input("The radius of the moving circle"))

    if t>2*math.pi:
        pass

    while(t < 2*math.pi):
        t = t +.01

        x = (R-r)*math.cos(t) - (r+p)*math.cos((R-r)/r*t) # x - coordinate of pen position
        y = (R-r)*math.sin(t) - (r+p)*math.sin((R-r)/r*t) # y - coordinate of pen position
        
        
        goto(x,y)
        
        


def start():
    """This function uses an if/else statement to define the p term and calls the spiro function to create the spirograph.

    preconditions: the turtle is down, facing east.
    postconditions: the turtle is moving between new (x,y) coordinates in the spiro function."""
    
    p = int(input("The offset of the pen point in the moving circle"))
    if (p < 10 or p > 100):
        print("Incorrect value for p!")


    else:
        r = 4       #int(input("The radius of the fixed circle"))
        R = 100     #int(input("The radius of the moving circle"))

        t=0
        x = (R-r)*math.cos(t) - (r+p)*math.cos((R-r)/r*t) # x - coordinate of pen position
        y = (R-r)*math.sin(t) - (r+p)*math.sin((R-r)/r*t) # y - coordinate of pen position
        up()
        goto(x,y)
        down()
        spiro(p)


        
        
        
        

def main():
    """runs the two functions to create the spirograph"""
    
    start()
    input("hit enter to close...")
    bye()


main()

