package zuul.person.objet;

/**
 * 
 * @author Cédric Lallemand
 *
 *@version 2015.01.20
 * 
 *          Class to create a Wallet
 */
public class Wallet {
	
	private int money;
	
	public Wallet(int money){
		this.money = money;
	}
	
	/**
	 * 
	 * @return the money in the "Wallet"
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * 
	 * Add a amount of cash in the "Wallet"
	 */
	public void raiseMoney(int x) {
		this.money = getMoney() + x;
	}

	/**
	 * 
	 * Decrease the amount of money available in the "Wallet"
	 */
	public boolean decreaseMoney(int x) {
		boolean transactionAccepted = true;
		if (this.getMoney() >= x) {
			this.money = getMoney() - x;
		}
		// TODO internationalisation
		else {
			transactionAccepted = false;
			System.out.println("Fond insuffisant !");
		}
		
		return transactionAccepted;
	}
}
