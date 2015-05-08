/*
*	Simple Library
*
*	Starting facts:
*	1. Up to three copies of a book with the same title may exist
*	2. Person may not check out multiple books with the same titles
*	3. Same book may only be loaned out to one person at a time
*
*	Initial State : No books are loaned out.
*
*	Operations:
*
*	A book is checked out by a person - checkout[p : Person, b : Book, st : Step]
*	A book is returned by a person -      return[p : Person, b : Book, st : Step]  
*
*/

open util/ordering[Step]
sig Step{}

sig Book {
	same_title : set Book
}

sig Person{
	on_loan : Book -> Step
}

//up to 3 books can have same title
fact EquivalenceClassOnTitle {
	all b : Book {													
		b in b.same_title
	}
	all b1, b2 : Book {										
		b1 in b2.same_title <=> b2 in b1.same_title
	}
	all b1, b2, b3 : Book {								
		b1 in b2.same_title and b2 in b3.same_title =>
			b1 in b3.same_title
	}
}


//no person can have same book loaned
pred CantHaveMultipleCopiesOfSameTitle[st : Step] {
	all p : Person {
		no disj b1, b2 : p.on_loan.st {
			b1 in b2.same_title
		}
	}
}


//no 2 people can have same book loaned
pred BookLoanedToAtMostOnePerson[st: Step] {
	all disj p1, p2 : Person {
		no p1.on_loan.st & p2.on_loan.st
	}
}




//define invariant






//operation to checkout a book








//operation to check for closure of checked out book









//operation to check for existance of checked out book








//operation to return a book










//operation to check for closure of returned book









//operation to check for existance of returned book
















run {} for 6 but exactly 6 Book, exactly 3 Person, 3 Step
