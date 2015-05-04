
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
            print(count)
            
def main():
    mySet=set()
    tests = int(input("tests (10-10000):"))
    if tests <10 or tests >10000:
        print ("incorrect value for tests")
        
    else:
        accumulator = 0
        for num in range(tests):
        #makeSet(tests,mySet)
            variable = makeSet(tests,mySet)
            accumulator += variable
            accumulator2 = (accumulator/tests)
        print(accumulator2)

main()   
