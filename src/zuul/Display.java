package zuul;


/**
 * A class used to interact with the player.
 * 
 * Replaces all "System.out.println".
 * 
 * @author Lisa Joanno
 *
 */
public class Display {
	/**
	 * Main use of this class. Is linked to ResourceBundle :
	 * checks if the key exists, if it doesn't, prints the key.
	 * 
	 * If the String to print is an error, you must not use this method.
	 * @param sentence
	 */
    public static void display(String key) {
    	if (Game.res.containsKey(key)) {// check if the key exists in the resource bundle
    	    System.out.print(Game.res.getString(key));
    	} else { // it doesn't exist
    	    System.out.print(key);
        }
    }
    
    /**
	 * Main use of this class. Is linked to ResourceBundle :
	 * checks if the key exists, if it doesn't, prints the key and back to the line.
	 * 
	 * If the String to print is an error, you must not use this method.
	 * @param sentence
	 */
    public static void displayln(String key) {
    	if (Game.res.containsKey(key)) {// check if the key exists in the resource bundle
    	    System.out.println(Game.res.getString(key));
    	} else { // is doesn't exist
    	    System.out.println(key);
        }
    }
    
    /**
     * This method does the same thing as the one above, but
     * this one is for errors.
     * @param key
     */
    public static void displayError(String key) {
    	if (Game.res.containsKey(key)) {// check if the key exists in the resource bundle
    	    System.err.println(Game.res.getString(key));
    	} else { // is doesn't exist
    	    System.err.println(key);
        }   	
    }
}
