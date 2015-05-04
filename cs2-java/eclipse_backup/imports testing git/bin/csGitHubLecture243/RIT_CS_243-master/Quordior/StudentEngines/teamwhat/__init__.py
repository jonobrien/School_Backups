"""
Student Quoridor Engine Module        
Author: Adam Oest (amo9149@rit.edu)
    
This is where you will be able to define all the
methods that control the flow of execution of the game
"""
from Model.interface import PlayerMove
from Engine.security import GameException
from .engineData import * 
from .myQueue import *
from .myStack import *
import copy
import random

"""
Quoridor II: Student Engine
Author: Adam Oest (amo9149@rit.edu)

Implement the methods in the order you see them

Author: Nicolas Manoogian (njm7461@cs.rit.edu)
"""

def init(logger, config, studentModel):
    """
        Part 1 - 4
    
        The system calls this function once at the beginning of the game.
        The student engine uses this function to initialize its data
        structures to the initial game state.

        Parameters
            logger: a reference to the logger object. The player model uses
                logger.write(msg) and logger.error(msg) to log diagnostic
                information.
                
            config: a Python 'dict' structure that has mapped all the
                parameter names to their values, as specified in the
                config.cfg file.
        
            studentModel: reference to a StudentEngineModel object. See
                the documentation for that class in the file
                Model/interface.py. This engine calls the methods in
                that object.
        returns:
            a data structure that stores all of the engine's needed data
    """
    
    # Modify the EngineData class in engineData.py as needed, and create
    # additional files/classes for your board data
    engineData = EngineData(logger, config, studentModel)
    return engineData

def last_move(engineData, playerMove):
    """
        Parts 1 and 2 only; in parts 3 and 4, this engine will be controlling
        the players.
        
        The system calls this function after a player makes a valid move in
        the game. The student engine updates its data structure with the
        information about the move.

        Parameters
            engineData: this engine's data, originally built by this
                        module in init()
        
            playerMove: the instance of PlayerMove that describes the
                        move just made
        
        returns:
            this player module's updated (engineData) data structure
    """
    
    # Update your engineData board state here, incorporating the last move.
    if playerMove.move == False and validate_move(engineData, playerMove.getCopy()):
        engineData.walls.append(Wall(playerMove.r1, playerMove.c1, playerMove.r2, playerMove.c2))
        if engineData.players[playerMove.playerId-1].walls < engineData.config["NUM_WALLS"][len(engineData.config["PLAYER_MODULES"])]:
            engineData.players[playerMove.playerId-1].walls += 1
    elif playerMove.move == True and validate_move(engineData, playerMove.getCopy()):
        engineData.players[playerMove.playerId-1].r = playerMove.r2
        engineData.players[playerMove.playerId-1].c = playerMove.c2
    return engineData

def compareWalls(w1, w2):
    """
        Determines if two walls are the same
        
        Parameters
            w1 (Wall): First wall
            w2 (Wall): Second wall

        Returns
            Boolean: if the two walls are the same
    """
    if (w1.r1 == w2.r1 and w1.r2 == w2.r2) and (w1.c1 == w2.c1 and w1.c2 == w2.c2):
        return True
    elif (w1.r1 == w2.r2 and w1.r2 == w2.r1) and (w1.c1 == w2.c2 and w1.c2 == w2.c1):
        return True
    else:
        return False

