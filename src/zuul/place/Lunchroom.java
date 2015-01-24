package zuul.place;

import zuul.Display;
import zuul.Game;
import zuul.commands.Command;
import zuul.person.Seller;
import zuul.person.Student;

/**
 * @author Lucas Martinez and Molinengo Mathieu
 * @version 2014.11.30
 * 
 *          Class to create a LunchRoom
 */
public class Lunchroom extends Room {

	boolean playBabyFoot;
	Seller seller;

	/***
	 * 
	 * Constructor to create a Lunchroom
	 * @param description the description of the lunchroom
	 * 
	 ***/
	public Lunchroom(String description, Seller seller) {
		super(description);
		this.seller = seller;
		
	}
	
	/***
	 * 
	 * Constructor to create a Lunchroom
	 * @param description the description of the lunchroom
	 * @param secret the boolean to define if the lunchroom is secret or not
	 * 
	 ***/
	public Lunchroom(String description,boolean secret) {
		super(description,secret);
	}

	/**
	 * This function determines if the student can enter the lunchroom or not
	 * @param student the student who wants enter
	 * @return true
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * This function determines what the student can do when he enters the room.
	 * Here, there is a probability that the student plays babyfoot
	 * @param student the student who enters in the lunchroom
	 * @return true
	 */
	@Override
	public boolean enter(Student student) {
		
		int random = (int) (Math.random() * 10);
		playBabyFoot = random > 7;
		
		if (playBabyFoot) {
			Display.displayln(Game.res.getString("lunchroom.babyFoot"));
			student.playBabyFoot();
			Display.displayln(getExitString());
		} else {
			Display.displayln(getLongDescription());
		}

		return true;

	}
	
	/**
	 * 
	 * Call to know if it's possible to buy something
	 * 
	 * @return true if a player can buy something
	 */
	@Override
	public boolean canBuy(){
		return true;
	}
	
	/**
	 * Display the list of object which can be buy.
	 */
	@Override
	public void diplayAvalaiblePayingObject(){
		this.seller.displayStock();
	}
	
	/**
	 * 
	 * Call by the student to buy a object
	 * 
	 * @param object - name of the object to buy
	 */
	@Override
	public void buy(String object, Student s){
		this.seller.sell(object, s);
	}
}
