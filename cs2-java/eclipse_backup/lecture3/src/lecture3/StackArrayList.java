package lecture3;

import java.util.ArrayList;

public class StackArrayList<E> implements Stack<E> {

	//under the hood uses an ArrayLust to store data
	private ArrayList<E> theStack;
	
	public void push(E el) {
		theStack.add(0, el);
	}
	
	public E pop() {
		//really should check if empty first then pop
		return theStack.remove(0);
	}
	
	
	
}
