"""
file: fourway_button.py
author: Jonathan Virgil O'Brien
Date: 8/26/13
Description: this python program (script?) uses the turtle module to draw
               an inner cirle surrounded by 4 triangles and an outer circle
               this creates the "fourway button" that is desired

"""

import turtle


turtle.hideturtle()        # hides the turtle, making it invisible while drawing


def triangle():

    """draws a triangle which surrounds the interior circle
    repeated to draw all four around the interior circle"""

    turtle.up()           # lifts turtle for movement to a new position
    turtle.forward(50)    # moves the turtle to start a new triangle
    turtle.down()         # puts the turtle down for drawing a line
    turtle.right(270)     # turns the turtle clockwise
    turtle.forward(40)    # draws first side
    turtle.right(115)
    turtle.forward(50)    # draws second side
    turtle.right(132)
    turtle.forward(50)    # draws third side
    turtle.up() 
    turtle.home()         # returns turtle to starting/default position


def circles():
    """ makes the circles for the fourway button"""
    
    turtle.circle(20)     # draws the smaller, inner circle
    turtle.up()
    turtle.right(90)
    turtle.forward(100)
    turtle.left(90)       # rotates the turtle counter clockwise
    turtle.down()
    turtle.circle(120)    # draws the larger, outer circle
    turtle.up()

def main():
    """runs the circles function and returns the turtle to the default
    position"""
    
    circles()
    turtle.home()
    

main()


    
triangle()                # draws the right triangle



turtle.left(90)
turtle.forward(40)        # these movements reposition turtle for left triangle
turtle.up()
turtle.left(90)

triangle()                # draws the left triangle



turtle.forward(20)
turtle.left(90)           # these movements reposition the turtle for the top triangle
turtle.forward(20)

triangle()                # draws the top triangle



turtle.backward(20)
turtle.right(90)          # these movements reposition the turtle for the bottom triangle
turtle.backward(20)

triangle()                # draws the bottom triangle



input("Mission accomplished, press enter please.")
turtle.bye
