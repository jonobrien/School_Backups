package tab;

import java.util.ArrayList;

public class Link {

	private String url;
	private int totalOccurances;
	
	private ArrayList<Integer> occurances;
	
	public Link(String url, int occurance){
		this.url = url;
		this.occurances = new ArrayList<Integer>(1);
		this.occurances.add(occurance);
		this.totalOccurances = 1;
	}
	
	public void addOccurance(int newOccurance){
	    occurances.add(newOccurance);
		this.totalOccurances++;
	}
	
	public boolean equals(Object o){
		String otherUrl = ((Link) o).getURL();
		return otherUrl.equals(this.url);
	}
	
	public int compare(Link otherLink){
		int result = 0;
		char c1, c2;
		c1 = this.url.toCharArray()[0];
		c2 = otherLink.getURL().toCharArray()[0];
		result = c1 - c2;
		return result;
	}
	
	public String getURL(){
		return this.url;
	}
	
	public ArrayList<Integer> getOccurances(){
	    return this.occurances;
	}
	
	public int getTotalOccurances(){
	    return this.totalOccurances;
	}
}
