"""
A collection of functions that draw Latin letters with the turtle
August 2013
James Heliotis


Modified by Jon O'Brien
9/9/13
Week 2 Lab - Spelling with Turtle
"""

import turtle


def drawLetter( letter , scale):
    turtle.hideturtle()
    
    if letter == " ":
        space()
    elif letter == "?":
        questionMark()
    elif letter == "i":
        i_lc()
    elif letter == "I":
        i_uc()
    elif letter == "s":
        s_lc()
    elif letter == "S":
        s_uc()
    elif letter == "a":
        questionmark()
    elif letter == "C":
        c_uc()
    elif letter == "c":
        c_lc()
    

def space():
    turtle.forward( 30 )

def questionMark():
    """ Draw a question mark.
    """
    scale = int(input("scale, integer please"))
    
    turtle.forward( 10 *scale)
    turtle.down()
    turtle.left( 90 )
    turtle.forward( 2 *scale)
    turtle.up()
    turtle.forward( 3 *scale)
    turtle.down()
    turtle.forward( 5 *scale)
    turtle.right( 90 )
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.left( 90 )
    turtle.forward( 5 *scale)
    turtle.up()
    turtle.forward( 15 *scale)
    turtle.left( 90 )
    turtle.forward ( 30 *scale)


def i_uc():
    """ Draw an upper case I.
    """
    scale = int(input("scale, integer please"))
    
    turtle.down()
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.left( 90 )
    turtle.forward( 10 *scale)
    turtle.left( 180 )
    turtle.forward( 20 *scale)
    turtle.left( 180 )
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.left( 90 )
    turtle.forward( 10 *scale)
    turtle.up()
    turtle.forward( 5 *scale)


def i_lc():
    """ Draw a lower case i.
    """
    scale = int(input("scale, integer please"))
    
    turtle.forward( 10 *scale)
    turtle.down()
    turtle.left( 90 )
    turtle.forward( 11 *scale)
    turtle.up()
    turtle.forward( 2 *scale)
    turtle.down()
    turtle.forward( 2 *scale)
    turtle.up()
    turtle.right( 180 )
    turtle.forward( 15 *scale)
    turtle.left( 90 )
    turtle.forward( 10 *scale)


def s_uc():
    """ Draw an upper case S.
    """
    scale = int(input("scale, integer please"))
    
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.right( 90 )
    turtle.forward( 20 *scale)
    turtle.right( 180 )
    turtle.down()
    turtle.forward( 20 *scale)
    turtle.left( 90 )
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.right( 90 )
    turtle.forward( 10 *scale)
    turtle.right( 90 )
    turtle.forward( 20 *scale)
    turtle.left( 180 )
    turtle.up()
    turtle.forward( 30 *scale)


def s_lc():
    """ Draw a lower case s.
    """
    scale = int(input("scale, integer please"))
    
    turtle.down()
    turtle.forward( 20 *scale)
    turtle.left( 90 )
    turtle.forward( 5 *scale)
    turtle.left( 90 )
    turtle.forward( 20 *scale)
    turtle.right( 90 )
    turtle.forward( 5 *scale)
    turtle.right( 90 )
    turtle.forward( 20 *scale)
    turtle.up()
    turtle.right( 90 )
    turtle.forward( 10 *scale)
    turtle.left( 90 )
    turtle.forward( 5 *scale)


def c_uc():
    """draw an uppercase C.
    """
    scale = int(input("scale, integer please"))
    
    turtle.down()
    turtle.forward(20 *scale)
    turtle.left(90)
    turtle.up()
    turtle.forward(20 *scale)
    turtle.left(90)
    turtle.down()
    turtle.forward(20 *scale)
    turtle.left(90)
    turtle.forward(20 *scale)
    turtle.left(90)
    turtle.up()
    turtle.forward(30 *scale)

    
def c_lc():
    """draw a lowercase c.
    """
    scale = int(input("scale, integer please"))

    
    turtle.down()
    turtle.forward(10 *scale)
    turtle.left(90)
    turtle.up()
    turtle.forward(10 *scale)
    turtle.left(90)
    turtle.down()
    turtle.forward(10 *scale)
    turtle.left(90)
    turtle.forward(10 *scale)
    turtle.left(90)
    turtle.up()
    turtle.forward(20 *scale)

def questionmark():
    """ letter is unavailable, therefore draw a question mark.
    """

    scale = int(input("scale, integer please"))
    
    questionMark()


