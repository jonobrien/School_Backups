from turtle import *
speed(0)
def drawTree ( segments , size ):
    """
    drawTree recursively draws the tree .
    segments -- NonNegInteger ;
    number of line segments from the base of the tree to
    the end of any branch should be integral and non - negative .
    size -- PosNumber ;
    length of tree " trunk " to draw should be ( strictly ) positive .
    5pre - conditions : segments >= 0 , size > 0.
    turtle is at base of tree ,
    turtle is facing along trunk of tree ,
    turtle is pen - down .
    post - conditions : a segments - level tree was drawn on the canvas ,
    turtle is at base of tree ,
    turtle is facing along trunk of tree ,
    turtle is pen - down .
    """
    if segments == 0:
    # base case : draw nothing
        pass
    else :
        # recursive case : draw trunk and two sub - trees
        forward ( size )
        left ( 45 )
        drawTree ( segments - 1 , size / 2 )
        right ( 90 ) # turn 45 degrees twice
        drawTree ( segments - 1 , size / 2 )
        left ( 45 )
        forward ( - size )
def initWorld ( size ):
    """
    initWorld initializes the drawing by establishing its pre - conditions .
    size -- PosNumber ;
    length of tree trunk to draw should be positive .
    pre - conditions :
    post - conditions : coordinate system
    is ( -2*| size | , -2*| size |) at lower - left
    to (2*| size | , 2*| size |) at upper - right .
    turtle is at origin ,
    turtle is facing North ,
    turtle is pen - down .
    """
    margin = 2 # provides canvas boundary
    setup ( 600 , 600 )
    setworldcoordinates ( -2* abs ( size ) - margin , -2* abs ( size ) - margin , \
    2* abs ( size ) + margin , 2* abs ( size ) + margin )
    home () # turtle is at origin , facing east , pen - down
    left ( 90 ) # turtle is facing North
    down () # turtle is pen - down
    pensize ( 2 )
def initWorldAndDrawTree ( segments , size ):
    """
    initWorldAndDrawTree prints a message , initializes the world ,
    draws an instance of the recursive tree , and waits for ENTER .
    segments -- NonNegInteger ;
    number of line segments from the base of the tree to
    6the end of any branch should be integral and non - negative .
    size -- PosNumber ;
    length of tree " trunk " to draw should be ( strictly ) positive .
    message -- String ;
    message to display
    """
    print ( " Drawing recursive tree with " , ( segments , size ))
    initWorld ( size )
    drawTree ( segments , size )
    update ()
    input ( " Hit ENTER to quit ." )
    bye ()
initWorldAndDrawTree ( 5,10 )

