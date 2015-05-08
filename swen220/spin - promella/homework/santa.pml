/*
 * Manifest constants - the number of elves and the quota
 * of toys for the day.
 */
#define NELVES	3
#define NELVESM1 2  /* NELVES - 1 for old versions of Spin */
#define QUOTA	10

/*
 * Mtype representing the two types of toys (dolls and trains)
 * and the STOP command.
 *
 * "choose" is a function to select what toy to make next.
 */
mtype = {DOLL, TRAIN, STOP} ;
inline choose(toy) {
	atomic {
		if
		:: true -> toy = DOLL ;
		:: true -> toy = TRAIN ;
		fi
	}
}

/*
 * Global state - the number of dolls and trains that have been
 * produced.
 */
byte dolls = 0 ;
byte trains = 0 ;
#define total_toys	(dolls + trains)

/*
 * Channel elves use to chat with Santa - they send their id and
 * he can respond with the toy he wants made or STOP.
 */
chan to_santa = [NELVES] of {byte /* the elfid */} ;

/*
 * Channels used by Santa to chat with the elves - an array
 * with one channel per elf indexed by elfid.
 */
chan to_elf[NELVES] = [0] of {mtype /* Santa's order */} ;

/*
 * The Santa process.
 *	- Print a message saying Santa is at work.
 *	- Loop:
 *		- If the number of STOP messages sent equals the number of elves,
 *        break out of the loop.
 *		- If Santa receives a request from an elf (with the elf's id):
 *			- If the QUOTA for today has been assigned to the elves:
 *				- Send the elf a STOP command on the elf's channel.
 *			  	- Increment the count of stop messages sent.
 *			- Otherwise:
 *				- Choose a toy for the requesting elf to make.
 *				- Send the toy information on the elf's channel.
 *				- Increment the number of toys assigned to be made.
 *  - Print the quota and the count of each toy type.
 *	- Say Santa is going home to Mrs. Claus.
 */

proctype Santa() {
	/*
	 * Santa's local state
	 *	elf				The id of the requesting elf.
	 *	total_assigned	The total number of toys assigned so far.
	 *	nstops			The number of STOP messages we've sent to elves.
	 *	next_toy		The next toy to make.
	 */

    byte elf = 0 ;
	byte total_assigned = 0 ;
	byte nstops = 0 ;
	mtype next_toy ;

	printf("Santa arrives at work\n") ;

	do
        /*
         * Fill in the body of the loop.
         * Use the inline function *choose* when you have
         * to choose a toy for an elf to make (like this):
         *    choose(next_toy)
         */
    ::
         skip ;
	od ;
    printf("Quota %d, Dolls %d, Trains %d\n", QUOTA, dolls, trains) ;
	printf("Santa goes home to Mrs. Claus\n") ;
}

/*
 * The generic Elf process.
 *	- Say the Elf has arrived.
 *	- Loop:
 *		- Request a toy to make from Santa by sending him our id.
 *		- Wait for a message on our rendevous channel.
 *		- If a STOP message, exit the loop.
 *		- Otherwise the message is DOLL or TRAIN:
 *			- Increment the global count of dolls or trains as appropriate,
 *		  	- Increment the local count of toys made,
 *			- Print what the Elf just did.
 *	- On loop exit, say the elf is leaving and print the total number of
 *    toys the elf made.
 */

proctype Elf(byte id) {
	/*
	 * An elf's local state
	 *	toy_to_make		STOP or the toy Santa wants this Elf to make.
	 *	toys_made		Count of the toys this Elf has made.
	 *	from_santa		Channel Santa uses to tell us what to do.
	 */

	mtype	toy_to_make ;
	byte	toys_made = 0 ;

	printf("Elf %d arrives at work\n", id) ;

	do
        /*
         * Fill in the body of the loop.
         */
    ::
         skip ;

        /*
         * End of each toy making iteration.
         */
		printf("Elf %d made a %e for a total of %d toys\n",
			id, toy_to_make, toys_made) ;
	od ;

	printf("Elf %d leaves after making %d toys\n", id, toys_made) ;
}

/*
 * Start the Elf process(es) and the Santa process.
 */
init {
	byte i = 0 ;

	atomic {
		for ( i : 0 .. NELVESM1 ) {
			run Elf(i) ;
		}
		run Santa() ;
	}
}

/*
 * The total_toys is always less than or
 * equal to the QUOTA.
 */
ltl Safe {
    /* Replace next line with appropriate logic statement */
    true ;
}

/*
 * Eventually the total_toys equals the QUOTA.
 */
ltl Live {
    /* Replace next line with appropriate logic statement */
    true ;
}
