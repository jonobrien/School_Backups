#define rand	pan_rand
#if defined(HAS_CODE) && defined(VERBOSE)
	cpu_printf("Pr: %d Tr: %d\n", II, t->forw);
#endif
	switch (t->forw) {
	default: Uerror("bad forward move");
	case 0:	/* if without executable clauses */
		continue;
	case 1: /* generic 'goto' or 'skip' */
		IfNotBlocked
		_m = 3; goto P999;
	case 2: /* generic 'else' */
		IfNotBlocked
		if (trpt->o_pm&1) continue;
		_m = 3; goto P999;

		 /* PROC Phil */
	case 3: /* STATE 1 - philosophers-solution.pml:50 - [printf('P%d is thinking\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		Printf("P%d is thinking\n", ((int)((P0 *)this)->_1_me));
		_m = 3; goto P999; /* 0 */
	case 4: /* STATE 2 - philosophers-solution.pml:55 - [want_to_eat[me] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((int)want_to_eat[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		want_to_eat[ Index(((P0 *)this)->_1_me, 4) ] = 1;
#ifdef VAR_RANGES
		logval("want_to_eat[Phil:me]", ((int)want_to_eat[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 5: /* STATE 3 - philosophers-solution.pml:56 - [printf('P%d wants to chow down\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][3] = 1;
		Printf("P%d wants to chow down\n", ((int)((P0 *)this)->_1_me));
		_m = 3; goto P999; /* 0 */
	case 6: /* STATE 4 - philosophers-solution.pml:59 - [(lefty)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][4] = 1;
		if (!(((int)((P0 *)this)->_1_lefty)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 7: /* STATE 5 - philosophers-solution.pml:33 - [((fork[me]>0))] (12:0:1 - 1) */
		IfNotBlocked
		reached[0][5] = 1;
		if (!((((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ])>0)))
			continue;
		/* merge: fork[me] = (fork[me]-1)(0, 6, 12) */
		reached[0][6] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = (((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ])-1);
#ifdef VAR_RANGES
		logval("fork[Phil:me]", ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 8: /* STATE 9 - philosophers-solution.pml:33 - [((fork[((me+1)%4)]>0))] (24:0:1 - 1) */
		IfNotBlocked
		reached[0][9] = 1;
		if (!((((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ])>0)))
			continue;
		/* merge: fork[((me+1)%4)] = (fork[((me+1)%4)]-1)(0, 10, 24) */
		reached[0][10] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]);
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = (((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ])-1);
#ifdef VAR_RANGES
		logval("fork[((Phil:me+1)%4)]", ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]));
#endif
		;
		/* merge: .(goto)(0, 23, 24) */
		reached[0][23] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 9: /* STATE 14 - philosophers-solution.pml:33 - [((fork[((me+1)%4)]>0))] (21:0:1 - 1) */
		IfNotBlocked
		reached[0][14] = 1;
		if (!((((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ])>0)))
			continue;
		/* merge: fork[((me+1)%4)] = (fork[((me+1)%4)]-1)(0, 15, 21) */
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]);
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = (((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ])-1);
#ifdef VAR_RANGES
		logval("fork[((Phil:me+1)%4)]", ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 10: /* STATE 18 - philosophers-solution.pml:33 - [((fork[me]>0))] (24:0:1 - 1) */
		IfNotBlocked
		reached[0][18] = 1;
		if (!((((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ])>0)))
			continue;
		/* merge: fork[me] = (fork[me]-1)(0, 19, 24) */
		reached[0][19] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = (((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ])-1);
#ifdef VAR_RANGES
		logval("fork[Phil:me]", ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		/* merge: .(goto)(0, 23, 24) */
		reached[0][23] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 11: /* STATE 24 - philosophers-solution.pml:67 - [want_to_eat[me] = 0] (0:0:1 - 3) */
		IfNotBlocked
		reached[0][24] = 1;
		(trpt+1)->bup.oval = ((int)want_to_eat[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		want_to_eat[ Index(((P0 *)this)->_1_me, 4) ] = 0;
#ifdef VAR_RANGES
		logval("want_to_eat[Phil:me]", ((int)want_to_eat[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 12: /* STATE 25 - philosophers-solution.pml:72 - [eating[me] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][25] = 1;
		(trpt+1)->bup.oval = ((int)eating[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		eating[ Index(((P0 *)this)->_1_me, 4) ] = 1;
#ifdef VAR_RANGES
		logval("eating[Phil:me]", ((int)eating[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 13: /* STATE 26 - philosophers-solution.pml:73 - [printf('P%d eating\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][26] = 1;
		Printf("P%d eating\n", ((int)((P0 *)this)->_1_me));
		_m = 3; goto P999; /* 0 */
	case 14: /* STATE 27 - philosophers-solution.pml:74 - [eating[me] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][27] = 1;
		(trpt+1)->bup.oval = ((int)eating[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		eating[ Index(((P0 *)this)->_1_me, 4) ] = 0;
#ifdef VAR_RANGES
		logval("eating[Phil:me]", ((int)eating[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 15: /* STATE 28 - philosophers-solution.pml:32 - [fork[me] = (fork[me]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][28] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]);
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = (((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ])+1);
#ifdef VAR_RANGES
		logval("fork[Phil:me]", ((int)now.fork[ Index(((int)((P0 *)this)->_1_me), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 16: /* STATE 30 - philosophers-solution.pml:32 - [fork[((me+1)%4)] = (fork[((me+1)%4)]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][30] = 1;
		(trpt+1)->bup.oval = ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]);
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = (((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ])+1);
#ifdef VAR_RANGES
		logval("fork[((Phil:me+1)%4)]", ((int)now.fork[ Index(((((int)((P0 *)this)->_1_me)+1)%4), 4) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 17: /* STATE 35 - philosophers-solution.pml:82 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][35] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */
	case  _T5:	/* np_ */
		if (!((!(trpt->o_pm&4) && !(trpt->tau&128))))
			continue;
		/* else fall through */
	case  _T2:	/* true */
		_m = 3; goto P999;
#undef rand
	}

