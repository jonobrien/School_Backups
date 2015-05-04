"""
Author: Jon O'Brien
Week 2 Lab - Spelling with Turtle
This program uses the Turtle module to draw the CSCI acronym as: "CSci" and contains
test funcitons to change the scale and adjust the window size along the same integer, as well as drawing a '?'
in place of a letter not contained in the letter_library.py file.

"""

import turtle
import math
import letter_library

turtle.hideturtle()

def initBannerCanvas( numChars , numLines, scale ):
    """
    Set up the drawing canvas to draw a banner numChars wide and numLines high.
    The coordinate system used assumes all characters are 20x20 and there
    are 10-point spaces between them.
    Precondition: The initial canvas is default size, then input by the first
    two user inputs, every input after that defines each letter's scale, probably between
    1 and 3 for the scale values to have the window visible on the screen.
    Postcondition: The turtle's starting position is at the bottom left
    corner of where the first character should be displayed, the letters are printed.
    """
    scale = int(input("scale, integer please"))
    
    # This setup function uses pixels for dimensions.
    # It creates the visible size of the canvas.
    canvas_height = 80 * numLines *scale
    canvas_width = 80 * numChars *scale
    turtle.setup( canvas_width *scale, canvas_height *scale)

    # This setup function establishes the coordinate system the
    # program perceives. It is set to match the planned number
    # of characters.
    height = 30 *scale
    width = 30 * numChars *scale
    margin = 5 # Add a bit to remove the problem with window decorations.
    turtle.setworldcoordinates(
        -margin+1 * scale, -margin+1 * scale, width + margin* scale, numLines*height + margin * scale)

    turtle.reset()
    turtle.up()
    turtle.setheading( 90 )
    turtle.forward( ( numLines - 1 ) * 30 )
    turtle.right( 90 )
    turtle.pensize( 1  *scale)


def main():
    """makes the canvas and the turtle graphic print-out of CSci in a single line banner."""
    turtle.hideturtle()
    scale = int(input("scale, integer please"))
    
    initBannerCanvas( 4 , 1, 1)

    letter_library.drawLetter( "C", 2 )
    
    letter_library.drawLetter( "S", 2 ) # when run, there are user inputs asked for,
    
    letter_library.drawLetter( "c", 2 ) # canvas and then for the letters.
    
    letter_library.drawLetter( "i", 2 )
    


def testScale():
    """entering an integer will scale the window and the letter requested below."""
    initBannerCanvas(1, 1, 2)
    
    letter_library.drawLetter( "I", 2 ) # first user input is for canvas and for the letter.


def testUnknownLetter():
    """calls for an 'a' to be drawn, prints that this is not possible, will be replaced with a "?" """
    
    initBannerCanvas(1, 1, 1)
    
    print("This letter is not available, a '?' will replace it.")

    letter_library.drawLetter( "a", 1)
    

#testUnknownLetter()
#testScale()
main()

