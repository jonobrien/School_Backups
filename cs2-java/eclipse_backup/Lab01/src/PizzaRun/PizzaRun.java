package PizzaRun;
/**
 *
 * @Jon O'Brien
 */
public class PizzaRun {
/**
 * PizzaRun is a simple program that calculates the number of pizzas to buy 
 * based on the sum of the slices entered on the command line arguments after 
 * the first argument, the price per pizza. 
 */
	private static int SLICE_PER_PIE = 8;
	/**
	 * 
	 * @param args (used for input)
	 * 
	 */
	
	public static void main(String[] args) {
		/**
		 * The main method.
		 */
		int totalPizzas = 0;
		for (int index = 1; index < args.length; index ++)
		{
			int pizzaTemp = Integer.parseInt(args[index]);
			totalPizzas += pizzaTemp;
			
		}
		int wholePizzas = calcWholePies(totalPizzas);
		double price = wholePizzas*Double.parseDouble(args[0]);
		int extraPizza = (wholePizzas*SLICE_PER_PIE)-totalPizzas;
		System.out.println("Buy " + wholePizzas + " pizzas for " + price);
		System.out.println("There will be " + extraPizza + " extra slices.");
		
	}
	public static int calcWholePies(int nSlices)
	/**
	 * calcWholePies returns the number of whole pizza pies are needed to fill 
	 * the order for a given number of slices.
	 */
	{
		int remSlices = nSlices % SLICE_PER_PIE;
		int remaining = 0;
		if (remSlices == 0)
		{
			remaining = nSlices/SLICE_PER_PIE;
			
		}
		else{
			int temp = nSlices - remSlices;
			remaining = (temp/SLICE_PER_PIE) + 1;
			
		}
		return remaining;
	}
}




//
//		
//		(for nSlices > SLICE_PER_PIE; nSlices = (nSlices - SLICES_PER_PIE); totalPizza = ++ ) 
//		{
//			totalPizza = ++
//		}
//}
