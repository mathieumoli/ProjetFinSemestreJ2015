package zuul.object;

import zuul.Game;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */
public class Broom extends ZuulObject {
	/**
	 * Constructor for create a Broom
	 */
	public Broom() {
		super("broom");
		
	}

	int i = 0;
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the broom
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		 
			System.out.println(Game.res.getString("broom.action"));
		
		

	}

}
