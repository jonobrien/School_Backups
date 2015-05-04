/**
 * File:
 *   $Id$
 *   
 * Revisions:
 *   $Log$
 */

import java.util.*;

/**
 * Fan implements the Fan class
 * @author Aaron T Deever
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 *
 */
public class Fan
{
	/*
	 * Initial amount of money
	 */
	public static final int FAN_MONEY = 50;
	/*
	 * Input scanner
	 */
	private Scanner in = new Scanner(System.in);
	/*
	 * Current amount of money
	 */
	private int money;
	/*
	 * Collection of fan's BaseballCards
	 */
	private ArrayList<BaseballCard> fancards;
	/*
	 * Dealer object
	 */
	private Dealer d;
	
	/**
	 * Default constructor
	 * Initializes initial amount of money and collection of fan cards
	 * Initializes dealer
	 */
	public Fan()
	{
		money = FAN_MONEY;
		fancards = new ArrayList<BaseballCard>();
		d = new Dealer();
	}

	/**
	 * Method to simulate a trade between Fan and Dealer.
	 * Makes sure that the fan has the promised card
	 * Verifies the trade with the dealer
	 * Removes the card that was traded and adds the card that was traded for
	 */
	public void makeTrade()
	{
		System.out.println("Input player you will trade: ");
		String fanPlayer = in.next();
		System.out.println("Input player you will receive: ");
		String dealerPlayer = in.next();
		
		BaseballCard cardtogive = null;
		for (BaseballCard bc : fancards)
		{
			if (bc.getPlayerName().equals(fanPlayer))
			{
				cardtogive = bc;
			}
		}
		
		// If the fan has the card and the dealer is willing to trade
		if (cardtogive != null && d.trade(fanPlayer, dealerPlayer) != null)
		{
			// Remove your card and add the new one
			fancards.remove(cardtogive);
			fancards.add(d.trade(fanPlayer, dealerPlayer));
		}
		else
		{
			System.out.println("Trade not accepted or bad input");
		}
		
	}

	/**
	 * Method to simulate a purchase of a card from the Dealer.
	 * Verifies that fan has enough money to purchase a card
	 */
	public void purchaseCard()
	{
		System.out.println("Input name of player card to buy: ");
		String fanPlayer = in.next();
		
		// If fan has enough money
		if (money - d.COST_PER_CARD > 0)
		{
			// If card exists, add card to collection and remove funds
			if(d.buyCard(fanPlayer) != null)
			{
				fancards.add(d.buyCard(fanPlayer));
				money -= d.COST_PER_CARD;
			}
			else
			{
				System.out.println("Card does not exist");
			}
		}
		else
		{
			System.out.println("Not enough money to buy a card");
		}
	}

	/**
	 * Method to simulate a purchase of a pack of cards from the Dealer
	 * Verifies that the fan has enough money to purchase a pack
	 */
	public void purchasePack()
	{
		if (money - d.COST_PER_PACK >= 0)
		{
			HashSet<BaseballCard> newpack = new HashSet<BaseballCard>(d.buyPack());
			for(BaseballCard bc : newpack)
			{
				fancards.add(bc);
			}
			money -= d.COST_PER_PACK;
			System.out.println("Fan bought: " + newpack);
		}
		else
		{
			System.out.println("Not enough money to purchase a pack");
		}
	}


	/**
	 * Method to print the current status of the simulation.
	 * 1) the amount of money the Fan has left
	 * 2) a representation of the cards that the Fan has
	 * 3) a representation of the cards that the Fan does not have.
	 */
	public void status()
	{
		// Print money
		System.out.println("Fan has $" + money + " remaining.");
		
		// Print sorted cards
		TreeSet<BaseballCard> cardset = new TreeSet<BaseballCard>(fancards);
		System.out.println("Fan has: " + cardset);
		
		// Print cards that the fan does not have yet
		ArrayList<BaseballCard> need = new ArrayList<BaseballCard>();
		for (BaseballCard bc : d.getCompleteSet())
		{
			if (!fancards.contains(bc))
			{
				need.add(bc);
			}
		}
		Collections.sort(need);
		System.out.println("Fan needs: " + need);

		// Print duplicate cards
		HashSet<BaseballCard> nonduplicates = new HashSet<BaseballCard>();
		ArrayList<BaseballCard> extra = new ArrayList<BaseballCard>();
		for (BaseballCard bc : fancards)
		{
			if (!nonduplicates.contains(bc))
			{
				nonduplicates.add(bc);
			}
			else
			{
				extra.add(bc);
			}
			
		}
		Collections.sort(extra);
		System.out.println("Fan has extra: " + extra);
		
	}
	
	/**
	 * Main method for Baseball card simulation
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		
		if(args.length != 0)
		{ 
			System.out.println("Usage: java Fan");
			return;
		}
		
		Fan fan = new Fan();
		fan.simulate();
	}
	
	/**
	 * Method to simulate the interaction of a Fan and Dealer to buy/trade cards
	 */
	public void simulate()
	{ 
		
		boolean quit = false;
		
		do
		{ 
			System.out.println();
			System.out.print("Options: buy (P)ack / buy (C)ard / (T)rade");
			System.out.println(" / (S)tatus / (Q)uit");
			System.out.print("Command: ");
			
			if(in.hasNext())
			{ 
				String cmd = in.next();
				switch(cmd.charAt(0))
				{ 
				case 'P':
				case 'p':
					purchasePack();
					break;
				case 'C':
				case 'c':
					purchaseCard();
					break;
				case 'T':
				case 't':
					makeTrade();
					break;
				case 'S':
				case 's':
					status();
					break;
				case 'Q':
				case 'q':
					quit = true;
					break;
				default:
					break;
				}
			}
			else
			{ 
				return;
			}
			
		} while (!quit);
	}	
}