/**
 * @author Jon O'Brien
 * square class that implements shape methods
 */

package lecture3;

public class Square implements Shape{
	double side;
	
	
	
	@Override
	public double area(){
		return side*side;
	}

	public int compareTo(Square s){
		if(this.side < s.side){
			return -1;
		}
		else if(this.side == s.side){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public String toString(){
		return String.valueOf(value);
		
	}
}
