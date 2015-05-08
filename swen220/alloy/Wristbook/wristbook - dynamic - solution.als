/**
 * The ordered Step set for sequencing states.
 */
open util/ordering[Step]
sig Step{}

some sig Person {
	friends : Person -> Step,
	requests : Person -> Step
}

one sig Wristbook {
	accounts : Person -> Step
}
//If Person a is friends with b, then b is friends with a.
pred FriendsSymmetric[st : Step]{
	all disj p1, p2 : Person|p2 in p1.friends.st => p1 in p2.friends.st
}

//Any Person p who is not in the Wristbook accounts
// (a) has no friends, 
//(b) has no incoming friend requests, and 
//(c) may not be shown as making any friend requests.
pred NoAccount_NoFriendsOrRequests[st : Step] {
	all p1 : Person |p1 not in Wristbook.accounts.st =>	p1 not in Wristbook.accounts.st
	all p1 : Person |p1 not in Wristbook.accounts.st => no (p1.friends.st + p1.requests.st)		
}

//No Person p has incoming friend requests from anyone with whom p is already friends.
pred NoFriendsMakeRequests[st : Step] {
	all disj p1, p2 : Person |p2 not in (p1.requests.st & p1.friends.st)
}


//No Person p is friends with him or her self.
pred NotFriendsOfSelf[st : Step] {
	all p1 : Person|p1 not in p1.friends.st
}

//No Person p has friend requests with him or her self.
pred NoRequestsOfSelf[st : Step] {
	all p1 : Person|p1 not in p1.requests.st
}

pred Invariant[st : Step] {
	NoFriendsMakeRequests[st]
	FriendsSymmetric[st]
	NoAccount_NoFriendsOrRequests[st]
	NoRequestsOfSelf[st]
	NotFriendsOfSelf[st]
}
//Some Persons do not have Wristbook accounts.
//There are some requests.
//There are at least three distinct Persons each of whom is friends with the other two.
/*run{
	all st : Step | Invariant[st]
    Person not in Wristbook.accounts
	some requests
	some p1, p2, p3 : Person | p1 in (p2.friends + p3.friends) and p2 in (p1.friends + p3.friends) and p3 in (p2.friends + p1.friends)
	
	} for 8

*/
/********************* INITIAL STATE ******************/

/**
 * In the initial state no one is enrolled in any courses.
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

/*******************Enroll*****************************/
pred enroll[st : Step, p : Person]{
	/*
	 * Preconditions
	 */
	st != last
	p not in Wristbook.accounts.st
		/*
		 * Effects
		 */
	let st' = next[st] {
		Wristbook.accounts.st' = Wristbook.accounts.st + p
		/*
		 * Frame
		 */
		friends.st' = friends.st &&
		requests.st' = requests.st
	}
}
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

/**************** WITHDRAW ******************/

pred withdraw[st : Step, p : Person]{
	/*
	 * Preconditions
	 */
	st != last
	p in Wristbook.accounts.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st - p
		Person.requests.st' = Person.requests.st - p
		Person.friends.st' = Person.friends.st - p
		p.friends.st' = p.friends.st - p.friends.st
		p.requests.st' = p.requests.st - p.requests.st
		/*
		 * Frame
		 */
		friends.st' = friends.st 
		requests.st' = requests.st
	}
}

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

/***************Request************************/

pred request[st : Step, from_p, to_p : Person]{
	/*
	 * Preconditions
	 */
	st != last
	from_p in Wristbook.accounts.st
	to_p in Wristbook.accounts.st
	to_p not in from_p.friends.st
	from_p not in to_p.friends.st
	from_p not in to_p.requests.st
	from_p != to_p

	let st' = next[st] {
		/*
		 * Effects
		 */
		to_p.requests.st' = to_p.requests.st + from_p

		/*
		 * Frame
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st
		friends.st' = friends.st
		all p : Person - to_p |p.requests.st' = p.requests.st
	}	
}
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

/*******************Accept*****************************/

pred accept[st : Step, from_p, to_p : Person]{
	/*
	 * Preconditions
	 */
	st != last
	from_p in Wristbook.accounts.st
    to_p in Wristbook.accounts.st
	from_p in to_p.requests.st
	from_p not in to_p.friends.st
	to_p not in from_p.friends.st
	from_p != to_p	

	let st' = next[st] {
		/*
		 * Effects
		 */
		to_p.requests.st' = to_p.requests.st - from_p
		to_p.friends.st' = to_p.friends.st + from_p
		from_p.requests.st' = from_p.requests.st - to_p
		from_p.friends.st' = from_p.friends.st + to_p
		/*
		 * Frame
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st
		all p: Person -( from_p + to_p) | p.requests.st' = p.requests.st &&
		p.friends.st' = p.friends.st
	}
}

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

/*******************Deny*****************************/

pred deny[st : Step, from_p, to_p : Person]{
	/*
	 * Preconditions
	 */
	st != last
	from_p in Wristbook.accounts.st
    to_p in Wristbook.accounts.st
	from_p in to_p.requests.st
	to_p not in from_p.friends.st
	from_p not in to_p.friends.st
	to_p not in from_p.requests.st
	from_p != to_p	

	let st' = next[st] {
		/*
		 * Effects
		 */
		to_p.requests.st' = to_p.requests.st - from_p
		/*
		 * Frame
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st
		friends.st' = friends.st
		all p : Person - to_p |
			p.requests.st' = p.requests.st
	}
}

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


/*****************DeFriend**************************/

pred de_friend[st : Step, p, unf_p : Person] {
	/*
	 * Preconditions
	 */
	p in Wristbook.accounts.st
	unf_p in  Wristbook.accounts.st
	p in unf_p.friends.st
	unf_p in p.friends.st
	p not in unf_p.requests.st
	unf_p not in p.requests.st

	let st' = next[st]{
		/*
		 * Effects
		 */
		p.friends.st' = p.friends.st - unf_p
		unf_p.friends.st' = unf_p.friends.st - p
		/*
		 * Frame
		 */
		Wristbook.accounts.st' = Wristbook.accounts.st
		requests.st' = requests.st
		all p : Person - (p+unf_p) |p.friends.st' = p.friends.st
	}
}


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

