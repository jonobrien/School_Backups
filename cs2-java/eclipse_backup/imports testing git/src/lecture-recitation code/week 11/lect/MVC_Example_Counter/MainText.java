/*
 * $Id: MainText.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

/**
 * View is separated from the model, but each knows the other one well.
 * View knows the model's methods, and the model knows what to call in
 * the view to get it updated.
 *
 * @author James Heliotis
 * @author Ben Steele
 */
public class MainText {

    public static void main( String[] args ) {

        Counter counter = new Counter();
        ViewControl view = new TextViewControl( counter );
        view.startViewControl();
    }

}

/*
 * $Log: MainText.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
