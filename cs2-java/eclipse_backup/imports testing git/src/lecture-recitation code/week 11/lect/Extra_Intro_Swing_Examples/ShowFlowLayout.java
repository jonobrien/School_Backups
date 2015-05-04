/*
 * ShowFlowLayout.java
 *
 * $Id: ShowFlowLayout.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: ShowFlowLayout.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */
import javax.swing.*;       // JButton, JFrame
import java.awt.*;          // Container, FlowLayout

/*
 * Create 10 buttons labeled Component 0..9 into the content
 * pane using a FlowLayout manager
 *
 * @author: Liang, Ex. 11.1
 */

// Extend from the JFrame class
public class ShowFlowLayout extends JFrame {

    // Constructor places components in the frame
    public ShowFlowLayout() {
        // Set FlowLayout, aligned left with a horizontal
        // gap 10 and vertical gap 20 between components
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // Add 10 buttons into the frame
        for (int i=0; i<10; i++) {
            add(new JButton("Button " + i));
        }
        
        // set frame appearance
        setTitle("ShowFlowLayout");
        setSize(600, 200);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } // ShowFlowLayout

    public static void main(String args[]) {
        new ShowFlowLayout();
    } // main
} // ShowFlowLayout
