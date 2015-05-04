## for GCC
CC = gcc

##Compilcation Flags
CFLAGS= -Wall -ansi

make: DetermineError TestData Correction



DetermineError: DetermineError.o
	$(CC) $(CFLAGS) -o DetermineError DetermineError.o

TestData: GenTestData.o
	$(CC) $(CFLAGS) -o TestData GenTestData.o

Correction: Correction.o
	$(CC) $(CFLAGS) -o Correction Correction.o

DetermineError.o: DetermineError.c
	$(CC) $(CFLAGS) -c DetermineError.c

GenTestData.o: GenTestData.c
	$(CC) $(CFLAGS) -c GenTestData.c

Correction.o: Correction.c
	$(CC) $(CFLAGS) -c Correction.c


######################### Block Used For Execution Of Programs #############
data:
	./TestData

output: 
	./TestData | ./Device

correction: 
	./TestData | ./Device | ./Correction 




test: 
	./TestData | ./Device | ./DetermineError

clean:
	rm -f *.o
	rm -f *.save
	rm -f *.gch
	
