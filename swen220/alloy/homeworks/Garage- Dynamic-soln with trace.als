 //Jon O'Brien
//Garage - Dynamic Activity with Trace bonus
/**********************
 ***
 ***	Change this to an equivalent dynamic
 ***	model, with facts (implicit and explicit) turned into
 ***	Step-dependent predicates.
 ***	Add an Invariant that combines all these predicates
 ***	into one overall claim.
 ***
 ***	Then define each of the predicates below, and attach
 ***	appropriate closure assertions and existence predicates.
 ***
 ***	init[st : Step]
 ***		The initial state has no cars in any space in the garage.
 ***
 ***	park[c : Car, st : Step]
 ***		At step 'st', a new car 'c' enters the garage an parks
 ***		in an empty space. No other car of space changes.
 ***		Get the prerequisites right!
 ***
 ***	exit[c : Car, st : Step]
 ***		A car 'c' currently parked exits the garage at
 ***		step 'st'. No other car or space changes.
 ***
 **********************/
open util/ordering[Step]
sig Step{}

/**
 * Cars that may be parked in the garage.
 */
some sig Car{}

/**
 * The spaces for cars in the garage.
 * A space is occupied by at most one car.
 */
some sig Space{
	parked : Car -> Step  //field of space is occupied by car (dependent on step whether it's parked)
}

/**
 * Any given car is parked in at most one space.
 */

//--------------Invariant---------------//

pred AtMostOneSpacePerCar[st:Step] {
	all c:Car | lone parked.st.c
}

/**
* Any given space holds at most one care
*/
pred AtMostOneCarPerSpace[st: Step] {
    all s: Space | lone s.parked.st
}

pred Invariant[st:Step]{ //Invariants are referenced from the operations
    AtMostOneSpacePerCar[st]
    AtMostOneCarPerSpace[st]
}

//----------------------------------------//


run {all st: Step | Invariant[st] } for 5

//---- init - no cars parked ---//
pred init[st:Step] {
	no parked.st
}

assert init_closed { //check to ensure the closure of the initial state
init[first] => Invariant[first]
}
check init_closed for 6 but 1 Step

pred init_exists { //define the initial states and check to see if they exist
init[first]
Invariant[first]
}
run init_exists for 6 but 1 Step
//-------------------------------------------------//

// - - park - car enters and parks - - - //

pred park[c  :Car, st : Step] {
	//prerequisites, not last step, car not already parked, space available
	st != last
	no parked.st.c
	some s : Space | no s.parked.st

	let st' = next[st] {
		//effects - what happens in the next step, look at the post conditions
		one s : Space {
			no s.parked.st
			s.parked.st' = c
			//frame
			all s1: Space - s {//s1 is every space except the one just parked in
				s1.parked.st' = s1.parked.st
			}
		}		
	}
}

assert park_closed {
	all st:Step - last, c : Car {//look at all steps except the last one, where there is a valid next step
		Invariant[st] && park[c, st] =>
			Invariant[next[st]] // same as st' except no let variable
	}
}
check park_closed for 6 but 2 Step

pred park_exists {
	some st : Step, c : Car {
		Invariant[st]
		park[c, st]
	}
}
run park_exists for 6 but 2 Step

// - - - - exit - a car can leave the space - - - - //

pred exit[c : Car, st : Step] {
	//prerequisites - not last step, car already parked
	st != last
	one parked.st.c
	
	let st' = next[st] {
	//effects
	let s = parked.st.c {
		no s.parked.st'
		//frame	
		all s1 :Space - s | s1.parked.st' = s1.parked.st
		}
	}
}

assert exit_closed {
	all st : Step - last, c : Car {
		Invariant[st] && exit[c, st] =>
			Invariant[next[st]]
	}
}
check exit_closed for 6 but 2 Step

pred exit_exists {
	some st: Step, c : Car {
		Invariant[st]
		exit[c, st]
	}
}
run exit_exists for 6 but 2 Step


// - -- - --  - - TRACE - - ---- - - --  //

pred trace {
	init[first]
	all st : Step - last {
		some c: Car {
			park[c, st] && Invariant[st]
		}
	}
}
run trace for 8 but 5 Step

