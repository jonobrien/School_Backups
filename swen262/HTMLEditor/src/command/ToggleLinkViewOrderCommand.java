package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Display;
import tab.Tab;

public class ToggleLinkViewOrderCommand implements ActionListener,
        CommandInterface {

    @Override
    public void execute() {
        for(Tab t: Display.getDisplay().getTabPanel().getList()){
            t.getContent().toggleLinkViewOrder();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        execute();
    }

}
