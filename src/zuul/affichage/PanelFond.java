package zuul.affichage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanelFond extends JPanel {
	private Image image;
	public PanelFond() {
		super();
		image = Toolkit.getDefaultToolkit().getImage("plan.jpg");
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);
		repaint();
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
