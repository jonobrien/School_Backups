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

		 /* PROC :init: */
	case 3: /* STATE 1 - shift-alt-esc1.pml:159 - [(run Customer(1,PIZZA))] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][1] = 1;
		if (!(addproc(0, 1, 1)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 4: /* STATE 2 - shift-alt-esc1.pml:160 - [(run Customer(2,PIZZA))] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][2] = 1;
		if (!(addproc(0, 2, 1)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 5: /* STATE 3 - shift-alt-esc1.pml:161 - [(run Cashier())] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][3] = 1;
		if (!(addproc(1, 0, 0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 6: /* STATE 4 - shift-alt-esc1.pml:162 - [(run Server())] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][4] = 1;
		if (!(addproc(2, 0, 0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 7: /* STATE 6 - shift-alt-esc1.pml:164 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][6] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Server */
	case 8: /* STATE 1 - shift-alt-esc1.pml:33 - [((takeOrder>0))] (33:0:1 - 1) */
		IfNotBlocked
		reached[2][1] = 1;
		if (!((((int)now.takeOrder)>0)))
			continue;
		/* merge: takeOrder = (takeOrder-1)(0, 2, 33) */
		reached[2][2] = 1;
		(trpt+1)->bup.oval = ((int)now.takeOrder);
		now.takeOrder = (((int)now.takeOrder)-1);
#ifdef VAR_RANGES
		logval("takeOrder", ((int)now.takeOrder));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 9: /* STATE 5 - shift-alt-esc1.pml:127 - [custsOrdering[curServe] = 255] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][5] = 1;
		(trpt+1)->bup.oval = ((int)custsOrdering[ Index(((int)now.curServe), 2) ]);
		custsOrdering[ Index(now.curServe, 2) ] = 255;
#ifdef VAR_RANGES
		logval("custsOrdering[curServe]", ((int)custsOrdering[ Index(((int)now.curServe), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 10: /* STATE 6 - shift-alt-esc1.pml:32 - [takeOrder = (takeOrder+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][6] = 1;
		(trpt+1)->bup.oval = ((int)now.takeOrder);
		now.takeOrder = (((int)now.takeOrder)+1);
#ifdef VAR_RANGES
		logval("takeOrder", ((int)now.takeOrder));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 11: /* STATE 10 - shift-alt-esc1.pml:131 - [thisOrder = curServe] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][10] = 1;
		(trpt+1)->bup.oval = ((int)((P2 *)this)->_4_thisOrder);
		((P2 *)this)->_4_thisOrder = ((int)now.curServe);
#ifdef VAR_RANGES
		logval("Server:thisOrder", ((int)((P2 *)this)->_4_thisOrder));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 12: /* STATE 11 - shift-alt-esc1.pml:132 - [curServe = ((curServe+1)%1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][11] = 1;
		(trpt+1)->bup.oval = ((int)now.curServe);
		now.curServe = ((((int)now.curServe)+1)%1);
#ifdef VAR_RANGES
		logval("curServe", ((int)now.curServe));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 13: /* STATE 12 - shift-alt-esc1.pml:32 - [takeOrder = (takeOrder+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][12] = 1;
		(trpt+1)->bup.oval = ((int)now.takeOrder);
		now.takeOrder = (((int)now.takeOrder)+1);
#ifdef VAR_RANGES
		logval("takeOrder", ((int)now.takeOrder));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 14: /* STATE 14 - shift-alt-esc1.pml:134 - [serving[thisOrder] = orderId[thisOrder]] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][14] = 1;
		(trpt+1)->bup.oval = ((int)serving[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]);
		serving[ Index(((P2 *)this)->_4_thisOrder, 2) ] = ((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]);
#ifdef VAR_RANGES
		logval("serving[Server:thisOrder]", ((int)serving[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 15: /* STATE 15 - shift-alt-esc1.pml:135 - [busyServe[thisOrder] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][15] = 1;
		(trpt+1)->bup.oval = ((int)busyServe[ Index(((int)((P2 *)this)->_4_thisOrder), 1) ]);
		busyServe[ Index(((P2 *)this)->_4_thisOrder, 1) ] = 1;
#ifdef VAR_RANGES
		logval("busyServe[Server:thisOrder]", ((int)busyServe[ Index(((int)((P2 *)this)->_4_thisOrder), 1) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 16: /* STATE 16 - shift-alt-esc1.pml:136 - [printf('take the order')] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][16] = 1;
		Printf("take the order");
		_m = 3; goto P999; /* 0 */
	case 17: /* STATE 17 - shift-alt-esc1.pml:138 - [((serve_foods[orderId[thisOrder]]==order[thisOrder]))] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][17] = 1;
		if (!((((int)now.serve_foods[ Index(((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]), 2) ])==((int)now.order[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 18: /* STATE 18 - shift-alt-esc1.pml:139 - [printf('made the right thing')] (0:23:0 - 1) */
		IfNotBlocked
		reached[2][18] = 1;
		Printf("made the right thing");
		/* merge: printf('This server is serving this customer')(23, 19, 23) */
		reached[2][19] = 1;
		Printf("This server is serving this customer");
		_m = 3; goto P999; /* 1 */
	case 19: /* STATE 20 - shift-alt-esc1.pml:33 - [((cust_wait[orderId[thisOrder]]>0))] (26:0:1 - 1) */
		IfNotBlocked
		reached[2][20] = 1;
		if (!((((int)now.cust_wait[ Index(((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]), 2) ])>0)))
			continue;
		/* merge: cust_wait[orderId[thisOrder]] = (cust_wait[orderId[thisOrder]]-1)(0, 21, 26) */
		reached[2][21] = 1;
		(trpt+1)->bup.oval = ((int)now.cust_wait[ Index(((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]), 2) ]);
		now.cust_wait[ Index(now.orderId[ Index(((P2 *)this)->_4_thisOrder, 2) ], 2) ] = (((int)now.cust_wait[ Index(((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]), 2) ])-1);
