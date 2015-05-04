

/**
 * VigenereCipherReader.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * VigenereCipherReader Class
 * A Vigenere cipher reader.
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

import java.io.IOException;
import java.io.Reader;

public class VigenereCipherReader extends Reader
{
	// Original stream
	private Reader os;
	// Keyword
	private String keyword;
	
	/**
	 * Creates a new Vigenere cipher reader.
	 * @param rd The underlying reader
	 * @param keyword The Vigenere cipher keyword. Although the keyword may include both lowercase and uppercase Roman alphabetic characters, the keyword is used in a case-insensitive manner. That is, both the character 'c' and the character 'C' in the keyword induce a rotation of 3.
	 * @throws IllegalArgumentException Thrown if keyword is a string that is empty or is not exclusively comprised of characters in the range 'a' through 'z' and 'A' through 'Z'.
	 */
	public VigenereCipherReader(Reader rd, String keyword) throws IllegalArgumentException
	{
		// TODO Implement constructor
		this.os = rd;
		this.keyword = keyword;
	}

	/**
	 * Closes the stream and releases any system resources associated with it.
	 */
	public void close() throws IOException
	{
		// TODO Implement close
		os.close();
	}
	
	/**
	 * Marks the present position in the stream.
	 */
	public void mark(int readAheadLimit) throws IOException
	{
		// TODO Implement mark
	}

	/**
	 * Reads a single character. Reads a single character from the underlying Reader, decodes it, and returns it.
	 */
	public int read() throws IOException
	{
		// TODO Implement read (no args)
		return 0;
	}
	
	/**
	 * Reads characters into a portion of an array. Reads characters from the underlying Reader into a portion of an array and decodes the read portion.
	 */
	public int read(char[] arg0, int arg1, int arg2) throws IOException
	{
		// TODO Implement read (with args)
		return 0;
	}
	
	/**
	 * Skips characters
	 * @param n number of characters to skip
	 * @return number of characters to actually skip
	 */
	public long skip(long n)
	{
		// TODO Implement skip
		return n;
	}
	
	/**
	 * Tells whether this stream is ready to be read.
	 */
	public boolean ready() throws IOException
	{
		// TODO Implement ready
		return false;
	}
	
	/**
	 * Tells whether this stream supports the mark operation.
	 */
	public boolean markSupported()
	{
		// TODO Implement markSupported
		return false;
	}
	
	/**
	 * Rests the stream
	 */
	public void reset() throws IOException
	{
		// TODO Implement reset
	}

}
