package zuul.object;

import zuul.Display;
import zuul.person.Student;
/**
 * 
 * @author Oussam Hlal
 *
 */

public class Coffee extends PayingObject {
	/**
	 * Constructor for create a Cofee
	 */
	public Coffee(){
		super("coffee",1);
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
		//TODO  supprimer la phrase déja implémenter de le implément/décrémente
		Display.display("energy.part1");
		Display.display(student.getName());
		student.incrementEnergy(30);
		Display.display("energy.part2");
		Display.displayln(Integer.toString((student.getEnergy())));
		Display.displayln("lunchroom.coffee2");
	}
	
}