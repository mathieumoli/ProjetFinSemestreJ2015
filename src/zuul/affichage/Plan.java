package zuul.affichage;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Plan extends JFrame {

	public Plan() {
		super("Plan");
		PanelFond g= new PanelFond();
		setContentPane(g);
		getContentPane().add(new JLabel("Bonjour"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}