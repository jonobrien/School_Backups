##hashing stuff - intro


d = dict()# or d = {} to make the list

#key        value
d['see'] = 100
d['spot'] = 23
d['run'] = 134

#change it with:
d['see'] = 44 # does not create a new entry once the key is already defined
#not necessarily printed in order
#print(d)
print('\n\nhash table')

print(hash('see'))
print(hash('spot'))
print(hash('run'))


d[4] = 'what'
d[5.67] = 55

print(d)
#keys must be immutable, cannot change or else hash doesn't work


#query - see if element is on dictionary
print('spot' in d)
#searches over keys to see if its in the table
print(44 in d) #44 is false, not a key
del d[4] #removes from dictionary
print(d.keys()) # getting a list of keys
print(d.values()) #getting a list of values


#loop through keys using for loop
for el in d:
    print('key is', el, 'the value is', d[el])









