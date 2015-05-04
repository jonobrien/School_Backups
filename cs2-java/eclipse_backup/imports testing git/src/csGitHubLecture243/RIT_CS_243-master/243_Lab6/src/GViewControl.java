/**
 * GViewControl.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * GViewControl Class
 * Class definition for the graphical view and controller
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GViewControl extends JFrame implements Observer
{
	// The model for the view and controller
	private ConcentrationModel model;
	
	// An ArrayList of colors for the cards
	private ArrayList<Color> colors;
	
	// An ArrayList of colors to represent the cards
	private ArrayList<CardButton> cardButtons;
	
	// A JLabel to provide messages in the window
	private JLabel instLabel;
	
	// Lower buttons
	private JButton resetButton;
	private JButton cheatButton;
	private JButton undoButton;
	
	// A button listener that can distinguish between Cards and lower buttons
	private AllButtonListener blistener;
	
	// A button container to hold the objects
	private JPanel buttonContainer;

	/**
	 * Constructs a GViewControl with a specific model
	 * Adds color pairs into the color list
	 * Adds CardButtons into the list
	 * @param m model for the view and controller
	 */
	public GViewControl(ConcentrationModel m)
	{
		// Set layout
		setLayout(new BorderLayout());
		
		// Construct model and set the controller to observe the model
		model = m;
		model.addObserver(this);
		
		// Add Colors
		colors = new ArrayList<Color>();
		
		// Add Standard Pretties
		colors.add(Color.GREEN);
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.ORANGE);
		colors.add(Color.YELLOW);
		colors.add(Color.CYAN);
		colors.add(Color.LIGHT_GRAY);
		colors.add(Color.PINK);
		for (int j = 7; j < ConcentrationModel.NUM_CARDS; j++)
		{
			colors.add(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		}
		
		// Initialize JLabel and add to view
		instLabel = new JLabel("Status: ");
		add(instLabel, BorderLayout.NORTH);
		
		// Initialize Button Listener
		blistener = new AllButtonListener();
		
		// Make CardButtons and add them to the ArrayList with their listeners
		cardButtons = new ArrayList<CardButton>();
		for (int i = 0; i < ConcentrationModel.NUM_CARDS; i++)
		{
			CardButton cb = new CardButton(i);
			cb.addActionListener(blistener);
			cardButtons.add(cb);
		}
		
		// Make lower buttons container
		JPanel lowerButtons = new JPanel();
		lowerButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		// Create lower buttons
		resetButton = new JButton("Reset");
		cheatButton = new JButton("Cheat");
		undoButton = new JButton("Undo");
		
		// Add listeners to lower buttons
		resetButton.addActionListener(blistener);
		cheatButton.addActionListener(blistener);
		undoButton.addActionListener(blistener);

		
		// Add lower buttons to the LB container
		lowerButtons.add(resetButton);
		lowerButtons.add(cheatButton);
		lowerButtons.add(undoButton);
		
		// Add LB container to view
		add(lowerButtons,BorderLayout.SOUTH);
		
		// Initialize the button container and add it to the center of the frame
		buttonContainer = new JPanel();
		buttonContainer.setLayout(new GridLayout(ConcentrationModel.BOARD_SIZE, ConcentrationModel.BOARD_SIZE, 2, 2));
		add(buttonContainer);
		
		// Set title and set initial game parameters
		setTitle("Concentration Game");
		update(new Observable(), new Object());
		setSize(640,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Updates the window when the model indicates an update is required
	 * Update changes the color and string content of a CardButton based on the CardFaces in the model
	 * and it changes the text in the label based on the model state.
	 * @param t not used
	 * @param o not used
	 */
	public void update(Observable t, Object o)
	{
		// Set header label
		String labeltext = "Moves: " + model.getMoveCount() + " ";
		switch (model.howManyCardsUp())
		{
			case 0: labeltext += "Select the first card."; break;
			case 1: labeltext += "Select the second card."; break;
			case 2: labeltext += "No Match: Undo or select a card."; break;
		}
		instLabel.setText(labeltext);
		
		// All face up cards should be set up
		for (int i = 0; i < ConcentrationModel.NUM_CARDS; i++)
		{
			CardFace c = model.getCards().get(i);
			if (c.isFaceUp())
			{
				cardButtons.get(i).setBackground(colors.get(c.getNumber()));
				cardButtons.get(i).setText(c.getNumber() + "");
			}
			else
			{
				cardButtons.get(i).setBackground(Color.WHITE);
				cardButtons.get(i).setText("");
			}
		}
		
		// Clear the container
		buttonContainer.removeAll();
		
		// Add cards to container
		for (CardButton b : cardButtons)
		{
			buttonContainer.add(b);
		}
	}
	
	/**
	 * AllButtonListener
	 * Listens to card buttons and lower buttons
	 * @author Nic Manoogian
	 */
	class AllButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() instanceof CardButton)
			{
				CardButton c = (CardButton)event.getSource();
				model.selectCard(c.getPos());
			}
			else if (event.getSource().equals(resetButton))
			{
				model.reset();
			}
			else if (event.getSource().equals(cheatButton))
			{
				ArrayList<CardButton> cheatButtons = new ArrayList<CardButton>();
				// Generate ArrayList of CardButtons
				ArrayList<CardFace> cheatmodel = model.cheat();
				for (int i = 0; i < ConcentrationModel.NUM_CARDS; i++)
				{
					CardFace cf = cheatmodel.get(i);
					CardButton cb = new CardButton(i);
					cb.setBorderPainted(false);
					cb.setContentAreaFilled(false);
					cb.setOpaque(true);
					cb.setBackground(colors.get(cf.getNumber()));
					cb.setText(cf.getNumber()+"");
					cheatButtons.add(cb);
				}
				// Make a CheatFrame with the ArrayList
				 CheatFrame cheater = new CheatFrame(cheatButtons,ConcentrationModel.BOARD_SIZE);
				
			}
			else if (event.getSource().equals(undoButton))
			{
				model.undo();
			}
		}
	}
	
	/**
	 * Main method used to play the game
	 * @param args arguments not used
	 */
	public static void main(String[] args)
	{
		GViewControl gview = new GViewControl(new ConcentrationModel());
	}
}
