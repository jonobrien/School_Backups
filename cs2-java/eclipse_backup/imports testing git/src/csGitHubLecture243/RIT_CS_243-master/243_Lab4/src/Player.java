/**
 * Player.java
 *
 * File:
 *	$Id: Player.java,v 1.1 2013/03/27 23:23:14 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Player.java,v $
 *	Revision 1.1  2013/03/27 23:23:14  njm7461
 *	Initial Commit
 *
 */

/**
 * Player Abstract Parent Class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public abstract class Player implements Comparable<Player>
{
	/**
	 * Hand of poker cards
	 */
	protected PokerHand myCards;
	/**
	 * name of player
	 */
	private String name;
	/**
	 * number of player wins
	 */
	private int wins;
	
	/**
	 * Default constructor for player
	 */
	public Player(String n)
	{
		name = n;
		wins = 0;
	}
	
	/**
	 * Get name method
	 * @return player name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * increments number of wins
	 */
	public void plusWin()
	{
		wins++;
	}
	
	/**
	 * Gets wins
	 * @return number of player wins
	 */
	public int getWins()
	{
		return wins;
	}
    
    /**
     * @return boolean: whether or not the player wants to stand
     */
    public abstract boolean stand();
    
    /**
     * Adds a card to the player's hand
     * @param c card to be added
     */
	public void addCard(Card c)
	{
		myCards.addCard(c);
	}
	 
	/**
	 * clears out the cards for the player
	 */
	public void newHand()
	{
		myCards = new PokerHand();
	}
	
	/**
	 * This function must come up with a single integer that represents the
	 * value of the hand.  You want the value to work such that a higher
	 * hand has a higher value. So the values should fall from highest to lowest
	 * @return integer representation of the hand
	 */
	public int value()
	{
		return myCards.value();
	}
	
	/**
	 * prints the hand in a nice format
	 */
	public void printHand()
	{
		myCards.printHand(); 
		System.out.println();
	}
     
	/**
	 * compares two player objects
	 */
	public int compareTo(Player other)
	{
		return (other.value()-value());
	}

}
