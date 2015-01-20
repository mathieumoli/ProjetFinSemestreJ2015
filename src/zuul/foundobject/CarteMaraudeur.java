package zuul.foundobject;

import java.util.ArrayList;
import java.util.Scanner;

import zuul.person.Person;

/**
 * 
 * @author Mathieu Molinengo
 *
 */
public class CarteMaraudeur {

	private ArrayList<Person> persons;
	private String password;
	private boolean locked;

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map
	 * 
	 */
	public CarteMaraudeur() {
		persons = new ArrayList<Person>();
		password = "je jure solennellement que mes intentions sont mauvaises";
		locked = true;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map
	 * 
	 */
	public CarteMaraudeur(ArrayList<Person> baladeurs) {
		persons = baladeurs;
		password = "je jure solennellement que mes intentions sont mauvaises";
		locked = true;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map, String the password
	 * of the map
	 * 
	 */
	public CarteMaraudeur(ArrayList<Person> baladeurs, String passwordChanged) {
		persons = baladeurs;
		password = passwordChanged;
		locked = true;
	}

	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map, String the password
	 * of the map and the boolean to unlock or lock the map
	 * 
	 */
	public CarteMaraudeur(ArrayList<Person> baladeurs, String passwordChanged,
	        boolean lock) {
		persons = baladeurs;
		password = passwordChanged;
		locked = lock;
	}

	public void seePeople() {
		// TODO internationalisation
		if (locked == false) {
			int i;
			for(i=0;i<persons.size();i++)
		}
		else
		{
			System.out.println("Give my the password stupid human");
			Scanner scanner = new Scanner(System.in);
			String pass = scanner.nextLine();
			unlockMap(pass);
		}

	}

	public void unlockMap(String pass) {
		if (pass.equals("i am chuck norris") || password.equals(pass)) {
			locked = false;
			seePeople();
		} else
			System.out
			        .println("You don't know the password, you'll never know where are the others");

	}
}
