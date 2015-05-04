package command;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tab.Tab;

public class BoundUndoByMouseCommand implements MouseListener, CommandInterface {

    Tab relativeTab;
    
    public BoundUndoByMouseCommand(Tab relativeTab) { 
        this.relativeTab = relativeTab;
    }
    
    @Override
    public void execute() {
        relativeTab.getUndoBuffer().closeCurrentAction();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        execute();
    }

    @Override
    public void mouseEntered(MouseEvent e) {        
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }

    @Override
    public void mousePressed(MouseEvent e) {        
    }

    @Override
    public void mouseReleased(MouseEvent e) {        
    }

}
