package zuul.foundobject;

import zuul.person.Student;

public class invisibilityCloak extends FoundObject {

	@Override
	public void useObject(Student student) {
		if(!student.isInvisible()){
			student.decrementEnergy(10);
		}
		student.changeVisibility();
	}

	
	public void addStuff() {
		//Nothings to do
		
	}

	
}
