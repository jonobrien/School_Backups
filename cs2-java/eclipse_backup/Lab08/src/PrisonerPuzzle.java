/*
 * PrisonerPuzzle.java
 * 
 * Version:
 * $Id: PrisonerPuzzle.java,v 1.5 2014/05/06 18:29:48 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: PrisonerPuzzle.java,v $
 * Revision 1.5  2014/05/06 18:29:48  jvo7822
 * minor formatting.
 *
 * Revision 1.4  2014/05/06 18:24:16  jvo7822
 * Finished PrisonerPuzzle.java, and the formatting of everything, should work as expected now.
 *
 * Revision 1.3  2014/05/06 17:58:18  jvo7822
 * Comments in Room.java, formatting elsewhere.
 *
 * Revision 1.2  2014/05/06 14:16:28  jvo7822
 * Formatting in Prisoner.java, formatting elsewhere.
 *
 * Revision 1.1  2014/05/06 04:04:18  jvo7822
 * Threads - initial commit.
 * 
 */

import java.util.ArrayList;


/**
 * This class constructs the puzzle and takes the input arguments and makes threads 
 * according to that input value.  The class also prints the ending statements along
 * with the expected number of days that would theoretically take to complete the task
 * under perfect conditions.
 * 
 * @author Jon O'Brien
 *
 */
public class PrisonerPuzzle {

	static ArrayList<Prisoner> PL = 
			new ArrayList<Prisoner>(); 	// ArrayList of Prisoners
	static Room prison;					// the synced room
	static double expected;				// the expected # days
	static int expectedInt;				//converted expected # days
	
	
	/**
	 * The main method takes the input from args and constructs the threads
	 * and then starts and joins the threads.  The expected number of days
	 * is calculated as the threads start and run through their visitRoom()
	 * method and finish as the number reaches input integer - 1.
	 * 
	 * @param args - the number of prisoners is input and used by the program.
	 */
	public static void main(String[] args ) throws InterruptedException {
        int numPris = Integer.parseInt (args[0] );
		prison = new Room( numPris );
		//improper number of prisoners input into args.
        if ( numPris < 2 ) {
        	System.out.println("Please enter a number of Prisoners greater than 2.");
        }
        //2 or more prisoners input into args.
        else {
        	for ( int i = 0; i < numPris ; i++ ) {	
        		//add the leader to the list
        		if (i == 0) {
        			Prisoner Leader = new Prisoner( i, numPris, prison );
                    PL.add(Leader);
        		}
        		//add the other prisoners to the list
        		else {
                    Prisoner p = new Prisoner( i, prison );
                    PL.add(p);
        		}
        	}
        	//start and join each thread
        	for (Prisoner pris : PL) {
                pris.start();
                pris.join();
            }
        	
        //the expected number of days needed to complete the problem.
        expected = numPris*(numPris-1);
        for (int j = 1; j < numPris; j++) {
        	expected += ((double) numPris/((double) numPris-j));
        }
        
        expected = (int) Math.ceil(expected);//take the ceiling value
        expectedInt = ((int) expected);//convert back to integer for print
        System.out.println("Leader writes Freedom note!");    
        System.out.println("Total visits: "+ prison.getVisitorCount());
        System.out.println("Expected visits: " + expectedInt);
        }
	}
}
