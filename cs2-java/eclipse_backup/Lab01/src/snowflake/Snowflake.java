/**
 * 
 *@author Jon O'Brien 
 *
 */

package snowflake;

import java.util.Scanner;

public class Snowflake {
	/**
	 * Snowflake class generates a snowflake using 
	 * recursion and Turtle graphics. 
	 */


	/**
	 * 
	 * @param args (unused here)
	 */

	public static void main(String[] args) {
		/**
		 * The main method.
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.println("Segment Length?: ");
		int length = input.nextInt();
		System.out.println("Depth of recursion?");

		int depth = input.nextInt();
		drawSnowFlake(length, depth);

	}

	public static void drawSnowFlake(int sides, int number)
	/**
	 * Sets up the canvas for drawing the snowflake.
	 */
	{
		Turtle turt = new Turtle(500, 500, 0);
		turt.setCanvasSize(1000, 1000);
		turt.setWorldCoordinates(0,  0, 1000, 1000);
		for (int index = 0; index < 6; index ++)
		{
			snowFlakePart(sides, number, turt);
			turt.turnLeft(60);
		}
	}



	public static void snowFlakePart(int sides, int number, Turtle turt)
	/**
	 * 
	 */
	{
		if (number > 0)
		{
			turt.goForward(sides);
			if (number >1)
			{
				turt.turnLeft(120);
				for (int index = 0; index < 5; index ++)
				{
					snowFlakePart(sides/3, number - 1, turt);
					turt.turnRight(60);
				}
				turt.turnRight(180);
			}
			turt.goForward(-sides);


		}

	}


}