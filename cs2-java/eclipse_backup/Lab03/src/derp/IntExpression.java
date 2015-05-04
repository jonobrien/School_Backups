package derp;

/*
 * IntExpression.java
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
 * @author Jon O'Brien
 * Generates Integer Expressions from Interp.java
 * 
 *
 */
public class IntExpression implements Expression{
	
	/**
	 * Holds integer value.
	 */
	private String value;
	
	
	
	/**
	 * creates an Int expression from supplied part(s)
	 * @param valString the integer string
	 */
	public IntExpression(String valString) {
		value = valString;
	}
	
	/**
	 * creates code for Int expression required.
	 */
	public String emit() {
		return value;
	}
	
	/**
	 * evaluates Int expression.
	 */
	public Integer evaluate() {
		return Integer.parseInt(value);
	}
	
	
	
	

	
}
