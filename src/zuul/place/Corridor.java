package zuul.place;

import zuul.Display;
import zuul.Game;
import zuul.commands.Command;
import zuul.object.Cheatsheet;
import zuul.object.Tablet;
import zuul.person.Student;

import java.util.Random;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create a Corridor which gives access to other room
 */
public class Corridor extends Room {
	private boolean lights, tablet, cheatsheet;
	private Tablet tabletInTheCorridor;
	private Cheatsheet cheatsheetInTheCorridor;
	private int nbRoom;

	/***
	 * 
	 * Constructor to create a Corridor
	 * 
	 * @param description
	 *            the description of the corridor
	 * 
	 ***/
	public Corridor(String description, int numRoom) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		nbRoom = numRoom;
		lights = (randomLight.nextBoolean()) ? true : false;

	}

	/***
	 * 
	 * Constructor to create a Corridor
	 * 
	 * @param description
	 *            the description of the corridor
	 * @param secret
	 *            , the boolean to define if the room is secret or not
	 * 
	 ***/
	public Corridor(String description, int numRoom, boolean secret) {
		super(description, secret);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		nbRoom = numRoom;
		lights = (randomLight.nextBoolean()) ? true : false;

	}

	/***
	 * 
	 * Method to randomize the apparition of tablet and cheatsheet
	 * 
	 ***/
	public void appearObject() {
		int chance1 = (int) (Math.random() * 20);
		tablet = (chance1 > 14) ? true : false;
		int chance2 = (int) (Math.random() * 20);
		cheatsheet = (chance2 > 18) ? true : false;

	}

	/***
	 * 
	 * Method to know if the student can enter in this corridor
	 * 
	 * @param student
	 *            the student who wants to go in
	 * @return true
	 * 
	 ***/
	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/***
	 * 
	 * Method to enter in this corridor
	 * 
	 * @param student
	 *            the student who wants to go in
	 * @return true
	 * 
	 ***/
	@Override
	public boolean enter(Student student) {
		if (isLights()) {
			appearObject();
			if (tablet) {
				tabletInTheCorridor = new Tablet();
				System.out.println(Game.res.getString("corridor.tablet"));
			}
			if (cheatsheet) {
				cheatsheetInTheCorridor = new Cheatsheet();
				System.out.println(Game.res.getString("corridor.cheatsheet"));
			}
			System.out.println(getLongDescription());
		} else {
			System.out.println(Game.res.getString("corridor.dark"));
			System.out.println(getExitString());
		}

		return true;
	}

	/***
	 * 
	 * Method to use tablet in this corridor
	 * 
	 * @param student
	 *            the student who wants to use it
	 * 
	 ***/
	@Override
	public void useTablet(Student student) {
		if (tablet) {
			tabletInTheCorridor.useObject(student);
			tablet = false;
		} else {
			System.out.println(Game.res.getString("corridor.notablet"));
		}
		System.out.println(this.getLongDescription());
	}

	/***
	 * 
	 * Method to use cheatsheet in this corridor
	 * 
	 * @param student
	 *            the student who wants to use it
	 * 
	 ***/
	public void useCheatsheet(Student student) {
		if (cheatsheet) {
			cheatsheetInTheCorridor.useObject(student);
			cheatsheet = false;
		} else {
			System.out.println(Game.res.getString("corridor.nocheatsheet"));
		}
		System.out.println(this.getLongDescription());
	}

	/***
	 * 
	 * Method to change the boolean lights to true
	 * 
	 */
	public void turnLightsOn() {
		lights = true;
	}

	/**
	 * @return the lights
	 */
	public boolean isLights() {
		return lights;
	}

	/**
	 * @param lights
	 *            the lights to set
	 */
	public void setLights(boolean lights) {
		this.lights = lights;
	}

	/**
	 * Switch the light on
	 * 
	 */
	@Override
	public void switchLightsOn() {
		this.setLights(true);

	}

	/**
	 * Switch the light off
	 * 
	 */
	@Override
	public void switchLightsOff() {
		this.setLights(false);
		Display.displayln("corridor.dark");
	}

	/**
	 * Try to search near the printer, if it's incomplete display
	 * message Then, display the answers available on the cheatsheet
	 * 
	 *
	 * 
	 * @param gamer
	 *            The Student who want to use a tablet
	 */
	@Override
	public void checkPrinter(Student gamer) {
		Display.display("cheatsheet.description1");
		Display.display("cheatsheet.description2");
		this.useCheatsheet(gamer);
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName() + " " + Integer.toString(nbRoom);
	}
}
