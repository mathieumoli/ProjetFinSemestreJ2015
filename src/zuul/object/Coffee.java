package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Coffee extends PayingObject {
	/**
	 * Constructor for create a Cofee
	 */
	public Coffee(){
		super("coffee",1);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who drink the cofee
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(30);
		Display.displayln("lunchroom.coffee2");
	}
	
}