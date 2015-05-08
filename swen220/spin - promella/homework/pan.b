	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* PROC P */

	case 3: /* STATE 3 */
		;
		((P1 *)this)->_3_gotit = trpt->bup.ovals[1];
		now.ice_cream_owner = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 5: /* STATE 10 */
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC M */

	case 6: /* STATE 3 */
		;
		((P0 *)this)->_2_gotit = trpt->bup.ovals[1];
		now.ice_cream_owner = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 8: /* STATE 10 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

