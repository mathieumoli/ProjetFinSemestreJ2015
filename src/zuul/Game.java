package zuul;

// ceci est un commentaire 

import zuul.commands.*;
import zuul.course.*;
import zuul.person.Student;
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
		        .println("Voulez-vous jouer en français ? Si oui, appuyez sur 1.");
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

		// create the rooms
		Lunchroom lunchroom = new Lunchroom(
		        res.getString("lunchroom.description"));
		LectureRoom lectureroom1 = new LectureRoom(
		        res.getString("lectureroom.description1"), 1);
		LectureRoom lectureroom2 = new LectureRoom(
		        res.getString("lectureroom.description1"), 2);
		LectureRoom lectureroom3 = new LectureRoom(
		        res.getString("lectureroom.description1"), 3);
		LabRoom labroom1 = new LabRoom(res.getString("labroom.description1"), 1);
		LabRoom labroom2 = new LabRoom(res.getString("labroom.description1"), 2);
		LabRoom labroom3 = new LabRoom(res.getString("labroom.description1"), 3);
		Corridor corridor1 = new Corridor(
		        res.getString("corridor1.description"));
		Corridor corridor2 = new Corridor(
		        res.getString("corridor2.description"));
		Corridor corridor3 = new Corridor(
		        res.getString("corridor3.description"));
		Corridor corridor4 = new Corridor(
		        res.getString("corridor4.description"));
		Library library = new Library(res.getString("library.description"));
		ExamRoom examroom = new ExamRoom(res.getString("examroom.description"));

		// initialise room exits

		corridor1.setExit("west", labroom1);
		corridor1.setExit("east", lunchroom);
		corridor1.setExit("north", corridor2);

		corridor2.setExit("south", corridor1);
		corridor2.setExit("west", lectureroom2);
		corridor2.setExit("east", lectureroom1);
		corridor2.setExit("north", corridor3);

		corridor3.setExit("south", corridor2);
		corridor3.setExit("west", labroom2);
		corridor3.setExit("east", labroom3);
		corridor3.setExit("north", corridor4);

		corridor4.setExit("south", corridor3);
		corridor4.setExit("west", library);
		corridor4.setExit("east", lectureroom3);
		corridor4.setExit("north", examroom);

		labroom1.setExit("east", corridor1);
		labroom2.setExit("east", corridor3);
		labroom3.setExit("west", corridor3);

		lunchroom.setExit("west", corridor1);

		library.setExit("east", corridor4);

		lectureroom1.setExit("west", corridor2);
		lectureroom2.setExit("east", corridor2);
		lectureroom3.setExit("west", corridor4);

		examroom.setExit("south", corridor4);

		currentRoom = corridor1; // start game in the first corridor
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
		createCourses();
		createRooms();
		createGamer();
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
			System.out.println("You are Chuck Norris, you never lose so congratulation you win !!!");
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

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			wantToQuit = quit(command);
		} else if (commandWord.equals("take")) {
			if (currentRoom instanceof Lunchroom) {
				wantCoffee(command);
			} else if (currentRoom instanceof Library) {
				wantBook(command);
			}
		} else if (commandWord.equals("lights")
		        && (currentRoom instanceof Corridor)) {
			goCorridor(command);
		} else if (commandWord.equals("attend")
		        && (currentRoom instanceof StudySpace)) {
			wantAttend(command);
		} else if (commandWord.equals("read")
		        && ((currentRoom instanceof Library))
		        || (!(gamer.getOOPbook().isEmpty()))) {
			wantRead(command);
		} else if (commandWord.equals("use")
		        && (currentRoom instanceof Corridor)) {
			wantUse(command);
		} else if (commandWord.equals("search")
		        && (currentRoom instanceof Corridor)) {
			wantSearch(command);
		} else if (commandWord.equals("start")
		        && (currentRoom instanceof ExamRoom)) {
			wantStart(command);
		}

		// else command not recognised.
		return wantToQuit;
	}

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println(res.getString("game.help2"));
		System.out.println(res.getString("game.help3"));
		System.out.println();
		System.out.println(res.getString("game.help4"));
		parser.showCommands();
	}

	/**
	 * Try to start the exam, if it's incomplete, display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantStart(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.start"));
		} else if ((command.getSecondWord().equals("exam"))
		        && (currentRoom instanceof ExamRoom)) {
			((ExamRoom) currentRoom).startExam(gamer);
			if (((ExamRoom) currentRoom).getExam().equals("noexam")) {
				System.out.println(Game.res
				        .getString("examroom.shortdescription")
				        + "\n"
				        + Game.res.getString("examroom.noexam")
				        + "\n"
				        + currentRoom.getExitString());
			} else
				System.out.println(currentRoom.getLongDescription());

		}
	}

	/**
	 * Try to use the tablet, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantUse(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.use"));
		} else if (command.getSecondWord().equals("tablet")) {
			((Corridor) currentRoom).useTablet(gamer);
		}

	}

	/**
	 * Try to search near the printer, if it's incomplete display an error
	 * message Then, display the answers available on the cheatsheet
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantSearch(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.search"));
		} else if (command.getSecondWord().equals("printer")) {
			System.out.println(Game.res.getString("cheatsheet.description1"));
			System.out.println(Game.res.getString("cheatsheet.description2"));
			((Corridor) currentRoom).useCheatsheet(gamer);
		}

	}

	/**
	 * Try to attend a lab or a lecture, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantAttend(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.attend"));
		} else if ((command.getSecondWord().equals("lab"))
		        && (currentRoom instanceof LabRoom)) {
			((LabRoom) currentRoom).attendLab(gamer);
			System.out.println(currentRoom.getLongDescription());

		} else if ((command.getSecondWord().equals("lecture"))
		        && (currentRoom instanceof LectureRoom)) {
			((LectureRoom) currentRoom).attendLecture(gamer);
			System.out.println(currentRoom.getLongDescription());
		}
	}

	/**
	 * Try to take and drink a coffee, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantCoffee(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.take"));
			return;
		} else if (command.getSecondWord().equals("coffee")) {
			System.out.println(res.getString("lunchroom.coffee1"));
			((Lunchroom) currentRoom).takeCoffee(gamer);
			System.out.println(res.getString("lunchroom.coffee2"));
		} else {
			System.out.println(res.getString("game.take"));
		}
		System.out.println(currentRoom.getExitString());
	}

	/**
	 * Try to read the book in the library, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantRead(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.read"));
		} else if (command.getSecondWord().equals("book")) {
			if (currentRoom instanceof Library) {
				((Library) currentRoom).learnPOO(gamer);
			} else {
				gamer.readTakenBook();
			}
		}

	}

	/**
	 * Try to turn the lights on, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void goCorridor(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know what to do...
			System.out.println(res.getString("game.idontknow"));
		} else if (command.getSecondWord().equals("on")) {
			((Corridor) currentRoom).setLights(true);
			(currentRoom).enter(gamer);

		} else if (command.getSecondWord().equals("off")) {
			((Corridor) currentRoom).setLights(false);
			System.out.println(res.getString("corridor.dark"));
		}
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
	 * Try to take the book in the library, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	private void wantBook(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.take"));
			return;
		} else if (command.getSecondWord().equals("book")) {
			((Library) currentRoom).takeBook(gamer);
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
}
