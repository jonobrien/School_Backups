//Jon O'Brien
//Wristbook Dynamic Project - taken from static solution

/**
	*	Wristbook Dynamic model
	*
	* For this model, we are only interested in
	* the management of friends. Applications,
	* photos, authentication, etc. are not
	* addressed.
	*/


/**
 * The ordered Step set for sequencing states.
 */
open util/ordering[Step]
sig Step{}


/**
 * Signature for a person who may or may not have an account.
 * Those who do have an account may have friends and pending
 * friend requests; for those without accounts, these sets must
 * be empty (and the person cannot have made any friend requests).
 */
some sig Person {
	friends : Person -> Step,	// known friends
	requests :Person -> Step	// incoming friend requests
}

/**
 * The Wristbook system itself is just the
 * set of persons who have accounts.
 */
one sig Wristbook {
	accounts :	Person -> Step,	// the persons with accounts
}

/** DYNAMIC
 * Friendship is symmetric - if I'm your friend then you
 * are my friend.
 */
pred FriendsSymmetric[st : Step] {
	friends.st = ~(friends.st)
}

/**DYNAMIC
 * Those persons w/o accounts cannot have friends, cannot
 * have pending friendship requests, and cannot have made
 * any friendship requests.
 */
pred NoAccount_NoFriendsOrRequests[st : Step] {
	let no_accts = (Person - Wristbook.accounts.st) {
		no no_accts.friends.st
		no no_accts.requests.st
		no requests.st.no_accts
	}
}

/**DYNAMIC
 * No person can make a frienship request to someone
 * with whom he or she is already a friend.
 */
pred NoFriendsMakeRequests[st : Step] {
	no friends.st & requests.st
	// Or, more mundanely
	// all p : Person | no p.friends & p.requests
}

/**DYNAMIC
 * No person is a friend of him or her self.
 */
pred NotFriendsOfSelf[st : Step] {
	all p : Person | p -> p ! in friends.st
	// Or
	// all p : Person | p ! in p.friends
	// Or
	// no friends & iden
}

/**DYNAMIC
 * No person can make a friendship request to
 * him or her self.
 */
pred NoRequestsOfSelf[st : Step] {
	all p : Person | p -> p ! in requests.st
	// Or
	// all p : Person | p ! in p.requests
	// Or
	// no requests & iden
}


// - - - -  - - -  - - - - - - - -  COMMENTED OUT RUN - - - - - - - - - - - - -  //
/**
 * Show situations where some persons don't have accounts.
 * Some friendship requests are outstanding.
 * Three different persons are each friends with each other.
 *
run {
	some Person - Wristbook.accounts
	some requests
	some disj p1, p2, p3 : Person {
		p1 in p2.friends
		p2 in p3.friends
		p3 in p1.friends
	}
} for 8 */
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //


/** 
 * INVARIANT
 * The invariant is defined for the dynamic model
 */
pred Invariant[st : Step] {
	NoFriendsMakeRequests[st]
	FriendsSymmetric[st]
	NoAccount_NoFriendsOrRequests[st]
	NoRequestsOfSelf[st]
	NotFriendsOfSelf[st]
}

/**
 * INITIAL STATE
 * In the initial state no one has any accounts, friends, or requests
 */
pred init[st : Step] {
	no Wristbook.accounts.st
	no requests.st
	no friends.st
}

assert init_closed {
	init[first] => Invariant[first]
}
check init_closed for 6 but exactly 1 Step

pred init_exists {
	Invariant[first]
	init[first]
}
run init_exists for 6 but exactly 1 Step


/** - - - - - - DYNAMIC OPERATIONS - - - - - - - - - - - - - - - - - - - - - - */


/************* ENROLL ******************/
/**
 *	Enroll a new person into the accounts.
 */
pred enroll[st : Step, p : Person] {
	/* Preconditions
	 *	- not last step
	 *	- p does not have an account */
	st != last
	p ! in Wristbook.accounts.st

	let st' = next[st] {
		/* Effects */
		Wristbook.accounts.st' = Wristbook.accounts.st + p
		/* Frame */
		friends.st' = friends.st
		requests.st' = requests.st
	}
}


/************* WITHDRAW ******************/
/**
 *	Withdraw a person's account from Wristbook.
 */
pred withdraw[st : Step, p : Person] {
	/* Preconditions
	 *	- not last step
	 *	- p has an account */
	st != last
	p in Wristbook.accounts.st

	let st' = next[st] {
		/* Effects */
		Wristbook.accounts.st' = Wristbook.accounts.st - p
		no p.friends.st'
		no p.requests.st'
		/* Frame */
		all p1 : Person - p {
			p1.friends.st' = p1.friends.st - p
			p1.requests.st' = p1.requests.st - p
		}
	}
}


/************* REQUEST ******************/
/**
 *	Request friendship.
 */
