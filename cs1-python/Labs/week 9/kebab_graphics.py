'''
Everything needed to do the graphical Shishkabob.  This is a 
fully object oriented class with a constructor and methods,
utilizing the 'self' concept for the instance name.

Author: Sean Strout
Author: James Heliotis
Author: Jon O'Brien
'''
from graphics import GraphWin, Line, Point, Circle, Rectangle

"""This dictionary maps food items (string), to colors (string)"""
Colors = { \
    "Beef": "brown",        \
    "Chicken": "yellow",    \
    "Onion": "grey",        \
    "Pepper": "green",      \
    "Tomato": "red"         \
}


# global constants for drawing
WIN_HEIGHT = 1
WIN_LOW_LEFT_X = -1
WIN_LOW_LEFT_Y = 0
WIN_UP_RIGHT_Y = WIN_LOW_LEFT_Y + WIN_HEIGHT
LINE_THICKNESS = 2
FOOD_WIDTH = 1
SKEWER_HANDLE_RADIUS = 0.1
BKGD_COLOR = "white"


class SkewerUI(object):
    """
    Class: SkewerUI
    Description: A graphical display for the Skewer. It displays
        the items in on the skewer graphically, as they are added,
        removed and shifted around by the various commands.
    """

    __slots__ = ( 
        'win',          # the graphical window
        'items'         # the list of food items (strings) from top to bottom
    )

    def __init__( self, N ):
        """
        Create the SkewerUI.
        Arguments:
            self - the SkewerUI being created
            N - the capacity of the skewer (for the window size)
        """
        
        # create the window
        self.createWindow( N ) # (Sets value of win attribute.)
        self.items = []
    
    def close(self):
        """
        On destruction, close the graphical window.
        Arguments:
          self - the SkewerUI being created
        """
        
        self.win.close()
    
    def createWindow(self, N):
        """
        Create the graphics window.
        Arguments:
            self - the SkewerUI instance
            N - the capacity of the skewer
        """
        self.win = GraphWin("Shish Kebab", 800, 200)
        self.win.setCoords( \
            WIN_LOW_LEFT_X, \
            WIN_LOW_LEFT_Y - 0.1, \
            WIN_LOW_LEFT_X+(N+1)*FOOD_WIDTH, \
            WIN_UP_RIGHT_Y + 0.1 \
        )
        
        # draw skewer
        line = Line( \
            Point(WIN_LOW_LEFT_X, WIN_LOW_LEFT_Y+WIN_HEIGHT/2.0), \
            Point(N, WIN_LOW_LEFT_Y+WIN_HEIGHT/2.0) \
        )
        line.setWidth(LINE_THICKNESS)
        line.draw(self.win)
        handle = Circle( \
            Point(N-.1, WIN_LOW_LEFT_Y+WIN_HEIGHT/2.0), \
            SKEWER_HANDLE_RADIUS \
        )
        handle.setFill(BKGD_COLOR)
        handle.setWidth(LINE_THICKNESS)
        handle.draw(self.win)
        self.items = []



    class _ShapeInfo():
        __slots__ = [ 'shapeClass', 'ctorArgs' ]
        def __init__( self, shapeClass, ctorArgs ):
            self.shapeClass = shapeClass
            self.ctorArgs = ctorArgs

    Shapes = { \
              True: _ShapeInfo( Circle, ( Point( 0, .5 ), .5 ) ), \
              False: _ShapeInfo( Rectangle, ( Point( -.5, 0 ), Point( .5, 1 ) ) ) \
    } # The bool is for vegetarian

    def add( self, food ):
        """
        Called whenever an item is added to the Skewer, so the graphics
        can be updated.  It uses the KSpot class to get the food items
        and display them.
        Arguments:
            self - the SkewerUI instance
            food - the new food added to the skewer (KSpot)
        """    
        if food != None:
            shapeInfo = SkewerUI.Shapes[ food.item.veggie ]
            graphic = (shapeInfo.shapeClass)( *shapeInfo.ctorArgs )
            graphic.setFill(Colors[food.item.name])
            graphic.draw( self.win )
            for prev in self.items:
                prev.move( 1, 0 )
            self.items.insert( 0, graphic )
            

    def remove( self ):
        """
        Called whenever an item is removed to the Skewer, so the graphics
        can be updated.  It uses the KSpot class to get the food items
        and display them.
        Arguments:
            self - the SkewerUI instance
            head - the head of the skewer (KSpot)
        """
        
        if len( self.items ) != 0:
            self.items[ 0 ].undraw()
            self.items.pop( 0 )
            for prev in self.items:
                prev.move( -1, 0 )
        
