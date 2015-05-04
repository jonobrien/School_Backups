package Players.LastPlace;

import java.util.ArrayList;
import java.util.Stack;

import Engine.Logger;
import Interface.Coordinate;
import Interface.GobbletPart1;
import Interface.PlayerModule;
import Interface.PlayerMove;
import Players.LastPlace.Piece;
/**
 * $Id:$
 * $Log:$
 * 
 * @author Dustin Martin, Jon O'Brien
 *
 */
public class LastPlace implements PlayerModule, GobbletPart1 {

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

		int stackNum = 0;
		int pieceSize = 0;
		int startRow = 0;
		int startCol = 0;
		int endRow = -1;
		int endCol = -1;
		if(this.playerId == 1){
			if(!player1Stacks.isEmpty()){
				startRow = -1;
				startCol = -1;
				for(int i = 0; i < player1Stacks.size(); i++ ){
					if(!player1Stacks.get(i).isEmpty()){
						if(player1Stacks.get(i).peek().getSize() > pieceSize ){
							pieceSize = player1Stacks.get(i).peek().getSize();
							stackNum = i+1;
						}
					}
				}
			}
			else{
				for(int row = 0; row < board.size(); row++){
					for(int col = 0; col < board.get(row).size(); col++){
						if(!board.get(row).get(col).isEmpty() && 
								board.get(row).get(col).peek().getPlayer() == playerId){
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
		if(this.playerId == 2){
			if(!player1Stacks.isEmpty()){
				startRow = -1;
				startCol = -1;
				for(int i = 0; i < player1Stacks.size(); i++ ){
					if(!player1Stacks.get(i).isEmpty()){
						if(player1Stacks.get(i).peek().getSize() > pieceSize ){
							pieceSize = player1Stacks.get(i).peek().getSize();
							stackNum = i+1;
						}
					}
				}
			}
			else{
				for(int row = 0; row < board.size(); row++){
					for(int col = 0; col < board.get(row).size(); col++){
						if(!board.get(row).get(col).isEmpty() && 
								board.get(row).get(col).peek().getPlayer() == playerId){
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
		outerloop:
			for( int row = 0; row < board.size(); row++){
				for( int col = 0; col < board.get(row).size(); col++){
					if( board.get(row).get(col).isEmpty()){
						endRow = row;
						endCol = col;
						break outerloop;
					}
				}

			}
		if( endRow == -1 && endCol == -1){
			if( playerId == 1 ){
				outerloop:
					for( int row = 0; row < board.size(); row++){
						for( int col = 0; col < board.get(row).size(); col++){
							if( !board.get(row).get(col).isEmpty() &&
									board.get(row).get(col).peek().getPlayer() == 2){
								if( startRow != -1 && startCol != -1){
									if( pieceSize > board.get(row).get(col).peek().getSize()){
										endRow = row;
										endCol = col;
										break outerloop;
									}
								}
							}
						}
					}
			}
			if( playerId == 2 ){
				outerloop:
					for( int row = 0; row < board.size(); row++){
						for( int col = 0; col < board.get(row).size(); col++){
							if( !board.get(row).get(col).isEmpty() &&
									board.get(row).get(col).peek().getPlayer() == 1){
								if( startRow != -1 && startCol != -1){
									if( pieceSize > board.get(row).get(col).peek().getSize()){
										endRow = row;
										endCol = col;
										break outerloop;
									}
								}
							}
						}
					}
			}
		}
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
