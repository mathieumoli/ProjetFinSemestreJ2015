package zuul.place;

import zuul.Game;
import zuul.commands.Command;
import zuul.person.Person;
import zuul.person.Student;

/**
 * @author Lucas Martinez and Molinengo Mathieu
 * @version 2014.11.30
 * 
 *          Class to create a LunchRoom
 */
public class Lunchroom extends Room {

	boolean playBabyFoot;

	/***
	 * 
	 * Constructor to create a Lunchroom
	 * @param description the description of the lunchroom
	 * 
	 ***/
	public Lunchroom(String description) {
		super(description);
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
	public void takeCoffee(Student gamer) {
		System.out.println(Game.res.getString("lunchroom.coffee1"));
		gamer.incrementEnergy(20);
		System.out.println(Game.res.getString("lunchroom.coffee2"));

	}

	/**
	 * This function determines if the student can enter the lunchroom or not
	 * @param student the student who wants enter
	 * @return true
	 */
	@Override
	public boolean canEnter(Person student) {
		return true;
	}

	/**
	 * This function determines what the student can do when he enters the room.
	 * Here, there is a probability that the student plays babyfoot
	 * @param student the student who enters in the lunchroom
	 * @return true
	 */
	@Override
	public boolean enter(Person student) {
		
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
			this.takeCoffee(gamer);
		} else {
			System.out.println(Game.res.getString("game.take"));
		}
		System.out.println(this.getExitString());
	}
}
