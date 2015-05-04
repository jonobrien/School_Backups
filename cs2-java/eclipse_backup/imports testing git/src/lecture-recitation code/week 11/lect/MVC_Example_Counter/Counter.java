/*
 * $Id: Counter.java,v 1.1 2012/04/20 00:22:15 vcss243 Exp $
 */

enum Direction { down, up };
    
/**
 * Counter is the 'Model'.
 * NOTE: Docs were minimized for brevity.
 */
public class Counter {

    private int count = 0;

    /** view is the model's link to the 'one and only' view (controller) */
    private ViewControl view;
    
    public void setView( ViewControl view ) {
        this.view = view;
    }

    public void bump( Direction dir ) {
        if ( dir == Direction.up ) {
            count += 1;
        }
        else {
            count -= 1;
        }
        view.updateValue( count );
    }

    public int getCount() {
        return count;
    }
}

/*
 * $Log: Counter.java,v $
 * Revision 1.1  2012/04/20 00:22:15  vcss243
 * Initial revision
 *
 */
