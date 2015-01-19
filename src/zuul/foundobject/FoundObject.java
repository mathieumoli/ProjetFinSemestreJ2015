package zuul.foundobject;

import zuul.person.Student;

/**
 * @author Lucas Martinez
 * @version 2014.11.30
 * 
 *          The FoundObject class is the abstract base class for all the found
 *          objects in the room
 */
public interface FoundObject {

	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the object
	 * 
	 ***/
	public abstract void useObject(Student student);

	/***
	 * 
	 * Add stuff to an object
	 * 
	 ***/
	public abstract void addStuff();
}
