package zuul.person.objet;

/**
 * 
 * @author Oussama Hlal
 *
 */
public class Wallet {

	private int money;
	private boolean passExam;
	private int level;

	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 **/
	public Wallet() {
		level = 1;
		money = 10000;
		passExam = true;
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
		this.level = level;
		this.money = money;
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
		this.level = level;
		this.money = money;
		this.passExam = passExam;
	}

	/**
	 * 
	 * @return the money in the "Wallet"
	 */
	public int getMoney() {
		return money;
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
	public boolean isPassExam() {
		return passExam;
	}

	/**
	 * Modify the amount of cash in the "Wallet"
	 * 
	 * 
	 */
	public void setMoney(int x) {
		this.money = x;
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
	 * 
	 * Add a amount of cash in the "Wallet"
	 */
	public void raiseMoney(int x) {
		setMoney(getMoney() + x);
	}

	/**
	 * 
	 * Decrease the amount of money available in the "Wallet"
	 */
	public void decreaseMoney(int x) {
		if (getMoney() >= x) {
			setMoney(getMoney() + x);
		}
		// TODO internationalisation
		else {
			System.out.println("Fond insuffisant !");
		}
	}

	/**
	 * Modify the boolean passExam with true
	 */
	public void changePassExam() {
		if (passExam == false) {
			passExam = true;
		}
	}

}