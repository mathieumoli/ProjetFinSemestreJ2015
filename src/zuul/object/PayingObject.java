package zuul.object;

import zuul.person.Student;

public class PayingObject extends ZuulObject{
	private int price;
	

	PayingObject(){
		super("") ;
		price=0;
	}
	
	PayingObject(String name ,int theprice){
		super(name);
		price=theprice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void useObject(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}
}
