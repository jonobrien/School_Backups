import java.util.ArrayList;
import java.util.Collections;

/*
 * Game.java
 * 
 * Version:
 *  $Id: Game.java,v 1.7 2014/02/25 17:46:05 jvo7822 Exp $
 * 
 * Revisions:
 *  $Log: Game.java,v $
 *  Revision 1.7  2014/02/25 17:46:05  jvo7822
 *  Added comments.
 *
 *  Revision 1.6  2014/02/25 03:37:02  jvo7822
 *  DONE!
 *
 *  Revision 1.5  2014/02/25 03:21:03  jvo7822
 *  Finished I think, time for those peskey comments and cleaning up the code.
 *
 *  Revision 1.4  2014/02/25 00:21:32  jvo7822
 *  4th commit, implemented game and more of the subclasses.
 *
 *  Revision 1.3  2014/02/24 17:30:54  jvo7822
 *  Working on pickPlayers, play, looping over the ages...
 *
 *  Revision 1.2  2014/02/23 22:55:18  jvo7822
 *  second commit.
 *
 *  Revision 1.1  2014/02/23 18:41:46  jvo7822
 *  Initial commit, testing cvs tags, Game.java skeleton outlined.
 *
 * 
 */

/**
 * Class to represent a generic game. Has instance variables 
 * for the name of the game (String), number of players that can 
 * play the game (intel) and who is playing the game (array of Player).
 * @author Jon O'Brien
 *
 */
public abstract class Game {
	protected String name;
	protected int totalPlayers;
	protected ArrayList <Player> players;
	
	
	/**
	 * 
	 * @param n - name of the game
	 * @param np - number of players that can play the game at once
	 */
	public Game(String n, int np) {
		this.name = n;
		this.totalPlayers = np;
		
	}
	
	
	
	/**
	 * Chooses players at random from the array passed in to play the game.
	 * Will pick as many players as can play the game at once.
	 *  
	 * @param players - list of players that might play the game
	 */
	public void pickPlayers(ArrayList<Player> players) {
		this.pickPlayers(players,totalPlayers);
		for (Player player:this.players) {
			System.out.println(player.getName());
		}
	}
	
	/**
	 * Chooses players at random from the list passed in to play the game.
	 * Will pick the number of players given as the second parameter (unless 
	 * the parameter is larger than the number that can play). You should 
	 * first create the list of Players of the correct size.
	 * Hint: use the isPlaying method to make sure no one plays twice!
	 * 
	 * @param players - list of players that might play the game
	 * @param num - numbers of players to pick
	 */
	public void pickPlayers(ArrayList<Player> players, int num) {
		this.players = new ArrayList<Player>(totalPlayers);
		Collections.shuffle(players);
		for (int chosen = 0 ;chosen <= num-1; chosen ++ ){
			if (!isPlaying(players.get(chosen))) {
				this.players.add(players.get(chosen));//adds to protected list
				this.totalPlayers ++;
			}
		}
	}
	
	/**
	 * 
	 * @param p - a player to check
	 * @return whether the player passed in, is playing the game.
	 */
	public boolean isPlaying(Player p) {
		return (this.players.contains(p));
	}
	
	/**
	 * Play the game! Since this is a generic game, no default behavior.
	 */
	public abstract void play();
	
	/**
	 * Returns a String representation of the game, in this case 
	 * simply the name of the game.
	 */
	public String toString() {
		return this.name;
		
	}
}

