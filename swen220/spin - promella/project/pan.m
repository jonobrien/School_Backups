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

		 /* CLAIM Liveness */
	case 3: /* STATE 1 - _spin_nvr.tmp:16 - [((!(custPlacedOrder[2])&&customerWaiting[2]))] (0:0:0 - 1) */
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0; int nn = (int) ((Pclaim *)this)->_n;
			if (verbose && !reported1)
			{	printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[5][1] = 1;
		if (!(( !(((int)now.custPlacedOrder[2]))&&((int)now.customerWaiting[2]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 4: /* STATE 5 - _spin_nvr.tmp:18 - [-end-] (0:0:0 - 1) */
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported5 = 0; int nn = (int) ((Pclaim *)this)->_n;
			if (verbose && !reported5)
			{	printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#else
{	static int reported5 = 0;
			if (verbose && !reported5)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[5][5] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* CLAIM Safety */
	case 5: /* STATE 1 - _spin_nvr.tmp:4 - [(((!(cashierBusy)&&!((customerOrder[2]==PIZZA)))&&customerWaiting[2]))] (0:0:0 - 1) */
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0; int nn = (int) ((Pclaim *)this)->_n;
			if (verbose && !reported1)
			{	printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][1] = 1;
		if (!((( !(((int)now.cashierBusy))&& !((now.customerOrder[2]==2)))&&((int)now.customerWaiting[2]))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 6: /* STATE 5 - _spin_nvr.tmp:9 - [(customerWaiting[2])] (0:0:0 - 1) */
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported5 = 0; int nn = (int) ((Pclaim *)this)->_n;
			if (verbose && !reported5)
			{	printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#else
{	static int reported5 = 0;
			if (verbose && !reported5)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported5 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][5] = 1;
		if (!(((int)now.customerWaiting[2])))
			continue;
		_m = 3; goto P999; /* 0 */
	case 7: /* STATE 9 - _spin_nvr.tmp:11 - [-end-] (0:0:0 - 1) */
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported9 = 0; int nn = (int) ((Pclaim *)this)->_n;
			if (verbose && !reported9)
			{	printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported9 = 1;
				fflush(stdout);
		}	}
#else
{	static int reported9 = 0;
			if (verbose && !reported9)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)this)->_p, src_claim[ (int) ((Pclaim *)this)->_p ]);
				reported9 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[4][9] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC :init: */
	case 8: /* STATE 1 - shift-alt-escape_paste1_edits.pml:225 - [foodArray[0] = CHILI] (0:5:4 - 1) */
		IfNotBlocked
		reached[3][1] = 1;
		(trpt+1)->bup.ovals = grab_ints(4);
		(trpt+1)->bup.ovals[0] = now.foodArray[0];
		now.foodArray[0] = 4;
#ifdef VAR_RANGES
		logval("foodArray[0]", now.foodArray[0]);
#endif
		;
		/* merge: foodArray[1] = SANDWICH(5, 2, 5) */
		reached[3][2] = 1;
		(trpt+1)->bup.ovals[1] = now.foodArray[1];
		now.foodArray[1] = 3;
#ifdef VAR_RANGES
		logval("foodArray[1]", now.foodArray[1]);
#endif
		;
		/* merge: foodArray[2] = PIZZA(5, 3, 5) */
		reached[3][3] = 1;
		(trpt+1)->bup.ovals[2] = now.foodArray[2];
		now.foodArray[2] = 2;
#ifdef VAR_RANGES
		logval("foodArray[2]", now.foodArray[2]);
#endif
		;
		/* merge: foodArray[3] = NONE(5, 4, 5) */
		reached[3][4] = 1;
		(trpt+1)->bup.ovals[3] = now.foodArray[3];
		now.foodArray[3] = 1;
#ifdef VAR_RANGES
		logval("foodArray[3]", now.foodArray[3]);
#endif
		;
		_m = 3; goto P999; /* 3 */
	case 9: /* STATE 5 - shift-alt-escape_paste1_edits.pml:229 - [(run Customer(CHILI,0))] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][5] = 1;
		if (!(addproc(0, 4, 0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 10: /* STATE 6 - shift-alt-escape_paste1_edits.pml:230 - [(run Customer(SANDWICH,1))] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][6] = 1;
		if (!(addproc(0, 3, 1)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 11: /* STATE 7 - shift-alt-escape_paste1_edits.pml:231 - [(run Customer(PIZZA,2))] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][7] = 1;
		if (!(addproc(0, 2, 2)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 12: /* STATE 8 - shift-alt-escape_paste1_edits.pml:232 - [(run Cashier())] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][8] = 1;
		if (!(addproc(1, 0, 0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 13: /* STATE 9 - shift-alt-escape_paste1_edits.pml:233 - [(run Server())] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][9] = 1;
		if (!(addproc(2, 0, 0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 14: /* STATE 11 - shift-alt-escape_paste1_edits.pml:235 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[3][11] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Server */
	case 15: /* STATE 1 - shift-alt-escape_paste1_edits.pml:191 - [custID = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][1] = 1;
		(trpt+1)->bup.oval = ((int)((P2 *)this)->_4_custID);
		((P2 *)this)->_4_custID = 0;
#ifdef VAR_RANGES
		logval("Server:custID", ((int)((P2 *)this)->_4_custID));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 16: /* STATE 2 - shift-alt-escape_paste1_edits.pml:191 - [(custID<=2)] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][2] = 1;
		(((int)((P2 *)this)->_4_custID)<=2);
		_m = 3; goto P999; /* 0 */
	case 17: /* STATE 3 - shift-alt-escape_paste1_edits.pml:193 - [(custOrderSent[custID])] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][3] = 1;
		if (!(((int)now.custOrderSent[ Index(((int)((P2 *)this)->_4_custID), 3) ])))
			continue;
		_m = 3; goto P999; /* 0 */
	case 18: /* STATE 4 - shift-alt-escape_paste1_edits.pml:26 - [((serverMutex[0]>0))] (9:0:3 - 1) */
		IfNotBlocked
		reached[2][4] = 1;
		if (!((((int)now.serverMutex[0])>0)))
			continue;
		/* merge: serverMutex[0] = (serverMutex[0]-1)(9, 5, 9) */
		reached[2][5] = 1;
		(trpt+1)->bup.ovals = grab_ints(3);
		(trpt+1)->bup.ovals[0] = ((int)now.serverMutex[0]);
		now.serverMutex[0] = (((int)now.serverMutex[0])-1);
#ifdef VAR_RANGES
		logval("serverMutex[0]", ((int)now.serverMutex[0]));
#endif
		;
		/* merge: receivedOrder = 1(9, 8, 9) */
		reached[2][8] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P2 *)this)->_4_receivedOrder);
		((P2 *)this)->_4_receivedOrder = 1;
#ifdef VAR_RANGES
		logval("Server:receivedOrder", ((int)((P2 *)this)->_4_receivedOrder));
#endif
		;
		/* dead 2: _4_receivedOrder */  
#ifdef HAS_CODE
		if (!readtrail)
#endif
			((P2 *)this)->_4_receivedOrder = 0;
		_m = 3; goto P999; /* 2 */
	case 19: /* STATE 9 - shift-alt-escape_paste1_edits.pml:196 - [serverBusy[0] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][9] = 1;
		(trpt+1)->bup.oval = ((int)now.serverBusy[0]);
		now.serverBusy[0] = 1;
#ifdef VAR_RANGES
		logval("serverBusy[0]", ((int)now.serverBusy[0]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 20: /* STATE 10 - shift-alt-escape_paste1_edits.pml:197 - [printf('Server retrieves & creates customer %d's order of %e\\n',custID,customerOrder[custID])] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][10] = 1;
		Printf("Server retrieves & creates customer %d's order of %e\n", ((int)((P2 *)this)->_4_custID), now.customerOrder[ Index(((int)((P2 *)this)->_4_custID), 3) ]);
		_m = 3; goto P999; /* 0 */
	case 21: /* STATE 11 - shift-alt-escape_paste1_edits.pml:198 - [printf('Server delivers customer %d his order of %e\\n',custID,customerOrder[custID])] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][11] = 1;
		Printf("Server delivers customer %d his order of %e\n", ((int)((P2 *)this)->_4_custID), now.customerOrder[ Index(((int)((P2 *)this)->_4_custID), 3) ]);
		_m = 3; goto P999; /* 0 */
	case 22: /* STATE 12 - shift-alt-escape_paste1_edits.pml:199 - [orderFulfilled[custID] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][12] = 1;
		(trpt+1)->bup.oval = ((int)now.orderFulfilled[ Index(((int)((P2 *)this)->_4_custID), 3) ]);
		now.orderFulfilled[ Index(((P2 *)this)->_4_custID, 3) ] = 1;
#ifdef VAR_RANGES
		logval("orderFulfilled[Server:custID]", ((int)now.orderFulfilled[ Index(((int)((P2 *)this)->_4_custID), 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 23: /* STATE 13 - shift-alt-escape_paste1_edits.pml:25 - [serverMutex[0] = (serverMutex[0]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][13] = 1;
		(trpt+1)->bup.oval = ((int)now.serverMutex[0]);
		now.serverMutex[0] = (((int)now.serverMutex[0])+1);
#ifdef VAR_RANGES
		logval("serverMutex[0]", ((int)now.serverMutex[0]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 24: /* STATE 15 - shift-alt-escape_paste1_edits.pml:201 - [serverBusy[0] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][15] = 1;
		(trpt+1)->bup.oval = ((int)now.serverBusy[0]);
		now.serverBusy[0] = 0;
#ifdef VAR_RANGES
		logval("serverBusy[0]", ((int)now.serverBusy[0]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 25: /* STATE 16 - shift-alt-escape_paste1_edits.pml:206 - [cashierBusy = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[2][16] = 1;
		(trpt+1)->bup.oval = ((int)now.cashierBusy);
		now.cashierBusy = 0;
#ifdef VAR_RANGES
		logval("cashierBusy", ((int)now.cashierBusy));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 26: /* STATE 17 - shift-alt-escape_paste1_edits.pml:207 - [receivedOrder = 0] (0:27:2 - 1) */
		IfNotBlocked
		reached[2][17] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((int)((P2 *)this)->_4_receivedOrder);
		((P2 *)this)->_4_receivedOrder = 0;
#ifdef VAR_RANGES
		logval("Server:receivedOrder", ((int)((P2 *)this)->_4_receivedOrder));
#endif
		;
		/* merge: .(goto)(27, 23, 27) */
		reached[2][23] = 1;
		;
		/* merge: custID = (custID+1)(27, 24, 27) */
		reached[2][24] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P2 *)this)->_4_custID);
		((P2 *)this)->_4_custID = (((int)((P2 *)this)->_4_custID)+1);
#ifdef VAR_RANGES
		logval("Server:custID", ((int)((P2 *)this)->_4_custID));
#endif
		;
		/* merge: .(goto)(0, 28, 27) */
		reached[2][28] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 27: /* STATE 18 - shift-alt-escape_paste1_edits.pml:208 - [(((!(custOrderSent[0])&&!(custOrderSent[1]))&&!(custOrderSent[2])))] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][18] = 1;
		if (!((( !(((int)now.custOrderSent[0]))&& !(((int)now.custOrderSent[1])))&& !(((int)now.custOrderSent[2])))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 28: /* STATE 19 - shift-alt-escape_paste1_edits.pml:209 - [printf('Server waits for an order to come in\\n')] (0:27:1 - 1) */
		IfNotBlocked
		reached[2][19] = 1;
		Printf("Server waits for an order to come in\n");
		/* merge: .(goto)(27, 23, 27) */
		reached[2][23] = 1;
		;
		/* merge: custID = (custID+1)(27, 24, 27) */
		reached[2][24] = 1;
		(trpt+1)->bup.oval = ((int)((P2 *)this)->_4_custID);
		((P2 *)this)->_4_custID = (((int)((P2 *)this)->_4_custID)+1);
#ifdef VAR_RANGES
		logval("Server:custID", ((int)((P2 *)this)->_4_custID));
#endif
		;
		/* merge: .(goto)(0, 28, 27) */
		reached[2][28] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 29: /* STATE 21 - shift-alt-escape_paste1_edits.pml:211 - [(1)] (27:0:1 - 1) */
		IfNotBlocked
		reached[2][21] = 1;
		if (!(1))
			continue;
		/* merge: .(goto)(27, 23, 27) */
		reached[2][23] = 1;
		;
		/* merge: custID = (custID+1)(27, 24, 27) */
		reached[2][24] = 1;
		(trpt+1)->bup.oval = ((int)((P2 *)this)->_4_custID);
		((P2 *)this)->_4_custID = (((int)((P2 *)this)->_4_custID)+1);
#ifdef VAR_RANGES
		logval("Server:custID", ((int)((P2 *)this)->_4_custID));
#endif
		;
		/* merge: .(goto)(0, 28, 27) */
		reached[2][28] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 30: /* STATE 24 - shift-alt-escape_paste1_edits.pml:191 - [custID = (custID+1)] (0:27:1 - 4) */
		IfNotBlocked
		reached[2][24] = 1;
		(trpt+1)->bup.oval = ((int)((P2 *)this)->_4_custID);
		((P2 *)this)->_4_custID = (((int)((P2 *)this)->_4_custID)+1);
#ifdef VAR_RANGES
		logval("Server:custID", ((int)((P2 *)this)->_4_custID));
#endif
		;
		/* merge: .(goto)(0, 28, 27) */
		reached[2][28] = 1;
		;
		_m = 3; goto P999; /* 1 */
	case 31: /* STATE 33 - shift-alt-escape_paste1_edits.pml:215 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[2][33] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Cashier */
	case 32: /* STATE 1 - shift-alt-escape_paste1_edits.pml:155 - [custID = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][1] = 1;
		(trpt+1)->bup.oval = ((int)((P1 *)this)->_3_custID);
		((P1 *)this)->_3_custID = 0;
#ifdef VAR_RANGES
		logval("Cashier:custID", ((int)((P1 *)this)->_3_custID));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 33: /* STATE 2 - shift-alt-escape_paste1_edits.pml:155 - [(custID<=2)] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][2] = 1;
		(((int)((P1 *)this)->_3_custID)<=2);
		_m = 3; goto P999; /* 0 */
	case 34: /* STATE 3 - shift-alt-escape_paste1_edits.pml:159 - [(((customerWaiting[custID]&&!(custPlacedOrder[custID]))&&!(someCustSelected)))] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][3] = 1;
		if (!(((((int)now.customerWaiting[ Index(((int)((P1 *)this)->_3_custID), 3) ])&& !(((int)now.custPlacedOrder[ Index(((int)((P1 *)this)->_3_custID), 3) ])))&& !(((int)now.someCustSelected)))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 35: /* STATE 4 - shift-alt-escape_paste1_edits.pml:26 - [((cashierMutex>0))] (9:0:2 - 1) */
		IfNotBlocked
		reached[1][4] = 1;
		if (!((((int)now.cashierMutex)>0)))
			continue;
		/* merge: cashierMutex = (cashierMutex-1)(9, 5, 9) */
		reached[1][5] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((int)now.cashierMutex);
		now.cashierMutex = (((int)now.cashierMutex)-1);
#ifdef VAR_RANGES
		logval("cashierMutex", ((int)now.cashierMutex));
#endif
		;
		/* merge: someCustPlacedOrder = 1(9, 8, 9) */
		reached[1][8] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P1 *)this)->_3_someCustPlacedOrder);
		((P1 *)this)->_3_someCustPlacedOrder = 1;
