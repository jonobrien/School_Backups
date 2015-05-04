package tab;

import javax.swing.JScrollPane;

public class TabContentText extends JScrollPane{
	
	private TabContentTextBuffer buffer;
	
	public TabContentText(TabContentTextBuffer buffer){
		super(buffer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.buffer = buffer;
	}
	
	public TabContentTextBuffer getBuffer(){
		return buffer;
	}
	
}
