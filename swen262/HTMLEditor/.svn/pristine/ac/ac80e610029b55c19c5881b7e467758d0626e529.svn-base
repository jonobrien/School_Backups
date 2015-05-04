package tab;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import main.StaticUtilities;

import command.BoundUndoByMouseCommand;
import command.KeyPressedCommand;

/**
 * This class is responsible for holding the tab's buffer, which
 * is only a TextArea with scroll bars. When initialized, a text listener
 * is added to the TextArea to recieve text events to recognize if a file
 * has been modified and may need to be saved.
 * 
 */
@SuppressWarnings("serial")
public class TabContentTextBuffer extends JTextArea {
	
	/**
	 * Constructor:
	 * 		initializes TextArea with scroll bars
	 */
    public TabContentTextBuffer(Tab parent){
        super();
        init(parent);
    }    
    
    /**
     * This method is responsible for adding a text linstener to notify the tab
     * that changes have been made (for saving purposes).
     */
    private void init(Tab parent){
    	//this.setFont(new Font("Consolas", Font.PLAIN, 15));
    	this.setFont(new Font("Consolas", Font.PLAIN, 16));
        this.setLineWrap( StaticUtilities.getLineWrap() );
        this.setWrapStyleWord( StaticUtilities.getWrapOnWord() );
        this.getDocument().addDocumentListener( new TabSavedMonitor());
        this.addKeyListener( new KeyPressedCommand( parent ) );
        this.addMouseListener( new BoundUndoByMouseCommand( parent ));
    }
    
    public void removeText(int position, int length){
        try {
            this.getDocument().remove( position , length );
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void insertText(int position, String text){
        try{
            this.getDocument().insertString( position , text , null );
        }catch(BadLocationException e) {
            e.printStackTrace();
        }
    }
}
