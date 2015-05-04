/**
 * Circle.java
 *
 * File:
 *	$Id: Circle.java,v 1.2 2013/03/18 19:12:53 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Circle.java,v $
 *	Revision 1.2  2013/03/18 19:12:53  njm7461
 *	Added more tests
 *	Added compareTo implementation
 *
 *	Revision 1.1  2013/03/18 18:35:22  njm7461
 *	Initial commit
 *
 */

/**
 * A hello world program in Java.
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Circle implements Shape
{
	private int radius;

	public Circle(int r)
	{
		radius = r;
	}
	
	public int area()
	{
		return (int) (Math.PI*radius*radius);
	}

	public int perimeter()
	{
		return (int) (2*Math.PI*radius);
	}
	
	public String sayHello()
	{
		return "Circle says hello";
	}
	
	public String circleTell()
	{
		return "Imma circle";
	}

}
