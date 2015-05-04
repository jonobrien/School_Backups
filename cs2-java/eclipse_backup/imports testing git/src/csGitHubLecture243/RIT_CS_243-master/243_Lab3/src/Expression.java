/**
 * Expression.java
 *
 * File:
 *	$Id: Expression.java,v 1.1 2013/03/20 18:43:47 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Expression.java,v $
 *	Revision 1.1  2013/03/20 18:43:47  njm7461
 *	Added operator expression classes
 *
 */

/**
 * Expression interface
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public interface Expression
{
	/**
	 * Causes evaluation of an expression
	 * @return An Integer, the value of the expression
	 */
	public String emit();
	
	/**
	 * Generates code for an expression
	 * @return A string that represents the code for the expression
	 */
	public Integer evaluate();

}
