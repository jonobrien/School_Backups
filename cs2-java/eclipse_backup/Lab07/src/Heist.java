import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Heist.java
 *
 * File:
 *	$Id: Heist.java,v 1.6 2014/04/25 02:34:50 jvo7822 Exp $
 *
 * Revisions:
 *	$Log: Heist.java,v $
 *	Revision 1.6  2014/04/25 02:34:50  jvo7822
 *	Finished comments.
 *
 *	Revision 1.5  2014/04/24 14:14:42  jvo7822
 *	Fixed bottom of GUI, added comments.
 *
 *	Revision 1.4  2014/04/22 02:28:56  jvo7822
 *	Everything implemented, gui bottom still not fixed.
 *
 *	Revision 1.3  2014/04/21 02:26:42  jvo7822
 *	formatting changes.
 *
 *	Revision 1.2  2014/04/21 00:04:36  jvo7822
 *	fixed timer errors, nothing updates yet.
 *
 *	Revision 1.1  2014/04/20 23:44:05  jvo7822
 *	Added Heist class, implemented gui and added gui alarm aspects.
 *
 */

/**
 * This class relies on HeistModel.java to run the heist game
 * and this class constructs the gui and glays the game with
 * the use of HeistModel.java and Alarm.java, using a config file,
 * heist1.txt.
 * 
 * @author Jon O'Brien
 */
public class Heist extends JFrame implements ActionListener, Observer {
	
	//initialize elements of GUI
	HeistModel heistModel;
	JFrame frame = new JFrame("Heist Game");
	JButton emp = new JButton("EMP");
	JButton reset = new JButton("RESET");
	JLabel top = new JLabel();
	JPanel floor = new JPanel();
	Timer timer;
	JButton[] buttons;
	
	/**
	 * 
	 * @param heistModel - an instance of the heistmodel class HeistModel.java
	 * this constructor makes the gui
	 * and adds the grid buttons to an array for easy access throughout the class
	 * and completes the setup of the gui for use with ActionListeners
	 * and ActionEvents through ActionPerformed method.
	 */
	public Heist(final HeistModel heistModel) {	
		buttons = new JButton[heistModel.getDim()* heistModel.getDim()];
		this.heistModel = heistModel; 
		this.heistModel.addObserver(this);
		String moves = "Moves: " + heistModel.getMoveCount() + " ";
		top.setText(moves);
		
		//start the alarm timer
		timer =  new Timer(heistModel.getRefreshRate(), this); 
		timer.start();
		
		//makes the Heist GUI
		LayoutManager layout = new BorderLayout();
		frame.setLayout(layout);
		frame.add(top, BorderLayout.NORTH);
		
		//set content pane and borderlayout of frame
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		//create panel for each button in museum floor
		floor.setLayout(new GridLayout(heistModel.getDim(), heistModel.getDim()));
		
		List<Boolean> alarm = heistModel.getAlarms();
		for (int i=0; i<heistModel.getDim()*heistModel.getDim(); i++) {
			if(i == heistModel.getJewelsLocation() 
					&& heistModel.getAreJewelsStolen() == false) {
				ImageIcon jewels = new ImageIcon("Jewels.JPG");
				buttons[i] = new JButton(jewels);
				buttons[i].setBackground(Color.WHITE);
				buttons[i].setActionCommand(i + "");
				buttons[i].addActionListener(this);
				floor.add(buttons[i]);
			}
			else if(i == heistModel.getThiefLocation()) {
				//if he has no jewels
				if (heistModel.getAreJewelsStolen() == false) {
					ImageIcon thief1 = new ImageIcon("Thief.JPG");
					buttons[i] = new JButton(thief1);
					buttons[i].addActionListener(this);
					buttons[i].setActionCommand(i + "");
					buttons[i].setBackground(Color.WHITE);
					floor.add(buttons[i]);
				}
				else {//if he has jewels
					ImageIcon thief2 = new ImageIcon("Escape.JPG");
					buttons[i] = new JButton(thief2);
					buttons[i].addActionListener(this);
					buttons[i].setActionCommand(i + "");
					buttons[i].setBackground(Color.WHITE);
					floor.add(buttons[i]);
				}
			}
			else if (alarm.get(i)) {
				buttons[i] = new JButton();
				buttons[i].setActionCommand(i + "");
				buttons[i].setBackground(Color.BLUE);  
				buttons[i].addActionListener(this);
				floor.add(buttons[i]);
			}
			else {
				buttons[i] = new JButton();
				buttons[i].setBackground(Color.WHITE);
				buttons[i].setActionCommand(i + "");
				buttons[i].addActionListener(this);
				floor.add(buttons[i]);
			}
        }
	//added the panel to the container
		container.add(floor);
	//added the container to the frame
		frame.add(container);
	//set the bottom button line and add to frame -- with aligning
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel BottomRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottom.add(BottomRight, BorderLayout.EAST);
		emp.addActionListener(this);
		reset.addActionListener(this);
		JTextField start = new JTextField("ENTER / EXIT");
		bottom.add(start, BorderLayout.WEST);
		BottomRight.add(emp);
		BottomRight.add(reset);
		frame.add(bottom, BorderLayout.SOUTH);
	//set frame size and visibility, properly close
		frame.setSize(400,400);
		frame.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
	}//constructor

	
	/**
	 * The main method to create and run the game.
	 * @param args - used for starting the game
	 * @throws FileNotFoundException - when no config file is present
	 */
	public static void main(String[] args) throws FileNotFoundException {
	    if(args.length != 1) { 
	        String us = "Usage: java Heist <config-file>";
	        System.out.println(us);
	        return;
	    }
	    new Heist(new HeistModel(args[0]));
	}//main
	
