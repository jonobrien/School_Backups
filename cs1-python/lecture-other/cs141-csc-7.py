from turtle import *
speed(0)
def drawSquares(length,depth):
    if depth<= 0:
        return
    count = 4
    while count>0:
        fd(length)
        lt(90)
        drawSquares(length/2,depth-1)
        rt(180)
        count-=1
drawSquares(50,3)
