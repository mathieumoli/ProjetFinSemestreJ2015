package zuul.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import zuul.Display;
import zuul.Game;
import zuul.affichage.Plan;
import zuul.commands.Command;
import zuul.course.Item;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.object.ZuulObject;
import zuul.person.object.Wallet;
import zuul.place.Room;

/**
 * @author Mathieu Molinengo & Cédric Lallemand
 * @version 2015.01.20
 * 
 *          Class to create a Student
 */
public class Student extends Person {

	final int ADD_ENERGIE_COFFEE = 30;
	final int LOSE_ENERGIE_BABYFOOT = 20;

	private ArrayList<LectureItem> oopBook;
	private int energy;
	private boolean isInvisible;
	private ArrayList<LectureItem> coursSuivi;
	private ArrayList<LabItem> labsSuivi;
	private HashMap<String, ZuulObject> bag;

	/***
	 * 
	 * Constructor to create a Student
	 * 
	 * @param nameOfStudent
	 *            - the name of created student
	 * 
	 ***/
	public Student(String nameOfStudent) {
		super(nameOfStudent, new Wallet(5));
		energy = 100;
		isInvisible = false;
		coursSuivi = new ArrayList<LectureItem>();
		labsSuivi = new ArrayList<LabItem>();
		oopBook = new ArrayList<LectureItem>();
		bag = new HashMap<String, ZuulObject>();
	}

	/***
	 * 
	 * Method to add an item (lab or lecture) which is learned by the student
	 * 
	 * @param itemListened
	 *            the item which must be added
	 * 
	 ***/
	public void addItem(Item itemListened) {
		if (itemListened instanceof LabItem) {
			if (!alreadyListenedLab(new LabItem(itemListened.getModule(),
			        itemListened.getNumber()))) {
				labsSuivi.add((LabItem) itemListened);
			}
			Display.displayln(this.getName()
			        + Game.res.getString("student.addLab.part1")
			        + itemListened.getModule()
			        + Game.res.getString("student.add.part2")
			        + itemListened.getNumberString());
		} else {
			if (!alreadyListenedLecture(new LectureItem(
			        itemListened.getModule(), itemListened.getNumber()))) {
				coursSuivi.add((LectureItem) itemListened);
			}
			Display.displayln(this.getName()
			        + Game.res.getString("student.addLecture.part1")
			        + itemListened.getModule()
			        + Game.res.getString("student.add.part2")
			        + itemListened.getNumberString());
		}
	}

	public void learnItem(Item item) {
		this.decrementEnergy(10);
		this.addItem(item);
	}

	/***
	 * 
	 * Method to decrement the energy of the student
	 * 
	 * @param theEnergy
	 *            the number of energy which must be removed
	 * 
	 ***/
	public void decrementEnergy(int theEnergy) {
		if (energy > theEnergy) {
			energy -= theEnergy;
			Display.displayln(Game.res.getString("student.energy.part1")
			        + this.getName()
			        + Game.res.getString("student.energy.part2")
			        + this.getEnergyString());
		} else {
			energy = 0;
			Display.displayln(Game.res.getString("student.energy0"));
			Display.displayln(Game.res.getString("game.thankyou"));
			System.exit(1);
		}
	}

	/***
	 * 
	 * Method to increment the energy of the student
	 * 
	 * @param theEnergy
	 *            the number of energy which must be added
	 * 
	 ***/
	public void incrementEnergy(int theEnergy) {
		energy += theEnergy;
		if (energy > 100) {
			energy = 100;
		}
		Display.displayln(Game.res.getString("student.energy.part1")
		        + this.getName() + Game.res.getString("student.energy.part2")
		        + this.getEnergyString() + ".");
	}

	/***
	 * 
	 * Method to check if a lab is already listened
	 * 
	 * @param theItem
	 *            the LabItem which must be checked
	 * 
	 * @return true if theItem was alreadyListened and false if it's not
	 * 
	 ***/
	public boolean alreadyListenedLab(LabItem theItem) {
		boolean listened = false;
		int i;
		int size = labsSuivi.size();
		for (i = 0; i < size; i++) {
			listened = theItem.equals(labsSuivi.get(i));
			if (listened)
				break;
		}
		return listened;
	}

