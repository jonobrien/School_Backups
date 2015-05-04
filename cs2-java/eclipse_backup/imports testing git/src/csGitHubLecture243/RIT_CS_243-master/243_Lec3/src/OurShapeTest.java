/**
 * OurShapeTest.java
 *
 * File:
 *	$Id: OurShapeTest.java,v 1.2 2013/03/18 19:12:53 njm7461 Exp $
 *
 * Revisions:
 *	$Log: OurShapeTest.java,v $
 *	Revision 1.2  2013/03/18 19:12:53  njm7461
 *	Added more tests
 *	Added compareTo implementation
 *
 *	Revision 1.1  2013/03/18 18:35:21  njm7461
 *	Initial commit
 *
 */

/**
 * Shape interface tester
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.ArrayList;
import java.util.Collections;

public class OurShapeTest
{

	/**
	 * @param args arguments not used
	 */
	public static void main(String[] args)
	{
		// we can have a reference to interface Shape
		Shape shape1;
		
		//Shape shape2 = new Shape(); // Cannot instantiate this type (interface)
		
		Square square1 = new Square(5); // New Square object with length 5
		shape1 = new Square(10); // We can a Square to a Shape type
		
		// we can create an array of Shapes and store in it any object of a class that implements Shape
		Shape [] items = new Shape[5];
		items[0] = new Circle(10);
		items[1] = new Circle(5);
		items[2] = new Square(7);
		items[3] = new Square(3);
		items[4] = new Circle(1);
		
		for (Shape s : items) // We can also iterate through the array using a For Each loop
		{
			System.out.println(s.sayHello()); //This method must be included in the Shape implementation in order it to be called in this way
			System.out.println("Perimeter:\t"+s.perimeter());
			System.out.println("Area:\t\t"+s.area());
			System.out.println();
		}
		
		
		/*
		 * if the circleTell() method is not in the interface, we have to cast in order to call
		 */
		for (Shape s : items)
		{
			if (s instanceof Circle)
			{
				System.out.println(((Circle)s).circleTell());
			}
			else if (s instanceof Square)
			{
				System.out.println(((Square)s).circleTell());
			}
			else
			{
				throw new ClassCastException("Java Derped");
			}
		}
		
		/*
		 * We make an ArrayList of Square object and because we have implemented Comparable, we can sort it
		 */
		ArrayList<Square> sqList = new ArrayList<Square>();
		sqList.add(new Square(3));
		sqList.add(new Square(5));
		sqList.add(new Square(4));
		sqList.add(new Square(2));
		sqList.add(new Square(1));
		sqList.add(new Square(6));
		
		Collections.sort(sqList);
		System.out.println(sqList);


	}

}
