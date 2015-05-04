/**
 * IntExpression.java
 *
 * File:
 *	$Id: IntExpression.java,v 1.1 2013/03/20 20:56:44 njm7461 Exp $
 *
 * Revisions:
 *	$Log: IntExpression.java,v $
 *	Revision 1.1  2013/03/20 20:56:44  njm7461
 *	Added Parse and helper recursion function
 *
 */

/**
 * Represents integer expressions in Interp
 * Instances differ by the integer
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class IntExpression implements Expression
{
	/**
	 * Holds the value of the integer expression
	 */
	private String value;

	/**
	 * Construct an Int expression from the supplied string
	 * @param valString The form the integer was written
	 */
	public IntExpression(String valString)
	{
		value = valString;
	}
	
	/**
	 * Generates code for an Int expression
	 * The code is the valString (the digits that were used to write it) of the int.
	 */
	public String emit()
	{
		return value;
	}

	/**
	 * Causes evaluation of an Int expression. The value is its number.
	 */
	public Integer evaluate()
	{
		return Integer.parseInt(value);
	}

}
