package zuul.place;

import java.util.ArrayList;
import java.util.HashMap;

import zuul.object.Broom;
import zuul.object.MaraudeurMap;
import zuul.object.PayingObject;
import zuul.object.Pc;
import zuul.object.Wand;
import zuul.person.Person;
import zuul.person.Seller;
import zuul.person.Student;

public class School {

	private HashMap<String, Room> hashmapRoom;
	private Room currentRoom;

	public School(ArrayList<Person> people, Student gamer,
	        HashMap<String, PayingObject> listPayingObject) {
		hashmapRoom = new HashMap<String, Room>();
		init(people, gamer, listPayingObject);
	}

	public void init(ArrayList<Person> people, Student gamer,
	        HashMap<String, PayingObject> listPayingObject) {
		
		Room ali, exam, foyer, lab1, lab2, lab3, lecture1, lecture2, lecture3, lunchRoom, library, secretariat, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13;
		boolean secret = true; // use to set secrete room
		hashmapRoom = new HashMap<String, Room>();

		ali = new AliOffice("alioffice.description");
		exam = new ExamRoom("examroom.description");
		foyer = new Foyer("club.description");
		lab1 = new LabRoom("labroom.description1", 1);
		lab2 = new LabRoom("labroom.description1", 2);
		lab3 = new LabRoom("labroom.description1", 3);
		lecture1 = new LectureRoom("lectureroom.description1", 1);
		lecture2 = new LectureRoom("lectureroom.description1", 2);
		lecture3 = new LectureRoom("lectureroom.description1", 3);
		library = new Library("library.description");
		lunchRoom = new Lunchroom("lunchroom.description", new Seller(
		        "Oussama", listPayingObject));
		secretariat = new Secretariat("secretarialDepartment.description");
		c1 = new Corridor("corridor1.description", 1);
		c2 = new Corridor("corridor2.description", 2);
		c3 = new Corridor("corridor3.description", 3);
		c4 = new Corridor("corridor4.description", 4);
		c5 = new Corridor("corridor5.description", 5, secret);
		c6 = new Corridor("corridor6.description", 6);
		c7 = new Corridor("corridor7.description", 7);
		c8 = new Corridor("corridor8.description", 8);
		c9 = new Corridor("corridor9.description", 9);
		c10 = new Corridor("corridor10.description", 10);
		c11 = new Corridor("corridor11.description", 11, secret);
		c12 = new Corridor("corridor12.description", 12);
		c13 = new Corridor("corridor13.description", 13, secret);

		c1.setExit("north", c2);
		c1.setExit("south", foyer);
		c1.setExit("east", lecture1);
		c1.setExit("west", secretariat);
		c2.setExit("north", c3);
		c2.setExit("south", c1);
		c2.setExit("east", lecture2);
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
		c12.setExit("west", c11);
		lecture1.setExit("west", c1);
		lecture2.setExit("west", c2);
		lecture3.setExit("west", c3);
		lab1.setExit("west", c6);
		lab2.setExit("west", c7);
		lab3.setExit("west", c8);
		secretariat.setExit("east", c1);
		exam.setExit("north", c5);
		lunchRoom.setExit("east", c9);
		library.setExit("south", c10);
		foyer.setExit("north", c1);
		ali.setExit("south", c12);
		c13.setExit("east", c7);
		c7.setExit("west", c13);

		c13.addAnObjectInRoom(new MaraudeurMap(people, gamer));
		foyer.addAnObjectInRoom(new Wand());
		foyer.addAnObjectInRoom(new Pc());
		c1.addAnObjectInRoom(new Broom());
		hashmapRoom.put("ali", ali);
		hashmapRoom.put("exam", exam);
		hashmapRoom.put("foyer", foyer);
		hashmapRoom.put("lab1", lab1);
		hashmapRoom.put("lab2", lab2);
		hashmapRoom.put("lab3", lab3);
		hashmapRoom.put("lecture1", lecture1);
		hashmapRoom.put("lecture2", lecture2);
		hashmapRoom.put("lecture3", lecture3);
		hashmapRoom.put("library", library);
		hashmapRoom.put("lunchroom", lunchRoom);
		hashmapRoom.put("secretariat", secretariat);
		hashmapRoom.put("c1", c1);
		hashmapRoom.put("c2", c2);
		hashmapRoom.put("c3", c3);
		hashmapRoom.put("c4", c4);
		hashmapRoom.put("c5", c5);
		hashmapRoom.put("c6", c6);
		hashmapRoom.put("c7", c7);
		hashmapRoom.put("c8", c8);
		hashmapRoom.put("c9", c9);
		hashmapRoom.put("c10", c10);
		hashmapRoom.put("c11", c11);
		hashmapRoom.put("c12", c12);
		hashmapRoom.put("c13", c13);

		currentRoom = foyer;
	}

	/**
	 * A method returning all the rooms.
	 * @return
	 */
	public HashMap<String,Room> getRooms() {
		return hashmapRoom;
	}
	
}
