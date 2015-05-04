/**
 * Shape.java
 *
 * File:
 *	$Id: Shape.java,v 1.2 2013/03/18 19:12:53 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Shape.java,v $
 *	Revision 1.2  2013/03/18 19:12:53  njm7461
 *	Added more tests
 *	Added compareTo implementation
 *
 *	Revision 1.1  2013/03/18 18:35:18  njm7461
 *	Initial commit
 *
 */

/**
 * Sample interface
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public interface Shape
{
	
	/**
	 * Calculate the area of shape
	 * @return the calculated area
	 */
	public int area();
	
	/**
	 * Calculate the perimeter of shape
	 * @return the perimeter
	 */
	public int perimeter();
	
	public String sayHello();
		

}
