package command;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.StaticUtilities;


/**
 * @JavaDoc
 * This class performs the undo/redo operations on the text area based on the given 
 * input object and restores/removes the desired content
 */
public class UndoCommand implements CommandInterface, ActionListener {

    private UndoInsertCommand insertUndoer;
    private UndoDeleteCommand deleteUndoer;
    
    public UndoCommand(){
        insertUndoer = new UndoInsertCommand();
        deleteUndoer = new UndoDeleteCommand();
    }
    
	@Override
	public void actionPerformed(ActionEvent event) {
		execute();
	}
	
	@Override
	public void execute() {		
		ActionBuffer currUndo = StaticUtilities.getCurrentTab().getUndoBuffer();
		ActionObject currUndoAction = currUndo.getActionToUndo();
		if(currUndoAction != null){
    		switch(currUndoAction.getType()){
    		    case(ActionObject.TYPING):
    		    case(ActionObject.INSERT):
    		        insertUndoer.execute( currUndoAction );
    		        break;
    		    case(ActionObject.DELETE):
    		    case(ActionObject.CUT):
    		        deleteUndoer.execute( currUndoAction );
                    break;
    		    default:
    		        //pass
    		        break;
    		}
		}
	}
	
}