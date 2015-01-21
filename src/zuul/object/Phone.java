package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Phone extends ZuulObject {
	/**
	 * Constructor for create a Phone
	 */
	public Phone() {
		super("phone");
		
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the phone
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		System.out.println("biip biip ... \n"+
	"Veuillez laisser votre message apres le bip ");		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}

}
