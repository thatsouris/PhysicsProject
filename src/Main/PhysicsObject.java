package Main;

import java.awt.Color;
import java.util.ArrayList;

public class PhysicsObject {
	public double x = 0;
	public double y = 0;
	public double velX = 0;
	public double velY = 0;
	public double acelX = 0;
	public double acelY = 0;
	public double radius = 1;
	public Color color = new Color(255, 255, 255);
	public double mass = 1;
	
	PhysicsObject(double x, double y, double velX, double velY, double acelX, double acelY, double radius, Color color, double mass) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.acelX = acelX;
		this.acelY = acelY;
		this.radius = radius;
		this.mass = mass;
		
		this.color = color;
	}
	
	public double getDistance(PhysicsObject object) {
		return Math.sqrt(Math.pow(Math.abs(this.x - object.x), 2d) + Math.pow(Math.abs(this.x - object.x), 2d));
	}
	
	public void simulate(double dt) {
		this.x += this.velX * dt;
		this.y += this.velY * dt;
		this.velX += this.acelX * dt;
		this.velY += this.acelY * dt;
	}

	public void updateTrajectory(ArrayList<PhysicsObject> objects) { // If you'd like any explanation on how this words, ask me. :)
		double forceMagnitudeX = 0d;
		double forceMagnitudeY = 0d;
		
		this.acelX = 0;
		this.acelY = 0;
		
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) != this) {
				double distance = this.getDistance(objects.get(i));
				
				long F = (long) ((long) ((this.mass * objects.get(i).mass) / (distance)));	    
				double F2 = (F * (6.67427 * Math.pow(10, -10)));
				
				double xRatio = objects.get(i).x - this.x;
				double yRatio = objects.get(i).y - this.y;
				
				forceMagnitudeX = xRatio * F2;
				forceMagnitudeY = yRatio * F2;
				
				this.acelX += forceMagnitudeX / this.mass;
				this.acelY += forceMagnitudeY / this.mass;
			}
			
		}
	}
}
