import java.util.ArrayList;

/*
 * 
 * TextObject.java
 * 
 * Version:
 * $Id: TextObject.java,v 1.4 2014/03/04 13:32:38 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: TextObject.java,v $
 * Revision 1.4  2014/03/04 13:32:38  jvo7822
 * Finished ListObject, wrote test for ListObject (test3.java) and fixed the Style replacement throughout the classes.
 *
 * Revision 1.3  2014/03/03 03:05:39  jvo7822
 * Code runs, need to debug Header and Style Object(s) and the replace() methods, and complete ListObject.
 *
 * Revision 1.2  2014/03/01 17:49:11  jvo7822
 * style object...
 *
 * Revision 1.1  2014/02/28 22:27:13  jvo7822
 * Initial Commit.
 *
 * 
 * 
 */

/**
 * This class represents DocObjects consisting of completely plain text.
 * @author Jon O'Brien
 *
 */
public class TextObject implements DocObject{
	
	/**
	 * constructor - creates text object
	 * @param text - the string to be contained in this node
	 */
	String text;
	public TextObject(String text) {
		this.text = text;
		//TODO text name is messed up here
	}
	
	/**
	 * a string of plain text
	 * @return a string containing legal XHTML that represents 
	 * the doc tree rooted at this node
	 */
	public String generateHTML() {
		return getText();
	}
	//TODO 
	public String getText() {
		return text;
	}
	
	
	/**
	 * How many printable characters are in this subtree of the document?
	 * @return - a long
	 */
	public long characterCount() {
		String [] split = text.split(" ");
		long count = 0;
		for (String tempString : split) {
			count += tempString.length();//splits and adds length to count in this method
		}
		return count;
		
	}
	
	/**
	 * Search for a given character sequence in this subtree of the document
	 * @param s - the search string
	 * @return -  true iff the search string is found in a single node of 
	 * the tree rooted at this document node
	 */
	public boolean contains(String s) {
		//return text.toLowerCase().contains(s.toLowerCase());
		return (text.contains(s));
		
	}
	
	/**
	 * What are the subtrees of this document node? Postcondition: returned 
	 * list is unmodifiable.
	 * @return - a list of the direct descendant document object nodes of this 
	 * node, preserving the order in which they were inserted. If this node's 
	 * type is one that does not have children, an empty list is returned. If 
	 * this node's type has a single subordinate DocObject, that single node 
	 * is returned in a singleton list.
	 */
	public java.util.List<DocObject> children() {
		ArrayList<DocObject> returnList = new ArrayList<DocObject>();
		return returnList;
		
	}
	
	/**
	 * In TextObjects, the old string is sought as a possible substring 
	 * anywhere in the object's current text and replaced with newS.
	 * @param oldS - the search string
	 * @param newS - the string that replaces each occurrence of the search string
	 */
	public void replace(String oldS, String newS) {
		String [] split = text.split(" ");
		String newtext = "";
		
		for (String tempString : split) {
			if (tempString.equals(oldS)) {//splits and checks to old part
				//re-adds to new string
			tempString = newS;
		}
		newtext = newtext + tempString + " ";
			//splits and adds length to count in this method
		}
		text = newtext;
	}
	
	
	/**
	 * Replace all occurrences of the search object with a new object. The 
	 * equality operator "==" (not the equals method) is used to identify the 
	 * search object in the document tree. The assignment operator (not a 
	 * copying operation) is used to insert the new object. If this node's type 
	 * is one that does not have children, this method is a no-op.
	 * @param oldObj - the search object
	 * @param newObj - the object that replaces each occurrence of the search object
	 */
	public void replace(DocObject oldObj, DocObject newObj) {
		//blank because sucks
		
		
	}
	
	/**
	 * Insert a new document object node into the list of children of this 
	 * node. If this node's type is one that does not have children, or 
	 * that has a fixed number of children when created, a BadChildException 
	 * (a descendant of RuntimeException) will occur.
	 * @param before - the index that the new document object will have, i.e., 
	 * its ordinal position in the child list. All children formally at that 
	 * or greater position will have their position numbers increased by one.
	 * @param dObj - the new document object to be inserted
	 */
	public void addChild(int before, DocObject dObj) {
		throw new BadChildException();
		
	}
	
	/**
	 * Is this the root of the document tree?
	 * @return - true iff this is an instance of RootObject.
	 */
	public boolean isRoot() {
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
