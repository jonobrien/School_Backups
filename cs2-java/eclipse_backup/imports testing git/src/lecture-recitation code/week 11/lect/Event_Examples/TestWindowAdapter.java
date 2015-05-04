/*
 * TestWindowAdapter.java
 *
 * $Id: TestWindowAdapter.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: TestWindowAdapter.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/*
 * Demos using a WindowAdapter to handle window activation events.
 * We'll won't write methods for any other WindowEvent's
 * 
 * @author: Sean Strout
 */

import java.awt.event.*;
import javax.swing.*;

public class TestWindowAdapter extends JFrame {

    public TestWindowAdapter() {
        // Use an anonymous class as the window listener.
        // We use a window adapter so we only need
        // to override the actions we care about.
        addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated!");
           }
           public void windowClosing(WindowEvent e) {
                System.out.println("Window closing!");
                dispose();
           }
        });
        
        // frame appearance
        // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);   
    }
    
    public static void main(String args[]) {
        new TestWindowAdapter();
    }

} // TestWindowAdapter