	/***
	 * 
	 * Method to add lectures of the taken OOP Book to the ArrayList coursSuivi
	 * 
	 * 
	 ***/
	public void readTakenBook() {
		for (int i = 0; i < oopBook.size(); i++) {
			this.addItem(oopBook.get(i));
			Display.displayln(Game.res.getString(oopBook.get(i).getBundleKey()));
		}
		this.decrementEnergy(35);
	}

	/***
	 * 
	 * Method to check if a lecture is already listened
	 * 
	 * @param theItem
	 *            the LectureItem which must be checked
	 * 
	 * @return true if theItem was alreadyListened and false if it's not
	 * 
	 ***/
	public boolean alreadyListenedLecture(LectureItem theItem) {
		boolean listened = false;
		int i;
		int size = coursSuivi.size();

		for (i = 0; i < size; i++) {
			listened = theItem.equals(coursSuivi.get(i));
			if (listened)
				break;
		}
		return listened;

	}

	/***
	 * 
	 * Method to get the energy of the student
	 * 
	 * @return the energy of the student
	 * 
	 */
	public int getEnergy() {
		return energy;

	}

	/***
	 * 
	 * Method to know if the student is invisible
	 * 
	 * @return true if the student is invisible
	 * 
	 */
	public boolean isInvisible() {
		return isInvisible;
	}

	/**
	 * 
	 * Change the visibility of the Student
	 * 
	 */
	public void changeVisibility() {
		if (isInvisible) {
			isInvisible = false;
			Display.displayln("student.cloakoff");
		} else {
			isInvisible = true;
			Display.displayln("student.cloakon");
		}
	}

	/***
	 * 
	 * Method to get the energy of the student with a string format
	 * 
	 * @return the energy of the student with a string format
	 */
	public String getEnergyString() {
		return Integer.toString(energy);
	}

	/***
	 * 
	 * Method to get the ArrayList of learned lectures
	 * 
	 * @return coursSuivi the ArrayList of learned lectures
	 */
	public ArrayList<LectureItem> getCoursSuivi() {
		return coursSuivi;
	}

	/***
	 * 
	 * Method to get the ArrayList of labs
	 * 
	 * @return labsSuivi the ArrayList of labs
	 */
	public ArrayList<LabItem> getLabsSuivi() {
		return labsSuivi;
	}

	/**
	 * Method to get the ArrayList which contains the taken OOP Book if a OOP
	 * Book was taken
	 * 
	 * @return the oOPbook
	 */
	public ArrayList<LectureItem> getOOPbook() {
		return oopBook;
	}

	/**
	 * Method to set an ArrayList of LectureItem in the variable oopBook
	 * 
	 * @param book
	 *            the oOPbook to set
	 */
	public void setOOPbook(ArrayList<LectureItem> book) {
		oopBook = book;
	}

	/***
	 * 
	 * Method to remove an item (lab or lecture) which is learned by the student
	 * 
	 * 
	 ***/
	public void removeItem() {
		LabItem lab;
		if (!coursSuivi.isEmpty()) {
			int taille = coursSuivi.size() - 1;

			int index = (int) (Math.random() * taille);
			Display.displayln(Game.res.getString("student.removeLecture1")
			        + coursSuivi.get(index).getModule()
			        + Game.res.getString("student.removeLecture2")
			        + coursSuivi.get(index).getNumberString());
			lab = new LabItem(coursSuivi.get(index).getModule(), coursSuivi
			        .get(index).getNumber());
			coursSuivi.remove(index);

			if (labsSuivi.contains(lab)) {
				int indexOfRem = labsSuivi.indexOf(lab);

				Display.displayln(Game.res.getString("student.removeLab1")
				        + labsSuivi.get(indexOfRem).getModule()
				        + Game.res.getString("student.removeLecture2")
				        + labsSuivi.get(indexOfRem).getNumberString());
				labsSuivi.remove(indexOfRem);
			}
		}
	}

