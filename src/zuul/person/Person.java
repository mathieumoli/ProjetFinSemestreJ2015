package zuul.person;

/**
 * @author Cédric Lallemand
 * @version 2015.01.20
 * 
 *          Class to create a Person
 */
public class Person {

	private String name;
	
	/***
	 * 
	 * Constructor to create a Person
	 * 
	 * @param name - the name of created person     
	 * 
	 ***/
	public Person(String name){
		this.name = name;
	}

	/***
	 * 
	 * Method to get the name of the person
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

}
