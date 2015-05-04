/*
 * MicrowaveUI.java
 *
 * $Id$
 *
 * $Log$
 */

/*
 * Demonstrates an inner class listener that responds to
 * button presses.
 *
 * @author: Liang, Ex 11.4
 * @author: Sean Strout
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MicrowareUI2 extends JFrame {
    private JTextField textField;
    
    public MicrowareUI2() {
        // Set the border layout for the frame
        setLayout(new BorderLayout());

        // Create panel1 for the button and
        // use a grid layout
        JPanel panel1 = new JPanel();
        //panel1.setOpaque(true);
        panel1.setLayout(new GridLayout(4, 3));

        // create ButtonListener
        ButtonListener listener = new ButtonListener();

        // Add buttons to the panel
        for (int i=1; i<10; i++) {
            JButton button = new JButton("" + i);
            button.setForeground(Color.BLACK);  
            button.addActionListener(listener);
            panel1.add(button);
        }

        JButton button = new JButton("0");
        button.addActionListener(listener);
        button.setForeground(Color.BLACK);
        panel1.add(button);

        button = new JButton("Start");
        button.setForeground(Color.GREEN);
        button.addActionListener(listener);
        panel1.add(button);

        button = new JButton("Stop");
        button.setForeground(Color.RED);
        button.addActionListener(listener);
        panel1.add(button);

        // Create panel2 to hold a text field and panel1
        JPanel panel2 = new JPanel(new BorderLayout());
        textField = new JTextField();
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.BLACK);
        panel2.add(textField,BorderLayout.NORTH);
        panel2.add(panel1, BorderLayout.CENTER);

        // Add panel2 and a button to the frame
        add(panel2, BorderLayout.EAST);
        button = new JButton("Food to be placed here");
        button.setForeground(Color.RED);
        button.addActionListener(listener);
        add(button, BorderLayout.CENTER);

        // set frame appearance
        setTitle("Zap It!");
        setSize(400, 250);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } // MicrowaveUI

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // check if a button number was pressed
            try {
                Integer num = Integer.parseInt(e.getActionCommand());
                System.out.println("Number button " + num + " pressed.");
                // inner class has access the outer class member
                textField.setText(textField.getText() + num);
            } catch (NumberFormatException nfe) {
                System.out.println("Command button pressed.");
            }
        }     
    }

    public static void main(String args[]) {
        MicrowareUI2 frame = new MicrowareUI2();
    } // main
} // MicrowaveUI
