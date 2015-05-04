/**
 * Animal.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * Animal Class
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public abstract class Animal
{

	public void nom(Animal food)
	{
		System.out.println("Om nom, yummy " + food.getClass().getName());
	}
	
	public void foo(int bar)
	{
		System.out.println("bar");
	}

}
