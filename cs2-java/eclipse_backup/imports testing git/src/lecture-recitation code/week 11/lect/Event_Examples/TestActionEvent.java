/*
 * TestActionEvent.java
 *
 * $Id: TestActionEvent.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: TestActionEvent.java,v $
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

public class TestActionEvent extends JFrame {

    private JButton buttonOK = new JButton("OK");
    private JButton buttonCancel = new JButton("Cancel");

    public TestActionEvent() {
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

    public static void main(String[] args) {
        new TestActionEvent();
    } // main
} // TestActionEvent
