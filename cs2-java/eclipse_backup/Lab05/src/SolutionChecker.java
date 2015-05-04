import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * SolutionChecker.java
 * 
 * Version:
 * $Id: SolutionChecker.java,v 1.5 2014/03/19 03:22:33 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: SolutionChecker.java,v $
 * Revision 1.5  2014/03/19 03:22:33  jvo7822
 * Row and Column in generateNeighbors is broken, but compiles.
 *
 * Revision 1.4  2014/03/18 18:39:41  jvo7822
 * Runs, but incorrect chains/neighbor lists.
 *
 * Revision 1.3  2014/03/18 01:48:13  jvo7822
 * working on generateNeighbors and dfs.
 *
 * Revision 1.2  2014/03/18 00:44:52  jvo7822
 * Need to get the lists of separate colors working and the checks finished.
 *
 * Revision 1.1  2014/03/17 12:25:45  jvo7822
 * Initial commit.
 *
 * 
 * 
 */

/**
 * SolutionChecker.java implements PuzzleVerifier to check the board and find
 * a valid solution for the proposed board setup given by the input.
 * @author Jon O'Brien
 *
 */
public class SolutionChecker implements PuzzleVerifier {
	//private HashMap<Integer, Integer> colorNumbers;
	//HashMap<Integer, Integer> totals2 = new HashMap<Integer, Integer>();
	private ArrayList<ArrayList<NodeZ>> board;
	public int totalCountChain = 0;
	private int boardSize;
	private ArrayList<Integer> colorTotal = new ArrayList<Integer>();
	private ArrayList<NodeZ> visited = new ArrayList<NodeZ>();

	/**
	 * This method checkSolution checks the board for being filled
	 * and for having every piece its' own neighbor and should
	 * iterate through the board checking every position for neighbors
	 * and chains of colors.
	 */
	@Override
	public int checkSolution(int[] values, int nColors) {
		
		//System.out.println("values:" + values + "**");
		int count = 0;
		board = new ArrayList<ArrayList<NodeZ>>();
		boardSize = (int) Math.sqrt(values.length);
		
		//create and populate the 2d-array structure
		for (int row = 0; row < boardSize; row++) {
			board.add( new ArrayList<NodeZ>());//is this supposed to be here?
			for (int col = 0; col < boardSize; col ++) {
				board.get(row).add(new NodeZ(values[count], row, col));//values[col + (row*boardSize)] 
				count++;
			}
		}
		//generate neighbors of nodes, search through connected lists and solution checks.
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				generateNeighbors(board.get(row).get(col));
				/*if (board.get(row).get(col).getColor()==0) {
					continue;
				}
				if (board.get(row).get(col).getNeighbors().isEmpty()) {
					return board.get(row).get(col).getColor();
				}
				else {
					for (NodeZ n: board.get(row).get(col).getNeighbors()) {
						generateNeighbors(n);
					}
				}
			}*/
		}
		}
		//dfs on the board
		for (int color = 1; color < nColors; color++) {//red is 1 at 0, don't forget that
			colorTotal.add(0);
			System.out.println(colorTotal);
			for (int rw = 0; rw < boardSize; rw++) {
				for (int cl = 0; cl < boardSize; cl++) {
					if (board.get(rw).get(cl).getColor() == color) {
						Search(board, board.get(rw).get(cl), color, visited);//, check visited list
					}
				}
			}
		}
		return -1;
	}
private void Search(ArrayList<ArrayList<NodeZ>> board, NodeZ node,int color, List<NodeZ> visited) { 
		
		//for (NodeZ nbr : node.getNeighbors()) {//while neighbors isn't empty 
			//if(!visited.contains(nbr)) { 
				//visited.add(nbr);
				Search(board, node, color, visited);
			}
		//}
	//}
	
/**
 * Makes the neighbors based on a given node and chains the nodes together.
 * @param spot
 */
public void generateNeighbors(NodeZ spot) {
	int row = spot.row;
	int col = spot.col;
	
	if (!(row < 0)) {
		//check top neighbor
		row++;//move to neighbor
		if (spot.row <=boardSize) {//maybe !=
			if (board.get(row).get(col).getColor() == spot.getColor()) {//new spot color = current spot
				spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
				//colorNumbers.put(spot.color, count++);
			 }
		}
		row--;
	}
	if (!(col < 0)) {
		//check left neighbor
		col--;		
		if (!(col < 0)) {
			if (board.get(row).get(col).getColor() == spot.getColor()) {
				spot.addNeighbor(board.get(row).get(col));
				//colorNumbers.put(spot.color, count++);
			}
		}
		col++;
	}
	if (!(row == boardSize)) {
		//check bottom neighbor
		row--;	
			if (!(row <0)) {
				if (board.get(row).get(col).getColor() == spot.getColor()) {
					spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
					//colorNumbers.put(spot.color, count++);
				}
			}
			row++;
	}
	if (!(col == boardSize)) {
		//check right neighbor
		col++;	
		if (!(col == boardSize)) {
			if (board.get(row).get(col).getColor() == spot.getColor()) {
				spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
				//colorNumbers.put(spot.color, count++);
			}
			col--;
		}
	}
}


/**
 * Class representing a node in a graph.
 * 
 * @author atd Aaron T Deever
 *
 */
	class NodeZ {
	private int row;
	private int col;

	/*
	 *  Name associated with this node.
	 */
	private int color;
	
	/*
	 * Neighbors of this node are stored as a list (adjacency list).
	 */
	private List<NodeZ> neighbors;
	
	/**
	 * Constructor.  Initialized with an empty list of neighbors.
	 * 
	 * @param name string representing the name associated with the node.
	 */
	public NodeZ(int color, int row, int col) { 
		this.color = color;
		this.neighbors = new LinkedList<NodeZ>();
	}
	
	/**
	 * Get the String name associated with this object.
	 * 
	 * @return name.
	 */
	public int getColor() { 
		return color;
	}
	
	/**
	 * Add a neighbor to this node.  Checks if already present, and does not
	 * duplicate in this case.
	 * 
	 * @param n: node to add as neighbor.
	 */
	public void addNeighbor(NodeZ n) { 
		if(!neighbors.contains(n)) {
			neighbors.add(n);
		}
	}
	
	/**
	 * Method to return the adjacency list for this node containing all 
	 * of its neighbors.
	 * 
	 * @return the list of neighbors of the given node
	 */
	public List<NodeZ> getNeighbors() { 
		return new LinkedList<NodeZ>(neighbors);
		}
		}
	}
	
