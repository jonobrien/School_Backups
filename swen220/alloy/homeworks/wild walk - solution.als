abstract sig Couple {
	husband	:  MaleName,		// reminder: default multiplicity is ONE
	wife	:  FemaleName,
	surname	:  SurName,
	animal	:  Animal,
	bird	:  Bird
}
enum SurName { Connor, Carver, Jones, Porter, White }
enum MaleName{ Paul, Peter, Jim, Tom, Mike }
enum FemaleName { Joanna, Marjorie, Olivia, Patricia, Sandra }
enum Animal { Beaver, Rabbit, Coyote, Woodchuck, Fox }
enum Bird { Eagle, Goose, Pheasant, Swan, WildTurkey }

fact One_to_One_Mappings {
	/* These one-to-one mappings only work using the '=' operator since
		there is exactly the same number of enum's and Couples	
	*/
	Couple.husband = MaleName
	Couple.wife = FemaleName
	Couple.surname = SurName
	Couple.animal = Animal
	Couple.bird = Bird

}

/* Fact #1 - Tom, who wasnâ€™t married to Olivia, saw a fox. 
                   The couple that saw the beaver also saw wild turkeys
 */
fact F1 {
	husband.Tom.wife != Olivia				// Tom not married to Oliva
	husband.Tom.animal = Fox				// Tom saw a fox
	animal.Beaver = bird.WildTurkey		// Couple that saw a Beaver is the same couple that saw a WildTurkey

	/* Using a 'let' 
	let h_name = husband.Tom {
		h_name.wife != Olivia
		h_name.animal = Fox
		}
	animal.Beaver = bird.WildTurkey
	*/
}

/* Fact #2 - Patricia Carver didnâ€™t see the pheasant. Paul didnâ€™t see the eagle. 
				   The Jonesâ€™s saw a coyote. Jimâ€™s last name wasnâ€™t White
*/
fact F2 {
	wife.Patricia.surname = Carver		// GIVEN: Patrica's surname is Carver
	wife.Patricia.bird != Pheasant			// Patricia didn't see the Pheasant
	husband.Paul.bird != Eagle				// Paul didn't see the Eagle
	surname.Jones.animal = Coyote		// Couple whose surname is Jones saw a coyote
	husband.Jim.surname != White		// Jim's last name isn't White
}

/* Fact #3 - The Porters didnâ€™t see the swans. Tom wasnâ€™t married to Sandra and his last name wasnâ€™t Jones. 
                    The Connors spotted a rabbit
*/
fact F3 {
	surname.Porter != bird.Swan		  
	husband.Tom.wife != Sandra
	husband.Tom.surname != Jones
	surname.Connor.animal = Rabbit
}

/* Fact #4 - The couple who saw the coyote didnâ€™t see the swan. 
                   Mike, whose last name wasnâ€™t Connor, didnâ€™t see the woodchuck. Sandra saw the goose
*/
fact F4 {
	animal.Coyote != bird.Swan
	husband.Mike.surname != Connor
	husband.Mike.animal != Woodchuck
	wife.Sandra.bird = Goose
}

/* Fact #5 - Peter and his wife Joanna didnâ€™t see the wild turkeys. 
				    Jim, whose last name wasnâ€™t Jones, saw the pheasant but not the woodchuck.  
*/
fact F5 {
	husband.Peter.wife = Joanna
	husband.Peter.bird != WildTurkey
	husband.Jim.surname != Jones
	husband.Jim.bird = Pheasant
	husband.Jim.animal != Woodchuck
}

/* Fact #6 - Marjorie White didnâ€™t see the swans. Paul Porter didnâ€™t see the beaver
*/
fact F6 {
	wife.Marjorie.surname = White
	wife.Marjorie.bird != Swan
	husband.Paul.surname = Porter
	husband.Paul.animal != Beaver
}

run { } for 5 		
