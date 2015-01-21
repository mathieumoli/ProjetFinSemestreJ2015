package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Tobacco extends PayingObject{
	/**
	 * Constructor for create Tabacco
	 */
	public Tobacco(){
		super("tobacco",2);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the tabacoo
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		student.decrementEnergy(20);
		
	}

}
