from turtle import *

def drawCross(l, s):
    if(s==0):
        return
    fd(l)
    drawCross(l/2, s-1)
    lt(90)
    drawCross(l/2,s-1)
    right(90)
    right(90)
    drawCross(l/2,s-1)
    left(90)
    back(l)
drawCross(200,6)
input("enter")
bye()




    
