/**
 * Bicycle.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Bicycle interface
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public interface Bicycle
{
	/**
	 * Ability to speed up
	 * @param i amount to speed up
	 */
	public void speedUp(int i);
	
	/**
	 * Ability to slow down
	 * @param i amount to slow down
	 */
	public void slowDown(int i);
	
	/**
	 * Ability to change gear
	 * @param up shifting (true => up; false => down)
	 */
	public void changeGear(boolean up);

}
