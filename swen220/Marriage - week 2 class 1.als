sig Name{}
abstract sig Person{
	name: one Name
}
sig Male extends Person{}
sig Female extends Person{}
sig Married in Person{
	spouse: one Married
}

fact{ // No two people can have the same name
	all disjoint p1, p2 : Person | no p1.name & p2.name
}

fact{ // if male, must be married to a female & visa versa
	all m : Married | (m in Male => m.spouse in Female) and
							   (m in Female => m.spouse in Male)
}
fact{// can't share spouses
	all disjoint m1, m2 : Married | m1.spouse != m2.spouse
}

fact symmetrical {
	spouse = ~spouse
}

assert cantshare{// can't share spouses
	all disjoint m1, m2 : Married | m1.spouse != m2.spouse
}
check cantshare

run{
#Married = 10

} for 20
