package zuul.person;

import zuul.Display;
import zuul.person.object.Wallet;

public class MysteriousPerson extends Person{
	private String bundleKey;

	public MysteriousPerson(String name, Wallet wallet, String key) {
	    super(name, wallet);
	    bundleKey=key;
	   
    }
	
	public void answerBack(){
		Display.display(this.getName());
		Display.displayln("bundleKey");
	}

}
