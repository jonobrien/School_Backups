	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* PROC Phil */
;
		;
		
	case 4: /* STATE 2 */
		;
		want_to_eat[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		;
		;
		
	case 7: /* STATE 6 */
		;
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 8: /* STATE 10 */
		;
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 9: /* STATE 15 */
		;
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 10: /* STATE 19 */
		;
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 11: /* STATE 24 */
		;
		want_to_eat[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 12: /* STATE 25 */
		;
		eating[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 14: /* STATE 27 */
		;
		eating[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 15: /* STATE 28 */
		;
		now.fork[ Index(((P0 *)this)->_1_me, 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 16: /* STATE 30 */
		;
		now.fork[ Index(((((P0 *)this)->_1_me+1)%4), 4) ] = trpt->bup.oval;
		;
		goto R999;

	case 17: /* STATE 35 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

