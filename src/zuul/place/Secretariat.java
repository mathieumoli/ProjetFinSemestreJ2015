package zuul.place;

import java.awt.DisplayMode;
import java.util.Random;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Lisa Joanno
 * 
 * The Secretarial Office
 *
 */
public class Secretariat extends Room {
    private boolean lights;
    
    /**
     * Constructor to create a secretarial office
     * @param description
     */
	public Secretariat(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}
	
	/**
	 * This function determines what the student do when he enter in the secretarial office
	 * 
	 * @param student the student who enters in the secretarial office
	 * @return true
	 */
	@Override
	public boolean enter(Student student) {
		Display.displayln("secretariat.aimable");
		this.getExitString();
		return true;
	}

	/**
	 * 	
	 * This function determines if the student can enter in the secretarial office
	 * 
	 * @param student the student who want to enter in the secretarial office
	 * @return true
	 *
	 */
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

}
