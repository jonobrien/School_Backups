/*
 * Room.java
 * 
 * Version:
 * $Id: Room.java,v 1.3 2014/05/06 18:29:48 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: Room.java,v $
 * Revision 1.3  2014/05/06 18:29:48  jvo7822
 * minor formatting.
 *
 * Revision 1.2  2014/05/06 17:58:13  jvo7822
 * Comments in Room.java, formatting elsewhere.
 *
 * Revision 1.1  2014/05/06 04:04:17  jvo7822
 * Threads - initial commit.
 *
 */

/**
 * This class constructs the room and has the visitRoom method that has
 * the print statements that update with threads toggling the switch and
 * the leader incrementing the counter for number of unique visits.
 * 
 * @author Jon O'Brien
 *
 */
public class Room {

    int numPris;		// the number of prisoners/threads
    Boolean Switch;		// the switch toggled on/off by unique prisoners or the leader
    int prisonCount;	// the number of unique prisoners visiting the room
    Boolean escape;		// the prisonCount = numPris and no one else has to visit the room.

    
    /**
     * the room is constructed with the number of prisoners and 
     * has a button and sign for telling all the prisoners that the
     * experiment is done and everything can stop.
     * 
     * @param numPris - the number of prisoners
     */
    public Room(int numPris) {
        this.numPris = numPris;
        Switch = false;
        escape = false;
        prisonCount = 0;
    }

    
    /**
     * The visitRoom method takes a Prisoner object and differentiates between 
     * leader prisoner/thread or ordinary thread/prisoner, then prints the respective
     * statement based on switch state, and increments their respective values, if
     * the total is reached, the prisoners can escape if the values equal, this boolean
     * is returned.
     * 
     * @param p - the current prisoner in the room
     * @return - true iff the correct number of unique prisoners has been achieved
     */
    public synchronized Boolean visitRoom(Prisoner p) {
        
    		// if switch is toggled/flipped
            if (Switch) {
            	//if the leader is in the room
                if (p.isLeader()) {
                    p.incrementUniquePrisCount();
                    System.out.println("On day " + prisonCount + ", " + 
                    		"Leader updates unique visitor count to: " + p.getUniquePris());
                    Switch = false;
                }
            }
            // all the other prisoners are in the room, one at a time.
            else {
                p.setTurnedOnBefore();
                System.out.println("On day " + prisonCount + ", Prisoner " + 
                		p.getNumber() + " turns on the light!");
            }
            //the total has been reached, everything ends
            escape = (Prisoner.UniquePris == numPris);
            return escape;
        }
   
    
    
    //number of prisoners that visited the room.
    public int getVisitorCount() {
        return prisonCount;
    }
}

