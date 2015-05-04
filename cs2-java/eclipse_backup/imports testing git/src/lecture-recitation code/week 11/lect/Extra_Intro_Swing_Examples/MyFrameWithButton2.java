/*
 * MyFrameWithButton.java
 *
 * $Id: MyFrameWithButton2.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: MyFrameWithButton2.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/* 
 * Create a frame with an OK button.  Here we subclass JFrame.
 *
 * @author: Sean Strout
 */
import javax.swing.*;       // JFrame

public class MyFrameWithButton2 extends JFrame {

    public MyFrameWithButton2(String title) {
        // set title in JFrame class
        super(title);
        
        // Create an "OK" button
        JButton okButton = new JButton("OK");

        // Add the button into the frame via the content pane
        add(okButton);
        
        // Set up the frame behavior
        setSize(400, 300);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String args[]) {
        new MyFrameWithButton2("Frame with components using subclassing");

    } // main
    
} // MyFrameWithButton
