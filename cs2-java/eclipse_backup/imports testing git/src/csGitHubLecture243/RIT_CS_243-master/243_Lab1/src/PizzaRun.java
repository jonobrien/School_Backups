/**
 * PizzaRun.java
 *
 * File:
 *	$Id: PizzaRun.java,v 1.3 2013/03/06 20:27:00 njm7461 Exp $
 *
 * Revisions:
 *	$Log: PizzaRun.java,v $
 *	Revision 1.3  2013/03/06 20:27:00  njm7461
 *	Added CVS comments
 *
 */

/**
 * calculates the number of pizzas to buy based on the sum of the slices entered on the command line arguments after the first argument, the price per pizza
 *
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class PizzaRun
{
		// SLICE_PER_PIE stores the number of slices in one pizza
        public static final int SLICE_PER_PIE = 8;
        /**
         * The main method
         * @param args Command line arguments, the first is the price for one pizza (double) followed by a list of integers representing the number of slices requested by each person
         */
        public static void main(String [] args)
        {
                int total_slices = 0;
                if (args.length == 0)
                {
                	System.out.println("No arguements");
                	return;
                }
                for (int i = 1; i < args.length; i++)
                {
                        total_slices += Integer.parseInt(args[i]);
                }

                System.out.println("Buy " + calcWholePies(total_slices) + " pizzas for $" + (calcWholePies(total_slices)*Double.parseDouble(args[0])));
                System.out.println("There will be " + (calcWholePies(total_slices)*SLICE_PER_PIE - total_slices) + " extra slices");
        }
        
        /**
         * 
         * @param nSlices integer representing the number of slices required by the eaters 
         * @return integer of how many pizzas must be ordered
         */
        public static int calcWholePies(int nSlices)
        {
                return (int) Math.ceil( (nSlices+0.0)/(SLICE_PER_PIE+0.0) );
        }

}

