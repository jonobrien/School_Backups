from turtle import *
import math
import random

MAX_SEGMENTS = 500

SEGMENT_LENGTH = 20
SEGMENT_THICKNESS = 10
SEGMENT_ANGLE = 30
hideturtle()


def BOUNDING_BOX():
    return 200



def drawBox():
    """
    docstring
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
    down()


def drawSnakeRec(segment): 
    """
    docstring
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
        #if statements about being close to box coordinates
        forward(random.randint(1, length))
        left(random.randint(-SEGMENT_ANGLE, SEGMENT_ANGLE))
        
        return length + drawSnakeRec(segment-1)


def drawSnakeIter(segment):
    """
    docstring
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

    speed(0)
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


