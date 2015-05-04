package command;

import java.util.Stack;





/**
 * This class holds the buffers used by the undo and redo commands to remove/reinsert data into the editor
 */
public class ActionBuffer {

	private Stack<ActionObject> undoBuffer;
	private ActionObject currentAction;
	
	public ActionBuffer () {
		this.undoBuffer = new Stack<ActionObject>();
		this.currentAction = null;
		}
	
	public ActionObject getActionToUndo() {
	    ActionObject toReturn;
	    if(currentAction != null){
	        toReturn = currentAction;
	        currentAction = null;
	    }else if(undoBuffer.isEmpty()){
	        toReturn = null;
	    }else{
	        toReturn = undoBuffer.pop();
	    }
		return toReturn;
	}
	
	public void addToTypingUndo(String toAdd, int position){
	    position++;
	    if(currentAction == null){
	        currentAction = new ActionObject(toAdd, ActionObject.TYPING, position);
	    }else if(currentAction.getType() != ActionObject.TYPING){
	        undoBuffer.push( currentAction );
	        currentAction = new ActionObject(toAdd, ActionObject.TYPING, position);
	    }else{
	        currentAction.addTyping(toAdd);
            if(currentAction.getSize() >= 10){
                undoBuffer.push( currentAction );
                currentAction = null;
            }
	    }
	}
	
	public void addToDeleteUndo(String toDelete, int position){
	    //position++;
	    if(currentAction == null){
	        currentAction = new ActionObject(toDelete, ActionObject.DELETE, position);
	    }else if(currentAction.getType() != ActionObject.DELETE){
	        undoBuffer.push(currentAction);
	        currentAction = new ActionObject(toDelete, ActionObject.DELETE, position);
	    }else{
	        currentAction.addDeletion( toDelete, position );
	        if(currentAction.getSize() >= 10){
	            undoBuffer.push( currentAction );
	            currentAction = null;
	        }
	    }
	}
	
	public void addInsertAction(String inserted, int position){
	    if(currentAction != null){
	        undoBuffer.push( currentAction );
	        currentAction = null;
	    }
	    undoBuffer.push(new ActionObject(inserted, ActionObject.INSERT, position));
	}
	
	public void addDeletAction(String deleted, int position){
	    //position++;
	    if(currentAction != null){
	        undoBuffer.push( currentAction );
	        currentAction = null;
	    }
	    undoBuffer.push( new ActionObject( deleted , ActionObject.DELETE , position ) );
	}
	
	public void closeCurrentAction(){
	    if(currentAction != null){
	        undoBuffer.push( currentAction );
	        currentAction = null;
	    }
	}
	
}