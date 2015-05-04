package command;

import main.StaticUtilities;

public class UndoInsertCommand implements UndoCommandInterface {

    @Override
    public void execute(ActionObject action) {
         //System.out.println("Attempting to remove " + action.getData() + " of length " + action.getSize() + " at position " + action.getPosition());
         StaticUtilities.getCurrentTab().getContent().getBuffer().removeText(action.getPosition(),action.getSize());
    }

}
