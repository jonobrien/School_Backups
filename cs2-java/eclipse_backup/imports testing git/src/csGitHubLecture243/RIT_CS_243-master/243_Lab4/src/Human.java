/**
 * Human.java
 *
 * File:
 *	$Id: Human.java,v 1.1 2013/03/27 23:23:16 njm7461 Exp $
 *
 * Revisions:
 *	$Log: Human.java,v $
 *	Revision 1.1  2013/03/27 23:23:16  njm7461
 *	Initial Commit
 *
 */

import java.util.Scanner;

/**
 * A human player for 2-card poker
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Human extends Player
{
    private static Scanner in;
    
    /**
    * Initialize a human player for 2-card poker
    */
    public Human (String n, Scanner inScan)
    {
    	super(n);
    	in = inScan;
    	myCards = new PokerHand();
    }
    
    
    /**
    * Asks the player if they want to stand.  You should prompt the
    * player with a suitable message, and then read the players response
    * from standard input.
    *
    * @return  a boolean value specifying if the human wants to stand
    */
    public boolean stand()
    {
        boolean res = true;
        String answer;
        char c;
        do
        {
            System.out.print("Do you want to stand (y/n)? ");
            answer = in.next();
            answer = answer.toLowerCase();
            c = answer.charAt(0);
        }
        while( c != 'y' && c != 'n' );
        
        
        if ( c == 'y' )
        {
            res = true;
        }
        else
        {
            res = false;
        }
        
        return res;
    }
    
}