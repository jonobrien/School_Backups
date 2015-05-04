                                                                     
                                                                     
                                                                     
                                             
""" 
file: hashtable.py
language: python3
author: sps@cs.rit.edu Sean Strout 
author: jeh@cs.rit.edu James Heliotis 
author: anh@cs.rit.edu Arthur Nunes-Harwitt
author: jsb@cs.rit.edu Jeremy Brown
description: open addressing Hash Table for CS 141 Lecture
"""

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


def hash_function( val, n ):
    """
       Compute a hash of the val string that is in [0 ... n).
    """
    
    hashcode = 0
    hashcode = len(val) % n
    return hashcode

def new_hash(val, n):
    a=.5
    hashcode = (((val * .5)*n) % 1)
    return hashcode
    
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
    print( ratio )
    if ratio >= .75:
        hTable = rehash( hTable )
    index = hash_function( key, len( hTable.table ) )
    if hTable.table[ index ] == []:
        hTable.table[ index ] = [ _Entry ]
        hTable.size += 1
    else:
        for i in range( len( hTable.table[ index ] ) ):
            if hTable.table[ index ][ i ].key == key:
                hTable.table[ index ][ i ].value = value
                return True
        hTable.table[ index ].append( _Entry )
    imbalance( hTable )
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
        preconditions: none
    """
    numOfChains = 0
    sum = 0
    for i in range( len( hTable.table ) ):
        if hTable.table[ i ] != []:
            sum += len( hTable.table[ i ] )
            numOfChains += 1
    print( str( sum ) + ", " + str( numOfChains ) )
    avg =  sum / numOfChains
    print ( avg - 1 )
 
def load( hTable ):
    """
        Checks ratio of items in table to table size
    """
    sum = 0
    size = len( hTable.table )
    for i in range( size ):
        sum += len( hTable.table[ i ] )
    return sum / size
 
def rehash( hTable ):
    """
        Performs a rehash every time the table starts to fill up.
    """
    newN = ( 2 * len( hTable.table ) ) + 1
    print( "New capacity: " + str( newN ) )
    newTable = mkHashTable( newN )
    for i in range( len( hTable.table ) ):
        for item in hTable.table[ i ]:
            index = hash_function( item.key, newN )
            newTable.table[ index ] = [ HashTable._Entry( item.key, item.value ) ]
    hTable.table = copy.deepcopy( newTable.table )
