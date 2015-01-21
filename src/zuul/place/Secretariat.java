package zuul.place;

import java.util.Random;

import zuul.person.Student;

public class Secretariat extends Room {
    private boolean lights;
    
	public Secretariat(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}

	@Override
	public boolean enter(Student student) {
		// TODO internationnalisation
		System.out.println("Vous �tes au secretariat. Les gens ici font comme si ils ne vous voyaient pas. Vous devriez partir.");
		return true;
	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

}