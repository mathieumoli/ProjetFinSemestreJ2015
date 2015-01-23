package zuul.place;

import java.util.Random;

import zuul.Display;
import zuul.person.Student;

public class AliOffice extends Room {
	protected boolean lights;	
	
	public AliOffice(String description) {
		super(description);
		Random randomLight = new Random();
		randomLight.nextBoolean();
		lights = (randomLight.nextBoolean()) ? true : false;
	}

	@Override
	public boolean enter(Student student) {
		Display.displayln("aliOffice.bordel");
		return true;
	}

	@Override
	public boolean canEnter(Student student) {
		return true;
	}

}