	/**
	 * 
	 * Return the success of the attempt to steal
	 * 
	 * @return true of the steal is successful
	 */
	public boolean successStealsMoney() {
		double random = Math.random()*100;
		boolean success = false;
		if (this.isInvisible()) {
			if (random > 20) {
				success = true;
			}
		} else {
			if (random > 80) {
				success = true;
			}
		}

		return success;
	}

	/**
	 * 
	 * Steals money in the wallet of "personStolen"
	 * 
	 * @param personStolen
	 *            - person which is stolen
	 * @return amount stolen
	 * 
	 */
	public void StealsMoney(Person personStolen) {
		this.decrementEnergy(10);
		if (successStealsMoney()) {
			this.getWallet().raiseMoney(personStolen.getWallet().stolen());
			Display.displayln("student.stealSucces");
			this.getWallet().displayMoney();
		} else {
			Display.displayln("student.spotted");
			this.decrementEnergy(20);
		}
	}

	/**
	 * Call when a student play babyfoot
	 */
	public void playBabyFoot() {
		this.getWallet().decreaseMoney(1);
		this.decrementEnergy(LOSE_ENERGIE_BABYFOOT);
		this.removeItem();
	}

	/**
	 * to verify if the student can use a course or a lab
	 * @param command the command types by the student
	 */
	public void wantUse(Command command) {
		if (command.hasSecondWord()) {
			String object = command.getSecondWord();
			object = object.toLowerCase();
			if (bag.containsKey(object)) {
				bag.get(object).useObject(this);
				if (!object.equals("map")) {
					bag.remove(object);
				}
			} else {
				Display.displayln("student.donthavethisinbag");
			}
		} else {
			Display.displayError("student.utilisationobject");
			this.displayObjectsInBag();
		}

	}

	/**
	 * This method interacts with other people in the room, following if there
	 * are one or several people in the room. You can say "hello".
	 * 
	 * @param command
	 * @param people
	 */
	public void wantSayHello(Command command, ArrayList<Person> people) {
		String word2 = "";
		Stromboni s = null;
		boolean stromboniIsHere = false;
		if (command.getSecondWord() != null) {
			word2 = command.getSecondWord().toLowerCase();
		}
		// ici récupérer les personnes qui sont bien dans la currentRoom de this
		ArrayList<Person> peopleInTheRoom = this.getCurrentRoom().peopleInRoom(
		        people);

		int nbOfPeople = peopleInTheRoom.size();
		if (nbOfPeople == 0) {
			Display.displayln("room.empty");
			return;
		}

		for (Person person : peopleInTheRoom) {
			if (person.canAllowToPassExam()) {
				s = (Stromboni) person;
				stromboniIsHere = true;
			}
		}
		if (stromboniIsHere) {
			s.answerBack(command, this.getWallet(), labsSuivi);
		} else {
			int i;
			for (i = 0; i < peopleInTheRoom.size(); i++) {
				peopleInTheRoom.get(i).answerBack(command);
			}
		}

	}

	/**
	 * 
	 * Call to know if a object can be add in bag
	 * 
	 * @param objectName
	 *            - the name of the object to add in bag
	 * @return - true if we can add the object in the bag
	 */
	public boolean canAddInBag(String objectName) {
		return !bag.containsKey(objectName);
	}

	/**
	 * Display the object in the bag
	 */
	public void displayObjectsInBag() {
		if (!this.bag.isEmpty()) {
			for (Entry<String, ZuulObject> entry : this.bag.entrySet()) {
				Display.displayln("- " + entry.getValue().getName());
			}
		} else {
			Display.displayln("student.emptybag");
		}
	}

	/**
	 * Add a object in the bag
	 * 
	 * @param obj
	 *            - object to add in the bag
	 */
	public void addInBag(ZuulObject obj) {
		if (this.canAddInBag(obj.getName())) {
			bag.put(obj.getName().toLowerCase(), obj);
		} else {
			Display.displayln("student.canthavemoreobjects");
		}
	}

