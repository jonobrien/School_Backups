package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tab.Tab;
import main.Display;
import main.MenuItemOption;
import main.StaticUtilities;

/**
 * UpdateWrapOnWordCommand is a concrete command object responsible changeing
 * the global setting of wraping on words and icons associated with it 
 */
public class UpdateWrapOnWordCommand implements ActionListener, CommandInterface {
    
    /**
     * The menu item clicked for toggling wrap on word
     */
    private MenuItemOption menuItemOption;
    
    /**
     * Concrete command observing a menu item
     * @param menuItemOption - the menu item for toggling wrap on word
     */
    public UpdateWrapOnWordCommand(MenuItemOption menuItemOption) {
        this.menuItemOption = menuItemOption;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

    @Override
    public void execute() {
        StaticUtilities.toggleWrapOnWord();
        for(Tab t : Display.getDisplay().getTabPanel().getList()){
            t.getContent().getBuffer().setWrapStyleWord( StaticUtilities.getWrapOnWord() );
        }
        if(StaticUtilities.getWrapOnWord()){
            menuItemOption.setIcon( StaticUtilities.onImage );
        }else{
            menuItemOption.setIcon( StaticUtilities.offImage );
        }
    }
}
