import java.util.*;
/**
 * AlbumComparator class
 * @author Nic Manoogian
 */
public class AlbumComparator implements Comparator<Album>
{
	/**
	 * Compares two Album objects
	 */
	public int compare(Album a, Album b)
	{
		int result = 0;
		if (a.getYear() != b.getYear())
		{
			result = a.getYear() - b.getYear();
		}
		else if (a.getArtist().compareTo(b.getArtist()) != 0)
		{
			result = a.getArtist().compareTo(b.getArtist());
		}
		else if (a.getTitle().compareTo(b.getTitle()) != 0)
		{
			result = a.getTitle().compareTo(b.getTitle());
		}
		
		if (a.getArtist().equals("Nickleback") && b.getArtist().equals("Nickleback"))
		{
			result = 0;
		}
		else if (a.getArtist().equals("Nickleback"))
		{
			result = 1;
		}
		else if (b.getArtist().equals("Nickleback"))
		{
			result = -1;
		}

		return result;
	}
}