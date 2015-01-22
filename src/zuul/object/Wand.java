package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Wand extends ZuulObject {
	/**
	 * Constructor for create a Wand
	 */
	public Wand() {
		super("wand");
		
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the wand
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		System.out.println("Wingardium Leviosa \n...\nPourquoi il se passe rien... \ntant pis, j ai un exam à réussir ") ;
		
	}

}
