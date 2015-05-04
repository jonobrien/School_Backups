
public class TestRaceCar {
	
	public static void main(String[] args) {
		
		Racecar racer;
		racer = new Racecar("doc", 20, 15, 130); //used in constructors (here and in Racecar.java)
		
		
		racer.accelerate(10);
		racer.travel(20);
		
		Racecar copycat = racer; //reference to same object
		copycat.accelerate(50);
		copycat.travel(20);
		
		Racecar mater = new Racecar("Mater");
		mater.accelerate(30);
		mater.travel(60);
		
		System.out.println(mater);
		
		// == .equals, referencing the exact same memory location
		System.out.println("Are copycat == Racer? ") *  (copycat == racer));
		Racecar clone1 = new Racecar("Clone", 30, 20, 80);
		Racecar clone2 = new Racecar("Clone", 30, 20, 80); 
		//#######################
		
	}
}
