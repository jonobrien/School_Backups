	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* PROC :init: */

	case 3: /* STATE 1 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 4: /* STATE 2 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 5: /* STATE 3 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 6: /* STATE 4 */
		;
		;
		delproc(0, now._nr_pr-1);
		;
		goto R999;

	case 7: /* STATE 6 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Server */

	case 8: /* STATE 2 */
		;
		now.takeOrder = trpt->bup.oval;
		;
		goto R999;

	case 9: /* STATE 5 */
		;
		custsOrdering[ Index(now.curServe, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 10: /* STATE 6 */
		;
		now.takeOrder = trpt->bup.oval;
		;
		goto R999;

	case 11: /* STATE 10 */
		;
		((P2 *)this)->_4_thisOrder = trpt->bup.oval;
		;
		goto R999;

	case 12: /* STATE 11 */
		;
		now.curServe = trpt->bup.oval;
		;
		goto R999;

	case 13: /* STATE 12 */
		;
		now.takeOrder = trpt->bup.oval;
		;
		goto R999;

	case 14: /* STATE 14 */
		;
		serving[ Index(((P2 *)this)->_4_thisOrder, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 15: /* STATE 15 */
		;
		busyServe[ Index(((P2 *)this)->_4_thisOrder, 1) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		;
		;
		;
		
	case 18: /* STATE 18 */
		goto R999;

	case 19: /* STATE 21 */
		;
		now.cust_wait[ Index(now.orderId[ Index(((P2 *)this)->_4_thisOrder, 2) ], 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 20: /* STATE 25 */
		;
		now.order[ Index(((P2 *)this)->_4_thisOrder, 2) ] = trpt->bup.ovals[1];
		now.orderId[ Index(((P2 *)this)->_4_thisOrder, 2) ] = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;

	case 21: /* STATE 27 */
		;
		now.serve = trpt->bup.oval;
		;
		goto R999;

	case 22: /* STATE 31 */
		;
		busyServe[ Index(((P2 *)this)->_4_thisOrder, 1) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 24: /* STATE 38 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Cashier */
;
		;
		
	case 26: /* STATE 2 */
		;
		custsOrdering[ Index(((P1 *)this)->_3_cust, 2) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 28: /* STATE 5 */
		;
		now.cust_wait[ Index(((P1 *)this)->_3_cust, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 29: /* STATE 9 */
		;
		now.cash = trpt->bup.oval;
		;
		goto R999;

	case 30: /* STATE 12 */
		;
		now.order[ Index(now.nextOrder, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 31: /* STATE 13 */
		;
		now.orderId[ Index(now.nextOrder, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 32: /* STATE 15 */
		;
		now.serve = trpt->bup.oval;
		;
		goto R999;

	case 33: /* STATE 18 */
		;
		now.nextOrder = trpt->bup.oval;
		;
		goto R999;

	case 34: /* STATE 19 */
		;
		now.nextOrder = trpt->bup.oval;
		;
		goto R999;

	case 35: /* STATE 22 */
		;
		((P1 *)this)->_3_cust = trpt->bup.ovals[1];
		((P1 *)this)->_3_cust = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;

	case 36: /* STATE 27 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Customer */
;
		;
		
	case 38: /* STATE 2 */
		;
		fav[ Index(((P0 *)this)->me, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 39: /* STATE 4 */
		;
		now.mutex = trpt->bup.oval;
		;
		goto R999;
;
		;
		;
		;
		
	case 42: /* STATE 11 */
		;
		now.waiting[ Index(now.nextWait, 2) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 44: /* STATE 13 */
		;
		now.nextWait = trpt->bup.oval;
		;
		goto R999;

	case 45: /* STATE 14 */
		;
		nwaiting = trpt->bup.oval;
		;
		goto R999;

	case 46: /* STATE 15 */
		;
		now.mutex = trpt->bup.oval;
		;
		goto R999;

	case 47: /* STATE 17 */
		;
		now.cust_wait[ Index(((P0 *)this)->me, 2) ] = trpt->bup.oval;
		;
		goto R999;

	case 48: /* STATE 21 */
		;
		now.mutex = trpt->bup.oval;
		;
		goto R999;

	case 49: /* STATE 23 */
		;
		now.ordering = trpt->bup.oval;
		;
		goto R999;

	case 50: /* STATE 24 */
		;
		nserving = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 52: /* STATE 26 */
		;
		now.cust_wait[ Index(((P0 *)this)->me, 2) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 54: /* STATE 32 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

