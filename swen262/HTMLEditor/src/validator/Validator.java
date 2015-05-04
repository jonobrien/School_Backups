package validator;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JTextArea;

/**
 * This class is responsible solely for validating the html code in 
 * the current tab's buffer (TextArea). The singleton's purpose is the
 * validate() method that returns whether or not the buffer is well formed.
 * 
 * The validator implements both the singleton and iterator patterns.
 * 
 * The iterator pattern is followed through the use of a Iterator and Container 
 * interface provided within this package.
 *
 */
public class Validator implements Container{
	
	//initialize a singledton Validator to null
	public static Validator validator = null;
	
	//Arraylist of tags for initally collecting
	private ArrayList<Tag> tags = new ArrayList<Tag>();
	
	//Stack of tags for validating balanced tags
	private Stack<Tag> tagsStack = new Stack<Tag>();
	
	//initialize pattern object with the above tag regular expression
	public Validator(){
		super();
	}

	/**
	 * getValidator is responsible for following the Singleton pattern. If the
	 * Validator hasn't been initialized, initialize it and return it. It it has,
	 * return it.
	 * @return validator - Singleton Validator
	 */
	public static Validator getValidator(){
		if(validator == null){
			validator = new Validator();
		}
		return validator;
	}
	
	/**
	 * validate() is the method responsible for communicating back to the display whether
	 * or not the TextArea is well formed for html. To do this, it first splits the TextArea's
	 * contents by new lines and spaces to get each individual string. It then runs each String
	 * though the pattern matcher. If they match, it's a tag, so a new Tag object is created and
	 * added to the ArrayList of tags. 
	 * 
	 * Then, through the use of the Stack, it uses an iterator to iterate through the ArrayList of tags
	 * to push and pop balancing tags. If it iterates through all the tags in the ArrayList, its well formed;
	 * if road blocks are found, it isn't well formed.
	 * 
	 * @param buffer - TextArea from the tab
	 * @return boolean true/false whether the buffer is well-formed
	 */
	public boolean validate(JTextArea buffer){

		String[] content = buffer.getText().split("<");
		
		char[] current_line;
		String current_tag = "";
		
		for(int i=0; i<content.length; i++){
			current_tag = "";
			current_line = content[i].toCharArray();
			for(int x = 0; x < current_line.length; x++){
				if(current_line[x] != '>'){
					current_tag += current_line[x];
				} else {
					String[] current = current_tag.split(" ");
					String sol = "";
					for(String s : current){
						if(s.length() > 0)
							sol = s;
						break;
					}
					tags.add(new Tag(sol));
				}
			}
		}
		
		for(int i = 0; i < tags.size(); i++){
			System.out.println(tags.get(i).getContents());
			System.out.println(tags.get(i).isEndTag());
		}
		
		//validation algorithm using iterator:
		for(Iterator iter = this.getIterator(); iter.hasNext();){
			Tag curr = (Tag) iter.next();
			if(curr.isEndTag()){
				if(tagsStack.isEmpty()){
					this.tags.clear();
					this.tagsStack.clear();
					return false;
				}
				Tag check = tagsStack.pop();
				if(!check.getContents().equals(curr.getContents())){
					//clear fields for next validation
					this.tags.clear();
					this.tagsStack.clear();
					return false;
				}
			} else {
				if(!curr.getContents().equals("img"))
					tagsStack.push(curr);
			}
		}
		
		if(tagsStack.isEmpty()){
			this.tags.clear();
			this.tagsStack.clear();
			return true;
		}
		
		this.tags.clear();
		this.tagsStack.clear();
		return false;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new TagIterator();
	}
	
	/**
	 * This is the implemented Iterator that the above Validator class
	 * uses. It implements the methods found in the iterator interface.
	 *
	 */
	private class TagIterator implements Iterator{

		int index;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < tags.size())
				return true;
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext())
				return tags.get(index++);
			return null;
		}
		
	}
	
}

