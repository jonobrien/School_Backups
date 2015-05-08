#define NCUSTS 2 		/* Number of customers */
#define NCASH  1 		/* Number of cashiers */
#define NSERV  1 		/* Number of servers */
#define NOBODY 255		/* Nobody's waiting */
#define NORDER 0  		

mtype = {CHILI, SANDWICH, PIZZA} /* Possible favorite foods for customers */
mtype foods[NCUSTS] ;

					/* SHARED STATE (GLOBALS) */

byte ordering = NOBODY ; 				/* customer currently ordering */
byte waiting[NCUSTS] = NOBODY ; 		/* customers waiting to order */
byte custsOrdering[NCUSTS] = NOBODY ;		/* number of orders 		*/
byte nextWait = 0 ;
byte nextOrder = 0 ;							/* next waiting customer */
byte order[NCUSTS] = NOBODY ;
byte orderId[NCUSTS] = NOBODY ;
byte fav[NCUSTS] = NOBODY ;
byte curServe = 0;
byte serving[NCUSTS] = NOBODY ;
byte busyServe[NSERV] = NOBODY ;
byte serve_foods[NCUSTS] = NOBODY ;

byte nwaiting = 0 ; 					/* # of customers waiting */
byte nserving = 0 ;						/* # of customers being served */


						/* SEMAPHORE FUNCTIONS */

#define sema byte
inline up(s) { s++ ; }
inline down(s) { atomic{ s > 0 ; s-- } }

						/* SEMAPHOR DEFINITIONS */
sema mutex = 1 ;
sema at_counter = 0 ; 
sema cust_wait[NCUSTS] = 0 ; 
sema cash = 0 ;
sema serve = 0 ;
sema takeOrder = 0 ;



/* Customer Process 
*	(1) Enter store
*	(2) Wait for Cashier
*	(3) Place order for food
*   (4) Wait for order to be fulfilled.
*   (5) Exit store with food
*/

proctype Customer(byte me; mtype food) {

	do
	:: 
		printf("C%d enters the Shift-Alt-Esc Cafe\n", me) ;
		fav[me] = food ;
		down(mutex) ;
		if
		:: ordering == NOBODY ->
			printf("C%d does not have to wait\n", me) ;
			skip;			/* go directly to purchase */
		:: else ->
			waiting[nextWait] = me ;
			printf("C%d is waiting in spot %d\n", me, nextWait) ;

			nextWait = (nextWait + 1) % NCUSTS ; 
			nwaiting++ ;
			up(mutex) ;
			up(cust_wait[me]); /* this allows the server to call me */
		fi ;

		up(mutex) ; 			/*Release the mutex if got here without waiting */
		ordering = me ; 		/*Finally being served! */
		nserving++ ; 			/*I was either called or there is no line */
		printf("C%d approaches the serving station\n", me) ;
		
		
		
		
		up(cust_wait[me]);	/* waiting to get my order completed */

		printf("C%d places order for %s", me, food);

	od ;
		
}


/* Cashier Process 
*	(1) Wait for new customer
*	(2) Select waiting customer
*	(3) Take order
*   (4) Pass order to server
*/


proctype Cashier(){
	byte cust = 0;
	do
	:: waiting[cust] ->
		custsOrdering[cust] = false ;
		printf("Customer %d was chosen", cust) ;
		down(cust_wait[cust]) ;
		down(cash) ;
		order[nextOrder] = foods[cust] ;
		orderId[nextOrder] = cust ;
		down(serve) ;
		nextOrder ++ ;
		nextOrder = (nextOrder + 1) % NCUSTS ;
		//up(cust_wait[cust]) ;
		
	:: else ->
		atomic{ cust++ ; cust = (cust % NCUSTS) } ;
		
	od ;
}

proctype Server(){
	
	byte thisOrder = 0;
	
	do 
	:: down(takeOrder) ;
		if
			:: custsOrdering[curServe] = NOBODY ;
				up(takeOrder);
				skip;
			:: else ->
				thisOrder = curServe ;
				curServe = (curServe + 1) % NSERV ;
				up(takeOrder) ;
				serving[thisOrder] = orderId[thisOrder] ;
				busyServe[thisOrder] = true ;
				printf("take the order") ;
				if
				:: serve_foods[orderId[thisOrder]] == order[thisOrder] ->
					printf("made the right thing");
					printf("This server is serving this customer") ; //variables later
					down(cust_wait[orderId[thisOrder]]) ;
					atomic{
						orderId[thisOrder] = NOBODY ;
						order[thisOrder] = 0 ;
					} ;
					up(serve) ;
					//down(cust_wait[orderId[thisOrder]]) ;
				fi ;
				busyServe[thisOrder] = false ;
				printf("I'm waiting on an order")
				
		fi ;
	od ;
}
	

init{
	atomic {
		run Customer(1, PIZZA);
		run Customer(2, PIZZA);
		run Cashier();
		run Server();
	}
}
