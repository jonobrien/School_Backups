/*
 * Test3.java
 * 
 * Re
 */
import java.util.Scanner;

public class Test3 {

	private Test3() {}
	
	public static void main( String[] args ) {

        Scanner in = new Scanner( System.in );
        DocObject ps1 = new TextObject( "Hello");
        DocObject ps2 = new TextObject( "World!");
        DocObject ordered = new ListObject(true);
        ordered.addChild(0, ps1);
        ordered.addChild(1, ps2);
        
        DocObject ps3 = new TextObject( "unordered");
        DocObject ps4 = new TextObject( "this");
        DocObject ps5 = new TextObject("is");
        DocObject unordered = new ListObject(false);
        unordered.addChild(0, ps3);
        unordered.addChild(1, ps4);
        unordered.addChild(2, ps5);
        
        DocObject document = new RootObject( "Test 3", unordered );
        DocObject document2 = new RootObject( "Test 3", ordered );

        
        
        Diagnostics.displayDocTree( document, "" );
        Diagnostics.renderAndWait( in, document );
        
        Diagnostics.displayDocTree( document2, "" );
        Diagnostics.renderAndWait( in, document2 );
        
	}
}