#ifdef VAR_RANGES
		logval("Cashier:someCustPlacedOrder", ((int)((P1 *)this)->_3_someCustPlacedOrder));
#endif
		;
		_m = 3; goto P999; /* 2 */
	case 36: /* STATE 9 - shift-alt-escape_paste1_edits.pml:162 - [custOrderSent[custID] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][9] = 1;
		(trpt+1)->bup.oval = ((int)now.custOrderSent[ Index(((int)((P1 *)this)->_3_custID), 3) ]);
		now.custOrderSent[ Index(((P1 *)this)->_3_custID, 3) ] = 0;
#ifdef VAR_RANGES
		logval("custOrderSent[Cashier:custID]", ((int)now.custOrderSent[ Index(((int)((P1 *)this)->_3_custID), 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 37: /* STATE 10 - shift-alt-escape_paste1_edits.pml:163 - [cashierBusy = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][10] = 1;
		(trpt+1)->bup.oval = ((int)now.cashierBusy);
		now.cashierBusy = 0;
#ifdef VAR_RANGES
		logval("cashierBusy", ((int)now.cashierBusy));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 38: /* STATE 11 - shift-alt-escape_paste1_edits.pml:164 - [someCustSelected = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][11] = 1;
		(trpt+1)->bup.oval = ((int)now.someCustSelected);
		now.someCustSelected = 1;
#ifdef VAR_RANGES
		logval("someCustSelected", ((int)now.someCustSelected));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 39: /* STATE 12 - shift-alt-escape_paste1_edits.pml:166 - [(((custPlacedOrder[custID]&&!(serverBusy[0]))&&!(orderTaken[custID])))] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][12] = 1;
		if (!(((((int)now.custPlacedOrder[ Index(((int)((P1 *)this)->_3_custID), 3) ])&& !(((int)now.serverBusy[0])))&& !(((int)now.orderTaken[ Index(((int)((P1 *)this)->_3_custID), 3) ])))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 40: /* STATE 13 - shift-alt-escape_paste1_edits.pml:168 - [orderTaken[custID] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][13] = 1;
		(trpt+1)->bup.oval = ((int)now.orderTaken[ Index(((int)((P1 *)this)->_3_custID), 3) ]);
		now.orderTaken[ Index(((P1 *)this)->_3_custID, 3) ] = 1;
#ifdef VAR_RANGES
		logval("orderTaken[Cashier:custID]", ((int)now.orderTaken[ Index(((int)((P1 *)this)->_3_custID), 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 41: /* STATE 14 - shift-alt-escape_paste1_edits.pml:169 - [custOrderSent[custID] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][14] = 1;
		(trpt+1)->bup.oval = ((int)now.custOrderSent[ Index(((int)((P1 *)this)->_3_custID), 3) ]);
		now.custOrderSent[ Index(((P1 *)this)->_3_custID, 3) ] = 1;
#ifdef VAR_RANGES
		logval("custOrderSent[Cashier:custID]", ((int)now.custOrderSent[ Index(((int)((P1 *)this)->_3_custID), 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 42: /* STATE 15 - shift-alt-escape_paste1_edits.pml:170 - [printf('Cashier selects customer %d and takes his order of %e\\n',custID,customerOrder[custID])] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][15] = 1;
		Printf("Cashier selects customer %d and takes his order of %e\n", ((int)((P1 *)this)->_3_custID), now.customerOrder[ Index(((int)((P1 *)this)->_3_custID), 3) ]);
		_m = 3; goto P999; /* 0 */
	case 43: /* STATE 16 - shift-alt-escape_paste1_edits.pml:171 - [printf('Cashier sends customer %d's order of %e to the server\\n',custID,customerOrder[custID])] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][16] = 1;
		Printf("Cashier sends customer %d's order of %e to the server\n", ((int)((P1 *)this)->_3_custID), now.customerOrder[ Index(((int)((P1 *)this)->_3_custID), 3) ]);
		_m = 3; goto P999; /* 0 */
	case 44: /* STATE 17 - shift-alt-escape_paste1_edits.pml:172 - [custsOrder = foodArray[custID]] (0:0:2 - 1) */
		IfNotBlocked
		reached[1][17] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((P1 *)this)->_3_custsOrder;
		((P1 *)this)->_3_custsOrder = now.foodArray[ Index(((int)((P1 *)this)->_3_custID), 4) ];
