"""
Quoridor II: Student Computer Engine

A sample class you may use to hold your state data
Author: Adam Oest (amo9149@rit.edu)

Author: Nicolas Manoogian (njm7461@cs.rit.edu)
"""

class EngineData(object):
    """A sample class for your engine data"""
    
    # Add other slots as needed
    __slots__ = ('logger', 'config', 'model', 'walls', 'playerturn', 'players', 'preMoves')
    
    def __init__(self, logger, config, model):
        """
            Constructs and returns an instance of EngineData
            
            You decide what parameters and slots to use.  This is just a 
            minimal example.
        """
        
        self.logger = logger
        self.config = config
        self.model = model
        self.walls = []
        self.players = []
        self.playerturn = 1
        self.preMoves = config['PRE_MOVE']
        
    def __str__(self):
        """
        __str__: EngineData -> string
        Returns a string representation of the EngineData object.
            self - the EngineData object
        """
        result = "EngineData= " \
                    + "logger: " + str(self.logger) \
                    + ", config: " + str(self.config) \
                    + ", model: " + str(self.model)
                
        # add any more string concatenation for your other slots here
                
        return result
    
class Wall(object):
    __slots__ = ('r1', 'c1', 'r2', 'c2', 'midr', 'midc')
    
    def __init__(self, r1, c1, r2, c2):
        self.r1 = r1
        self.r2 = r2
        self.c1 = c1
        self.c2 = c2
        self.midr = (r1 + r2) / 2
        self.midc = (c1 + c2) / 2

    
    def __str__(self):
        return self.r1, self.c1, self.r1, self.c2

class Player(object):
    __slots__ = ('id', 'r', 'c', 'walls')
    def __init__(self, id, r, c):
        self.id = id
        self.r = r
        self.c = c
        self.walls = 0
        