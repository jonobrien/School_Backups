//Jon O'Brien
//Wristbook-static Project 1

sig Person {
	friends : set Person,
	requests : set Person
}

one sig Wristbook {
	accounts : set Person,
}


//If Person a is friends with b, then b is friends with a.
fact FriendsSymmetric {
	friends = ~friends
}


/*
Any Person p who is not in the Wristbook accounts 
(a) has no friends 
(b) has no incoming friend requests
(c) may not be shown as making any friend requests  
*/
fact NoAccount_NoFriendsOrRequests {
	all p : Person | p !in Wristbook.accounts => (no p.friends and no p.requests and p !in Person.requests)
}


//No Person p has incoming friend requests from anyone with whom p is already friends.
fact NoFriendsMakeRequests {
	//all p : Person, r : p.requests | r !in p.friends
	all p : Person | no p.friends & p.requests
}


//No Person p is friends with him or her self.
fact NotFriendsOfSelf {
	all p : Person |  p !in p.friends
}


//No Person p has friend requests with him or her self.
fact NoRequestsOfSelf {
	all p : Person | p !in p.requests
}


// defines the initial setup of the Wristbook system
pred StaticUniverse {
	all p : Person | p in Wristbook.accounts => # p.friends = 2
	some p : Person | p !in Wristbook.accounts
	# Wristbook.accounts > 2
	some Person.requests
	
} run StaticUniverse for 8


