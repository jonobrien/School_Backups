/**
 * 
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class TestYield
{

	// main method
	public static void main(String args[])
	{
		
		// If there are cmd line args, the threads won't yield
		boolean yield = args.length > 0 ? false : true;

		// Create threads
		PrintCharYield printA = new PrintCharYield('a', 10, yield);
		PrintCharYield printB = new PrintCharYield('b', 10, yield);
		PrintNumYield print100 = new PrintNumYield(10, yield);

		// Start threads
		printA.start();
		printB.start();
		print100.start();
	}
}

class PrintCharYield extends Thread
{
	private char charToPrint;	// the character to print
	private int times;		// The times to repeat
	private boolean yield;		// Do I yield?

	// Construct a thread with specified character and number
	// of times to print the character
	public PrintCharYield(char c, int t, boolean y)
	{
		charToPrint = c;
		times = t;
		yield = y;
	}

	// Override the run() method to tell the system
	// what the thread will do
	public void run()
	{
		for (int i=0; i<=times; i++)
		{
			System.out.print(" " + charToPrint);

			// Let other threads run if told to
			if (yield)
			{
				Thread.yield();
			}
		}
	}
}
		
class PrintNumYield extends Thread
{
	private int lastNum;		// the last number to print
	private boolean yield;		// Do I yield?

	// Construct a thread with the last number
	public PrintNumYield(int n, boolean y)
	{
		lastNum = n;
		yield = y;
	}

	// Override the run() method to tell the system
	// what the thread will do
	public void run()
	{
		for (int i=0; i<=lastNum; i++)
		{
			System.out.print(" " + i);

			// Let other threads run if told to
			if (yield)
			{
				Thread.yield();
			}
		}
	}
}