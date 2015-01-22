package zuul.affichage;


import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author Mathieu Molinengo
 * @version 01.22.2015
 *
 */
public class Plan extends JFrame {
	
	/**
	 * Constructor to show the plan
	 */
	public Plan() {
		super("Plan");
		PanelFond g= new PanelFond();
		setContentPane(g);
		getContentPane().add(new JLabel("Plan"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}