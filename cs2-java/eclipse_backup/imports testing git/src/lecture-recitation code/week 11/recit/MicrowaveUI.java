/*
 * MicrowaveUI.java
 *
 * $Id$
 *
 * $Log$
 */

/*
 * Create a user interface for a microwave oven
 *
 * @author: Liang, Ex 11.4
 * @author: Sean Strout
 */

import java.awt.*;
import javax.swing.*;

public class MicrowaveUI extends JFrame {
    public MicrowaveUI() {
        // Get the content pane of the frame
        Container container = getContentPane();

        // Set the border layout for the frame
        container.setLayout(new BorderLayout());
        

        // Create panel1 for the button and
        // use a grid layout
        JPanel panel1 = new JPanel();
        //panel1.setOpaque(true);
        panel1.setLayout(new GridLayout(4, 3));

        // Add buttons to the panel
        for (int i=1; i<10; i++) {
            JButton button = new JButton("" + i);
            button.setForeground(Color.BLACK);  
            panel1.add(button);
        }

        JButton button = new JButton("0");
        button.setForeground(Color.BLACK);
        panel1.add(button);

        button = new JButton("Start");
        button.setForeground(Color.GREEN);
        panel1.add(button);

        button = new JButton("Stop");
        button.setForeground(Color.RED);
        panel1.add(button);

        // Create panel2 to hold a text field and panel1
        JPanel panel2 = new JPanel(new BorderLayout());
        JTextField textField = 
            new JTextField("Time to be displayed here...");
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.BLACK);
        panel2.add(textField,BorderLayout.NORTH);
        panel2.add(panel1, BorderLayout.CENTER);

        // Add panel2 and a button to the frame
        container.add(panel2, BorderLayout.EAST);
        button = new JButton("Food to be placed here");
        button.setForeground(Color.RED);
        container.add(button, BorderLayout.CENTER);

        // set frame appearance
        setTitle("Zap It!");
        setSize(400, 250);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } // MicrowaveUI

    public static void main(String args[]) {
        MicrowaveUI frame = new MicrowaveUI();
    } // main
} // MicrowaveUI