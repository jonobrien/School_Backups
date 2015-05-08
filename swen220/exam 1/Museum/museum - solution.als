//Jon O'Brien
//Museum Exam 1

/**
 * The pictures in a museum.
 */
some sig Picture{}

/**
 * Clients of the museum, in general, have some pictures loaned
 * to them and have desires for other pictures.
 */
some sig Client {
	loaned :	set Picture,
	desires	:	set Picture
}

/**
 * The museum has some pictures on display that can be loaned and
 * others in the permanent collection that must remain in the museum.
 *
 * Note: The Pictures on loan are exactly those all the Clients as
 *				a group have been "loaned".
 */
one sig Museum {
	permanent	: set Picture,
	onDisplay	: set Picture
}

/**
 *	All pictures are either on display OR loaned out.
 */
pred F1_All_pictures_onDisplay_or_on_loan {
	Museum.onDisplay + Client.loaned = Picture // union of sets for ensuring all pictures
																		   // are loaned or displayed
}

/**
 *	All pictures in the permanent collection are always on display
 *	(they cannot be loaned to clients).
 *	Pictures on display other than the permanent collection are
 *	eligible for loaning to clients.
 */
pred F2_All_pictures_permanent_are_onDisplay {
	all p : Museum.permanent | p in Museum.onDisplay  //if a picture is permanent, it is always on display
}

/**
 *	A picture cannot be both on display and loaned out.
 */
pred F3_No_picture_onDisplay_and_loaned {
	no Museum.onDisplay & Client.loaned // pictures can't be both loaned and displayed
}

/**
 *	No client can desire to borrow pictures that are
 *	in the permanent collection.
 */
pred F4_Client_cannot_desire_permanent_pictures {
	all c : Client | no c.desires & Museum.permanent // client cannot desire a permanent picture
}	

/**
 *	A client cannot desire a picture he or she has been loaned.
 */
pred F5_Cannot_desire_what_you_are_loaned {
	all c : Client | no c.desires & c.loaned // client can't desire the same picture he is loaned
}

/**
 *	All pictures some client desires are on loan.
 *	Note that a client *MAY* have been loaned a picture
 *	that no other client desires.
 */
pred F6_All_desired_pictures_are_loaned {
	all c : Client | no c.desires & Museum.onDisplay // if it's desired, it cannot be on display
}

/**
 *	Two different clients cannot be loaned the same picture.
 */
pred F7_No_loan_conflicts {
	all c1, c2 : Client | (c1 != c2) => 
		(no c1.loaned & c2.loaned) // take 2 unique clients and their intersection of loaned is empty
																									
}

/**
 *	This run predicate is designed to show
 *	"interesting" states.
 */
run{
	some permanent
	some onDisplay - permanent
	some desires
	some loaned
	some Client.loaned - Client.desires
	some Client.loaned & Client.desires
	some loaned.Picture & desires.Picture
} for exactly 3 Client, exactly 8 Picture

///*** Instructor Predicates & Assertions ***///

pred Soln_F1_All_pictures_onDisplay_or_on_loan {
  Picture = Museum.onDisplay + Client.loaned
}
assert Equiv_F1_All_pictures_onDisplay_or_on_loan {
  Soln_F1_All_pictures_onDisplay_or_on_loan <=> F1_All_pictures_onDisplay_or_on_loan
}
check Equiv_F1_All_pictures_onDisplay_or_on_loan for 8

pred Soln_F2_All_pictures_permanent_are_onDisplay {
  Museum.permanent in Museum.onDisplay
}
assert Equiv_F2_All_pictures_permanent_are_onDisplay {
  Soln_F2_All_pictures_permanent_are_onDisplay <=> F2_All_pictures_permanent_are_onDisplay
}
check Equiv_F2_All_pictures_permanent_are_onDisplay for 8

pred Soln_F3_No_picture_onDisplay_and_loaned {
  no Museum.onDisplay & Client.loaned
}
assert Equiv_F3_No_picture_onDisplay_and_loaned {
  Soln_F3_No_picture_onDisplay_and_loaned <=> F3_No_picture_onDisplay_and_loaned
}
check Equiv_F3_No_picture_onDisplay_and_loaned for 8

pred Soln_F4_Client_cannot_desire_permanent_pictures {
  no Client.desires & Museum.permanent
}
assert Equiv_F4_Client_cannot_desire_permanent_pictures {
  Soln_F4_Client_cannot_desire_permanent_pictures <=> F4_Client_cannot_desire_permanent_pictures
}
check Equiv_F4_Client_cannot_desire_permanent_pictures for 8

pred Soln_F5_Cannot_desire_what_you_are_loaned {
  no c : Client {
    some c.loaned & c.desires
  }
}
assert Equiv_F5_Cannot_desire_what_you_are_loaned {
  Soln_F5_Cannot_desire_what_you_are_loaned <=> F5_Cannot_desire_what_you_are_loaned
}
check Equiv_F5_Cannot_desire_what_you_are_loaned for 8

pred Soln_F6_All_desired_pictures_are_loaned {
  Client.desires in Client.loaned
}
assert Equiv_F6_All_desired_pictures_are_loaned {
  Soln_F6_All_desired_pictures_are_loaned <=> F6_All_desired_pictures_are_loaned
}
check Equiv_F6_All_desired_pictures_are_loaned for 8

pred Soln_F7_No_loan_conflicts {
  no disj c1, c2 : Client | some c1.loaned & c2.loaned
}
assert Equiv_F7_No_loan_conflicts {
  Soln_F7_No_loan_conflicts <=> F7_No_loan_conflicts
}
check Equiv_F7_No_loan_conflicts for 8
