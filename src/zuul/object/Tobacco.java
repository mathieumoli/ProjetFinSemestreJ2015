package zuul.object;

import zuul.Display;
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
		Display.display("energy.part1");
		Display.display(student.getName());
		student.decrementEnergy(20);
		Display.display("energy.part2");
		Display.displayln(Integer.toString((student.getEnergy())));
		Display.displayln("tobacco.action");
	}

}
