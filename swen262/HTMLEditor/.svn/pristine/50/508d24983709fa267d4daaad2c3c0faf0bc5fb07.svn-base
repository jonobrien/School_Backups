package tab;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TabHeader is responsible for holding and handling the data of 
 * the tab that is visible at all times (title/index/close button).
 */
@SuppressWarnings("serial")
public class TabHeader extends JPanel {
    
	//TabCloseButton for each tab
    private TabCloseButton closeButton;
    
    //Filename of tab (initialized to "untitled")
    private JLabel title;
    
    //index of respected tab
    @SuppressWarnings("unused")
    private int index;

    /**
     * Constructor when opeing a file (known filename)
     * @param index - index of respected tab
     * @param title - filename to be shown on tab
     */
    public TabHeader(int index, String title){
        super();
        init(index, title);
    }
    
    /**
     * Constructor for a new tab (unknown filename)
     * @param index - index of respected tab
     */
    public TabHeader(int index){
        super();
        init(index, "untitled");
    }
    
    /**
     * init is responsible initializing the contents of the TabHeader
     * and for formatting the view of the TabHeader itself.
     * @param index - index of respected tab
     * @param title - filename to be shown on tab (may be unknown : "untitled")
     */
    private void init(int index, String title){
        closeButton = new TabCloseButton(index);
        this.title = new JLabel( title );
        this.index = index;
        
        super.setLayout( new BorderLayout() );
        super.setOpaque( false );
        super.add( this.title, BorderLayout.WEST );
        super.add( closeButton, BorderLayout.EAST );
    }
    
    /**
     * getButton is a getter method for the TabHeader's TabCloseButton
     * @return TabCloseButton
     */
    public TabCloseButton getButton(){
		return this.closeButton;
    	
    }
    
    /**
     * When a tab change is made in the view (closing of tabs), updateIndex is called to change
     * the header's and closeButon's index respectively.
     * @param newIndex
     */
    public void updateIndex(int newIndex){
    	this.index = newIndex;
    	this.closeButton.updateIndex(newIndex);
    }

    /**
     * getTitle is a getter method for the tab header's tilte (filename).
     * @return
     */
    public String getTitle(){
        return this.title.getText();
    }
    
    /**
     * updateTitle is responsible for updating the tabs title (filename) when
     * the tab is saved to a different filename.
     * @param newTitle
     */
    public void updateTitle(String newTitle) {
        this.title.setText( newTitle );
    }
    
}
