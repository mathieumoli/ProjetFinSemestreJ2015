package zuul.person;

import java.util.ArrayList;
import java.util.Iterator;

import zuul.Display;
import zuul.commands.Command;
import zuul.person.object.Wallet;
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
	 * @param name
	 *            - the name of created person
	 * 
	 ***/
	public Person(String name) {
		this.name = name;
	}

	/***
	 * 
	 * Constructor to create a Person
	 * 
	 * @param name
	 *            - the name of created person
	 * 
	 ***/
	public Person(String name, Wallet wallet) {
		this.name = name;
		this.wallet = wallet;
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
	public Wallet getWallet() {
		return this.wallet;
	}

	/**
	 * 
	 * Method to know if the Person can allow a student to pass the exam
	 * 
	 * @return true if the person can allow student to passe the exam
	 * 
	 */
	public boolean canAllowToPassExam() {
		return false;
	}

	/**
	 * Method to know where are the person
	 * 
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Method to modify where are the person
	 * 
	 * @param currentRoom
	 *            the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * 
	 * The person do a random move to go in a accessible room
	 * 
	 */
	public void randomMove() {
		double rand;
		boolean trouve = false;
		ArrayList<Room> hm = new ArrayList<Room>();
		hm.addAll(this.currentRoom.getExits().values());
		hm.add(this.currentRoom);
		while (!trouve) {

			rand = Math.random();
			rand = Math.round(rand * ((hm.size() - 1)));
			if (!hm.get((int) rand).isSecret()) {
				this.currentRoom = hm.get((int) rand);
				trouve = true;
			}
		}
	}

	/**
	 * 
	 * Method to display a answer to the hello of the user
	 * @param command
	 * 				the command writted by the user
	 */
	public void answerBack(Command command) {
		if (command.getSecondWord() != null
				&& command.getSecondWord().equals("hello")) {
			Display.display(this.getName());
			Display.displayln("person.hello");
		} else {
			Display.display(this.getName());
			Display.displayln("person.notUnderstood");
		}
	}
}