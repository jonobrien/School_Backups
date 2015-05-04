package main;

public class Main {

	//main to run the editor
	public static void main(String[] args) {
	    Display.getDisplay().setVisible(true);
	    
	    //executes any command line arguments
		for(int i = 0;i < args.length;i++){
		    Display.getDisplay().getFileOpener().execute( args[i] );
		}
		if(args.length > 0){
		    Display.getDisplay().getTabPanel().getList().get( 0 ).getHeader().getButton().getActionListeners()[0].actionPerformed( null );
		}
	}
}
