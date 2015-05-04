"""
Description: The main module for running the Shish Kebab program.

Author: Sean Strout
Author: James Heliotis
Author: jon O'Brien
"""

import sys
import skewer
import skewer_exception
import food


def calories(ourSkewer,args):
    """
    This function ives you the total number of calories for the items
    in the skewer.
    arguments:
         ourSkewer - the skewer object
         args - ignored
    """
    print("The Skewer contains:", skewer.calories(ourSkewer),"calories")

    

def help(ourSkewer, args):
    """
    Displays the valid commands and their usage.
    Arguments:
        ourSkewer - unused
        args - unused
    Example:
       help   # displays this usage message
    """
    
    print(  "Kebab commands:" )
    print(  "---------------" )
    print(  "create N - creates a skewer to hold N items." )
    print(  "destroy - destroys the skewer and all items on it." )
    print(  "add item - adds an item to the skewer." )
    print(  "eat - eat the top item on the skewer." )
    print(  "has item - is an item on the skewer?" )
    print(  "status - the capacity and current number of items on the skewer." )
    print(  "top - the top item on the skewer." )
    print(  "items - displays all the items on the skewer, in order." )
    print(  "calories - displays the total number of calories in the skewer.")
    print(  "veggie - does the skewer have any meat?" )
    print(  "help - displays this usage message")
    print(  "foods - display the valid food items that can be added to the skewer")
    print(  "quit - exit the program." )
    
def foods(ourSkewer, args):
    """
    Display the acceptable foods items the skewer can hold.
    Arguments:
        ourSkewer - the Skewer object
        args - unused
    Example:
        foods   # displays the list of valid food strings
    """
    print(  "Kebab can hold the following foods: ", food.FOODS )
    
def create(ourSkewer, args):
    """
    Create the skewer that will hold the food.
    Arguments:
        ourSkewer - the Skewer object
        args - a string containing the size to create.
    Example:
        create 10    # creates a skewer that can hold 10 elements
    """
 
    # make sure the size is valid
    try:
        size = int(args[0])
        if size < 1:
            raise skewer_exception.SkewerException("Skewer size must be greater than 0")
    except ValueError as e:
        print("The size of the skewer must be a valid integer")
        return None
   
    # force delete any pre-existing skewer
    if ourSkewer:
        ourSkewer = skewer.close( ourSkewer )
    
    ourSkewer = skewer.mkSkewer( size )
    print(  "Skewer created." )
    return ourSkewer
    
def destroy(ourSkewer):
    """
    Destroy the skewer, if it exists
    Arguments:
        ourSkewer - the Skewer object
    Example:
        destroy     # Destroys the skewer and all items on it
    """
        
    skewer.destroy( ourSkewer )
    return None
    
def add(ourSkewer, args):
    """
    Add a specified item to the skewer
    Arguments:
        ourSkewer - the Skewer object
        args - The name of the item to add
    Example:
        add Onion   # add an Onion to the skewer
    """
    if len(args) < 1: 
        help(None, None)
        return
        
    name = args[0]
    
    # Check that the name is in the list of valid foods.  
    if name not in food.FOODS:
        raise skewer_exception.SkewerException( "Kebab can hold the following foods: " + str(food.FOODS) )
    
    skewer.add(ourSkewer, name)
    if ourSkewer != None:
        print( name, "successfully added to the skewer." )
    else:
        print( name, "was not successfully added to the skewer." )

    
def eat(ourSkewer, args):
    """
    Eat the top item on the skewer.
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        eat   # consumes the top item, if one is present
    """

    name = skewer.top( ourSkewer )
    ourSkewer = skewer.remove( ourSkewer )
    print(  "Ate", name, ". Yum!" )


def has(ourSkewer, args):
    """
    Checks if the skewer holds a certain item.
    Arguments:
        ourSkewer - the Skewer object
        args - the name of the item to search for
    Example:
        has Onion    # does the skewer have an Onion on it?
    """
    if len(args) < 1: 
        help(None, None)
        return
        
    name = args[0]
    
    if skewer.has( ourSkewer, name ): 
        print( name, "does exist on the Skewer." )
    else: 
        raise skewer_exception.SkewerException("Skewer size must be greater than 0")

def status(ourSkewer, args):
    """
    Returns information about the skewer and the items on it.
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        status    # displays the size and capacity of the skewer
    """
    print( skewer.size( ourSkewer ), "out of", \
            ourSkewer.capacity, "items on the skewer." )
        
def top(ourSkewer, args):
    """
    Returns the name of the top item on the skewer.
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        top    # displays the top item if there is one
    """
    print( skewer.top( ourSkewer ), "is on top of the skewer." )
          
def items(ourSkewer, args):
    """
    Displays the items on the skewer, in text form.
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        items    # displays a list of the items from top to bottom
    """
    
    print(  "The skewer contains: ", skewer.asString( ourSkewer ) )

def veggie(ourSkewer, args):
    """
    Tells whether there is any meat on the skewer or if it is
    all vegetables
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        veggie    # skewer is all veggies or contains some meat?
    """
    
    if skewer.isVeggie( ourSkewer ):
        print(  "The skewer is vegetarian friendly." )
    else:
        print(  "The skewer contains meat." )
            
def quit(ourSkewer, args):
    """
    Exit the program.
    Arguments:
        ourSkewer - the Skewer object
        args - ignored
    Example:
        quit    # exits program.
    """

    print( "Goodbye!" )
    sys.exit(0)

# Each valid command is stored in a dictionary as string by key.
# The corresponding method to call is stored as the value.
CMDS = {'foods' : foods,
        'add' : add,
        'create' : create,
        'destroy' : destroy,
        'eat' : eat,
        'has' : has,
        'status' : status,
        'top' : top,
        'items' : items,
        'veggie' : veggie,
        'calories': calories,
        'help' : help,
        'quit' : quit}

def mainLoop():
    """
    Runs the main command loop by prompting for input and responding.
    Arguments: None
    """
    
    # create the empty skewer
    ourSkewer = None

    # the command line prompt
    print("Enter 'help' for the list of valid commands")
    PROMPT = "> "

    # the command loop runs until the user enters the endProg command
    while sys.stdin:
        try:
            line = input(PROMPT)
            tokens = line.split()
            if len(tokens) > 0:
                cmd = tokens[0]
                if cmd in CMDS:
                    if cmd == "create":
                        if len(tokens) == 2:
                            ourSkewer = create(ourSkewer, tokens[1])
                        else:
                            help(None,None)
                    elif cmd == "destroy":
                        ourSkewer = destroy(ourSkewer)
                    elif skewer == None and cmd != "quit":
                        print(  "Skewer has not been created yet." )
                    elif cmd in CMDS:
                        # Strip off the command and pass the remaining line
                        # arguments to the appropriate function, which is
                        # the value in the dictionary.
                        CMDS[cmd](ourSkewer, tokens[1:])
                    else:
                        help(None,None)
                else:
                    help(None, None)
        except skewer_exception.SkewerException as e:
            print( str(e) )
        except EOFError:
            print()     # user entered ctrl-D, so we are done
            quit(None, None)
        
if __name__ == "__main__":
    mainLoop()
