/**
 * TrollsBridge Class
 * Monitor for the Woolie Threads
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.ArrayList;

public class TrollsBridge
{
	private int maxCapacity;
	private int onBridge;
	private ArrayList<String> waitingQueue;
	
	/**
	 * Creates a TrollsBridge object with a specified maximum capacity
	 * @param max maximum capacity of the bridge
	 */
	public TrollsBridge(int max)
	{
		maxCapacity = max;
		onBridge = 0;
		waitingQueue = new ArrayList<String>();
	}
	
	/**
	 * Request permission to go onto the troll's bridge.
	 * Woolies call this method to ask the troll to put them on the queue of woolies trying to get on the bridge.
	 * The Woolie (thread) waits until it becomes the head of the queue and there is room on the troll's bridge.
	 * @param thisWoolie the Woolie trying to get on the bridge (the same object as Thread calling this method)
	 */
	public synchronized void enterBridgePlease(Woolie thisWoolie)
	{
		// Notify addition
		System.out.println("The troll scowls \"Get in line!\" when " + thisWoolie.getName() + " shows up at the bridge.");
		// Add Woolie name to the queue
		waitingQueue.add(thisWoolie.getName());
		
		// Wait if the bridge is at max capacity or if its not your turn
		while (onBridge == maxCapacity || !waitingQueue.get(0).equals(thisWoolie.getName()))
		{
			try
			{
				wait();
			}
			catch (InterruptedException e){}
		}
		
		// Add the Woolie to the crossing count
		onBridge++;
		// Remove the Woolie from the waiting queue
		waitingQueue.remove(0);
		// Notify in case there is still room
		notifyAll();
	}
	
	/**
	 * Tell the troll of a TrollsBridge that a woolie has left the bridge so that the troll can let other woolies get on if there is room.
	 */
	public synchronized void leave()
	{
		// Decrement crossing count
		if (onBridge > 0)
		{
			onBridge--;
		}
		// Notify the threads
		notifyAll();
	}

}
