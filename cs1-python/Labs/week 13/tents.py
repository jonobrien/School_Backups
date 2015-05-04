"""
File: tents.py (Student version)
Author: Aaron Deever <atd@cs.rit.edu>
Author: Jon O'Brien
Purpose:  A backtracking solver for the Tents and Trees puzzle.
Language: Python 3
"""

from copy import deepcopy
from sys import argv

# STUDENTS ARE FREE TO ADD ADDITIONAL SLOTS TO THIS CLASS, BUT DO NOT CHANGE
# ANY OF THE EXISTING SLOTS!!!!
class TentsConfig():
    """
    A class that represents a tents configuration.
        DIM - square board DIMension (int)
        colVals - number of tents in each column, left to right 
            (list of DIM int's)
        rowVals - number of tents in each row, top to bottom
            (list of DIM int's)
        board - square grid of values 
            (list of list of int's, size DIM*DIM)
        cursor - the current location being looked at for trees/tents
            (x,y value, integers used for row, column)
    """
    __slots__ = ('DIM', 'colVals', 'rowVals', 'board', 'cursor')
   
    """Names for each possible board value"""
    EMPTY = 0   # can be referenced anywhere as: TentsConfig.EMPTY
    GRASS = 1   # can be referenced anywhere as: TentsConfig.GRASS
    TREE  = 2   # can be referenced anywhere as: TentsConfig.TREE
    TENT  = 3   # can be referenced anywhere as: TentsConfig.TENT

def mkTentsConfig(dim, colVals, rowVals, board):
    """
    Create a TentsConfig object.  Inputs are:
        dim     # square DIMension of board
        colVals # DIM values left to right
        rowVals # DIM values top to bottom
        board   # initial configuration of board as 2D list
 
    Returns: A config (TentsConfig)
    """
    
    config = TentsConfig()    
    config.DIM = dim
    config.colVals = colVals
    config.rowVals = rowVals
    config.board = board
    config.cursor = (-1,0)
    

    # additional initialization

    return config

def mkConfigString(config):                       
    """
    Creates a string representation of the config.  Input is:
        config  # a TentsConfig object
        
    Returns: a string representation of the config.
    """

    # top row
    result = '  '
    for val in config.colVals:
        result += str(val) + ' '
    result += '\n  ' + '-' * (config.DIM*2-1) + '\n'
            
    # board rows
    for row in range(config.DIM):
        result += str(config.rowVals[row]) + '|'
        for col in range(config.DIM):
            result += str(config.board[row][col])
            if col != config.DIM-1: result += ' '
        result += '|\n'
        
    # bottom row
    result += '  ' + '-' * (config.DIM*2-1) + '\n'
              
    return result

def readBoard(filename):
    """
    Read the board file.  It is organized as follows:
        DIM     # square DIMension of board
        colVals # DIM values, left to right
        rowVals # DIM values, top to bottom
        row 1 values    # 0 for empty, 2 for tree
        row 2 values    # 0 for empty, 2 for tree
        ...
    Input is:
        filename  # The file name (string)
        
    Returns: A config (TentsConfig) containing the board info from file
    """

    f = open(filename)
    DIM = int(f.readline().strip())
    colVals = [int(val) for val in f.readline().split()]
    rowVals = [int(val) for val in f.readline().split()]
    board = list()
    for _ in range(DIM):
        line = [int(val) for val in f.readline().split()]
        board.append(line)
    f.close()
    return mkTentsConfig(DIM, colVals, rowVals, board)
    
def isGoal(config):
    """
    Checks whether a config is a goal or not.  Input is:
        config: The config (TentsConfig)
        
    Returns: True if config is a goal, False otherwise
    """
    
    # YOUR IMPLEMENTATION REPLACES THIS
    rows = [0 for _ in range(config.DIM)]
    cols = [0 for _ in range(config.DIM)]

    for row in range(config.DIM):
        for col in range(config.DIM):
            if config.board[row][col] == TentsConfig.TENT:
                rows[row] += 1 #increment values in the lists
                cols[col] += 1
    if rows == config.rowVals and cols == config.colVals:
        for row in range(config.DIM):
            for col in range(config.DIM):
                if config.board[row][col] == TentsConfig.EMPTY:
                    return False
        return True
    
    return False


def getSuccessors(config):
    """
    Get the successors of config.  Input is:
        config: The config (TentsConfig)
        
    Returns: A list of successor configs (list of TentsConfig)
    """

    # YOUR IMPLEMENTATION REPLACES THIS ... was just return []

    successors = []
    row, col = config.cursor
    col += 1
    
    if col >= config.DIM:
        row += 1
        col = 0
        if row >= config.DIM:
            return successors

    if config.board[row][col] == TentsConfig.TREE:
        succ = deepcopy(config)
        
        succ.cursor = row, col
        successors.append(succ)
        
    else:
        valG = TentsConfig.GRASS
        succ = deepcopy(config)
        succ.board[row][col] = valG
 
        succ.cursor = row, col
        successors.append(succ)

        valT = TentsConfig.TENT
        succ = deepcopy(config) 
        succ.board[row][col] = valT

        succ.cursor = row, col
        successors.append(succ)
        
    return successors
        
        
        
