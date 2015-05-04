/**
 * AddExpression.java
 *
 * File:
 *	$Id: AddExpression.java,v 1.1 2013/03/20 18:43:47 njm7461 Exp $
 *
 * Revisions:
 *	$Log: AddExpression.java,v $
 *	Revision 1.1  2013/03/20 18:43:47  njm7461
 *	Added operator expression classes
 *
 */

/**
 * Represents addition expressions in Interp
 * Instances differ by the expressions whose values are to be added
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class AddExpression implements Expression
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
	 * Construct an Add expression from the supplied subexpressions
	 * @param exp1 First subexpression
	 * @param exp2 Second subexpression
	 */
	public AddExpression(Expression exp1, Expression exp2)
	{
		ex1 = exp1;
		ex2 = exp2;
	}


	/**
	 * Generates code for an Add expression
	 * The code is the code for each subexpression, surrounded by parentheses with a plus sign in between
	 * @return A string that represents the code for the expression
	 */
	public String emit()
	{
		return "("+ex1.emit()+" + "+ex2.emit()+")";
	}

	/**
	 * Causes evaluation of an Add expression
	 * The value is the sum of the values of the subexpressions
	 * @return An Integer, the sum of the values of the sub-expressions
	 */
	public Integer evaluate()
	{
		return ex1.evaluate()+ex2.evaluate();
	}
	

}
