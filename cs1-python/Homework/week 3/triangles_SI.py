from turtle import *

def recTriangle(size, depth):
    if (depth == 0):
        pass
    else:
        lt(60)
        forward(size)
        recTriangle(size, depth-1)
        recTriangle(size/2,depth-1)
recTriangle(100,2)
