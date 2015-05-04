


def say(strng, numbers):
    """




    """
    if strng == "":
        return numbers
    numbers += sayHelp(strng[0]) + " " + sayHelp(strng[1])

    if strng[0] != "1":
        numbers += "s." + " "
    else:
        numbers += "." + " "
    return say(strng[2:], numbers)

def sayHelp(char):
    if char == '1':
        return "one"
    elif char == '0':
        return "zero"
    elif char == '2':
        return "two"
    elif char == '3':
        return "three"
    
#function to test its output, prompt for testing function
#after printing index, prompt for yes, tests functions run, 3 test cases
    

def see(strng): 
    length = runLength(strng, strng[0])
    left = strng[0]
    right = strng[length:]

    if right == "":
        return str(length) + left
    else:
        return str(length) + left + see(right)

def runLength(strng, head):
    
    if strng == "":
        return 0
    elif (strng[0] != head):
        return 0
    elif (head == strng[0]):
        return 1+ runLength(strng[1:], head)
    


def seeHelper (index):
    """
    returns a string
    """
    strng = '0'
    
    for i in range(index):
        strng = see(strng)
    return strng



    
def testSay():
    print ("testing Say()")
    if (say("3110", "") == "three ones. one zero. "):
        print("pass")
    else:
        print("fail")
           
    if say("10", "") == "one zero. ":
        print("pass")
    else:
        print("fail")

    if say("1110", "") == "three ones. one zero. ":
        print("pass")
    else:
        print("fail")
        
def testSee():
    print ("testing see()")
    if (see("3110") == "132110"):
        print("pass")
    else:
        print("fail")
        
    if (see("01") == "10"):
        print("pass")
    else:
        print("fail")
    if (see("0") == "10"):
        print("pass")
    else:
        print("fail")

def testRunLength():
    print ("testing runLength()")
    print (runLength("1110","1")) #== "3":
##        print("pass")
##    else:
##        print("fail")
        
##    if (runLength("3110","3")):
##        print("pass")
##    else:
##        print("fail")
##        
##    if (runLength("1110","0")):
##        print("pass")
##    else:
##        print("fail")




    
       
##    if see("10", "") == "one zero. ":
##        print("pass")
##    else:
##        print("fail")
##
##    if see("1110", "") == "three ones. one zero. ":
##        print("pass")
##    else:
##        print("fail")
##


        
#print see("1110")

def test():
    ask = input("Shall I test the functions?")
    if ask != "yes":
        return print("not testing the functions")
    #testSay()
    #testSee()
    testRunLength()
    





def main():
    index = int(input("input an index:"))
    #print(seeHelper(index))
    strng = seeHelper(index)
    print(index,":" + " ", end = "")
    print (strng, ":" + " ", end = "")
    print(say(strng, ""), end ="")
    print(" ")
    test()


    
main()






