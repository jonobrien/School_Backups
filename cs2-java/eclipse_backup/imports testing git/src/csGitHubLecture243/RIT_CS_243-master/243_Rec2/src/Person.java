/**
 * Person.java
 *
 * File:
 *	$Id: Person.java,v 1.1 2013/03/15 19:34:06 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Person.java,v $
 *	Revision 1.1  2013/03/15 19:34:06  njm7461
 *	Initial commit
 *
 */

/**
 * A class representing a person with a name and age
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Person
{
	/**
	 * First Name as a String
	 */
	private String firstName;
	/**
	 * Last Name as a String
	 */
	private String lastName;
	/**
	 * Age as an int
	 */
	private int age;
	
	/**
	 * Constructs a default person - John Doe, age 0
	 */
	public Person()
	{
		firstName = "John";
		lastName = "Doe";
		age = 0;
	}
	
	/**
	 * Creates a person with specifications
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param age Age
	 */
	public Person(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * @return First Name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/** 
	 * @return Last Name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * @return Age
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Sets the full name of a person, separated by a space
	 * @param name Full name
	 */
	public void setName(String name)
	{
		String[] splits = name.split(" ");
		firstName = splits[0];
		lastName = splits[1];
	}
	
	/**
	 * Returns a String representation of a Person
	 */
	public String toString()
	{
		return "Name: " + firstName + " " + lastName + ", Age: " + age;
	}
	
	/**
	 * Compares two Person objects
	 */
	public boolean equals(Object person)
	{
		return (((Person) person).getFirstName() == firstName && ((Person) person).getLastName() == lastName && ((Person) person).getAge() == age);
	}
	
}
