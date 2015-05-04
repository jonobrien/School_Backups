package PrimeSieve;

/**
 * PrimeSieve.java


 * 
 * Version:
 *		$Id: PrimeSieve.java,v 1.4 2014/02/04 20:08:51 jvo7822 Exp $
 *
 * Revisions:
 * 		$Log: PrimeSieve.java,v $
 * 		Revision 1.4  2014/02/04 20:08:51  jvo7822
 * 		Done with everything.
 *
 * 		Revision 1.3  2014/02/04 19:48:12  jvo7822
 * 		Finished and commented PizzaRun, PrimeSieve, Snowflake.
 *
 * 		Revision 1.2  2014/02/04 00:55:39  jvo7822
 * 		Finished PrimeSieve.java and Snowflake.java, all should be working.
 *
 * 		Revision 1.1  2014/02/03 23:54:25  jvo7822
 * 		Initial commit to save work thusfar, errors in snowflake.
 *
 */

import java.util.ArrayList;

import java.util.Scanner;

/**
 * A class that computes prime numbers between 2 and N, using the Sieve of 
 * Eratosthenes algorithm.
 * <P>
 * Example 1: 
 * On the second line, the program waits after the colon character 
 * for the user to enter the maximum number, N, and 
 * the user enters 72 as the value for 'N'.
 * <PRE>
 * $ java PrimeSieve
 * Compute prime numbers from 2 to: 72
 * Prime numbers: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71
 * $ 
 * </PRE>
 * <P>
 * Example 2: The user enters 1, an invalid value for 'N', and
 * the program displays the following message instead of running the algorithm:
 * <PRE>
 * $ java PrimeSieve
 * Compute prime numbers from 2 to: 1
 * N must be greater than or equal to 2.
 * </PRE>
 *  
 * @author sps Sean Strout
 * @author Jon O'Brien - findPrimes
 */
public class PrimeSieve {

    /**
     * Find and return the prime numbers between 2 and N inclusive.
     * 
     * @param N The maximum value (inclusive) to check.
     * @return A list of prime numbers
     */
    public static ArrayList<Integer> findPrimes(int N) {
        // the discovered prime numbers go here
        ArrayList<Integer> primes = new ArrayList<Integer>();

        // create a candidate list of values 2..N
        ArrayList<Integer> nums = new ArrayList<Integer>(N - 2);
        for (int i = 2; i < N; i ++)
        {
        	nums.add(i);
        }
        for (int i = 0; i < nums.size(); i ++)
        {
        	if (nums.get(i) > 0 && i < nums.size() - 1)
        	{
        		for (int newNum = i + 1; newNum < nums.size(); newNum ++)
        		{
        			if (nums.get(newNum) > 0 && nums.get(newNum) % nums.get(i)==0)
        			{
        				nums.set(newNum,  -1);
        				
        			}
        		}
        			
        	}
        }
        for (int i = 0; i < nums.size(); i ++)
        {
        	int tempNums = nums.get(i);
        	if (tempNums > 0)
        	{
        		primes.add(tempNums);
        		
        	}
        }

        return primes;
    }   // findPrimes()
    
    

    /**
     * The main method.
     * 
     * @param args The command line arguments (unused)
     */
    public static void main(String[] args) {
		
        // read input value, N
        System.out.print("Compute prime numbers from 2 to: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
		
        if (N < 2) {
            System.out.println("N must be greater than or equal to 2.");
        } else {
            ArrayList<Integer> primes = findPrimes(N);

            // display output
            System.out.print("Prime numbers: ");
            for (Integer i : primes) {
                System.out.print(i + " ");
            }
        }
    }   // main()
}   // PrimeSieve{}
