sig Name {}
abstract sig Person {
	name : Name
}

sig Male extends Person {}
sig Female extends Person {}

sig Married in Person {
	spouse : one Married
}

fact {
all p : Married | (p in Male => p.spouse in Female) and ( p in Female =>
p.spouse in Male)
}

fact  NoCommonName {
//	all p2,p3 : Person | (p2 != p3) => no p2.name & p3.name // i would think eqal names, but you want to use set operators in alloy 
	all disjoint p2,p3 : Person | no p2.name & p3.name



}

run {}
