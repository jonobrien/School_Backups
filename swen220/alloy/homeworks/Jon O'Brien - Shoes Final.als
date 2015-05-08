//Jon O'Brien
//Shoes - Puzzle


abstract sig FName{
lname : one LName,
shoe : one Shoe,
color: one Color
}

one sig Clarisse, Margaret, Nancy, Sally extends FName {}

enum LName { Barlow, Parker, Stevens, West }

enum Shoe { Boots, Flats, Pumps, Sandals }

enum Color { Black, Brown, Green, Pink }

/* These one-to-one mappings only work using the '=' operator since
there is exactly the same number of enum's and Couples	
*/
fact OneToOne {	  
//	all  disjoint fn1, fn2 : FName | fn1.lname!= fn2.lname  
FName.lname = LName // unique names (first, last)
FName.shoe = Shoe       //unique shoe
FName.color = Color	  //shoe has unique color
}

fact facts{
    //1
    Nancy.lname = Barlow
    Nancy.shoe != Boots
    //2
    one f:FName | f.lname = Parker and f.color = Green
    Sally.shoe = Pumps
    //3
    let p = Pumps.~shoe | p.color != Pink
    //Sally.color != Pink
    //4
    one f:FName | f.shoe = Boots and f.color = Brown and f.lname != West
   //5
   Sally.lname != Stevens
   Clarisse.shoe != Flats
   //6
   Margaret.lname != Parker
   Margaret.shoe = Sandals
   Margaret.color != Black
}

run{} for 4
