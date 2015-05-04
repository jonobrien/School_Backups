import java.util.*;
/**
 * Album Class
 * @author Nic Manoogian
 */
public class Album implements Comparable<Album>
{
	private String artist;
	private String title;
	private int year;

	/**
	 * Constructs an album with an artist, title, and year
	 * @param artist artist name
	 * @param title album title name
	 * @param year album year
	 */
	public Album(String artist, String title, int year)
	{
		this.artist = artist;
		this.title = title;
		this.year = year;
	}

	/**
	 * Returns the artist name
	 * @return artist name as a String
	 */
	public String getArtist()
	{
		return artist;
	}

	/**
	 * Returns the title of the album
	 * @return title of album
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Returns the year of the album
	 * @return year of album
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * String representation of an album
	 * @return String representation
	 */
	public String toString()
	{
		return getArtist() + " released " + getTitle() + " in " + getYear();
	}

	/**
	 * Compares Albums based on artist, then year, then title
	 */
	public int compareTo(Album a)
	{
		int result = 0;
		if (getArtist().compareTo(a.getArtist()) != 0)
		{
			result = getArtist().compareTo(a.getArtist());
		}
		else if (getYear() != a.getYear())
		{
			result = getYear() - a.getYear();
		}
		else if (getTitle().compareTo(a.getTitle()) != 0)
		{
			result = getTitle().compareTo(a.getTitle());
		}

		return result;
	}
}