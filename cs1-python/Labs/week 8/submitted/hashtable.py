""" 
file: hashtable.py
language: python3
author: sps@cs.rit.edu Sean Strout 
author: jeh@cs.rit.edu James Heliotis 
author: anh@cs.rit.edu Arthur Nunes-Harwitt
author: jsb@cs.rit.edu Jeremy Brown
description: chaining Hash Table 

modified: Laura Silva
date: 10/29/2013
"""


class HashTable( ):
    """
    The HashTable data structure contains a collection of values
    where each value is located by a hashable key.
    No two values may have the same key, but more than one
    key may have the same value.
    """

    __slots__ = ( "table", "size")


def mkHashTable(capacity=100):
    
    aHashTable = HashTable()
    aHashTable.table = [ list() for _ in range(capacity)]
    aHashTable.size = 0
    return aHashTable


def HashTableToStr(hashtable):
    result = ""
    for i in range(len(hashtable.table)):
        for el in hTable.table[i]:  
            result += str( i ) + ": "
            result += EntryToStr(el) + "\n"
    return result


class _Entry( ):
    """
    Entry is a class used to hold key/value pairs.
    """

    __slots__ = ( "key", "value" )


def EntryToStr(entry):
    """
    EntryToStr returns the string representation of the entry.
    """
    return "(" + str(entry.key) + ", " + str(entry.value) + ")" 


def mkEntry(key, value):
    aEntry = _Entry();
    aEntry.key = key;
    aEntry.value = value;
    return aEntry;


def hash_functionOriginal(val, n):
    """
    Compute a hash of the val string that is in [0 ... n)
    using the built-in hash function.
    """
    
    hashcode = hash( val ) % n
    # hashcode = 0
    # hashcode = len(val) % n
    return hashcode


def hash_function(val, n):
    """
    Compute a hash of the val string that is in [0 ... n)
    using ordinal values.
    """
    
    num = 0
    for letter in val:
        num += ord(letter)
    
    hashcode = num % n

    return hashcode


def keys(hTable):
    """
    Return a list of keys in the given hashTable.
    """
    
    result = []
    for lst in range (len(hTable.table)):
        for entry in hTable.table[lst]:
            result.append(entry.key)
    return result


def contains(hTable, key):
    """
    Return True if hTable has an entry with the given key.
    """
    
    index = hash_function(key, len(hTable.table))
    for el in hTable.table[index]:
        if el.key == key:
            return True
    
    return False

    
def checkLoad(hTable):
    """
    Checks the load of the hash table. It returns the ratio
    of number of entries in the table to the capacity of the table.
    """
    
    size = hTable.size #num of entries

    return (size/len(hTable.table))


def put(hTable, key, value):
    """
    put first checks the load of the table. If the load is greater than
    or equal to 0.75, it rehashes the table. Else, it checks to see
    if the key is already present in the table and if it is, the
    given value will replace the previous one already in the table.
    If the key is not in the table, it adds it to the list and
    increases the size by 1.
    """
    
    load = checkLoad(hTable)

    if load >= 0.75:
        rehash(hTable)
    else:
        index = hash_function(key, len(hTable.table))
        if contains(hTable, key):
            for el in hTable.table[index]:
                if el.key == key:
                    el.value = value
        else:
            hTable.table[index].append(mkEntry(key, value))
            hTable.size += 1


def get(hTable, key):
    """
    get returns the value associated with the given key in
    the given hash table. If the key is not in the table,
    an Exception is raised.
    Precondition: contains(hTable, key)
    """
    
    index = hash_function(key, len(hTable.table))
    for el in hTable.table[index]:
        if el.key == key:
            return el.value
    raise Exception ("Hash table does not contain key.")


def imbalance(hTable):
    """
    Imbalance computes the average length of all non-empty chains
    and then subtracts 1.
    """
    
    count = 0 #how many non-empty buckets
    for bucket in range (len(hTable.table)):
        if hTable.table[bucket] != []:
            count += 1

    return ((hTable.size / count) - 1)


def rehash(hTable):
    """
    rehash creates a new capacity n for a table (2N+1), then it
    creates a new table using that capacity. The function loops
    through the table reassigning the current keys and values, to
    then use the put function to put them in the new table. 
    """
    
    newn = (2 * (len(hTable.table)) + 1)
    newhTable = mkHashTable (newn)
    
    for el in range(len(hTable.table)):
        for item in hTable.table[el]:
            newKey = item.key
            newValue = item.value
            put(newhTable, newKey, newValue)

    hTable.size = newhTable.size
    hTable.table = newhTable.table


