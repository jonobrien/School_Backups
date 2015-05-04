/**
 * UsingComparator.java
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

public class UsingComparator implements Comparator<UsingComparable>
{
	//Sort by second letter
	public int compare(UsingComparable uc1, UsingComparable uc2)
	{
		return (uc1.getName().charAt(1) - uc2.getName().charAt(1));
	}

}