#ifdef VAR_RANGES
		logval("Cashier:custsOrder", ((P1 *)this)->_3_custsOrder);
#endif
		;
		/* dead 2: _3_custsOrder */  
#ifdef HAS_CODE
		if (!readtrail)
#endif
			((P1 *)this)->_3_custsOrder = 0;
		_m = 3; goto P999; /* 0 */
	case 45: /* STATE 18 - shift-alt-escape_paste1_edits.pml:25 - [cashierMutex = (cashierMutex+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[1][18] = 1;
		(trpt+1)->bup.oval = ((int)now.cashierMutex);
		now.cashierMutex = (((int)now.cashierMutex)+1);
#ifdef VAR_RANGES
		logval("cashierMutex", ((int)now.cashierMutex));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 46: /* STATE 20 - shift-alt-escape_paste1_edits.pml:174 - [((!(someCustPlacedOrder)&&(custID==2)))] (29:0:1 - 1) */
		IfNotBlocked
		reached[1][20] = 1;
		if (!(( !(((int)((P1 *)this)->_3_someCustPlacedOrder))&&(((int)((P1 *)this)->_3_custID)==2))))
			continue;
		/* merge: printf('Cashier waits for a customer to approach him\\n')(29, 21, 29) */
		reached[1][21] = 1;
		Printf("Cashier waits for a customer to approach him\n");
		/* merge: .(goto)(29, 25, 29) */
		reached[1][25] = 1;
		;
		/* merge: custID = (custID+1)(29, 26, 29) */
		reached[1][26] = 1;
		(trpt+1)->bup.oval = ((int)((P1 *)this)->_3_custID);
		((P1 *)this)->_3_custID = (((int)((P1 *)this)->_3_custID)+1);
