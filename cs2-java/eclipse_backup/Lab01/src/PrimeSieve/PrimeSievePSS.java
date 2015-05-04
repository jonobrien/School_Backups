package PrimeSieve;

/**
 * PrimeSievePSS.java
 * $Id: PrimeSievePSS.java,v 1.1 2014/02/03 23:54:26 jvo7822 Exp $
 * Revisions:
 *         $Log: PrimeSievePSS.java,v $
 *         Revision 1.1  2014/02/03 23:54:26  jvo7822
 *         Initial commit to save work thusfar, errors in snowflake.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Compute prime numbers between 2 and N, using the Sieve of 
 * Eratosthenes algorithm.
 * <P>
 * Example 1: 
 * On the second line, the program waits after the colon character 
 * for the user to enter the maximum number, N, and 
 * the user enters 72 as the value for 'N'.
 * <PRE>
 * $ java PrimeSieve
 * Compute prime numbers from 2 to: 55
 * Prime numbers: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53
 * $ 
 * </PRE>
 * <P>
 * Example 2: The user enters 1, an invalid value for 'N', and
 * the program displays the following message instead of
 * running the algorithm:
 * <PRE>
 * $ java PrimeSieve
 * Compute prime numbers from 2 to: 1
 * N must be greater than or equal to 2.
 * </PRE>
 * @author sps Sean Strout
 */
public class PrimeSievePSS {

    /**
     * The main method (put here for problem-solving).
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


    /**
     * Find and return the prime numbers between 2 and N inclusive.
     * 
     * @param N The maximum value (inclusive) to check.
     * @return A list of prime numbers
     */
    public static ArrayList<Integer> findPrimes(int N) {

        // the discovered prime numbers go here
        ArrayList<Integer> primes = new ArrayList<Integer>();

        // These comments are a rough outline of the algorithm.
        // create a candidate list of values 2..N

        // loop through candidate values until none remain.
            // First candidate is always prime -- the current prime.
            // The sieve removes remaining candidates that are
            // not evenly divisible by the current prime.

            // Note: Java generates a Concurrent Modification Exception
            // if you attempt to use a foreach loop that
            // removes elements from the candidate list.





        return primes;
    }   // findPrimes()

}   // PrimeSieve{}
