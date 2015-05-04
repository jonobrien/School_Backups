/**
 * PairTest.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Uses the PairModified and Hero Classes to test the Generic Swap functions
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class PairTest
{

	/**
	 * Loads two Hero objects into a pair object
	 * Switches them
	 * @param args Command line arguments not used
	 */
	public static void main(String[] args)
	{
		PairModified<Hero> dynamicDuo = new PairModified<Hero>(new Hero("Batman"), new Hero("Robin"));
		System.out.println(dynamicDuo);
		dynamicDuo.swap();
		System.out.println(dynamicDuo);
	}

}
