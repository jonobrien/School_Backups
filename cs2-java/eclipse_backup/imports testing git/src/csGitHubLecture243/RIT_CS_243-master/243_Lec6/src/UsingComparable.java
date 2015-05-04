/**
 * UsingComparable.java
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

public class UsingComparable implements Comparable <UsingComparable>, Comparator<UsingComparable>
{
	private String name;
	private int age;
	
	public UsingComparable(String n, int a)
	{
		name = n;
		age = a;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return name + ": " + age;
	}
	
	
	// Total ordering of the data => we don't want objects that aren't equal being considered equal
	public int compareTo(UsingComparable b)
	{
		if (getAge() - b.getAge() == 0)
		{
			return getName().compareTo(b.getName());
		}
		else
		{
			return getAge() - b.getAge();
		}
	}
	
	public int compare(UsingComparable uc1, UsingComparable uc2)
	{
		return (uc1.getName().charAt(1) - uc2.getName().charAt(1));
	}
	
	public static void main(String[] args)
	{
		ArrayList<UsingComparable> uc = new ArrayList<UsingComparable>();
		
		uc.add(new UsingComparable("Joe", 12));
		uc.add(new UsingComparable("Tim", 19));
		uc.add(new UsingComparable("Jack", 50));
		uc.add(new UsingComparable("Amy", 5));
		
		Collections.sort(uc);
		
		System.out.println("ArrayList: " + uc);
		
		//the Comparator can be the same class (UsingComparable) or a different one (UsingComparator)
		Collections.sort(uc, new UsingComparable("Joe", 12));
		System.out.println(uc);
		
		
		HashSet<UsingComparable> hc = new HashSet<UsingComparable>();
		
		hc.add(new UsingComparable("Joe", 12));
		hc.add(new UsingComparable("Tim", 19));
		hc.add(new UsingComparable("Jack", 50));
		hc.add(new UsingComparable("Amy", 5));
		hc.add(new UsingComparable("Amy", 5));

		
		System.out.println("HashSet: " + hc);
		
		TreeSet<UsingComparable> tc = new TreeSet<UsingComparable>();
		
		tc.add(new UsingComparable("Joe", 12));
		tc.add(new UsingComparable("Tim", 19));
		tc.add(new UsingComparable("Jack", 50));
		tc.add(new UsingComparable("Amy", 5));
		tc.add(new UsingComparable("Amy", 5));
		tc.add(new UsingComparable("Kimmy", 5));

		
		System.out.println("TreeSet: " + tc);

	}
	
	public boolean equals(Object o)
	{
		if (! (o instanceof UsingComparable))
		{
			return false;
		}
		else
		{
			UsingComparable uc = (UsingComparable)o;
			if (uc.toString().equals(toString()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public int hashCode()
	{
		return this.toString().hashCode();
	}

}
