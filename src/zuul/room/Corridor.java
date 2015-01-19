package zuul.room;

import zuul.Game;
import zuul.foundobject.Cheatsheet;
import zuul.foundobject.Tablet;
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

	/***
	 * 
	 * Constructor to create a Corridor
	 * @param description the description of the corridor
	 * 
	 ***/
	public Corridor(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();

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
		cheatsheet = (chance2 > 17) ? true : false;

	}

	/***
	 * 
	 * Method to know if the student can enter in this corridor
	 * @param student the student who wants to go in
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
	 * @param student the student who wants to go in
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
	 * @param student the student who wants to use it
	 * 
	 ***/
	public void useTablet(Student student) {
		if(tablet){
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
	 * @param student the student who wants to use it
	 * 
	 ***/
	public void useCheatsheet(Student student) {
		if(cheatsheet){
			cheatsheetInTheCorridor.useObject(student);
			cheatsheet = false;
		} else{
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
}
