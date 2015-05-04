from turtle import *
speed(0)
def drawTriangle(l, s):
    if(s==0):
        return
    fd(l)
    drawTriangle(l/2, s-1)
    lt(60)
    drawTriangle(l/2,s-1)
    left(60)
    fd(l)
    left(60)
    drawTriangle(l/2,s-1)
    left(60)
    back(l)
drawTriangle(100,6)
input("enter")
    




    
