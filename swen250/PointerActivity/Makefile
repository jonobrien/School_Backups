CC=gcc
#replaced gcc with $(CC)

make: test_pointers
    
test_pointers.o: main.c read_data.c read_data.h
	$(CC) -c main.c read_data.c
test_pointers: test_pointers.o
	$(CC) main.o read_data.o -o test_pointers
clean:
	rm -f *~ *.o test_pointers
run:
	./test_pointers
