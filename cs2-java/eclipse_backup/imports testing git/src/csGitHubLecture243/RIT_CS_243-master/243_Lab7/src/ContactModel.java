/**
 * ContactModel.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * ContactModel Class
 * Maintains information about many contacts
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ContactModel
{
	// Collection of Person objects
	private ArrayList<Person> people;
	// Collection of Person objects that were searched for
	private ArrayList<Person> selected;
	// Boolean to represent if the contacts are supposed to be sorted
	private boolean sort;
	
	/**
	 * Default constructor adds Contacts into the People ArrayList
	 */
	public ContactModel()
	{
		// Initialize main contact ArrayList
		people = new ArrayList<Person>();
		
		// Populate people list
		for (int i = 0; i < Contacts.peopleNames.length; i++)
		{
			people.add(new Person(Contacts.peopleNames[i], Contacts.peopleNumbers[i]));
		}
		
		// Initialize selected ArrayList
		selected = new ArrayList<Person>(people);

		// Not initially sorted
		sort = false;
	}

	/**
	 * Gets the array of people that have been selected
	 * @return array of People objects
	 */
	public Person[] getSelected()
	{
		return selected.toArray(new Person[selected.size()]);
	}

	/**
	 * Gets the sorted (or unsorted) array of people depending on sort
	 * @return a sorted or unsorted list of people
	 */
	public Person[] getPeople()
	{
		if (sort)
		{
			return getSorted();
		}
		else
		{
			return getSelected();
		}
	}
	
	/**
	 * Selects all people who match a specific string
	 * Both the user input and the raw person data are sterilized (no spaces or dashes)
	 * @param s search string
	 */
	public void search(String s)
	{
		if (!s.equals(""))
		{
			selected.clear();
			String searchStr = s.toLowerCase().replace("-", "").replace(" ", "");
			for (Person p : people)
			{
				if (p.getRaw().contains(searchStr))
				{
					select(p);
				}
			}
		}
		else
		{
			selected = new ArrayList<Person>(people);
		}
	}
	
	/**
	 * Add person to selected list
	 * @param p Person object to add
	 */
	public void select(Person p)
	{
		selected.add(p);
	}
	
	/**
	 * Removes a selected Person from the list
	 * @param p Person object to remove
	 */
	public void deselect(Person p)
	{
		selected.remove(p);
	}

	
	/**
	 * Gets the sorted, selected People
	 * @return selected, sorted Person array
	 */
	public Person[] getSorted()
	{
		Person [] sorted = getSelected();
		Arrays.sort(sorted);
		return sorted;
	}
	
	/**
	 * Sets the sort boolean
	 * @param s sort value to set
	 */
	public void setSort(boolean s)
	{
		sort = s;
	}
	
	/**
	 * Replaces one person for another in the list
	 * @param p1 Person to replace
	 * @param p2 Person with which to replace
	 */
	public void update(Person p1, Person p2)
	{
		int j = 0;
		for (int i = 0; i < people.size(); i++)
		{
			if (people.get(i).equals(p1))
			{
				j = i;
			}
		}
		people.set(j, p2);
	}
	
	/**
	 * Removes a person from the list
	 * @param p Person to remove
	 */
	public void remove(Person p)
	{
		people.remove(p);
	}

	/**
	 * Adds a person to the list
	 * @param name name of Person
	 * @param number Person's number
	 */
	public void addPerson(String name, String number)
	{
		people.add(new Person(name, number));
	}
}
