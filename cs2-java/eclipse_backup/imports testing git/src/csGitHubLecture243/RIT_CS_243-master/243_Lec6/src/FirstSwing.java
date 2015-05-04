/**
 * FirstSwing.java
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

public class FirstSwing
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("First Swing GUI");
		// System.out.println("Is it visible? " + frame.isVisible());
		frame.setSize(400,300);
		frame.setLocation(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(new GridLayout(3,3,5,5));
		//frame.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4);
		//frame.setLayout(new BorderLayout());
		
		// get the content pane
		// don't have to use the content pane, we can add directly to the pane
		Container con = frame.getContentPane();
		
		// first button
		JButton jb1 = new JButton("Press Me");
		jb1.setSize(100,200);
		jb1.setLocation(200, 0);
		jb1.setForeground(Color.BLUE);
		con.add(jb1);
		
		// second button
		JButton jb2 = new JButton("Press Me Also");
		jb2.setSize(100,200);
		jb2.setLocation(300, 0);
		con.add(jb2);
		
		// add a text field
		JTextField text = new JTextField(10);
		text.setText("Default test");
		text.setSize(100, 100);
		text.setEditable(false);
		con.add(text);
		
		// add a label
		JLabel label = new JLabel("Just a label");
		con.add(label);
		
		frame.setVisible(true);
	}

}
