/*
 * ButtonListener.java
 *
 * $Id: ButtonListener.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: ButtonListener.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/* 
 * Demonstrates a listener for action events on two buttons
 *
 * @author: Liang, Ex 12.1
 */

import java.awt.event.*;
import java.util.Date;

class ButtonListener implements ActionListener {
    // This method is invoked whenever a button is clicked
    public void actionPerformed(ActionEvent event) {
        System.out.println("The " + event.getActionCommand() + 
            " button was clicked at\n " + 
            new Date(event.getWhen()));
    } // actionPerformed
} // ButtonListener