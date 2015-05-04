/*
 * MicrowaveUI.java
 */

/*
 * Demonstrates an inner class listener that responds to
 * button presses.
 * In this case we extend JButton to make a button that holds
 * a number. There is no need to translate the button's label string
 * into an integer.
 *
 * @author: Liang, Ex 11.4
 * @author: Sean Strout
 * @author James Heliotis
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MicrowaveUI3 extends JFrame {
    private JTextField textField;
    
    private class NButton extends JButton {
        private int number;
        public NButton(String name, int number) {
            super(name);
            this.number = number;
        }
        public int getNumber() { return number; }
    }

    public MicrowaveUI3() {
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
            NButton button = new NButton("" + i,i);
            button.setForeground(Color.BLACK);  
            button.addActionListener(listener);
            panel1.add(button);
        }

        NButton nbutton = new NButton("0",0);
        nbutton.addActionListener(listener);
        nbutton.setForeground(Color.BLACK);
        panel1.add(nbutton);

        JButton button = new JButton("Start");
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
            Object button = e.getSource();
            if ( button instanceof NButton) {
                int num = ((NButton)button).getNumber();
                System.out.println("Number button " + num + " pressed.");
                // inner class has access to the outer class member
                textField.setText(textField.getText() + num);
            }
            else {
                System.out.println(e.getActionCommand()+" button pressed.");
            }
        }     
    }

    public static void main(String args[]) {
        new MicrowaveUI3();
    } // main
} // MicrowaveUI
