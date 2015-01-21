package zuul.object;

abstract class PayingObject extends ZuulObject{
	
	private int price;
	
	PayingObject(String name ,int theprice){
		super(name);
		price=theprice;
	}

	public int getPrice() {
		return price;
	}
}
