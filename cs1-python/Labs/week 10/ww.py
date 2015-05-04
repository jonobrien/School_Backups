"""
Author: Jon O'Brien
Due Date: 11/12/13
Assignment: Wacky Wheel of Fortune

This program takes a game of wheel of fortune and prints winners based on
the account balance at the end, number of pieces remaining in the wheel.
this program then runs through the while loop for each value on the wheel
and moves through them.  This program prints winners, account balance,
direction of travel, and the round and its count.

"""
from random import *
from myList import *

def spinDirec(wheel):
    """
    determines the direction of travel along the wheel, clockwise or
    anti-clockwise.
    """
    direc = randint(1,1000)
    spin = direc%2
    num = 0
    
    if spin == 0:
        val = moveDist(wheel)
        while num < val:
            forward(wheel)
            num += 1
    else:
        val = moveDist(wheel)
        while num < val:
            backward(wheel)
            num += 1
        
def moveDist(wheel):
    """
    takes a random integer from 2 to the size of the wheel.
    """
    dist = randint(2,wheel.size)
    return dist


def main():
    """
    runs the main function to take the file and seed.  It then makes the players
    into a dictionary and makes the wheel.  Then it reads through the file and
    assigns the value to the players and the rest to the wheel list.
    A while loop is used to play the game, print the proper statements
    and check for victory conditions.
    """
    inputData = input("Enter text file with input Data:")
    seed2= int(input("Enter the seed for random number generator:"))
    seed(seed2)#set the seed
    
    players = {1: 0, 2: 1,3: 2}
    
    wheel=mkList()
    
    firstLine=True
    for line in open(inputData):
        if firstLine==True: #reassigns player bank to first value 
            players[1]=int(line[1:])
            players[2]=int(line[1:])
            players[3]=int(line[1:])
            firstLine=False
            
        else:
            add(wheel,int(line[1:]))
     #dictionary of players with initial amount assigned
    i = 1
    while len(players) > 1 and size(wheel)>=3:
        print(" ")
        print("=======================================================")
        print("START Round",i,"players are:",players)
        i+=1
        for player in range(1,4):
            
            if player in players:
                direction=randint(0,1000)%2
                distance=randint(2,size(wheel))
                if direction==0:
                    print("\n","Player",player,"spins (clockwise):")
                else:
                    print("\n","Player",player,"spins (anti-clockwise):")
                for x in range(1,distance):
                    
                    if direction == 1:
                        
                        forward(wheel)
                    else:
                        backward(wheel)
                    print("->",wheel.cursor.data,end="")
                result=wheel.cursor.data
                if direction == 0:
                    players[player] += result
                else:
                    players[player] -= result
                if players[player] < 0:
                    print("\n","Account Balance:", players[player],"-Eliminated")
                    del players[player]
                else:
                    print("\n","Account Balance:",players[player])
                
                remove(wheel)
                forward(wheel)
    if size(wheel) >=3 or len(players)==1:
        if 1 in players:
            print("\n","Player 1 WON!")
        if 2 in players:
            print("\n","Player 2 WON!")
        if 3 in players:
            print("\n","Player 3 WON!")
    else:
        print("the Wheel has less than 3 spots.  No one wins!")


main()
               
