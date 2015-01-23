package zuul.place;

import java.util.Random;

import zuul.Advertisement;
import zuul.Display;
import zuul.person.Student;

/**
 * A room where you can check the board, typing "check board".
 * 
 * @author Lisa Joanno
 *
 */
public class Foyer extends Room {
	protected boolean lights;
	protected Advertisement advertisement;

	/***
	 * 
	 * Constructor to create a "foyer" 
	 * @param description the description of the lunchroom
	 * 
	 ***/
	public Foyer(String description) {
		super(description);
		advertisement = new Advertisement();
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}
	/**
	 * This function determines what the student do when he enter in the foyer
	 * 
	 * @param student the student who enters in the foyer
	 * @return true
	 */
	@Override
	public boolean enter(Student student) {
		annonce();
		return true;
	}

	/**
	 * 	
	 * This function determines if the student can enter in the foyer
	 * 
	 * @param student the student who want to enter in the foyer
	 * @return true
	 *
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * A class printing an advertisement if the player chooses to check the
	 * board, by typing "check board".
	 */
	private void annonce() {
		Display.display("foyer.lookTab");
		// une chance sur 2 qu'il y ait une annonce
		Random rnd = new Random();
		int intRandom = rnd.nextInt(10);
		if (intRandom > 4) {
			Display.displayln("foyer.noannonce");
		} else {
			advertisement.displayNewAd();
		}
	}

}
