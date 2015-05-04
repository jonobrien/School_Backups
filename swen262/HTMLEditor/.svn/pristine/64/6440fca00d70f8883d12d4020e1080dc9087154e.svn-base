package command;

import main.StaticUtilities;


/**
 * This class is the action objects stored in the ActionBuffers that handle undo and redo
 * for the HTMLEditor
 */
public class ActionObject {
    
    public static final int TYPING = 0;
    public static final int INSERT = 1;
    public static final int DELETE = 2;
    public static final int CUT = 3;
    
	private int position;
	
	private String data;
	private int type;
	
	public ActionObject(String initialData, int type, int initialPosition){
	    this.position = initialPosition;
	    this.type = type;
	    this.data = initialData;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getType(){
	    return type;
	}
	
	public void addTyping(String toAdd){
	    if(this.type == TYPING){
	        this.data = this.data.concat( toAdd );
	    }
	}
	
	public void addDeletion(String toDelete, int position){
	    if(this.type == DELETE){
	        if(position < this.position){
	            this.position = position;
	            this.data = toDelete.concat( this.data );
	        }else{
	            this.data = this.data.concat( toDelete );
	        }
	    }
	}
	
	public int getSize(){
	    return data.length();
	}
	
	public String getData(){
	    return data;
	}
	
	public void setPosition(int newPosition){
	    this.position = newPosition;
	}
}

