import java.util.ArrayList;
import java.util.Collections;

/*
 * GermanBoardGame.java
 * 
 * Version:
 *  $Id: GermanBoardGame.java,v 1.9 2014/02/25 17:46:04 jvo7822 Exp $
 * 
 * Revision:
 *  $Log: GermanBoardGame.java,v $
 *  Revision 1.9  2014/02/25 17:46:04  jvo7822
 *  Added comments.
 *
 *  Revision 1.8  2014/02/25 03:37:02  jvo7822
 *  DONE!
 *
 *  Revision 1.7  2014/02/25 03:21:03  jvo7822
 *  Finished I think, time for those peskey comments and cleaning up the code.
 *
 *  Revision 1.6  2014/02/25 01:43:18  jvo7822
 *  GameNight.java is broken, everything else done, just debugging.
 *
 *  Revision 1.5  2014/02/25 00:21:31  jvo7822
 *  4th commit, implemented game and more of the subclasses.
 *
 *  Revision 1.4  2014/02/24 17:30:54  jvo7822
 *  Working on pickPlayers, play, looping over the ages...
 *
 *  Revision 1.3  2014/02/24 15:51:59  jvo7822
 *  3rd commit.
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
 * Class to represent German board games. These games are like regular board 
 * games with two exceptions. They never rely on any luck, and only people 
 * over 10 years of age play them.
 * @author Jon O'Brien
 * 
 */
public class GermanBoardGame extends BoardGame{
	private final static int AGE_ALLOWED = 10;
	
	/**
	 * Constructor, takes a name and number of players
	 * @param n - name of game.
	 * @param np - number of players.
	 * @param l - luck factor - inherited from super
	 */
	public GermanBoardGame(String n, int np, double l) {
		super(n, np, l);
		l = 0.0;
	}
	
	
	/**
	 * Chooses players to play the game at random, but will not choose any 
	 * player age 10 or under.
	 * @param players - list of players to choose from
	 * @param num - the number of players to pick
	 */
	@Override
	public void pickPlayers(ArrayList <Player> players, int num) {
		this.players = new ArrayList<Player>(totalPlayers);
		Collections.shuffle(players);
		int index = 0;
		while (this.players.size() < totalPlayers) {
			if (!isPlaying(players.get(index)) && (players.get(index).getAge() > AGE_ALLOWED))
				this.players.add(players.get(index));
				index ++;
			}
		}
	}