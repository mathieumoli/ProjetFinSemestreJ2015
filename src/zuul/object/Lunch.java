package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Lunch extends PayingObject {
	/**
	 * Constructor for create a Lunch
	 */
	public Lunch(){
		super("lunch",4);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who eat the lunch
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(70);
		
	}	

}
