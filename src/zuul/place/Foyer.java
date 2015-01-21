package zuul.place;

import java.util.Random;
import zuul.foundobject.Advertisement;
import zuul.person.Student;

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
		annonce();
		return true;
	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

	/**
	 * A class printing an advertisement if the player chooses to look at the board,
	 * by typing "see board".
	 */
	private void annonce() {
		System.out.println("Vous regardez sur le tableau.");
        // ici déjà on va voir si il y a une annonce, une chance sur 2
	    Random rnd = new Random();
	    int intRandom = rnd.nextInt(10);
	    if (intRandom > 4) {
	    	System.out.println("Il n'y a pas d'annonce.");
	    } else {
	    	advertisement.displayNewAd();
	    }
	    
	}
	
}
