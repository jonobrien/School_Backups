""" 
file: style-example.py
language: python3
author: bks@cs.rit.edu ben k steele 
description: cs1 initial style recommendations example
"""

import turtle 


def drawLine() :
    """ draw a line in the current direction.
    """
    turtle.forward( 100 )

def getAnswer() :
    """ provide the answer to life, the universe and everything.
    """
    # look ma! no global variables!
    return 42

""" kilobyte constant for memory calculations """
KILOBYTE = 1024 


def test_drawLine() :
    """ 
    Test the drawLine() function and visually verify the drawing.
    First draw to the right, turtle's default heading.
    Next draw to the top. Next draw to the right.
    Then prompt user and wait for acknowledgement before calling
    bye() to close the graphics window.
    """
    drawLine()
    turtle.left( 90 ) 
    drawLine()
    turtle.right( 90 ) 
    drawLine()
    userResponse = input( "hit 'q' to quit: " )
    # if statement shows secondary indentation and multiple arguments.
    if userResponse != 'q' :
        print( 'you entered ', userResponse )
    turtle.bye() 

# # script execution/run
# the following condition checks whether we are
# running as a script, in which case run the test code.
# if the file is being imported, don't run the test code.

if __name__ == '__main__' :
    test_drawLine()
    print( getAnswer() )
    print( 2 * ( KILOBYTE + 1 ), 'is 2KB with 2 bytes to spare...' )
