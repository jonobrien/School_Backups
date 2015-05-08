
/**********************************************
 *
 *	Support for verifying student dynamic models of Wristbook.
 *
 *	First create a "correct" invariant from the dynamic solution.
 *	This is used in all our checks to avoid spurious counter-examples
 *	arising from incorrect student invariants.
 *
 *	For the init predicate and all the operation predicates:
 *		*	The solution predicate name has V (for verification) preprended.
 *		*	Two assertions are constructed:
 *				SV_xxx says that the student version of xxx implies the
 *				       verification version. Counter examples mean the
 *				       student version is too weak - it allows xxx
 *				       solutions that the verfication excludes.
 *				VS_xxx says that the verification version of xxx implies
 *				       the student version. Counter examples mean the
 *				       student version is too strong - it excludes xxx
 *				       solutions that the verification allows.
 *
 *	If students followed the naming rules, then simply appending this
 *	to the student dynamic solution should permit running the student
 *	existence predicates and closure assertions as well as these
 *	verification assertions.
 *
 *********************************************/




/**
 * Overall state invariant that should hold
 * at each step. This is the solution version
 * with the intermediate predicates replaced
 * by their definition.
 */
pred VInvariant[st : Step] {
	//FriendsSymmetric[st]
	friends.st = ~(friends.st)

	//NoAccount_NoFriendsOrRequests[st]
	let no_accts = (Person - Wristbook.accounts.st) {
		no no_accts.friends.st
		no no_accts.requests.st
		no requests.st.no_accts
	}

	//NoFriendsMakeRequests[st]
	no friends.st & requests.st

	//NotFriendsOfSelf[st]
	all p : Person | p -> p ! in friends.st

	//NoRequestsOfSelf[st]
	all p : Person | p -> p ! in requests.st
}

pred Invariant[st : Step] {
	NoFriendsMakeRequests[st]
	FriendsSymmetric[st]
	NoAccount_NoFriendsOrRequests[st]
	NoRequestsOfSelf[st]
	NotFriendsOfSelf[st]
}

/****
 ****		SOLUTION OPERATIONS
 ***/

/************* INIT ******************/

/**
 *	Initial state - no accounts, no friends, no requests
 */
pred Vinit[st : Step] {
	no accounts.st
	no friends.st
	no requests.st
}

assert SV_init {
	(VInvariant[first] && init[first]) =>
		(VInvariant[first] && Vinit[first])
}
check SV_init for 6 but exactly 1 Step

assert VS_init {
	(VInvariant[first] && Vinit[first]) =>
		(VInvariant[first] && init[first])
}
check VS_init for 6 but exactly 1 Step

/**
 * Added based on experience where students forget to add the .st
 * to the end of relations in init. The following predicate *should*
 * find a solution, but will not if the students don't qualify the
 * claim on accounts, friends, and requests by the step argument.
 */

pred DiffStatesPossible {
  init[first]
	VInvariant[next[first]]
	some accounts.(next[first])
	some friends.(next[first])
	some requests.(next[first])
}
run DiffStatesPossible for 6 but exactly 2 Step


/************* ENROLL ******************/

/**
 *	Enroll a new person into the accounts.
 */
pred Venroll[st : Step, p : Person] {
	/*
	 * Preconditions
	 *		- not last step
	 *		- p does not have an account
	 */
	st != last
	p ! in Wristbook.accounts.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st + p

		/*
		 * Frame
		 */
		friends.st' = friends.st
		requests.st' = requests.st
	}
}

assert SV_enroll {
	all p : Person {
		(VInvariant[first] && enroll[first, p]) =>
			(VInvariant[first] && Venroll[first, p])
	}
}
check SV_enroll for 6 but exactly 2 Step

assert VS_enroll {
	all p : Person {
		(VInvariant[first] &&  Venroll[first, p]) =>
			(VInvariant[first] && enroll[first, p])
	}
}
check VS_enroll for 6 but exactly 2 Step



/************* WITHDRAW ******************/

/**
 *	Withdraw a person's account from Wristbook.
 */
pred Vwithdraw[st : Step, p : Person] {
	/*
	 * Preconditions
	 *		- not last step
	 *		- p has an account
	 */
	st != last
	p in Wristbook.accounts.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st - p
		no p.friends.st'
		no p.requests.st'

		/*
		 * Frame
		 */
		all p1 : Person - p {
			p1.friends.st' = p1.friends.st - p
			p1.requests.st' = p1.requests.st - p
		}
	}
}

assert SV_withdraw {
	all p : Person {
		(VInvariant[first] && withdraw[first, p]) =>
			(VInvariant[first] && Vwithdraw[first, p])
	}
}
check SV_withdraw for 6 but exactly 2 Step

