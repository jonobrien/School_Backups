import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;

/**
 * RedactWriter.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * RedactWriter Class
 * A redact writer
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class RedactWriter extends Writer
{
	// Underlying writer
	private Writer writer;
	// HashSet of redacted words
	private HashSet<String> redactedWords;
	// String buffer containing the current words
	private String buffer;

	/**
	 * Creates a redact writer
	 * @param wr the underlying Writer
	 * @param redacts A collection of words to be redacted
	 * @throws IllegalArgumentException Thrown if redacts includes a string that is empty or is not exclusively comprised of characters in the range 'a' through 'z' and 'A' through 'Z'.
	 */
	public RedactWriter(Writer wr, Collection<String>redacts) throws IllegalArgumentException
	{
		// Initialize writer and buffer String
		writer = wr;
		buffer = "";
		
		// Check to make sure all Strings in the redacts collection are valid
		for (String r : redacts)
		{
			if (!r.toLowerCase().matches("[a-zA-Z]+") || r.equals(""))
			{
				throw new IllegalArgumentException("The following string is illegal: " + r);
			}
		}
		
		// Build a HashSet based on Collection
		redactedWords = new HashSet<String>(redacts);
	}

	/**
	 * Closes the stream, flushing it first. Because no additional
	 * characters may be written to a closed Writer, any buffered characters
	 * should be written to the underlying Writer as though they were a completed word.
	 */
	@Override
	public void close() throws IOException
	{
		// Write the buffer
		for (char p : buffer.toCharArray())
		{
			writer.write(p);
		}
		
		// Clear the buffer
		buffer = "";
		
		// Flush the writer
		writer.flush();
	}

	/**
	 * Flushes the stream.
	 * The flush method does not adhere to the complete specification given 
	 * by Flushable.flush and Writer.flush, because it is impossible to know if 
	 * the buffered characters correspond to a word that should be redacted until
	 * subsequent written characters are observed. The flush method does, however,
	 * flush the underlying Writer.
	 */
	@Override
	public void flush() throws IOException
	{
		if (redactedWords.contains(buffer))
		{
			// Write Xs to writer
			for (int i = 0; i < buffer.length(); i++)
			{
				writer.write('X');
			}
		}
		else
		{
			// Write buffer to writer
			for (int i = 0; i < buffer.length(); i++)
			{
				writer.write(buffer.charAt(i));
			}
		}

		// Clear buffer
		buffer = "";
		// Flush the writer
		writer.flush();
	}

	/**
	 * Writes a portion of an array of characters.
	 * Passes each of the characters to the single character write function
	 * @param cbuf character buffer to write
	 * @param off location to start in the buffer
	 * @param len number of characters from the buffer to add
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException
	{
		for (int bufferindex = off; bufferindex < off + len && bufferindex < cbuf.length; bufferindex++)
		{
			write(cbuf[bufferindex]);
		}
	}
	
	/**
	 * Writes a single character.
	 * If the character belongs to a redacted word, writes 'X' to the underlying Writer.
	 * Otherwise, writes the character to the underlying Writer.
	 * @param single character to write
	 */
	@Override
	public void write(int c) throws IOException
	{

		// If the character is not a letter
		if (!Character.isLetter(c))
		{
			flush();
			writer.write(c);
		}
		else
		{
			// Add the character to the buffer
			buffer += Character.toString((char) c);
		}
	}
}
