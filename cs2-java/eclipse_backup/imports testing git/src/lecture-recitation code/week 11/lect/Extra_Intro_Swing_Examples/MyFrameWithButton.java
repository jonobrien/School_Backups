/*
 * MyFrameWithButton.java
 *
 * $Id: MyFrameWithButton.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: MyFrameWithButton.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/* 
 * Create a frame with an OK button.
 *
 * @author: Sean Strout
 */
import javax.swing.*;       // JFrame
import java.awt.*;          // Container

public class MyFrameWithButton {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Frame with components");

        // Get the content pane, which was made when the
        // frame was created.
        Container container = frame.getContentPane();

        // Create an "OK" button
        JButton okButton = new JButton("OK");
    
        // Add the button into the frame via the content pane
        container.add(okButton);

        // Set up the frame behavior
        frame.setSize(400, 300);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } // main
} // MyFrameWithButton
