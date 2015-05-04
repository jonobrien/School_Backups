import java.util.*;

/**
 * Iterator Example Class
 * @author Nic Manoogian
 */
public class Iterate
{
	/**
	 * Main method
	 * @param args command line arguments unused
	 */
	public static void main(String [] args)
	{
		List<Album> albums = new LinkedList<Album>();
		albums.add(new Album("Pink Floyd", "Dark Side of the Moon", 1973));
		albums.add(new Album("NickelBack", "Here and Now", 2011));
		albums.add(new Album("Radiohead", "Ok Computer", 1997));
		albums.add(new Album("Coldplay", "Mylo Xyloto", 2011));
		albums.add(new Album("U2", "All That You Can't Leave Behind", 2000));

		// Using a foreach loop
		for (Album a : albums)
		{
			System.out.println(a);
		}

		System.out.println();

		// Using an iterator
		Iterator<Album> iter = albums.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
			iter.remove();
		}
	}

	/**
	 * Using a map example
	 */
	public void datMap()
	{
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('a',"Hello");
		map.put('b',"Python");
		map.put('c',"!");
	}
}