/**
 * TestSleep.java
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

public class TestSleep
{


    public static void main(String args[])
    {
        
        // If there are no cmd line args, the threads won't sleep
        System.out.println("If there are no cmd line args, letter threads won't sleep");
        int sleep = args.length == 0 ? 0 : Integer.parseInt(args[0]);

        // Create threads
        PrintCharSleep printA = new PrintCharSleep('a', 10, sleep);
        PrintCharSleep printB = new PrintCharSleep('b', 10, sleep);
        PrintNumSleep print100 = new PrintNumSleep(10);

        // Start threads
        printA.start();
        printB.start();
        print100.start();
    }
}

class PrintCharSleep extends Thread
{
    private char charToPrint;    // the character to print
    private int times;        // The times to repeat
    private int sleep;        // amount to sleep

    // Construct a thread with specified character and number
    // of times to print the character
    public PrintCharSleep(char c, int t, int s)
    {
        charToPrint = c;
        times = t;
        sleep = s;
    } // PrintCharSleep

    /**
     * Override the run() method to tell the system what to do
     */
    public void run()
    {
        for (int i=0; i<=times; i++)
        {
            System.out.print(" " + charToPrint);

            // sleep for specified amount of time
            try
            {
                Thread.sleep(sleep);
            }
            catch (InterruptedException ex)
            {
            }
        }
        System.out.println();
    }
}
        
class PrintNumSleep extends Thread
{
	// the last number to print
    private int lastNum;

    /**
     * Construct a thread with the last number
     * @param n last number to print
     */
    public PrintNumSleep(int n)
    {
        lastNum = n;
    }

    /**
     * Override the run() method to tell the system what the thread will do
     */
    public void run()
    {
        for (int i=0; i<=lastNum; i++)
        {
            System.out.print(" " + i);

        }
        System.out.println();
    }
}