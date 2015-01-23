package zuul;

import zuul.commands.*;
import zuul.course.*;
import zuul.object.*;
import zuul.person.MysteriousPerson;
import zuul.person.Person;
import zuul.person.Stromboni;
import zuul.person.Student;
import zuul.person.object.Wallet;
import zuul.place.*;

import java.util.*;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kölling, David J. Barnes (original version) Martinez Lucas
 *         and Molinengo Mathieu (updated version)
 * @version 2014.11.30
 */

public class Game {
	private Parser parser;
	private Room currentRoom;
	public static ResourceBundle res;
	private Locale locale;
	private Student gamer;
	public static final int NB_COURSES = 3;
	public static final String COURSES[] = { "OOP", "C", "ALGO" };
	public static final String COURSESBUNDLEKEY[] = { "oop.lecture1",
	        "oop.lecture2", "oop.lecture3", "c.lecture1", "c.lecture2",
	        "c.lecture3", "algo.lecture1", "algo.lecture2", "algo.lecture3" };
	public static List<LabItem> labs = new ArrayList<LabItem>();
	public static List<LectureItem> lectures = new ArrayList<LectureItem>();
	public static ArrayList<Person> people = new ArrayList<Person>();
	private HashMap<String,Room> hashmapRoom = new HashMap<String,Room>();
	Scanner scanner = new Scanner(System.in);
	HashMap<String,PayingObject> listPayingObject;
	private School school;
	
	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		parser = new Parser();
		getLanguage();
		res = ResourceBundle.getBundle("zuul.intl.Zuul", locale);
	}

	private void initPayingObject(){
		this.listPayingObject = new HashMap<String, PayingObject>();
		this.listPayingObject.put("alcohol",new Alcohol());
		this.listPayingObject.put("coffee",new Coffee());
		this.listPayingObject.put("lunch",new Lunch());
		this.listPayingObject.put("redbull",new Redbull());
	}
	/**
	 * Ask to the user his prefered language and set it
	 */
	private void getLanguage() {
		System.out
		        .println("Voulez-vous jouer en francais ? Si oui, appuyez sur 1.");
		System.out
		        .println("Or do you prefer playing in English ? If so, press 2.");

		
		String choice = scanner.nextLine();

		if (choice.equals("1")) {
			locale = Locale.getDefault();
		} else if (choice.equals("2")) {
			locale = new Locale("en", "US");
		} else {
			getLanguage();
		}
	}

	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createSchool() {
		school = new School(people,gamer,listPayingObject);
		hashmapRoom = school.getRooms();
		currentRoom = hashmapRoom.get("foyer");
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
		createCourses();
		initPayingObject();
		createSchool();
		createPersons();
		//MaraudeurMap c1= new MaraudeurMap(people,gamer);
		//gamer.addInBag(c1);
		if (!(gamer.getName().equals("Chuck Norris"))) {
			printGamer();
			printPeopleInRoom();
			// Enter the main command loop. Here we repeatedly read commands and
			// execute them until the game is over.

			boolean finished = false;
			while (!finished) {
				Command command = parser.getCommand();
				finished = processCommand(command);
				gamer.setCurrentRoom(currentRoom);
			}
			Display.displayln(res.getString("game.thankyou"));
		} else {
			System.out
			        .println(res.getString("name.CN"));
			Display.displayln(res.getString("game.thankyou"));

		}

	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		Display.displayln("");
		Display.displayln(res.getString("game.welcome"));
		Display.displayln(res.getString("game.boring"));
		Display.displayln(res.getString("game.help"));
        Display.displayln("");
	}

	/**
	 * Create the player based on the given name.
	 * 
	 * Here we create every people in the game, by giving their names and how much
	 * money they have, and  you must set their current room.
	 * You must also set the player's current room.
	 */

	private void createPersons() {
		Display.displayln(res.getString("game.askname"));
		String name = scanner.nextLine();
		gamer = new Student(name);
		
		// creates other players
		Stromboni stromboni;
		Person person1,person2,person3, person4, person5, person6, person7, person8, person9;
		MysteriousPerson  mp1,mp2,mp3;
		stromboni = new Stromboni();
		stromboni.setCurrentRoom(hashmapRoom.get("c5"));
		people.add(stromboni);

		person1 = new Person("Cédric", new Wallet(10));
		person1.setCurrentRoom(hashmapRoom.get("foyer"));
		people.add(person1);

		person2 = new Person("Mathieu", new Wallet(4));
		person2.setCurrentRoom(hashmapRoom.get("foyer"));
		people.add(person2);

		person3 = new Person("Lisa", new Wallet(5));
		person3.setCurrentRoom(hashmapRoom.get("foyer"));
		people.add(person3);
		
		person4 = new Person("Tom", new Wallet(1));
		person4.setCurrentRoom(hashmapRoom.get("c4"));
		people.add(person4);
		
		person5 = new Person("Dorian", new Wallet(6));
		person5.setCurrentRoom(hashmapRoom.get("c6"));
		people.add(person5);
		
		person6 = new Person("Florent", new Wallet(12));
		person6.setCurrentRoom(hashmapRoom.get("c11"));
		people.add(person6);
		
		person7 = new Person("Nicolas", new Wallet(16));
		person7.setCurrentRoom(hashmapRoom.get("library"));
		people.add(person7);
		
		person8 = new Person("Dominque", new Wallet(0));
		person8.setCurrentRoom(hashmapRoom.get("library"));
		people.add(person8);
		
		person9 = new Person("Alison", new Wallet(2));
		person9.setCurrentRoom(hashmapRoom.get("library"));
		people.add(person9);

		mp1 = new MysteriousPerson("Litovsky", new Wallet(8),"mysteriousperson.indice1");
		mp1.setCurrentRoom(hashmapRoom.get("library"));
		people.add(mp1);
		
		mp2 = new MysteriousPerson("Leroux", new Wallet(8),"mysteriousperson.indice2");
		mp2.setCurrentRoom(hashmapRoom.get("lunchroom"));
		people.add(mp2);
		
		mp3 = new MysteriousPerson("Giuleri", new Wallet(8),"mysteriousperson.indice2");
		mp3.setCurrentRoom(hashmapRoom.get("c11"));
		people.add(mp3);
		
		gamer.setCurrentRoom(hashmapRoom.get("foyer"));
	}

	/**
	 * Print a welcoming message to the gamer
	 */

	private void printGamer() {
		String string = new String(res.getString("game.welcomename1")
		        + gamer.getName() + res.getString("game.welcomename2")
		        + gamer.getName() + res.getString("game.welcomename3"));
		Display.displayln(string);
		Display.displayln("");
		Display.displayln(currentRoom.getLongDescription());
	}

	/**
	 * This method creates the labs and lectures (3 each) for 3 subjects
	 */
	private void createCourses() {
		int k;
		for (int i = 0; i < NB_COURSES; ++i) {
			k = i;
			for (int j = 0; j < COURSES.length; ++j) {
				labs.add(new LabItem(COURSES[j], i + 1));
				lectures.add(new LectureItem(COURSES[j], i + 1,
				        COURSESBUNDLEKEY[k]));
				k += 3;
			}
		}
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 *
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			Display.displayError(res.getString("game.idontknow"));
			return false;
		}

		switch (command.getCommandWord()) {
		case "go":
			goRoom(command);
			break;

		case "help":
			currentRoom.printHelp(parser);
			
			break;
		case "quit":
			wantToQuit = quit(command);
			break;
		case "lights":
			currentRoom.wantSwitchLights(command, gamer);
			break;
		case "attend":
			currentRoom.wantAttend(command, gamer);
			break;
		case "turn":
			currentRoom.wantTurn(command, gamer);
			break;
		case "search":
			gamer.searchInRoom();
			break;
		case "start":
			currentRoom.wantStart(command, gamer);
			break;
		case "buy":
			gamer.wantBuy(command);
			break;
		case "use":
			gamer.wantUse(command);
			break;
		case "check":
			currentRoom.checkPrinter(command, gamer);
			break;
		case "say":
		    gamer.wantSayHello(command, people, currentRoom);
		    break;
		case "see":
			gamer.seePlan(command);
			break;
		default:
			break;
		}
		// else command not recognised.
		return wantToQuit;
	}

	
	/**
	 * a method printing every people in the room.
	 */
	private void printPeopleInRoom() {
		
		ArrayList<Person> peopleInRoom = new ArrayList<Person>();
		for (Person person : people) {
			if (person.getCurrentRoom()==currentRoom) {
				peopleInRoom.add(person);
			}
		}
		if (people.size() == 0) {
			Display.displayln("Il n'y a personne dans cette salle."); // TODO interna
			return;
		}
		Display.display("Les personnes présentes dans cette salle sont : ");
		for (Person person : peopleInRoom) {
			Display.display(person.getName()+ "   ");			
		}
		Display.displayln("");
	}
	
	
	/**
	 * Try to in to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Display.displayError(res.getString("game.where"));
			return;
		}
		String direction = command.getSecondWord();
		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null) {
			Display.displayError(res.getString("game.nodoor"));
		} else if (nextRoom.enter(gamer)) {
			currentRoom = nextRoom;
			printPeopleInRoom();
			int i;
			for(i=0;i<people.size();i++){
			    people.get(i).randomMove();
			}
		} else {
			Display.displayln(currentRoom.getLongDescription());
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			Display.displayError(res.getString("game.quitwhat"));
			return false;
		}
		return true; // signal that we want to quit
	}

	/**
	 * @return the parser
	 */
	public Parser getParser() {
		return parser;
	}

	/**
	 * @param parser
	 *            the parser to set
	 */
	public void setParser(Parser parser) {
		this.parser = parser;
	}
}
