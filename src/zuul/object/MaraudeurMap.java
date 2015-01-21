package zuul.object;

import java.util.ArrayList;
import java.util.Scanner;

import zuul.person.Person;
import zuul.person.Student;

/**
 * 
 * @author Mathieu Molinengo
 *
 */
public class MaraudeurMap extends ZuulObject{

	private ArrayList<Person> persons;
	private String password;
	private boolean locked;
	private Student owner;

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map
	 * 
	 */
	public MaraudeurMap(Student player) {
		super("Map");
		persons = new ArrayList<Person>();
		// TODO internationalisation
		password = "je jure solennellement que mes intentions sont mauvaises";
		locked = true;
		owner=player;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map
	 * 
	 */
	public MaraudeurMap(ArrayList<Person> baladeurs,Student player) {
		super("Map");
		persons = baladeurs;
		password = "je jure solennellement que mes intentions sont mauvaises";
		locked = true;
		owner=player;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map, String the password
	 * of the map
	 * 
	 */
	public MaraudeurMap(ArrayList<Person> baladeurs, String passwordChanged,Student player) {
		super("Map");
		persons = baladeurs;
		password = passwordChanged;
		locked = true;
		owner=player;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map, String the password
	 * of the map and the boolean to unlock or lock the map
	 * 
	 */
	public MaraudeurMap(ArrayList<Person> baladeurs, String passwordChanged,
	        boolean lock) {
		super("Map");
		persons = baladeurs;
		password = passwordChanged;
		locked = lock;
	}

	/**
	 * To see other People
	 */
	private void seePeople() {
		// TODO internationalisation
		System.out.println("--- Marauder Map ---");
		if (locked == false) {
			int i;
			for(i=0;i<persons.size();i++){
				// TODO internationalisation
				System.out.println(persons.get(i).getName()+" is in "+persons.get(i).getCurrentRoom().getClass().getSimpleName());
			}
			// TODO internationalisation
			System.out.println("You are in : "+owner.getCurrentRoom().getClass().getSimpleName());
		}
		else
		{
			// TODO internationalisation
			System.out.println("Give my the password stupid human");
			Scanner scanner = new Scanner(System.in);
			String pass = scanner.nextLine();
			unlockMap(pass);
		}

	}
	/**
	 *  To unlock the Map and see people 
	 * 
	 * @param pass the scanned string which can be the password
	 */
	private void unlockMap(String pass) {
		// TODO internationalisation
		if (pass.equals("i am dark vador") || password.equals(pass)) {
			locked = false;
			seePeople();
		} else
			System.out
			        .println("You don't know the password, you'll never know where are the others");

	}

	@Override
    public void useObject(Student student) {
	    seePeople();
	   System.out.println(student.getCurrentRoom().getExitString());
	    
    }
}
