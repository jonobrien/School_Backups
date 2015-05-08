byte lcm = 0 ;

proctype LCM( byte ox ; byte oy ) {
	byte temp = 0 ;
	byte x = ox ;
	byte y = oy ;

	do
	:: x > y -> y = y + oy ;
	:: x < y -> x = x + ox ;
	:: x == y -> break ;
	od ;

	lcm = x ;
	printf("LCM of %d and %d is %d\n", ox, oy, lcm) ;
}

init {
	run LCM(8, 10) ;
}
