package command;

import java.util.LinkedList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tab.Tab;
import tab.TabPanel;
import main.Display;

/**
 * AddNewTabCommand is a concrete command object responsible for adding a new
 * tab at the end of the tab panel's linkedlist of tabs.
 */
public class AddNewTabCommand implements CommandInterface, ChangeListener {
    
    @Override
    /**
     * execute recieves state changes from the tab panel and if
     * it was invoked from the add-tab button, the method
     * creates a new tab and inserts it at the end of the
     * tab list.
     */
    public void execute() {
        TabPanel tabs = Display.getDisplay().getTabPanel();
        LinkedList<Tab> tabList = tabs.getList();
        int tabIndex = tabs.getSelectedIndex();
        int tabCount = tabs.getTabCount();
        
        tabs.setSelectedIndex(0);
        Tab newTab = new Tab(tabCount - 1);
        tabList.add(newTab);
        tabs.insertTab(null, null, newTab.getContent(), null, tabCount - 1);
        tabs.setTabComponentAt(tabCount - 1, newTab.getHeader());
        tabs.setSelectedIndex( tabCount - 1  );
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        execute();
    }

}
