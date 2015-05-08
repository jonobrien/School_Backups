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

		 /* PROC P */
	case 3: /* STATE 1 - IceCreamRace-Activity-JonO'Brien.pml:44 - [((ice_cream_owner==NO_ONE))] (9:0:2 - 1) */
		IfNotBlocked
		reached[1][1] = 1;
		if (!((now.ice_cream_owner==3)))
			continue;
		/* merge: ice_cream_owner = PETE(9, 2, 9) */
		reached[1][2] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = now.ice_cream_owner;
		now.ice_cream_owner = 1;
#ifdef VAR_RANGES
		logval("ice_cream_owner", now.ice_cream_owner);
#endif
		;
		/* merge: gotit = 1(9, 3, 9) */
		reached[1][3] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P1 *)this)->_3_gotit);
		((P1 *)this)->_3_gotit = 1;
#ifdef VAR_RANGES
		logval("P:gotit", ((int)((P1 *)this)->_3_gotit));
#endif
		;
		/* merge: printf('Pete says \\'I've got it!\\'\\n')(9, 4, 9) */
		reached[1][4] = 1;
		Printf("Pete says \"I've got it!\"\n");
		/* merge: .(goto)(0, 8, 9) */
		reached[1][8] = 1;
		;
		_m = 3; goto P999; /* 4 */
	case 4: /* STATE 9 - IceCreamRace-Activity-JonO'Brien.pml:54 - [assert((!(gotit)||(ice_cream_owner==PETE)))] (0:0:0 - 3) */
		IfNotBlocked
		reached[1][9] = 1;
		spin_assert(( !(((int)((P1 *)this)->_3_gotit))||(now.ice_cream_owner==1)), "( !(gotit)||(ice_cream_owner==1))", II, tt, t);
		_m = 3; goto P999; /* 0 */
	case 5: /* STATE 10 - IceCreamRace-Activity-JonO'Brien.pml:55 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[1][10] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC M */
	case 6: /* STATE 1 - IceCreamRace-Activity-JonO'Brien.pml:25 - [((ice_cream_owner==NO_ONE))] (9:0:2 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		if (!((now.ice_cream_owner==3)))
			continue;
		/* merge: ice_cream_owner = MIKE(9, 2, 9) */
		reached[0][2] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = now.ice_cream_owner;
		now.ice_cream_owner = 2;
#ifdef VAR_RANGES
		logval("ice_cream_owner", now.ice_cream_owner);
#endif
		;
		/* merge: gotit = 1(9, 3, 9) */
		reached[0][3] = 1;
		(trpt+1)->bup.ovals[1] = ((int)((P0 *)this)->_2_gotit);
		((P0 *)this)->_2_gotit = 1;
#ifdef VAR_RANGES
		logval("M:gotit", ((int)((P0 *)this)->_2_gotit));
#endif
		;
		/* merge: printf('Mike says \\'I've got it!\\'\\n')(9, 4, 9) */
		reached[0][4] = 1;
		Printf("Mike says \"I've got it!\"\n");
		/* merge: .(goto)(0, 8, 9) */
		reached[0][8] = 1;
		;
		_m = 3; goto P999; /* 4 */
	case 7: /* STATE 9 - IceCreamRace-Activity-JonO'Brien.pml:35 - [assert((!(gotit)||(ice_cream_owner==MIKE)))] (0:0:0 - 3) */
		IfNotBlocked
		reached[0][9] = 1;
		spin_assert(( !(((int)((P0 *)this)->_2_gotit))||(now.ice_cream_owner==2)), "( !(gotit)||(ice_cream_owner==2))", II, tt, t);
		_m = 3; goto P999; /* 0 */
	case 8: /* STATE 10 - IceCreamRace-Activity-JonO'Brien.pml:36 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][10] = 1;
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

