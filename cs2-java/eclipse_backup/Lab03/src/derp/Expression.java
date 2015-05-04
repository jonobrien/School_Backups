package derp;

/*
 * Expression.java
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
 * Interface for the Expression
 * @author Jon O'Brien
 *
 */
public interface Expression {

	
	
	/**
 * This evaluates the expressions that are input
 * @return an Integer, the evaluated expression
 */
	public String emit();
	
	/**
	 * Creates code for the expressions
	 * @return String that represents the expression
	 */
	public Integer evaluate();
}
