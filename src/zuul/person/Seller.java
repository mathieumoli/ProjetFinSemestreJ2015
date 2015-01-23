package zuul.person;

import java.util.Map;
import java.util.Map.Entry;

import zuul.Display;
import zuul.Game;
import zuul.object.PayingObject;

public class Seller extends Person {

	Map<String, PayingObject> stock;
	
	public Seller(String name, Map<String, PayingObject> stock) {
		super(name);
		this.stock = stock;
	}
	
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
