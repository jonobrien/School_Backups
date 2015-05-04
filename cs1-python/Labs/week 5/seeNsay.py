


def say(strng, numbers): #works
    """
    say: (strng) string -> string
         (numbers) string -> string
         returns a string
         
    This function takes two arguments, accumulates the words that make up the string of values
    and returns the string of words.  This function groups the value characters to account
    for the grouping of words, calls sayHelp() and returns the string of words
    ie: one zero. (or) three ones.  I tested the functions independently of eachother and their
    respective outputs to determine if they run correctly.  The output of words is for the prior index.
    ie: index 4 outputs words for index 3, and 3 outputs index 2.
    """
    
    if strng == "":
        return numbers              # returns a string
    numbers += sayHelp(strng[0]) + " " + sayHelp(strng[1])

    if strng[0] != "1":
        numbers += "s." + " "
    else:
        numbers += "." + " "
    return say(strng[2:], numbers)  #returns a string

def sayHelp(char):
    """
    sayHelp: (char) string -> string

    This function gives say the words associated with the string values from the inputted
    index value and the string that resulted from it.  This function takes the argument of
    char and returns strings for each passed string. 
    """
    
    if char == '1':
        return "one"       #returns a string
    elif char == '0':
        return "zero"      #returns a string
    elif char == '2':
        return "two"       #returns a string
    elif char == '3':
        return "three"     #returns a string
    
def see(strng): #works
    """
    see: (strng) string -> string
                 returns a string

    This function takes the argument of strng and finds the length, returns the string of
    the values associated with the input index and the string of letter length in the head
    and the tail of the string.
    """
    
    length = runLength(strng, strng[0])
    left = strng[0]
    right = strng[length:]


    if right == "":
        return str(length) + left              #returns a string
    else:
        return str(length) + left + see(right) #returns a string

def runLength(strng, head): #works
    """
    runLength: (strng) string -> string
               (head)  string -> integer
               returns an integer

    This function takes the string, converts it to an integer, reads the head character, and
    returns the number of times that character appears before a different character.  This
    function takes two arguments of strings that use recursion to return the integer value.
    """
    
    if strng == "":
        return 0                               #returns an integer
    elif (strng[0] != head):
        return 0                               #returns an integer
    elif (head == strng[0]):
        return 1+ runLength(strng[1:], head)   #returns an integer
    


def seeHelper (index): #works
    """
    seeHelper: (index) integer -> string
                        returns a string
                        
    This seeHelper function takes an argument of an integer and retunrs a string.  it uses a
    for loop to go through the different indeces and calculating the string value that becomes
    the integer output values.

                        
    """
    strng = '0'
    
    for i in range(index):
        strng = see(strng)
    return strng  #returns a string



    
def testSay():
    """
    testSay: prints strings.

    This function tests the say() function by comparing output strings and the if/else statements that
    tell you if the equality test is true or false.  true, it prints pass, false, prints fail.
    Three tests to demonstrate the function's process.


    """
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
    """
    testSee: prints strings.

    This function tests the see() function by comparing output strings and the if/else statements that
    tell you if the equality test is true or false.  true, it prints pass, false, prints fail.
    Three tests to demonstrate the function's process.


    """
    print ("testing see()")
    if (see("3110") == "132110"):
        print("pass")
    else:
        print("fail")
        
    if (see("1110") == "10"):
        print("pass")
    else:
        print("fail")
    if (see("0") == "10"):
        print("pass")
    else:
        print("fail")

def testRunLength():
    """
    testRunLength: prints strings.

    This function tests the runLength() function by comparing output strings and the if/else statements that
    tell you if the equality test is true or false.  true, it prints pass, false, prints fail.
    Three tests to demonstrate the function's process.


    """
    print ("testing runLength()")
    if runLength("1110","1") == "2":
        print("pass")
    else:
        print("fail")
        
    if runLength("3110","3") == "2":
        print("pass")
    else:
        print("fail")
        
    if runLength("10","1") == "4":
        print("pass")
    else:
        print("fail")

        


def test():
    """
    test: returns a string

    This function runs the other test functions.  The if statement determines whether or not the other
    functions are run.  This function confirms the other functions actually work properly and completes
    but may fail if the tested output is incorrect.

    """
    ask = input("Shall I test the functions?")
    if ask != "yes":
        return print("not testing the functions") #returns a string
    testSay()
    testSee()
    testRunLength()
    





def main():
    """
    main: prints strings
    test() in main -> see above

    This function main() asks for user input for the index value, tests for index of zero, and then runs
    the rest of the function.  The function prints the index, the string of values that result from
    the index, as well as the string of words that are the order of the string of values that result
    from the index.  prints "index : values : words"  The output of the words output is the index prior
    to it, index 4 outputs the words for index 3, and 3 for 2, etc.
    
    """
    index = int(input("input an index:"))
    if index == 0:
        print ("0", ":", "0",":", "zero.")
        test()
    else:
        
    
        strng = seeHelper(index)
        print(index,":" + " ", end = "")
        print (strng, ":" + " ", end = "") #prints strings
        print(say(strng, ""), end ="")
        print(" ")
        test()


    
main()






