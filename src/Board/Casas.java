package Board;

import java.awt.Color;

public class Casas {
	
	private boolean isOccupied;
	private int xPos;
	private int yPos;
	private Color cor;
	private int playerId;
	
	public Casas(int d, int e) {
		
		this.xPos = d * 40;
		this.yPos = e * 40;
		this.isOccupied = false;
	}
	
	public int getX() {
		
		return this.xPos;
	}
	
	public int getY() {
		
		return this.yPos;
	}
	
	public void setColor(Color c) {
		
		this.cor = c;
	}
	
	public Color getColor() {
		
		return this.cor;
	}
	
	public void setPlayerId(int id) {
		
		this.playerId = id;
	}
	
	public int getPlayerId() {
		
		return this.playerId;
	}
	
	public void setIsOccupied() {
		
		if(this.isOccupied)
			this.playerId = -1;
		
		this.isOccupied = !this.isOccupied;
	}
	public boolean getIsOccupied() {
		
		return this.isOccupied;
	}

}
