/**
 * Snowflake.java
 *
 * File:
 *	$Id: Snowflake.java,v 1.1 2013/03/07 05:09:13 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Snowflake.java,v $
 *	Revision 1.1  2013/03/07 05:09:13  njm7461
 *	Added postLabReport.txt and checked all files
 *
 */

/**
 * Draws pictures using a Turtle program package developed at Princeton
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.util.Scanner;
public class Snowflake
{

	/**
	 * The main method gets user inputs and draws the snowflake part by part.
	 * @param args Command line arguments are not used
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Snowflake Drawer\nEnter branch length: ");
		int S = input.nextInt();
		System.out.println("Enter depth of recursion: ");
		int N = input.nextInt();
		Turtle t = init(S);
		for (int i = 0; i < 6; i++)
		{
			snowflake(S,N,t);
			t.turnLeft(60);
		}

	}
	
	/**
	 * Initializes the Turtle graphics
	 * @param S The length of the main snowflake branch
	 * @return A turtle object to draw with
	 */
	public static Turtle init(int S)
	{
		Turtle t = new Turtle (0, 0, 0);
		t.setWorldCoordinates(-500, -500, 500, 500);
		return t;
	}
	
	public static void snowflake(int S, int N, Turtle t)
	{
		if (N > 0)
		{
			t.goForward(S);
			if (N > 1)
			{
				t.turnLeft(120);
				for (int i = 0; i < 5; i++)
				{
					snowflake(S/3,N-1,t);
					t.turnRight(60);
				}
				t.turnRight(180);
			}
			t.goForward(-1*S);
		}
	}
}
