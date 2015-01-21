package zuul.object;

import zuul.person.Student;

public class Lunch extends PayingObject {
	
	public Lunch(){
		super(4);
	}
	
	@Override
	public void useObject(Student student) {
		student.incrementEnergy(70);
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}
	

}
