"""
Jon O'Brien
Personal SE
1/27/14

added 1/29/14
"""

def fizz():
    for i in range(1,101):
        if  i%5==0 and i%7==0:
            print("FizzBuzz")
        elif i%5==0:
            print("fizz")
        elif i%7==0:
            print("Buzz")
        else:
            print(i)
        
        
        
fizz()
