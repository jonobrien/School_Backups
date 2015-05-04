"""
Author: Jon O'Brien
Date: 10/16/13
CS1 Midterm - Practical


This program takes the fibonacci sequence to draw the spiral requested inside of
the sequence of tiled boxes, which are a different color than the spiral itself.
"""

import turtle

def fib(n):
    """
    performs the fibonacci sequence which adds the two prvious terms together
    to make the third
    """
    if n == 1:
        return 1
    elif n ==0:
        return 0
    else:
        return fib(n-1) + fib(n-2)
    
print(fib(4))

def init(m):
    turtle.setup(600,600)
    setworldcoordinates(-2*m,-2*m,2*m,2*m)

def drawSquaresIter(n,depth=4):
    """
    draws the squares for the fibonacci spiral, the squares are iteratively drawn
    """
    turtle.pencolor("blue")
    if depth <= 0:
        return
    count = 4
    while count > 0:
        turtle.forward(fib(n-2))
        turtle.left(90)
        turtle.forward(fib(n-1))
        turtle.left(90)
        turtle.forward(fib(n-1))
        turtle.left(90)
        
        count -=1
        #print(count)

def drawSquaresRec(n,depth=4):
    if depth <= 0:
        return
    else:
        drawSquaresRec(n,depth-1)
        turtle.forward(fib(n-1))
        turtle.left(90)
        turtle.forward(fib(n-1))
        turtle.left(90)
        drawSquaresRec(n,depth-2)
        #print(depth)

def drawSpiral(n):
    turtle.pencolor("red")
    count = 4
    while count>0:
        turtle.circle(fib(n),45) 
        turtle.left(90)
        turtle.forward(fib(n-1)) #an attempt to move to the second larger square
        count-=1
        #print(count)
        


def main():
    n = int(input("enter number of times to spiral"))
    if n == 0: #a fibonacci spiral image using 0 terms should draw nothing.
        return
    #init(fib(n+3))
    turtle.goto(0,0)
    drawSquaresIter(n,depth=4)
    turtle.goto(0,0)
    drawSpiral(n)
    
    input("Hit Enter to Continue")
    turtle.reset()
    drawSquaresRec(n,depth=4)
    drawSpiral(n)
    input("Hit Enter to Quit")
    turtle.bye()
    
    
main()
