package zuul;


/**
 * A class used to interact with the player.
 * 
 * Replaces all "System.out.println".
 * @author user
 *
 */
public class Display {
	/**
	 * Main use of this class. Is linked to ResourceBundle :
	 * checks if the key exists, if it doesn't, prints the key.
	 * @param sentence
	 */
    public void display(String key) {
    	//if () {// check if the key exists in the resource bundle
    	    System.out.println(key);
    	//} else {
    	    System.out.println(key);
        //}
    }
    
    public void displayError(String key) {
    	
    }
}
