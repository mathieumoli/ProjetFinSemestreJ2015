package zuul.foundobject;

import java.util.ArrayList;

import zuul.person.Person;

/**
 * 
 * @author Mathieu Molinengo
 *
 */
public class CarteMaraudeur {
	
	private ArrayList<Person> persons;
	private String password="je jure solennellement que mes intentions sont mauvaises ";
	
	/**
	 * 
	 * Constructor to create by default, the Maraudeur Map
	 * 
	 */
	public CarteMaraudeur(){
		persons=new ArrayList<Person>();
	}
}
