inFile = 'vars.txt'

symTbl = dict()

for line in open(inFile):
    symTbl[line[0]] = int(line.split()[1])
