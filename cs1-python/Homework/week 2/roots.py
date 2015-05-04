"""
file: roots.py
author: Jonathan O'Brien
date: 9/7/13
description: This python program evaluates sets of quadratic numbers in the quadratic
             equation and lists out the equation, the roots, and the number of roots,
             if necessary, there are 10 tests performed on the function to asses its'
             accuracy and outputs' if, elif statements.

prints in the form of:

equation:
# roots.
roots:

"""



import math # imports the math module for use in the program


def quadraticRoots(a, b, c):
    """code inputs 3 values for the 3 coefficients in the 'standard form'
    quadratic equation, then the function prints the equation with the
    coefficients and the number of roots, if necessary."""
    

    discrim = (b**2 - 4*a*c)
    print("Equation:",""" """, a, "x^2", "+" , b, "x", "+", c ,"=0",sep=""  )
    if discrim < 0:
        print("equation:", a, b, c )
        print("no roots.")  # no rational roots
        print("")
        
    elif discrim > 0:
       
        x1 = (-b + math.sqrt(discrim))/(2*a) # equations used to find root 1
        x2 = (-b - math.sqrt(discrim))/(2*a) # equations used to find root 2
        print("equation:", a, b, c )
        print("two roots.")
        print("x1=", x1)
        print("x2=", x2)
        print("")
        
        
    elif discrim == 0:
        x1 = (-b + math.sqrt(discrim))/(2*a)
        print("equation:", a, b, c )
        print("one root.")  # may be double roots
        print("x1=", x1)
        print("")
        
        
def main():
    """function that runs the code to display the different quadratic sets of
    coeefficients"""
    
    quadraticRoots(1, 2, 3)
    quadraticRoots(1, 2, 4)
    quadraticRoots(1, 0, 0)
    quadraticRoots(2, -11, -21)  # conducts 10 "tests" of the code, yielding
    quadraticRoots(1, -3, -4)    # different results to test it.
    quadraticRoots(1, 0, -4)
    quadraticRoots(4, -10, 8)
    quadraticRoots(1, -7, 0)
    quadraticRoots(1, 4, 4)
    quadraticRoots(1, -2, 1)
    quadraticRoots(4, 1, 4)
    
    




main() # runs the function main() to determine the roots, if any.


input("enter")




