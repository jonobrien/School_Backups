import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Redact.java
 *
 * File:
 *      $Id$
 *
 * Revisions:
 *      $Log$
 *
 */

/**
 * Redact Class
 * A redact program
 * @author Nicolas Manoogian <njm7461@cs.rit.edu>
 */

public class Redact
{
	/**
	 * Main method to redact
	 * <pre>Usage: java Redact word-file input-file output-file</pre>
	 * @param args word-file input-file output-file
	 */
	public static void main(String[] args)
	{
		// Verify arguments
		if (args.length != 3)
		{
			System.err.println("Usage: java Redact <word-file> <input-file> <output-file>");
			System.exit(1);
		}
		
		// Build a redacts list
		HashSet<String> redacts = new HashSet<String>();
		
		// Load the redacts text
		Scanner redscanner = null;
		try
		{
			redscanner = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e2)
		{
			System.err.println("word file was not found");
			System.exit(1);
		}
		// Populate the set
		while (redscanner.hasNext())
		{
			redacts.add(redscanner.next());
		}
		
		// Build the writer
		RedactWriter redactWriter = null;
		try
		{
			// Write to the specified output
			Writer w = null;
			// Use standard output if dash is specified
			if (args[2].equals("-"))
			{
				w = new PrintWriter(System.out);
			}
			else
			{
				w = new FileWriter(new File(args[2]));
			}
			redactWriter = new RedactWriter(w, redacts);
		}
		catch (IllegalArgumentException e2)
		{
			System.err.println(e2.getMessage());
			System.exit(1);
		}
		catch (IOException e2)
		{
			System.err.println("could not write file");
			System.exit(1);
		}

		// Initialize the reader
		BufferedReader in = null;
		try
		{
			// Use standard input if dash is specified
			if (args[1].equals("-"))
			{
				in = new BufferedReader(new InputStreamReader(System.in));
			}
			else
			{
				in = new BufferedReader(new FileReader(args[1]));
			}
		}
		catch (FileNotFoundException e1)
		{
			System.err.println("input file was not found");
			System.exit(1);
		}
		
		// Read from the file, char by char and pass it to the writer
		try
		{
			int currentC;
			while ((currentC = in.read()) != -1)
			{
				redactWriter.write(currentC);
			}
			// Close the writer, reader, and file scanner
			redactWriter.close();
			in.close();
			redscanner.close();
		}
		catch (IOException e)
		{
			System.err.println("IO Error");
			System.exit(1);
		}
	}
}
