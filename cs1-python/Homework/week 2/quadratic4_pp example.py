# quadratic6.py
#A program that computes the real roots of a quadratic equation.
#Illustrates robust exception handling to avoid crash on bad inputs

import math 

def main():
    print "This program finds the real solutions to a quadratic\n"
    try:
        a, b, c = input("Please enter the coefficients (a, b, c): ")
        discRoot = math.sqrt(b * b - 4 * a * c)
        root1 = (-b + discRoot) / (2 * a)
        root2 = (-b - discRoot) / (2 * a)
        print "\nThe solutions are:", root1, root2 
    except ValueError, excObj:
        msg = str(excObj)
        if msg == "math domain error":
            print "\nNo Real Roots"
        elif msg == "unpack tuple of wrong size":
            print "\nYou didn't give me the right number of coefficients."
        else:
            print "\nSomething went wrong, sorry!"
