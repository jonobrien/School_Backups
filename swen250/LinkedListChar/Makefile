# Makefile for linked list 

linked: linked.o main.o 
	gcc -o linked linked.o main.o 

linked.o: linked.h linked.c
	gcc -c linked.c

main.o: linked.h main.c
	gcc -c main.c

clean:
	rm *.o linked
