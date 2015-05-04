/*
 * Poker.java
 *
 * Version:
 * $Id: Poker.java,v 1.1 2013/03/27 23:23:16 njm7461 Exp $
 *
 * Revisions:
 * $Log: Poker.java,v $
 * Revision 1.1  2013/03/27 23:23:16  njm7461
 * Initial Commit
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A 2-card poker game played between a human and a computer player
 *
 * @author paw: Phil White
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Poker
{

   /**
    * Plays a single hand of poker
    *
    * @param    person	The human player
    * @param    comp	The computer player
    * @param    d	The deck
    * @return   String representation of winner
    */
    public static ArrayList<Player> playHand( ArrayList<Player> plist, Deck d )
    {
    	ArrayList<Player>standing = new ArrayList<Player>();
	
		System.out.println( "== Dealing Cards\n" );
		//give initial cards 
		for (int j=0; j<2; j++ )
		{
			for (Player p : plist)
			{
				p.addCard(d.dealCard());
			}
		}
		
	
		// ask all players if they want to stand and show hands
		for (Player p : plist)
		{
			if (p instanceof Human)
			{
				System.out.println( "==============  " + p.getName() + "'s Cards  ========" );
				p.printHand();
			}
			
			if (p.stand())
			{
				standing.add(p);
				System.out.println(p.getName() + " stands");
			}
			else
			{
				System.out.println(p.getName() + " folds");
			}
		}
		
		
		Collections.sort(standing); //Sort players by their cards
		
		if (standing.size() > 2)
		{
			//Print a header
			System.out.println("=================== Results ===================");
		}

		//Print cards
		for (Player p : standing)
		{
			System.out.println( "==============  " + p.getName() + "'s Cards  ========" );
			p.printHand();
		}

	
		//Print winner
		System.out.println(standing.get(0).getName() + " is the winner!");
		standing.get(0).plusWin();
		
		return plist;
    }

   /**
    * main method -- plays multiple hands of poker, after each hand
    * ask the user if they want to play again.  We also keep trak of
    * the number of games played/won by the user and print the results
    * at the end.
    *
    * @param    args      command line arguments
    */
    public static void main( String args[] )
    {
		System.out.println("MultiPlayer Poker");
		Scanner in = new Scanner( System.in );
		String again;
		char c;
		int numGames = 0;
	
		Deck theDeck = new Deck();
		ArrayList<Player> players = new ArrayList<Player>();
		
		// Populate the player list
		System.out.println("Add Players:");
		String input = "";
		do
		{
			System.out.println("Enter h for Human, c for Computer, f for Finished: ");
			input = in.next();
			if (input.equals("h"))
			{
				System.out.println("Enter name for Human: ");
				input = in.next();
				players.add(new Human(input, in));
			}
			else if (input.equals("c"))
			{
				System.out.println("Enter name for Computer: ");
				input = in.next();
				players.add(new Computer(input));
			}
			else if (input.equals("f"))
			{
				System.out.println("Finished!");
			}
			else
			{
				System.out.println("Invalid entry");
			}
		}
		while (!input.equals("f"));

		//Quit if there are no players to play
		if (players.size() == 0)
		{
			System.out.println("No players to play");
			System.exit(0);
		}
	
		//Play hands
		do
		{
		    numGames = numGames + 1;
	
		    System.out.println();
		    System.out.println( "##########################################" );
		    System.out.println( "##########       NEW HAND      ###########" );
		    System.out.println( "##########################################" );
		    System.out.println( "\n== Shuffling" );
		    theDeck.shuffle();
	
		    players = playHand( players, theDeck ); //Play the hand with the players
		    Collections.shuffle(players); //Shuffle the players
		    
		    for (Player p : players)
		    {
		    	p.newHand(); //Give each player a new hand
		    }
	
		    //Ask if players want to play another hand
		    do
		    {
		    	System.out.print( "Do you wish to play " + "another hand (y/n):" );
		    	again = in.next();
		    	again = again.toLowerCase();
		    	c = again.charAt( 0 );
		    }
		    while( c != 'y' && c != 'n' );
	
		}
		while ( c == 'y' );
	
		//If not, print results
		System.out.println( "========== Results ==========" );
		for (Player p : players)
		{
			System.out.println(p.getName() + " has " + p.getWins() + " win(s)");
		}
	
		in.close(); //Close Scanner
    }
} 
