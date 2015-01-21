package zuul.object;

import zuul.Game;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Cofee extends PayingObject {
	/**
	 * Constructor for create a Cofee
	 */
	public Cofee(){
		super("cofee",1);
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
		
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}
	
}