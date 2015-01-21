package zuul.object;

import zuul.person.Student;

public class InvisibilityCloak extends ZuulObject {

	public InvisibilityCloak(String name) {
	    super(name);
    }


	@Override
	public void useObject(Student student) {
		if(!student.isInvisible()){
			student.decrementEnergy(10);
		}
		student.changeVisibility();
	}


	
}
