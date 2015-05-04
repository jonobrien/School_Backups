

/**
 * CardButton.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * CardButton Class
 * Class definition for a button that represents a card in the concentration game
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import javax.swing.JButton;

public class CardButton extends JButton
{
	private int position;
	
	/**
	 * Construct a CardButton object
	 * @param pos The position or index of the represented card in the model
	 */
	public CardButton(int pos)
	{
		position = pos;
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setSize(100,100);
	}
	
	/**
	 * Get the position of the card
	 * @return An integer that is the position or index of the represented card in the model
	 */
	public int getPos()
	{
		return position;
	}

}
