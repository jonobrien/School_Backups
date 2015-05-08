//Jon O'Brien
//Wristbook-static Solution file converted for R2

/**
	*	Wristbook static model
	*
	* For this model, we are only interested in
	* the management of friends. Applications,
	* photos, authentication, etc. are not
	* addressed.
	*/

/**
 * Signature for a person who may or may not have an account.
 * Those who do have an account may have friends and pending
 * friend requests; for those without accounts, these sets must
 * be empty (and the person cannot have made any friend requests).
 */
sig Person {
	friends :		set Person,		// known friends
	requests :	set Person		// incoming friend requests
}

/**
 * The Wristbook system itself is just the
 * set of persons who have accounts.
 */
one sig Wristbook {
	accounts :	set Person		// the persons with accounts
}

/**
 * Friendship is symmetric - if I'm your friend then you
 * are my friend.
 */
fact FriendsSymmetric {
	friends = ~friends
}

/**
 * Those persons w/o accounts cannot have friends, cannot
 * have pending friendship requests, and cannot have made
 * any friendship requests.
 */
fact NoAccount_NoFriendsOrRequests {
	let no_accts = (Person - Wristbook.accounts) {
		no no_accts.friends
		no no_accts.requests
		no requests.no_accts
	}
}

/**
 * No person can make a frienship request to someone
 * with whom he or she is already a friend.
 */
fact NoFriendsMakeRequests {
	no friends & requests
	// Or, more mundanely
	// all p : Person | no p.friends & p.requests
}

/**
 * No person is a friend of him or her self.
 */
fact NotFriendsOfSelf {
	all p : Person | p -> p ! in friends
	// Or
	// all p : Person | p ! in p.friends
	// Or
	// no friends & iden
}

/**
 * No person can make a friendship request to
 * him or her self.
 */
fact NoRequestsOfSelf {
	all p : Person | p -> p ! in requests
	// Or
	// all p : Person | p ! in p.requests
	// Or
	// no requests & iden
}

/**
 * Show situations where some persons don't have accounts.
 * Some friendship requests are outstanding.
 * Three different persons are each friends with each other.
 */
run {
	some Person - Wristbook.accounts
	some requests
	some disj p1, p2, p3 : Person {
		p1 in p2.friends
		p2 in p3.friends
		p3 in p1.friends
	}
} for 8
