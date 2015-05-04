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
 *	$Id: Heist.java,v 1.3 2014/04/21 02:26:42 jvo7822 Exp $
 *
 * Revisions:
 *	$Log: Heist.java,v $
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

//TODO
//need to fix gui bottom part
//need to be able to move thief
//need to update game being lost with alarm switching to current thief position
//need to update game being lost with alarm being clicked on
//need to update game with thief moving, jewels being picked up, winning game
//need to update move count and print loss conditions


public class Heist extends JFrame implements ActionListener, Observer {
	
	//initialize elements of GUI
	HeistModel heistModel;
	JFrame frame = new JFrame("Heist Game");
	JLabel top = new JLabel();
	JPanel floor = new JPanel();
	Timer timer;
	JButton[] buttons;
	
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
		//add 16 buttons for the floor, alarms too
		/*for (int i=0; i<heistModel.getDim()*heistModel.getDim(); i++) {
			JButton tile = new JButton();
			tile.setBackground(Color.WHITE);
			tile.setActionCommand(i + "");
			tile.addActionListener(this);
			floor.add(tile);
		}*/
		List<Boolean> alarm = heistModel.getAlarms();
		for (int i=0; i<heistModel.getDim()*heistModel.getDim(); i++) {
			if(i == heistModel.getJewelsLocation() && heistModel.getAreJewelsStolen() == false) {//TODO might need one later on for fixing when he picks up jewels
				ImageIcon jewels = new ImageIcon("Jewels.JPG");
				buttons[i] = new JButton(jewels);
				buttons[i].setBackground(Color.WHITE);
				buttons[i].addActionListener(this);
				floor.add(buttons[i]);
			}
			else if(i == heistModel.getThiefLocation()) {
				//if he has no jewels
				if (heistModel.getAreJewelsStolen() == false) {
					ImageIcon thief1 = new ImageIcon("Thief.JPG");
					buttons[i] = new JButton(thief1);
					buttons[i].addActionListener(this);
					buttons[i].setBackground(Color.WHITE);
					floor.add(buttons[i]);
				}
				else {//if he has jewels
					ImageIcon thief2 = new ImageIcon("Escape.JPG");
					buttons[i] = new JButton(thief2);
					buttons[i].addActionListener(this);
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
	/*set the bottom button line and add to frame -- without aligning */
		JPanel bottom = new JPanel(new BorderLayout());
		JButton emp = new JButton("emp");
		JButton reset = new JButton("reset");
		JTextField start = new JTextField("ENTER / EXIT");
		bottom.add(start, BorderLayout.WEST);
		bottom.add(emp,BorderLayout.CENTER);
		bottom.add(reset,BorderLayout.EAST);
		frame.add(bottom, BorderLayout.SOUTH);
	//set frame size and visibility, properly close
		frame.setSize(400,400);
		frame.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 		
	}//constructor

	public static void main(String[] args) throws FileNotFoundException {
	    if(args.length != 1) { 
	        String us = "Usage: java Heist <config-file>";
	        System.out.println(us);
	        return;
	    }
	    new Heist(new HeistModel(args[0]));
	}
	
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() instanceof JButton) {
				if (((JButton) event.getSource()).getText().equals("emp")) {
					//if not used
					heistModel.disableAlarm();
				}
				else if (((JButton) event.getSource()).getText().equals("reset")) {
					heistModel.reset();
				}
				else {
					heistModel.selectCell(Integer.parseInt(event.getActionCommand()));
				}
			}
			else if (event.getSource() instanceof Timer) {
				heistModel.updateAlarmPattern();
			}
		}//actionPerformed
		
	@Override
	public void update(Observable o, Object arg) {
		String moves = "Moves: " + heistModel.getMoveCount() + " ";
		String lost = "GAME OVER - ALARM TRIGGERED.";
		
		
			//update buttons
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
				
				if (heistModel.getGameStatus() == 0) {
					//lost game
					top.setText(moves + lost);
				}
				if (heistModel.getGameStatus() == 2) {//gameStatus == 2
					//won
					String won = "YOU WON!";
					top.setText(moves + won);
				}
				
				else {
					top.setText(moves);
				}
				//if !jewels stolen
				//set jewels location to jewels icon
				//set thief icon to thief icon
				
				//else set thief to escape
				//validate
				
				validate();
				
				
				
				
				/*
				
				if(i == heistModel.getJewelsLocation() && heistModel.getAreJewelsStolen() == false) {
					ImageIcon jewels = new ImageIcon("Jewels.JPG");
					//buttons[i] = new JButton(jewels);
					buttons[i].setIcon(jewels);
					buttons[i].setBackground(Color.WHITE);
				}
				else if(i == heistModel.getThiefLocation()) {
					//if he has no jewels
					if (heistModel.getAreJewelsStolen() == false) {
						ImageIcon thief1 = new ImageIcon("Thief.JPG");
						buttons[i].setIcon(thief1);
						buttons[i].setBackground(Color.WHITE);
					}
					else {//if he has jewels
						ImageIcon thief2 = new ImageIcon("Escape.JPG");
						//JButton thief2W = new JButton(thief2);
						buttons[i].setIcon(thief2);
						buttons[i].setBackground(Color.WHITE);
					}
				}
				else if (alarm.get(i)) {
					buttons[i].setActionCommand(i + "");
					buttons[i].setBackground(Color.BLUE);  
				}
				else {
					buttons[i].setBackground(Color.WHITE);
					buttons[i].setActionCommand(i + "");
				}
	        }
		}
		
		//1 update moves
		//0 lost 
		//2 won
		*/
}//end