def get_neighbors(engineData, r, c, checkPlayers):
    """
        Part 1
    
        This function is used only in part 1 mode. The system calls it after
        all PRE_MOVEs have been made. (See the config.cfg file.)

        Parameters
            engineData: the data originally built by this module in init()
            r: row coordinate of starting position for this player's piece
            c: column coordinate of starting position for this player's piece
        
        returns:
            a list of coordinate pairs (a list of lists, e.g. [[0,0], [0,2]],
            not a list of tuples) denoting all the reachable neighboring squares
            from the given coordinate. "Neighboring" means exactly one move
            away.
    """
    
    # Use your engineData object to get a list of neighbors  
    playerlocation = []
    if checkPlayers:
        for player in engineData.players:
            if player.id != engineData.playerturn:
                playerlocation.append((player.r, player.c))

    neighbors = []
    if r + 1 < 9:  # Bottom========================================
        # First Wall Start
        
        t1wall = Wall(r+1, c-1, r+1, c+1)
        t2wall = Wall(r+1, c, r+1, c+2)
        valid = True
        for curwall in engineData.walls:
            if compareWalls(t1wall, curwall):
                        
                        valid = False
            if compareWalls(t2wall, curwall):
                       
                        valid = False
        if valid == True and (r+1, c) in playerlocation:
            
            # If first wall passed... Check for pawn in space
            if (r+1,c) in playerlocation:
                # If there is a pawn, check for jump
                t1wall = Wall(r+2, c-1, r+2, c+1)
                t2wall = Wall(r+2, c, r+2, c+2)
                jumpValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall):
                        jumpValid = False
                    if compareWalls(t2wall, curwall):
                        jumpValid = False
                if jumpValid == True and (r+2, c) not in playerlocation:
                    neighbors.append([r+2, c])
                elif (r+2, c) in playerlocation or jumpValid == False:
                    #If you can't jump directly, check right for wall or pawn
                    t1wall = Wall(r+1, c+1, r+3, c+1)
                    t2wall = Wall(r, c+1, r+2, c+1)
                    rightValid = True
                    for curwall in engineData.walls:
                        if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                            rightValid = False
                    if rightValid == True and (r+1, c+1) not in playerlocation:
                        neighbors.append([r+1, c+1])
                    #Then check left for wall or pawn
                    t1wall = Wall(r+1, c-1, r+3, c-1)
                    t2wall = Wall(r, c-1, r+2, c-1)
                    leftValid = True
                    for curwall in engineData.walls:
                        if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                            leftValid = False
                    if leftValid == True and (r, c-1) not in playerlocation:
                        neighbors.append([r, c-1])
                    
        elif (r+1, c) not in playerlocation and valid == True:
            
            neighbors.append([r+1, c])


    if c + 1 < 9:  # Right========================================
       
        t1wall = Wall(r-1, c+1, r+1, c+1)
        t2wall = Wall(r, c+1, r+2, c+1)
        valid = True
        for curwall in engineData.walls:
            if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                valid = False
        if valid == True and (r, c+1) in playerlocation:
            t1wall = Wall(r-1, c+2, r+1, c+2)
            t2wall = Wall(r, c+2, r+2, c+2)
            jumpValid = True
            for curwall in engineData.walls:
                if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                    jumpValid = False
            if jumpValid == True and (r, c+2) not in playerlocation:
                neighbors.append([r,c+2])
            elif (r, c+2) in playerlocation or jumpValid == False:
                #check top
                t1wall = Wall(r, c+1, r, c+3)
                t2wall = Wall(r, c, r, c+2)
                topValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        topValid = False
                if topValid == True and (r-1, c+1) not in playerlocation:
                    neighbors.append([r-1, c+1])
                #check bottom
                t1wall = Wall(r+1, c+1, r+1, c+3)
                t2wall = Wall(r+1, c, r+1, c+2)
                bottomValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        bottomValid = False
                if bottomValid == True and (r+1, c+1) not in playerlocation:
                    neighbors.append([r+1, c+1])
        elif (r, c+1) not in playerlocation and valid == True:
            neighbors.append([r, c+1])

    if r - 1 >= 0:  # Top========================================
        
        t1wall = Wall(r, c, r, c+2)
        t2wall = Wall(r, c-1, r, c+1)
        valid = True
        for curwall in engineData.walls:
            if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                valid = False
        if valid == True and (r-1, c) in playerlocation:
            t1wall = Wall(r-1, c, r-1, c+2)
            t2wall = Wall(r-1, c-1, r-1, c+1)
            jumpValid = True
            for curwall in engineData.walls:
                if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                    jumpValid = False
            if jumpValid == True and (r-2, c) not in playerlocation:
                neighbors.append([r-2,c])
            elif (r-2, c) in playerlocation or jumpValid == False:
                #If you can't jump directly, check right for wall or pawn
                t1wall = Wall(r-1, c+1, r-3, c+1)
                t2wall = Wall(r, c+1, r-2, c+1)
                rightValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        rightValid = False
                if rightValid == True and (r-1, c+1) not in playerlocation:
                    neighbors.append([r-1, c+1])
                #Then check left for wall or pawn
                t1wall = Wall(r-1, c, r-3, c)
                t2wall = Wall(r, c, r-2, c)
                leftValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        leftValid = False
                if leftValid == True and (r-1, c-1) not in playerlocation:
                    neighbors.append([r-1, c-1])
        elif (r-1, c) not in playerlocation and valid == True:
            neighbors.append([r-1, c])

    if c - 1 >= 0:  # Left========================================
        
        t1wall = Wall(r, c, r+2, c)
        t2wall = Wall(r-1, c, r+1, c)
        valid = True
        for curwall in engineData.walls:
            if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                valid = False
        if valid == True and (r, c-1) in playerlocation:
            t1wall = Wall(r, c-1, r+2, c-1)
            t2wall = Wall(r-1, c-1, r+1, c-1)
            jumpValid = True
            for curwall in engineData.walls:
                if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                    jumpValid = False
            if jumpValid == True and (r, c-2) not in playerlocation:
                neighbors.append([r, c-2])
            elif (r, c-2) in playerlocation or jumpValid == False:
                #check top
                t1wall = Wall(r, c-1, r, c-3)
                t2wall = Wall(r, c, r, c-2)
                topValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        topValid = False
                if topValid == True and (r-1, c-1) not in playerlocation:
                    neighbors.append([r-1, c-1])
                #check bottom
                t1wall = Wall(r+1, c-1, r+1, c-3)
                t2wall = Wall(r+1, c, r+1, c-2)
                bottomValid = True
                for curwall in engineData.walls:
                    if compareWalls(t1wall, curwall) or compareWalls(t2wall, curwall):
                        bottomValid = False
                if bottomValid == True and (r+1, c-1) not in playerlocation:
                    neighbors.append([r+1, c-1])        
        elif (r, c-1) not in playerlocation and valid == True:
            neighbors.append([r, c-1])
    
    
    neighbors2 = []
    while len(neighbors) > 0:
        coord = neighbors.pop(0)
        if coord[0] >= 0 and coord[0] < 9 and coord[1] >= 0 and coord[1] < 9 :
            neighbors2.append(coord)
    
    
    return neighbors2

