import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * ButtonListener.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * 
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class ButtonListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The " + e.getActionCommand() + " button was clicked on " + new Date(e.getWhen()));
	}
}
