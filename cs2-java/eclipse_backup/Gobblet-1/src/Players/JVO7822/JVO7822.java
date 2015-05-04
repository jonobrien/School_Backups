/*
 * JVO7822.java
 * 
 * Version:
 * $Id: JVO7822.java,v 1.6 2014/03/11 20:28:13 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: JVO7822.java,v $
 * Revision 1.6  2014/03/11 20:28:13  jvo7822
 * Everything is not as it seems. Part 1 of Project 2.
 *
 * Revision 1.5  2014/03/11 19:55:33  jvo7822
 * Finished, time for those pesky comments.
 *
 * Revision 1.4  2014/03/11 03:46:30  jvo7822
 * Need to fix indexing in stacks for players.
 *
 * Revision 1.3  2014/03/11 02:08:43  jvo7822
 * Fix nulls and working on LastMove...
 *
 * Revision 1.2  2014/03/10 23:59:27  jvo7822
 * Need to finish LastMove, Init, DumpGameState.
 *
 * Revision 1.1  2014/03/10 15:55:05  jvo7822
 * Initial commit.
 *
 * 
 * 
 */


package Players.JVO7822;

import java.util.ArrayList;
import java.util.Stack;
import Engine.Logger;
import Interface.GobbletPart1;
import Interface.PlayerModule;
import Interface.PlayerMove;
/**
 * The player class for JVO7822 in the Gobblet game.
 * @author Jon O'Brien
 *
 */
public class JVO7822 implements PlayerModule, GobbletPart1 {
	int playerId;
	private Logger log;
	//The board
	private ArrayList<ArrayList<Stack<Pieces>>> board;
	//the 3 stacks outside for the 2 players
	private ArrayList<Stack<Pieces>> Player1Stack;
	private ArrayList<Stack<Pieces>> Player2Stack;


	@Override
	public void dumpGameState() {
		// TODO Auto-generated method stub
		//System.out.println("***board***");
		System.out.println();
		for (int row = 0; row < 4; row++) 
		{
			for (int col = 0; col < 4; col++)
			{
				if (board.get(row).get(col).isEmpty())
				{
					System.out.print("  [] ");
				}
				else
				{
					System.out.print(" ");
					System.out.print(board.get(row).get(col).peek().toString());
				}
			}
				if (row == 0 || row == 2)
				{
					if (row == 0) 
					{
						System.out.print("  ");
						for(Stack<Pieces> stack : Player1Stack)
						{
							if (stack.isEmpty())
							{
								System.out.print(" _");
							}
							else
							{
								System.out.print(" " + stack.peek().getSize());
							}
						}
					}
					else
					{
						System.out.print("  ");
						for(Stack<Pieces> stack : Player2Stack)
						{
							if (stack.isEmpty())
							{
								System.out.print(" _");
							}
							else
							{
								System.out.print(" " + stack.peek().getSize());
							}
						}
					}
				}
				System.out.println();
			}
		}

	
	@Override
	public int getID() {
		return playerId;
	}
	
	
	@Override
	public int getTopOwnerOnBoard(int row, int col) {
		Pieces TopOwner;
		int owner;
		if (board.get(row).get(col).isEmpty()) {
			owner = -1;
		}
		else {
			TopOwner = board.get(row).get(col).peek();
			owner = TopOwner.getPlayerID();
		}
		return owner;
	}

	
	@Override
	public int getTopSizeOnBoard(int row, int col) {
		Pieces topSize;
		int size;
		if (board.get(row).get(col).isEmpty()) {
			size = -1;
		}
		else {
			topSize = board.get(row).get(col).peek();
			size = topSize.getSize();
		}
		return size;
	}
	
	
	public int getTopSizeOnStack(int playerId, int stackNum) 
	{
		Pieces topStack;
		int size = 0;
		stackNum = stackNum - 1;//adjust to get indexing
		if (playerId == 1) 
		{
			if (Player1Stack.get(stackNum).isEmpty()) 
			{
				size = -1;
			}
			else 
			{
				topStack = (Player1Stack.get(stackNum).peek());
				size = topStack.getSize();
			}
		}
		else 
		{ //player 2
			if (Player2Stack.get(stackNum).isEmpty()) 
			{
				size = -1;
			}
			else {
				topStack = Player2Stack.get(stackNum).peek();
				size = topStack.getSize();
			}
		}
		return size;
	}

	
	@Override
	public void init(Logger arg0, int playerId) {
		log = arg0;
		board = new ArrayList<ArrayList<Stack<Pieces>>>();
		Player1Stack = new ArrayList<Stack<Pieces>>();
		Player2Stack = new ArrayList<Stack<Pieces>>();
		for (int row = 0; row < 4; row++) 
		{
			board.add(new ArrayList<Stack<Pieces>>());
			for (int col = 0; col < 4; col++) 
			{
				board.get(row).add(new Stack<Pieces>());
			}
		}
		
		
		
		//3 stacks per player
		for (int index = 0; index < 3; index ++) 
		{//4 pieces in each stack
			Player1Stack.add(new Stack<Pieces>());
				for (int col = 1; col < 5; col ++)
				{//add a piece in each spot of the stack off-board
					Player1Stack.get(index).push(new Pieces(1, col));
				}
			}

		for (int index = 0; index < 3; index ++)
		{
			Player2Stack.add(new Stack<Pieces>());
				for (int col = 1; col < 5; col ++)
				{
					Player2Stack.get(index).push(new Pieces(2, col));
				}
			}
	}
	
	@Override
	public void lastMove(PlayerMove move) {
		// TODO Auto-generated method stub
		
		
	       if (move.getPlayerId() == 1) {
	    	   if (move.getStack() == 0) {//starting on board
	    		   Pieces p = board.get(move.getStartRow()).get(move.getStartCol()).pop();
	               board.get(move.getEndRow()).get(move.getEndCol()).push(p);
	                }
	    	   else {//on the stack off board to on board
	    		   int number = move.getStack();
		    	   number -= 1;
	    		   Pieces p = Player1Stack.get(number).pop();
	               board.get(move.getEndRow()).get(move.getEndCol()).push(p);
	            }

	            }
	       else { // player2
	    	   if (move.getStack() == 0) {
	    		   
	    		   Pieces p = board.get(move.getStartRow()).get(move.getStartCol()).pop();
	               board.get(move.getEndRow()).get(move.getEndCol()).push(p);
	           }
	    	   else {
	    		   int number = move.getStack();
		    	   number -= 1;
	    		   Pieces p = Player2Stack.get(number).pop();
	    		   board.get(move.getEndRow()).get(move.getEndCol()).push(p);
	                }
	            }
	        }

	
	@Override
	public PlayerMove move() {
		throw new UnsupportedOperationException();
		//return null;
	}

	
	@Override
	public void playerInvalidated(int arg0) {
		throw new UnsupportedOperationException();

	}
}
