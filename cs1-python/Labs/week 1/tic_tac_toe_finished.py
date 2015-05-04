"""
file: tic_tac_toe.py
author: Jonathan Virgil O'Brien
Date: 9/1/13
Description: This python code draws a tic-tac-toe board with a 'valid' game
               sequence.  It draws the required image through reused functions
               for the X's and O's, the grid is completed in one function.  First
               the grid is drawn, then the bottom left 'X' and middle right 'O'
               then top middle 'X' then top left 'O' then bottom middle 'X' then
               the bottom right 'O' and finally the middle 'X.'

               The code was tested after finishing a function.  I wrote the function
               for the grid, had it pause after every couple of steps, and adjusted any
               steps if necessary.  I tested the 'X' and 'O' functions in the same manner,
               due to having a default starting point of the origin, all I had to do was
               move the turtle's pen to the default cell position and the functions would
               work as expected, this makes the code highly adjustable, and can be moved around
               to adjust for changes to the code.  A simple up, down, left or right was all that
               was needed to adjust the drawing position for each new blank cell for the
               tic-tac-toe board.  There may be some redundant up() commands in the code.



"""


import turtle
from turtle import *

turtle.hideturtle()  # hides the pen from view

def grid():
    """this function draws the grid lines for the tic-tac-toe board"""
    up()
    right(90)
    forward(65)  # moves the turtle down to start the grid
    left(90)
    forward(30)  # moves the turtle over to position for the vertical lines
    down()
    left(90)
    forward(180) # draws the first grid
    up()
    left(90)
    forward(60)  # moves for the second vertical line
    down()
    left(90)
    forward(180) # draws the second line
    left(90)
    up()
    forward(120) # moves over the the bottom right of the imaginary square around
                 # the tic-tac-toe board
    left(90)
    forward(60)  # moves the turtle to the position for the horizontal lines
    left(90)
    down()
    forward(180) # draws the first horizontal
    up()
    right(90)
    forward(60)  # moves up for the second horizontal
    down()
    right(90)
    forward(180) # draws the second horizontal
    up()
    turtle.home()
    
grid() # draws the grid


def draw_X():
    """this function draws an 'x' in the center of the white cell of the board"""
    
    up()
    forward(25)
    left(135)
    down()
    forward(71) # draws the first part of the 'X'
    up()
    right(135)
    forward(50) # moves the pen to second position for the 'X'
    right(135)
    down()
    forward(71) # draws the second part of the 'X'
    up()
    turtle.home()

def draw_O():
    """this function draws an 'o' in the center of the white cell of the board"""
    down()
    circle(25) # draws the 'O' for the cell
    up()
    turtle.home()
    

backward(60)
right(90)
forward(60) 
left(90)
draw_X()  # the 'X' for the bottom left

forward(60)
draw_O() # the 'O' in the middle right

left(90)
forward(60)
right(90)
draw_X()   # the 'X' in the top middle

left(90)
forward(60)
left(90)
forward(60)
left(180)
draw_O()   # the 'O' in the top left

right(90)
forward(60)
left(90)
draw_X() # the 'X' in the bottom middle

right(90)
forward(60)
left(90)
forward(60)
draw_O() # the 'O' in the bottom right

draw_X() # the final 'X' in the middle


input("Mission accomplished, please press enter.")
turtle.bye
