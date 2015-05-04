/*
 * JVO7822.java
 * 
 * Version:
 * $Id:
 * 
 * Revisions:
 * $Log:
 *
 */

package Players.JVO7822;

import java.util.ArrayList;
import java.util.Stack;
import Engine.Logger;
import Interface.Coordinate;
import Interface.GobbletPart1;
import Interface.PlayerModule;
import Interface.PlayerMove;
import Players.JVO7822.Piece;


/**
 * The player module for my Gobblet Part 3a, individual code except for the parts 
 * that we wrote for part 2/previous parts.
 * 
 * @author Jon_2
 *
 */
public class JVO7822 implements PlayerModule, GobbletPart1 {

	private ArrayList<ArrayList<Stack<Piece>>> board;
	private ArrayList<Stack<Piece>> player1Stacks = new ArrayList<Stack<Piece>>();
	private ArrayList<Stack<Piece>> player2Stacks = new ArrayList<Stack<Piece>>();
	private int playerId;
	private int playerTurn = 1;
	/* (non-Javadoc)
	 * @see Interface.GobbletPart1#dumpGameState()
	 */
	@Override
	public void dumpGameState() {

		for( int row = 0; row < board.size(); row++ ){
			for( int col = 0; col < board.get(row).size() ; col++){
				if ( board.get(row).get(col).isEmpty() ){
					System.out.print(board.get(row).get(col) + "   ");
				}
				else{
					System.out.print(
							board.get(row).get(col).peek().toString() + " ");
				}
			}
			if( row == 0 || row == 2){
				System.out.print(printStacks( row ));
			}
			System.out.println();
		}	
	}
	/**
	 * This method uses the row currently being printed to print the stacks of
	 * the players in a manner that is formatted well.
	 * @param row the row number currently being printed by dumpGameState.
	 * @return a string representing the stacks.
	 */
	private String printStacks( int row ){
		String stackTops = "  ";
		if( row == 0 ){
			for (int i = 0; i < 3; i++){
				if( !player1Stacks.get(i).isEmpty()){
					stackTops += String.valueOf(
							player1Stacks.get(i).peek().getSize()) + " ";
				}
				else{
					stackTops += "_ ";
				}
			}
		}
		else if ( row == 2 ){
			for(int i = 0; i < 3; i++){
				if( !player2Stacks.get(i).isEmpty()){
					stackTops += String.valueOf(
							player2Stacks.get(i).peek().getSize()) + " ";
				}
				else{
					stackTops += "_ ";
				}
			}
		}
		return stackTops;
	}
	/* (non-Javadoc)
	 * @see Interface.GobbletPart1#getID()
	 */
	@Override
	public int getID() {
		return this.playerId;
	}

