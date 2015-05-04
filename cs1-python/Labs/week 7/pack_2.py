"""
Author: Jon O'Brien
Due date: 10/22/13
Lab: week 7 - Two D. Bin Packing

"""

def isSpaceFree(bn,row,col,size): #size is block size
    if row + size >= len(bn) or col + size >= len(bn):                                        
        return False
    else:
        for r in range(row,size + row):
            for c in range(col, size + col):
                if bn[r][c] != 0:
                    return False
    return True

def findSpace(bn,block):
    for r in range(len(bn)):
        for c in range(len(bn)):
            if isSpaceFree(bn, r, c, block):
                return r,c


def x(blocklist,bn): #goes through the list and uses the blocks, then puts them in or not, then in the unused list
    for el in blocklist:
        if isSpaceFree(bn,row,col,size):
            changeBin(bn,row,col,size) #NEEDS LIST OF UNUSED BLOCKS
        else:
            findSpace()  #find space free function, need to know what rows and columns, ask that in
            #the above free space function
    


def makeLstBin(number, dimension, bn): 
    for r in range(dimension):
        for c in range(dimension):
            print(bn[row][col], end=" ")
        print()


def changeBin(bn, row, col, size): #done, just need to call function and bin
    for r in range(row, row + size):
        for c in range(col, col + size):
            print(row,col) # test
            bn[r][c] = size

    
def main():
      
    dimension = int(input("square dimension"))
    fileName = input("test file")
    blocklist=[]
    for num in open(fileName):
        for i in num.split():
            blocklist.append(int(i))    
        blocklist.sort(reverse = True) #sorts and reverses the input file of blocks
        print(blocklist)

        
    number=blocklist.append(blocklist) #take the block size number and insert it into the bin
    #print(bn)
    bn = [[0 for col in range(dimension)] for row in range(dimension)]
    #makeLstBin(number,dimension,bn)
    changeBin(bn,1,0,3)
    makeLstBin(number,dimension,bn)

main()


