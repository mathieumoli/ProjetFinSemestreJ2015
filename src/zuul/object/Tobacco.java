package zuul.object;

import zuul.person.Student;

public class Tobacco extends PayingObject{
	
	public Tobacco(){
		super("tobacco",2);
	}
	
	@Override
	public void useObject(Student student) {
		student.decrementEnergy(20);
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}

}
