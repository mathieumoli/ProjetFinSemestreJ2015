package zuul.person.object;

/**
 * 
 * @author Oussama Hlal & Cédric Lallemand
 *
 *@version 2015.01.20
 * 
 *          Class to create a StudentWallet
 */
public class Wallet{

	private int money;
	private boolean passExam;
	private int level;

	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 **/
	public Wallet() {
		this.money= 1000;
		this.level = 1;
		this.passExam = false;
	}
	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 * @param integer
	 *            the amount of money in the Wallet
	 * 
	 **/
	public Wallet(int money) {
		this.money=money;
		this.level = 1;
		this.passExam=false;
	}

	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 * @param integer
	 *            the amount of money and the level, the grade of the owner of
	 *            the "Wallet"
	 * 
	 **/
	public Wallet(int money, int level) {
		this.money=money;
		this.level = level;
		this.passExam=false;
	}

	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 * @param integer
	 *            the amount of money and the grade of the owner of the
	 *            "Wallet" and a boolean to know if he can pass an exam
	 * 
	 **/

	public Wallet(int money, int level, boolean passExam) {
		this.money=money;
		this.level = level;
		this.passExam = passExam;
	}

	/**
	 * 
	 * @return the level of the owner of the "Wallet"
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * 
	 * @return if the person can pass the exam or not
	 */
	public boolean canPassExam() {
		return passExam;
	}

	/**
	 * 
	 * @return increase the level of the student
	 */
	public void raiseLevel() {
		if (getLevel() < 3) {
			this.level = getLevel() + 1;
		} else {
			// TODO internationalisation
			System.out.println("Niveau max atteint ! ");
		}
	}

	/**
	 * Modify the boolean passExam with true
	 */
	public void canNowPassExam() {
		passExam = true;
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
	
	/**
	 * 
	 * Call when the wallet is stolen, all the money is lost.
	 * @return
	 */
	public int stolen(){
		int stolen = this.getMoney();
		this.decreaseMoney(stolen);
		return stolen;
	}
}