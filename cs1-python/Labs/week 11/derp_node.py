"""
141 Tree Lab - Derp the Interpreter

These are the definitions of the node classes and maker functions that
are used by the interpreter. It is meant to be imported by the main program.

Author: Sean Strout (sps@cs.rit.edu)

Author: Jon O'Brien
Due Date: 11/19/13
Assignment: Derp the Interpreter
"""

##############################################################################
# structure definitions for parse tree
##############################################################################

class MultiplyNode:
    """Represents an multiply operator, *"""
    
    __slots__ = ('left', 'right')
    
class DivideNode:
    """Represents an integer divide operator, //"""

    __slots__ = ('left', 'right')
    
class AddNode:
    """Represents an addition operator, +"""

    __slots__ = ('left', 'right')
    
class SubtractNode:
    """Represents an addition operator, -"""

    __slots__ = ('left', 'right')
    
class LiteralNode:
    """Represents an operand node"""
    
    __slots__ = ('val')
    
class VariableNode:
    """Represents a variable node"""
    
    __slots__ = ('name')
    
##############################################################################
# structure creation routines for parse tree
##############################################################################
        
def mkMultiplyNode(left, right):
    """mkMultiplyNode(): Node * Node -> MultiplyNode
    Creates and returns an multiply node."""
    
    node = MultiplyNode()
    node.left = left
    node.right = right
    return node
    
def mkDivideNode(left, right):
    """mkDivideNode(): Node * Node -> DivideNode
    Creates and returns an divide node."""

    node = DivideNode()
    node.left = left
    node.right = right
    return node

def mkAddNode(left, right):
    """mkAddNode(): Node * Node -> AddNode
    Creates and returns an add node."""

    node = AddNode()
    node.left = left
    node.right = right
    return node

def mkSubtractNode(left, right):
    """mkSubtractNode(): Node * Node -> SubtractNode
    Creates and returns a subtract node."""

    node = SubtractNode()
    node.left = left
    node.right = right
    return node    
    
def mkLiteralNode(val):
    """mkOperatorNode(): int -> LiteralNode
    Creates and returns a literal node."""
    
    node = LiteralNode()
    node.val = val
    return node
    
def mkVariableNode(name):
    """mkVariableNode(): String -> VariableNode
    Creates and returns an variable node."""

    node = VariableNode()
    node.name = name
    return node
