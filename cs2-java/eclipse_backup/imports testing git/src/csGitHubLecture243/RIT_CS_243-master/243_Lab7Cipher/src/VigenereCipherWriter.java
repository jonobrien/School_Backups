import java.io.IOException;
import java.io.Writer;

/**
 * VigenereCipherWriter.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * VigenereCipherWriter
 * A Vigenere cipher writer
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class VigenereCipherWriter extends Writer
{
	// Underlying (decorated) output stream
	private Writer os;
	// Keyword
	private String keyword;
	
	/**
	 * Creates a new Cipher Writer
	 * @param wr underlying Writer
	 * @param keyword The Vigenere cipher keyword. Although the keyword may include both lowercase and uppercase Roman alphabetic characters, the keyword is used in a case-insensitive manner. That is, both the character 'c' and the character 'C' in the keyword induce a rotation of 3.
	 * @throws IllegalArgumentExceptionThrown if keyword is a string that is empty or is not exclusively comprised of characters in the range 'a' through 'z' and 'A' through 'Z'.
	 */
	public VigenereCipherWriter(Writer wr, String keyword) throws IllegalArgumentException
	{
		// TODO Implement constructor
		this.os = wr;
		this.keyword = keyword;
	}
	
	/**
	 * Writes a single character. Encodes a single character and writes it to the underlying Writer.
	 */
	public void write(int ci) throws IOException
	{
		// TODO Implement write (single character)
	}

	/**
	 * Closes the stream
	 * Flushing it first
	 */
	public void close() throws IOException
	{
		// TODO Implement close
		flush();
		os.close();
	}

	/**
	 * Flushes the stream
	 */
	public void flush() throws IOException
	{
		// TODO Implement flush
		os.flush();
	}

	/**
	 * Writes a portion of an array of characters. Encodes a portion of an array and writes the encoded portion to the underlying OutputStream.
	 */
	public void write(char[] arg0, int arg1, int arg2) throws IOException
	{
		// TODO Implement write (any portion of array of characters)
	}
}
