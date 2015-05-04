/**
 * Parse.java
 *
 * File:
 *	$Id: Parse.java,v 1.2 2013/03/20 22:45:17 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Parse.java,v $
 *	Revision 1.2  2013/03/20 22:45:17  njm7461
 *	Removed old imports
 *
 *	Revision 1.1  2013/03/20 20:56:43  njm7461
 *	Added Parse and helper recursion function
 *
 */

/**
 * A container for the static methods to parse interp expressions
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Parse
{
	public Parse()
	{
	}
	
	/**
	 * Parse a prefix expression
	 * @param s String representing the expression
	 * @return An Expression tree representing the token stream, or null
	 */
	public static Expression parseString(String s)
	{
		return parseStringRec(s, 0);
	}
	
	/**
	 * Helper recursion function for String parser
	 * @param s String representation of the expression
	 * @param curs Depth of recursion, location of cursor
	 * @return An Expression tree representing the token stream, or null
	 */
	private static Expression parseStringRec(String s, int curs)
	{
		String [] strExp = s.split("\\s+");
		if (strExp[curs].matches("\\d+")) 	// Looking an an integer
		{
			//System.out.println("adding an int");
			return new IntExpression(strExp[curs]);
		}
		else							// Looking at an operator
		{
			if (strExp[curs].equals("+"))
			{
				//System.out.println("adding a plus");
				return new AddExpression(parseStringRec(s, curs + 1), parseStringRec(s, curs + 2));
			}
			else if (strExp[curs].equals("-"))
			{
				//System.out.println("adding a minus");
				return new SubExpression(parseStringRec(s, curs + 1), parseStringRec(s, curs + 2));
			}
			else if (strExp[curs].equals("*"))
			{
				//System.out.println("adding a mul");
				return new MulExpression(parseStringRec(s, curs + 1), parseStringRec(s, curs + 2));
			}
			else
			{
				System.out.println("Malformed string " + strExp[curs]);
			}
		}
		return new IntExpression("0");
	}

}