	/**
	 * 
	 * If there is an object in the current room, it is add in the bag (if the
	 * room has more than one object only one is add to the bag, a other search
	 * is mandatory to discover the other)
	 * 
	 */
	public void searchInRoom() {
		if (this.getCurrentRoom().objectInRoom()) {
			ZuulObject objectFound = this.getCurrentRoom().search();
			Display.displayln(Game.res.getString("student.iadd")
			        + objectFound.getName()
			        + Game.res.getString("student.inmybag"));
			this.addInBag(objectFound);
		} else {
			Display.displayln("student.noobjecthere");
		}
	}

	/**
	 * A method printing the map.
	 * 
	 * @param command
	 */
	public void seePlan(Command command) {
		if (command.getSecondWord() != null
		        && command.getSecondWord().toLowerCase().equals("plan")) {
			if (bag.containsKey("map")) {
				new Plan("planAvecSallesSecretes.jpg");
			} else {
				new Plan("planSansSallesSecretes.jpg");
			}
		} else {
			Display.displayln("student.whattosee");
		}
	}

	/**
	 * Call when a student want buy something
	 * 
	 * @param commande
	 *            give by the user
	 */
	public void wantBuy(Command command) {
		if (this.getCurrentRoom().canBuy()) {
			if (!command.hasSecondWord()) {
				this.getCurrentRoom().diplayAvalaiblePayingObject();
			} else {
				String objectName = command.getSecondWord().toLowerCase();
				if (this.canAddInBag(objectName)) {
					this.getCurrentRoom().buy(objectName, this);
					this.getWallet().displayMoney();
				} else {
					Display.displayln("student.cantbuythis");
				}
			}
		} else {
			Display.displayln("room.noSeller");
		}
	}

	/**
	 * To verify the command and launch the fonction in the room to switch the
	 * light
	 * 
	 * @param command
	 *            the command of the user
	 */
	public void wantSwitchLights(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know what to do...
			Display.displayln("game.idontknow");
		} else if (command.getSecondWord().equals("on")) {
			getCurrentRoom().switchLightsOn();
			getCurrentRoom().enter(this);
		} else if (command.getSecondWord().equals("off")) {
		}
		getCurrentRoom().switchLightsOff();

	}

	/**
	 * To verify the command and launch the fonction in the room to start an
	 * exam
	 * 
	 * @param command
	 *            the command of the user
	 */
	public void wantStart(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Display.displayError("game.start");
		} else if (command.getSecondWord().equals("exam")) {
			getCurrentRoom().startExam(this);
		}

	}

	/**
	 * To verify the command and launch the fonction in the room to check the
	 * pointer
	 * 
	 * @param command
	 *            the command of the user
	 */
	public void checkPrinter(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Display.displayln("game.search");
		} else if (command.getSecondWord().equals("printer")) {

			getCurrentRoom().checkPrinter(this);
		}

	}

	/**
	 * to verify if the student can attend a course or a lab
	 * @param command the command types by the student
	 */
	public void wantAttend(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Display.displayln("game.attend");
		} else if ((command.getSecondWord().equals("lab"))) {
			getCurrentRoom().attendLab(this);
		} else if ((command.getSecondWord().equals("lecture"))) {
			getCurrentRoom().attendLecture(this);
		} else {
			Display.displayln("game.attend");
		}

	}

	/**
	 * 
	 * Call when the user want steal
	 * 
	 * @param command
	 *            - the command of the user
	 */
	public void wantSteal(Command command, ArrayList<Person> allPeople) {
		if (command.hasSecondWord()) {
			ArrayList<Person> peopleInRoom = this.getCurrentRoom()
			        .peopleInRoom(allPeople);
			for (Person p : peopleInRoom) {
				if (p.getName().equals(command.getSecondWord())) {
					this.StealsMoney(p);
					return;
				}
			}
			Display.displayError("student.personnothere");
		} else {
			Display.displayError("student.utilisationsteal");
		}
	}

}
