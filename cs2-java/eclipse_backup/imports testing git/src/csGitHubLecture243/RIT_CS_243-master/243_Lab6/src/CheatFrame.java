/**
 * CheatFrame.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * CheatFrame Class
 * Class definition for the cheating window in a concentration card game.
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.util.ArrayList;

public class CheatFrame extends JFrame
{	
	/**
	 * Construct a CheatFrame object
	 * @param cardButtons An ArrayList of CardButtons that are all showing their numbers
	 * @param size The size (of one side) of the board (measured in cards)
	 */
	public CheatFrame(ArrayList<CardButton> cardButtons, int size)
	{
		setLayout(new GridLayout(size,size));
		for (CardButton cb : cardButtons)
		{
			add(cb);
		}
		setSize(480,360);
		setVisible(true);
	}
}
