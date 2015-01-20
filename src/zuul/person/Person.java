package zuul.person;

import zuul.person.objet.Wallet;
import zuul.place.Room;

/**
 * @author Cédric Lallemand
 * @version 2015.01.20
 * 
 *          Class to create a Person
 */
public class Person {

	private String name;
	private Room currentRoom;
	private Wallet wallet;
	
	/***
	 * 
	 * Constructor to create a Person
	 * 
	 * @param name - the name of created person     
	 * 
	 ***/
	public Person(String name, Wallet wallet){
		this.name = name;
	}

	/***
	 * 
	 * Method to get the name of the person
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the wallet of the person
	 */
	public Wallet getWallet(){
		return this.wallet;
	}
	
	/**
	 * 
	 * Method to know if the Person can allow a student to pass the exam
	 * @return true if the  person can allow student to passe the exam
	 * 
	 */
	public boolean canAllowToPassExam(){
		return false;
	}

	/**
	 * Method to know where are the person
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Method to modify where are the person
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	

}