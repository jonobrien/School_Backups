import java.util.ArrayList;

/*
 * TeamCardGame.java
 * 
 * Version:
 *  $Id: TeamCardGame.java,v 1.7 2014/02/25 17:46:07 jvo7822 Exp $
 * 
 * Revision:
 *  $Log: TeamCardGame.java,v $
 *  Revision 1.7  2014/02/25 17:46:07  jvo7822
 *  Added comments.
 *
 *  Revision 1.6  2014/02/25 03:21:04  jvo7822
 *  Finished I think, time for those peskey comments and cleaning up the code.
 *
 *  Revision 1.5  2014/02/25 01:43:18  jvo7822
 *  GameNight.java is broken, everything else done, just debugging.
 *
 *  Revision 1.4  2014/02/25 00:21:32  jvo7822
 *  4th commit, implemented game and more of the subclasses.
 *
 *  Revision 1.3  2014/02/24 17:30:55  jvo7822
 *  Working on pickPlayers, play, looping over the ages...
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
 * Represents a card game played with two teams of two (such as bridge,
 *  spades, etc).
 * @author Jon O'Brien
 *
 */
public class TeamCardGame extends Game{
	private static final int NUMBER_ALLOWED = 4;
	/**
	 * Constructor. Assumes all such games are played by four players.
	 * @param n - name of game.
	 */
	public TeamCardGame(String n) {
		super(n, NUMBER_ALLOWED);
	}
	
	/**
	 * Plays the game, selecting a winning team according to total team 
	 * intelligence. This is computed for each team as the team's higher
	 * intelligence value plus twice the team's lower intelligence value. 
	 * The players of the first team are the first and third players, and 
	 * the players on the second team are the second and fourth players. 
	 * Display the name(s) of the winning player(s).
	 * 
	 */
	@Override
	public void play() {
		double team1;
		double team2;
		double team1P1 = players.get(0).getIntelligence();
		double team1P2 = players.get(2).getIntelligence();
		double team2P1 = players.get(1).getIntelligence();
		double team2P2 = players.get(3).getIntelligence();
		ArrayList <Player> winnerList = new ArrayList<Player>();
		//team 1 comparisons for intelligence to determine winners
		{
		if (team1P1 > team1P2) {
			team1 = team1P1 + 2*team1P2;
		}
		else {
			team1 = team1P2 + 2*team1P1;
			}
		
		//team 2 comparisons for intelligence to determine winners
		if (team2P1 > team2P2) {
			team2 = team2P1 + 2*team2P2;
		}
		else {
			team2 = team2P2 + 2*team2P1;
			}
		//handles ties, team1 wins
		if (team1 >= team2) {
			winnerList.add(players.get(0));
			winnerList.add(players.get(2));
			winnerList.get(0).youWin();
			winnerList.get(1).youWin();
			
			System.out.println("The winners are: " + players.get(0).getName() + 
					" and " + players.get(2).getName());
		}
		else {
			winnerList.add(players.get(1));
			winnerList.add(players.get(3));
			winnerList.get(0).youWin();
			winnerList.get(1).youWin();
				
				System.out.println("The winners are: " + players.get(1).getName() + 
						" and " + players.get(3).getName());
		}
		}
		
		}

	}
