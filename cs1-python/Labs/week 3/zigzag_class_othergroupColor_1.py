"""
Author: Jon O'Brien
Lab: ZigZag - week 3
Description:  This program recursively draws zigzags with alternating green
                and red crosses."""


import turtle
from turtle import*

def Drawzigzag(size, depth):
    if (depth % 2==1):
        colorvar = "green"
    else:
        colorvar = "red"
    color(colorvar)
    if (depth==0):
        return
    lt(90)
    
    color
    fd(size/2)
    rt(90)
    fd(size)
    lt(45)
    Drawzigzag(size/2,depth-1)
    color
    rt(45)
    
    back(size)
    lt(90)
    back(size)
    lt(90)
    fd(size)
    lt(45)
    Drawzigzag(size/2, depth-1)
    rt(45)
    
    back(size)
    rt(90)
    fd(size/2)
    rt(90)
    


Drawzigzag(100,4)
