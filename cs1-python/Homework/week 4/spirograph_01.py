"""
Author: Jon O'Brien
Due Date: 9/21/13
Assignment: Spirograph.py
"""



from turtle import *
import math
speed(2)

R = 100    #int(input("The radius of the fixed circle"))
r = 75     #int(input("The radius of the moving circle"))
p = 20     #int(input("The offset of the pen point in the moving circle"))



def spiro(radius):
    Pi=3.14
    circle(R)
    up()
    if (radius == 0):
        pass
        
    else:
        t=2*Pi
        x = (R-r)*math.cos(t) - (r+p)*math.cos((R-r)/r*t) # x - coordinate of pen position
        y = (R-r)*math.sin(t) - (r+p)*math.sin((R-r)/r*t) # y - coordinate of pen position
        up()
        goto(x,y)
        down()
        circle(r, p)
        spiro(radius-1)



spiro(25)
        
