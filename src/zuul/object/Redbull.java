package zuul.object;

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
		//TODO internationalisation
		System.out.println("le redbull c'est trop bon") ;
		student.incrementEnergy(40);
		
	}
	
}
