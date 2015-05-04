"""
Author: Jonathan O'Brien
Homework 2
This python program evaluates sets of quadratic numbers in the quadratic equation.
The 

x^2 + ax + b = 0  (or ax^2 + bx + c = 0)
By substituting x = y-t and t = a/2, the equation reduces to 
    y^2 + (b-t^2) = 0 
which has easy solution
    y = +/- sqrt(t^2-b)
"""



import math


def quadraticRoots(a, b, c):
    """code inputs 3 values for the 3 coefficients in the 'standard form'
    quadratic equation, then the function prints the equation with the
    coefficients and the number of roots, if necessary.

    
    a = input ("enter a coefficient value for the 'a' term")
    a = int(a)
        
    b = input ("enter a coefficient value for the 'b' term")
    b = int(b)
    
    c = input ("enter a coefficient value for the 'c' term")
    c = int(c)
    """

    discrim = (b**2 - 4*a*c)
    print("Equation:",""" """, a, "x^2", "+" , b, "x", "+", c ,"=0",sep=""  )
    if discrim < 0:
        print("equation:", a, b, c )
        print("no roots.")
        print("")
        
    elif discrim > 0:
       
        x1 = (-b + math.sqrt(discrim))/(2*a)
        x2 = (-b - math.sqrt(discrim))/(2*a)
        print("equation:", a, b, c )
        print("x1=", x1)
        print("x2=", x2)
        print("two roots.")
        print("")
        
        
    elif discrim == 0:
        x1 = (-b + math.sqrt(discrim))/(2*a)
        print("equation:", a, b, c )
        print("x1=", x1)
        print("one root.")
        print("")
        
        
def main():
    """function that runs the code to display the different quadratic sets of coeefficients"""
    
    quadraticRoots(1, 2, 3)
    quadraticRoots(1, 2, 4)
    quadraticRoots(1, 0, 0)
    quadraticRoots(2, -11, -21)  # 10 "tests" for the code yielding
    quadraticRoots(1, -3, -4)    # different results to test the code
    quadraticRoots(1, 0, -4)
    quadraticRoots(4, -10, 8)
    quadraticRoots(1, -7, 0)
    quadraticRoots(1, 4, 4)
    quadraticRoots(1, -2, 1)
    


#http://stackoverflow.com/questions/15398427/solving-quadratic-equation

main() # runs the function main() to determine the roots, if any




input("enter")


