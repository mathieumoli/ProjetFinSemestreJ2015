package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Phone extends ZuulObject {
	/**
	 * Constructor for create a Phone
	 */
	public Phone() {
		super("phone");
		
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the phone
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		Display.displayln("phone.action");			
	}

}
