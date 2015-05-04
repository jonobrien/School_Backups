import turtle
from turtle import*
"""def drawZigZag(size,depth):
    if (depth==0):
        return
    lt(90)
    fd(size/2)
    rt(90)
    fd(size)
    
    back(size)
    
    lt(90)
    back(size)
    rt(90)
    back(size)
    fd(size)
    lt(90)
    fd(size)
    rt(90)
    drawZigZag(size,depth-1)
"""

speed(0)
def Drawzigzag(size, depth):
    if (depth==0):
        return
    lt(90)
    fd(size/2)
    rt(90)
    fd(size)
    #lt(45)
    Drawzigzag(size/2,depth-1)
    
    #rt(45)
    
    back(size)
    lt(90)
    back(size)
    lt(90)
    fd(size)
    #lt(45)
    Drawzigzag(size/2, depth-1)
    #rt(45)
    
    back(size)
    rt(90)
    fd(size/2)
    rt(90)
    


Drawzigzag(100,4)
