"""
Jon O'Brien
10/29/13
lab7-hashtables
"""
                                                                     
                                                                     
                                             
""" 
file: hashtable.py
language: python3
author: sps@cs.rit.edu Sean Strout 
author: jeh@cs.rit.edu James Heliotis 
author: anh@cs.rit.edu Arthur Nunes-Harwitt
author: jsb@cs.rit.edu Jeremy Brown
description: open addressing Hash Table for CS 141 Lecture
"""
import copy
class HashTable( ):
    """
       The HashTable data structure contains a collection of values
       where each value is located by a hashable key.
       No two values may have the same key, but more than one
       key may have the same value.
    """

    __slots__ = ( "table", "size" )


def mkHashTable(capacity):
  hTable = HashTable()
  hTable.table = [[] for _ in range(capacity)]
  hTable.size = 0
  return hTable

def HashTableToStr(hashtable):
  result = ""
  for i in range( len( hashtable.table ) ):
      if i != None:
          result += str( i ) + ": "
          result += EntryToStr( hashtable.table[i] ) + "\n"
  return result


class _Entry( ):
    """
       A class used to hold key/value pairs.
    """

    __slots__ = ( "key", "value" )


def EntryToStr(entry):
  """
       return the string representation of the entry.
  """
  return "(" + str( entry.key ) + ", " + str( entry.value ) + ")" 

def mkEntry(key, value):
  aEntry = _Entry()
  aEntry.key = key
  aEntry.value = value
  return aEntry


def old_hash( val, n ):
    """
       Compute a hash of the val string that is in [0 ... n), this came with the file.
    """
    hashcode = hash( val ) % n
    # hashcode = 0
    # hashcode = len(val) % n
    return hashcode

def new_hash(val, n):
    """
    another method to acquire the hashcodes.

    """
    number = 0
    for letter in val:
        number = number + ord(letter) #turn the letter into a number
    return number%n

def hash_function( val, n ):
    """
       Compute a hash of the val string with ordinal values, computing hascodes.
    """
    
    a=.5
    hashcode = int((((len(val) * .5)*n) % 2))
    return hashcode

    
    
##        """
##           Compute a hash of the val string that is in [0 ... n).
##        """
##        number = 0
##        for letter in val:
##            number = number + ord(letter) #turn the letter into a number
##        return number%n
##    a=.5
##    hashcode = int((((len(val) * .5)*n) % 2))
##    return hashcode
    
def keys( hTable ):
    """
       Return a list of keys in the given hashTable.
    """
    result = []
    for item in hTable.table:
        if item != []:
            for entry in item:
                result.append( entry.key )
    return result

def contains( hTable, key ):
    """
       Return True iff hTable has an entry with the given key.
    """
    index = hash_function( key, len( hTable.table ) )
    lst = hTable.table[ index ]
    for i in lst:
        if i.key == key:
            return True
    return False

def put( hTable, key, value ):
    """
       Using the given hash table, set the given key to the
       given value. If the key already exists, the given value
       will replace the previous one already in the table.
       If the table is full, an Exception is raised.
    """
    ratio = load( hTable )
    #print( ratio )#prints the load for a check for rehashing
    if ratio >= .75:
        rehash( hTable)
    index = hash_function( key, len( hTable.table ) )
    if hTable.table[ index ] == []:
        hTable.table[ index ] = [ mkEntry(key, value) ]
        hTable.size += 1
    else:
        for i in range( len( hTable.table[ index ] ) ):
            if hTable.table[ index ][ i ].key == key:
                hTable.table[ index ][ i ].value = value
                return True
        hTable.table[ index ].append( mkEntry(key, value))
                                                          
    return True

 
def get( hTable, key ):
    """
       Return the value associated with the given key in
       the given hash table.
       Precondition: contains(hTable, key)
    """
    index = hash_function( key, len( hTable.table ) )
    if hTable.table[ index ] == []:
        raise Exception( "Hash table does not contain key." )
    else:
        lst = hTable.table[ index ]
        for i in lst:
            if i.key == key:
                return i.value
        raise Exception( "Hash table does not contain key." )
 

def imbalance( hTable ):
    """
        Compute average length of all non-empty chains
        This function takes the parameter of the hashtable that is used in the
        program to store the key-value pairs.
    """
    numOfChains = 0
    total = 0
    for i in range( len( hTable.table ) ):
        if hTable.table[ i ] != []:
            total += len( hTable.table[ i ] )
            numOfChains += 1
    avg =  (total / numOfChains)-1
    return avg


 
def load( hTable ):
    
    """
        Checks ratio of items in table to table size, to determine  the load on
        the hashtable, for rehashing.
    """
    total = 0
    size = len( hTable.table )
    for i in range( size ):
        total += len( hTable.table[ i ] )
    
    return total/size

 
def rehash( hTable):
    """
        Performs a rehash every time the table starts to fill up, determined by
        the load on the table.
    """
    #print("######IN REHASH #############")
    newN = ( 2 * len( hTable.table ) ) + 1
    print(newN)#testing
    #print( "New capacity: " + str( newN ) )
    newTable = mkHashTable( newN )
    for i in range( len( hTable.table ) ):
        for item in hTable.table[ i ]:
            myKey = item.key
            myValue = item.value
            #print("in inner for loop")
            #print("#####", myKey, myValue, "####")
            put(newTable, myKey, myValue)
    hTable.table = newTable.table
    hTable.size = newTable.size
    print("end")
    return newTable
