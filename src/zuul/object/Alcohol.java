package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */
public class Alcohol extends PayingObject {
	/**
	 * Constructor for create Alcohol
	 */
	public Alcohol(){
		super("alcohol",3);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who drink alcohol
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.decrementEnergy(40);
		
	}
	
}
