"""
Edited by: Jon O'Brien
Due date: 10/29/13
lab8 - hash tables

This program is used by word_cout.py to take an input text file and output the
number of unique words, total number of words, the words that appeared the most,
and the word count.  A hash table was used to store the values for the text file
and the table was resized and rehashed when it was almost full, being detected
by a function for capacity and load of the table.  A class was setup to hold
the entries for the table and different hash functions were tested to determine
the effectiveness of a given hash function over the construction of the hash
table.  Each key and value pair had to be tested for being alreaedy in the table
and had to be acquired with a hashcode and put into the table, which was rehashed
if necessary.
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


def mkHashTable(capacity=100):
    """
    This function is the helper function for the hashTable class, it takes capacity as
    a parameter. This function is used to make each instance for the hash table and
    it helps to create the hash table that is rehashed when the need arises and the
    table is made in this function as well with the list of lists defined in the range
    of capacity.
    """
    
    hTable = HashTable()
    hTable.table = [list() for _ in range(capacity)]
    hTable.size = 0
    return hTable


def HashTableToStr(hashtable):
    """
    This function takes the hashtable as a parameter. This function then converts the
    results of every index in the table to a string. Everything is returned as a
    result of the function after calling EntryToStr() function that does other changes
    defined below.
    """
    result = ""
    for i in range( len( hashtable.table ) ):
      if i != None:
          result += str( i ) + ": "
          result += EntryToStr( hashtable.table[i] ) + "\n"
    return result


class _Entry( ):
    """
    This is a class used to hold key-value pairs.  This class takes no parameters.  It stores
    every key-value and is helped by other functions defined below.
    """

    __slots__ = ( "key", "value" )


def EntryToStr(entry):
    """
    This function takes entry as a parameter. This function is a helper function for the
    class entry.  It converts every entry into a string from a key-value pair.
    """
  
    return "(" + str( entry.key ) + ", " + str( entry.value ) + ")" 


def mkEntry(key, value):
    """
    This function takes key and value as parameters. This function is a helper function for the
    class of Entry() and it creates entries in the class that are used later and converted for use
    by other functions.
    """
    aEntry = _Entry()
    aEntry.key = key
    aEntry.value = value
    return aEntry


def given_hash( val, n ):
    """
    This function Computes a hash of the val string that is in [0 ... n), this hashing function was given in
    the file and it makes hashcodes from the values in use in the program and these are useful
    for the key-value pairs and indices in the table, also useful for rehashing as well.
    """
    hashcode = hash( val ) % n
    # hashcode = 0
    # hashcode = len(val) % n
    return hashcode

def hash_function(val, n):
    """
    This is another method to acquire the hashcodes.  Similar to the given_hash() function above
    it takes the values and n that are parameters and makes hashcodes for use in the creation of
    the table and indices for the key-value pairs.  This funcion in particular takes the ordinal
    value for each letter and assigns it an integer it can then perform modular division on to
    calculate the hashcode on.

    """
    number = 0
    for letter in val:
        number = number + ord(letter) #turn the letter into a number
    return number%n


    
def keys( hTable ):
    """
       This function returns a list of keys in the given hashTable. This function takes the
       paramter of the hash table.  Then the function iterates over each item in the table
       and tests for an empty slot in the table, if there is, it is added to the table
       and the calculations continue for each item in the table.
    """
    result = []
    for item in range(len(hTable.table)):
        if item != []:
            for entry in item:
                result.append( entry.key )
    return result

def contains( hTable, key ):
    """
       This function return True iff hTable has an entry with the given key.  This function
       takes the hash table and key as parameters.  This function then iterates over each
       intex in the table and checks for each key being in the table and returns false if not.
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

       The load is tested here to determine if rehashing is necessary and if the load is
       met or exceeded, then the table is rehashed and the functions are ran again until
       the table is full and there are no more key-value pairs to add to the table.
    """
    ratio = load( hTable )
    
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

       This function takes the hash table and key as parameters.  It uses the key and
       tests for the index of each location to be empty, if it is then an exception
       is raised and the key is not in the table. otherwise there is a list that is
       constructed of the indices and the keys are used to assist with this as well.
       If the key is not in the table, then another exception is raised as well.
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
        
        Imbalance() measures the effectiveness of the hashing function, the lower the
        number, the closer to zero, the better.
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
        This function checks ratio of items in table to table size, to determine  the load on
        the hashtable, for rehashing.  It takes the hash table as a parameter.  It performs
        calculations with iterating over each index of the size and accumulates the total.
        This total is divided by size to determine the load on the table, used in put()
        to make the table perform a rehash if it becomes to full and needs resizing.
    """
    total = 0
    size = len( hTable.table )
    for i in range( size ):
        total += len( hTable.table[ i ] )
    
    return total/size

 
def rehash( hTable):
    """
        This function performs a rehash every time the table starts to fill up, determined by
        the load on the table.  This function takes the hash table as a parameter.  It iterates
        over each item in the hash table and moves it to a new table and increaes the size of
        the table for use again.  The table is increased in size until all the key-value pairs
        are in the table and the load is not met or exceeded.  Put is used to rework the tables
        and rematch up the key-value pairs to their correct location during the rehash to the
        new table that is being created and expanded upon.
    """
    
    newN = ( 2 * len( hTable.table ) ) + 1
    newTable = mkHashTable( newN )
    for i in range( len( hTable.table ) ):
        for item in hTable.table[ i ]:
            myKey = item.key
            myValue = item.value
            put(newTable, myKey, myValue)
    hTable.table = newTable.table
    hTable.size = newTable.size
    
    return newTable
