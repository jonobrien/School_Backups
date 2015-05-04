/*
 * $Id: ViewControl.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

/**
 * ViewControl is a "View-Controller" interface for a Model-View-Controller.
 *
 * NOTE: This interface should be generic to specify the type of update value.
 *
 * @author Ben Steele
 */
public interface ViewControl {
    
    /**
     * updateValue changes the value in the model.
     * @param value the value passed to update the model.
     */
    public void updateValue( int value );

    /** startViewControl opens the view-control for user interaction */
    public void startViewControl() ;

}

/*
 * $Log: ViewControl.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
