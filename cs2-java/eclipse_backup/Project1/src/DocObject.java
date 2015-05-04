import java.util.List;

/*
 * 
 * DocObject.java
 * 
 * Version:
 * $Id: DocObject.java,v 1.2 2014/02/28 23:40:51 jvo7822 Exp $
 * 
 * Revisions:
 * $Log: DocObject.java,v $
 * Revision 1.2  2014/02/28 23:40:51  jvo7822
 * Lots of copy and paste.
 *
 * Revision 1.1  2014/02/28 22:27:14  jvo7822
 * Initial Commit.
 *
 * 
 * 
 */

public interface DocObject {

	String generateHTML();

	long characterCount();

	boolean contains(String s);

	void replace(String oldS, String newS);

	void replace(DocObject oldObj, DocObject newObj);

	boolean isRoot();

	List<DocObject> children();

	void addChild(int before, DocObject dObj);


}
