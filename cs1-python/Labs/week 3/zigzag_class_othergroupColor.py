"""
Author: Jon O'Brien
Lab: ZigZag - week 3
Description:  This program recursively draws zigzags with alternating green
                and red crosses."""

speed(0)

import turtle
from turtle import*

def Drawzigzag(size, depth):
    if (depth % 2==1):
        colorvar = ("green")
    else:
        colorvar = ("red")
    color(colorvar)
    if (depth==0):
        return
    lt(90)
    
    color("red")
    fd(size/2)
    color("green")
    rt(90)
    fd(size)
    #color("green")  #"**"
    lt(45)
    #color("red")
    Drawzigzag(size/2,depth-1)
    #color("red")
    rt(45)
    #color("green")
    back(size)
    
    color("red")  #"**"
    lt(90)
    
    back(size)
    color("green")
    
    lt(90)
    fd(size)
    lt(45)
    Drawzigzag(size/2, depth-1)
    #color("green")
    rt(45)
    back(size)
    color("green")
    
    rt(90)
    fd(size/2)
    rt(90)
    


Drawzigzag(100,4)
