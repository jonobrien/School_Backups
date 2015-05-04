package command;

import main.StaticUtilities;

public class UndoDeleteCommand implements UndoCommandInterface {

    @Override
    public void execute(ActionObject action) {
        System.out.println("Attempting to insert " + action.getData() + " at position " + action.getPosition());
        StaticUtilities.getCurrentTab().getContent().getBuffer().insertText(action.getPosition(),action.getData());
    }

}
