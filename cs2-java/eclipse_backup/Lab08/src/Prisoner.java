/*
 * Prisoner.java
 * 
 * Version:
 * $Id: Prisoner.java,v 1.5 2014/05/06 18:29:48 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: Prisoner.java,v $
 * Revision 1.5  2014/05/06 18:29:48  jvo7822
 * minor formatting.
 *
 * Revision 1.4  2014/05/06 18:24:16  jvo7822
 * Finished PrisonerPuzzle.java, and the formatting of everything, should work as expected now.
 *
 * Revision 1.3  2014/05/06 17:58:21  jvo7822
 * Comments in Room.java, formatting elsewhere.
 *
 * Revision 1.2  2014/05/06 14:16:28  jvo7822
 * Formatting in Prisoner.java, formatting elsewhere.
 *
 * Revision 1.1  2014/05/06 04:04:18  jvo7822
 * Threads - initial commit.
 *
 */

import java.util.concurrent.ThreadLocalRandom;


/**
 * This class constructs the prisoners/threads.  Takes in a number and a synchronized room
 * and has all the connected numbers and values for the prisoners that are used by the
 * puzzle and the room in calculating the number of days needed to complete the puzzle
 * and properly finish the task required.  Two different types of prisoners based on
 * whether or not they are 1: the leader, or 2: the rest of the prisoners.
 * 
 * @author Jon O'Brien
 *
 */
public class Prisoner extends Thread {
	
	int prisNum; 			// the number of prisoners undergoing the experiment.
	static int total; 		// the total number of prisoners needed to escape
    static int UniquePris;	// if the prisoner is unique or not, being in the room prior
    Boolean leader;			// the designation of being the leader
    Boolean TurnOnBefore;	// whether or not the switch is flipped
    Room prison; 			// the room the prisoners sync into, has the switch
    
    
    /**
     * Prisoners that are not the leader, don't keep track of the number of prisoners
     * that have flipped the switch.
     * 
     * @param prisNum - the number of the prisoner, for use by the leader.
     * @param prison - the room that the thread enters.
     */
    public Prisoner(int prisNum, Room prison) {
        this.prisNum = prisNum;
        TurnOnBefore = false;
        this.prison = prison;
        leader = false;
    }
    
    
    /**
     * This prisoner is the Leader and that thread has to keep track
     * of the total number of prisoners that have flipped the switch.
     * 
     * @param prisNum - the number of the leader
     * @param totalPris - tje total number of prisoners/threads being made
     * @param prison - the room the leader enters, the thread goes into.
     */
    public Prisoner(int prisNum, int totalPris, Room prison) {
        this.prisNum = prisNum;
        UniquePris = 0;
        leader = true;
        this.prison = prison;
        TurnOnBefore = false;
        total = totalPris;
    }
    
    // the switch was turned on before.
    public Boolean getTurnedOnBefore() {  
        return TurnOnBefore;
    }
    
    // increase count of unique flip occurrences.
    public void incrementUniquePrisCount() { 
        UniquePris++;
    }
    
    // prisoner total that have visited the room.
    public int getUniquePris() { 
        return UniquePris;
    }
    
    // number of prisoners that are in the experiment.
    public int getNumber() { 
        return prisNum;
    }
    
    // to flip or not to flip the switch.
    public void setTurnedOnBefore() { 
        if (prison.Switch) {
        }//if on, do nothing 
        else {
        	prison.Switch = true;
        	TurnOnBefore = true; // flip it on
        }
    }
    
    // this prisoner is the leader
    public Boolean isLeader() { 
        return leader;
    }
    

    /**
     * this method overrides the run method for the threads and runs until the note
     * is written by the leader and everyone can escape. A prisoner is chosen at random
     * to go into the room and interact with the switch.
     */
    @Override
    public void run() {
        while (UniquePris != prison.numPris - 1) {
               int note = ThreadLocalRandom.current().nextInt(0, total);
                for (Prisoner p : PrisonerPuzzle.PL) {
                    if (note == p.getNumber()) {
                        prison.prisonCount++;
                        prison.visitRoom(p);
                    }
                }
            }
        }
	}

