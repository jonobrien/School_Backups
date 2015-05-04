/**
 * Monster.java
 *
 * File:
 *	$Id: Monster.java,v 1.2 2013/03/25 19:13:12 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Monster.java,v $
 *	Revision 1.2  2013/03/25 19:13:12  njm7461
 *	Added equals method
 *
 *	Revision 1.1  2013/03/25 18:46:26  njm7461
 *	Initial Commit
 *
 */

/**
 * Monster Parent Class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public abstract class Monster
{
	private String name;
	protected int hitPoints; // Fewer restrictions, other classes in the same package and child classes have access
	
	/**
	 * Initializes with a name and initial hitpoints
	 * @param tname name
	 * @param thit hitpoints
	 */
	public Monster(String tname, int thit)
	{
		name = tname;
		hitPoints = thit;
	}
	
	/**
	 * 
	 * @return name of monster
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return hit points of monster
	 */
	public int getHitPoints()
	{
		return hitPoints;
	}
	
	/**
	 * @return name of monster and hitPoints
	 */
	public String toString()
	{
		return (name + " has hitpoints " + hitPoints);
	}
	
	/**
	 * Deals damage to monster
	 * @param d amount of damage
	 */
	public void takeDamage(int d)
	{
		System.out.println(name + " takes damage " + d);
		if (hitPoints - d >= 0)
			hitPoints -= d;
		else
			hitPoints = 0;
			
	}

	public boolean equals(Object obj)
	{
		if (obj instanceof Monster)
		{
			Monster mon = (Monster) obj;
			return name.equals(mon.name) && hitPoints == mon.hitPoints;
		}
		else
		{
			return false;
		}
	
	}

	public abstract void crossWater(); // Abstract method

}
