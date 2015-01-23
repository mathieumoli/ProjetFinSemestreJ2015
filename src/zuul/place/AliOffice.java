package zuul.place;

import java.util.Random;

import zuul.Display;
import zuul.person.Student;

public class AliOffice extends Room {
	protected boolean lights;	
	
	/**
	 * Constructor to create an Ali's office
	 * @param description the string which defines the Ali's office
	 */
	public AliOffice(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}

	/**
	 * This function determines what the student do when he enter in the Ali's office
	 * 
	 * @param student the student who enters in the foyer
	 * @return true
	 */
	@Override
	public boolean enter(Student student) {
		Display.displayln("aliOffice.bordel");
		return true;
	}

	/**
	 * This function determines if the student can enter the Ali's office or not
	 * @param student the student who wants enter
	 * @return true
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

}
