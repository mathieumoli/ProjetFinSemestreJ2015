package zuul.person;

import java.util.ArrayList;
import java.util.ResourceBundle;

import zuul.Game;
import zuul.course.Item;
import zuul.course.LabItem;
import zuul.course.LectureItem;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create a Student
 */
public class Student {

	private ArrayList<LectureItem> oopBook;
	private int energy;
	private String name;
	private ArrayList<LectureItem> coursSuivi;
	private ArrayList<LabItem> labsSuivi;

	/***
	 * 
	 * Constructor to create a Student
	 * 
	 * @param nameOfStudent
	 *            the name of created student
	 * 
	 ***/
	public Student(String nameOfStudent) {
		energy = 100;
		name = nameOfStudent;
		coursSuivi = new ArrayList<LectureItem>();
		labsSuivi = new ArrayList<LabItem>();
		oopBook = new ArrayList<LectureItem>();
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
			System.out.println(this.name
					+ Game.res.getString("student.addLab.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		} else {
			if (!alreadyListenedLecture(new LectureItem(
					itemListened.getModule(), itemListened.getNumber()))) {
				coursSuivi.add((LectureItem) itemListened);
			}
			System.out.println(this.name
					+ Game.res.getString("student.addLecture.part1")
					+ itemListened.getModule()
					+ Game.res.getString("student.add.part2")
					+ itemListened.getNumberString());
		}
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
			System.out.println(Game.res.getString("student.energy.part1")
					+ this.name + Game.res.getString("student.energy.part2")
					+ this.getEnergyString());
		} else {
			energy = 0;
			System.out.println(Game.res.getString("student.energy0"));
			System.out.println(Game.res.getString("game.thankyou"));
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

		System.out.println(Game.res.getString("student.energy.part1")
				+ this.name + Game.res.getString("student.energy.part2")
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
			System.out.println(Game.res
					.getString(oopBook.get(i).getBundleKey()));
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
	 * Method to get the energy of the student with a string format
	 * 
	 * @return the energy of the student with a string format
	 */
	public String getEnergyString() {
		return Integer.toString(energy);
	}

	/***
	 * 
	 * Method to get the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return name;
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
			System.out.println(Game.res.getString("student.removeLecture1")
					+ coursSuivi.get(index).getModule()
					+ Game.res.getString("student.removeLecture2")
					+ coursSuivi.get(index).getNumberString());
			lab = new LabItem(coursSuivi.get(index).getModule(), coursSuivi
					.get(index).getNumber());
			coursSuivi.remove(index);

			if (labsSuivi.contains(lab)) {
				int indexOfRem = labsSuivi.indexOf(lab);

				System.out.println(Game.res.getString("student.removeLab1")
						+ labsSuivi.get(indexOfRem).getModule()
						+ Game.res.getString("student.removeLecture2")
						+ labsSuivi.get(indexOfRem).getNumberString());
				labsSuivi.remove(indexOfRem);
			}
		}
	}
}