def get_shortest_path(engineData, r1, c1, r2, c2, playerCheck):
    """
        Part 1
    
        This function is only called in part 1 mode. The engine calls it when
        a shortest path is requested by the user via the graphical interface.

        Parameters
            engineData: the data originally built by this module in init()
            r1: row coordinate of starting position
            c1: column coordinate of starting position
            r2: row coordinate of destination position
            c2: column coordinate of destination position
        
        returns:
            a list of coordinates that form the shortest path from the starting
            position to the destination, inclusive. The format is an ordered
            list of coordinate pairs (a list of lists, e.g.,
            [[0,0], [0,1], [1,1]], not a list of tuples).
            If there is no path, an empty list, [], should be returned.
    """
    
    # Use your engineData object to find a shortest path using breadth-first
    # search (BFS).
    # You will probably find the get_neighbors function helpful.
    
    # Replace the line below with your computations.
    source = [r1, c1]
    destination = [r2, c2]
    # 'prime' the dispenser with the source 
    dispenser = Queue()
    enqueue(source, dispenser)

    # construct the predecessors data structure
    predecessors = {}
    predecessors[str(source)] = None

    # loop until either the destination is found or the dispenser 
    # is empty (no path)
    while not emptyQueue(dispenser):
        current = front(dispenser)
        dequeue(dispenser)
        if current == destination:
            break
        # loop over all neighbors of current
        for neighbor in get_neighbors(engineData, current[0], current[1], playerCheck):
            # process unvisited neighbors
            if str(neighbor) not in predecessors:
                predecessors[str(neighbor)] = current
                enqueue(neighbor, dispenser)
        
    stack = Stack()
    if str(destination) in predecessors:
        tmp = destination
        while tmp != source:
            push(tmp, stack)
            tmp = predecessors[str(tmp)]
        push(source, stack)
        
    path = []
    while not emptyStack(stack):
        path.append(top(stack)) 
        pop(stack)   
    return path

