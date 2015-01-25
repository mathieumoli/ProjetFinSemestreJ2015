package zuul.object;

import zuul.person.Student;

/**
 * An object allowing to steal a little more easily.
 * @author user
 *
 */
public class InvisibilityCloak extends ZuulObject {

	public InvisibilityCloak() {
	    super("cloak");
    }

	@Override
	public void useObject(Student student) {
		if(!student.isInvisible()){
			student.decrementEnergy(20);
		}
		student.changeVisibility();
	}


	
}
