/*
 * ShowGridLayout.java
 *
 * $Id: ShowGridLayout.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: ShowGridLayout.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/*
 * 10 buttons arranged in a grid layout based on a row and column input
 * on the command line
 *
 * @author: Sean Strout
 */

import javax.swing.*;   // JButton, JFrame
import java.awt.*;  // GridLayout, Container

public class ShowGridLayout extends JFrame {
    public ShowGridLayout(int rows, int cols) {
        // Set the grid layout based on user input for
        // the rows and columns.  The gaps are 5 pixels
        setLayout(new GridLayout(rows, cols, 5, 5));

        // Add 10 buttons to the frame
        for (int i=0; i<10; i++) {
            add(new JButton("Button " + i));
        }
        
        // set frame appearance
        setTitle("ShowGridLayout");
        setSize(600, 200);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } // ShowGridLayout

    public static void main(String args[]) {
        if (args.length != 2) {
            System.err.println("Usage: java ShowGridLayout rows cols");
            return;
        }

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);

        new ShowGridLayout(rows, cols);
    } // main
} // ShowGridLayout
