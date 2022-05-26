package Display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Main.PhysicsObject;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	PhysicsObject[] objects;
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(25, 25, 25));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Object drawing
		if (this.objects != null) {
			for (int i = 0; i < this.objects.length; i++) {
				PhysicsObject object = this.objects[i];
				g.setColor(object.color);
				g.fillOval((int) (object.x - (object.radius / 2)), (int) (object.y - (object.radius / 2)), (int) object.radius, (int) object.radius);
			}
		}
	}
	
	public void setObjects(PhysicsObject[] newObjects) {
		this.objects = newObjects;
	}
}
