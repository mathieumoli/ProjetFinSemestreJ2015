package zuul.object;

import zuul.Game;
import zuul.person.Student;
import zuul.place.ExamRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Martinez
 * @version 2014.11.30
 * 
 *          Class to create an OOP Cheatsheet
 */
public class Cheatsheet extends ZuulObject {
	private List<String> answers = new ArrayList<String>();

	/***
	 * 
	 * Default constructor to create a Cheatsheet
	 * 
	 ***/
	public Cheatsheet() {
		super("cheatsheet");
		addStuff();
	}

	/***
	 * 
	 * Add stuff in the answer ArrayList of a cheatsheet
	 * 
	 ***/
	public void addStuff() {
		for (int i = 1; i <= ExamRoom.NB_QUESTIONS; ++i) {
			answers.add(Game.res.getString("OOP.exam.answer" + i));
		}
	}

	/***
	 * 
	 * Method to use the cheatsheet
	 * 
	 * @param student
	 *            the student who use the cheatsheet
	 * 
	 ***/
	public void useObject(Student student) {
		System.out.println(answers);
		student.decrementEnergy(20);
	}
}
