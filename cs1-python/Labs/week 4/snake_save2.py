from turtle import *
import math
import random

MAX_SEGMENTS = 500

SEGMENT_LENGTH = 20
SEGMENT_THICKNESS = 10
SEGMENT_ANGLE = 30

def BOUNDING_BOX():
    """
    This function defines the bounding box length and is used in the creation and
    detection of the box.
    """
    
    return 200


hideturtle()

def drawBox():
    """
    This function draws the bounding box with dimensions of 200x200.
    preconditions: pen is down, facing east.
    postconditions: pen is down, facing east.
    """
    up()
    goto(0,0)
    fd(100)
    down()
    lt(90)
    fd(100)
    lt(90)
    fd(200)
    lt(90)
    fd(200)
    lt(90)
    fd(200)
    lt(90)
    fd(100)
    up()
    goto(0,0)
    rt(90)
    down()


def drawSnakeRec(segment): 
    """
    This function recursively draws the snake at a random heading with a random pencolor.
    When the pen reaches the bounding box, it turns around and starts forward again.  The
    function uses user input for number of segments between 0 and 500, and a random color
    for the pen and a random size for the pen are chosen for each segment.  The pen goes
    forward and turns left for each segment, unless the bounding box is detected, then it
    turns around and continues onward.

    preconditions: turtle is down, facing east, with a black color, inside the bounding box.
    postconditions: turlte is down, facing a random diection, with a random color,
                      inside the bounding box.
    """
    
    if segment == 0:
        return 0
    else:
        length = random.randint(1, SEGMENT_LENGTH)
        x,y = position()
        if x > BOUNDING_BOX() - 120:
            setheading(180)
        elif x < - BOUNDING_BOX() + 120:
            setheading(0)
        if y > BOUNDING_BOX() - 120:
            setheading(270)
        elif y < - BOUNDING_BOX() + 120:
            setheading(90)

        pensize(random.randint(1, SEGMENT_THICKNESS))
        pencolor(random.random(), random.random(), random.random())
        forward(random.randint(1, length))
        left(random.randint(-SEGMENT_ANGLE, SEGMENT_ANGLE))
        
        return length + drawSnakeRec(segment-1)


def drawSnakeIter(segment):
    """
    docstring

    This function uses a while loop to iteratively draw the snake at a random heading with
    a random pencolor.  When the pen reaches the bounding box, it turns around and starts
    forward again.  The function uses user input for number of segments between 0 and 500,
    and a random color for the pen and a random size for the pen are chosen for each segment.
    The pen goes forward and turns left for each segment, unless the bounding box is detected,
    then it turns around and continues onward.

    preconditions: turtle is down, facing east, with a black color, inside the bounding box.
    postconditions: turlte is down, facing a random diection, with a random color,
                      inside the bounding box.
    """
    totalLength = 0
    while (segment > 0):
        length = random.randint(1, SEGMENT_LENGTH)
        x,y = position()
        if x > BOUNDING_BOX() - 120:
            setheading(180)
        elif x < - BOUNDING_BOX() + 120:
            setheading(0)
        if y > BOUNDING_BOX() - 120:
            setheading(270)
        elif y < - BOUNDING_BOX() + 120:
            setheading(90)
        pensize(random.randint(1, SEGMENT_THICKNESS))
        pencolor(random.random(), random.random(), random.random())
        forward(random.randint(1, length))
        left(random.randint(-SEGMENT_ANGLE, SEGMENT_ANGLE))

        segment = segment-1
        totalLength = length + totalLength
    return totalLength

        
def main():
    """
    docstring
    """
    speed(0)
    drawBox()
    
    segment=int(input("Segments: (0-500): "))
    if segment >500 or segment < 0:
        print ("segments must be between 0 and 500 inclusive")
    totalLength = drawSnakeRec(segment)
    print ("the total length of the snake is:",(totalLength))
    input("enter for Iterative")
    
    reset()
    hideturtle()

    
    drawBox()
    segment=int(input("Segments: (0-500): "))
    if segment > 500 or segment < 0:
        print ("segments must be between 0 and 500 inclusive")
    totalLength = drawSnakeIter(segment)
    print ("the total length of the snake is:", (totalLength))
    bye()
    

main()
























##
##    
##def main():
##    drawBox()
##    segment=int(input("Segments: (0-500): "))
##    totalLength = drawSnakeIter(segment)
##    print ("the total length of the snake is:", (totalLength))
##
###main()


def boundingBox():
    if 2>1: #snake is near box
        pass #turn around
    else:
        pass#continue drawing