def validate_move(engineData, playerMove):
    """
        Check to see if the given move is valid for the given game state.
        
        In part 2 this function is called by the system.
        In parts 3 and 4 the function is called internally by the player
        engine itself from next_move().

        Parameters
            engineData: the data originally built by this module in init()
                        (used to establish the context of the move)
            playerMove: the instance of PlayerMove that describes the
                        move just made
        Returns: a bool representing whether or not the given move is valid
    """
    if playerMove.playerId != engineData.playerturn:
        engineData.logger.write("Player " + str(playerMove.playerId) + " has moved out of turn.")
        return False

    if playerMove.move == False:    # Wall move
        midr = (playerMove.r2 + playerMove.r1) / 2
        midc = (playerMove.c2 + playerMove.c1) / 2
        if engineData.players[playerMove.playerId-1].walls >= engineData.config["NUM_WALLS"][len(engineData.players)]:
            engineData.logger.write("Player " + str(playerMove.playerId) + " out of walls")
            return False
        if playerMove.r1 != playerMove.r2 and playerMove.c2 != playerMove.c1:
            engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " is diagonal, or misordered")
            return False
        if playerMove.r1 == playerMove.r2 and playerMove.c2 - playerMove.c1 != 2:
            engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " is not 2 units, is diagonal, or misordered")
            return False
        if playerMove.c1 == playerMove.c2 and playerMove.r2 - playerMove.r1 != 2:
            engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " is not 2 units, is diagonal, or misordered")
            return False
        if (midr == 0 or midr == 9 or midc == 0 or midc == 9):
            engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " is along the edge")
            return False
        for wall in engineData.walls:
            if wall.midr == midr and wall.midc == midc:
                engineData.logger.write("This wall causes and intersection at " + str(midr) + ", " + str(midc))
                return False
            if (wall.midr == playerMove.r1 or wall.midr == playerMove.r2) and (midr == wall.r1 or midr == wall.r2) and (wall.c1 == playerMove.c1):
                engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " causes an row intersection with " + str(wall.r1) + ", " + str(wall.c1) + ", " + str(wall.r2) + ", " + str(wall.c2))
                return False
            if (wall.midc == playerMove.c1 or wall.midc == playerMove.c2) and (midc == wall.c1 or midc == wall.c2) and (wall.r1 == playerMove.r1):
                engineData.logger.write("Wall " + str(playerMove.r1) + ", " + str(playerMove.c1) + ", " + str(playerMove.r2) + ", " + str(playerMove.c2) + " causes an column intersection with " + str(wall.r1) + ", " + str(wall.c1) + ", " + str(wall.r2) + ", " + str(wall.c2))
                return False
        
        tempWalls = copy.deepcopy(engineData.walls)
        engineData.walls.append(Wall(playerMove.r1, playerMove.c1, playerMove.r2, playerMove.c2))
        playershavepaths = []
        for p in engineData.players:
            if p.id == 1:
                targetrow = [(0,0),(0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(0,7),(0,9)]
            elif p.id == 2:
                targetrow = [(8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7),(8,9)]
            elif p.id == 3:
                targetrow = [(0,8),(1,8),(2,8),(3,8),(4,8),(5,8),(6,8),(7,8),(8,8)]
            elif p.id == 4:
                targetrow = [(0,0),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0),(8,0)]
            else:
                targetrow = []
                
            pcheck = False
            # print(p.id)
            for coord in targetrow:
                if len(get_shortest_path(engineData, p.r, p.c, coord[0], coord[1], False)) != 0:
                    pcheck = True
            playershavepaths.append(pcheck)
        engineData.walls = copy.deepcopy(tempWalls)
        if False in playershavepaths:
            # Player is allowed to pass because his (or her, don't be sexist now) path is blocked
            if playerMove.c1 == playerMove.c2 and playerMove.r1 == playerMove.c1:
                return True
            engineData.logger.write("Wall will block player " + str(playershavepaths.index(False) + 1) + " path ")
            return False
        else:
            return True
                
    else:   # Pawn move
        if playerMove.r1 != engineData.players[playerMove.playerId-1].r or playerMove.c1 != engineData.players[playerMove.playerId-1].c:
            engineData.logger.write("Player move is at incorrect start location [" + str(playerMove.r1) + ", " + str(playerMove.c1)+"]")
            return False
        
        for p in engineData.players:
            if (playerMove.r2 == p.r and playerMove.c2 == p.c) and (playerMove.r1 != playerMove.r2 and playerMove.c1 != playerMove.c2):
                engineData.logger.write("Player is trying to move into another")
                return False
        if playerMove.r2 >= 9 or playerMove.r2 < 0 or playerMove.c2 >= 9 or playerMove.c2 < 0:
            engineData.logger.write("Player move out of bounds")
            return False
        pathlen = get_shortest_path(engineData, playerMove.r1, playerMove.c1, playerMove.r2, playerMove.c2, True)
        if len(pathlen) > 2 or len(pathlen) == 0:
            playerlocation = []
            for player in engineData.players:
                if player.id != engineData.playerturn:
                    playerlocation.append((player.r, player.c))
            engineData.logger.write("Illegal multi-square move " + str(pathlen) + " player locations: " + str(playerlocation))
            return False
        
        return True

