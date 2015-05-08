//Jon O'Brien

// Freinds & Enemies Activity

some sig Person {
	friends : set Person,
	enemies : set Person
}


--------------------------------------- FACTS -----------------------------------------

// The enemies of a person's enemies are friends
// of that person.
fact EnemyOfEnemyIsFriend {
	all p : Person, q : p.enemies {
		q.enemies in p.friends
	}
}

// Everyone is a friend of him or her self.
fact AreOwnFriend {

	all p : Person | (p in p.friends)
}

// Nobody has someone else as both a friend and an enemy.
fact NoFriendsAreEnemies {
all p : Person | no p.friends & p.enemies

}


// A person's friends have that person as their
// friend.
fact FriendsAreSymmetric {
	friends = ~friends
}

// A person's enemies have that person as their
// enemy.
fact EnemiesAreSymmetric {
	all disj p1, p2 : Person|
		p2 in p1.enemies => p1 in p2.enemies
}

--------------------------------------- ASSERTIONS -----------------------------------------

// No person is his or her own enemy.
assert NotOwnEnemy {
		all p : Person |  p ! in p.enemies

}
check NotOwnEnemy for 8


--------------------------------------- PREDICATES -----------------------------------------

// There is exactly one person who is the enemy of
// everyone else.
pred CommonEnemy {
	one p1 : Person{
		all p2 : (Person-p1){
			p1 in p2.enemies
		}
	}	
}
run CommonEnemy for exactly 5 Person

// Some persons have no friends other than themselves.
pred SomeLonelyPersons {
	some p : friends{
		p.friends = p
	}
}
run SomeLonelyPersons for exactly 5 Person

--------------------------------------- RUN -----------------------------------------

run {} for exactly 5 Person






