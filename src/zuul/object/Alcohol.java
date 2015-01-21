package zuul.object;

import zuul.person.Student;

public class Alcohol extends PayingObject {

	public Alcohol(){
		super("alcohol",3);
	}
	
	@Override
	public void useObject(Student student) {
		student.decrementEnergy(40);
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}
	
}
