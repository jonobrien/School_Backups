/**
 * Puzzle.java
 *
 * File:
 *	$Id: Puzzle.java,v 1.2 2013/03/22 23:23:20 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Puzzle.java,v $
 *	Revision 1.2  2013/03/22 23:23:20  njm7461
 *	Fixed JavaDocs
 *
 *	Revision 1.1  2013/03/22 01:46:35  njm7461
 *	Initial Commit
 *
 */

/**
 * the Puzzle Interface
 * It contains the routines necessary for accessing the start and goal configs, as well as generating new neighboring configs
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.ArrayList;

public interface Puzzle
{
	/**
	 * Get the starting config for this puzzle
	 * @return the starting config
	 */
	int getStart();
	
	/**
	 * Get the goal config for this puzzle
	 * @return the goal config
	 */
	int getGoal();

	/**
	 * Returns true if the configuration is a goal
	 * @return configuration is a goal
	 */
	boolean isGoal();
	
	/**
	 * For an incoming config, generate and return all direct neighbors to this config
	 * @param config the incoming config
	 * @return the collection of neighbor configs
	 */
	ArrayList<Puzzle> getNeighbors(Puzzle originalconfig);
}
