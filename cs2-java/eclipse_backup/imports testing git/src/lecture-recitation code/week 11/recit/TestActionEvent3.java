/*
 * TestActionEvent.java
 *
 * $Id$
 *
 * $Log$
 */

/* 
 * Demonstrates two anonymous listeners for two buttons.
 *
 * @author: Sean Strout
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent3 extends JFrame {

    private JButton buttonOK = new JButton("OK");
    private JButton buttonCancel = new JButton("Cancel");

    public TestActionEvent3() {
        // Set flow layout in the content pane
        setLayout(new FlowLayout());

        // Add buttons to the frame
        add(buttonOK);
        add(buttonCancel);

        // Register anonymous listeners
        buttonOK.addActionListener(new ActionListener() {
            // This method is invoked whenever the OK button is clicked
            public void actionPerformed(ActionEvent event) {
                System.out.println(buttonOK);
                System.out.println("You pressed the OK button.");
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            // This method is invoked whenever the OK button is clicked
            public void actionPerformed(ActionEvent event) {
                System.out.println("You pressed the CANCEL button.");
            }
        });

        // set frame appearance
        setTitle("TestActionEvent");
        setSize(250, 80);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // TestActionEvent

    public static void main(String[] args) {
        TestActionEvent3 frame = new TestActionEvent3();
    } // main
} // TestActionEvent