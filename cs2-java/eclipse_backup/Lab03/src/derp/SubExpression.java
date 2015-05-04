package derp;

/*
 * SubExpression.java
 * 
 * Version:
 * $id$
 * 
 * Revisions:
 * $log$
 * 
 *
 */


/**
 * Generates code for the Subtract Expression used by Interp.java
 * @author Jon O'Brien
 *
 */
public class SubExpression implements Expression {

	/**
	 * first expression:
	 */
	private Expression Ex1;

	/**
	 * second expression:
	 */
	private Expression Ex2;

	/**
	 * Constructs the Subtract Expression from the 2 supplied part(s)
	 * 
	 * @param Expr1
	 *            First supplied part
	 * @param Expr2
	 *            Second supplied part
	 * 
	 */
	public SubExpression(Expression Exp1, Expression Exp2) {
		Ex1 = Exp1;
		Ex2 = Exp2;
	}

	/**
	 * Creates code for the Subtract Expression The code is for the supplied part(s),
	 * with parenthesis when necessary, and the minus sign too.
	 * 
	 * @return String that represents the necessary expression
	 */

	public String emit() {
		return "(" + Ex1.emit() + " - " + Ex2.emit() + ")";

	}
	
	public Integer evaluate() {
		return Ex1.evaluate() - Ex2.evaluate();
	}

}

