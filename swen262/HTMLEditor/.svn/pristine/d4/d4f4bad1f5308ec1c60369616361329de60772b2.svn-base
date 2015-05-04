package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.StaticUtilities;

/**
 * UpdateTabSizeCommand is a concrete command object responsible for updating
 * the global size of future tabs
 */
public class UpdateTabSizeCommand implements ActionListener, CommandInterface {

    @Override
    public void execute() {
        String newTabSizeString = (String) JOptionPane.showInputDialog(null,"New Tab Size","Updating Tab Size",JOptionPane.QUESTION_MESSAGE,null,null,Integer.toString(StaticUtilities.getTabSpaces()));
        if(newTabSizeString != null){
            StaticUtilities.setTabSpaces( Integer.parseInt( newTabSizeString ));
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        execute();
    }

}
