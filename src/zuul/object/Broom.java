package zuul.object;

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
		 
			System.out.println("I believe I can fly \n"
					+ "I believe I can touch the sky \n"
					+ "I think about it every night and day \n"
					+ "Spread my wings and fly away \n "
					+ "I believe I can soar \n "
					+ "I see me running through that open door \n "
					+ "I believe I can fly \n " + "I believe I can fly ");
		
		

	}

}
