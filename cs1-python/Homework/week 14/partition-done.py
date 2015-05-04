"""
File: partition.py
Author: Aaron Deever <atd@cs.rit.edu>
Author: Jon O'Brien
Purpose:  A backtracking solver for the partitioning problem.
Language: Python 3
"""
from copy import deepcopy
from sys import argv


class PartitionConfig():
    """
    A class that represents a partition configuration. There are slots for the
    list that was constructed from the input file, the first sub-list and the
    second sub-list, and the index that is incremented for each following list.
    """
    __slots__ = ("input", "subA", "subB", "index")



def mkPartitionConfig(filename):
    """
    ***Due to the filename being imported here as a parameter, the file was
    opened and the list was constructed here instead of main.***

    Create a PartitionConfig object.  Input is:
        filename   # name of the file containing the input data
    Returns: A config (PartitionConfig)
    """
    
    #makes input list
    ints = []
    ab = open(filename)
    intSet =ab.readline().strip().split() 
    for i in intSet:
        ints.append(int(i))
    
    config = PartitionConfig()
    config.input = ints
    config.subA = []
    config.subB = []
    config.index = 0
    
    return config



def mkConfigString(config):
    """
    Creates a string representation of the config partition for output.
    Input is:
        config: the current config (PartitionConfig)
    Returns:  A string
    """
    
    suba=""
    subb=""
    for el in config.subA:
        suba += str(el) + " "
    for el in config.subB:
        subb += str(el) + " "
    
    sol = "Subset A:" + "  " + str(suba) + "\n" + "Subset B:" + "  " + str(subb)
    
    return sol



def isGoal(config):
    """
    Checks whether a config is a goal (solution) or not.  Input is:
        config: The config (PartitionConfig)
    Returns: True if config is a goal, False otherwise
    """
    
    if len(config.input) == config.index:
        if (sum(config.subA)) == (sum(config.subB)):
            return True
        
    return False


    
def getSuccessors(config):
    """
    Get the successors of config.  Input is:
        config: The config (PartitionConfig)
    Returns: A list of successor configs (list of PartitionConfig)
    """
    
    successors = []
    if config.index != len(config.input):
        newConfigA = deepcopy(config) #copy
        newConfigB = deepcopy(config)
        
        newConfigA.subA.append(config.input[config.index]) #add values
        newConfigB.subB.append(config.input[config.index])
        
        newConfigA.index += 1 #move to next value
        newConfigB.index += 1
        
        successors.append(newConfigA) #add to list
        successors.append(newConfigB)
    
    return successors



def isValid(config):
    """
    Checks the config to see if it is valid.  Input is:
        config: The config (PartitionConfig)
    Returns: True if the config is valid, False otherwise
    """
    
    if sum(config.subA) > sum(config.input)//2 or sum(config.subB) > \
       sum(config.input)//2:
        return False
    else:
        return True


    
def solve(config, debug):
    """
    Generic backtracking solver.  Inputs are:
        config: the current config (PartitionConfig)
        debug: print debug output? (Bool)
    Returns:  A config (PartitionConfig), if valid, None otherwise
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
        Usage: python3 partition.py [filename] [debug]
            [filename]: The name of the input file
            [debug]: True or False for debug output
    """
    
    # if no command line arguments specified, prompt for the filename
    # and debug choice
    if len(argv) == 1:
        filename = input('Enter input file: ')
        #readline and strip to make list of ints
        debug = eval(input("Debug output (True or False): "))
    # otherwise, use the command line arguments
    elif len(argv) == 3:
        filename = argv[1]
        debug = eval(argv[2])
    # incorrect number of command line arguments
    else:
        print("Usage: python3 partition.py [filename debug]")
        print("optional command line arguments:" )
        print("  filename: The name of the input file")
        print("  debug: True or False for debug output")
        return -1
        
    # read and display the initial board
    initConfig = mkPartitionConfig(filename)
    
    # solve the puzzle
    solution = solve(initConfig, debug)
    
    # display the solution, if one exists
    if solution != None:
        print('Solution:\n' + mkConfigString(solution))
    else:
        print('There is no partition for the input data.')
 
# the program just calls main
if __name__ == '__main__':
    main()
