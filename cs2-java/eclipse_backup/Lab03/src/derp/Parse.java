package derp;

/*
 * Parse.java
 * 
 * Version:
 * $id$
 * 
 * Revisions:
 * $log$
 * 
 *
 */

public class Parse 
{

private static int cursor = 0;

	public Parse()
	{
	}
/**
 * Parse over a prefix expression
 * @param s String that represents the expression
 * @return returns the Expression tree that represents the tokens or nulls.
 */
	public static Expression parseString(String s) {
		
		cursor = -1;
		return parseStringRec(s);
	}
/**
 * Recursive function to parse the Strings
 * @param s String that represents the expression
 * @param cursor the recursive level, keeps track of current position
 * @return returns the Expression tree that represents the tokens or nulls.
 */
	private static Expression parseStringRec(String s) {
		System.out.println(cursor);
		String [] strExpression = s.split("\\s+");
		cursor++;
		if (strExpression[cursor].matches("\\d+")) //if it is an integer
		{
			//adds an integer
			return new IntExpression(strExpression[cursor]);
	}
		else //it is an operator
		
		{
			if (strExpression[cursor].equals("+"))//addition operator found
			{
				return new AddExpression(parseStringRec(s), parseStringRec(s));
			}
			else if (strExpression[cursor].equals("-"))//subtraction operator found
			{
				return new SubExpression(parseStringRec(s), parseStringRec(s));
			}
			else if (strExpression[cursor].equals("*"))//multiplication operator found
			{
				return new MulExpression(parseStringRec(s), parseStringRec(s));
			}
			else//anything else
			{
				System.out.println("Incorrect String " + strExpression[cursor]);
			}
		}
		
		return new IntExpression("0");
	
	}
	
}
