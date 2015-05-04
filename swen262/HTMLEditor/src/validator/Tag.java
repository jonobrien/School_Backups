package validator;

/**
 * This class is responsible for holding the contents of
 * each html tag in the editor buffer when validating. Apon
 * initialization, the tag is parsed to assign it's type
 * (start/end) and is stripped of all html tag syntax (<,/,>).
 */
public class Tag {

	//the contents within the tag
	private String contents;
	
	//whether or not the tag is an end tag or start tag
	private boolean isEndTag;
	
	/*
	 * Initializes the tag
	 */
	public Tag(String tag){
		initializeType(tag);
		this.contents = tag.replaceAll("/", "");
	}
	
	/**
	 * itializeType takes in a String and sets the tag's isEndTag
	 * field to true/false depending on its type.
	 * @param tag - String
	 * @return void
	 */
	private void initializeType(String tag) {
		if(tag.startsWith("/"))
			this.isEndTag = true;
		else
			this.isEndTag = false;
	}

	/**
	 * isEndTag is a getter method to get the current tags isEndTag field.
	 * @return boolean isEndTag
	 */
	public boolean isEndTag(){
		return this.isEndTag;
	}
	
	/**
	 * getContents is a getter method to get the current tags contents.
	 * That is the string within the html tags.
	 * @return String contents
	 */
	public String getContents(){
		return this.contents;
	}
}
