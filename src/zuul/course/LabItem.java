package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *         Class to create a LabItem
 */

public class LabItem extends Item {
	
	/***
	 * 
	 * Default constructor to create an LabItem without module, a default number and bundleKey
	 * 
	 ***/
	public LabItem(){
		super();
	}

	/***
	 * 
	 * Constructor to create an LabItem with module and a number
	 * @param module the name of the module 
	 * @param number the number of the module
	 * 	 
	 ***/
	public LabItem(String module, int number) {
		super(module, number);
	}
	
	/***
	 * 
	 *  Indicates whether some other object is "equal to" this one.
	 *  @param object the reference object with which to compare. 
	 *  @return true if this LabItem is the same as the object argument; false otherwise.
	 * 
	 ***/
	@Override
	public boolean equals(Object object) {
		boolean equality = false;
		if (object instanceof LabItem) {
			if (this.module.equals(((LabItem) object).getModule())) {

				if (this.number == ((LabItem) object).getNumber()) {
					equality=true;
				}
			}
		}
		return equality;
	}

}
