/**
 * BaseballCard.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * BaseballCard Class
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class BaseballCard implements Comparable<BaseballCard>
{
	/*
	 * Name of the player
	 */
	private String name;
	/*
	 * Number of home runs
	 */
	private int homeruns;
	
	/**
	 * Constructs a Baseball card with a name and home runs
	 * @param name Player Name
	 * @param homers Home Runs
	 */
	public BaseballCard(String name, int homers)
	{
		this.name = name;
		this.homeruns = homers;
	}
	
	/**
	 * Constructs a BaseballCard as a copy of another BaseballCard
	 * @param bc other card to copy
	 */
	public BaseballCard(BaseballCard bc)
	{
		this(bc.getPlayerName(), bc.getHomeRuns());
		
	}

	/**
	 * Compares to BaseballCard objects using home runs
	 * @param bc other card to compare
	 * @return integer position
	 */
	public int compareTo(BaseballCard bc)
	{
		if (getHomeRuns() - bc.getHomeRuns() == 0)
		{
			return toString().compareTo(bc.toString());
		}
		else
		{
			return (getHomeRuns() - bc.getHomeRuns());	
		}
	}
	
	/**
	 * Determines if two Baseball cards are equal based on their toString (name and home runs)
	 * @param o Other object to compare
	 * @return boolean true if objects are equal, false otherwise
	 */
	public boolean equals(Object o)
	{
		if (o instanceof BaseballCard)
		{
			BaseballCard bc = (BaseballCard)o;
			return toString().equals(bc.toString());
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method to get home runs of player associated with current BaseballCard object
	 * @return the number of home runs
	 */
	public int getHomeRuns()
	{
		return homeruns;
	}
	
	/**
	 * Method to get name of player associated with current BaseballCard object
	 * @return the player's name
	 */
	public String getPlayerName()
	{
		return name;
	}
	
	/**
	 * Method to compute hashCode for BaseballCard object
	 * Overrides:hashCode in class Object
	 * @return int indicating the hashCode value for this object
	 */
	public int hashCode()
	{
		return this.toString().hashCode();
	}
	
	/**
	 * Method to convert a BaseballCard object to a String
	 * Overrides:toString in class Object
	 * @return String representation of BaseballCard object
	 */
	public String toString()
	{
		return (name + ":" + homeruns);
	}
}
						