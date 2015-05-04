/**
 * SubExpression.java
 *
 * File:
 *	$Id: SubExpression.java,v 1.1 2013/03/20 18:43:47 njm7461 Exp $
 *
 * Revisions:
 *	$Log: SubExpression.java,v $
 *	Revision 1.1  2013/03/20 18:43:47  njm7461
 *	Added operator expression classes
 *
 */

/**
 * Represents subtraction expressions in Interp
 * Instances differ by the expressions whose values are to be subtracted
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class SubExpression implements Expression
{
	/**
	 * First expression
	 */
	private Expression ex1;
	/**
	 * Second expression
	 */
	private Expression ex2;
	
	/**
	 * Construct an Sub expression from the supplied subexpressions
	 * @param exp1 First subexpression
	 * @param exp2 Second subexpression
	 */
	public SubExpression(Expression exp1, Expression exp2)
	{
		ex1 = exp1;
		ex2 = exp2;
	}


	/**
	 * Generates code for an Subtraction expression
	 * The code is the code for each subexpression, surrounded by parentheses with a minus sign in between
	 * @return A string that represents the code for the expression
	 */
	public String emit()
	{
		return "("+ex1.emit()+" - "+ex2.emit()+")";
	}

	/**
	 * Causes evaluation of an Sub expression
	 * The value is the difference of the values of the subexpressions
	 * @return An Integer, the difference of the values of the sub-expressions
	 */
	public Integer evaluate()
	{
		return ex1.evaluate()-ex2.evaluate();
	}
	

}