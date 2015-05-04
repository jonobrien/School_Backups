/*
 * PuzzleVerifier.java
 * 
 * Version:
 * $Id: PuzzleVerifier.java,v 1.1 2014/03/17 12:25:44 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: PuzzleVerifier.java,v $
 * Revision 1.1  2014/03/17 12:25:44  jvo7822
 * Initial commit.
 *
 * 
 * 
 */

/**
 * 
 * This interface specifies the method that must be implemented
 * by a puzzle verifying class
 * 
 * @author Zack Butler
 *
 */
public interface PuzzleVerifier {

	/**
	 * Check whether the current puzzle values 
	 * represent a correct solution.
     * 
     * @param values a 1-dimensional representation of the
     * current state of the puzzle.  Contains an 
     * integer for each grid cell, starting at the upper left 
     * and proceeding row by row.  Zero represents an empty 
     * cell, otherwise the value represents
     * the color in the cell.
     * @param nColors The total number of colors in the puzzle.
     * @return -1 if puzzle is correctly solved, otherwise the 
     * number of the first color that is not correctly connected.
	 */
	public int checkSolution(int[] values, int nColors);
	
}
