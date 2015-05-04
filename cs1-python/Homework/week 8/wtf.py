"""
Author: Jon O'Brien
Due: 10/26/13
Assignment: Hashing homework - birthday.py

This program determines how many people are needed to find a duplicate person
in the same room for the same birthday.  There is a function that uses a while True loop
and if statements to determine if the generated number is already contained in the set
and if it is not then it is added to the set.  The count is accumulated and used in the
averaging of number of people per room that is required for there to be a duplicate.

"""

import random

def makeSet():
    """
    This function takes no parameters and creates the set. There is a while loop
    that takes a random integer between 0 and 365, for a total of 365 integers
    and compares that random value to the set to determine if there is a duplicate.
    If that random integer is not in the set then it is added to the set and the
    test is performed again.  This count is accumulated over the running of the function.


    """
    mySet=set()
    count = 0
    while True:
        birthday = random.randint(0,365)
        if birthday in mySet:
            return count
        else:
            mySet.add(birthday)
            count+=1
            
def main():
    """
    This function takes user input for an integer.  If this input value is not between
    the if statement range of between 10 and 10000, the incorrect value statement
    is printed. If the value is in that range, then the for loop iterates over the
    range of values every time in the makeSet() function and accumulates the values
    returns from that function.  This returned value is divided by the input integer
    and the average number of rooms is needed for the required result of average birthdays.

    """
    
    tests=int(input("tests (10-10000):"))
    if tests<10 or tests>10000:
        print("incorrect value for tests")
    else:
        accumulator = 0
        for num in range(tests):
            accumulator+=makeSet()
            accumulator2=(accumulator/tests)
        print(accumulator2)
main()
