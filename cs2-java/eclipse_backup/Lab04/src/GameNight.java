import java.util.ArrayList;

/*
 * GameNight.java
 * 
 * Version:
 *  $Id: GameNight.java,v 1.10 2014/02/25 17:46:05 jvo7822 Exp $
 * 
 * Revisions:
 *  $Log: GameNight.java,v $
 *  Revision 1.10  2014/02/25 17:46:05  jvo7822
 *  Added comments.
 *
 *  Revision 1.9  2014/02/25 03:37:02  jvo7822
 *  DONE!
 *
 *  Revision 1.8  2014/02/25 03:21:03  jvo7822
 *  Finished I think, time for those peskey comments and cleaning up the code.
 *
 *  Revision 1.7  2014/02/25 01:43:18  jvo7822
 *  GameNight.java is broken, everything else done, just debugging.
 *
 *  Revision 1.6  2014/02/25 00:21:31  jvo7822
 *  4th commit, implemented game and more of the subclasses.
 *
 *  Revision 1.5  2014/02/24 17:30:54  jvo7822
 *  Working on pickPlayers, play, looping over the ages...
 *
 *  Revision 1.4  2014/02/24 15:51:59  jvo7822
 *  3rd commit.
 *
 *  Revision 1.3  2014/02/23 22:55:18  jvo7822
 *  second commit.
 *
 *  Revision 1.2  2014/02/23 22:00:22  jvo7822
 *  Added playerList.
 *
 *  Revision 1.1  2014/02/23 18:41:46  jvo7822
 *  Initial commit, testing cvs tags, Game.java skeleton outlined.
 *
 * 
 */

/**
 * Uses the Player class and Game and its subclasses to simulate a night 
 * of game-playing.
 * @author Jon O'Brien
 *
 */
public class GameNight {
	

	private static ArrayList <Player> playerList = new ArrayList<Player>();
	private static ArrayList <Game> gameList = new ArrayList<Game>();
	
	
	
	/**
	 * Create and populate a list of at least 8 players.
	 * 
	 * Create and populate a list of at least 5 games, using each subclass of 
	 * Game at least once, and pick players for each game.
	 * 
	 * Use a loop to play each game exactly once.
	 * 
	 * Use a loop to print out each Player's ending stats and determine the big 
	 * winner of the night.
	 * 
	 * Print out the big winner.
	 * @param args - cmd line args - unused.
	 */
	public static void main(String[] args) {
		
		//creating players 
		Player Jon = new Player("Jon", 95, 95, 95, 19);
		Player P8 = new Player("P8", 50, 50, 50, 5);
		Player Victoria = new Player("Victoria", 90, 90, 90, 18);
		Player Brandon= new Player("Brandon", 10, 10, 10, 6);
		Player Allison = new Player("Allison", 90, 90, 90, 20);
		Player Chris = new Player("Chris", 100, 100, 100, 23);
		Player Tania = new Player("Tania", 80, 80, 80, 8);
		Player Nick = new Player("Nick", 100, 100, 100, 7);


		
		//adding all the people to the playerList
		playerList.add(Jon);
		playerList.add(P8);
		playerList.add(Victoria);
		playerList.add(Brandon);
		playerList.add(Allison);
		playerList.add(Chris);		
		playerList.add(Tania);
		playerList.add(Nick);


		//creating games of different game types/subclasses
		Game Spades = new TeamCardGame("Spades");
		Game DDRExtreme = new ConsoleGame("DDR Extreme", 2, false);
		Game PuertoRico = new GermanBoardGame("Puerto Rico", 4, 0);
		Game MarioParty = new ConsoleGame("Mario Party", 4, true);
		Game CandyLand = new BoardGame("Candy Land", 4, 0);

		//adding games to gameList
		gameList.add(Spades);
		gameList.add(DDRExtreme);
		gameList.add(PuertoRico);
		gameList.add(MarioParty);
		gameList.add(CandyLand);

		
		for (Game current: gameList) {
			System.out.println("Picking players for:" + current);
			current.pickPlayers(playerList);
			current.play();
		}
		
		for (Player challenger:playerList) {
			System.out.println("Name: " + challenger.getName());
			System.out.println("Number of wins: " + challenger.getWins());
		}
		
		Player Winner = playerList.get(0);
		int highWinner = playerList.get(0).getWins();
		for (Player option: playerList) {
			if (option.getWins() > highWinner) {
				highWinner = option.getWins();
						Winner = option;	
			}
		}
		System.out.println("The winner is: " + Winner.getName() + " with " + 
		Winner.getWins() + " wins!");

}

}