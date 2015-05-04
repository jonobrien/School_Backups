package copy;

/*
 * ConsoleGame.java
 * 
 * Version:
 *  $Id: ConsoleGame.java,v 1.6 2014/02/25 17:46:06 jvo7822 Exp $
 * 
 * Revisions:
 *  $Log: ConsoleGame.java,v $
 *  Revision 1.6  2014/02/25 17:46:06  jvo7822
 *  Added comments.
 *
 *  Revision 1.5  2014/02/25 03:37:02  jvo7822
 *  DONE!
 *
 *  Revision 1.4  2014/02/25 01:43:18  jvo7822
 *  GameNight.java is broken, everything else done, just debugging.
 *
 *  Revision 1.3  2014/02/25 00:21:32  jvo7822
 *  4th commit, implemented game and more of the subclasses.
 *
 *  Revision 1.2  2014/02/23 22:55:18  jvo7822
 *  second commit.
 *
 *  Revision 1.1  2014/02/23 18:41:47  jvo7822
 *  Initial commit, testing cvs tags, Game.java skeleton outlined.
 *
 * 
 */

/**
 * Represents a console game. Success at console games always depends 
 * on dexterity, and may optionally depend on intelligence as well.
 * @author Jon O'Brien
 *
 */
public class ConsoleGame extends Game{
	
	
	private boolean usesInt = true;
	
	/**
	 * Constructor, takes three args to set the instance variables
	 * @param name - Name of the game
	 * @param np - Number of players that can play the game at once
	 * @param usesBrains - Whether or not the game uses intelligence
	 */
	public ConsoleGame(String name, int np, boolean usesBrains) {
		super(name, np);
		usesBrains = usesInt;
		
	}
		
	
	/**
	 * Plays the game and chooses a winner. Winner is chosen either 
	 * as the player with highest dexterity (if the game does not use 
	 * intelligence) or highest (dexterity + intelligence) otherwise.
	 */
	@Override
	public void play() {
        System.out.println("Playing " + name + "...");
        double bestval = 0;
        Player winner = null;
        for (Player player : players) {
            double thisval = player.getDexterity();
            if (!usesInt){
            	if (thisval > bestval) {
            		bestval = thisval;
            		winner = player;
            	}
            }
            else {
            	//uses intelligence and adds that to the total.
	        	double thisval1 = player.getDexterity() + player.getIntelligence();
	        	if (thisval1 > bestval) {
	                bestval = thisval1;
	                winner = player;
	        	}
            }
        }
        System.out.println("Winner is " + winner.getName());
        winner.youWin();
    }
		

}
