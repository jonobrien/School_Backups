import java.util.*;

public class AlbumCompareTest
{
	public static void main(String [] args)
	{
		ArrayList<Album> alist = new ArrayList<Album>();
		alist.add(new Album("James Taylor", "Believe", 1993));
		alist.add(new Album("James Taylor", "Icon", 1993));
		alist.add(new Album("James Taylor", "Forget", 1991));
		alist.add(new Album("ABBA", "Walk the Earth", 1980));
		alist.add(new Album("Nickleback", "Absolute Crap", 2000));
		alist.add(new Album("Zebra", "Not Much Better", 2010));
		alist.add(new Album("Aaron Carter", "Oh, Aaron, Stop Making Music", 2010));

		Collections.sort(alist, new AlbumComparator());
		// Collections.sort(alist);
		System.out.println(alist);
	}
}