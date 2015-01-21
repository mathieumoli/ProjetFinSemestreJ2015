package zuul.object;

import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Pc extends ZuulObject {
	/**
	 * Constructor for create a Pc
	 */
	public Pc() {
		super("pc");
		
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the pc
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		System.out.println("ça faisait longtemps que je me suis pas connecté\n"+
				"...\n"+
				"Facebook.com \n"+
				"Connexion échouée...");
		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}

}
