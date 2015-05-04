"""
file: python3 fourway_button.py
author: Jonathan Virgil O'Brien
Date: 8/26/13
"""

import turtle
from turtle import *

turtle.hideturtle()       #hides the turtle, making it invisible while drawing
turtle.circle(20)

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
    

triangle()                # draws the right triangle


turtle.home()             # returns turtle to starting/default position for left triangle

left(90)
forward(40) # these movements reposition turtle for next triangle
up()
left(90)


triangle()                # draws the left triangle

turtle.home()



forward(20)
left(90)
forward(20)


triangle()

turtle.home() # returns turtle to starting/default position for bottom triangle

backward(20)
right(90)
backward(20)
triangle()

turtle.home()

input("enter")

right(90)
forward(100)
left(90)
turtle.down()
circle(120)

"""

down()

triangle()

triangle()
turtle.home()
left(180)
forward(50)
down()
triangle()

"""



input("Mission accomplished, press enter please.")
turtle.bye
