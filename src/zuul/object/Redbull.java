package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Redbull extends PayingObject {
	/**
	 * Constructor for create a Redbull
	 */
	public Redbull(){
		super("redbull",2);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who drink the redbull 
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(40);
		Display.displayln("redbull.action");
	}
	
}