assert VS_withdraw {
	all p : Person {
		(VInvariant[first] &&  Vwithdraw[first, p]) =>
			(VInvariant[first] && withdraw[first, p])
	}
}
check VS_withdraw for 6 but exactly 2 Step


/************* REQUEST ******************/

/**
 *	Request friendship.
 */
pred Vrequest[st : Step, from_p, to_p : Person] {
	/*
	 * Preconditions
	 *		- not last step
	 *		- the persons are different
	 *		- both persons have accounts
	 *		- from_p is not already a friend of to_p and
	 *		  from_p does not have a request in to to_p
	 */
	st != last
	from_p != to_p
	(from_p + to_p) in Wristbook.accounts.st
	from_p ! in to_p.(friends + requests).st

	let st' = next[st] {
		/*
		 * Effects
		 */
		requests.st' = requests.st + (to_p -> from_p)

		/*
		 * Frame
		 */
		friends.st' = friends.st
		accounts.st' = accounts.st
	}
}

assert SV_request {
	all p, q : Person {
		(VInvariant[first] && request[first, p, q]) =>
			(VInvariant[first] && Vrequest[first, p, q])
	}
}
check SV_request for 6 but exactly 2 Step

assert VS_request {
	all p, q : Person {
		(VInvariant[first] &&  Vrequest[first, p, q]) =>
			(VInvariant[first] && request[first, p, q])
	}
}
check VS_request for 6 but exactly 2 Step


/************* ACCEPT ******************/

/**
 *	Accept a friendship request.
 */
pred Vaccept[st : Step, from_p, to_p : Person] {
	/*
	 * Preconditions
	 *	- not last step
	 *	- from_p has a request to_p
	 */
	st != last
	from_p in to_p.requests.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		requests.st' = requests.st - (to_p -> from_p + from_p -> to_p)
		friends.st' = friends.st + (to_p -> from_p + from_p -> to_p)

		/*
		 * Frame
		 */
		accounts.st' = accounts.st
	}
}


assert SV_accept {
	all p, q : Person {
		(VInvariant[first] && accept[first, p, q]) =>
			(VInvariant[first] && Vaccept[first, p, q])
	}
}
check SV_accept for 6 but exactly 2 Step

assert VS_accept {
	all p, q : Person {
		(VInvariant[first] &&  Vaccept[first, p, q]) =>
			(VInvariant[first] && accept[first, p, q])
	}
}
check VS_accept for 6 but exactly 2 Step



/************* DENY ******************/

/**
 *	Deny a friendship request.
 */
pred Vdeny[st : Step, from_p, to_p : Person] {
	/*
	 * Preconditions
	 *		- not the last step
	 *		- from_p has a request in to to_p
	 *		- to_p does not have a request in to from_p
	 */
	st != last
	from_p in to_p.requests.st
	to_p ! in from_p.requests.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		requests.st' = requests.st - (to_p -> from_p)

		/*
		 * Frame
		 */
		accounts.st' = accounts.st
		friends.st' = friends.st
	}
}

assert SV_deny {
	all p, q : Person {
		(VInvariant[first] && deny[first, p, q]) =>
			(VInvariant[first] && Vdeny[first, p, q])
	}
}
check SV_deny for 6 but exactly 2 Step

assert VS_deny {
	all p, q : Person {
		(VInvariant[first] &&  Vdeny[first, p, q]) =>
			(VInvariant[first] && deny[first, p, q])
	}
}
check VS_deny for 6 but exactly 2 Step



/************* DE-FRIEND ******************/

/**
 *	De-friend a current friend
 */
pred Vde_friend[st : Step, p, unf_p : Person] {
	/*
	 * Preconditions
	 *		- not last step
	 *		- unf_p is a friend of p (and vice-vera, of course)
	 */
	st != last
	unf_p in p.friends.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		friends.st' = friends.st - (p -> unf_p + unf_p -> p)

		/*
		 * Frame
		 */
		accounts.st' = accounts.st
		requests.st' = requests.st
	}
}

assert SV_de_friend {
	all p, q : Person {
		(VInvariant[first] && de_friend[first, p, q]) =>
			(VInvariant[first] && Vde_friend[first, p, q])
	}
}
check SV_de_friend for 6 but exactly 2 Step

assert VS_de_friend {
	all p, q : Person {
		(VInvariant[first] &&  Vde_friend[first, p, q]) =>
			(VInvariant[first] && de_friend[first, p, q])
	}
}
check VS_de_friend for 6 but exactly 2 Step
