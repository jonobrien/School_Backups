import java.util.ArrayList;

/**
 * Water class and main
 * Representation of a Water
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Water implements Puzzle
{
	private int[] jugCapacity;
	private int[] jugs;
	private int goal;
		
	public Water(int g, int[] j)
	{
		goal = g;
		jugCapacity = j;
	}

	/**
	 * Get the starting config for this puzzle
	 * @return the starting config
	 */
	public int[] getStart()
	{
		return new int[jugCapacity.length];
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
	 * One of three possible outcomes:
	 * - Fill a single jug up to complete capacity by submerging it in the lake
	 * - Empty a single jug by dumping all water in the jug into the lake
	 * - Pour the contents of any one jug into another jug, without exceeding the capacity of the jug being poured into
	 * @param config the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<Integer> getNeighbors(int[] config)
	{
		ArrayList<Integer> neighbors = new ArrayList<Integer>();

		// For each of the jugs in the config
		for (int i = 0; i < config.length; i++)
		{
			//Add if that index was full
			int[] fullconfig = new int[config.length];
			System.arraycopy(config, 0, fullconfig, 0, config.length);
			fullconfig[i] = jugCapacity[i];
			neighbors.add(fullconfig);

			//Add if that index was empty
			int[] emptyconfig = new int[config.length]; 
			System.arraycopy(config, 0, emptyconfig, config.length);
			fullconfig[i] = 0;
			neighbors.add(fullconfig);
		}

		//For each of the jugs in the config
		for (int i = 0; i < config.length; i++)
		{
			for (int j = 0; j < config.length; j++)
			{


			}
		}
		return neighbors;
	}

	/**
	 * @param args {amount} {jug1} [{jug2} ...]
	 */
	public static void main(String[] args)
	{
		if (args.length != 3)
		{
			System.out.println("Usage: java Water {amount} {jug1} [{jug2} ...]");
			System.exit(0);
		}
		Water c = new Water(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
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
