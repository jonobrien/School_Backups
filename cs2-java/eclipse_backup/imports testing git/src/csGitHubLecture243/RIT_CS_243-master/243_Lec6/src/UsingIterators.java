/**
 * UsingIterators.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * 
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.*;
public class UsingIterators
{

	/**
	 * @param args command line arguments not used
	 */
	public static void main(String[] args)
	{
		LinkedList<Integer> lst = new LinkedList<Integer>();
		
		for (int i = 100; i < 110; i++)
		{
			lst.add(i);
		}
		
		Iterator<Integer> iter = lst.iterator();
		
		//can't remove unless element is processed
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
			iter.remove();
		}
		System.out.println("Size: " + lst.size());
		
		
//		Can't change uless remove is used
//		int counter = 0;
//		for(Iterator<Integer> it = lst.iterator();it.hasNext(); )
//		{
//			System.out.println(it.next());
//			counter++;
//			if (counter == 4)
//			{
//				lst.add(12345);
//			}
//		}

	}

}
