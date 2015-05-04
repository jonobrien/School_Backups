import java.util.*;
/**
 * Collections Test class
 * @author Nic Manoogian
 */
public class Test
{
	public static void main(String [] args)
	{
		Collection<String> c1 = new ArrayList<String>();
		c1.add("alpha");
		c1.add("beta");
		c1.add("gamma");
		c1.add("delta");
		c1.add("gamma");
		c1.add("beta");
		c1.add("alpha");
		System.out.println(c1);
		System.out.println();

		Collection<String> c2 = new TreeSet<String>(c1);
		System.out.println(c2);


	}
}