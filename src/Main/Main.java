package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Timer;

public class Main implements ActionListener {
	Timer timer;
	ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();
	
	final int FPS = 60;
	long lastTime = new Date().getTime();
	double dt = 0d;
	long thisTime = lastTime;
	Display.Display disp;
	
	Main() {
		disp = new Display.Display(1250, 750);
		
		objects.add(new PhysicsObject(250, 250, 0, 0, 0, 0, 10, new Color(255, 255, 0), Math.pow(10, 11)));
		objects.add(new PhysicsObject(250, 50, 50, 0, 0, 0, 5, new Color(255, 211, 0), Math.pow(10, 10)));
		objects.add(new PhysicsObject(300, 80, 50, 0, 0, 0, 5, new Color(255, 211, 0), Math.pow(10, 10)));
		objects.add(new PhysicsObject(400, 70, 50, 0, 0, 0, 5, new Color(255, 211, 0), Math.pow(10, 10)));
		
		// Simulating physics
		
		Timer timer = new Timer(1/FPS, this);
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.thisTime = new Date().getTime();
		this.dt = (thisTime - lastTime) / 1000d;
		this.lastTime = this.thisTime;
		
		PhysicsObject[] toSubmit = new PhysicsObject[objects.size()];
		
		for (int i = 0; i < objects.size(); i += 1) {
			this.objects.get(i).updateTrajectory(this.objects);
			this.objects.get(i).simulate(dt);
			
			toSubmit[i] = this.objects.get(i);
		}
		
		disp.panel.setObjects(toSubmit);
		
		disp.panel.repaint();
	}
}
