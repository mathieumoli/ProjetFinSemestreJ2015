package zuul.object;

import zuul.person.Student;

public class InvisibilityCloak extends ZuulObject {

	public InvisibilityCloak() {
	    super("cloak");
    }


	@Override
	public void useObject(Student student) {
		if(!student.isInvisible()){
			student.decrementEnergy(10);
		}
		student.changeVisibility();
	}


	
}
