package zuul.object;

import zuul.person.Student;

/**
 * @author Lucas Martinez
 * @version 2014.11.30
 * 
 *          The FoundObject class is the abstract base class for all the found
 *          objects in the room
 */
public abstract class ZuulObject {
	private String name;
	
	/**
	 * Constructor with name
	 */
	public ZuulObject(String name){
		this.name=name;
	}
	
	/***
	 * 
	 * Method to use the object
	 * 
	 * @param student
	 *            the student who use the object
	 * 
	 ***/
	public abstract void useObject(Student student);

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
