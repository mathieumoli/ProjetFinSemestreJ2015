package zuul.object;

import java.util.ArrayList;
import java.util.Scanner;

import zuul.Display;
import zuul.Game;
import zuul.affichage.Plan;
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
		
		password = Game.res.getString("maraudeur.password");
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
		
		Display.displayln("maraudeur.show");
		if (locked == false) {
			int i;
			for(i=0;i<persons.size();i++){
				
				Display.display(persons.get(i).getName());
				Display.display("maraudeur.see");
				Display.displayln(persons.get(i).getCurrentRoom().getName());
			}
			
			Display.display("maraudeur.you");
			Display.displayln(owner.getCurrentRoom().getName());
		}
		else
		{
			
			Display.displayln("maraudeur.passwordAnnonce");
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
		
		if (pass.equals(Game.res.getString("maraudeur.alterpassword")) || password.equals(pass)) {
			locked = false;
			seePeople();
		} else
			Display.displayln("maraudeur.failpassword");


	}

	@Override
    public void useObject(Student student) {
	    seePeople();
	    Plan g=new Plan("maraudeurmap.jpg");
	   System.out.println(student.getCurrentRoom().getExitString());
	    
    }
}