pred request[st : Step, from_p, to_p : Person] {
	/* Preconditions
	 *	- not last step
	 *	- the persons are different
	 *	- both persons have accounts
	 *	- from_p is not already a friend of to_p and
	 *	     from_p does not have a request in to to_p */
	st != last
	from_p != to_p
	(from_p + to_p) in Wristbook.accounts.st
	from_p ! in to_p.(friends + requests).st

	let st' = next[st] {
		/* Effects */
		requests.st' = requests.st + (to_p -> from_p)
		/* Frame */
		friends.st' = friends.st
		accounts.st' = accounts.st
	}
}


/************* ACCEPT ******************/
/**
 *	Accept a friendship request.
 */
pred accept[st : Step, from_p, to_p : Person] {
	/* Preconditions
	 *	- not last step
	 *	- from_p has a request to_p */
	st != last
	from_p in to_p.requests.st

	let st' = next[st] {
		/* Effects */
		requests.st' = requests.st - (to_p -> from_p + from_p -> to_p)
		friends.st' = friends.st + (to_p -> from_p + from_p -> to_p)
		/* Frame */
		accounts.st' = accounts.st
	}
}


/************* DENY ******************/
/**
 *	Deny a friendship request.
 */
pred deny[st : Step, from_p, to_p : Person] {
	/* Preconditions
	 *	- not the last step
	 *	- from_p has a request in to to_p
	 *	- to_p does not have a request in from_p  */
	st != last
	from_p in to_p.requests.st
	to_p ! in from_p.requests.st

	let st' = next[st] {
		/* Effects */
		requests.st' = requests.st - (to_p -> from_p)
		/* Frame */
		accounts.st' = accounts.st
		friends.st' = friends.st
	}
}


/************* DE-FRIEND ******************/
/**
 *	De-friend a current friend
 */
pred de_friend[st : Step, p, unf_p : Person] {
	/*  Preconditions
	 *	- not last step
	 *	- unf_p is a friend of p (and vice-vera, of course)   */
	st != last
	unf_p in p.friends.st

	let st' = next[st] {
		/* Effects  */
		friends.st' = friends.st - (p -> unf_p + unf_p -> p)
		/* Frame  */
		accounts.st' = accounts.st
		requests.st' = requests.st
	}
}



/** * * * * * * * *TESTS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/***************************************************************************************/

/** - - - - - - enroll - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert enroll_closed {
	all p : Person {
		Invariant[first] && enroll[first,p] =>
			Invariant[next[first]]
	}
}
check enroll_closed for 6 but exactly 2 Step

pred enroll_exists {
	Invariant[first]
	some p: Person| enroll[first,p]
}
run enroll_exists for 6 but exactly 2 Step

/** - - - - - - withdraw - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert withdraw_closed {
	all p : Person {
		Invariant[first] && withdraw[first, p] =>
			Invariant[next[first]]
	}
}
check withdraw_closed for 6 but exactly 2 Step

pred withdraw_exists {
	Invariant[first]
	some p : Person| withdraw[first,p]
}
run withdraw_exists for 6 but exactly 2 Step

/** - - - - - - request - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert request_closed {
	all from_p, to_p : Person {
		Invariant[first] && accept[first, from_p, to_p] =>
			Invariant[next[first]]
	}
}
check request_closed for 6 but exactly 2 Step

pred request_exists {
	Invariant[first]
	some from_p, to_p: Person| request[first, from_p, to_p]
}
run request_exists for 6 but exactly 2 Step

/** - - - - - - accept - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert accept_closed {
	all from_p, to_p : Person {
		Invariant[first] && accept[first, from_p, to_p] =>
			Invariant[next[first]]
	}
}
check accept_closed for 6 but exactly 2 Step

pred accept_exists {
	Invariant[first]
	some from_p, to_p: Person| accept[first, from_p, to_p]
}
run accept_exists for 6 but exactly 2 Step

/** - - - - - - deny - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert deny_closed {
	all from_p, to_p : Person {
		Invariant[first] && deny[first, from_p, to_p] =>
			Invariant[next[first]]
	}
}
check deny_closed for 6 but exactly 2 Step

pred deny_exists {
	Invariant[first]
	some from_p, to_p: Person| deny[first, from_p, to_p]
}
run deny_exists for 6 but exactly 2 Step

/** - - - - - - de-friend - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
assert de_friend_closed {
	all p, unf_p : Person {
		Invariant[first] && de_friend[first, p, unf_p] =>
			Invariant[next[first]]
	}
}
check de_friend_closed for 6 but exactly 2 Step

pred de_friend_exists {
	Invariant[first]
	some p, unf_p: Person| de_friend[first, p, unf_p]
}
run de_friend_exists for 6 but exactly 2 Step

/*********************************************************************************************/
/** * * * * * * * *END TESTS * * ** * * * * * * * * * * *  * * * * * * * * * * * * * * * * * * * * * */






