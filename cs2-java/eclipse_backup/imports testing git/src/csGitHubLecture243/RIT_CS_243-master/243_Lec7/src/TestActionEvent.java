/**
 * TestActionEvent.java
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
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class TestActionEvent extends JFrame
{
	private JButton button1;
	private JButton button2;
	private ButtonListener outerclass;
	private ButtonListener2 buttonlistener;
	private OurMouseListener m;
	private OurWindowListener w;
	
	public TestActionEvent()
	{
		buttonlistener = new ButtonListener2(); 
		ActionListener anonlistener = new ActionListener() {public void actionPerformed(ActionEvent event)
		{
			if (event.getSource().equals(button1))
			{
				System.out.println("Button 1 was pressed");
			}
			else
			{
				System.out.println("Button 2 was pressed");
			}
		}};
		
		w = new OurWindowListener();

		m = new OurMouseListener();
		button1 = new JButton("Button 1");
		button1.addActionListener(buttonlistener);
		button1.addMouseListener(m);
		button2 = new JButton("Button 2");
		button2.addActionListener(buttonlistener);
		button2.addMouseListener(m);
		
	}
	
	public void action()
	{
		add(button1);
		add(button2);
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(w);
	}
	public static void main(String[] args)
	{
		TestActionEvent s = new TestActionEvent();
		s.action();
	}
	
	// Inner class defined within the class
	class ButtonListener2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource().equals(button1))
			{
				System.out.println("Button 1 was pressed");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Button 2 was pressed");
				System.out.println("Button 2 was pressed");
			}
		}

	}
	class OurMouseListener extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			Object button = e.getSource();
			if (button instanceof JButton)
			{
				((JButton)button).setBackground(Color.RED);
			}
		}
	}
	
	class OurWindowListener extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			TestActionEvent t = (TestActionEvent)e.getSource();
			int n = JOptionPane.showConfirmDialog(t, "Do you really want to close?", "Window closing message", JOptionPane.OK_CANCEL_OPTION);
			
			if (n == JOptionPane.CLOSED_OPTION)
			{
				t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
	}
}
