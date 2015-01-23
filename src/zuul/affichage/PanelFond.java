package zuul.affichage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * 
 * @author Mathieu Molinengo
 * @version 01.22.2015
 */
public class PanelFond extends JPanel {
	private Image image;
	/**
	 * Constructor to create the PanelFond
	 */
	public PanelFond(String plan) {
		super();
		image = Toolkit.getDefaultToolkit().getImage(plan);
		
	}
	/**
	 * paintComponent to show the picture
	 * @param
	 * 		the graphics where the picture is displayed
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);
		repaint();
	}

	/**
	 * To get the picture
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
