import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * SolutionChecker.java
 * 
 * Version:
 * $Id: SolutionChecker.java,v 1.4 2014/03/18 18:39:41 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: SolutionChecker.java,v $
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
	private HashMap<Integer, Integer> colorNumbers;//is this right?

	private ArrayList<ArrayList<Node>> board;
	public int totalCountChain = 0;
	private int boardSize;
	private ArrayList<Node> visited = new ArrayList<Node>();
	private ArrayList<Integer> colorTotals;
	//HashMap<Integer, Integer> totals2 = new HashMap<Integer, Integer>();

	/**
	 * This method checkSolution checks the board
	 */
	@Override
	public int checkSolution(int[] values, int nColors) {
		colorNumbers = new HashMap<Integer, Integer>();
		//colorTotals = new ArrayList<Integer>(nColors);
		System.out.println("values:" + values + "**");
		board = new ArrayList<ArrayList<Node>>();
		boardSize = (int) Math.sqrt(values.length);
		//System.out.println( boardSize);
		/*for (int color = 0; color < nColors+1; color++) {
			colorTotals.add(0);
		}
		System.out.println("colorTotals" + colorTotals);*/
		
		for (int i = 1; i <nColors; i++) {
			colorNumbers.put(i, 0);//initialize the hashmap and add zeros
		}
		
		//create and populate the 2d-array structure
		int count = 0;
		for (int row = 0; row < boardSize; row++) {
			board.add( new ArrayList<Node>());
			System.out.println(board);
			for (int col = 0; col < boardSize; col ++) {
				board.get(row).add(new Node(values[count], row, col));//values[col + (row*boardSize)]
			count++;
			}
		}
		//dfs through each node spot on the board
		for (ArrayList<Node> spot : board) {
            for (Node n : spot) {
            	if (n.getNeighbors().isEmpty()) {
            		return n.getColor();
            	}
                n.generateNeighbors(n);
                visitDFS(n, visited);
            }
        }
		return -1;
		//check for empty spots on the board
		
		/*for (int i = 0; i < (values.length); i++) {
			System.out.println("in empty checking");
            if (values[i] == 0) {
                return values[i - 1];
            }
            else {
            	return values[i];
            }
        }*/
	}

private void visitDFS(Node node, List<Node> visited) { 
		
		for (Node nbr : node.getNeighbors()) { 
			if(!visited.contains(nbr)) { 
				visited.add(nbr);
				visitDFS(nbr, visited);
			}
		}
	}


/**
 * Class representing a node in a graph.
 * 
 * @author atd Aaron T Deever
 *
 */
	class Node {
	private int row;
	private int col;

	/*
	 *  Name associated with this node.
	 */
	private int color;
	
	/*
	 * Neighbors of this node are stored as a list (adjacency list).
	 */
	private List<Node> neighbors;
	
	/**
	 * Constructor.  Initialized with an empty list of neighbors.
	 * 
	 * @param name string representing the name associated with the node.
	 */
	public Node(int color, int row, int col) { 
		this.color = color;
		this.neighbors = new LinkedList<Node>();
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
	public void addNeighbor(Node n) { 
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
	public List<Node> getNeighbors() { 
		return new LinkedList<Node>(neighbors);
		}
	
	public List<Node> generateNeighbors(Node spot) {
		System.out.println("in generate neighbors");
		int count = colorNumbers.get(spot.color);
		if (!(row < 0)) {
			//check top neighbor
			row++;//move to neighbor
			System.out.println("row top neighbor check after incrementing" + " " + row + " " + col);
			if (row <=boardSize) {//maybe !=
				if (board.get(row).get(col).getColor() == spot.getColor()) {//new spot color = current spot
					spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
					colorNumbers.put(spot.color, count++);
					
				 }
			}
			row--;
		}
		
		
		if (!(col < 0)) {
			//check left neighbor
			col--;
			
			System.out.println("col left neighbor check after incrementing" + " " + row + " " + col);
			
			if (!(col < 0)) {
				
				if (board.get(row).get(col).getColor() == spot.getColor()) {
					spot.addNeighbor(board.get(row).get(col));
					colorNumbers.put(spot.color, count++);
				}
			}
			col++;
		}
		
		if (!(row == boardSize)) {
			//check bottom neighbor
			row--;	
			System.out.println("row bottom neighbor check after incrementing" + " " + row + " " + col);
				if (!(row <0)) {
					if (board.get(row).get(col).getColor() == spot.getColor()) {
						spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
						colorNumbers.put(spot.color, count++);
					}
				}
				row++;
		}
		
		if (!(col == boardSize)) {
			//check right neighbor
			col++;	
			System.out.println("col right neighbor check after incrementing" + " " + row + " " + col);

			if (!(col == boardSize)) {
			
				if (board.get(row).get(col).getColor() == spot.getColor()) {
					spot.addNeighbor(board.get(row).get(col));//add currentNode to visited list
					colorNumbers.put(spot.color, count++);
					
				}
				col--;
			}
		}
		return neighbors;//list of connected neighbors by color
	}	
	}
	
}