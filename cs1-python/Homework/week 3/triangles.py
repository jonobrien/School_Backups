"""
Author: Jon O'Brien
Due Date: 9/14/13
Assignment: Triangles.py

This program uses recursion to draw several triangles atop each other.
There is the repetition of a single triangle function, modified over each new recursive step,
to output two new triangles that are at the edges, above and smaller the previous
triangles before it.

"""
import turtle
from turtle import *

depth = int(input("enter depth"))


def triangle(size, depth):
    """draws a triangle based on the default starting position of pen down,
    facing right, recursively repeating upwards with one triangle at each respective
    edge of the triangle below it.  Turtle moves to the starting position of the
    triangle above it, recursive calls are used to complete the program, main().
    
        Preconditions: pen is down, facing right, before the function runs.
        Postconditions: function runs and completes, pen is down, facing right,
        after the function runs."""

    
    if (depth < 1):
        pass
    else:
        lt(60)
        fd(size)
        rt(60)
        triangle(size/2,depth-1) #recursive calls for the triangle sides
        back(size)
        triangle(size/2,depth-1)
        rt(60)
        fd(size)
        lt(60)
        




def main():
    """runs the recursive function drawing the triangles.

    Preconditions: turtle module is imported and depth is defined.
    Postconditions: main() runs, triangles are drawn, program ends."""

    
    triangle(128, depth)
    
   

main()
