/**
 * AddressBook.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * AddressBook GUI
 * ViewController
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddressBook extends JFrame
{
	private JList contactList;
	private ContactModel model;
	private JTextField updateText;
	private JTextField search;
	
	/**
	 * Default constructor
	 */
	public AddressBook(ContactModel c)
	{
		// Set JFrame layout
		setLayout(new BorderLayout());
		
		// Initialize model
		model = c;
		
		// Build JList from model
		contactList = new JList(model.getPeople());
		
		// Build a top JPanel
		JPanel top = new JPanel(new GridLayout(2,1));
		
		// Build main menu bar
		JMenuBar mbar = new JMenuBar();
		
		// Build action menu and components
		JMenu actionMenu = new JMenu("Action");
		
		// Build add button with listener and add
		JMenuItem addbutton = new JMenuItem("Add");
		addbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String newname = JOptionPane.showInputDialog("Enter contact name to add:");
				String newnumber = JOptionPane.showInputDialog("Enter contact number to add: 000-000-0000");
				model.addPerson(newname, newnumber);
				contactList.setListData(model.getPeople());
			}
		});
		actionMenu.add(addbutton);
		
		// Build delete button with listener and add
		JMenuItem deletebutton = new JMenuItem("Delete");
		deletebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (contactList.getSelectedValue() != null)
				{
					// Remove the person
					model.remove(Person.parsePerson(contactList.getSelectedValue().toString()));
					// Requery the model for the observed text
					model.search(search.getText());
					// Update view
					contactList.setListData(model.getPeople());
				}
			}
		});
		actionMenu.add(deletebutton);
		
		// Build exit button with listener and add
		JMenuItem exitbutton = new JMenuItem("Exit"); 
		exitbutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		actionMenu.add(exitbutton);

		
		// Add actionMenu to bar
		mbar.add(actionMenu);
		
		// Add bar to top panel
		top.add(mbar, BorderLayout.SOUTH);
		
		// Build a search field and add it to the top panel
		search = new JTextField();
		
		// Add search key listener
		search.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) {}

			public void keyReleased(KeyEvent e)
			{
				model.search(((JTextField) e.getSource()).getText());
				contactList.setListData(model.getPeople());
			}

			public void keyTyped(KeyEvent e) {}
		});
		top.add(search);
		
		// Build a JScroller Pane from the JList and add to mid panel
		JPanel mid = new JPanel(new BorderLayout());
		JScrollPane scroller = new JScrollPane(contactList);
		mid.add(scroller);
		
		// Build a JCheckBox with a listener and add to mid panel
		JCheckBox sort = new JCheckBox("Sort");
		sort.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e)
			{
				model.setSort(((AbstractButton)e.getSource()).isSelected());
				contactList.setListData(model.getPeople());
			}
			
		});
		mid.add(sort, BorderLayout.EAST);
		
		// Build lower JPanel
		JPanel lower = new JPanel(new FlowLayout());
		
		// Add JTextField to lower panel
		updateText = new JTextField();
		updateText.setPreferredSize(new Dimension(300,20));
		lower.add(updateText);
		
		// Add List Selection Listener
		contactList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (((JList)e.getSource()).getSelectedValue() != null)
				{
					updateText.setText(((JList)e.getSource()).getSelectedValue().toString());
				}
				else
				{
					updateText.setText("");
				}
			}
		});
		
		// Add update button to lower panel
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Update the model
				model.update(Person.parsePerson(contactList.getSelectedValue().toString()),Person.parsePerson(updateText.getText()));
				// Requery the model for the observed text
				model.search(search.getText());
				// Update view
				contactList.setListData(model.getPeople());
			}
		});
		lower.add(updateButton);

		// Add panels to view
		add(top, BorderLayout.NORTH);
		add(mid);
		add(lower, BorderLayout.SOUTH);
		
		// Set JFrame defaults
		setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Main
	 * @param args command line arguments not used
	 */
	public static void main(String[] args)
	{
		AddressBook mainBook = new AddressBook(new ContactModel()); 
	}
}
