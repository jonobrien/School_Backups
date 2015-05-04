"""
Author: Jon O'Brien
Due Date: 9/21/13
Assignment: Spirograph.py
"""



from turtle import *
from math import *
speed(1)

R = 4    #int(input("The radius of the fixed circle"))
r = 100     #int(input("The radius of the moving circle"))
p = int(input("The offset of the pen point in the moving circle"))


#goto (0,0)
def spiro(radius, t=2*pi):
    
    if (p < 10 or p > 100):
        print("Incorrect value for p!")
        quit()

    if (radius == 0):
        pass
        #input("enter")
    
    else:

        x = (R-r)*math.cos(t) - (r+p)*math.cos((R-r)/r*t) # x - coordinate of pen position
        y = (R-r)*math.sin(t) - (r+p)*math.sin((R-r)/r*t) # y - coordinate of pen position
        up()
        goto(x,y)
        t = t - .01
        down()
        circle(100)
        circle(r, p)
        
        spiro(radius-1)


goto(0,0)
spiro(50, 2*pi)
        


