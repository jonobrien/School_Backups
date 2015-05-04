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
	private int config;
	
	/**
	 * Constructs a Clock object with total hours, start and goal configurations
	 * @param h clock hours
	 * @param s start config
	 * @param g goal config
	 */
	public Clock(int h, int s, int g)
	{
		hours = h;
		start = s;
		goal = g;
		config = s;
	}

	/**
	 * Constructs a Clock object with default constructor, but with specified configuration
	 * @param h clock hours
	 * @param s start config
	 * @param g goal config
	 * @param c current configuration
	 */
	public Clock(int h, int s, int g, int c)
	{
		this(h, s, g);
		config = c;
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
	 * Returns true if the configuration is a goal
	 * @return configuration is a goal
	 */
	public boolean isGoal()
	{
		return getGoal() == goal;
	}

	/**
	 * Get the current configuration
	 * @return the current config
	 */
	public int getConfig()
	{
		return config;
	}

	/**
	 * For an incoming config, generate and return all direct neighbors to this config
	 * @param config the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<Puzzle> getNeighbors(Puzzle originalconfig)
	{
		Clock c = (Clock)originalconfig; 
		ArrayList<Puzzle> neighbors = new ArrayList<Puzzle>();
		if (c.getConfig() == hours)
		{
			neighbors.add(new Clock(hours, start, goal, 1));
			neighbors.add(new Clock(hours, start, goal, hours - 1));
		}
		else if (c.getConfig() == 1)
		{
			neighbors.add(new Clock(hours, start, goal, 2));
			neighbors.add(new Clock(hours, start, goal, hours));
		}
		else
		{
			neighbors.add(new Clock(hours, start, goal, c.getConfig() - 1));
			neighbors.add(new Clock(hours, start, goal, c.getConfig() + 1));
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
