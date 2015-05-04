/*
 * ShowComponents.java
 * 
 * $Id: ShowComponents.java,v 1.1 2011/06/03 19:09:12 vcss243 Exp $
 *
 * $Log: ShowComponents.java,v $
 * Revision 1.1  2011/06/03 19:09:12  vcss243
 * Initial revision
 *
 */

/*
 * Example swing components
 */
import javax.swing.*;
import java.awt.*;

public class ShowComponents extends JFrame {
    public ShowComponents () {
		// align components to left in a flow layout
        setLayout(new FlowLayout (FlowLayout.LEFT, 10, 20));

        // create a bunch of different JComponents
        add(new JButton("OK"));
        add(new JLabel("Enter your name: "));
        add(new JTextField("Type name here..."));
        add(new JCheckBox("Bold"));

		// group radio buttons together
        ButtonGroup group = new ButtonGroup();
        for ( String color: new String[]{"Red","Green","Blue"} ) {
            JRadioButton butt = new JRadioButton( color, true );
            add( butt ); // should set one to true
            group.add( butt );
        }
    	add(new JComboBox(new String[]{"High", "Med", "Low"}));
        
        // set frame appearance
        setTitle("GUI Components");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 200);
        setLocation(100, 100);
        setVisible(true); 
    } // ShowComponents

    public static void main(String args[]) {
        new ShowComponents();
    } // main
} // ShowComponents
