package zuul.person;

import java.util.HashMap;

import zuul.object.PayingObject;

public class Seller extends Person {

	HashMap<String, PayingObject> stock;
	
	public Seller(String name, HashMap<String, PayingObject> stock) {
		super(name);
		this.stock = stock;
	}
	
	public void  displayStock(){
		if(stock.size() != 0){
			//TODO interna
			System.out.println("Voici tout ce que je peux te vendre l'ami : " + stock.toString());
		} else {
			//TODO internationalisation
			System.out.println("Malheureusement je ne peux rien te vendre.\n"
					+ "J'ai été dévalisé plus un seul article en stock ...");
		}
	}
	
	/**
	 * Call when the player s want buy the object "object"
	 * @param object - object to buy
	 * @param s - player which want buy 
	 */
	public void sell(String object, Student s){
		//TODO 
		if(this.stock.containsKey(object)){
			s.addInBag(this.stock.get(object));
			//TODO interna
			System.out.println("Et voila un " + object + " pour toi, rienviens me voir quand tu veux !");
		} else {
			//TODO interna
			System.out.println("Désolé je n'ai pas ca en stock ...");
		}
	}

}
