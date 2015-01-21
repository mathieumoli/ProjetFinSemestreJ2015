package zuul.foundobject;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create an Tablet
 */
public class Tablet extends FoundObject {
	private LectureItem coursInThisTablet;

	/***
	 * 
	 * Default constructor to create a Tablet
	 * 
	 ***/
	public Tablet() {
		addStuff();

	}

	/***
	 * 
	 * Add stuff in the answer ArrayList of a tablet
	 * 
	 ***/
	public void addStuff() {
		int nbCours = Game.lectures.size() - 1;
		int alea = (int) (Math.random() * nbCours);
		coursInThisTablet = Game.lectures.get(alea);
	}

	/***
	 * 
	 * Method to use the tablet
	 * 
	 * @param student
	 *            the student who use the tablet
	 * 
	 ***/
	public void useObject(Student student){
		System.out.println(Game.res.getString("tablet.on"));
		int chance = (int) (Math.random() * 10);
		if(chance > 7)
			playZuul(student);
		else if(chance <= 7 && chance > 3)
			learnLecture(student);
		else
			playAppli(student);
		
	}

	/***
	 * 
	 * Method to use an application
	 * 
	 * @param student
	 *            the student who use the tablet 
	 * 
	 ***/
	private void playAppli(Student student) {
		System.out.println(Game.res.getString("tablet.appli"));
		student.decrementEnergy(30);
		student.removeItem();		
	}

	/***
	 * 
	 * Method to play to Zuul
	 * 
	 * @param student
	 *            the student who use the tablet 
	 * 
	 ***/
	public void playZuul(Student student) {
		System.out.println(Game.res.getString("tablet.zuul"));
		student.decrementEnergy(15);
	}
	
	/***
	 * 
	 * Method to learn the lectures which are in the tablet
	 * 
	 * @param student
	 *            the student who use the tablet 
	 * 
	 ***/
	public void learnLecture(Student student) {
		addStuff();
		System.out.println(Game.res.getString("tablet.lecture"));
		System.out.println(Game.res.getString(coursInThisTablet.getBundleKey().toString()));
		student.decrementEnergy(10);
		student.addItem(coursInThisTablet);

	}
}
