/*
 * $Id: Main.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

/**
 * View is separated from the model, but each knows the other one well.
 * View knows the model's methods, and the model knows what to call in
 * the view to get it updated.
 *
 * @author James Heliotis
 * @author Ben Steele
 */
public class Main {

    public static void main( String[] args ) {

        Counter counter = new Counter();
        CountView view = new CountView( counter );
        view.startViewControl();
    }

}

/*
 * $Log: Main.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
