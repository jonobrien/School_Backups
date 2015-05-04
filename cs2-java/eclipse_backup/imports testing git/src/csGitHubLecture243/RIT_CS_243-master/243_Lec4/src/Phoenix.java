/**
 * Phoenix.java
 *
 * File:
 *	$Id: Phoenix.java,v 1.1 2013/03/25 18:46:25 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Phoenix.java,v $
 *	Revision 1.1  2013/03/25 18:46:25  njm7461
 *	Initial Commit
 *
 */

/**
 * Phoenix Child Class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Phoenix extends Monster implements Flyer
{
	private int flight;
	
	/**
	 * Constructs a phoenix
	 * Calls the constructor for the Monster parent class
	 * @param tname name of the phoenix
	 * @param thit
	 */
	public Phoenix(String tname, int thit)
	{
		super(tname, thit); //If you don't put this in, Java will call the super class anyway, just with no arguments (which will complain in this case)
		flight = 0;
	}
	
	public void fly(int d)
	{
		System.out.println(getName() + " flies " + d + " miles");
		flight += d;
	}
	
	public void regen()
	{
		int increase = (int)(getHitPoints() * .1);
		System.out.println(getName() + " regenerating " + increase + " hit points");
		hitPoints += increase;
	}
	
	public String toString()
	{
		String str = super.toString();
		str += ", and has flown " + flight + "miles";
		return str;
		
	}
	
	public void crossWater()
	{
		System.out.println(getName() + " flys across water");
		
	}
	

}
