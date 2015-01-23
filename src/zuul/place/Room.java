package zuul.place;

import zuul.Game;
import zuul.commands.Command;
import zuul.commands.Parser;
import zuul.object.ZuulObject;
import zuul.person.Student;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public abstract class Room {
	private String description;
	private boolean secret;
	private ArrayList<ZuulObject> objectInRoom;
	private HashMap<String, Room> exits; // stores exits of this room.

	protected String getDescription() {
		return description;
	}

	/**
	 * Abstract method which will be overriden in each class
	 * 
	 * @param student
	 * @return
	 */
	public abstract boolean enter(Student student);

	/**
	 * Abstract method which will deterimport java.util.*;mine if the student
	 * can enter
	 * 
	 * @param student
	 * @return
	 */
	public abstract boolean canEnter(Student student);

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 * 
	 * @param description
	 *            The room's description.
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<String, Room>();
		this.secret = false;
		this.objectInRoom = new ArrayList<ZuulObject>();
	}

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 * 
	 * @param description
	 *            The room's description.
	 * @boolean secret if the room is a secret room or not
	 */
	public Room(String description, boolean secret) {
		this.description = description;
		exits = new HashMap<String, Room>();
		this.secret = secret;
		this.objectInRoom = new ArrayList<ZuulObject>();
	}

	/**
	 * Define an exit from this room.
	 * 
	 * @param direction
	 *            The direction of the exit.
	 * @param neighbor
	 *            The room to which the exit leads.
	 */
	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	/**
	 * @return The short description of the room (the one that was defined in
	 *         the constructor).
	 */
	public String getShortDescription() {
		return description;
	}

	/**
	 * Return a description of the room in the form: You are in the kitchen.
	 * Exits: north west
	 * 
	 * @return A long description of this room
	 */
	public String getLongDescription() {
		return description + ".\n" + getExitString();
	}

	/**
	 * Return a string describing the room's exits, for example
	 * "Exits: north west".
	 * 
	 * @return Details of the room's exits.
	 */
	public String getExitString() {
		String returnString = Game.res.getString("game.exits");
		Set<String> keys = exits.keySet();
		for (String exit : keys) {
			returnString += " " + exit;
		}
		return returnString;
	}

	/**
	 * Return the room that is reached if we go from this room in direction
	 * "direction". If there is no room in that direction, return null.
	 * 
	 * @param direction
	 *            The exit's direction.
	 * @return The room in the given direction.
	 */
	public Room getExit(String direction) {
		return exits.get(direction);
	}

	/**
	 * Try to start the exam, if it's incomplete, display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	public void wantStart(Command command) {
		// TODO internationalisation
		System.out.println("You can't do this here !");
	}

	/**
	 * To deal with starting command
	 * 
	 * @param command
	 *            the command which must be deal
	 * @param gamer
	 *            the student who want to start something
	 */
	public void wantStart(Command command, Student gamer) {
		// TODO internationalisation
		System.out.println("You can't do this here");
	}

	/**
	 * @return the exits
	 */
	public HashMap<String, Room> getExits() {
		return exits;
	}

	/**
	 * @param exits
	 *            the exits to set
	 */
	public void setExits(HashMap<String, Room> exits) {
		this.exits = exits;
	}

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	public void printHelp(Parser parser) {
		System.out.println(Game.res.getString("game.help2"));
		System.out.println(Game.res.getString("game.help3"));
		System.out.println();
		System.out.println(Game.res.getString("game.help4"));
		parser.showCommands();
	}

	/**
	 * Try to turn the lights on, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 * @param gamer
	 *            The Student who want to switch on or off the lights
	 */
	public void wantSwitchLights(Command command, Student gamer) {
		System.out.println("You can't do this here");

	}

	/**
	 * Try to use the tablet, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 * @param gamer
	 *            The Student who want to use a tablet
	 */
	public void wantTurn(Command command, Student gamer) {
		System.out.println("You can't do this here");

	}

	/**
	 * Try to attend a lab or a lecture, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 * 
	 * @param gamer
	 *            The Student who want to attend to a lecture or a lab
	 */
	public void wantAttend(Command command, Student gamer) {
		System.out.println("You can't do this here");

	}

	public void addAnObjectInRoom(ZuulObject obj) {
		this.objectInRoom.add(obj);
	}

	/**
	 * Try to search near the printer, if it's incomplete display an error
	 * message Then, display the answers available on the cheatsheet
	 * 
	 * @param command
	 *            The command to be processed.
	 * 
	 * @param gamer
	 *            The Student who want to use a tablet
	 */
	public void checkPrinter(Command command, Student gamer) {
		System.out.println("You can't do this here");

	}

	/**
	 * 
	 * Call only when there is one or more object is the room to search a object
	 * in the room
	 * 
	 * @return a object present in the room
	 * @throws EmptyStackException
	 */
	public ZuulObject search() throws EmptyStackException {
		if (this.objectInRoom()) {
			int rand = (int) Math.round(Math.random() * (this.objectInRoom.size() - 1));
			ZuulObject obj = this.objectInRoom.get(rand);
			this.objectInRoom.remove(rand);
			return obj;
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * 
	 * Call to know if the room has object
	 * 
	 * @return true if there is one or more object in the room
	 */
	public boolean objectInRoom() {
		return !this.objectInRoom.isEmpty();
	}

	/**
	 * 
	 * Call to know if the room is secret
	 * 
	 * @return true if the room is secret
	 */
	public boolean isSecret() {
		return this.secret;
	}

	/**
	 * 
	 * Call to know the name of the room
	 * 
	 * @return the name of the room
	 */
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	/**
	 * 
	 * Call to know if it's possible to buy something 
	 * 
	 * @return true if a player can buy something
	 */
	public boolean canBuy(){
		return false;
	}
	
	/**
	 * Display the list of object which can be buy.
	 */
	public void diplayAvalaiblePayingObject(){
		//TODO interna
		System.out.println("Il n'y a pas de vendeur ici.");
	}
	
	/**
	 * 
	 * Call by the student to buy a object
	 * 
	 * @param object - name of the object to buy
	 */
	public void buy(String object, Student s){
		//TODO interna
		System.out.println("Il n'y a pas de vendeur ici.");
	}

}
