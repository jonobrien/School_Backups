"""
author: Jon O'Brien
Due date: 11/23/13
Assignment: Hercules and the Hydra

This program is awesome.

"""
from array_heap import *

def battle(heap,line,line3):
    """
    docstring
    """
    rounds=1
    while heap.size != 0:
            #print("start round:",rounds)
            headsize=removeMin(heap) #cuts off head
            #print("head cut-off:",headsize)
            displayHeap(heap)

            
            if headsize == 1:
                pass
            
            if headsize > 1:
                add(heap, headsize//2) #add two more heads
                add(heap, headsize//2)
                
            if rounds // int(line3) != 0 and rounds % int(line3) == 0:
                #print(" entered head==1")   test
                for i in range(heap.size):
                    if heap.array[i] != None:
                        heap.array[i]+=1

            rounds += 1 #counts number of rounds
            if rounds == 100:
                return "Result:   Hercules gives up after 100 rounds."
                
    return "Hercules slays the Hydra after " +  str(rounds-1) + " rounds."


def main():
    """
    docstring
    """
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
        heap=mkHeap(100+len(hydra),less) #min-heap
        for i in hydra:
            add(heap, i)
    else:
        heap=mkHeap(100+len(hydra),greater)#max-heap
        for i in hydra:
            add(heap, i)
    line3=fp.readline().strip()
    print("hydra growth period:",line3)
    print(battle(heap,line,line3))
    
    
main()




























