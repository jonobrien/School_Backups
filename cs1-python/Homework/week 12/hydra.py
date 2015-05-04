"""
author: Jon O'Brien
Due date: 11/23/13
Assignment: Hercules and the Hydra

This program takes an input file, makes a heap, runs through the battle
between Hercules and the Hydra with rounds accumulating and determines if
Hercules wins or gives up with the utilization of if statements to add heads
and grow the heads every growth factor number of turns.  The strategy and list
of integer heads and growth period are printed along with the number of rounds
needed to complete the fight, either with Hercules winning or not.
"""
from array_heap import *

def battle(heap,line,line3):
    """
    This function takes the heap, first and third lines as parameters.  This
    function then defines rounds  and then goes through a while loop to
    determine headsize and whether or not heads are added to the hydra or some
    are cut and not regenerated.  The heads grow after the Kth turn, determined
    by the third line in the file.  The rounds are accumulated and using if
    statements detemines everything about the fight and whether or not Hercules
    wins, then these round numbers are returned and printed out in the main.
    Hercules loses if 100 rounds are done.
    """
    rounds=1
    while heap.size != 0:
            headsize=removeMin(heap) #cuts off head
            if headsize == 1:
                pass
            if headsize > 1:
                add(heap, headsize//2) #add two more heads
                add(heap, headsize//2)
            if rounds // int(line3) != 0 and rounds % int(line3) == 0:
                for i in range(heap.size):
                    if heap.array[i] != None:
                        heap.array[i]+=1 #grows heads
            rounds += 1 #counts number of rounds
            if rounds == 100:
                return "Hercules gives up after 100 rounds."
    return "Hercules slays the Hydra after " +  str(rounds-1) + " rounds."


def main():
    """
    this function takes an input file and opens it.  There are 3 lines
    in the files, the first line determines whether it is a min or max heap.
    The second line is the list of integers that are the heads of the hydra
    and the third line is the growth factor for the hydra heads for every
    turn that is conducted over the course of the battle.  The list of heads
    is made and the heaps are made dependent on the first line of the file.
    The lines are described and printed out along with the battle function.
    """
    fp = open(input("Please input name of file to read:  "))
    hydra=[]
    line=fp.readline().strip()
    line2=fp.readline().strip()
    hydra1=line2.split(" ")
    for i in hydra1:
        hydra.append(int(i)) 
    
    if line == 'smallest':
        heap=mkHeap(100+len(hydra),less) #min-heap
        for i in hydra:
            add(heap, i)
            
    else:
        heap=mkHeap(100+len(hydra),greater)#max-heap
        for i in hydra:
            add(heap, i)
    line3=fp.readline().strip()
    print("Hercules' strategy:", line)
    print("Initial Hydra heads:", hydra)
    print("Hydra growth period:",line3)
    print("")
    print(battle(heap,line,line3))

main()
