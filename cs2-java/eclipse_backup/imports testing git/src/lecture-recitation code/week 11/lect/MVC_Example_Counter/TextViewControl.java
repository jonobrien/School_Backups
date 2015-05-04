/*
 * $Id: TextViewControl.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

import java.util.Scanner;

/**
 * TextViewControl is a 
 * "View-Controller" for a variation of Model-View-Controller.
 *
 * Note: javadocs are minimal for brevity.
 *
 * @author Ben Steele
 */
public class TextViewControl implements ViewControl {
    
    private final Counter model;

    private final static String UP = "+";

    private final static String DOWN = "-";
    
    public TextViewControl( Counter model ) {

        this.model = model;
        model.setView( this );
    }

    /** startViewControl opens the view-control for user interaction */
    public void startViewControl() {

        System.out.println( "Value == " + model.getCount() );
        System.out.print( "Enter + to increase or - to decrease " );
        Scanner inScan = new Scanner( System.in );

        String line = inScan.nextLine();
        while ( line != null && ! line.equals("") ) {

            if ( line.contains( UP ) ) {
                model.bump( Direction.up );

            } else if ( line.contains( DOWN ) ) {
                model.bump( Direction.down );

            } else {
                System.out.println( "unknown input. try again." );
            }
            line = inScan.nextLine();
        }
        System.out.println( "So long and thanks for all the pizza." );
    }

    /** this view simply displays of the new value. */
    public void updateValue( int value ) {
        System.out.println( "Value == " + value );
    }

}

/*
 * $Log: TextViewControl.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
