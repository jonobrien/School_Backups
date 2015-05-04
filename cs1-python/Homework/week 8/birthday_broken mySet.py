"""
Autor: Jon O'Brien
Date: 10/26/13
Assignment: Hashing - Birthdays 1/23 chance needed to get a person with a
duplicate birthday.

set converted into a list
random number birthday
count number of people needed to have equal birthday
runnning total = number of tests that had some kind of count accumulator
"""

import random

def makeSet(tests,mySet):
    """
    Makes the set and tests to see if birthdays are the same,accumulates this
    """
    count = 0
    while True:
        
        birthday = random.randint(0,364)
        if birthday in mySet:
            return count
        else:
            mySet.add(birthday)
            count+=1

def number(tests,mySet):
    """
    The number of people in the room it takes for a duplicate to appear and
    accumulates that value, then divides by the number of tests run to
    determine the average of people per room that is needed to find duplicates.
    """
    accumulator = 0
    for i in range(tests):
        makeSet(tests,mySet)
        variable = makeSet(tests,mySet)
        accumulator += variable
    accumulator2 = (accumulator/tests)
    return accumulator2
    
def main():
    mySet=set()
    tests = int(input("tests (10-10000):"))
    if tests <10 or tests >10000:
        print ("incorrect value for tests")
        
    else:
        print(number(tests,mySet))
        
    
main()
    








##def sets(birthday,tests):
##    mySet1 = ([birthday])
##    myset2 = ([birthday])
##    count = 0
##    for i in range(tests):
##        if mySet2 in mySet1:#compare sets for equal birthdays
##            
##            count = count-1#decrement total and continue until duplicate found
##            return count




##
##
##        print("debug")
##        if len(mySet)==0:
##               mySet.add(birthday)
##               n+= birthday
##               print("debug2")
##        else:
##            if (birthday in mySet):
##                   i = len(myset)
##                   total += i
##                   count=0
##                   print("3333")
##            else:
##                print("else2")
##                mySet.add(val)
##        count-=1
##    count=365
##    print("4444")
##    tests-=1
##    return int(total/val)
##







          
main()



##def mkBirthdayRandom()
##def make list of set of counted rooms
##def count number of people it took to have duplicate bd dates
##def 
