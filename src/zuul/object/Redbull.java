package zuul.object;

import zuul.Display;
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
		Display.display("student.energy.part1");
		Display.display(student.getName());
		student.incrementEnergy(40);
		Display.display("student.energy.part2");
		Display.displayln(Integer.toString((student.getEnergy())));
		Display.displayln("redbull.action");
		
	}
	
}