		/**
		 * ActionEvent - used to determine the type of button pressed.  This method
		 * completes the actions that are requested when the button is pressed and the 
		 * actions include, but are not limited to: updating alarm patterns, updating the
		 * thief location, or using the emp/reset buttons.
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() instanceof JButton) {
				if (((JButton) event.getSource()).getText().equals("EMP")) {
					//if not used
					((JButton) event.getSource()).setEnabled(false);
					heistModel.disableAlarm();
				}
				else if (((JButton) event.getSource()).getText().equals("RESET")) {
					emp.setEnabled(true);
					heistModel.reset();
				}
				else {
					heistModel.selectCell(Integer.parseInt(event.getActionCommand()));
				}
			}
		    if (event.getSource() instanceof Timer) {
				heistModel.updateAlarmPattern();
			}
		}//actionPerformed
		
	/**
	 * The update method updates the gui and prints different text dependent on
	 * the movecount, the state of the game.  Update also checks for proper 
	 * icons being displayed and changes the color of the tiles in the grid as well.
	 */
	@Override
	public void update(Observable o, Object arg) {
		String moves = "Moves: " + heistModel.getMoveCount() + " ";
		String lost = "GAME OVER - ALARM TRIGGERED.";
		String won = "WINNER!";
		ImageIcon jewels = new ImageIcon("Jewels.JPG");
		ImageIcon thief = new ImageIcon("Thief.JPG");
		ImageIcon escape = new ImageIcon("Escape.JPG");
			//update buttons

		if (heistModel.getGameStatus() == 0) {
			//lost game
			top.setText(moves + lost);
		}
		if (heistModel.getGameStatus() == 2) {
			//won
			top.setText(moves + won);
		}
			List<Boolean> alarm = heistModel.getAlarms();
			for (int i=0; i<heistModel.getDim()*heistModel.getDim(); i++) {
				buttons[i].setIcon(null);
				if (alarm.get(i)) {
					//buttons[i].setActionCommand(i + "");
					buttons[i].setBackground(Color.BLUE);  
				}
				else {
					buttons[i].setBackground(Color.WHITE);
					//buttons[i].setActionCommand(i + "");
				}	
			}
			if  (heistModel.getGameStatus() == 1) {
				top.setText(moves);
			}
			if (!heistModel.getAreJewelsStolen()) {
				buttons[heistModel.getJewelsLocation()].setIcon(jewels);
				buttons[heistModel.getThiefLocation()].setIcon(thief);
			}
			else {
				buttons[heistModel.getThiefLocation()].setIcon(escape);
			}
			validate();
			
	}//update
}//end
