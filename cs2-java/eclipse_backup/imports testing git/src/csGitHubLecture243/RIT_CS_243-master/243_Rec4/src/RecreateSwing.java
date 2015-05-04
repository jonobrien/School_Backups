/**
 * RecreateSwing.java
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
import javax.swing.*;

import java.awt.*;

public class RecreateSwing
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("main frame");
		frame.setSize(800,500);
		frame.setLocation(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JFrame buttons = new JFrame("button frame");
		buttons.setLayout(new GridLayout(5,5));
		
		for (int i = 0; i < 25; i++)
		{
			JButton jb1 = new JButton("Button"+i);
			buttons.add(jb1);
		}
		
		JFrame otherbuttons = new JFrame("other buttons");
		otherbuttons.setLayout(new FlowLayout());
		
		for (int i = 25; i <= 26; i++)
		{
			JButton jb1 = new JButton("Button"+i);
			otherbuttons.add(jb1, BorderLayout.CENTER);
		}
		
		frame.add(buttons.getContentPane(), BorderLayout.NORTH);
		frame.add(otherbuttons.getContentPane(), BorderLayout.SOUTH);
		
		System.out.println(BorderLayout.NORTH);
		frame.setVisible(true);
	}
}
