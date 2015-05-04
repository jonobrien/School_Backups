/**
 * Driver.java
 *
 * File:
 *	$Id:
 *
 * Revisions:
 *	$Log:
 *
 */

/**
 * Creates a collection of objects and then operates on them
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Driver
{

	/**
	 * Main class
	 * @param args System arguments unused
	 */
	public static void main(String[] args)
	{
		ArrayList<Person> people = new ArrayList<Person>();
		Scanner input = new Scanner(System.in);
		int choice,tempAge;
		String tempFirst,tempLast;
		
		while (true)
		{
			System.out.println("List of options: ");
			System.out.println("1:\tNew Person");
			System.out.println("2:\tFind persons below age 20");
			System.out.println("3:\tQuit");
			choice = input.nextInt();
			
			switch (choice)
			{
				case 1:
					System.out.println("Enter First Name: ");
					tempFirst = input.next();
					System.out.println("Enter Last Name: ");
					tempLast = input.next();
					System.out.println("Enter Age: ");
					tempAge = input.nextInt();
					people.add(new Person(tempFirst, tempLast, tempAge));
					break;
				case 2:
					for (Person p : people)
					{
						if (p.getAge() < 20)
						{
							System.out.println("\t" + p);
						}
					}
					break;
				case 3:
					//return;
					System.exit(1);
					break;
				default:
					break;
			}
		}
		

	}

}
