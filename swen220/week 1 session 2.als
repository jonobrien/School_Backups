/*
 * Basic signatures.
 *
 * A signature defines a set of elements or atoms
 *   - An atom has no internal structure at all
 *   - The only property an atom has is identity (we can
 *     whether or not two atoms are equal or different).
 *   - An atom belongs to the set defined by its signature.
 *
 * Top level signatures partition the universal set (univ)
 *   - univ is the union of all such signatures.
 *   - the top level signatures are pair-wise disjoint.
 *     (i.e., no atom is a member of more than one top-level
 *     signature).
 */
 
sig Person{}
/*
 * Course is a signature with fields (relations to atoms in
 * other signatures).
 *   - set - a group of zero or more atoms, no order, no dups.
 *   - a unique atom
 *   - some - a set of one or more atoms (not empty).
 *   - one - exactly one atom
 */
sig Course {
	taughtby  : one Person,
	enrolled	: set Person
}

/*
 * Facts define the "axioms" of our system - rules that must
 * hold for any possible configuration of signatures and
 * fields.
 */

/* Fact #1
*  Teaches can't enroll in courses that they teach.
*/
fact CantTeachAndTake{   
	all c : Course | c.taughtby ! in c.enrolled
}
/* read as: "For every atom(c) in course, the set of atoms in the taughtby relation cannot be
 *				    a member of (subset of) the set of atoms in the enrolled relation"
*/
  

/*
 * Run lets us see all possible configuration up to a given
 * maximum size for each signature in our model.
 *   - The boolean / logical statement in braces further
 *     constrains the possible solutions.
 *   - An empty constrain is true - that is, any
 *     solution consistent with the facts is ok.
 */
pred LimitCourses{   // predicate referenced in run stmt below 
  #Course <=2
}
run LimitCourses   // execute the LimitCourses predicate

run{} 				     // default:  <= 3 of each signature

run{ } for 5 but 7 Person



