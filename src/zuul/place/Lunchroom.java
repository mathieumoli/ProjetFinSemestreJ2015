package zuul.place;

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
	 * The student takes a coffee which allows him to gain 20 points of energy
	 * @param gamer the student who takes a coffee and who increments his energy
	 */
	public void buyCoffee(Student gamer) {
		System.out.println(Game.res.getString("lunchroom.coffee1"));
		gamer.getWallet().decreaseMoney(1); //Coffee cost 1 euro
		//gamer.incrementEnergy(20); quand on le boit
		//TODO rajouter l'objet dans le sac
		System.out.println(Game.res.getString("lunchroom.coffee2"));

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
			System.out.println(Game.res.getString("lunchroom.babyFoot"));
			student.playBabyFoot();
			System.out.println(getExitString());
		} else {
			System.out.println(getLongDescription());
		}

		return true;

	}
	
	/**
	 * Try to take the book in the library, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 * @param gamer
	 * 			  The Student who want to take something
	 */
	@Override
	public void wantTake(Command command,Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(Game.res.getString("game.take"));
			return;
		} else if (command.getSecondWord().equals("coffee")) {
			this.buyCoffee(gamer);
		} else {
			System.out.println(Game.res.getString("game.take"));
		}
		System.out.println(this.getExitString());
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
