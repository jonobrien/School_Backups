package main;

/**
 * Enum that represents the supported html tags
 * This will store the opening and closing tags as well as if they are inLine or not
 */
public enum HTMLTag {
    PARAGRAPH("p", false),
    HEADER1("h1", false),
    HEADER2("h2", false),
    HEADER3("h3", false),
    HEADER4("h4", false),
    HEADER5("h5", false),
    HEADER6("h6", false),
    BOLD("strong", true),
    ITALIC("em", true),
    HEAD("head", false),
    BODY("body",false),
    HTML("html",false),
    ORDEREDLIST("ol", false),
    UNORDEREDLIST("ul", false),
    DESCRIPTIONLIST("dl", false),
    LISTITEM("li", false),
    LISTTERM("dt", false),
    LISTDATA("dd", false),
    TABLE("table", false),
    TABLEROW("tr", false),
    TABLEDATA("td", false),
    TABLEHEADER("th", false),
    TABLECAPTION("caption", false),
    ANCHOR("a", true),
    IMAGE("img", true);
    
    /**
     * Opening tag based on the tag type
     */
    private String openingTag;
    /**
     * Closing tag based on the tag type
     */
    private String closingTag;
    /**
     * Whether or no the tag will be created in the same line or split among several
     */
    private boolean inLine;
    
    /**
     * Creates the static objects based on the tags
     * @param tag - What type of tag it is and what text goes inside it
     * @param inLine - Stored to for later, to tell if the tag is and inLine tag of not
     */
    private HTMLTag(String tag, boolean inLine){
        openingTag = "<" + tag + ((tag != null && tag == "img") ? " src=\"" : "") + 
        		((tag != null && tag == "a") ? " href=\"\">" : "") + ((tag != null && tag != "a" && tag != "img") ? ">" : "");
        closingTag = (tag != null && tag == "img") ? "\">" : "</" + tag + ">";
        this.inLine = inLine;
    }
    
    /**
     * Gets the opening tag for a tag type
     * @return - opening tag for the object's tag type
     */
    public String getOpenTag(){
        return this.openingTag;
    }
    
    /**
     * Gets the closing tag for a tag type
     * @return - closing tag for the object's tag type
     */
    public String getCloseTag(){
        return this.closingTag;
    }
    
    /**
     * Gets whether or not the tag is inLine
     * @return - whether of not the tag is inLine
     */
    public boolean getInLine(){
        return this.inLine;
    }
}
