package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */
public class Twix extends PayingObject {
	/**
	 * Constructor for create a Twix
	 */
	public Twix(){
		super("twix",1);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who eat the twix
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(30);
		
	}

}
