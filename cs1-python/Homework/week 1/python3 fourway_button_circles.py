"""
file: python3 fourway_button.py
author: Jonathan Virgil O'Brien
Date: 8/26/13
"""


from turtle import *

hideturtle()        # hides the turtle, making it invisible while drawing


def triangle():

    """draws the triangles which surround the interior circle"""

    turtle.up()           # lifts pen for movement to a new position
    turtle.forward(50)    # moves the turtle to start a new triangle
    turtle.down()         # puts the turtle down for drawing a line
    turtle.right(270)     #turns the turtle to draw a side of the triangle
    turtle.forward(40)    # makes first side
    turtle.right(115)
    turtle.forward(50)    # makes second side
    turtle.right(132)
    turtle.forward(50)    # makes third side
    turtle.up() 
    turtle.home()         # returns turtle to starting/default position


def circles():
    """ makes the circles for the fourway button"""
    turtle.circle(20)     # makes the smaller, inner circle
    up()
    right(90)
    forward(100)
    left(90)
    down()
    circle(120)           # makes the larger, outer circle
    up()

def main():
    """runs the circles function and returns the turtle to the default
    position"""
    circles()
    turtle.home()
    

main()
    
triangle()                # draws the right triangle


left(90)
forward(40)      # these movements reposition turtle for left triangle
up()
left(90)


triangle()                # draws the left triangle


forward(20)
left(90)         # these movements reposition the turtle for the top triangle
forward(20)

triangle()              # draws the top triangle

backward(20)
right(90)      # these movements reposition the turtle for the bottom triangle
backward(20)

triangle()              # draws the bottom triangle




input("Mission accomplished, press enter please.")
turtle.bye
