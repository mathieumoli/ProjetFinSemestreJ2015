package zuul.person;

import java.util.ArrayList;

import zuul.Display;
import zuul.commands.Command;
import zuul.course.LabItem;
import zuul.person.object.Wallet;

/**
 * @author Cédric Lallemand
 * @version 2015.01.20
 * 
 *          Class to create a Stromboni
 */
public class Stromboni extends Person {

	final static String nameStromboni = "Stromboni";

	/***
	 * 
	 * Constructor to create a Stromboni
	 * 
	 ***/
	public Stromboni() {
		super(nameStromboni, new Wallet(30));
	}

	/**
	 * 
	 * Method to know if the Person can allow a student to pass the exam
	 * 
	 * @return true if the person can allow student to passe the exam
	 * 
	 */
	@Override
	public boolean canAllowToPassExam() {
		return true;
	}

	public void allowStudentToPassExam(Wallet wallet, ArrayList<LabItem> labs) {
		if (labs.size() == 9) {
			wallet.canNowPassExam();
			Display.display(this.getName());
			Display.displayln("stromboni.allow");
		} else
			Display.display(this.getName());
		Display.displayln("stromboni.canNotAllow");
	}

	/**
	 * to do move 
	 */
	@Override
	public void randomMove() {

	}
	
	/**
	 * to get the name of Stromboni
	 * @return the name of Stromboni
	 */
	public String getStromboniName() {
		return nameStromboni;
	}

	/**
	 * 
	 * Method to display a answer to the hello of the user
	 * 
	 * @param command
	 *            the command writted by the user
	 */
	public void answerBack(Command command, Wallet wallet,
	        ArrayList<LabItem> labs) {
		if (command.getSecondWord().equals("hello")) {
			Display.display(this.getName());
			Display.displayln("person.hello");
			this.allowStudentToPassExam(wallet, labs);
		} else {
			Display.display(this.getName());
			Display.displayln("person.notUnderstood");
		}
	}
}