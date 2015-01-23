package zuul.person;

import java.util.Map;
import java.util.Map.Entry;

import zuul.object.PayingObject;

public class Seller extends Person {

	Map<String, PayingObject> stock;
	
	public Seller(String name, Map<String, PayingObject> stock) {
		super(name);
		this.stock = stock;
	}
	
	public void  displayStock(){
		if(stock.size() != 0){
			//TODO interna
			System.out.println("Voici tout ce que je peux te vendre l'ami : ");
			for(Entry<String, PayingObject> entry : stock.entrySet()){
				System.out.println("- " + entry.getValue().getName());
			}
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
			if(s.getWallet().decreaseMoney(this.stock.get(object).getPrice())){
				s.addInBag(this.stock.get(object));
				//TODO interna
				System.out.println("Et voila un " + object + " pour toi, rienviens me voir quand tu veux !");
			} else {
				System.out.println("T'as cru que cétait gratuit !? T'as pas assez d'argent pour acheter ca !");
			}
		} else {
			//TODO interna
			System.out.println("Désolé je n'ai pas ca en stock ...");
		}
	}

}
