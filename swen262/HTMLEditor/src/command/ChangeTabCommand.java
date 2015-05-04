package command;

import java.util.LinkedList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.Display;
import main.StaticUtilities;
import tab.Tab;
import tab.TabPanel;

public class ChangeTabCommand implements CommandInterface, ChangeListener {

	private AddNewTabCommand addNewTabCommand;
	
	public ChangeTabCommand(){
		init();
	}
	
	private void init(){
		addNewTabCommand = new AddNewTabCommand();
	}

	@Override
	public void execute() {
		TabPanel tabs = Display.getDisplay().getTabPanel();
        LinkedList<Tab> tabList = tabs.getList();
        int tabIndex = tabs.getSelectedIndex();
        int tabCount = tabs.getTabCount();
        int lastTab = tabCount - 1;
        if(tabIndex == tabCount - 1){
        	addNewTabCommand.execute();
        }
        StaticUtilities.updateLinkViewMenuItem();
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		execute();
	}

}
