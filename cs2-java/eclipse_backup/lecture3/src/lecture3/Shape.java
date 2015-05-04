/**
 * Shape Interface
 * @author Jon O'Brien
 * 
 * 
 * Notes:
 * 1) sybtax is similar to class def, but uses interface
 * 2) inside the inteface:
 * 		a) public methods - the contract, any implemeting class 
 * 			must promise to implement these methods
 * 		b) public, static, final fields (constants)
 * 3) our interface defines a reference type (just like class defs do)
 * 4) interface can NOT be instatiated, no interface objects
 */
package lecture3;

public interface Shape {

	/**
	 * Method to compute area
	 */
	
	public double area();
	
	/**
	 * method to compute perimeter
	 * 
	 */
	
	public double perimeter();
	
	
}

