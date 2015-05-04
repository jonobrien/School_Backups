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

depth = int(input("enter depth"))


def triangle(size, depth):
    """draws a triangle based on the default starting position of pen down,
    facing right, recursively repeating upwards with one triangle at each respective
    edge of the triangle below it."""

    
    
    if (depth < 1):
        pass
    else:
        
        lt(60)
        fd(size)
        rt(60)
        triangle(size/2,depth-1)
        back(size)
        triangle(size/2,depth-1)
        rt(60)
        fd(size)
        lt(60)
        




def main():
    """runs the recursive function drawing the triangles."""

    
    triangle(128, depth)
    
   

main()
