/*
 * 
 * Pieces.java
 * 
 * Version:
 * $Id: Pieces.java,v 1.4 2014/03/11 20:28:14 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: Pieces.java,v $
 * Revision 1.4  2014/03/11 20:28:14  jvo7822
 * Everything is not as it seems. Part 1 of Project 2.
 *
 * Revision 1.3  2014/03/11 19:55:34  jvo7822
 * Finished, time for those pesky comments.
 *
 * Revision 1.2  2014/03/11 03:46:30  jvo7822
 * Need to fix indexing in stacks for players.
 *
 * Revision 1.1  2014/03/10 23:59:27  jvo7822
 * Need to finish LastMove, Init, DumpGameState.
 *
 * 
 * 
 */

package Players.JVO7822;
/**
 * 
 * @author Jon O'Brien
 *
 */
public class Pieces {
	public int playerId;
	public int Piece_size;
	
/**
 * 
 * @param playerId - the owner of the current piece.
 * @param Piece_size - the size of the current piece.
 */
public Pieces(int playerId, int Piece_size) {
	this.playerId = playerId;
	this.Piece_size = Piece_size;
}

/**
 * Returns player number for owner of piece.
 * @return - integer of player.
 */
public int getPlayerID() {
	return playerId;
}

/**
 * Returns size of piece.
 * @return - integer of piece.
 */
public int getSize() {
	return Piece_size;
}

/**
 * Conducts conversions to allow for printing of piece sizes and playerIds.
 */
public String toString(){
    String PieceString;
    PieceString = Piece_size+"("+playerId+")";
    return PieceString;
    
	}


}

