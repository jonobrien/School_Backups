


def say(character):
    numbers = ""
    if character == '1':
        numbers += "one"
    elif character == '0':
        numbers += "zero"
    elif character == '2':
        numbers += "two"
    elif character == '3':
        numbers += "three"

    if strng[0] != "1":
        numbers += "s."
    else:
        numbers += "."
    return numbers + say(strng[2:])
    
#function to test its output, prompt for testing function
#after printing index, prompt for yes, tests functions run, 3 test cases
    
def runLength(strng,char):
    if (strng == ""):
        return 0
    elif (strng[0] != char):
        return 0
    elif (strng[0] == char):
        return 1 + runlength(strng[1:], char)



def see(strng):
    length = runLength(strng, 1)
    left = strng[0]
    right = strng[length:]

    if right == "":
        return str(length) + left
    else:
        return str(length) + left + see(right)


def seehelper (index):
    """
    returns a string
    """
    while index >= 0:
        if index == 0:
            return 0
        else:
            return see(str(seehelper(index-1)))

def main():
    index = int(input("input an index:"))
    strng = seehelper(index)

    print(index,":", end = "")
    print(see(str(seehelper(index-1))), ":", end = "")
    print(say(str(seehelper(index))), end ="")
    
def testSay():
    print(say("") == ++)
    print(say("3110") == "three ones. one zero.")


"""

if string is empty
    return ""
else:
    count = runlength(string)
    return str(count) + string[0] + see(string[count:]) #maybe count - 1 in the see call


"""
main()
