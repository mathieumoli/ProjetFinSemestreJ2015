package zuul;

import zuul.commands.*;
import zuul.course.*;
import zuul.person.Person;
import zuul.person.Stromboni;
import zuul.person.Student;
import zuul.person.objet.StudentWallet;
import zuul.person.objet.Wallet;
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

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		parser = new Parser();
		getLanguage();
		res = ResourceBundle.getBundle("zuul.intl.Zuul", locale);
	}

	/**
	 * Ask to the user his prefered language and set it
	 */
	private void getLanguage() {
		System.out
		        .println("Voulez-vous jouer en francais ? Si oui, appuyez sur 1.");
		System.out
		        .println("Or do you prefer playing in English ? If so, press 2.");

		Scanner scanner = new Scanner(System.in);
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
	private void createRooms() {
		Room ali = new AliOffice("le bureau d'Ali"); // TODO
													 // internationnalisation
		Room exam = new ExamRoom(res.getString("examroom.description"));
		Room foyer = new Foyer("le foyer"); // TODO internationnalisation
		Room lab1 = new LabRoom(res.getString("labroom.description1"), 1);
		Room lab2 = new LabRoom(res.getString("labroom.description1"), 2);
		Room lab3 = new LabRoom(res.getString("labroom.description1"), 3);
		Room lecture1 = new LectureRoom(
		        res.getString("lectureroom.description1"), 1);
		Room lecture2 = new LectureRoom(
		        res.getString("lectureroom.description1"), 2);
		Room lecture3 = new LectureRoom(
		        res.getString("lectureroom.description1"), 3);
		Room library = new Library(res.getString("library.description"));
		Room lunchRoom = new Lunchroom(res.getString("lunchroom.description"));
		// enlev� la print room
		Room secretariat = new Secretariat("au secretariat"); // TODO
															  // internationnalisation
		Room c1 = new Corridor(res.getString("corridor1.description"));
		Room c2 = new Corridor(res.getString("corridor2.description"));
		Room c3 = new Corridor(res.getString("corridor3.description"));
		Room c4 = new Corridor(res.getString("corridor4.description"));
		Room c5 = new Corridor("corridor5.description");
		Room c6 = new Corridor("corridor6.description");
		Room c7 = new Corridor("corridor7.description");
		Room c8 = new Corridor("corridor8.description");
		Room c9 = new Corridor("corridor9.description");
		Room c10 = new Corridor("corridor10.description");
		Room c11 = new Corridor("corridor11.description");
		Room c12 = new Corridor("corridor12.description");
		// Room u1 = new UselessRoom();
		// Room u2 = new UselessRoom();
		c1.setExit("north", c2);
		c1.setExit("south", foyer);
		c1.setExit("east", lecture1);
		c1.setExit("west", secretariat);
		c2.setExit("north", c3);
		c2.setExit("south", c1);
		c2.setExit("east", lecture2);
		// c2.setExit("west", u1);
		c3.setExit("north", c6);
		c3.setExit("south", c2);
		c3.setExit("east", lecture3);
		c3.setExit("west", c4);
		c4.setExit("east", c3);
		c4.setExit("west", c5);
		c5.setExit("south", exam);
		c5.setExit("east", c4);
		c6.setExit("north", c7);
		c6.setExit("south", c3);
		c6.setExit("east", lab1);
		c7.setExit("north", c8);
		c7.setExit("south", c6);
		c7.setExit("east", lab2);
		c8.setExit("north", c9);
		c8.setExit("south", c7);
		c8.setExit("east", lab3);
		c9.setExit("north", c10);
		c9.setExit("south", c8);
		c9.setExit("east", c11);
		c9.setExit("west", lunchRoom);
		c10.setExit("north", library);
		c10.setExit("south", c9);
		c11.setExit("east", c12);
		c11.setExit("west", c9);
		c12.setExit("north", ali);
		// c12.setExit("south", print);
		// c12.setExit("east", u2);
		c12.setExit("west", c11);
		lecture1.setExit("west", c1);
		lecture2.setExit("west", c2);
		lecture3.setExit("west", c3);
		lab1.setExit("west", c6);
		lab2.setExit("west", c7);
		lab3.setExit("west", c8);
		secretariat.setExit("east", c1);
		exam.setExit("north", c5);
		// u1.setExit("east", c2);
		// u2.setExit("west", c12);
		lunchRoom.setExit("east", c9);
		library.setExit("south", c10);
		// print.setExit("north", c12);
		foyer.setExit("north", c1);
		ali.setExit("south", c12);
		currentRoom = foyer;

		createGamer();
		
		/**
		 * // create the rooms Lunchroom lunchroom = new Lunchroom(
		 * res.getString("lunchroom.description")); LectureRoom lectureroom1 =
		 * new LectureRoom( res.getString("lectureroom.description1"), 1);
		 * LectureRoom lectureroom2 = new LectureRoom(
		 * res.getString("lectureroom.description1"), 2); LectureRoom
		 * lectureroom3 = new LectureRoom(
		 * res.getString("lectureroom.description1"), 3); LabRoom labroom1 = new
		 * LabRoom(res.getString("labroom.description1"), 1); LabRoom labroom2 =
		 * new LabRoom(res.getString("labroom.description1"), 2); LabRoom
		 * labroom3 = new LabRoom(res.getString("labroom.description1"), 3);
		 * Corridor corridor1 = new Corridor(
		 * res.getString("corridor1.description")); Corridor corridor2 = new
		 * Corridor( res.getString("corridor2.description")); Corridor corridor3
		 * = new Corridor( res.getString("corridor3.description")); Corridor
		 * corridor4 = new Corridor( res.getString("corridor4.description"));
		 * Library library = new Library(res.getString("library.description"));
		 * ExamRoom examroom = new
		 * ExamRoom(res.getString("examroom.description"));
		 * 
		 * // initialise room exits
		 * 
		 * corridor1.setExit("west", labroom1); corridor1.setExit("east",
		 * lunchroom); corridor1.setExit("north", corridor2);
		 * 
		 * corridor2.setExit("south", corridor1); corridor2.setExit("west",
		 * lectureroom2); corridor2.setExit("east", lectureroom1);
		 * corridor2.setExit("north", corridor3);
		 * 
		 * corridor3.setExit("south", corridor2); corridor3.setExit("west",
		 * labroom2); corridor3.setExit("east", labroom3);
		 * corridor3.setExit("north", corridor4);
		 * 
		 * corridor4.setExit("south", corridor3); corridor4.setExit("west",
		 * library); corridor4.setExit("east", lectureroom3);
		 * corridor4.setExit("north", examroom);
		 * 
		 * labroom1.setExit("east", corridor1); labroom2.setExit("east",
		 * corridor3); labroom3.setExit("west", corridor3);
		 * 
		 * lunchroom.setExit("west", corridor1);
		 * 
		 * library.setExit("east", corridor4);
		 * 
		 * lectureroom1.setExit("west", corridor2); lectureroom2.setExit("east",
		 * corridor2); lectureroom3.setExit("west", corridor4);
		 * 
		 * examroom.setExit("south", corridor4);
		 * 
		 * currentRoom = corridor1; // start game in the first corridor
		 */
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
		createCourses();
		createRooms();
		//createGamer();
		if (!(gamer.getName().equals("Chuck Norris"))) {
			printGamer();

			// Enter the main command loop. Here we repeatedly read commands and
			// execute them until the game is over.

			boolean finished = false;
			while (!finished) {
				Command command = parser.getCommand();
				finished = processCommand(command);
			}
			System.out.println(res.getString("game.thankyou"));
		} else {

			// TODO internationalisation
			System.out
			        .println("You are Chuck Norris, you never lose so congratulation you win !!!");
			System.out.println(res.getString("game.thankyou"));

		}

	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println(res.getString("game.welcome"));
		System.out.println(res.getString("game.boring"));
		System.out.println(res.getString("game.help"));
		System.out.println();
	}

	/**
	 * Create the player based on the given name
	 */

	private void createGamer() {
		System.out.println(res.getString("game.askname"));
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		gamer = new Student(name);
		// creates other players
		Stromboni stromboni = new Stromboni();
		Person person1 = new Person("Cédric", new Wallet(10));
		Person person2 = new Person("Mathieu", new Wallet(4));
		Person person3 = new Person("Lisa", new Wallet(5));
		person1.setCurrentRoom(currentRoom);
		person2.setCurrentRoom(currentRoom);
		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(stromboni);

	}

	/**
	 * Print a welcoming message to the gamer
	 */

	private void printGamer() {
		String string = new String(res.getString("game.welcomename1")
		        + gamer.getName() + res.getString("game.welcomename2")
		        + gamer.getName() + res.getString("game.welcomename3"));
		System.out.println(string);
		System.out.println();
		System.out.println(currentRoom.getLongDescription());
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
			System.out.println(res.getString("game.idontknow"));
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
		case "take":
			currentRoom.wantTake(command, gamer);
			break;
		case "lights":
			currentRoom.wantSwitchLights(command, gamer);
			break;
		case "attend":
			currentRoom.wantAttend(command, gamer);
			break;
		case "read":
			currentRoom.wantRead(command, gamer);
			break;
		case "turn":
			currentRoom.wantTurn(command, gamer);
			break;
		case "search":
			currentRoom.wantSearch(command, gamer);
			break;
		case "start":
			currentRoom.wantStart(command, gamer);
			break;
		case "use":
			gamer.wantUse(command.getSecondWord());
			break;
		case "say":
		    gamer.wantSayHello(command, people, currentRoom);
		    break;
		default:
			break;
		}
		// else command not recognised.
		return wantToQuit;
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
			System.out.println(res.getString("game.where"));
			return;
		}
		String direction = command.getSecondWord();
		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null) {
			System.out.println(res.getString("game.nodoor"));
		} else if (nextRoom.enter(gamer)) {
			currentRoom = nextRoom;
		} else {
			System.out.println(currentRoom.getLongDescription());
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
			System.out.println(res.getString("game.quitwhat"));
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
