"""
author: Jon O'Brien
Due date: 11/23/13
Assignment: Hercules and the Hydra

This program is awesome.

"""
from array_heap import *


def battle(heap,line3,regen):
    while heap.size != 0: # >0 ??
        if line == 'smallest':
           displayHeap(heap)
           head=removeMin(heap)
           if head > 1:
                add(heap, head//2)
                add(heap, head//2)
           else: #head == 1
               if count // regen == 0:
                   #count is supposed to be a test for heads
                   print(count)
                   
        if line == 'largest':
            displayHeap(heap)
            head = removeMin(heap)
            #still removes max value, but function is the same
            
                
                
               
           
        else:
            print('6')
    

def main():
    fp = open(input("Please input name of file to read:"))
    hydra=[]
    line=fp.readline().strip()
    line2=fp.readline().strip()
    hydra1=line2.split(" ")
    for i in hydra1:
        hydra.append(int(i))
        
    print("Hercules strategy:", line)
    print("Initial Hydra heads:", hydra)
    if line == 'smallest':
        heap=mkHeap(100+len(hydra),less)
        for i in hydra:
            add(heap, i)
    else:
        heap=mkHeap(100+len(hydra),greater)
        for i in hydra:
            add(heap, i)
    line3=fp.readline().strip()
    print("hydra growth period:",line3)
    battle(heap,line,line3)
    
    



main()




























