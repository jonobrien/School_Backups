/*
 * Piece.java
 * 
 * Version:
 * $Id: Piece.java,v 1.4 2014/04/29 21:47:08 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: Piece.java,v $
 * Revision 1.4  2014/04/29 21:47:08  jvo7822
 * updated and added comments.
 *
 * Revision 1.3  2014/04/29 21:44:21  jvo7822
 * cvs tags working?
 *
 */

package Players.JVO7822;

/**
 * @author Jon O'Brien
 * This is a class that represents the Pieces, it holds the player value (1 or 2)
 * and it holds the size of the piece(1-4)
 */
public class Piece {
	private int playerValue; //The ID of the player.
	private int pieceSize; //The size of the piece.
	public Piece( int playerValue, int pieceSize ){
		this.playerValue = playerValue;
		this.pieceSize = pieceSize;
	}
	
	/**
	 * @return The size of the piece.
	 */
	public int getSize(){
		return this.pieceSize;
	}
	/**
	 * @return The players ID.
	 */
	public int getPlayer(){
		return this.playerValue;
	}
	/**
	 * A String representation of the piece.
	 */
	public String toString(){
		return String.valueOf(pieceSize) + "(" + String.valueOf(playerValue) + ")";
	}

}
