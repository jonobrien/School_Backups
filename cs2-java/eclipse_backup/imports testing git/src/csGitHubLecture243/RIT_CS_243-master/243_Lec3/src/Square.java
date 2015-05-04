/**
 * Square.java
 *
 * File:
 *	$Id: Square.java,v 1.2 2013/03/18 19:12:53 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Square.java,v $
 *	Revision 1.2  2013/03/18 19:12:53  njm7461
 *	Added more tests
 *	Added compareTo implementation
 *
 *	Revision 1.1  2013/03/18 18:35:16  njm7461
 *	Initial commit
 *
 */

/**
 * A hello world program in Java.
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Square implements Shape, Comparable<Square>
{
	static final int NUM_SIDES = 4;
	private int side;
	
	public Square(int width)
	{
		side = width;
	}
	public int area()
	{
		return side * side;
	}

	public int perimeter()
	{
		return side*NUM_SIDES;
	}
	
	public String sayHello()
	{
		return "Square says hello";
	}
	
	public String circleTell()
	{
		return "I'm not a circle";
	}

	public int compareTo(Square sq) {
		if (side > sq.side)
		{
			return 1;
		}
		else if (side == sq.side)
		{
			return 0;
		}
		else
		{
			return -1;
		}
			
	}
	
	public String toString()
	{
		return String.valueOf(side);
	}

}
