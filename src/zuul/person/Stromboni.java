package zuul.person;

import java.util.ArrayList;

import zuul.person.object.Wallet;
import zuul.place.Room;

/**
 * @author Cédric Lallemand
 * @version 2015.01.20
 * 
 *          Class to create a Stromboni
 */
public class Stromboni extends Person{

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
	 * @return true if the  person can allow student to passe the exam
	 * 
	 */
	@Override
	public boolean canAllowToPassExam(){
		return true;
	}
	
	public  void allowStudentToPassExam(){
		//TODO method to allow a student to passe exam
	}
	
	@Override
	public void randomMove(){
	
	}
}