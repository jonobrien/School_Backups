"""
A program that draws letters on a canvas using the turtle package

August 2013
James Heliotis
"""

import turtle
import math
import letter_library

scale = 2

def initBannerCanvas( numChars, numLines ):
    """
    Set up the drawing canvas to draw a banner numChars wide and numLines high.
    The coordinate system used assumes all characters are 20x20 and there
    are 10-point spaces between them.
    Postcondition: The turtle's starting position is at the bottom left
    corner of where the first character should be displayed.
    """
    # This setup function uses pixels for dimensions.
    # It creates the visible size of the canvas.
    canvas_height = 80 * numLines *scale
    canvas_width = 80 * numChars *scale
    turtle.setup( canvas_width *scale, canvas_height )

    # This setup function establishes the coordinate system the
    # program perceives. It is set to match the planned number
    # of characters.
    height = 30 
    width = 30 * numChars 
    margin = 5 # Add a bit to remove the problem with window decorations.
    turtle.setworldcoordinates(
        -margin+1, -margin+1, width + margin, numLines*height + margin )

    turtle.reset()
    turtle.up()
    turtle.setheading( 90 )
    turtle.forward( ( numLines - 1 ) * 30 )
    turtle.right( 90 )
    turtle.pensize( 2  *scale)


def main():
    
    initBannerCanvas( 2 , 2)
    letter_library.drawLetter( "C" )
    letter_library.drawLetter( "S" )
    letter_library.drawLetter( "c" )
    letter_library.drawLetter( "i" )
    
    input( "enter. " )



main()



#scale = int(input("size wanted"))

