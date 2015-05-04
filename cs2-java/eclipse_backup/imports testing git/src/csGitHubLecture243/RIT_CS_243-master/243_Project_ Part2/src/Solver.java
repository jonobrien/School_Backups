/**
 * Solver.java
 *
 * File:
 *	$Id: Solver.java,v 1.5 2013/03/22 23:23:20 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Solver.java,v $
 *	Revision 1.5  2013/03/22 23:23:20  njm7461
 *	Fixed JavaDocs
 *
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
 * Solver Class
 * Takes a Clock object, as a Puzzle interface, and uses it to solve the puzzle using the algorithm described below
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.ArrayList;

public class Solver
{
	
	public Solver()
	{
		
	}
	
	/**
	 * Follows this algorithm to solve the puzzle:
	 * 
	 * create an empty queue as an ArrayList<Integer>
	 *	create an ArrayList<Integer> of one element from the starting config and enqueue it
	 *	set found to whether the starting config is the goal config, or not
	 *	while the queue is not empty and not found:
	 *	    dequeue the front element from the queue and set it to current
	 *	    for each neighbor of the last element in current:
	 *	        create an ArrayList<Integer> for the next config and make it a copy of current
	 *	        append the neighbor to the next config
	 *	        if the next config is the goal:
	 *	            set current to the next config
	 *	            set found to true
	 *	            break out of the for loop
	 *	        else:
	 *	            enqueue the next config
	 *	            
	 *	if found:
	 *	    current is the solution
	 *	else:
	 *	    there is no solution
	 * @param c Puzzle
	 * @return Goal configuration or null
	 */
	public ArrayList<Puzzle> solve(Puzzle c)
	{
		ArrayList<ArrayList <Puzzle>> queue = new ArrayList<ArrayList <Puzzle>>();
		ArrayList<Puzzle> current = new ArrayList<Puzzle>();
		current.add(c);
		queue.add(current);
		boolean found = (c.isGoal());

		while (queue.size() != 0 && !found)
		{
			current = queue.remove(0);
			for (Object neighbor : c.getNeighbors(current.get(current.size()-1)))
			{
				ArrayList<Puzzle> nextConfig = new ArrayList<Puzzle>(current);
				//for (int i : current)
				//	nextConfig.add(i);
				nextConfig.add(neighbor);
				//System.out.println(nextConfig);
				if (nextConfig.get(nextConfig.size()-1) == c.getGoal())
				{
					current = nextConfig;
					found = true;
					break;
				}
				else
				{
					queue.add(nextConfig);
				}
			}
		}
		
		if (found)
		{
			return current;
		}
		else
		{
			return new ArrayList<Puzzle>();
		}
	}

}
