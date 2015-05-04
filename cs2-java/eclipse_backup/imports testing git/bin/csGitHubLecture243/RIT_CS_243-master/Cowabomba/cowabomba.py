from math import *
class Cow(object):
    __slots__ = ('name', 'x', 'y')

    def __init__(self, name, x, y):
        self.name = name
        self.x = x
        self.y = y

    def __str__(self):
        return (self.name + " " + str(self.x) + "," + str(self.y))

class Bomb(object):
    __slots__ = ('color', 'x', 'y', 'r', 'adjlst')

    def __init__(self, color, x, y, r):
        self.color = color
        self.x = x
        self.y = y
        self.r = r
        self.adjlst = []

    def __str__(self):
        return (self.color + " " + str(self.x) + "," + str(self.y) + "," + str(self.r))

def isClose(x1, x2, y1, y2, r):
    return sqrt((x1-x2)**2+(y1-y2)**2) <= r

def isInList(n1, n2):
    for node in n1.adjlst:
        if node == n2:
            return True
    return False

def recCount(node, visited, c):
    for next in node.adjlst:
        if not next in visited:
            visited.append(next)
            print(next)
            if isinstance(next, Cow):
                c = c+1
            elif isinstance(next, Bomb):
                recCount(next, visited, c)
    return c

def populateAndCalculate(filename):
    cowlst = []
    bomblst = []
    f = open(filename, "r")

    line = f.readline()
    while line != "":
        s = line.split()
        if s[0] == "cow":
            cowlst.append(Cow(s[1],int(s[2]),int(s[3])))
        elif s[0] == "bomb":
            bomblst.append(Bomb(s[1],int(s[2]),int(s[3]),int(s[4])))
        line = f.readline()
    f.close()

    for b in bomblst:
        print("Triggering " + b.color + " bomb...")
        for n in bomblst:
            if isClose(b.x, n.x, b.y, n.y, b.r) and not isInList(b, n) and not b == n:
                print(b.color + " bomb sets off " + n.color + " bomb")
                b.adjlst.append(n)
        for c in cowlst:
            if isClose(b.x, c.x, b.y, c.y, b.r) and not isInList(b, c):
                print(b.color + " bomb paints " + c.name)
                b.adjlst.append(c)
        print("\n")

    index = 0
    maximum = 0
    for n in range(0, len(bomblst)):
        #countlst.append(recCount(bomblst[n], list(), 0))
        print(bomblst[n].color)
        calcd = recCount(bomblst[n], list(), 0)
        print(calcd)
        if calcd > maximum:
            index = n
            maximum = calcd
    print("Triggering the " + bomblst[index].color + " bomb paints the largest number of cows:" + str(maximum))




populateAndCalculate("cowinput.txt")