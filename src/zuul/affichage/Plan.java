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
	public Plan(String plan) {
		super("Plan");
		PanelFond g= new PanelFond(plan);
		setContentPane(g);
		getContentPane().add(new JLabel("Plan"));
		setSize(600, 750);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}