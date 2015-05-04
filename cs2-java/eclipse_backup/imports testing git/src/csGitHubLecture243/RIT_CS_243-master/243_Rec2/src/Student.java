/**
 * Student.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * Student class
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Student
{
	private static int id = 1; // Static => does not change between instances
	private int myId; // Not static => specific for all instances
	private String name;
	
	public Student(String name)
	{
		this.name = name;
		this.myId = id++;
	}

}
