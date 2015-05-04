import sys

START_CODON = "aug"
STOP_CODONS = ["uaa","uag","uga"]
RNA_TO_AAs = {"aug":"Met","uuu":"Phe", "uuc":"Phe", "uua":"Leu", "uug":"Leu", "cuc":"Leu","cug":"Leu","auu":"Ile", "auc":"Ile", "aua":"Ile", "guu":"Val", "guc":"Val", "gua":"Val", "gug":"Val", "ucu":"Ser", "ucc":"Ser", "uca":"Ser", "ucg":"Ser", "ccu":"Pro", "ccc":"Pro", "cca":"Pro", "ccg":"Pro", "acu":"Thr", "acc":"Thr", "aca":"Thr", "acg":"Thr", "gcu":"Ala", "gcc":"Ala", "gca":"Ala", "gcg":"Ala", "uau":"Tyr", "uac":"Tyr", "cau":"His", "cac":"His", "caa":"Gln", "cag":"Gln", "aau":"Asn", "aac":"Asn", "aaa":"Lys", "aag":"Lys", "gau":"Asp", "gac":"Asp", "gaa":"Glu", "gag":"Glu", "ugu":"Cys", "ugc":"Cys", "ugg":"Trp", "cgu":"Arg", "cgc":"Arg", "cga":"Arg", "cgg":"Arg", "agu":"Ser", "agc":"Ser", "aga":"Arg", "agg":"Arg", "ggu":"Gly", "ggc":"Gly", "gga":"Gly", "ggg":"Gly" }

def main():
    letters = input("Input RNA code\n")
    decode(letters)

def decode(letters):
    rna = letters.split()
    index = 0
    for i in range(len(rna)):
        if(rna[i].lower() == START_CODON):
            convert(rna[i:],index)
            print("",end="\n")
    print("")

def convert(letters,index):
    for i in range(len(letters)):
            if( (letters[i].lower() == STOP_CODONS[0]) or (letters[i].lower() == STOP_CODONS[1]) or (letters[i].lower() == STOP_CODONS[2])):
                return i
            else:
                print(RNA_TO_AAs[letters[i].lower()],end =" ")
            i+=1

main()

    