def initialize_player(engineData, playerNum):
    """
        Part 3 and 4
        The system calls this function when it wants the student engine
        to initialize a specific player module via its init() function.
        
        Reference file for init(): StudentPlayers/RenameYourPlayer/__init__.py
        
        Parameters
            engineData: the data originally built by this module in init()
                        (used to establish the context of the move)
            playerNum: the number of the player (in [0 .. n-1] for n players)

        returns: the engine data, modified
    """
    
    # Step 1
    # Fetch the reference to the model from your engineData.
    model = engineData.model
    
    # Step 2
    # Get the player module from the model using model.getPlayerModule.
    playerModule = model.getPlayerModule(playerNum)
    
    # Step 3
    # Call the chosen player module's init function with the appropriate data.
    #
    # Tips:
    # logger was already given to you in your own init method
    # numWalls depends on the number of players and is accessible through the
    #     NUM_WALLS key in the config dictionary
    # playerHomes may only include home locations for active players in the game
    #     and it must be a tuple, not a list.

    if len(engineData.config["PLAYER_MODULES"]) == 1:
        homeloc = [(8, 4)]
    if len(engineData.config["PLAYER_MODULES"]) == 2:
        homeloc = [(8, 4),(0, 4)]
    if len(engineData.config["PLAYER_MODULES"]) == 3:
        homeloc = [(8, 4),(0, 4),(4, 0)]
    if len(engineData.config["PLAYER_MODULES"]) == 4:
        homeloc = [(8, 4),(0, 4),(4, 0),(4, 8)]

    player = playerModule.init(engineData.logger, playerNum, engineData.config["NUM_WALLS"][len(engineData.config["PLAYER_MODULES"])], homeloc)
    
    # Step 4
    # Save the player data using StudentEngineModel's setPlayerData method.
    # The StudentEngineModel object should have been saved when your init
    # function was called.
    
    model.setPlayerData(playerNum, player)
    engineData.players.append(Player(playerNum, homeloc[playerNum-1][0], homeloc[playerNum-1][1]))
    return engineData

def next_move(engineData):
    """
        Part 3 and 4
        
        Ask the module of the player whose turn it is for its next move
        (player's move function.)
        Check the move for validity. If invalid, exit_due_to_error is called.
        If valid, all player modules are notified of the move via last_move.

        Process the next move, sending it to the engine
                      and notifying other players
        
                      
        Parameters
            engineData: the data originally built by this module in init()
                        (used to establish the context of the move)
            playerNum: the number of the player (in [0 .. n-1] for n players)

        returns: the engine data, modified by the actions described above
    """
    
    # Step 1
    # Get playerMove object from the current player using player module's move
    # function.
    # (At this point you do not need to record any player's playerData.)
    engineModel = engineData.model
    engineModule = engineData.model.getPlayerModule(engineData.playerturn)
    if len(engineData.preMoves) > 0:
        # still preMoves left, use that instead of asking player
        # note that pop removes from the list and returns the first item
        playerMove = engineData.preMoves.pop(0)
    else:
        # Get move from player (i.e. the normal case)
        # obtain the right player module and their player data from the model
        playerMove = engineModule.move(engineModel.getPlayerData(engineData.playerturn))

    # Step 2
    # Validate the move.
    if not validate_move(engineData, playerMove.getCopy()):
        exit_due_to_error(playerMove.getCopy())
    else:
        last_move(engineData, playerMove.getCopy())
        engineData.model.makeMove(playerMove.getCopy())
        for i in range(1,len(engineData.config['PLAYER_MODULES'])+1):
            player = engineData.model.getPlayerModule(i)
            player.last_move(engineData.model.getPlayerData(i), playerMove.getCopy())
            engineData.model.setPlayerData(i, engineData.model.getPlayerData(i))
    
    # Increment player turn
    if engineData.playerturn == len(engineData.config['PLAYER_MODULES']):
        engineData.playerturn = 1
    else:
        engineData.playerturn += 1

    # Step 3
    # If it is invalid:
    #     Call exit_due_to_error (contained in this file).
    # else:
    #     Update your engineData board state.
    #     Call the makeMove function in your model object.
    #         The StudentEngineModel object should have been saved when your
    #         init function was called.
    #
    #     Notify all players of this move by doing the following
    #         for each player:
    #             Call player.last_move(playerData, playerMove).
    #             Save the player's returned playerData using
    #                                           model.setPlayerData
    #
    #     [ !!! Obtain playerData using model.getPlayerData ??? ]
    
    # Safety tip: rather than passing the playerMove object, pass a copy of it
    # by calling playerMove.getCopy() to ensure that there is no harm done if
    # the original object gets modified.

    # Development tip: Disable AUTO_PLAY in config.cfg while developing this.

    return engineData

