"""
141 Tree Lab - Derp the Interpreter
 
Derp is a simple interpreter that parses and evaluates preorder expressions
containing basic arithmetic operators (*,//,-+).  It performs arithmetic with
integer only operands that are either literals or variables (read from a
symbol table).  It dumps the symbol table, produces the expression infix with
parentheses to denote order of operation, and evaluates/produces the result of
the expression.
 
Author: Sean Strout (sps@cs.rit.edu)
 
Author: Ranbir Aulakh (rsa5330@g.rit.edu)
"""
 
from derp_node import *
 
def parse(tokens, i = 0):
    """parse: tuple(String) * int -> (Node, int)
   From an infix stream of tokens, and the current index into the
   token stream, construct and return the tree, as a collection of Nodes,
   that represent the expression.
   
   NOTE:  YOU ARE NOT ALLOWED TO MUTATE 'tokens' (e.g. pop())!!!  YOU
       MUST USE 'i' TO GET THE CURRENT TOKEN OUT OF 'tokens'
   """
    if tokens[i] == '+':
        left, i = parse(tokens, i+1)
        right, i = parse(tokens, i)
        return mkAddNode(left, right), i
    elif tokens[i] == '-':
        left, i = parse(tokens, i+1)
        right, i = parse(tokens, i)
        return mkSubtractNode(left, right), i
    elif tokens[i] == '*':
        left, i = parse(tokens, i+1)
        right, i = parse(tokens, i)
        return mkMultiplyNode(left, right), i
    elif tokens[i] == '//':
        left, i = parse(tokens, i+1)
        right, i = parse(tokens, i)
        return mkDivideNode(left, right), i
 
    elif tokens[i].isdigit():
        return mkLiteralNode(tokens[i]), i+1
    else:
        return mkVariableNode(tokens[i]), i+1
    raise TypeError("Error: Invalid Input!")
               
##############################################################################
# infix
##############################################################################
       
def infix(node):
    """infix: Node -> String | TypeError
   Perform an inorder traversal of the node and return a string that
   represents the infix expression."""
 
    if isinstance(node, MultiplyNode):
        return "(" + infix(node.left) + " * " + infix(node.right) + ")"
    elif isinstance(node, DivideNode):
        return "(" + infix(node.left) + " // " + infix(node.right) + ")"
    elif isinstance(node, AddNode):
        return "(" + infix(node.left) + " + " + infix(node.right) + ")"
    elif isinstance(node, SubtractNode):
        return "(" + infix(node.left) + " - " + infix(node.right) + ")"
    elif isinstance(node, VariableNode):
        return node.name
    elif isinstance(node, LiteralNode):
        return node.val
    else:
        TypeError("Error: Invalid Input!")
   
##############################################################################
# evaluate
##############################################################################    
     
def evaluate(node, symTbl):
    """evaluate: Node * dict(key=String, value=int) -> int | TypeError
   Given the expression at the node, return the integer result of evaluating
   the node.
   Precondition: all variable names must exist in symTbl"""
 
    if isinstance(node, MultiplyNode):
        return evaluate(node.left,symTbl) * evaluate(node.right,symTbl)
    elif isinstance(node, DivideNode) :
        return evaluate(node.left,symTbl) // evaluate(node.right,symTbl)
    elif isinstance(node, AddNode) :
        return evaluate(node.left,symTbl) + evaluate(node.right,symTbl)
    elif isinstance(node, SubtractNode) :
        return evaluate(node.left,symTbl) - evaluate(node.right,symTbl)
    elif isinstance(node, VariableNode) :
        return int(symTbl[node.name])
    elif isinstance(node, LiteralNode) :
        return int(node.val)
    else:
        TypeError("Error: Invalid Input!")
   
   
##############################################################################
# main
##############################################################################
                     
def main():
    """main: None -> None
   The main program prompts for the symbol table file, and a prefix
   expression.  It produces the infix expression, and the integer result of
   evaluating the expression"""
   
    print("Hello Herp, welcome to Derp v1.0 :)")
 
    inFile = input("Herp, enter symbol table file: ")
 
    symTbl = {}
    for line in open(inFile):
        lineStrip = line.split()
        symTbl[lineStrip[0]] = int(lineStrip[1])
 
    print("Derping the symbol table (variable name => integer value)")
 
    for nameNnums in sorted(symTbl):
        print("Variable name:", nameNnums, "=>", symTbl[nameNnums])
   
    # STUDENT: CONSTRUCT AND DISPLAY THE SYMBOL TABLE HERE done
   
    print("Herp, enter prefix expressions, e.g.: + 10 20 (RETURN to quit)...")
 
   
    # input loop prompts for prefix expressions and produces infix version
    # along with its evaluation
   
    while True:
        tokens = []
        prefixExp = input("derp> ")
        if prefixExp == "":
            break
       
        # STUDENT: GENERATE A LIST OF TOKENS FROM THE PREFIX EXPRESSION done
 
        tokens = prefixExp.split()
       
        # STUDENT: CALL parse WITH THE LIST OF TOKENS AND SAVE THE ROOT OF
        # THE PARSE TREE done
 
        root,i = parse(tokens, i = 0)
       
        # STUDENT: GENERATE THE INFIX EXPRESSION BY CALLING infix AND SAVING
        # THE STRING    
       
        print("Derping the infix expression:", infix(root))
 
        # STUDENT: EVALUTE THE PARSE TREE BY CALLING evaluate AND SAVING THE
        # INTEGER RESULT
       
        print("Derping the evaluation:", evaluate(root,symTbl))
       
    print("Goodbye Herp :(")
   
if __name__ == "__main__":
    main()
