class NoneNode():
    __slots__ = ()

NONE_NODE = NoneNode()
    
class Node():
    __slots__ = ( 'data', 'next' )  
    
def mkNode(dataVal, nextVal):
    """Create and return a newly initialized Node object"""
    node = Node()
    node.data = dataVal
    node.next = nextVal
    return node
