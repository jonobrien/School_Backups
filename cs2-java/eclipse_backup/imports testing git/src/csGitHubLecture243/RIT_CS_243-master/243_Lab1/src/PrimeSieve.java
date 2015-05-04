/**
 * PrimeSieve.java
 * File:
 *	$Id: PrimeSieve.java,v 1.1 2013/03/06 23:42:33 njm7461 Exp $
 * Revisions:
 *	$Log: PrimeSieve.java,v $
 *	Revision 1.1  2013/03/06 23:42:33  njm7461
 *	Added PrimeSieve class
 *
 */

/**
 * produces prime numbers starting with 2 up to the value of a given number
 * 
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.Scanner;
import java.util.ArrayList;
public class PrimeSieve
{

	/**
	 * The main method
	 * @param args Command line arguments are unused
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Sieve of Eratosthenes Program\nEnter maximum N value: ");
		int maxn = input.nextInt();
		System.out.println("Primes less than or equal to " + maxn + ":\n" + findPrimes(maxn));
		
	}
	/**
	 * Find and return the prime numbers between 2 and N inclusive.
	 * @param N the maximum value (inclusive to check)
	 * @return primelist a list of the prime numbers
	 */
	public static ArrayList<Integer> findPrimes(int N)
	{
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		int p = 2;
		for (int i = 2; i <= N; i++)
		{
			intlist.add(i);
		}
		
		while (intlist.size() > 0)
		{
			p = intlist.get(0);
			primelist.add(p);
			for (int i = 1; i < N; i++)
			{
				intlist.remove(new Integer(p*i));

			}
		}
		return primelist;
	}

}
