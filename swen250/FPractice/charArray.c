
#include <stdlib.h>
#include <stdio.h>
#define MAXSIZE 9

void addThing(int number, char add);

typedef struct {
    int num;
    char thing[MAXSIZE + 1];
}Stuff;

struct Stuff overall = NULL;

//char word[MAXSIZE + 1];
//int ID = 0;
int ID = 0;
char word[MAXSIZE];


void main() {
    //int ID = 0;
    //char word[MAXSIZE];
    /* while there is input from stdin, print the id and words that are given. */
    while (scanf("%d, %s",&ID, word) != EOF) {
        printf("id = '%d'\n", ID);
        printf("word = '%s'\n", word);
        addThing(ID, *word);
        printf("overall num: \n",overall->num);
        printf("overall thing: \n", overall->thing);
    }//while loop

}//main

void addThing(int number, char add) {
    Stuff inner;
    inner = (Stuff*)malloc(sizeof(Stuff));
    inner->num = number;
    inner->thing = add;
    inner = overall;
    overall = inner;


}
