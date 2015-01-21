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
		super(1);
	}
	
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(30);
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}

}
