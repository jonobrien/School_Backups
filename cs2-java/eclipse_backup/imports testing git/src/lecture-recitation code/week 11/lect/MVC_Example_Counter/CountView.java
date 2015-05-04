/*
 * $Id: CountView.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * CountView is the "View-Controller" variation of a Model-View-Controller.
 *
 * @author James Heliotis
 * @author Ben Steele
 */
public class CountView implements ViewControl {
    
    private JFrame frame;
    private JButton upButt;
    private JButton downButt;
    private JLabel valueLabel;

    private final Counter model;
    
    public CountView( Counter model ) {

        // connect the model and this view

        this.model = model;
        model.setView( this );

        // set up this view and its (nested/anonymous) controllers

        valueLabel = new JLabel( String.valueOf( model.getCount() ) );
        upButt = new JButton( "+" );

        upButt.addActionListener( new ActionListener() {
            /** actionPerformed accesses CountView's model field */
            public void actionPerformed( ActionEvent e ) {
                CountView.this.model.bump( Direction.up );
            }
        });
        downButt = new JButton( "-" );

        downButt.addActionListener( new ActionListener() {
            /** actionPerformed accesses CountView's model field */
            public void actionPerformed( ActionEvent e ) {
                CountView.this.model.bump( Direction.down );
            }
        });
        frame = new JFrame( "Counter" );
        frame.setLayout( new GridLayout( 0, 3 ) );
        frame.add( downButt );
        frame.add( valueLabel );
        frame.add( upButt );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    /** startViewControl opens the view-control for user interaction */
    public void startViewControl() {
        frame.pack();
        frame.setLocationRelativeTo( null );  // center on screen
        frame.setVisible( true );
    }

    public void updateValue( int value ) {
        valueLabel.setText( String.valueOf( value ) );
    }

}

/*
 * $Log: CountView.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
