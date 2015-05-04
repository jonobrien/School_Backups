
public class Racecar {
	
	//public variables,classes, etc can be accessed by any other file ("outer world") using the current file, class etc.
	//private variables, etc are not accessible to other files, unless specified by another function/method
	//state(field) information
	
	
	//constants
	public static final double DEFAULT_MPG = 30;
	public static final double DEFAULT_FUEL_CAPACITY = 15;
	public static final double DEFAULT_MAX_SPEED = 100;
	//static is info that belongs to class as a whole, only allocate one memory spot instead of 
	//lots for every instance
	//final indicates the values can't be changed, made them constants
	
	private String name;
	private double mpg;
	private double fuelCapacity;
	private double maxSpeed;
	private double currSpeed;
	private double fuelLeft;
	private double distanceTravelled;
	
	/*
	 * 
	 * constructor comments
	 * 
	 * 1) invoke to create an object of this class
	 * 2) looks like methods but no return value and
	 * 		the name of the constructor needs to match class name
	 * 3) often used to initialize data values for the object
	 * 
	 */
	
	public Racecar(String name, double milesPerGallon,
			double tankCapacity, double maxSpeed) {
		this.name = name; //shadowing, assoc with input argunent ssigned to variable, the kw
		//this or this. allows us to use the variable keywords
		mpg = milesPerGallon;
		this.fuelCapacity = tankCapacity;
		this.maxSpeed = maxSpeed;
		
		fuelLeft = tankCapacity;
		currSpeed = 0;
		distanceTravelled = 0;
		
	}
	
	//default constructor
	public Racecar(String name) {
		this(name, DEFAULT_MPG, DEFAULT_FUEL_CAPACITY, DEFAULT_MAX_SPEED);
		
	}
	
	
	
	//a few methods (behaviors) we might be interested in
	
	
	public void accelerate(double factor) {
		//void methods don't return anything
		currSpeed += factor;
		if(currSpeed > maxSpeed) {
			currSpeed = maxSpeed;
		}
	}
	
	
	public void fillUp() {
		fuelLeft = fuelCapacity;
		
	}
	
	
	public double getFuelLeft() {
		return fuelLeft;
	}
	
	public void travel (int minutes) {
		double distance = minutes / 60.0 * currSpeed;
		//make sure your calculations are the correct type, integer, double, etc
		//here all variables are good to go
		double fuelUsed = distance/mpg;
		
		if(fuelUsed > fuelLeft) {
			fillUp();
			System.out.println(name + " is refuelling");
			
		}
		
		else{
			distanceTravelled += distance;
			fuelLeft -= fuelUsed;
			System.out.println(name + " has travelled " + distanceTravelled + " miles.");
			
		}
		
	}
	
	public String toString() {
		return name + " is going " + mpg + " miles per hour " +
				"and has travelled " + distanceTravelled + " miles.";
		
	}
	
	public boolean equals(Object o) {
		if( !(o instanceof Racecar)) {
			return false;
			
		Racecar r = (Racecar)o;
		//define our own ideas of inequality
		return (((name.equals(r.name)) && (mpg == r.mpg)) );
		
		}
		return false;
	}
}
