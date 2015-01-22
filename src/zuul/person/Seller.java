package zuul.person;

import java.util.ArrayList;
import zuul.object.PayingObject;

public class Seller extends Person {

	ArrayList<PayingObject> stock;
	
	public Seller(String name, ArrayList<PayingObject> stock) {
		super(name);
		this.stock = stock;
	}
	
	public void  displayStock(){
		if(stock.size() != 0){
			System.out.println("Voici tout ce que je peux te vendre l'ami : " + stock.toString());
		} else {
			System.out.println("Malheureusement je ne peux rien te vendre.\n"
					+ "J'ai été dévalisé plus un seul article en stock ...");
		}
	}

}
