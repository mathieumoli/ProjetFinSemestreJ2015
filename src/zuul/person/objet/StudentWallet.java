package zuul.person.objet;

/**
 * 
 * @author Oussama Hlal & Cédric Lallemand
 *
 *@version 2015.01.20
 * 
 *          Class to create a StudentWallet
 */
public class StudentWallet extends Wallet{

	private boolean passExam;
	private int level;

	/**
	 * 
	 * Constructor to create a Wallet
	 * 
	 **/
	public StudentWallet() {
		super(1000);
		this.level = 1;
		this.passExam = true;
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
	public StudentWallet(int money, int level) {
		super(money);
		this.level = level;
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

	public StudentWallet(int money, int level, boolean passExam) {
		super(money);
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
	public boolean isPassExam() {
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
	public void changePassExam() {
		if (passExam == false) {
			passExam = true;
		}
	}

}