#ifdef VAR_RANGES
		logval("Cashier:custID", ((int)((P1 *)this)->_3_custID));
#endif
		;
		/* merge: .(goto)(0, 30, 29) */
		reached[1][30] = 1;
		;
		_m = 3; goto P999; /* 4 */
	case 47: /* STATE 23 - shift-alt-escape_paste1_edits.pml:177 - [(1)] (29:0:1 - 1) */
		IfNotBlocked
		reached[1][23] = 1;
		if (!(1))
			continue;
		/* merge: .(goto)(29, 25, 29) */
		reached[1][25] = 1;
		;
		/* merge: custID = (custID+1)(29, 26, 29) */
		reached[1][26] = 1;
		(trpt+1)->bup.oval = ((int)((P1 *)this)->_3_custID);
		((P1 *)this)->_3_custID = (((int)((P1 *)this)->_3_custID)+1);
#ifdef VAR_RANGES
		logval("Cashier:custID", ((int)((P1 *)this)->_3_custID));
#endif
		;
		/* merge: .(goto)(0, 30, 29) */
		reached[1][30] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 48: /* STATE 26 - shift-alt-escape_paste1_edits.pml:155 - [custID = (custID+1)] (0:29:1 - 5) */
		IfNotBlocked
		reached[1][26] = 1;
		(trpt+1)->bup.oval = ((int)((P1 *)this)->_3_custID);
		((P1 *)this)->_3_custID = (((int)((P1 *)this)->_3_custID)+1);
