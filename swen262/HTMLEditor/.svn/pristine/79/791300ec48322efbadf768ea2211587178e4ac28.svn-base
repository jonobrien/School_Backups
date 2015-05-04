package main;

import javax.swing.ImageIcon;

import tab.Tab;

/**
 * This class consists of a few static utility methods.
 * Its purpose is soley to house any static methods that
 * perform reusable functionality.
 */
public class StaticUtilities {
	
	//private static final String URLRegex = "^(?:(?:https?|ftp)://)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/i";
    
    private static int tabSpaces = 4;
    private static boolean lineWrap = false;
    private static boolean wrapOnWord = false;
    private static boolean autoIndent = true;
    
    
    //the types for each command for checking
  	private static int INSERTHTML = 1;
  	private static int CUT = 2;
  	private static int PASTE = 3;
  	private static int TEXTENTRY = 4;
  	private static int TEXTDELETION = 5;
  	private static int OUTLINE = 6;
    
    
    private static MenuItemOption linkViewMenuItem;
    
    //public static Font globalFont;
    public static final ImageIcon offImage = new ImageIcon("res/icons/close.png");
    public static final ImageIcon onImage = new ImageIcon("res/icons/on.png");
    
	/**
	 * anitNegativeOne simply protects the return of index out of bounds
	 * errors that could possibly arise. It takes the value, it it's out
	 * of bounds (-1), it is reassigned to index 0.
	 * @param val - value of index
	 * @return val - same value or 0 if negative
	 */
    public static int antiNegativeOne(int val){
        if (val == -1){
            val = 0;
        }
        return val;
    }
    
    /**
     * getCurrentTab simply gets the Tab object of the current selected
     * tab in the dispaly.
     * @return Tab - current tab
     */
    public static Tab getCurrentTab(){
        return Display.getDisplay().getTabPanel().getList().get(Display.getDisplay().getTabPanel().getSelectedIndex());
    }
    
    public static String spaces(int numOfSpaces){
        String spacesString = new String();
        for(int count = 0;count < numOfSpaces;count++){
            spacesString = spacesString.concat( " " );
        }
        return spacesString;
    }
    
    public static String getTab(){
        return spaces(tabSpaces);
    }
    
    public static int getTabSpaces(){
        return tabSpaces;
    }
    
    public static void setTabSpaces(int newLen){
        tabSpaces = newLen;
    }
    
    public static boolean getLineWrap(){
        return lineWrap;
    }
    
    public static void setLineWrap(boolean newLineWrap){
        lineWrap = newLineWrap;
    }
    
    public static boolean getWrapOnWord(){
        return wrapOnWord;
    }
    
    public static void setWrapOnWord(boolean newWrapOnWord){
        wrapOnWord = newWrapOnWord;
    }
    
    public static boolean getAutoIndent(){
        return autoIndent;
    }
    
    public static void setAutoIndent(boolean newAutoIndent){
        autoIndent = newAutoIndent;
    }
    
    public static void toggleLineWrap(){
        lineWrap = !lineWrap;
    }
    
    public static void toggleWrapOnWord(){
        wrapOnWord = !wrapOnWord;
    }
    
    public static void toggleAutoIndent(){
        autoIndent = !autoIndent;
    }

	public static void setLinkViewMenuItem(MenuItemOption linkViewMenuItem) {
		StaticUtilities.linkViewMenuItem = linkViewMenuItem;
	}
	
	public static void updateLinkViewMenuItem(){
		if(getCurrentTab().getContent().getView()){
			linkViewMenuItem.setIcon(onImage);
		}else{
			linkViewMenuItem.setIcon(offImage);
		}
	}
		

	/**
	 * These methods return the types for the ActionObjects
	 * used to undo/redo the commands in the editor
	 */
	public static int getHtml() {
		return INSERTHTML;
	}
	
	public static int getCut() {
	    return CUT;
	}
	
	public static int getPaste() {
	    return PASTE;
	}
	
	public static int getTextEntry() {
	    return TEXTENTRY;
	}
	
	public static int getTextDeletion() {
	    return TEXTDELETION;
	}
	
	public static int getOutline() {
	    return OUTLINE;
	}

	
}
