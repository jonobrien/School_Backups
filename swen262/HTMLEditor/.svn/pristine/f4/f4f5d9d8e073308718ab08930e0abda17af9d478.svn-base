package tab;

import java.util.LinkedList;

import javax.swing.JTabbedPane;

import command.AddNewTabCommand;
import command.ChangeTabCommand;

/**
 * TabPanel acts as the controller of all the tabs. It creates this initial
 * tab, with add-tab tab. It is also responsible for updating all tab's index when
 * tabs are added or closed.
 */
@SuppressWarnings("serial")
public class TabPanel extends JTabbedPane {

	//Linked list of tabs
    LinkedList<Tab> tabList;
    
    /**
     * Constructs TabPanel
     */
    public TabPanel(){
        super();
        init();
    }
    
    /**
     * init creates the first tab and adds an add-tab tab with a
     * new AddNewTabCommand (concrete command). The add-tab tab acts
     * as the invoker of the AddNewTabCommand's execute() method.
     */
    private void init(){
        tabList = new LinkedList<Tab>();
        
        Tab newTab = new Tab(0);
        tabList.add( newTab );
      
        super.addTab(null, newTab.getContent() );
        super.setTabComponentAt( 0 , newTab.getHeader() );       
        super.addTab("+",null);
        super.setSelectedIndex( 0 );
        super.addChangeListener( new ChangeTabCommand());
    }
    
    /**
     * getList is a getter method for the Linked list of tabs
     * @return linked list of tabs
     */
    public LinkedList<Tab> getList(){
        return this.tabList;
    }
    
    /**
     * updateIndecies iterates through all the tabs, and updates
     * each tab's index.
     */
    public void updateIndecies() {
        for(int i = 0;i < tabList.size();i++){
            tabList.get(i).updateIndex(i);
        }
    }
    
}
