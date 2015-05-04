import java.util.ArrayList;

/**
 * Clock.java
 *
 * File:
 *	$Id: Clock.java,v 1.4 2013/03/22 23:20:33 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Clock.java,v $
 *	Revision 1.4  2013/03/22 23:20:33  njm7461
 *	Checked for CL argument length
 *
 *	Revision 1.3  2013/03/22 02:37:52  njm7461
 *	Fixed neighbor generator
 *
 *	Revision 1.2  2013/03/22 02:19:09  njm7461
 *	Updated Solver solve function
 *
 *	Revision 1.1  2013/03/22 01:46:35  njm7461
 *	Initial Commit
 *
 */

/**
 * Clock class and main
 * Representation of a clock
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Clock implements Puzzle
{
	private int hours;
	private int start;
	private int goal;
		
	public Clock(int h, int s, int g)
	{
		hours = h;
		start = s;
		goal = g;
	}

	/**
	 * Get the starting config for this puzzle
	 * @return the starting config
	 */
	public int getStart()
	{
		return start;
	}

	/**
	 * Get the goal config for this puzzle
	 * @return the goal config
	 */
	public int getGoal()
	{
		return goal;
	}

	/**
	 * For an incoming config, generate and return all direct neighbors to this config
	 * @param config the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<Integer> getNeighbors(int config)
	{
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		if (config == hours)
		{
			neighbors.add(1);
			neighbors.add(hours - 1);
		}
		else if (config == 1)
		{
			neighbors.add(2);
			neighbors.add(hours);
		}
		else
		{
			neighbors.add(config - 1);
			neighbors.add(config + 1);
		}
		
		return neighbors;
	}

	/**
	 * @param args {hours:  number of hours, an integer N} {start: start time, an integer from 1..N} {goal: goal time, an integer from 1..N}
	 */
	public static void main(String[] args)
	{
		if (args.length != 3)
		{
			System.out.println("Usage: java Clock hours start goal");
			System.exit(0);
		}
		Clock c = new Clock(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		Solver s = new Solver();
		ArrayList<Integer> solution = s.solve(c);

		for (int i = 0; i < solution.size(); i++)
		{
			System.out.println("Step " + i + ": " + solution.get(i));
		}
		
		if (solution == null)
		{
			System.out.println("No Solution Found");
		}

	}

}
