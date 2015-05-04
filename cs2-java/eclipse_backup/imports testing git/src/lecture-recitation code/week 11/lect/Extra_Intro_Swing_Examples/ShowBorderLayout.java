/*
 * ShowBorderLayout.java
 *
 * $Id: ShowBorderLayout.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: ShowBorderLayout.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/*
 * 5 buttons arranged in a border layout.
 *
 * @author: Liang, Ex 11.3
 */

import javax.swing.*;   // JButton, JFrame
import java.awt.*;  // BorderLayout, Container

public class ShowBorderLayout extends JFrame {
    public ShowBorderLayout() {
        // Set the border layout with horizontal gap 5
        // and vertical gap 10
        setLayout(new BorderLayout(5, 10));

        // Add buttons to the frame
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("Center"), BorderLayout.CENTER);
        
        // set frame appearance
        setTitle("ShowBorderLayout");
        setSize(600, 200);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    } // ShowBorderLayout

    public static void main(String args[]) {
        new ShowBorderLayout();
    } // main
} // ShowBorderLayout
