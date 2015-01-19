package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 2014.11.30
 * 
 *          Class to create an Item
 */
public class Item {
	protected String module;
	protected int number;
	protected String bundleKey;

	/***
	 * 
	 * Default constructor to create an Item without module, a default number
	 * and default bundleKey
	 * 
	 ***/
	public Item() {
		module = "default";
		number = 0;
		bundleKey = "room.nothing";
	}

	/***
	 * 
	 * Constructor to create an Item with module and a number but without
	 * bundleKey
	 * 
	 * @param themodule
	 *            the name of the module
	 * @param thenumber
	 *            the number of the module
	 * 
	 ***/
	public Item(String themodule, int thenumber) {
		module = themodule;
		number = thenumber;

	}

	/***
	 * 
	 * Constructor to create an Item with module, a number and bundleKey
	 * 
	 * @param themodule
	 *            the name of the module
	 * @param thenumber
	 *            the number of the module
	 * @param key
	 *            the bundle key of the module
	 ***/
	public Item(String themodule, int thenumber, String key) {
		module = themodule;
		number = thenumber;
		bundleKey = key;
	}

	/**
	 * 
	 * Method to get the module of the item
	 * 
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * 
	 * Method to get the number of the item
	 * 
	 * @return the number
	 * 
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 
	 * Method to get the number of the item in String format
	 * 
	 * @return the number in String format
	 * 
	 */
	public String getNumberString() {
		return Integer.toString(number);
	}

	/**
	 * 
	 * Method to get the bundleKey
	 * 
	 * @return the bundleKey
	 * 
	 */
	public String getBundleKey() {
		return bundleKey;
	}

	/**
	 * @param bundleKey
	 *            the bundleKey to set
	 */
	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}

}
