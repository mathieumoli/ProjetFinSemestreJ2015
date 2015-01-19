package zuul.room;

import java.util.ArrayList;

import zuul.Game;
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
		poo2Book = new ArrayList<LectureItem>();

		LectureItem poo2BookPage1 = new LectureItem("OOP", 1, "oop.lecture1");
		LectureItem poo2BookPage2 = new LectureItem("OOP", 2, "oop.lecture2");
		LectureItem poo2BookPage3 = new LectureItem("OOP", 3, "oop.lecture3");
		poo2Book.add(poo2BookPage1);
		poo2Book.add(poo2BookPage2);
		poo2Book.add(poo2BookPage3);

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
			System.out.println(Game.res.getString("library.description") + "\n"
					+ getExitString());

			return true;
		}
		System.out.println(Game.res.getString("library.closed"));
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

	/***
	 * 
	 * Method to set the poo2Book in the Student to can use it later
	 * 
	 * @param student
	 *            the student who wants take the book
	 */
	public void takeBook(Student student) {
		student.setOOPbook(poo2Book);
		System.out.println(Game.res.getString("library.takebook") + "\n"
				+ getExitString());
	}

	/***
	 * 
	 * Method to read the poo2Book without take it
	 * 
	 * @param goodStudent
	 *            the Student who wants learn all the OOP lectures
	 * 
	 */
	public void learnPOO(Student goodStudent) {
		int sizeBook = poo2Book.size();
		for (int i = 0; i < sizeBook; i++) {
			if (!goodStudent.alreadyListenedLecture(poo2Book.get(i))) {
				goodStudent.addItem(poo2Book.get(i));
				System.out.println(Game.res.getString(poo2Book.get(i)
						.getBundleKey()) + "\n");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		goodStudent.decrementEnergy(35);
		System.out.println(getExitString());

	}
}
