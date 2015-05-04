"""
Description: A module that represents "spots" on the skewer.

Author: Sean Strout
Author: James Heliotis
Author: Jon O'Brien
"""
import food

class NoneNode():
    """A class to represent no node"""
    __slots__ = ()
    
"""A global constant for no node"""
NONE_NODE = NoneNode()


class KebabSpot(object):
    """
    This class is used to represent an individual
        spot on the shish kebab skewer. Each spot contains
        1. item - a food item.
        2. succ - a reference to the next KebabSpot (or NoneNode).  
    In computer science terms, a KebabSpot acts like a node in a stack.
    """
    __slots__ = (
        'item',          # The food item (of type Food)
        'succ'          # The next food item (of type Food, or None)
    )

    
def mkKebabSpot( item, succ ):
    """
    Construct a KebabSpot instance.
    Arguments:
        item - the item (type Food) to store at this spot
        succ - the next KebabSpot on the skewer
    Returns:  New KebabSpot
    """
    kebabSpot = KebabSpot()
    kebabSpot.item = item
    kebabSpot.succ = succ
    return kebabSpot




def calories(kebabSpot):
    """
    counts the number of calories on the skewer with a while loop.  It takes
    the parameter of kebabSpot that is used to find the position of the
    object on the skewer and counts the calories it receives to accumulate.
    """
    calories = 0
    currSpot = kebabSpot
    while currSpot != NONE_NODE:
        calories += int(food.CALORIES[currSpot.item.name])
        currSpot = currSpot.succ
    return calories       
  

def size(kebabSpot):
    """
    Count the number of KebabSpots on the skewer starting
    at this one and going to the end.
    Idea: If one asks the first KebabSpot on the skewer
    for a size, the total number of KebabSpot's (and therefore
    food items) is computed.
    Arguments:
        kebabSpot - the KebabSpot instance
    Returns: The number of KebabSpots starting at this one.
    """
    #need to go through all the spots to continue through this stuff.
    if kebabSpot==NONE_NODE:
        return 0
    else:
        return 1 + size(kebabSpot.succ)



def isVeggie(kebabSpot):
    """
    Return whether there are only vegetable foods from this
    KebabSpot to the end of the skewer.
    Idea: If one asks the first KebabSpot on the skewer
    isVeggie, one can find out if the entire shish kebab
    is vegetarian.
    Arguments:
        kebabSpot - the KebabSpot instance
    Returns: True if there are no vegetables starting at
        this KebabSpot, False otherwise.
    """
    if kebabSpot==NONE_NODE:
        return True
    elif kebabSpot.item.veggie is True:
        return isVeggie(kebabSpot.succ)
    else:
        return False


def has(kebabSpot, name):
    """
    Return whether there are any foods of the given kind
    from this KebabSpot to the end of the skewer.
    Arguments:
        kebabSpot - the KebabSpot instance
        name - the name (string) being searched for.
    Returns: True if any of the spots hold a food
        item that equals the name, False otherwise.
    """
    while(kebabSpot != NONE_NODE):
        if str(kebabSpot.item.name)==str(name):
            return True
        else:
            return has(kebabSpot.succ,name)
    return False

def stringEm(kebabSpot):
    """
    Return a string that contains the list of names of
    items in the skewer from this spot down, with a comma
    after each entry.
    Arguments:
        kebabSpot - the KebabSpot instance
    Returns: A string containing the names of each
        of the food items from this spot down.
    """
    if isinstance(kebabSpot,NoneNode):
        return''
    elif isinstance(kebabSpot.succ,NoneNode):
        return str(kebabSpot.item.name)
    else:
        return str(kebabSpot.item.name) + ', ' + stringEm(kebabSpot.succ)
    
def emptyKebab(kebabSpot):
    """Returns whether the kebabSpot is empty or not"""
    if kebabSpot==NONE_NODE:
        return True
    else:
        return False


