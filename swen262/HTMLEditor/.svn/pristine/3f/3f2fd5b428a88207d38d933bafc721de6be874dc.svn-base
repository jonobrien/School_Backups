package command;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;

import javax.swing.text.BadLocationException;

import main.StaticUtilities;
import tab.Tab;
import tab.TabContentTextBuffer;

public class KeyPressedCommand implements CommandInterface, KeyListener {

    private final static int CTRL_V_CODE = 22;
    private final static int CTRL_X_CODE = 24;
    private final static int BACKSPACE_CODE = 8;
    private final static int DELETE = 127;
    
    /**
     * Tab Buffer that will be observed for key inputs
     */
    private Tab parent;
    
    /**
     * Observes a tab buffer to look for specific key inputs
     * @param tabContentBuffer = tab buffer to observe
     * */
    public KeyPressedCommand(Tab parent){
        this.parent = parent;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((int)e.getKeyChar());
        int keyPressed = (int)e.getKeyChar();
        TabContentTextBuffer tabContentBuffer = parent.getContent().getBuffer();
        String selectedText = tabContentBuffer.getSelectedText();
        int position = tabContentBuffer.getCaretPosition();
        if((selectedText != null) && (keyPressed < 65535)){
            parent.getUndoBuffer().addDeletAction( selectedText , tabContentBuffer.getSelectionStart() );
        }else if(keyPressed == 65535){
            parent.getUndoBuffer().closeCurrentAction();
        }
        switch(keyPressed){
            case(CTRL_V_CODE):
                try {
                    parent.getUndoBuffer().addInsertAction( (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData( DataFlavor.stringFlavor ) , position );
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case(CTRL_X_CODE):
                //Pass
                break;
            case(BACKSPACE_CODE):
            case(DELETE):
                if(selectedText == null){
                    if(!(position == tabContentBuffer.getText().length() && keyPressed == DELETE)){
                        try {
                            parent.getUndoBuffer().addToDeleteUndo( tabContentBuffer.getText( position - (keyPressed == BACKSPACE_CODE?1:0) , 1 ) , position - (keyPressed == BACKSPACE_CODE?1:0) );
                        } catch (BadLocationException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
        TabContentTextBuffer tabContentBuffer = parent.getContent().getBuffer();
        
    	int startIndex = tabContentBuffer.getCaretPosition();
    	int endIndex;
    	int oldIndent;
    	
        if(e.getKeyChar() == '\t'){
            //If tab key is hit
            try{
                //Removed inserted tab character
                tabContentBuffer.getDocument().remove( tabContentBuffer.getCaretPosition() - 1 , 1 );
                //Insert tab spaces
                parent.getUndoBuffer().addInsertAction( StaticUtilities.getTab() , tabContentBuffer.getCaretPosition() );
                tabContentBuffer.insert( StaticUtilities.getTab() ,tabContentBuffer.getCaretPosition());
            }catch (BadLocationException e2){}
        }else if (e.getKeyChar() == '\n' && StaticUtilities.getAutoIndent()){
            //If enter key is hit
            //Auto Indent
            oldIndent = getLastLineIndentation( tabContentBuffer );
            parent.getUndoBuffer().addInsertAction( "\n" + StaticUtilities.spaces( oldIndent ) , tabContentBuffer.getCaretPosition() - 1 );
            tabContentBuffer.insert(StaticUtilities.spaces( oldIndent ),tabContentBuffer.getCaretPosition());
        }
        else if(Character.toString( e.getKeyChar() ).matches( 
                    "[a-zA-Z0-9\\,\\.\\/\\<\\>\\?\\;\\'\\:\\\"\\[\\]\\{\\}\\|\\\\\\`\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\+\\=]" )){
            parent.getUndoBuffer().addToTypingUndo( Character.toString(e.getKeyChar()), tabContentBuffer.getCaretPosition() - 1 );
        }
        endIndex = tabContentBuffer.getCaretPosition();
        int length = endIndex - startIndex;
        if (length == 0) {
        	length = 1;
        }
        
    }

    @Override
    public void execute() {
        //pass
    }
    
    /**
     * Get the indentation of the line previous to the one the caret is currently on in tabContentBuffer
     * @return number of spaces to indent on the new line
     */
    private int getLastLineIndentation(TabContentTextBuffer tabContentBuffer){
        int count = 0;
        try {
            int lastLineIndex = tabContentBuffer.getLineOfOffset( tabContentBuffer.getCaretPosition() )-1;
            int lastLineStart = tabContentBuffer.getLineStartOffset( lastLineIndex );
            int lastLineLength = tabContentBuffer.getLineEndOffset( lastLineIndex ) - lastLineStart;
            String lastLine = tabContentBuffer.getText( lastLineStart , lastLineLength );
            for(count = 0;count < lastLine.toCharArray().length;count++){
                if(lastLine.toCharArray()[count] != ' '){
                    break;
                }
            }
            int openTags = 0;
            for(String s : lastLine.split( "<" )){
                if(s.contains( ">" ) && !s.contains( "br>") && !s.trim().matches( "img\\ssrc=\".*" )){
                    if(!s.startsWith( "/" )){
                        openTags++;
                    }else{openTags--;}
                    openTags = StaticUtilities.antiNegativeOne( openTags );
                }
            }
            if(openTags > 0){count += StaticUtilities.getTabSpaces();}
        } catch (BadLocationException e1) {}
        return count;
    }

}
