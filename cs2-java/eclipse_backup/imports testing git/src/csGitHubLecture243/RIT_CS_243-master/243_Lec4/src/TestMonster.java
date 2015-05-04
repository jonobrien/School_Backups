import java.util.ArrayList;

/**
 * TestMonster.java
 *
 * File:
 *	$Id: TestMonster.java,v 1.1 2013/03/25 19:13:11 njm7461 Exp $
 *
 * Revisions:
 *	$Log: TestMonster.java,v $
 *	Revision 1.1  2013/03/25 19:13:11  njm7461
 *	Added equals method
 *
 */

/**
 * TestMonster.java Class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class TestMonster
{
	/**
	 * Main class
	 * @param args command line arguments are not used
	 */
	public static void main(String [] args)
	{
		//Monster m = new Monster("Marvin", 35);
		Phoenix p = new Phoenix("Firebird", 40);
		Flyer f = new Phoenix("Lightning", 50);

		System.out.println(p instanceof Monster);
		System.out.println(p instanceof Phoenix);
		System.out.println(p instanceof Flyer);

		//m.takeDamage(10);
		// m.regen(); //Not defined for Monster
		//System.out.println(m);

		p.fly(5);
		p.regen();
		p.takeDamage(50);

		System.out.println(p); // overrides the Monster toString() method

		//Monster m2 = new Monster("Marvin", 25);
		//System.out.println("m2 equals m" + m2.equals(m));
		String str = "Marvin";
		//System.out.println("m equals str" + m.equals(str)); // This causes failure because of a cast error, so we fix the method so it checks for type

		System.out.println();
		System.out.println();
		System.out.println();
		
		ArrayList<Monster> mlist = new ArrayList<Monster>();
		//mlist.add(new Monster("Cliff", 25));
		mlist.add(new Phoenix("Faux", 45));

		for (Monster k : mlist)
		{
			k.crossWater(); // Calls the overridden one for a Phoenix, calls the regular for a Monster (polymorphism)
		}

		// Phoenix ee = new Monster("Joe", 20); // Can't make the child equal to parent type
		// Phoenix ee = new Lochness("Joe", 20); // Can't make the child equal to another child type

		
	}

}
