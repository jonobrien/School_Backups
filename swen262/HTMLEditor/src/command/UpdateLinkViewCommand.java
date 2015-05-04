package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tab.Tab;
import main.Display;

public class UpdateLinkViewCommand implements ActionListener, CommandInterface {

    @Override
    public void execute() {
        for(Tab t: Display.getDisplay().getTabPanel().getList()){
            t.getContent().updateLinkView();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        execute();
    }

}
