package War;

import Zen.*;

public class Tank extends ZenSprite {
	String name;
	int health = 100;
	double angle = 0;
	boolean laserFired = false;
	boolean horizontal = true;
	
	@Override
public void draw() {
		drawTank();
		if (laserFired) {
			drawLaser();
		}
		drawName();
		if ( health < 1 ) {
			drawExplosion();
		}
	}
	
	private void drawExplosion() {
		Zen.setColor("yellow");
		
	}

	private void drawName() {
		Zen.setColor("black");
		Zen.drawText(name, getX() - 15, getY() - 15);
	}


	private void drawLaser() {
		Zen.setColor("red");
		Zen.drawLine(getX(), getY(), getX() + 2000, getY());
		
	}
	
	
	private void drawTank() {
		if (horizontal) {
			Zen.setColor("black");
			Zen.fillRect(getX() - 20, getY() - 10, 40, 20);
			Zen.setColor("green");
			Zen.fillRect(getX() - 25, getY() - 15, 50, 5);
			Zen.fillRect(getX() + 25, getY() + 10, 50, 5);
			Zen.setColor("dark gray");
			Zen.fillOval(getX() - 8, getY() - 8, 16, 16);
		}
		else {
			Zen.setColor("black");
			Zen.fillRect(getX() - 10, getY() - 20, 20, 40);
			Zen.setColor("green");
			Zen.fillRect(getX() - 25, getY() - 15, 50, 5);
			Zen.fillRect(getX() + 25, getY() + 10, 50, 5);
			Zen.setColor("dark gray");
			Zen.fillOval(getX() - 8, getY() - 8, 16, 16);
		}
		
		Line turret = new Line(getX(), getY(), getX() + 30, getY(), 6);
		turret.rotateTo( Math.toDegrees(angle) );
		Zen.setColor("dark gray");
		Zen.draw(turret);
	}


	@Override
	public void move() {
		setX( Zen.readInt(name + "x"));
		setY( Zen.readInt(name + "y"));
		
		laserFired = Zen.readBoolean(name + "laser");
		angle = Zen.readDouble(name + "angle");
		horizontal = Zen.readBoolean(name + "health");
		health = Zen.readInt(name + "health");
			
	}
	
}
