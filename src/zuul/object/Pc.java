package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Pc extends ZuulObject {
	/**
	 * Constructor for create a Pc
	 */
	public Pc() {
		super("pc");
		
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the pc
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		Display.displayln("pc.action");
		
	}

}
