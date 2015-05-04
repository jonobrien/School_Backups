/**
 * TestThread Class
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
public class TestThread
{

	/**
	 * Main method
	 * Creates threads and runs them
	 * @param args not used
	 */
	public static void main(String args[])
	{
		// Create threads
		PrintChar printA = new PrintChar('a', 50);
		PrintChar printB = new PrintChar('b', 50);
		PrintNum print100 = new PrintNum(50);

		// Start threads
		printA.start();
		printB.start();
		print100.start();
	}
}

class PrintChar extends Thread
{
	// The character to print
	private char charToPrint;
	// The times to repeat
	private int times;

	/**
	 * Constructs a print character thread
	 * @param c character to print
	 * @param t number of times to repeat
	 */
	public PrintChar(char c, int t)
	{
		charToPrint = c;
		times = t;
	}

	/**
	 * Print the character
	 */
	public void run()
	{
		for (int i=0; i<=times; i++) {
			System.out.print(" " + charToPrint);
		}
	}
}

class PrintNum extends Thread
{
	// Last number to print
	private int lastNum;

	/**
	 * Construct a thread to print numbers
	 * @param n last number to print
	 */
	public PrintNum(int n)
	{
		lastNum = n;
	}

	/**
	 * Printthe characters 
	 */
	public void run()
	{
		for (int i=0; i<=lastNum; i++)
		{
			System.out.print(" " + i);
		}
	}
}