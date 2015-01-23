package zuul.person;

import java.util.Map;
import java.util.Map.Entry;

import zuul.Display;
import zuul.Game;
import zuul.object.PayingObject;
/**
 * 
 * @author Cedric Lallemand
 *
 */
public class Seller extends Person {

	Map<String, PayingObject> stock;
	
	/**
	 * 
	 * Constructor to create a seller
	 * @param name
	 * 				the name of the seller
	 * @param stock
	 * 				the map which contains all paying objects 
	 */
	public Seller(String name, Map<String, PayingObject> stock) {
		super(name);
		this.stock = stock;
	}
	
	/**
	 * To show all paying objects which are contained by the seller
	 */
	public void  displayStock(){
		if(stock.size() != 0){
			Display.displayln("seller.seewhatisell");
			for(Entry<String, PayingObject> entry : stock.entrySet()){
				Display.displayln("- " + entry.getValue().getName());
			}
		} else {
			Display.displayln("seller.nothingmore");
		}
	}
	
	/**
	 * Call when the player s want buy the object "object"
	 * @param object - object to buy
	 * @param s - player which want buy 
	 */
	public void sell(String object, Student s){
		if(this.stock.containsKey(object)){
			if(s.getWallet().decreaseMoney(this.stock.get(object).getPrice())){
				s.addInBag(this.stock.get(object));
				Display.displayln(Game.res.getString("seller.foryou") + object + Game.res.getString("seller.comeback"));
			} else {
				Display.displayln("seller.notfree");
			}
		} else {
			Display.displayln("seller.idonthavethis");
		}
	}

}
