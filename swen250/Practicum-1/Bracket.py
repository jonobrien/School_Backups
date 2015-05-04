# Jon O'Brien - Practicum-1
#
# Transform the 'original' string into the 'bracketed' string by
# surrounding all vowels - a, e, i, o, u in either case - by square
# brackets ([]), any digit by angle brackets (<>), and copying all
# other characters "as is".
#
# When done, return the 'bracketed' string.
#
# Example: bracket("I think February 29, 2024 will be sunny.")
#    returns "[I] th[i]nk F[e]br[u][a]ry <2><9>, <2><0><2><4> w[i]ll b[e] s[u]nny."

import fileinput
import sys

def bracket(original):
    bracketed = ''
    vowels = ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    original = sys.stdin
    for word in original:
        index = word.strip().split()
        #strips and splits everything apart.
        for char in word:
            if char in vowels:
                bracketed += "["+char+"]" #adds [] around vowels of both cases
            elif char.isdigit():
                bracketed += "<" + char + ">" #adds <> around numbers
            else:
                bracketed += char #adds all other characters to string

    return bracketed


if __name__ == '__main__':
    original = sys.stdin
    sys.stdout = print(bracket(original))
