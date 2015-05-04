
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 13kle_000
 */
public class SavedPrisonerPuzzle {

    static List<Prisoner> Prision = new ArrayList<>();

    static Room room;

    public static void main(java.lang.String[] args) throws InterruptedException {

        int NumPrisoners = Integer.parseInt(args[0]);
        room = new Room(NumPrisoners);
        if (NumPrisoners < 2) {
            System.out.println("Please enter a number greater than or equal to 2");
        } else {

            for (int i = 0; i < NumPrisoners; i++) {
                if (i == 0) {
                    Prisoner Leader = new Prisoner(i, NumPrisoners, room);
                    Prision.add(Leader);

                } else {
                    Prisoner p = new Prisoner(i, room);
                    Prision.add(p);

                }

            }
            for (Prisoner p : Prision) {
                p.start();
                p.join();
                
            }

        }
        System.out.println("Total Days: "+room.getVisitorCount());
        System.out.println("Leader write Freedon note");    
        
        
    }
    
}