	/* (non-Javadoc)
	 * @see Interface.GobbletPart1#getTopOwnerOnBoard(int, int)
	 */
	@Override
	public int getTopOwnerOnBoard(int row, int col) {
		if( !board.get(row).get(col).isEmpty() ){
			return board.get(row).get(col).peek().getPlayer();
		}
		else{
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see Interface.GobbletPart1#getTopSizeOnBoard(int, int)
	 */
	@Override
	public int getTopSizeOnBoard(int row, int col) {
		if( !board.get(row).get(col).isEmpty() ){
			return board.get(row).get(col).peek().getSize();
		}
		else{
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see Interface.GobbletPart1#getTopSizeOnStack(int, int)
	 */
	@Override
	public int getTopSizeOnStack(int playerID, int stackNum) {
		if( playerID == 1){
			if ( !player1Stacks.get(stackNum-1).isEmpty() ){
				return player1Stacks.get(stackNum-1).peek().getSize();
			}
			else{
				return -1;
			}
		}
		else if( playerID == 2){
			if ( !player2Stacks.get(stackNum-1).isEmpty() ){
				return player2Stacks.get(stackNum-1).peek().getSize();
			}
			else{
				return -1;
			}
		}
		else{
			System.err.println("Incorrect player value");
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see Interface.PlayerModule#init(Engine.Logger, int)
	 */
	@Override
	public void init(Logger logger, int playerId) {
		this.playerId = playerId;
		board = new ArrayList<ArrayList<Stack<Piece>>>();
		for( int i = 0; i < 4; i++){
			ArrayList<Stack<Piece>> inner = new ArrayList<Stack<Piece>>();
			for ( int x = 0; x < 4; x++){
				Stack<Piece> spot = new Stack<Piece>();
				inner.add(spot);
			}
			board.add(inner);
		}
		for( int i = 0;i < 3; i++){
			Stack<Piece> stack = new Stack<Piece>();
			for( int x = 0; x < 4; x++ ){
				Piece piece = new Piece( 1, x+1 );
				stack.push(piece);
			}
			player1Stacks.add(stack);

		}
		for( int i = 0;i < 3; i++){
			Stack<Piece> stack = new Stack<Piece>();
			for( int x = 0; x < 4; x++ ){
				Piece piece = new Piece( 2, x+1 );
				stack.push(piece);
			}
			player2Stacks.add(stack);

		}
	}
	/**
	 * a boolean to iterathe through the ArrayList of stacks
	 * and check each individual stack being empty. 
	 * 
	 * used to determine if player should pick from board or not, fixes
	 * error when stacks are empty and player tries to move from stacks to board.
	 * 
	 * @param PlayerId - the id of the current player for stacks
	 * @return - true if all stacks empty, false if any of them are empty
	 */
	public boolean checkStacksEmpty(int PlayerId) {//TODO
		if (playerId == 1) {
			for ( int i=0; i< 3; i++) {
				if (!player1Stacks.get(i).isEmpty()) {
					return false;
				}
			}
			return true;//true iff all 3 empty
		}
		else {
			for ( int i=0; i< 3; i++) {
				if (!player2Stacks.get(i).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see Interface.PlayerModule#lastMove(Interface.PlayerMove)
	 */
	@Override
	public void lastMove(PlayerMove move) {
		int startRow = move.getStartRow();
		int startCol = move.getStartCol();
		int endRow = move.getEndRow();
		int endCol = move.getEndCol();
		Piece piece = new Piece(0,0);
		if( startRow == -1 && startCol == -1){
			if( move.getPlayerId() == 1 ){
				if( !player1Stacks.get(move.getStack()-1).isEmpty() ){
					piece = player1Stacks.get(move.getStack()-1).pop();
				}
				else{
					System.err.print("Empty Stack");
				}
			}
			else if( move.getPlayerId() == 2 ){
				if( !player2Stacks.get(move.getStack()-1).isEmpty() ){
					piece = player2Stacks.get(move.getStack()-1).pop();
				}
				else{
					System.err.print("Empty Stack");
				}
			}
		}
		else{
			if ( !board.get(startRow).get(startCol).isEmpty() ){
				if( board.get(startRow).get(startCol).peek().getSize() 
						== move.getSize() ){
					if( board.get(startRow).get(startCol).peek().getPlayer() 
							== move.getPlayerId() ){
						piece = board.get(startRow).get(startCol).pop();
					}
				}
			}
			else{
				System.err.print("Empty board space.");
			}
		}
		if( !board.get(endRow).get(endCol).isEmpty() ){
			if ( board.get(endRow).get(endCol).peek().getSize() < piece.getSize() ){
				board.get(endRow).get(endCol).push(piece);
			}
			else{ 
				System.err.print("Invalid end position");
			}
		}
		else{
			board.get(endRow).get(endCol).push(piece);
		}
		if( this.playerTurn == 1 ){
			this.playerTurn = 2;
		}
		else{ this.playerTurn = 1;}

	}

	/* (non-Javadoc)
	 * @see Interface.PlayerModule#move()
	 */
	/* (non-Javadoc)
	 * @see Interface.PlayerModule#move()
	 * This method makes moves pre-strategy. It preforms very basic moves is designed
	 * to make sure it follows all of the rules. It generates a piece to move
	 * based on the state of the stacks if empty it moves a piece from the board
	 * otherwise it takes the biggest piece from all the stacks.
	 * It gets its start position based on the piece.
	 * Its end position is the first empty spot or the smallest piece your
	 * partner has on the board.
	 */
	@Override
	public PlayerMove move() {
		//TODO 
		//check if board is full, move piece from board to gobble up opponent piece of smaller size in a threatening position
		//make threatening position function for use in move()
		//make iteration function to check if board is full
		//
		boolean chooseFromStack = true;
		int stackNum = 0;
		int pieceSize = 0;
		int startRow = 0;
		int startCol = 0;
		int endRow = -1;
		int endCol = -1;
		
		do {
		if(this.playerId == 1){
			if(chooseFromStack == true && !checkStacksEmpty(playerId)){//
				startRow = -1;   //stacks aren't empty and 
				startCol = -1;
				for(int i = 0; i < player1Stacks.size(); i++ ){//iterates through the stacks
					if(!player1Stacks.get(i).isEmpty()){
						if(player1Stacks.get(i).peek().getSize() > pieceSize ){
							pieceSize = player1Stacks.get(i).peek().getSize();
							stackNum = i+1;
						}
					}
				}
			}
			else{//stacks are empty and the player has to move pieces from the board
				for(int row = 0; row < board.size(); row++){
					for(int col = 0; col < board.get(row).size(); col++){
						if (!board.get(row).get(col).isEmpty()) {
							if(board.get(row).get(col).peek().getPlayer() == playerId){ //board location is not empty, and piece at location is owned by player 1 and is a 4
								if( board.get(row).get(col).peek().getSize() == 4){
									startRow = row;
									startCol = col;
									pieceSize = board.get(row).get(col).peek().getSize();
								}
							}
						}
					}
				}
			}
		}
		if(this.playerId == 2) {//same thing for player 2
			if (!checkStacksEmpty(playerId) && chooseFromStack == true) {
				startRow = -1;
				startCol = -1;
				for(int i = 0; i < player2Stacks.size(); i++ ){
					if(!player2Stacks.get(i).isEmpty()){
						if(player2Stacks.get(i).peek().getSize() > pieceSize ){
							pieceSize = player2Stacks.get(i).peek().getSize();
							stackNum = i+1;
						}
					}
				}
			}
			else {//player 2 stacks are empty
				for(int row = 0; row < board.size(); row++){
					for(int col = 0; col < board.get(row).size(); col++){
						if (!board.get(row).get(col).isEmpty()) {
							if(	board.get(row).get(col).peek().getPlayer() == playerId ) {//board is not empty at location and player 2 owns piece of size 4
								if( board.get(row).get(col).peek().getSize() == 4){
									startRow = row;
									startCol = col;
									pieceSize = board.get(row).get(col).peek().getSize();
								}
							}
						}
					}
				}
			}
		}
		outerloop:
			for( int row = 0; row < board.size(); row++){ //iterate through the board
				for( int col = 0; col < board.get(row).size(); col++){
					if( board.get(row).get(col).isEmpty()){
						endRow = row;
						endCol = col;
						break outerloop;
					}
				}
			}
		if( endRow == -1 && endCol == -1){ //if no empty space on board
			if( playerId == 1 ){
				outerloop:
					for( int row = 0; row < board.size(); row++){
						for( int col = 0; col < board.get(row).size(); col++){
							if( !board.get(row).get(col).isEmpty()) {
								if( (board.get(row).get(col).peek().getPlayer() == 2 
										&& startRow != -1 && startCol != -1) 
											|| board.get(row).get(col).peek().getPlayer() == 1){
									if( pieceSize > board.get(row).get(col).peek().getSize()){
										endRow = row;
										endCol = col;
										break outerloop;
									}
								}
							}
						}
					}
			}//player 1 end
			if( playerId == 2 ){
				outerloop:
					for( int row = 0; row < board.size(); row++){
						for( int col = 0; col < board.get(row).size(); col++){
							if( !board.get(row).get(col).isEmpty()) {
								if( (board.get(row).get(col).peek().getPlayer() == 1 
										&& startRow != -1 && startCol != -1) 
											|| board.get(row).get(col).peek().getPlayer() == 2){
									if( pieceSize > board.get(row).get(col).peek().getSize()){
										endRow = row;
										endCol = col;
										break outerloop;
									}
								}
							}
						}
					}
				}//player 2 end
			}
		
		
		
		 // if coordinates are -1 set choose from stack to false to choose piece off the board
			if (endRow == -1 || endCol == -1) {
				chooseFromStack = false;
				stackNum = 0;//pick from board
			}
		}//do loop end
			
			while (endRow == -1 || endCol == -1);// coordinates arent -1, check board, 
		
		Coordinate start = new Coordinate(startRow, startCol);
		Coordinate end = new Coordinate(endRow, endCol);
		PlayerMove move = new PlayerMove(playerId, stackNum, pieceSize, start, end);
		return move;
	}

	/* (non-Javadoc)
	 * @see Interface.PlayerModule#playerInvalidated(int)
	 */
	@Override
	public void playerInvalidated(int arg0) {
	}

}
