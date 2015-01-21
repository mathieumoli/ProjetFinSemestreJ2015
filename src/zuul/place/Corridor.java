package zuul.place;

import zuul.Game;
import zuul.commands.Command;
import zuul.object.Cheatsheet;
import zuul.object.Tablet;
import zuul.person.Person;
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
	 * Constructor to create a Corridor
	 * @param description the description of the corridor
	 * @param secret, the boolean to define if the room is secret or not
	 * 
	 ***/
	public Corridor(String description,boolean secret) {
		super(description,secret);
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
		cheatsheet = (chance2 > 18) ? true : false;

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
	
	/**
	 * Try to use the tablet, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 * @param gamer
	 *            The Student who want to use a tablet
	 */
	@Override
    public void wantSwitchLights(Command command,Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know what to do...
			System.out.println(Game.res.getString("game.idontknow"));
		} else if (command.getSecondWord().equals("on")) {
			this.setLights(true);
			this.enter(gamer);

		} else if (command.getSecondWord().equals("off")) {
			this.setLights(false);
			System.out.println(Game.res.getString("corridor.dark"));
		}
	}
	
	/**
	 * Try to use the tablet, if it's incomplete display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	@Override
	public void wantTurn(Command command,Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(Game.res.getString("game.use"));
		} else if (command.getSecondWord().equals("tablet")) {
			this.useTablet(gamer);
		}

	}
	
	/**
	 * Try to search near the printer, if it's incomplete display an error
	 * message Then, display the answers available on the cheatsheet
	 * 
	 * @param command
	 *            The command to be processed.
	 *            
	 * @param gamer
	 *            The Student who want to use a tablet
	 */
	@Override
	public void wantSearch(Command command,Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(Game.res.getString("game.search"));
		} else if (command.getSecondWord().equals("printer")) {
			System.out.println(Game.res.getString("cheatsheet.description1"));
			System.out.println(Game.res.getString("cheatsheet.description2"));
			this.useCheatsheet(gamer);
		}

	}
}
