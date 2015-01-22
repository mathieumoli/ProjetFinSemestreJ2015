package zuul.object;

import zuul.Display;
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
		super("twix",1);
	}
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who eat the twix
	 * 
	 ***/
	@Override
	public void useObject(Student student) {
		Display.display("energy.part1");
		Display.display(student.getName());
		student.incrementEnergy(30);
		Display.display("energy.part2");
		Display.displayln(Integer.toString((student.getEnergy())));
		Display.displayln("twix.action");
	}

}
