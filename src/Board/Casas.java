package Board;

import java.awt.Color;

public class Casas {
	
	private boolean isOccupied = false;
	private float xPos;
	private float yPos;
	
	public Casas(int x, int y) {
		
		this.xPos = x * 40;
		this.yPos = y * 40;
	}
	
	public float getX() {
		
		return this.xPos;
	}
	
	public float getY() {
		
		return this.yPos;
	}

}
