/**
 * Computer.java
 *
 * File:
 *	$Id: Computer.java,v 1.1 2013/03/27 23:23:13 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Computer.java,v $
 *	Revision 1.1  2013/03/27 23:23:13  njm7461
 *	Initial Commit
 *
 */

/**
 * Computer player for 2-card poker
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Computer extends Player
{	
	private static final int BETTER_THAN_HALF_WIN_VALUE =
		( Ranks.QUEEN.getValue() ) * 14 + 
		( Ranks.JACK.getValue() );

	/**
	 * Constructor makes a computer player with name n
	 * @param n name of computer
	 */
	public Computer(String n)
	{
		super(n); // Set Player name in super class
		myCards = new PokerHand();
	}


	/**
	 * determines if the computer should stand (vs fold).  Note the
	 * computer will stand if it has >=50% chance of winning (Based on
	 * other work, a High Card hand with a Q and J beats 50% of the other
	 * possible hands).  For the complete odds of winning see <a href="../chance.html">chance.html</a> for tables containing the chance 
	 * to win for 2-cards of the same suit, and 2 cards of unmatched suits
	 *
	 * @return	a boolean value specifying if the computer wants to stand
	 */
	public boolean stand()
	{
		return ( myCards.value() >= BETTER_THAN_HALF_WIN_VALUE );
	}
}
