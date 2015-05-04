package lecture3;

public class ShapeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape1;
		
		
		
		Circle c1 = new Circle(10);
		System.out,println(c1.area())
		
		
		//create a circle object and assign to an interface reference
		Shape c2 = new Circle(20);
		System.out.println(c2.area);

		
		//array of Shape references
		Shape[] items = new Shape[5];
		items[0] = new Circle(6);
		items[1] = new Circle(8)
		items[3] = new Rectangel(4,7);
		items[4] = new square(1);
		
		for(Shape item : items){
			System.out.Println("Perimeter is: +perimeter is: " + item.perimeter());
			
		}
		
		for(Shape item: items){
			//can't acess non-inteface methods using an interface reference, 
			//ex:  let's make this a circle object
			System.out.println(item.sayHello());
			
		}
	}

}
