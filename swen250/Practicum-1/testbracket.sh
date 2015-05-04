#!/bin/bash
# Extend the following script to run tests that confirm your program is
# working correctly. You are not required to create PyUnit tests.
# 

#Testing original sample
echo "I think February 29, 2024 will be sunny." | python3 Bracket.py
# Output should be: [I] th[i]nk F[e]br[u][a]ry <2><9>, <2><0><2><4> w[i]ll b[e] s[u]nny.

#Test Lowercase Vowels Only
echo "aeiou" |  python3 Bracket.py
# Output should be: [a][e][i][o][u]

#Add others here:

########################################################################

#uppercase vowels only:
echo "AEIOU" | python3 Bracket.py
# Output should be: [A][E][I][O][U]


#numbers only:
echo "01234567890" | python3 Bracket.py
# Output should be: <0><1><2><3><4><5><6><7><8><9><0>


#another example:
echo "Today was a good day; I got the 1st Practicum DONE!!1!!1!!" | python3 Bracket.py
# Output should be: T[o]d[a]y w[a]s [a] g[o][o]d d[a]y; [I] g[o]t th[e] <1>st Pr[a]ct[i]c[u]m D[O]N[E]!!<1>!!<1>!!


#just consonants:
echo "qwrty" | python3 Bracket.py
# Output should be: qwrty


#special characters and vowels:
echo "!@#%^%&*&*(AEIOUaeiou<>()$" | python3 Bracket.py
# Output should be: !@#%^%&*&*([A][E][I][O][U][a][e][i][o][u]<>()$




