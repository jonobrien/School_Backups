/**
 * Person.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * Person Class
 * Holds information about a contact
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Person implements Comparable<Person>
{
	// Contact name
	private String name;
	// Contact number
	private String number;
	
	/**
	 * Constructs a person with a given name and number
	 * @param n name
	 * @param num number
	 */
	public Person(String n, String num)
	{
		name = n;
		number = num;
	}
	
	/**
	 * Constructs and "empty" person
	 */
	public Person()
	{
		this("", "");
	}
	
	/**
	 * Gets the contact name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the contact number
	 * @return number
	 */
	public String getNumber()
	{
		return number;
	}
	
	/**
	 * Sets the contact name
	 * @param s name to set
	 */
	public void setName(String s)
	{
		name = s;
	}
	
	/**
	 * Sets the contact number
	 * @param s number to set
	 */
	public void setNumber(String s)
	{
		number = s;
	}

	/**
	 * Returns the String representation of a person
	 */
	public String toString()
	{
		return name + " : " + number;
	}

	/**
	 * Compares the names and then the numbers
	 */
	public int compareTo(Person p)
	{
		if (this.getName().equals(p.getName()))
		{
			return this.getNumber().compareTo(p.getNumber());
		}
		else
		{
			return this.getName().compareTo(p.getName());
		}
	}
	
	/**
	 * Two contacts are equal if they have the same string representation
	 */
	public boolean equals(Object o)
	{
		if (o instanceof Person)
		{
			return toString().equals(o.toString());
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Gets "raw" person data for query
	 * @return all lower case name and number with no spaces or dashes
	 */
	public String getRaw()
	{
		return name.toLowerCase()+number.replace("-", "").replace(" ", "");
	}
	
	/**
	 * Returns a Person from a String representation
	 * @param s String to parse
	 * @return A Person object
	 */
	public static Person parsePerson(String s)
	{
		String name = s.split(" : ")[0];
		String number = s.split(" : ")[1];
		return new Person(name, number);
	}
}
