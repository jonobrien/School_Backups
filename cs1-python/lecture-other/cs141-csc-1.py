def reverse(string):
    if string=='':
        return string
    else:
        return reverse(string[1:])+string[0]
string = "Cinco-fone"
#print(reverse(string))

from turtle import *
speed(0)
def square(length,depth): #question 7
    if depth<=0:
        return
    count = 4
    while count >0:
        
        lt(90)
        fd(length)
        square(length/2,depth-1)
        rt(180)
        count-=1
#square(100,3)
                    # recitation week 3 #1
def drawThing(n,l): #broken basecase-ish and image incorrect
    if n == 0:
        return
    lt(45)
    fd(l)
    rt(45)
    rt(90)
    drawThing(n-1,l/2)
    lt(90)
    rt(45)
    back(l)
    lt(45)

##drawThing(3,100)
##input("enter to close")
##bye()

#cs141 ta review question 5
def mystery(x):
    if x > 0:
        if x % 2 == 0:
            fd(20)
            rt(90)
        else:
            back(40)
            lt(90)
        mystery(x-1)

mystery(4)









        
    
