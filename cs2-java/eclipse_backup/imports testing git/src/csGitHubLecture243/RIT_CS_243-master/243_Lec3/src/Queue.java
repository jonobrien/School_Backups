/**
 * Queue.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * A hello world program in Java.
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public interface Queue <E>
{
	/**
	 * Return the first element in the queue without changing anything
	 * @return the first element or null if empty
	 */
	public E front();
	
	/**
	 * Removes the first element
	 * @return the first element or null if empty
	 */
	public E dequeue();
	
	/**
	 * Add an object to the end of the queue
	 * @param e data to be added
	 * @return stuff
	 */
	public boolean enqueue(E e);
	
	public boolean isFull();
	
	public boolean isEmpty();
	
}
