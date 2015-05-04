import java.util.ArrayList;

/**
 * MyGenericQueue.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

/**
 * A hello world program in Java.
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class MyGenericQueue <E> implements Queue <E>
{
	private ArrayList <E> que;
	
	public MyGenericQueue()
	{
		que = new ArrayList <E> ();
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		return que.get(0);
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return que.remove(0);
	}

	@Override
	public boolean enqueue(E e) {
		// TODO Auto-generated method stub
		return que.add(e);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (que.size() == 0);
	}

}
