"""
Author: Jon O'Brien
Date: 9/10/13
Assignment: Triangles.py

This program uses recursion to draw several triangles atop each other, similar to a fractal.
There is the repetition of a single triangle function, modified over each new recursive step,
to output two new triangles that are at the edges, above and smaller than the previous
triangles before it.

"""
import turtle
from turtle import *
speed(3)


def triangle(size, depth):
    """this draws a triangle based on the input parameter of 'size,' based on
    the default starting position of the turtle facing right, pen down"""
    
    if depth==0:
        
        turtle.forward(size)
        turtle.left(120)
        turtle.forward(size)
        turtle.left(120)
        turtle.forward(size)
    


def triangle2(size,depth):
    """draws a triangle based on the default starting position of pen down,
    facing right, recursively repeating upwards with one triangle at each respective
    edge of the triangle below it."""

    if depth==0:
        print("zero")
        quit()
    else:
        
        turtle.down()
        turtle.left(60)
        triangle(size,depth-1) #draws the triangle for depth=1
        turtle.left(120)
        turtle.forward(size)
        triangle(size/2, depth-1) #draws the first triangle for depth=2
        rt(120)
        fd(size)
        rt(120)
        triangle(size/2,depth-1) #finishes depth=2
        left(120)
        fd(size/2)
        triangle(size/4,depth-1) #starts left side, depth=3
        rt(120)
        fd(size/2)
        rt(120)
        triangle(size/4,depth-1) #finishes left side, depth=3
        fd(size/2)
        lt(60)
        fd(size)
        lt(60)
        fd(size/2)
        triangle(size/4,depth-1) #starts right side, depth=3
        rt(120)
        fd(size/2)
        rt(120)
        triangle(size/4,depth-1) #finishes right side, depth=3
        fd(size/2)
        #still need depth 4
    

def main():
    
    triangle2(100, 1)
    
   

main()
