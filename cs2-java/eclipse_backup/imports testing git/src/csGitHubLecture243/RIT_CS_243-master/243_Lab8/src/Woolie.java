/**
 * Woolie.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * Woolie Class
 * Represents one Woolie Thread
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Woolie extends Thread
{
	private int crossTime;
	private String destination;
	private TrollsBridge bridgeGuard;
	
	/**
	 * Construct a new Woolie object that can run as a thread.
	 * @param name name of the woolie
	 * @param crossTime the number of seconds it takes the Woolie to cross after it has climbed onto the bridge
	 * @param destination the Woolie's destination city
	 * @param bridgeGuard the TrollsBridge that the Woolie is crossing
	 */
	public Woolie(String name, int crossTime, String destination, TrollsBridge bridgeGuard)
	{
		// Set thread name
		setName(name);
		// Convert seconds to milliseconds
		this.crossTime = crossTime;
		// Set destination
		this.destination = destination;
		// Set the TrollBridge
		this.bridgeGuard = bridgeGuard;
	}
	
	/**
	 * The run method handles a Woolie's behavior as it crosses the bridge.
	 * The well-behaved Woolie asks the troll at the bridge to cross.
	 * While it is crossing the bridge, it reports its progress each second as it works its way across, and the woolie lastly tells the troll that it has gotten off the bridge.
	 */
	public void run()
	{
		// Request addition into queue
		bridgeGuard.enterBridgePlease(this);
		
		// Display initial message at time 0
		System.out.println(getName() + " is starting to cross.");
		
		// Sleep for time to cross
		for (int sleeptime = 1; sleeptime < crossTime; sleeptime++)
		{
			// Sleep for 1 second
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				System.err.println("Unexpected interruption");
			}
			// For every one second interval, beyond time 0, that the Woolie is on the bridge, display the message
			System.out.println("\t" + getName() + " " + sleeptime + " seconds.");
		}
		
		// Sleep for last second
		try
		{
			sleep(1000);
		}
		catch (InterruptedException e)
		{
			System.err.println("Unexpected interruption");
		}
		
		bridgeGuard.leave();
		
		// When the Woolie reaches its destination, display the message
		System.out.println(getName() + " leaves at " + destination + ".");
	}

}
