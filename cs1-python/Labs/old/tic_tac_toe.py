"""
author: Jonathan O'Brien
date:8/30/13
"""



from turtle import *

turtle.hideturtle()

def grid():
    """this function draws the grid lines for the tic-tac-toe board"""
    up()
    right(90)
    forward(65) #moves the turtle down to start the grid
    left(90)
    forward(30) #moves the turtle over to position for the vertical lines
    down()
    left(90)
    forward(180) #draws the first grid
    up()
    left(90)
    forward(60) # moves for the second vertical line
    down()
    left(90)
    forward(180) #draws the second line
    left(90)
    up()
    forward(120) #moves over the the bottom right of the imaginary square around
                 #the tic-tac-toe board
    left(90)
    forward(60)  #moves the turtle to the position for the horizontal lines
    left(90)
    down()
    forward(180) #draws the first horizontal
    up()
    right(90)
    forward(60)  #moves up for the second horizontal
    down()
    right(90)
    forward(180)
    up()
    turtle.home()
    
grid()


def draw_X():
    """this function draws an 'x' in the center of the white cell of the board"""
    
    up()
    forward(25)
    left(135)
    down()
    forward(71)
    up()
    right(135)
    forward(50)
    right(135)
    down()
    forward(71)
    up()
    turtle.home()

def draw_O():
    """this function draws an 'o' in the center of the white cell of the board"""
    down()
    circle(25)
    up()
    turtle.home()
    

backward(60)
right(90)
forward(60) 
left(90)
draw_X()  # the 'x' for the bottom right


forward(60)
draw_O() # the 'o' in the middle right


left(90)
forward(60)
right(90)
draw_X()   # the 'x' in the top middle

left(90)
forward(60)
left(90)
forward(60)
left(180)
draw_O()   # the 'o' in the top left

right(90)
forward(60)
left(90)
draw_X()

right(90)
forward(60)
left(90)
forward(60)
draw_O()

draw_X()


















input("enter")
turtle.bye
