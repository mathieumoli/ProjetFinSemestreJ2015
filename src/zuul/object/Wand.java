package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Wand extends ZuulObject {
	/**
	 * Constructor for create a Wand
	 */
	public Wand() {
		super("wand");
		
	}
	
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who uses the wand
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		Display.displayln("wand.action") ;
	}

}