def isValid(config):
    """
    Checks the config to see if it is valid.  Input is:
        config: The config (TentsConfig)
        
    Returns: True if the config is valid, False otherwise
    """
   
    row, col = config.cursor

    if row >= 0 and col >= 0 and row < config.DIM and col <  config.DIM:
        if config.board[row][col] == TentsConfig.TENT: #intial boundary check

        ############ checks around current position if on the board ###########
            if row-1>=0 and col-1>=0 and row-1<config.DIM and col-1<config.DIM:
                #top left
                if config.board[row-1][col-1] == TentsConfig.TENT:
                    return False
                        
            if row-1 >=0 and col >=0 and row-1< config.DIM and col< config.DIM:
                #top mid
                if config.board[row-1][col] == TentsConfig.TENT:
                    return False
                        
            if row-1>=0 and col+1>=0 and row-1<config.DIM and col+1<config.DIM:
                #top right
                if config.board[row-1][col+1] == TentsConfig.TENT:
                    return False
                        
            if row >=0 and col-1 >=0 and row <config.DIM and col-1<config.DIM:
                #mid left
                if config.board[row][col-1] == TentsConfig.TENT:
                    return False
                        
            if row >=0 and col+1 >=0 and row <config.DIM and col+1 <config.DIM:
                #mid right
                if config.board[row][col+1] == TentsConfig.TENT:
                    return False

            if row+1>=0 and col-1>=0 and row+1<config.DIM and col-1<config.DIM:
                #bottom left
                if config.board[row+1][col-1] == TentsConfig.TENT:
                    return False

            if row+1 >=0 and col >=0 and row+1 < config.DIM and col<config.DIM:
                #bottom mid
                if config.board[row+1][col] == TentsConfig.TENT:
                    return False
                    
            if row+1>=0 and col+1>=0 and row+1<config.DIM and col+1<config.DIM:
                #bottom right
                if config.board[row+1][col+1] == TentsConfig.TENT:
                    return False

            #################### checks for trees #############################
            if row-1 >=0 and col >=0 and row-1 <config.DIM and col<config.DIM:
                #top mid
                if config.board[row-1][col] == TentsConfig.TREE:
                    return True

            if row+1>=0 and col >=0 and row+1<config.DIM and col <config.DIM:
                #bottom mid
                if config.board[row+1][col] == TentsConfig.TREE:
                    return True

            if row >=0 and col+1 >=0 and row <config.DIM and col+1<config.DIM:
                #mid right
                if config.board[row][col+1] == TentsConfig.TREE:
                    return True

            if row >=0 and col-1 >=0 and row <config.DIM and col-1<config.DIM:
                #mid left
                if config.board[row][col-1] == TentsConfig.TREE:
                    return True
    return True



def solve(config, debug):
    """
    Generic backtracking solver.  Inputs are:
        config: the current config (TentsConfig)
        debug: print debug output? (Bool)
        
    Returns:  A config (TentsConfig), if valid, None otherwise
    """
    
    if isGoal(config):
        return config
    else:
        if debug: print('Current:\n' + mkConfigString(config))
        for successor in getSuccessors(config):
            if isValid(successor):
                if debug: print('Valid Successor:\n'+mkConfigString(successor))
                solution = solve(successor, debug)
                if solution != None:
                    return solution
        return None
    
def main():
    """
    The main program.
        Usage: python3 tents.py [filename] [debug]
            [filename]: The name of the board file
            [debug]: True or False for debug output
    """
    
    # if no command line arguments specified, prompt for the filename
    # and debug choice
    if len(argv) == 1:
        filename = input('Enter board file: ')
        debug = eval(input("Debug output (True or False): "))
    # otherwise, use the command line arguments
    elif len(argv) == 3:
        filename = argv[1]
        debug = eval(argv[2])
    # incorrect number of command line arguments
    else:
        print("Usage: python3 tents.py [filename debug]")
        print("optional command line arguments:" )
        print("  filename: The name of the board file")
        print("  debug: True or False for debug output")
        return -1
        
    # read and display the initial board
    initConfig = readBoard(filename)
    print('Initial Config:\n' + mkConfigString(initConfig))
    
    # solve the puzzle
    solution = solve(initConfig, debug)
    
    # display the solution, if one exists
    if solution != None:
        print('Solution:\n' + mkConfigString(solution))
    else:
        print('No solution.')
    
if __name__ == '__main__':
    main()
