/**
 * PairModified.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Pair Class Modifed
 * Works with generics <E>
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class PairModified <E>
{
	/**
	 * First item in pair
	 */
	private E first;
	/**
	 * Second item in pair
	 */
	private E second;
	/**
	 * Number of swaps that have occurred
	 */
	private int numSwaps;
	
	
	/**
	 * constructor with two elements
	 * @param f first element
	 * @param s second element
	 */
	public PairModified(E f, E s)
	{
		first = f;
		second = s;
	}
	
	/**
	 * switches the two elements
	 */
	public void swap()
	{
		E temp = first;
		first = second;
		second = temp;
		numSwaps++;
	}
	
	/**
	 * prints first and second element separated by a comma
	 */
	public String toString()
	{
		return first + ", " + second;
	}

}
