import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * ListObject.java
 * 
 * Version:
 * $Id: ListObject.java,v 1.3 2014/03/04 13:32:38 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: ListObject.java,v $
 * Revision 1.3  2014/03/04 13:32:38  jvo7822
 * Finished ListObject, wrote test for ListObject (test3.java) and fixed the Style replacement throughout the classes.
 *
 * Revision 1.2  2014/02/28 23:40:51  jvo7822
 * Lots of copy and paste.
 *
 * Revision 1.1  2014/02/28 22:27:15  jvo7822
 * Initial Commit.
 *
 * 
 * 
 */

public class ListObject implements DocObject{

public String html;
public boolean isordered;
ArrayList<DocObject> children = new ArrayList<DocObject>();


public ListObject(boolean ordered) {
	if (ordered) {
		isordered = true;
	}
	else {
		isordered = false;
	}
}


/**
 * Convert this subtree of the document to plain-text HTML.
 * @return - a string containing legal XHTML that represents the doc 
 * tree rooted at this node
 */
String paragraph;
@Override
public String generateHTML() {
	if (isordered) {
		//ordered ol
		html = "<ol>";
		for (DocObject object : children) {
			html = html + "<li>" + object.generateHTML() + "</li>";
		}
		html += "</ol>";
	}
	else {
		//unordered
		html = "<ul>";
		for (DocObject object : children) {
			html = html + "<li>" + object.generateHTML() + "</li>";
		}
		html += "</ul>";
	}
	return html;
	}

/**
 * How many printable characters are in this subtree of the document?
 * @return - the number of non-whitespace characters below this node in 
 * the tree
 */
@Override
public long characterCount() {
	long count = 0;
	for (DocObject object : children) {
		count += object.characterCount();
	}
	return count;
}

/**
 * 
 * @param s - the search string
 * @return - true iff the search string is found in a single node of the 
 * tree rooted at this document node
 */
@Override
public boolean contains(String s) {
	for (DocObject object : children) {
		if (object.contains(s)) {
			return true;
		}
	}
	return false;
}

/**
 * What are the subtrees of this document node? Postcondition: returned 
 * list is unmodifiable.
 * @return -     a list of the direct descendant document object nodes 
 * of this node, preserving the order in which they were inserted. If 
 * this node's type is one that does not have children, an empty list 
 * is returned. If this node's type has a single subordinate DocObject, 
 * that single node is returned in a singleton list.
 */
@Override
public List<DocObject> children() {
	List<DocObject> unMod = Collections.unmodifiableList(children);
	//TODO
	return unMod;
}

/**
 * Replace all occurrences of the search string with a new string. As in 
 * the contains method, the search string must exist completely within 
 * one document object node.
 * @param oldS - the search string
 * @param newS - the string that replaces each occurrence of the 
 * search string
 */
@Override
public void replace(String oldS, String newS) {
	for (DocObject object : children) {
		object.replace(oldS, newS);
	}
}

/**
 * Replace all occurrences of the search object with a new object. The 
 * equality operator "==" (not the equals method) is used to identify 
 * the search object in the document tree. The assignment operator (not 
 * a copying operation) is used to insert the new object. If this node's 
 * type is one that does not have children, this method is a no-op.
 * @param oldObj - the search object
 * @param newObj - the object that replaces each occurrence of the 
 * search string
 */
@Override
public void replace(DocObject oldObj, DocObject newObj) {
	for (int i = 0; i < children.size(); i++) {
		if (children.get(i) == oldObj) {
			children.set(i, newObj);
		}
		else {
			//handle the child's child replacement
			children.get(i).replace(oldObj, newObj);//his child
		}
	}
	
}
/**
 * Insert a new document object node into the list of children of this 
 * node. If this node's type is one that does not have children, or 
 * that has a fixed number of children when created, a BadChildException 
 * (a descendant of RuntimeException) will occur.
 * @param before - the index that the new document object will have, 
 * i.e., its ordinal position in the child list. All children formally 
 * at that or greater position will have their position numbers increased 
 * by one.
 * @param dObj - the new document object to be inserted
 */
@Override
public void addChild(int before, DocObject dObj) {
		children.add(before, dObj);
	}


/**
 * Is this the root of the document tree?
 * @return - true iff this is an instance of RootObject
 */
@Override
public boolean isRoot() {
	return false;
}
}