package zuul.object;

import zuul.Game;
import zuul.person.Student;

public class Cofee extends PayingObject {
	
	public Cofee(){
		super(1);
	}

	@Override
	public void useObject(Student student) {
		student.incrementEnergy(30);
		
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}
	
}