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

def main():
    quadraticRoots()
    
"""  
def quadraticRoots(a, b, c):
    a = print("first term", a)
    b = print("second term", b)
    c = print("third term", c)
quadraticRoots()
"""
def quadraticRoots():
    """user inputs 3 values for the 3 coefficients in the 'standard form'
    quadratic equation, then the function prints the equation with the
    coefficients and the number of roots."""

    print ("for the equation ax^2 + bx + c")
    
    a = input ("enter a coefficient value for the 'a' term")
    a = int(a)
        
    b = input ("enter a coefficient value for the 'b' term")
    b = int(b)
    
    c = input ("enter a coefficient value for the 'c' term")
    c = int(c)

    discrim = math.sqrt (b**2 - 4*a*c)
    print("Equation:", a, "x^2", "+" , b, "x", "+", c , sep="" )
    if discrim < 0:
        print("no roots.")
        
    elif discrim > 0:
        print("two roots.")
        x1 = (-b + math.sqrt(discrim))/(2*a)
        x2 = (-b - math.sqrt(discrim))/(2*a)
        print("x1=", x1)
        print("x2=", x2)
        
    elif discrim == 0:
        x1 = (-b + math.sqrt(discrim))/(2*a)
        x2 = (-b - math.sqrt(discrim))/(2*a)
        print("x1=", x1)
        print("x2=", x2)
        print("one root.")
        
    
    #print(discrim , a, b, c)

#need MAIN():

#only have to evaluate for positive, negative and zero, and display that
# have to list roots for equations see: http://stackoverflow.com/questions/15398427/solving-quadratic-equation

main() # runs the quadratic function to determine roots



input("enter")
