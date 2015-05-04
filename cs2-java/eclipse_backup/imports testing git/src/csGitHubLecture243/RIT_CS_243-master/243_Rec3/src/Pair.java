/**
 * Pair.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Pair class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Pair
{
	private int first;
	private int second;
	private int numSwaps;
	
	public Pair (int f, int s)
	{
		first = f;
		second = s;
	}
	
	public void swap()
	{
		int temp = first;
		first = second;
		second = temp;
		numSwaps++;
	}

}
