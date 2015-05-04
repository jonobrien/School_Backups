/**
 * Arena.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * 
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.util.ArrayList;

public class Arena
{

	/**
	 * @param args Command line arguments unused
	 */
	public static void main(String[] args)
	{
		TRex stan = new TRex();
		Animal polymorphic_stan = new TRex();
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new TRex());
		animals.add(new Kitten());
		
		for (Animal a : animals)
		{
			stan.nom(a);
			polymorphic_stan.nom(a);
		}
		
		stan.dieInIceAge();
		stan.foo(1);
		//Animal a = new Animal(); //Cannot instantiate with type Animal

	}

}
