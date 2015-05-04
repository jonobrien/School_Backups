package lecture3;

public interface Stack<E>  {
//the E generalizes data types, any letter will do.  that says you have to specify types

	
	public E pop();
	
	public void push(E el);
	
	public E top();
	
	public boolean isEmpty();
	
	public int size();
}
