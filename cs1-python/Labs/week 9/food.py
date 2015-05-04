"""
Description: A module that represents the valid food types

Author: Sean Strout
Author: James Heliotis
Author: Jon O'Brien
"""

# The set of valid food items
FOODS = {'Beef', 'Chicken', 'Onion', 'Pepper', "Tomato"}

# The set vegetables
VEGGIES = {'Onion', "Pepper", 'Tomato'}

# The calories for each food item (a dictionary, where 
# key = food name (string) and value = calories (int)
CALORIES = \
    { 'Beef' : 200,     \
     'Chicken' : 140,   \
     'Onion' : 30,      \
     'Pepper' : 25,     \
     'Tomato' : 10,     \
    }
    
class Food():
    """
    All types of items that can be skewered
    Slots:
        name - a string name
        veggie - a boolean (True if vegetable)
    """
    __slots__ = (
        'name',         # string name
        'veggie',       # a boolean (True is vegetable)
        'tomatoes',     #added this for tomatoes
    )

def mkFood( name ):
    """Create and return a newly initialized Food item"""
    result = Food()
    result.name = name
    result.veggie = name in VEGGIES
    return result