#ifdef VAR_RANGES
		logval("Cashier:custID", ((int)((P1 *)this)->_3_custID));
#endif
		;
		/* merge: .(goto)(0, 30, 29) */
		reached[1][30] = 1;
		;
		_m = 3; goto P999; /* 1 */
	case 49: /* STATE 35 - shift-alt-escape_paste1_edits.pml:181 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][35] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Customer */
	case 50: /* STATE 1 - shift-alt-escape_paste1_edits.pml:118 - [((customerWaiting[id]==0))] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		if (!((((int)now.customerWaiting[ Index(((P0 *)this)->id, 3) ])==0)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 51: /* STATE 2 - shift-alt-escape_paste1_edits.pml:119 - [printf('Customer %d enters store\\n',id)] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][2] = 1;
		Printf("Customer %d enters store\n", ((P0 *)this)->id);
		_m = 3; goto P999; /* 0 */
	case 52: /* STATE 3 - shift-alt-escape_paste1_edits.pml:120 - [custPlacedOrder[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][3] = 1;
		(trpt+1)->bup.oval = ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]);
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("custPlacedOrder[Customer:id]", ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 53: /* STATE 4 - shift-alt-escape_paste1_edits.pml:121 - [orderFulfilled[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][4] = 1;
		(trpt+1)->bup.oval = ((int)now.orderFulfilled[ Index(((P0 *)this)->id, 3) ]);
		now.orderFulfilled[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("orderFulfilled[Customer:id]", ((int)now.orderFulfilled[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 54: /* STATE 5 - shift-alt-escape_paste1_edits.pml:122 - [customerWaiting[id] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][5] = 1;
		(trpt+1)->bup.oval = ((int)now.customerWaiting[ Index(((P0 *)this)->id, 3) ]);
		now.customerWaiting[ Index(((P0 *)this)->id, 3) ] = 1;
#ifdef VAR_RANGES
		logval("customerWaiting[Customer:id]", ((int)now.customerWaiting[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 55: /* STATE 6 - shift-alt-escape_paste1_edits.pml:124 - [(!(cashierBusy))] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][6] = 1;
		if (!( !(((int)now.cashierBusy))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 56: /* STATE 7 - shift-alt-escape_paste1_edits.pml:26 - [((customerMutex[id]>0))] (11:0:1 - 1) */
		IfNotBlocked
		reached[0][7] = 1;
		if (!((((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ])>0)))
			continue;
		/* merge: customerMutex[id] = (customerMutex[id]-1)(0, 8, 11) */
		reached[0][8] = 1;
		(trpt+1)->bup.oval = ((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ]);
		now.customerMutex[ Index(((P0 *)this)->id, 3) ] = (((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ])-1);
