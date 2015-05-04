/**
 * File:
 *   $Id$
 *   
 * Revisions:
 *   $Log$
 */

import java.util.*;

/**
 * Dealer implements the Dealer class
 * @author Aaron T Deever
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 *
 */
public class Dealer
{
	public final int CARDS_PER_PACK = 5;
	public final int COST_PER_CARD = 3;
	public final int COST_PER_PACK = 10;
	
	
	/**
	 * Dealer stores information about the baseball cards contained in this
	 * special edition.
	 */
	private HashMap<String, Integer> playerData = new HashMap<String, Integer>();
	
	/**
	 * Default Constructor
	 */
	public Dealer()
	{ 
		playerData.put("Bonds", 762);
		playerData.put("Aaron",  755);
		playerData.put("Ruth", 714);
		playerData.put("Mays",  660);
		playerData.put("Rodriguez",  647);
		playerData.put("Griffey", 630);
		playerData.put("Thome",  612);
		playerData.put("Sosa", 609);
		playerData.put("Robinson", 586);
		playerData.put("McGwire", 583);
	}
	
	/**
	 * Method to create and return a new BaseballCard object corresponding to a specific player.
	 * @param player name of player
	 * @return a new BaseballCard object. Returns null if the requested player does not correspond to a BaseballCard in the special edition. NOTE - all dealer functions should create and return new BaseballCard objects.
	 */
	public BaseballCard buyCard(String player)
	{
		if (playerData.containsKey(player))
		{
			return new BaseballCard(player, playerData.get(player));
		}
		else
		{
			return null;
		}
	}

	/**
	 * Method to create a Collection of BaseballCard objects representing a pack.
	 * A pack consists of new BaseballCard objects corresponding to
	 * a random selection of players chosen without repeats.
	 * @return a Collection of size CARDS_PER_PACK containing new BaseballCard objects chosen without repeats.
	 */
	public Collection<BaseballCard> buyPack()
	{
		HashSet<BaseballCard> pack = new HashSet<BaseballCard>();
		HashSet<BaseballCard> completeSet = (HashSet<BaseballCard>) getCompleteSet();
		BaseballCard randomcard = (BaseballCard) completeSet.toArray()[(int)(Math.random()*completeSet.size())];

		while (pack.size() < CARDS_PER_PACK)
		{
			pack.add(randomcard);
			randomcard = (BaseballCard) completeSet.toArray()[(int)(Math.random()*completeSet.size())];
		}
		return pack;
	}

	/**
	 * Method to create a collection of the entire special edition of cards
	 * that can be used as a basis of comparison or generation
	 * @return a Collection containing a BaseballCard object for each player in the special edition.
	 */
	public Collection<BaseballCard> getCompleteSet()
	{
		HashSet<BaseballCard> complete = new HashSet<BaseballCard>();
		for (String key : playerData.keySet())
		{
			complete.add(new BaseballCard(key, playerData.get(key)));
		}
		return complete;
	}

	/**
	 * Method to "trade" one BaseballCard for another. The Dealer will accept a trade if he receives a BaseballCard that he values more highly than the BaseballCard he gives.
	 * The Dealer values BaseballCards based on the number of home runs that player has. He values a player with more home runs above a player with fewer home runs.
	 * If two players have an equal number of home runs, the Dealer values more highly the player whose lexicographical ordering of name is higher
	 * (e.g. he values Smith higher than Johnson).
	 * @param fanPlayer name of player BaseballCard that Fan wants to trade to Dealer
	 * @param dealerPlayer name of player BaseballCard that Fan wants to acquire from Dealer
	 * @return a new BaseballCard object corresponding to the requested card (null if rejected or malformed)
	 */
	public BaseballCard trade(String fanPlayer, String dealerPlayer)
	{
		// Accept players with same rank and "higher" name value
		if (playerData.get(fanPlayer) == playerData.get(dealerPlayer) && fanPlayer.compareTo(dealerPlayer) > 1)
		{
			return new BaseballCard(dealerPlayer, playerData.get(dealerPlayer));
		}
		// Accept trades with high cards
		else if (playerData.get(fanPlayer) > playerData.get(dealerPlayer))
		{
			return new BaseballCard(dealerPlayer, playerData.get(dealerPlayer));
		}
		// Reject trades otherwise
		else
		{
			return null;
		}
	}
}