#!/usr/local/bin/python3.1

# N-Queens using backtracking
# Author: Sean Strout (sps@cs.rit.edu)

from copy import deepcopy

class Board(object):
    """The chess board representation.
        dim:the square dimension of the board (int)
        grid: the 2-D dimensional board
        lastQueen: (r,c) where last queen was placed"""
    __slots__ = ('dim', 'grid', 'lastQueen')
    
    def __init__(self, size):
        self.dim = size
        self.grid = [ ['.' for col in range(self.dim)] for row in range(self.dim) ]
        self.lastQueen = (-1,-1)  # which (r,c) last queen was placed
        
    def __str__(self):
        result = ""
        for row in range(self.dim):
            for col in range(self.dim):
                result += self.grid[row][col]
            result += "\n"
        return result

def isGoal(board):
    """Goal is when a queen is in the last column.  This is only called if the
    board is valid."""
    return board.lastQueen[1] == board.dim-1
    
def generateNeighbors(board):
    """Make all the neighbors of this board (valid or not)."""
    neighbors = []
    col = board.lastQueen[1] + 1
    for row in range(board.dim):
        neighbor = deepcopy(board)          # copy the board
        neighbor.grid[row][col] = 'Q'       # place the queen
        neighbor.lastQueen = (row, col)     # store this queen location
        neighbors.append(neighbor)          
    return neighbors
    
def isValid(board):
    """Do any queens on the board interfere with others already placed?"""
    # check rows    
    for row in range(board.lastQueen[0]+1):
        if board.grid[row].count('Q') > 1:
            return False
    
    # check diags by moving diagonally backwards up and down rows from
    # last queen 
    uprow = downrow = board.lastQueen[0]
    for col in range(board.lastQueen[1]-1,-1,-1):
        uprow -= 1
        downrow += 1
        if uprow >= 0 and board.grid[uprow][col] == 'Q' or downrow < board.dim and board.grid[downrow][col] == 'Q':
           return False
    
    return True
        
def solve(board):
    """Backtracking algorithm."""
    if isGoal(board):
        return board
    else:
        for neighbor in generateNeighbors(board):
            if isValid(neighbor):
                solution = solve(neighbor)
                if solution != None:
                    return solution      
        return None

DIM = int(input("Enter board dimension: "))
board = Board(DIM)
solution = solve(board)
print("A Solution:")
print(solution)
