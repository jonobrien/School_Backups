CC=gcc
CFLAGS= -Wall -ansi -pedantic


make: hw8 x11 png

hw8: hw8.o InvPend.o ODEsolvers.o
	$(CC) $(CFLAGS) -o hw8 hw8.o InvPend.o ODEsolvers.o -lm


hw8.o: hw8.c
	$(CC) $(CFLAGS) -c hw8.c

InvPend.o: InvPend.c
	$(CC) $(CFLAGS) -c InvPend.c

ODEsolvers.o: ODEsolvers.c
	$(CC) $(CFLAGS) -c ODEsolvers.c


png: plots.o
	$(CC) -Wall -pedantic -o png plots.o

plots.o: plots.c
	$(CC) -Wall -pedantic -c plots.c 


eu_graph: 
	./png eu

rk2_graph:
	./png rk2

rk3_graph:
	./png rk3

rk4_graph:
	./png rk4


eu: 
	./hw8 eu .01 20 .5 .31415926 -2.0 1 > pend_eu.sim
	sed 1d pend_eu.sim

rk2:
	./hw8 rk2 .001 20 .5 .31415926 -2.0 1 > pend_rk2.sim
	sed 1d pend_rk2.sim

rk3:
	./hw8 rk3 .001 20 .5 .31415926 -2.0 1 > pend_rk3.sim
	sed 1d pend_rk3.sim

rk4:
	./hw8 rk4 .001 20 .5 .31415926 -2.0 1 > pend_rk4.sim
	sed 1d pend_rk4.sim

graphs: eu rk2 rk3 rk4 eu_graph rk2_graph rk3_graph rk4_graph








clean:
	rm *.o