#ifdef VAR_RANGES
		logval("customerMutex[Customer:id]", ((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 1 */
	case 57: /* STATE 11 - shift-alt-escape_paste1_edits.pml:126 - [customerOrder[id] = foodArray[id]] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][11] = 1;
		(trpt+1)->bup.oval = now.customerOrder[ Index(((P0 *)this)->id, 3) ];
		now.customerOrder[ Index(((P0 *)this)->id, 3) ] = now.foodArray[ Index(((P0 *)this)->id, 4) ];
#ifdef VAR_RANGES
		logval("customerOrder[Customer:id]", now.customerOrder[ Index(((P0 *)this)->id, 3) ]);
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 58: /* STATE 12 - shift-alt-escape_paste1_edits.pml:127 - [printf('Customer %d tells Cashier he wants %e\\n',id,foodArray[id])] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][12] = 1;
		Printf("Customer %d tells Cashier he wants %e\n", ((P0 *)this)->id, now.foodArray[ Index(((P0 *)this)->id, 4) ]);
		_m = 3; goto P999; /* 0 */
	case 59: /* STATE 13 - shift-alt-escape_paste1_edits.pml:128 - [custPlacedOrder[id] = 1] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][13] = 1;
		(trpt+1)->bup.oval = ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]);
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = 1;
#ifdef VAR_RANGES
		logval("custPlacedOrder[Customer:id]", ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 60: /* STATE 14 - shift-alt-escape_paste1_edits.pml:130 - [(orderFulfilled[id])] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][14] = 1;
		if (!(((int)now.orderFulfilled[ Index(((P0 *)this)->id, 3) ])))
			continue;
		_m = 3; goto P999; /* 0 */
	case 61: /* STATE 15 - shift-alt-escape_paste1_edits.pml:131 - [customerWaiting[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((int)now.customerWaiting[ Index(((P0 *)this)->id, 3) ]);
		now.customerWaiting[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("customerWaiting[Customer:id]", ((int)now.customerWaiting[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 62: /* STATE 16 - shift-alt-escape_paste1_edits.pml:132 - [custPlacedOrder[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][16] = 1;
		(trpt+1)->bup.oval = ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]);
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("custPlacedOrder[Customer:id]", ((int)now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 63: /* STATE 17 - shift-alt-escape_paste1_edits.pml:133 - [orderFulfilled[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][17] = 1;
		(trpt+1)->bup.oval = ((int)now.orderFulfilled[ Index(((P0 *)this)->id, 3) ]);
		now.orderFulfilled[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("orderFulfilled[Customer:id]", ((int)now.orderFulfilled[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 64: /* STATE 18 - shift-alt-escape_paste1_edits.pml:134 - [printf('C%d's order has been fulfilled and he leaves the restauraunt\\n',id)] (0:20:0 - 1) */
		IfNotBlocked
		reached[0][18] = 1;
		Printf("C%d's order has been fulfilled and he leaves the restauraunt\n", ((P0 *)this)->id);
		/* merge: printf('--------------------------------------------------\\n')(20, 19, 20) */
		reached[0][19] = 1;
		Printf("--------------------------------------------------\n");
		_m = 3; goto P999; /* 1 */
	case 65: /* STATE 20 - shift-alt-escape_paste1_edits.pml:136 - [custOrderSent[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][20] = 1;
		(trpt+1)->bup.oval = ((int)now.custOrderSent[ Index(((P0 *)this)->id, 3) ]);
		now.custOrderSent[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("custOrderSent[Customer:id]", ((int)now.custOrderSent[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 66: /* STATE 21 - shift-alt-escape_paste1_edits.pml:137 - [orderTaken[id] = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][21] = 1;
		(trpt+1)->bup.oval = ((int)now.orderTaken[ Index(((P0 *)this)->id, 3) ]);
		now.orderTaken[ Index(((P0 *)this)->id, 3) ] = 0;
#ifdef VAR_RANGES
		logval("orderTaken[Customer:id]", ((int)now.orderTaken[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 67: /* STATE 22 - shift-alt-escape_paste1_edits.pml:138 - [customerOrder[id] = NONE] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][22] = 1;
		(trpt+1)->bup.oval = now.customerOrder[ Index(((P0 *)this)->id, 3) ];
		now.customerOrder[ Index(((P0 *)this)->id, 3) ] = 1;
#ifdef VAR_RANGES
		logval("customerOrder[Customer:id]", now.customerOrder[ Index(((P0 *)this)->id, 3) ]);
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 68: /* STATE 23 - shift-alt-escape_paste1_edits.pml:139 - [someCustSelected = 0] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][23] = 1;
		(trpt+1)->bup.oval = ((int)now.someCustSelected);
		now.someCustSelected = 0;
#ifdef VAR_RANGES
		logval("someCustSelected", ((int)now.someCustSelected));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 69: /* STATE 24 - shift-alt-escape_paste1_edits.pml:25 - [customerMutex[id] = (customerMutex[id]+1)] (0:0:1 - 1) */
		IfNotBlocked
		reached[0][24] = 1;
		(trpt+1)->bup.oval = ((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ]);
		now.customerMutex[ Index(((P0 *)this)->id, 3) ] = (((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ])+1);
#ifdef VAR_RANGES
		logval("customerMutex[Customer:id]", ((int)now.customerMutex[ Index(((P0 *)this)->id, 3) ]));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 70: /* STATE 33 - shift-alt-escape_paste1_edits.pml:144 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][33] = 1;
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

