package zuul.place;

import java.util.Random;

import zuul.Advertisement;
import zuul.person.Student;

/**
 * A room where you can check the board, typing "check board".
 * @author user
 *
 */
public class Foyer extends Room {
	protected boolean lights;
	protected Advertisement advertisement;

	public Foyer(String description) {
		super(description);
		advertisement = new Advertisement();
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}

	@Override
	public boolean enter(Student student) {
		annonce(); // TODO verifier secondWord "board".
		return true;
	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * A class printing an advertisement if the player chooses to check the board,
	 * by typing "check board".
	 */
	private void annonce() {
		System.out.println("Vous regardez sur le tableau.");    // TODO internationnalisation
		// une chance sur 2 qu'il y ait une annonce
	    Random rnd = new Random();
	    int intRandom = rnd.nextInt(10);
	    if (intRandom > 4) {
	    	System.out.println("Il n'y a pas d'annonce.");
	    } else {
	    	advertisement.displayNewAd();
	    }
	}
	
}
