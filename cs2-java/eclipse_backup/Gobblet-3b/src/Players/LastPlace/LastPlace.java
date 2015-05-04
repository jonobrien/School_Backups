package Players.LastPlace;

import java.util.ArrayList;
import java.util.Stack;

import utilities.Cloner;
import Engine.Logger;
import Interface.Coordinate;
import Interface.GobbletPart1;
import Interface.PlayerModule;
import Interface.PlayerMove;
import Players.LastPlace.Piece;
/**
 * $Id: LastPlace.java,v 1.3 2014/04/15 22:45:30 p142-05f Exp $
 * $Log: LastPlace.java,v $
 * Revision 1.3  2014/04/15 22:45:30  p142-05f
 * Final Version
 *
 * @author Dustin Martin, 
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
			}
			else if( move.getPlayerId() == 2 ){
				if( !player2Stacks.get(move.getStack()-1).isEmpty() ){
					piece = player2Stacks.get(move.getStack()-1).pop();
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
		}
		if( !board.get(endRow).get(endCol).isEmpty() ){
			if ( board.get(endRow).get(endCol).peek().getSize() < piece.getSize() ){
				board.get(endRow).get(endCol).push(piece);
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
	 * This method invokes some strategy, It generates a piece to move
	 * based on the state of the stacks if empty it moves a piece from the board
	 * otherwise it takes the biggest piece from all the stacks.
	 * It gets its start position based on the piece.
	 * Its end position is the first empty spot or the smallest piece your
	 * partner has on the board.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PlayerMove move() {
		ArrayList<PlayerMove> moveSet = new ArrayList<PlayerMove>();
		PlayerMove bestMove = null;
		int bestScore = 0;
		moveSet = generateMoves();
		Cloner.addImmutable(Piece.class);
		for(PlayerMove move: moveSet){
			/* copy the board and playerStacks for move checking */
			ArrayList<ArrayList<Stack<Piece>>> tempBoard = (ArrayList<ArrayList<Stack<Piece>>>) Cloner.deepCopy(this.board);
			ArrayList<Stack<Piece>> player1TempStacks = (ArrayList<Stack<Piece>>) Cloner.deepCopy(this.player1Stacks);
			ArrayList<Stack<Piece>> player2TempStacks = (ArrayList<Stack<Piece>>) Cloner.deepCopy(this.player2Stacks);
			if( moveScore( move ) > bestScore ){
				bestScore = moveScore( move );
				bestMove = move;
			}
			this.board = tempBoard;
			this.player1Stacks = player1TempStacks;
			this.player2Stacks = player2TempStacks;
		}

		return bestMove;


	}
	/**
	 * This method generates the move list based on the rows and columns that are iterated over,
	 * each row and each column, and then check each space for moves, for each player makes moves.
	 * @return - returns the list of moves.
	 */
	private ArrayList<PlayerMove> generateMoves(){
		ArrayList<PlayerMove> moves = new ArrayList<PlayerMove>();
		
		for( int row = 0; row < board.size(); row++ ){
			for( int col = 0; col < board.get(row).size(); col++ ){
				
				for( int fromRow = 0; fromRow < board.size(); fromRow++ ){
					for( int fromCol = 0; fromCol < board.get(fromRow).size(); fromCol++ ){
						
						if( !board.get(fromRow).get(fromCol).isEmpty() ){
							if( board.get(fromRow).get(fromCol).peek().getPlayer() == this.playerId ){
								if( !board.get(row).get(col).isEmpty()){
									if( board.get(row).get(col).peek().getSize() < 
											board.get(fromRow).get(fromCol).peek().getSize() ){
										moves.add(new PlayerMove( this.playerId, 0, board.get(fromRow).get(fromCol).peek().getSize(),
												new Coordinate(fromRow, fromCol), new Coordinate(row, col)));
									}
								}
								else{
									moves.add(new PlayerMove( this.playerId, 0, board.get(fromRow).get(fromCol).peek().getSize(),
											new Coordinate(fromRow, fromCol), new Coordinate(row, col)));
								}
							}
						}
					}
				}
			}
		}
		if( this.playerId == 1){
			int stackNum = 1;
			for(Stack<Piece> stack: this.player1Stacks ){
				if( !stack.isEmpty() ){
					for( int row = 0; row < board.size(); row++ ){
						for( int col = 0; col < board.get(row).size(); col++ ){
							if( board.get(row).get(col).isEmpty() ){
									//|| board.get(row).get(col).peek().getSize() < stack.peek().getSize() ){ 
								//gobble up pieces from the board(error)
								moves.add(new PlayerMove(this.playerId, stackNum, stack.peek().getSize(), 
										new Coordinate(-1,-1), new Coordinate(row, col )));
							}	
						}
					}

				}
				stackNum++;
			}
		}
		else{
			int stackNum = 1;
			for(Stack<Piece> stack: this.player2Stacks ){
				if( !stack.isEmpty() ){
					for( int row = 0; row < board.size(); row++ ){
						for( int col = 0; col < board.get(row).size(); col++ ){
							if( board.get(row).get(col).isEmpty() ){
									//|| board.get(row).get(col).peek().getSize() < stack.peek().getSize() ){ 
								//gobble up pieces from the board(error)
								moves.add(new PlayerMove(this.playerId, stackNum, stack.peek().getSize(), 
										new Coordinate(-1,-1), new Coordinate(row, col )));
							}
						}
					}
				}
				stackNum++;
			}
		}
		return moves;
	}
	
	/**
	 * This method takes a PlayerMove and calculates a value for a particular
	 * space based on the strategy criteria.  The different diagonals and 
	 * combinations of pieces are looked at and assigned a weight, that is
	 * put into a list of values that is used to make the actual moves on the board.
	 * @param move - the move being evaluated.
	 * @return - the value of the move.
	 */
	private int moveScore(PlayerMove move ){
		this.lastMove(move);
		int score = 0;
		if( this.playerTurn == 1 ){
			this.playerTurn = 2;
		}
		else{
			this.playerTurn = 1;
		}
		/* the 4 inner spaces have a score of 25 */
		if( move.getEndRow() == 0 && move.getEndCol() == 0 ){
			score += 25;
		}
		if( move.getEndRow() == 0 && move.getEndCol() == 3 ){
			score += 25;
		}
		if( move.getEndRow() == 3 && move.getEndCol() == 0 ){
			score += 25;
		}
		if( move.getEndRow() == 3 && move.getEndCol() == 3 ){
			score += 25;
		}
		/* the 4 corners have a score of 30 */
		if( move.getEndRow() == 1 && move.getEndCol() == 1 ){
			score += 30;
		}
		if( move.getEndRow() == 1 && move.getEndCol() == 2 ){
			score += 30;
		}
		if( move.getEndRow() == 2 && move.getEndCol() == 1 ){
			score += 30;
		}
		if( move.getEndRow() == 2 && move.getEndCol() == 2 ){
			score += 30;
		}
		int oppCount = 0;
		int myCount = 0;
		boolean myFour = false;
		for( int row = 0; row < board.size(); row++){
			if( !board.get(row).get(0).isEmpty() ){
				if( board.get(row).get(0).peek().getPlayer() != this.playerId ){
					score -= board.get(row).get(0).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(row).get(0).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(row).get(0).peek().getSize();
					myCount++;
				}
			}
		}
		/* these if-blocks are repeated for the next 10 blocks to determine move values, 
		 * therefore the comments will be duplicated and I will not copy and paste the same
		 * throughout the code to reduce length of code.  Nonetheless, they are the same, and 
		 * these comments apply to all if-blocks following here.  */
		
		/* If the opponent has 3 and I don't have a 4 in that line. */
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		/* If the opponent has 3 and I have none in that line. */
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		/* If the opponent has 2 and I don't have a 4 in that line. */
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		/* If I have 2 in that line. */
		if( myCount == 2 ){
			score += 30;
		}
		/* If I have 2 in that line, and a 4 is in that line. */
		if( myCount == 2 && myFour ){
			score += 50;
		}
		/* If I have 3 in that line. */
		if( myCount == 3 ){
			score += 100;
		}
		/* If I have 3 in that line, and a 4 is in that line. */
		if( myCount == 3 && myFour ){
			score += 150;
		}
		/* If I have 4 in that line. */
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for( int row = 0; row < board.size(); row++){
			if( !board.get(row).get(1).isEmpty() ){
				if( board.get(row).get(1).peek().getPlayer() != this.playerId ){
					score -= board.get(row).get(1).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(row).get(1).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(row).get(1).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for( int row = 0; row < board.size(); row++){
			if( !board.get(row).get(2).isEmpty() ){
				if( board.get(row).get(2).peek().getPlayer() != this.playerId ){
					score -= board.get(row).get(2).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(row).get(2).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(row).get(2).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for( int row = 0; row < board.size(); row++){
			if( !board.get(row).get(3).isEmpty() ){
				if( board.get(row).get(3).peek().getPlayer() != this.playerId ){
					score -= board.get(row).get(3).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(row).get(3).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(row).get(3).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for(  int col = 0; col < board.size(); col++){
			if( !board.get(0).get(col).isEmpty() ){
				if( board.get(0).get(col).peek().getPlayer() != this.playerId ){
					score -= board.get(0).get(col).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(0).get(col).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(0).get(col).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for(  int col = 0; col < board.size(); col++){
			if( !board.get(1).get(col).isEmpty() ){
				if( board.get(1).get(col).peek().getPlayer() != this.playerId ){
					score -= board.get(1).get(col).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(1).get(col).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(1).get(col).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for(  int col = 0; col < board.size(); col++){
			if( !board.get(2).get(col).isEmpty() ){
				if( board.get(2).get(col).peek().getPlayer() != this.playerId ){
					score -= board.get(2).get(col).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(2).get(col).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(2).get(col).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for(  int col = 0; col < board.size(); col++){
			if( !board.get(3).get(col).isEmpty() ){
				if( board.get(3).get(col).peek().getPlayer() != this.playerId ){
					score -= board.get(3).get(col).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(3).get(col).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(3).get(col).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		/* Diagonal Check, every row and column in a particular line, repeated 
		 * a couple times.*/
		for( int i = 0; i < board.size(); i++){
			if( !board.get(i).get(i).isEmpty() ){
				if( board.get(i).get(i).peek().getPlayer() != this.playerId ){
					score -= board.get(i).get(i).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(i).get(i).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(i).get(i).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		oppCount = 0;
		myCount = 0;
		myFour = false;
		for( int i = 0; i < board.size(); i++){
			if( !board.get(3-i).get(i).isEmpty() ){
				if( board.get(3-i).get(i).peek().getPlayer() != this.playerId ){
					score -= board.get(3-i).get(i).peek().getSize();
					oppCount++;
				}
				else{
					if( board.get(3-i).get(i).peek().getSize() == 4 ){
						myFour = true;
					}
					score += board.get(3-i).get(i).peek().getSize();
					myCount++;
				}
			}
		}
		if( oppCount == 3 && !myFour ){
			score -= 9000;
		}
		if( oppCount == 3 && myCount == 0 ){
			score -= 2000;
		}
		
		if( oppCount == 2 && !myFour ){
			score -= 30;
		}
		if( myCount == 2 ){
			score += 30;
		}
		if( myCount == 2 && myFour ){
			score += 50;
		}
		if( myCount == 3 ){
			score += 100;
		}
		if( myCount == 3 && myFour ){
			score += 150;
		}
		if( myCount == 4){
			score = Integer.MAX_VALUE;
		}
		/* return the score calculated for the move */
		return score;
	}
	
	
	/* (non-Javadoc)
	 * @see Interface.PlayerModule#playerInvalidated(int)
	 */
	@Override
	public void playerInvalidated(int arg0) {
	}

}
