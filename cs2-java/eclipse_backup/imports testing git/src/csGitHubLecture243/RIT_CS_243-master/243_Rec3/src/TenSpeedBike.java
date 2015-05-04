/**
 * TenSpeedBike.java
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

public class TenSpeedBike implements Bicycle
{
	private static final int MAX_SPEED = 40;
	private static final int MAX_GEAR = 10;
	private int speed;
	private int gear;
	
	public TenSpeedBike()
	{
		speed = 0;
		gear = 1;
	}

	public void speedUp(int i)
	{
		if (speed + i <= MAX_SPEED)
		{
			speed += i;
		}
	}

	public void slowDown(int i)
	{
		if (speed - i >= 0)
		{
			speed -= i;
		}
	}

	public void changeGear(boolean up)
	{
		if (up)
		{
			if (gear < MAX_GEAR)
			{
				gear++;
			}
		}
		else
		{
			if (gear > 0)
			{
				gear--;
			}
		}
	}
}
