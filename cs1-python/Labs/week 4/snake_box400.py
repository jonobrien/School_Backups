"""
Author: Jon O'Brien
Date due: 9/24/13
Lab: week 4 - snake.py

This program utilizes the turtle and random modules to draw randomized snakes inside
of a 400x400 bounding box.  There are two snakes, one recursive and one iterative that draw
the snake insoe the bounding box.  If a segment number is entered outside the range,
the turtle graphic window closes and the program exits.  The total length of the snake is
accumulated over the running of each draw function and is output at the completion of the function.

"""


from turtle import *
import random

MAX_SEGMENTS = 500
SEGMENT_LENGTH = 20
SEGMENT_THICKNESS = 10  # The constants used in the program.
SEGMENT_ANGLE = 30

def BOUNDING_BOX():
    """
    This function defines the bounding box length and is used in the creation and
    detection of the box.
    """
    
    return 200


hideturtle() #hides the turtle to not interfere with the program.

def drawBox():
    """
    This function draws the bounding box with dimensions of 400x400.
    preconditions: pen is down, facing east.
    postconditions: pen is down, facing east.
    """
    up()
    goto(0,0)
    fd(200)
    down()
    lt(90)
    fd(200)
    lt(90)
    fd(400)
    lt(90)
    fd(400)  # steps used to create the bounding box's visible boundary
    lt(90)
    fd(400)
    lt(90)
    fd(200)
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
        if x > BOUNDING_BOX() - 25:
            setheading(180)
        elif x < - BOUNDING_BOX() + 25:    # if/elif statements defining the
            setheading(0)                   # bounding box detection.
        if y > BOUNDING_BOX() - 25:
            setheading(270)
        elif y < - BOUNDING_BOX() + 25:
            setheading(90)

        pensize(random.randint(1, SEGMENT_THICKNESS))
        pencolor(random.random(), random.random(), random.random())
        forward(random.randint(1, length))
        left(random.randint(-SEGMENT_ANGLE, SEGMENT_ANGLE))
        
        return length + drawSnakeRec(segment-1)


def drawSnakeIter(segment):
    """
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
        if x > BOUNDING_BOX() - 25:
            setheading(180)
        elif x < - BOUNDING_BOX() + 25:  # if/elif statements defining the
            setheading(0)                 # bounding box detection.
        if y > BOUNDING_BOX() - 25:
            setheading(270)
        elif y < - BOUNDING_BOX() + 25:
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
    Main defines the speed of the turtle, draws the bounding box, asks
    for user input for the number of segments to be draws for the recursive
    or iterative function, and prints an error if a number outside the range
    between 0 and 500 is entered, pauses and resets between drawing each snake, and
    closes the window when completed.


    """
    
    segment=int(input("Segments (0-500): "))
    if segment > 500 or segment < 0:
        print ("segments must be between 0 and 500 inclusive")
        bye()
        
    else:
        speed(0)
        drawBox()
        totalLength = drawSnakeRec(segment)
        print ("the total length of the snake is:",(totalLength))
        input("enter for Iterative")
        
        reset()
        hideturtle()  # resets and rehides the turtle for the iterative call

    
        
        segment=int(input("Segments (0-500): "))
        if segment > 500 or segment < 0:
            print ("segments must be between 0 and 500 inclusive")
            bye()
            
        else:
            speed(0)
            drawBox()
            totalLength = drawSnakeIter(segment)
            print ("the total length of the snake is:", (totalLength))
            bye()
    

main() # calls main() to complete the program.






