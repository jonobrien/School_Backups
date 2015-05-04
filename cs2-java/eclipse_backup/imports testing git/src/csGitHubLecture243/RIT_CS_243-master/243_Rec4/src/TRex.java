/**
 * TRex.java
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

public class TRex extends Animal
{
	public void dieInIceAge()
	{
		System.out.println("Died.");
	}
	
	public void nom(Animal food)
	{
		System.out.println("TRex: ");
		super.nom(food);
	}
	
	public void foo(int b)
	{
		System.out.println("b");
	}

}
