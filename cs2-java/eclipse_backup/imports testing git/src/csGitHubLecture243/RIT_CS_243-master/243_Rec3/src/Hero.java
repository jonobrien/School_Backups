/**
 * Hero.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Hero Class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Hero
{
	private String name;

	/**
	 * Default Hero constructor with name
	 */
	public Hero (String n)
	{
		name = n;
	}
	

	/**
	 * Override toString method that prints the name of the hero
	 */
	public String toString()
	{
		return name;
	}

}
