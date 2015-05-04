/*
 * TestActionEvent.java
 *
 * $Id: TestActionEvent2.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: TestActionEvent2.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/* 
 * Demonstrates a listener for action events on two buttons
 *
 * @author: Liang, Ex 12.1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2 extends JFrame {

    private JButton buttonOK = new JButton("OK");
    private JButton buttonCancel = new JButton("Cancel");

    public TestActionEvent2() {
        // Set flow layout in the content pane
        setLayout(new FlowLayout());
        
        // Add buttons to the frame
        add(buttonOK);
        add(buttonCancel);

        // Create a listener object
        ButtonListener buttonListener = new ButtonListener();

        // Register listeners
        buttonOK.addActionListener(buttonListener);
        buttonCancel.addActionListener(buttonListener);
    
        // set frame appearance
        setTitle("TestActionEvent");
        setSize(250, 80);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } // TestActionEvent
    
    // ButtonListener is an inner class
    class ButtonListener implements ActionListener {
        // This method is invoked whenever a button is clicked
        public void actionPerformed(ActionEvent event) {
            // inner class has access to outter class state
            if (event.getSource().equals(buttonOK)) {
                System.out.println("You pressed the OK button.");
            } else if (event.getSource().equals(buttonCancel)) {
                System.out.println("You pressed the CANCEL button.");
            }
        } // actionPerformed
    } // ButtonListener

    public static void main(String[] args) {
        new TestActionEvent2();
    } // main
} // TestActionEvent