def exit_due_to_error(message):
    """
        Part 3 and 4: Exit the program 
                      after a player makes an illegal move
        This is an INTERNAL function called from next_move above, when
        that function has determined that the move chosen by the player
        violates the rules of the game.

        Parameters
            message: the error message to be displayed in the user interface
    """
    
    # NOTE: You do not need to edit the code in this function at all!
    
    raise GameException(message)

def generate_board(engineData):
    """    
        Part 4: Generate a symmetric board configuration
        
        engineData: your engine state
        
        moveExecFunction: call with moves
        
        returns: your engine state
    """
    # Hint: disable AUTO_PLAY while developing this
        
    
    # numWalls equals the value of the STUDENT_ENGINE_WALLS config parameter
    # this controls how many PlayerMoves you generate in this function
    # note that this number should always be even due to the asymmetry of the
    # game board
    random.seed()
    
    numWalls = engineData.config["STUDENT_ENGINE_WALLS"]

    
    # Generate PlayerMoves to be made
    
    # For each move:
    #     call model.makeMove(playerMove)
    #     notify players of this move
    
    while numWalls > 0:
        row1 = random.randint(2,7)  # Row1
        col1 = random.randint(0,2)  # Col1
        vert = False
        if random.randint(0,1) == 0:
            vert = True

#        if random.randint(0,1) == 0:
#            num3 += 2
#        else:
#            num4 += 2
#        print(num1,num2,num3,num4)
        wallmoves = []
        
        # First Player Wall
        if vert == True:
            wallmoves.append(PlayerMove(engineData.playerturn, False, row1, col1, row1+2, col1))
        else:
            wallmoves.append(PlayerMove(engineData.playerturn, False, row1, col1, row1, col1+2))
        # Second Player (if existent)
        if len(engineData.players) > 1:
            if vert == True:
                wallmoves.append(PlayerMove(engineData.playerturn, False, 7-row1, 9-col1, 9-row1, 9-col1))
            else:
                wallmoves.append(PlayerMove(engineData.playerturn, False, 9-row1, 7-col1, 9-row1, 9-col1))
        # Third and Fourth Player Moves (if existent)
        if len(engineData.players) > 2:
            # Third
            if vert == True:
                wallmoves.append(PlayerMove(engineData.playerturn, False, col1, 9-row1, col1, 7-row1))
            else:
                wallmoves.append(PlayerMove(engineData.playerturn, False, col1, 9-row1, col1+2, 9-row1))
            # Fourth
            if vert == True:
                wallmoves.append(PlayerMove(engineData.playerturn, False, 9-col1, row1, 9-col1, row1+2))
            else:
                wallmoves.append(PlayerMove(engineData.playerturn, False, 7-col1, row1, 9-col1, row1))
                
        # Validation
        valid = True
        for v in wallmoves:
            if not validate_move(engineData, v.getCopy()):
                valid = False
                
        if valid == True:
            for w in wallmoves:
                w.playerId = engineData.playerturn
                # print(w, engineData.playerturn)

                last_move(engineData, w.getCopy())
                engineData.model.makeMove(w.getCopy())
                for i in range(1,len(engineData.config['PLAYER_MODULES'])+1):
                    player = engineData.model.getPlayerModule(i)
                    player.last_move(engineData.model.getPlayerData(i), w.getCopy())
                    engineData.model.setPlayerData(i, engineData.model.getPlayerData(i))
                if engineData.playerturn == len(engineData.config['PLAYER_MODULES']):
                    engineData.playerturn = 1
                else:
                    engineData.playerturn += 1
            numWalls-=1
            
        # Need to send these walls directly to board so they get checked against each other
    
    return engineData
    