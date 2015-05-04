"""
Author: Jon O'Brien
Due Date: 11/16/17
Assignment: Binary Search Tree

This program makes a binary search tree.
"""

class EmptyMap():
    """

    """
    __slots__ = ()

class nonEmptyMap():
    """

    """
    __lslots __ = ("right", "left", "key", "value")
    
def mkEmptyMap():
    """

    """
    return EmptyMap()

def mknonEmptyMap():
    """

    """
    nonEmpty=nonEmptyMap()
    nonEmpty.right=right
    nonEmpty.left=left
    nonEmpty.key=key
    nonEmpty.value=value
    return nonEmpty




##    
##def insert(key,value,nonEmpty):
##    if nonEmpty.value > btreeNode.value: #insert left
##        if nonEmpty.left == None:
##            nonEmpty.left = btreeNode
##        else:
##            nonEmpty.left.insert(btreeNode)
##    else: #insert right
##        if nonEmpty.right == None:
##            nonEmpty.right = btreeNode
##        else:
##            nonEmpty.right.insert(btreeNode)


def insert(self,node,someNumber):
    #http://stackoverflow.com/questions/5444394/implementing-binary-search-tree-in-python
        if node is None:
            node = Node(someNumber)
        else:
            if node.data > someNumber:
                self.insert(node.rchild,someNumber)
            else:
                self.insert(node.rchild, someNumber)
        return  


##  def insert(self, value):
    #http://code.activestate.com/recipes/577540-python-binary-search-tree/
##        """
##        Insert the specified value into the BST.
##        """
##        # Get the sort key for this value.
##        if self._sort_key is None:
##            sort_key = value
##        else:
##            sort_key = self._sort_key(value)
##        # Walk down the tree until we find an empty node.
##        node = self._root
##        while node:
##            if sort_key < node[_SORT_KEY]:
##                node = node[_LEFT]
##            else:
##                node = node[_RIGHT]
##        # Put the value in the empty node.
##        if sort_key is value:
##            node[:] = [[], [], value]
##        else:
##            node[:] = [[], [], value, sort_key]
##        self._len += 1
##


def mapInsert1(key, value, node):
    #http://stackoverflow.com/questions/13205212/binary-search-tree-insert-function
    if isinstance(node, EmptyMap):
        node = mkNonEmptyMap(mkEmptyMap(), key, value, mkEmptyMap())
        return node
    else:
        if key > node.key:
            return mapInsert1(key, value, node.right)
        elif key < node.key:
            return mapInsert1(key, value, node.left)
        elif key == node.key:
            node.value = value
            return mapInsert1(key, value, node)
        else:
            raise TypeError('Bad Map')


def mapInsert2(key, value, node):
    #http://stackoverflow.com/questions/13205212/binary-search-tree-insert-function
    if node == None:
        print '0'
        node.insert(mkEmptyMap(), key, value, mkEmptyMap())
        return node
    else:
        if key > node.key:
            print '1'
            return mapInsert2(key, value, node.right)
        elif key < node.key:
            print '2'
            return mapInsert2(key, value, node.left)
        elif key == node.key:
            print '3'
            node.value = value
            return node
        else:
            raise TypeError('Bad Map')





