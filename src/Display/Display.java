package Display;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Main.PhysicsObject;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Panel panel;
	
	public Display(int width, int height) {
		super("Physics Project");
		
		panel = new Panel();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setPreferredSize(new Dimension(width, height));
		this.setSize(new Dimension(width, height));

		Image icon = new ImageIcon(this.getClass().getResource("logotrans.png")).getImage();
		this.setIconImage(icon);
	}
	
	public void submitObjects(PhysicsObject[] objects) {
		panel.setObjects(objects);
		panel.repaint();
	}
}
