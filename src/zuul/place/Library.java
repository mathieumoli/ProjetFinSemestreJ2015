package zuul.place;

import java.util.ArrayList;

import zuul.Display;
import zuul.Game;
import zuul.commands.Command;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Lucas Martinez and Molinengo Mathieu
 * @version 2014.11.30
 * 
 *          Class to create a LabRoom
 */
public class Library extends Room {

	boolean isOpen = false;
	private ArrayList<LectureItem> poo2Book;

	/***
	 * 
	 * Constructor to create a Library
	 * 
	 * @param description
	 *            the description of the library
	 * 
	 ***/
	public Library(String description) {
		super(description);
	}

	/***
	 * 
	 * Constructor to create a Library
	 * 
	 * @param description
	 *            the description of the library
	 * @param secret
	 *            the boolean of the library if it's secret or not
	 * 
	 ***/
	public Library(String description, boolean secret) {
		super(description, secret);
	}

	/***
	 * 
	 * This function determines if the student can enter the library or not
	 * 
	 * @param student
	 *            who wants enter in the labroom
	 * @return true if the student can enter and false if he can't
	 * 
	 */
	public boolean canEnter(Student student) {
		return isOpen();
	}

	/***
	 * 
	 * Method to enter in this library
	 * 
	 * @param student
	 *            the student who wants to go in
	 * @return true if he can go in and false if he can't
	 * 
	 ***/
	public boolean enter(Student student) {
		if (canEnter(student)) {
			Display.displayln(Game.res.getString("library.description") + "\n"
			        + getExitString());

			return true;
		}
		Display.displayln(Game.res.getString("library.closed"));
		return false;
	}

	/***
	 * Method to randomize the opening of the library
	 * 
	 * @return true if the library is open or not if it isn't
	 */
	public boolean isOpen() {
		int random = (int) (Math.random() * 10);

		isOpen = random > 7;
		return isOpen;
	}
}
