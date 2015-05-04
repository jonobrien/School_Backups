/*
 * DialogDemo
 *
 * $Id: DialogDemo.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: DialogDemo.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/* 
 * Demonstrates a simple dialog.
 *
 */
import javax.swing.*;

public class DialogDemo {
    public static void main(String[] args) {
        String speed = 
            JOptionPane.showInputDialog(null, "Speed in miles per hour?");
        double mph = Double.parseDouble(speed);
        double kph = 1.621 * mph;
        JOptionPane.showMessageDialog(null, "KPH = " + kph);
        System.exit(0);
    }
}