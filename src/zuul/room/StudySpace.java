package zuul.room;

import java.util.ResourceBundle;

import zuul.course.Item;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo and Martinez Lucas
 * @version 2014.11.30
 * 
 *          The StudySpace class is the abstract base class for Labroom and
 *          LectureRoom object
 * 
 */
public abstract class StudySpace extends Room {
	protected Item coursInThisRoom;
	protected int nbRoom;
	protected boolean isAttend;

	/***
	 * 
	 * Constructor to create a StudySpace
	 * 
	 * @param description
	 *            the description of the StudySpace
	 * @param nbRoom
	 *             the integer which defines the courses in this studyspace
	 * 
	 ***/
	public StudySpace(String description, int nbRoom) {
		super(description);
		coursInThisRoom = new Item();
		this.nbRoom = nbRoom;
	}

	/***
	 * 
	 * Constructor to create a StudySpace
	 * 
	 * @param description
	 *            the description of the StudySpace
	 * @param itemInThisRoom
	 *             the studied item in this studyspace
	 * 
	 ***/
	public StudySpace(String description, Item itemInThisRoom) {
		super(description);
		coursInThisRoom = itemInThisRoom;
	}

	public abstract void randomizeCourses();

	/**
	 * 
	 * Method to get the coursInThisRoom
	 * 
	 * @return the coursInThisRoom
	 */
	public Item getCoursInThisRoom() {
		return coursInThisRoom;
	}

	/**
	 * @param coursInThisRoom
	 *            the coursInThisRoom to set
	 */
	public void setCoursInThisRoom(Item coursInThisRoom) {
		this.coursInThisRoom = coursInThisRoom;
	}

	/**
	 * This function determines if the student must enter in the studyspace (if
	 * the studyspace contains an OOP item)
	 * 
	 * @param student
	 *            the Student who wants enter in this StudySpace
	 * @return true if the student must enter and false if he mustn't
	 */
	public boolean mustEnter(Student student) {
		if (coursInThisRoom.getModule().equals("OOP")) {
			return true;
		}
		return false;
	}

}
