package zuul.place;

import zuul.Game;
import zuul.commands.Command;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Person;
import zuul.person.Student;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create a LabRoom
 */
public class LabRoom extends StudySpace {

	/***
	 * 
	 * Constructor to create a LabRoom
	 * 
	 * @param description
	 *            the description of the labroom
	 * @param nbRoom
	 *            the integer which defines the courses in this labroom
	 * 
	 ***/
	public LabRoom(String description, int nbRoom) {
		super(description, nbRoom);
		coursInThisRoom = new LabItem();

	}
	
	/***
	 * 
	 * Constructor to create a LabRoom
	 * 
	 * @param description
	 *            the description of the lectureroom
	 * @param nbRoom
	 *            the integer which defines the courses in this lectureroom
	 * @param secret
	 *            the boolean which defines if the LectureRoom is secret or not
	 ***/
	public LabRoom(String description, int nbRoom,boolean secret) {
		super(description, nbRoom,secret);
		coursInThisRoom = new LabItem();


	}

	/**
	 * This function determines if the student can enter the labroom or not the
	 * student can't enter if he didn't attend the respective lecture
	 * 
	 * @param student
	 *            who wants enter in the labroom
	 * @return true if the student can enter and false if he can't
	 */
	@Override
	public boolean canEnter(Student student) {
		if (coursInThisRoom.getNumber() == 0) {
			return true;
		} else if (!student.alreadyListenedLecture(new LectureItem(
				coursInThisRoom.getModule(), coursInThisRoom.getNumber()))) {
			String string = new String(Game.res.getString("labroom.noattend1")
					+ coursInThisRoom.getModule()
					+ Game.res.getString("labroom.noattend2")
					+ coursInThisRoom.getNumberString());
			System.out.println(string);
			return false;
		}
		return true;
	}

	/**
	 * This function determines if the student must enter in the labroom (if the
	 * labroom contains an OOP lab and if the student learns the responsive
	 * lecture) or not the student can't enter if he didn't attend the
	 * respective lecture
	 * 
	 * @param student
	 *            the Student who wants enter in this LabRoom
	 * @return true if the student must enter and false if he mustn't
	 */
	public boolean mustEnter(Student student) {
		return super.mustEnter(student);
	}

	/***
	 * 
	 * Method to enter in this examroom
	 * 
	 * @param student
	 *            the Student who wants to go in
	 * @return true if he can go in and false if he can't
	 * 
	 ***/
	@Override
	public boolean enter(Student student) {
		randomizeCourses();

		isAttend = false;

		if (canEnter(student)) {
			if (coursInThisRoom.getNumber() == 0) {
				System.out.println(getLongDescription());
			} else if (mustEnter(student)) {
				attendLab(student);
				System.out.println(getLongDescription());
			} else {
				System.out.println(getLongDescription());
			}

			return true;
		} else
			return false;
	}

	/***
	 * 
	 * Method to randomize the lab in the labroom (it will have no lab too)
	 * 
	 ***/
	@Override
	public void randomizeCourses() {
		if (nbRoom == 1)
			coursInThisRoom = Game.labs
					.get((int) (Math.random() * (3 - 0) + 0));
		else if (nbRoom == 2)
			coursInThisRoom = Game.labs
					.get((int) (Math.random() * (6 - 3) + 3));

		else
			coursInThisRoom = Game.labs
					.get((int) (Math.random() * (9 - 6) + 6));

		int noCours = (int) (Math.random() * 9);
		if (noCours > 6) {
			coursInThisRoom = new LectureItem();
		}
	}

	/***
	 * 
	 * Method to add the lab of this labroom in the labsSuivi of the student
	 * 
	 * @param goodStudent
	 *            the sSudent who attends the lab
	 */
	public void attendLab(Student goodStudent) {
		if (coursInThisRoom.getNumber() != 0) {
			System.out.println(Game.res.getString("labroom.attendlab.part1")
					+ coursInThisRoom.getModule()
					+ Game.res.getString("room.attend.part2")
					+ coursInThisRoom.getNumber()
					+ Game.res.getString("room.attend.part3"));
			try {
				Thread.sleep(3000);
				System.out.println("...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			isAttend = true;
			System.out.println(Game.res.getString("labroom.attendlab.part4"));
			goodStudent.decrementEnergy(10);
			goodStudent.addItem(coursInThisRoom);
		}

	}

	/**
	 * Return a description of the room in the form: You are in the kitchen.
	 * Exits: north west
	 * 
	 * @return A long description of this room
	 */
	@Override
	public String getLongDescription() {
		if (coursInThisRoom.getNumber() == 0) {
			return Game.res.getString("labroom.shortdescription")
					+ Game.res.getString(coursInThisRoom.getBundleKey()) + "\n"
					+ getExitString();
		} else if (isAttend) {
			return getExitString();
		} else
			return description + coursInThisRoom.getModule() + " numero "
					+ coursInThisRoom.getNumberString() + ".\n"
					+ Game.res.getString("labroom.description2") + "\n"
					+ getExitString();
	}

	/**
	 * Try to attend a lab, if it's incomplete display an error
	 * message
	 * 
	 * @param command
	 *            The command to be processed.
	 * 
	 * @param gamer
	 *            The Student who want to attend to a lecture or a lab
	 */
	@Override
	public void wantAttend(Command command, Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(Game.res.getString("game.attend"));
		} else if ((command.getSecondWord().equals("lab"))) {
			this.attendLab(gamer);
			System.out.println(this.getLongDescription());
		}

	}
}