#ifdef VAR_RANGES
		logval("cust_wait[orderId[Server:thisOrder]]", ((int)now.cust_wait[ Index(((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 20: /* STATE 24 - shift-alt-esc1.pml:143 - [orderId[thisOrder] = 255] (0:28:2 - 1) */
		IfNotBlocked
		reached[2][24] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]);
		now.orderId[ Index(((P2 *)this)->_4_thisOrder, 2) ] = 255;
#ifdef VAR_RANGES
		logval("orderId[Server:thisOrder]", ((int)now.orderId[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]));
#endif
		;
		/* merge: order[thisOrder] = 0(28, 25, 28) */
		reached[2][25] = 1;
		(trpt+1)->bup.ovals[1] = ((int)now.order[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]);
		now.order[ Index(((P2 *)this)->_4_thisOrder, 2) ] = 0;
#ifdef VAR_RANGES
		logval("order[Server:thisOrder]", ((int)now.order[ Index(((int)((P2 *)this)->_4_thisOrder), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 21: /* STATE 27 - shift-alt-esc1.pml:32 - [serve = (serve+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][27] = 1;
		(trpt+1)->bup.oval = ((int)now.serve);
		now.serve = (((int)now.serve)+1);
#ifdef VAR_RANGES
		logval("serve", ((int)now.serve));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 22: /* STATE 31 - shift-alt-esc1.pml:149 - [busyServe[thisOrder] = 0] (0:0:1 - 2) */
		IfNotBlocked
		reached[2][31] = 1;
		(trpt+1)->bup.oval = ((int)busyServe[ Index(((int)((P2 *)this)->_4_thisOrder), 1) ]);
		busyServe[ Index(((P2 *)this)->_4_thisOrder, 1) ] = 0;
#ifdef VAR_RANGES
		logval("busyServe[Server:thisOrder]", ((int)busyServe[ Index(((int)((P2 *)this)->_4_thisOrder), 1) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 23: /* STATE 32 - shift-alt-esc1.pml:150 - [printf('I'm waiting on an order')] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][32] = 1;
		Printf("I'm waiting on an order");
		_m = 3; goto P999; /* 0 */
	case 24: /* STATE 38 - shift-alt-esc1.pml:154 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][38] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Cashier */
	case 25: /* STATE 1 - shift-alt-esc1.pml:102 - [(waiting[cust])] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][1] = 1;
		if (!(((int)now.waiting[ Index(((int)((P1 *)this)->_3_cust), 2) ])))
			continue;
		_m = 3; goto P999; /* 0 */
	case 26: /* STATE 2 - shift-alt-esc1.pml:103 - [custsOrdering[cust] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][2] = 1;
		(trpt+1)->bup.oval = ((int)custsOrdering[ Index(((int)((P1 *)this)->_3_cust), 2) ]);
		custsOrdering[ Index(((P1 *)this)->_3_cust, 2) ] = 0;
#ifdef VAR_RANGES
		logval("custsOrdering[Cashier:cust]", ((int)custsOrdering[ Index(((int)((P1 *)this)->_3_cust), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 27: /* STATE 3 - shift-alt-esc1.pml:104 - [printf('Customer %d was chosen',cust)] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][3] = 1;
		Printf("Customer %d was chosen", ((int)((P1 *)this)->_3_cust));
		_m = 3; goto P999; /* 0 */
	case 28: /* STATE 4 - shift-alt-esc1.pml:33 - [((cust_wait[cust]>0))] (11:0:1 - 1) */
		IfNotBlocked
		reached[1][4] = 1;
		if (!((((int)now.cust_wait[ Index(((int)((P1 *)this)->_3_cust), 2) ])>0)))
			continue;
		/* merge: cust_wait[cust] = (cust_wait[cust]-1)(0, 5, 11) */
		reached[1][5] = 1;
		(trpt+1)->bup.oval = ((int)now.cust_wait[ Index(((int)((P1 *)this)->_3_cust), 2) ]);
		now.cust_wait[ Index(((P1 *)this)->_3_cust, 2) ] = (((int)now.cust_wait[ Index(((int)((P1 *)this)->_3_cust), 2) ])-1);
#ifdef VAR_RANGES
		logval("cust_wait[Cashier:cust]", ((int)now.cust_wait[ Index(((int)((P1 *)this)->_3_cust), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 29: /* STATE 8 - shift-alt-esc1.pml:33 - [((cash>0))] (12:0:1 - 1) */
		IfNotBlocked
		reached[1][8] = 1;
		if (!((((int)now.cash)>0)))
			continue;
		/* merge: cash = (cash-1)(0, 9, 12) */
		reached[1][9] = 1;
		(trpt+1)->bup.oval = ((int)now.cash);
		now.cash = (((int)now.cash)-1);
#ifdef VAR_RANGES
		logval("cash", ((int)now.cash));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 30: /* STATE 12 - shift-alt-esc1.pml:107 - [order[nextOrder] = foods[cust]] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][12] = 1;
		(trpt+1)->bup.oval = ((int)now.order[ Index(((int)now.nextOrder), 2) ]);
		now.order[ Index(now.nextOrder, 2) ] = now.foods[ Index(((int)((P1 *)this)->_3_cust), 2) ];
#ifdef VAR_RANGES
		logval("order[nextOrder]", ((int)now.order[ Index(((int)now.nextOrder), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 31: /* STATE 13 - shift-alt-esc1.pml:108 - [orderId[nextOrder] = cust] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][13] = 1;
		(trpt+1)->bup.oval = ((int)now.orderId[ Index(((int)now.nextOrder), 2) ]);
		now.orderId[ Index(now.nextOrder, 2) ] = ((int)((P1 *)this)->_3_cust);
#ifdef VAR_RANGES
		logval("orderId[nextOrder]", ((int)now.orderId[ Index(((int)now.nextOrder), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 32: /* STATE 14 - shift-alt-esc1.pml:33 - [((serve>0))] (18:0:1 - 1) */
		IfNotBlocked
		reached[1][14] = 1;
		if (!((((int)now.serve)>0)))
			continue;
		/* merge: serve = (serve-1)(0, 15, 18) */
		reached[1][15] = 1;
		(trpt+1)->bup.oval = ((int)now.serve);
		now.serve = (((int)now.serve)-1);
#ifdef VAR_RANGES
		logval("serve", ((int)now.serve));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 33: /* STATE 18 - shift-alt-esc1.pml:110 - [nextOrder = (nextOrder+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][18] = 1;
		(trpt+1)->bup.oval = ((int)now.nextOrder);
		now.nextOrder = (((int)now.nextOrder)+1);
#ifdef VAR_RANGES
		logval("nextOrder", ((int)now.nextOrder));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 34: /* STATE 19 - shift-alt-esc1.pml:111 - [nextOrder = ((nextOrder+1)%2)] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][19] = 1;
		(trpt+1)->bup.oval = ((int)now.nextOrder);
		now.nextOrder = ((((int)now.nextOrder)+1)%2);
#ifdef VAR_RANGES
		logval("nextOrder", ((int)now.nextOrder));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 35: /* STATE 21 - shift-alt-esc1.pml:115 - [cust = (cust+1)] (0:24:2 - 1) */
		IfNotBlocked
		reached[1][21] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((int)((P1 *)this)->_3_cust);
		((P1 *)this)->_3_cust = (((int)((P1 *)this)->_3_cust)+1);
#ifdef VAR_RANGES
		logval("Cashier:cust", ((int)((P1 *)this)->_3_cust));
#endif
		;
		/* merge: cust = (cust%2)(24, 22, 24) */
		reached[1][22] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P1 *)this)->_3_cust);
		((P1 *)this)->_3_cust = (((int)((P1 *)this)->_3_cust)%2);
#ifdef VAR_RANGES
		logval("Cashier:cust", ((int)((P1 *)this)->_3_cust));
#endif
		;
		/* merge: .(goto)(0, 25, 24) */
		reached[1][25] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 36: /* STATE 27 - shift-alt-esc1.pml:118 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][27] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Customer */
	case 37: /* STATE 1 - shift-alt-esc1.pml:57 - [printf('C%d enters the Shift-Alt-Esc Cafe\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		Printf("C%d enters the Shift-Alt-Esc Cafe\n", ((int)((P0 *)this)->me));
		_m = 3; goto P999; /* 0 */
	case 38: /* STATE 2 - shift-alt-esc1.pml:58 - [fav[me] = food] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((int)fav[ Index(((int)((P0 *)this)->me), 2) ]);
		fav[ Index(((P0 *)this)->me, 2) ] = ((P0 *)this)->food;
#ifdef VAR_RANGES
		logval("fav[Customer:me]", ((int)fav[ Index(((int)((P0 *)this)->me), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 39: /* STATE 3 - shift-alt-esc1.pml:33 - [((mutex>0))] (19:0:1 - 1) */
		IfNotBlocked
		reached[0][3] = 1;
		if (!((((int)now.mutex)>0)))
			continue;
		/* merge: mutex = (mutex-1)(0, 4, 19) */
		reached[0][4] = 1;
		(trpt+1)->bup.oval = ((int)now.mutex);
		now.mutex = (((int)now.mutex)-1);
#ifdef VAR_RANGES
		logval("mutex", ((int)now.mutex));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 40: /* STATE 7 - shift-alt-esc1.pml:61 - [((ordering==255))] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][7] = 1;
		if (!((((int)now.ordering)==255)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 41: /* STATE 8 - shift-alt-esc1.pml:62 - [printf('C%d does not have to wait\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][8] = 1;
		Printf("C%d does not have to wait\n", ((int)((P0 *)this)->me));
		_m = 3; goto P999; /* 0 */
	case 42: /* STATE 11 - shift-alt-esc1.pml:65 - [waiting[nextWait] = me] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][11] = 1;
		(trpt+1)->bup.oval = ((int)now.waiting[ Index(((int)now.nextWait), 2) ]);
		now.waiting[ Index(now.nextWait, 2) ] = ((int)((P0 *)this)->me);
#ifdef VAR_RANGES
		logval("waiting[nextWait]", ((int)now.waiting[ Index(((int)now.nextWait), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 43: /* STATE 12 - shift-alt-esc1.pml:66 - [printf('C%d is waiting in spot %d\\n',me,nextWait)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][12] = 1;
		Printf("C%d is waiting in spot %d\n", ((int)((P0 *)this)->me), ((int)now.nextWait));
		_m = 3; goto P999; /* 0 */
	case 44: /* STATE 13 - shift-alt-esc1.pml:68 - [nextWait = ((nextWait+1)%2)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][13] = 1;
		(trpt+1)->bup.oval = ((int)now.nextWait);
		now.nextWait = ((((int)now.nextWait)+1)%2);
#ifdef VAR_RANGES
		logval("nextWait", ((int)now.nextWait));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 45: /* STATE 14 - shift-alt-esc1.pml:69 - [nwaiting = (nwaiting+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][14] = 1;
		(trpt+1)->bup.oval = ((int)nwaiting);
		nwaiting = (((int)nwaiting)+1);
#ifdef VAR_RANGES
		logval("nwaiting", ((int)nwaiting));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 46: /* STATE 15 - shift-alt-esc1.pml:32 - [mutex = (mutex+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((int)now.mutex);
		now.mutex = (((int)now.mutex)+1);
#ifdef VAR_RANGES
		logval("mutex", ((int)now.mutex));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 47: /* STATE 17 - shift-alt-esc1.pml:32 - [cust_wait[me] = (cust_wait[me]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][17] = 1;
		(trpt+1)->bup.oval = ((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ]);
		now.cust_wait[ Index(((P0 *)this)->me, 2) ] = (((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ])+1);
#ifdef VAR_RANGES
		logval("cust_wait[Customer:me]", ((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 48: /* STATE 21 - shift-alt-esc1.pml:32 - [mutex = (mutex+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][21] = 1;
		(trpt+1)->bup.oval = ((int)now.mutex);
		now.mutex = (((int)now.mutex)+1);
#ifdef VAR_RANGES
		logval("mutex", ((int)now.mutex));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 49: /* STATE 23 - shift-alt-esc1.pml:75 - [ordering = me] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][23] = 1;
		(trpt+1)->bup.oval = ((int)now.ordering);
		now.ordering = ((int)((P0 *)this)->me);
#ifdef VAR_RANGES
		logval("ordering", ((int)now.ordering));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 50: /* STATE 24 - shift-alt-esc1.pml:76 - [nserving = (nserving+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][24] = 1;
		(trpt+1)->bup.oval = ((int)nserving);
		nserving = (((int)nserving)+1);
#ifdef VAR_RANGES
		logval("nserving", ((int)nserving));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 51: /* STATE 25 - shift-alt-esc1.pml:77 - [printf('C%d approaches the serving station\\n',me)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][25] = 1;
		Printf("C%d approaches the serving station\n", ((int)((P0 *)this)->me));
		_m = 3; goto P999; /* 0 */
	case 52: /* STATE 26 - shift-alt-esc1.pml:32 - [cust_wait[me] = (cust_wait[me]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][26] = 1;
		(trpt+1)->bup.oval = ((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ]);
		now.cust_wait[ Index(((P0 *)this)->me, 2) ] = (((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ])+1);
#ifdef VAR_RANGES
		logval("cust_wait[Customer:me]", ((int)now.cust_wait[ Index(((int)((P0 *)this)->me), 2) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 53: /* STATE 28 - shift-alt-esc1.pml:84 - [printf('C%d places order for %s',me,food)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][28] = 1;
		Printf("C%d places order for %s", ((int)((P0 *)this)->me), ((P0 *)this)->food);
		_m = 3; goto P999; /* 0 */
	case 54: /* STATE 32 - shift-alt-esc1.pml:88 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][32] = 1;
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

