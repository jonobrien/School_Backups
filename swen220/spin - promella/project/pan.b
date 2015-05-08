	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* CLAIM Liveness */
;
		;
		
	case 4: /* STATE 5 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM Safety */
;
		;
		;
		;
		
	case 7: /* STATE 9 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC :init: */

	case 8: /* STATE 4 */
		;
		now.foodArray[3] = trpt->bup.ovals[3];
		now.foodArray[2] = trpt->bup.ovals[2];
		now.foodArray[1] = trpt->bup.ovals[1];
		now.foodArray[0] = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 4);
		goto R999;

	case 9: /* STATE 5 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 10: /* STATE 6 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 11: /* STATE 7 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 12: /* STATE 8 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 13: /* STATE 9 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 14: /* STATE 11 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Server */

	case 15: /* STATE 1 */
		;
		((P2 *)this)->_4_custID = trpt->bup.oval;
		;
		goto R999;

	case 16: /* STATE 2 */
		;
		(((int)((P2 *)this)->_4_custID)<=2);
		;
		goto R999;
;
		;
		
	case 18: /* STATE 8 */
		;
		((P2 *)this)->_4_receivedOrder = trpt->bup.ovals[1];
		now.serverMutex[0] = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 19: /* STATE 9 */
		;
		now.serverBusy[0] = trpt->bup.oval;
		;
		goto R999;
;
		;
		;
		;
		
	case 22: /* STATE 12 */
		;
		now.orderFulfilled[ Index(((P2 *)this)->_4_custID, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 23: /* STATE 13 */
		;
		now.serverMutex[0] = trpt->bup.oval;
		;
		goto R999;

	case 24: /* STATE 15 */
		;
		now.serverBusy[0] = trpt->bup.oval;
		;
		goto R999;

	case 25: /* STATE 16 */
		;
		now.cashierBusy = trpt->bup.oval;
		;
		goto R999;

	case 26: /* STATE 24 */
		;
		((P2 *)this)->_4_custID = trpt->bup.ovals[1];
		((P2 *)this)->_4_receivedOrder = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 28: /* STATE 24 */
		;
		((P2 *)this)->_4_custID = trpt->bup.oval;
		;
		goto R999;

	case 29: /* STATE 24 */
		;
		((P2 *)this)->_4_custID = trpt->bup.oval;
		;
		goto R999;

	case 30: /* STATE 24 */
		;
		((P2 *)this)->_4_custID = trpt->bup.oval;
		;
		goto R999;

	case 31: /* STATE 33 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Cashier */

	case 32: /* STATE 1 */
		;
		((P1 *)this)->_3_custID = trpt->bup.oval;
		;
		goto R999;

	case 33: /* STATE 2 */
		;
		(((int)((P1 *)this)->_3_custID)<=2);
		;
		goto R999;
;
		;
		
	case 35: /* STATE 8 */
		;
		((P1 *)this)->_3_someCustPlacedOrder = trpt->bup.ovals[1];
		now.cashierMutex = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;

	case 36: /* STATE 9 */
		;
		now.custOrderSent[ Index(((P1 *)this)->_3_custID, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 37: /* STATE 10 */
		;
		now.cashierBusy = trpt->bup.oval;
		;
		goto R999;

	case 38: /* STATE 11 */
		;
		now.someCustSelected = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 40: /* STATE 13 */
		;
		now.orderTaken[ Index(((P1 *)this)->_3_custID, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 41: /* STATE 14 */
		;
		now.custOrderSent[ Index(((P1 *)this)->_3_custID, 3) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		;
		;
		
	case 44: /* STATE 17 */
		;
		((P1 *)this)->_3_custsOrder = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;

	case 45: /* STATE 18 */
		;
		now.cashierMutex = trpt->bup.oval;
		;
		goto R999;

	case 46: /* STATE 26 */
		;
		((P1 *)this)->_3_custID = trpt->bup.oval;
		;
		goto R999;

	case 47: /* STATE 26 */
		;
		((P1 *)this)->_3_custID = trpt->bup.oval;
		;
		goto R999;

	case 48: /* STATE 26 */
		;
		((P1 *)this)->_3_custID = trpt->bup.oval;
		;
		goto R999;

	case 49: /* STATE 35 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Customer */
;
		;
		;
		;
		
	case 52: /* STATE 3 */
		;
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 53: /* STATE 4 */
		;
		now.orderFulfilled[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 54: /* STATE 5 */
		;
		now.customerWaiting[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 56: /* STATE 8 */
		;
		now.customerMutex[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 57: /* STATE 11 */
		;
		now.customerOrder[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 59: /* STATE 13 */
		;
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 61: /* STATE 15 */
		;
		now.customerWaiting[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 62: /* STATE 16 */
		;
		now.custPlacedOrder[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 63: /* STATE 17 */
		;
		now.orderFulfilled[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;
;
		
	case 64: /* STATE 18 */
		goto R999;

	case 65: /* STATE 20 */
		;
		now.custOrderSent[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 66: /* STATE 21 */
		;
		now.orderTaken[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 67: /* STATE 22 */
		;
		now.customerOrder[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 68: /* STATE 23 */
		;
		now.someCustSelected = trpt->bup.oval;
		;
		goto R999;

	case 69: /* STATE 24 */
		;
		now.customerMutex[ Index(((P0 *)this)->id, 3) ] = trpt->bup.oval;
		;
		goto R999;

	case 70: /* STATE 33 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

