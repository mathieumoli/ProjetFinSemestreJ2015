package zuul.object;

import zuul.Display;
import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create an Tablet
 */
public class Tablet extends ZuulObject {
	private LectureItem coursInThisTablet;

	/***
	 * 
	 * Default constructor to create a Tablet
	 * 
	 ***/
	public Tablet() {
		super("tablet");
		addStuff();

	}

	/***
	 * 
	 * Add stuff in the answer ArrayList of a tablet
	 * 
	 ***/
	public void addStuff() {
		int nbCours = Game.getLectures().size() - 1;
		int alea = (int) (Math.random() * nbCours);
		coursInThisTablet = Game.getLectures().get(alea);
	}

	/***
	 * 
	 * Method to use the tablet
	 * 
	 * @param student
	 *            the student who use the tablet
	 * 
	 ***/
	@Override
	public void useObject(Student student){
		Display.displayln(Game.res.getString("tablet.on"));
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
		Display.displayln(Game.res.getString("tablet.appli"));
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
		Display.displayln(Game.res.getString("tablet.zuul"));
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
		Display.displayln(Game.res.getString("tablet.lecture"));
		Display.displayln(Game.res.getString(coursInThisTablet.getBundleKey().toString()));
		student.decrementEnergy(10);
		student.addItem(coursInThisTablet);

	}
}
