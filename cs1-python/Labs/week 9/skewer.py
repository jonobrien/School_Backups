"""
Author: Sean Strout
Author: Jon O'Brien
Description: A module for representing the skewer functionality
    and graphics.  It interfaces between the main program
    (kebab.py) and the modules kebab_graphics.py and kebab_spot.py
"""

import kebab_graphics
import skewer_exception
import food
import kebab_spot

def calories(skwr):
    """
    This function takes the paramter of the skewer and uses it to test for an
    empty skewer and returns the value of calories.


    """
    if skwr==None:
        raise skewer_exception.SkewerException( \
            "Cannot get calories from skewer if it does not have anything")
    return kebab_spot.calories(skwr.top)

 
class Skewer():
    """
    Class: Skewer
    Description: This class receives commands from Kabob and
        works with the KebebSpot class to represent a shish kebab
        of food items on a skewer.
    Slots:
        top - reference to top KebabSpot node
        capacity - maximum number of KebabSpots/Food items allowed 
        ui - the GraphWin that shows the kebab
    """
    
    __slots__ = ('top', 'capacity', 'ui')

def mkSkewer( capacity ):
    """
    Construct a Skewer instance.
    Arguments:
        capacity - the maximum number of items it can hold
    Exceptions:
        skewer_exception.SkewerException - a capacity less than 1 was specified.
    """
    
    if capacity < 1: 
        raise skewer_exception.SkewerException( \
            "Skewers must have positive capacity!" )
        
    result = Skewer()
    result.top = kebab_spot.NONE_NODE
    result.capacity = capacity
    result.ui = kebab_graphics.SkewerUI( capacity )
    return result
        
def close( skwr ):
    """
    Close the UI if the skewer is deleted.
    Arguments:
        skwr - the Skewer instance being deleted.
    Exceptions:
        skewer_exception.SkewerException - cannot close the skewer because it doesn't exist
    """
    if skwr == None:
        raise skewer_exception.SkewerException( "Cannot close the skewer if it does not exist")
    
    skwr.ui.close()
    
def destroy( skwr ):
    """
    Close and destroy the skewer, if it exists
    Exceptions:
        skewer_exception.SkewerException - cannot destroy the skewer because it doesn't exist
    """
    if skwr == None:
           raise skewer_exception.SkewerException( "Cannot destroy the skewer if it does not exist")
    
    close(skwr)

def add( skwr, name ):
    """
    Add a food item to the skewer
    Arguments:
        skwr - the Skewer instance
        name - the string name of the food item
    Exceptions:
        skewer_exception.SkewerException - item could not be added because skewer doesn't exist
    """

    if skwr == None:
        raise skewer_exception.SkewerException( "Cannot add item to skewer that does not exist")

    if skwr.top == kebab_spot.NONE_NODE or kebab_spot.size( skwr.top ) < skwr.capacity:
        obj = food.mkFood( name )
        # Create new KebabSpot and "push" it on the skwr.
        skwr.top = kebab_spot.mkKebabSpot( obj, skwr.top )
        # Have the food appear in the right spot.
        skwr.ui.add( skwr.top )
    else:
        raise skewer_exception.SkewerException( "Cannot add item to a full skewer!" )

def top(skwr):
    """
    Gets the name of the top item on the skewer.
    Arguments:
        skwr - the Skewer instance
    Exceptions:
        skewer_exception.SkewerException - no item was on the skewer, or it doesn't exist
    Returns: The name of the food item (string) on the front
    """
    
    if skwr == None:
        raise skewer_exception.SkewerException( "Cannot get top item from skewer that does not exist") 
    if kebab_spot.emptyKebab(skwr.top):
        raise skewer_exception.SkewerException( "Cannot get top item from an empty skewer!" )
    return skwr.top.item.name

def remove(skwr):
    """
    Remove the front item from the skewer.
    Arguments:
        skwr - the Skewer instance
    Exceptions:
        skewer_exception.SkewerException - no item was on the skewer, or it doesn't exist
    """
    
    if skwr == None:
        raise skewer_exception.SkewerException( "Cannot eat item from skewer that does not exist")
    if kebab_spot.emptyKebab(skwr.top):
        raise skewer_exception.SkewerException( "Cannot get item from an empty skewer!" )
        
    # Un-draw the food item.
    skwr.ui.remove()
    # "Pop" the item off the skewer.
    skwr.top = skwr.top.succ

def size( skwr ):
    """
    Get the number of elements on the skewer.
    Arguments:
        skwr - the Skewer instance
    Returns: the number of elements (int)
    Exceptions:
        skewer_exception.SkewerException - skewer doesn't exist
    """
    if skwr == None:
        raise skewer_exception.SkewerException( \
            "Cannot get size from skewer that does not exist")

    return kebab_spot.size( skwr.top )

def isVeggie( skwr ):
    """
    Are there only vegetables on the skewer?
    Arguments:
        skwr - the Skewer instance
    Returns: True if there are only veggies on the skewer, 
        False if not.
    Exceptions:
        skewer_exception.SkewerException - skewer does not exist
    """
    if skwr == None:
        raise skewer_exception.SkewerException( \
            "Cannot tell if veggie if the skewer does not exist")

    return kebab_spot.isVeggie( skwr.top )

def has( skwr, name ):
    """
    Is a particular food item on the skewer?
    Arguments:
        skwr - the Skewer instance
        name - the name (string) of the food item to search for
    Returns: True if the item is on the skewer, False if not.
    Exceptions:
        skewer_exception.SkewerException - skewer does not exist
    """
    if skwr == None:
        raise skewer_exception.SkewerException( \
            "Cannot tell if skewer has something on it if it does not exist")
        
    return kebab_spot.has( skwr.top, name )

def asString( skwr ):
    """
    Return a string representation of the items on the skewer.
    Arguments:
        skwr - the Skewer instance
    Returns: A string containing all the items on the skewer,
        from front to back, comma separated, and surrounded with
        square brackets.
    """
    
    if skwr == None:
        raise skewer_exception.SkewerException( \
            "Cannot get items from skewer if it does not exist")
         
    return "[ " + kebab_spot.stringEm( skwr.top ) + " ]"
