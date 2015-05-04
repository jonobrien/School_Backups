make: health


health: health.o health_util.o
	gcc -o health health.o health_util.o


health.o:	health.c health.h
	gcc -c health.c


health_util.o:	health_util.c health.h
	gcc -c health_util.c


clean:
	rm -f *.o health
	

test1:
	./health < test1.txt


test2:
	./health < test2.txt


test3:
	./health < test3.txt

