package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MenuItemOption;
import main.StaticUtilities;
import tab.Tab;

public class ToggleLinkViewCommand implements CommandInterface, ActionListener {
	
	@Override
	public void execute() {
		Tab currentTab = StaticUtilities.getCurrentTab();
		currentTab.getContent().toggleView();
		StaticUtilities.updateLinkViewMenuItem();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		execute();
	}

}
