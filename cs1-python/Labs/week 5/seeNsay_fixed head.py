"""
author: Jon O'Brien
due date: 10/1/13
lab - week 5 - seeNSay
"""
#the indeces given on the lab handout
s0 = 0
s1 = 10
s2 = 1110
s3 = 3110
s4 = 132110
s5 = 1113122110
s6 = 311311222110
s7 = 13211321322110

def head():
    pass


def runlen(strng,char):
    if (strng == ""):
        return 0
    elif (strng[0] != char):
        return 0
    elif (strng[0] == char):
        return 1 + runlen(strng[1:], char)



char = input("character wanted:")
strng = input("enter the string:")
runlen(strng,char)
print(runlen(strng,char))





















#have to calculate actual strings below to allow for input of any index


# if/elif/else statements about adding prior indeces with slicing, [:] or [1:1]
