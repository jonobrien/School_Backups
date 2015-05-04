"""
A collection of functions that draw Latin letters with the turtle

August 2013
James Heliotis
"""

import turtle

def drawLetter( letter ):
    if letter == " ":
        space()
    elif letter == "i":
        i_lc()
    elif letter == "I":
        i_uc()
    elif letter == "s":
        s_lc()
    elif letter == "S":
        s_uc()

def space():
    turtle.forward( 30 )

def questionMark(:
    """ Draw a question mark.
    """
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
    turtle.forward( 10 *scale)

def i_lc():
    """ Draw a lower case i.
    """
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
    turtle.forward( 20 *scale)

def s_uc():
    """ Draw an upper case S.
    """
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
    turtle.forward( 10 *scale)


