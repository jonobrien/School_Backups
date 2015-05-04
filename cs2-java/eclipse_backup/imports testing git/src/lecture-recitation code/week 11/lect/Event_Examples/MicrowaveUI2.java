/*
 * MicrowaveUI.java
 *
 * $Id: MicrowaveUI2.java,v 1.2 2012/04/05 13:22:34 vcss243 Exp $
 *
 * $Log: MicrowaveUI2.java,v $
 * Revision 1.2  2012/04/05 13:22:34  vcss243
 * fixed misnamed class
 *
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
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


public class MicrowaveUI2 extends JFrame {
    private JTextField textField;
    
    public MicrowaveUI2() {
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
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
        new MicrowaveUI2();
    } // main
} // MicrowaveUI
