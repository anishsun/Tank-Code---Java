package War;

import Zen.*;

public class Game extends ZenGame {

	
	public static void main(String[] args) {
		Zen.connect("zenlab");
		Game g = new Game();
		g.setSize(1500, 1000);
		g.run();
	}

	@Override
	public void setup() {
		setupPlayer("anish");
		setupPlayer("rahul");
		setupPlayer("rhea");
		setupPlayer("keshav");
		setupPlayer("nathan");
		setupPlayer("pranav");
		setupPlayer("sahil");
		setupPlayer("rohan");
		
		
		Zen.write("anishx", 400);
		Zen.write("anishy", 400);
		Zen.write("anishhealth", 100);
		Zen.write("anishlaser", false);
		Zen.write("anishhorizontal", true);
	}

	private void setupPlayer(String playerName) {
		Tank test;
		test = new Tank();
		test.name = playerName;
		addSprite(test);
	}

	@Override
	public void loop() {
		drawBackground();
		checkKeys();
		sendMyPosition();
		checkIfHit();
		
	}

	private void sendMyPosition() {
		
		
	}

	private void checkIfHit() {
		
		
	}

	private void drawBackground() {
		Zen.setBackground("light blue");
		
	}

	private void checkKeys() {
		int x = Zen.readInt("anishx");
		int y = Zen.readInt("anishy");
		
		if (Zen.isKeyPressed("left")) {
			Zen.write("anishhorizontal", true);
			x = x - 10;
		}
		if (Zen.isKeyPressed("right")) {
			Zen.write("anishhorizontal", true);
			x = x + 10;
		}
		if (Zen.isKeyPressed("up")) {
			Zen.write("anishhorizontal", false);
			y = y - 10;
		}	
		if (Zen.isKeyPressed("down")) {
			Zen.write("anishhorizontal", false);
			y = y + 10;
		}
		
		if (Zen.isKeyPressed("space")) {
			Zen.write("anishlaser", true);
		}
		else {
			Zen.write("anishlaser", false);
		}
			
		Zen.write("anishx", x);
		Zen.write("anishy", y);
		
		Line reference = new Line(x, y, Zen.getMouseX(), Zen.getMouseY());
		Zen.write("anishangle", reference.angle());
	}
	
}	
	



