"""
Author: Jon O'Brien
Due date: 11/26/13
Assignment: Variable Length Coding lab

This program takes an input file, constructs a dictionary, then a heap from
that and sorts the symbols and adds codewords to them according to the
frequencies and the sorting algorithm of variable length coding.  The final
output is the symbol, frequency, codeword, and calculated vlc codeword length
and the fixed codeword length.  There are classes and constructors to hold
the objects used in the making of the heap and the comparisons and while loops
used to iterate over each node and compute the required output and calculations

"""
from array_heap import *
import math

class Symbol():
    """
    This class has slots for symbol, frequency, and codeword.  The symbol
    object used by it is initialized by the helper function of mkSymbol.

    """
    __slots__=("symbol","frequency","codeword")

    
def mkSymbol(letter,frequency,codeword):
    """
    This function is a constructor for the class Symbol, it holds attributes
    for symbol, frequency and codeword.  A Symbol object is initailized and
    a symbol is returned.
    """
    symbol = Symbol()
    symbol.symbol = letter
    symbol.frequency = frequency
    symbol.codeword=""
    return symbol


class Node():
    """
    This class has slots for totalFrequency and symbols. The node
    object used by it is initailized by the helper function of mkNode.
    """
    __slots__=("totalFrequency","symbols")


def mkNode(totalFrequency, symbols):
    """
    This function is a constructor for the class Node, it holds attributes for
    totalFrequency and symbols, and returns the node.  It initializes a node
    object after completion.
    """
    node=Node()
    node.totalFrequency = totalFrequency
    node.symbols=symbols
    return node
    

def myCompareFunc(node1,node2):
    """
    This function takes the first and second node and compares their total
    frequencies and returns a boolean True or False dependent on the first
    node being less than or equal to the second node.
    """
    if(node1.totalFrequency <= node2.totalFrequency):
        return True
    else:
        return False

def combine(heap):
    """
    This function takes a heap and removes the node with the 1st and 2nd
    lowest cumulative frequency, the root node of the heap, and prepends a
    "1" or a "0" to the codeword and does this for the entire heap until all
    the symbols have been iterated through for the heap.  The heap is
    reconstructed with these new nodes with the codewords and frequency
    counts correctly after the combinations are done.  The heap is returned.
    """
    while (heap.size > 1):
        node1 = removeMin(heap)
        node2 = removeMin(heap)
        for char in node1.symbols:
            char.codeword = "1" + char.codeword
        for char in node2.symbols:
            char.codeword = "0" + char.codeword
        newnode = mkNode(node1.totalFrequency + node2.totalFrequency, \
                         node1.symbols + node2.symbols)
        add(heap,newnode)
    return heap

def main():
    """
    This function takes an input file and iterates over the lines in the file
    and creates a dictionary and then a heap with the new compare function
    is made from that. Then the dictionary is iterated through and a list of
    symbols is made along with the nodes for the heap. Then the combine
    function is used to make the cumulative heap.  Then the output is
    constructed along with the values for the vlc and the fixed codewords.
    The correct output is printed according to the guidelines in the handouts.

    """
    file=open(input("enter file name"))
    freq={}
    
    for line in file:
        line.strip().replace(" ","")
        for char in line:
            if char in freq:
                freq[char] += 1
            else:
                freq[char] = 1
    newHeap = mkHeap(len(freq),myCompareFunc)
    
    for char in freq:
        mySymbol = mkSymbol(char, freq[char], "")
        mynode = mkNode(freq[char], [mySymbol])
        add(newHeap, mynode)
    combinedHeap = combine(newHeap)
    final = removeMin(combinedHeap)
    average = 0
    
    print("")
    print("Variable Length Code Output:")
    print("----------------------------")
    for char in final.symbols:
        print("Symbol: %2s" % char.symbol, " ", end='')
        print("Codeword: %8s" % char.codeword, " ", end='')
        print("Frequency: %5d" % char.frequency, " ", end='')
        print("")
        average += (len(char.codeword)*char.frequency)
        #add symbols and find the average
        
    average = (average/final.totalFrequency)
    diff = len(final.symbols)
    print("")
    print("Average VLC codeword length: ",average)
    print("Average Fixed length codeword length: ",math.log(diff,2))    
        
main()
