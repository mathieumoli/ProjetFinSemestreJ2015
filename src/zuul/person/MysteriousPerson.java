package zuul.person;

import zuul.Display;
import zuul.commands.Command;
import zuul.person.object.Wallet;
/**
 * 
 * @author Mathieu Molinengo
 * 
 */
public class MysteriousPerson extends Person {
	private String bundleKey;

	/**
	 * Constructor to create a Mysterious Person
	 * @param name, the name of the Mysterious Person
	 * @param wallet, the wallet of the Mysterious Person
	 * @param key, the bundlekey of the clue of the Mysterious Person
	 */
	public MysteriousPerson(String name, Wallet wallet, String key) {
		super(name, wallet);
		bundleKey = key;
	}

	/**
	 * 
	 * Method to display a answer to the hello of the user
	 * 
	 * @param command
	 *            the command writted by the user
	 */
	@Override
	public void answerBack(Command command) {
		if (command.getSecondWord() != null
		        && command.getSecondWord().equals("hello")) {
			Display.display(this.getName());
			Display.displayln(bundleKey);
		} else {
			Display.display(this.getName());
			Display.displayln("person.notUnderstood");
		}
	}

}
