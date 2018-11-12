package Board;

import java.awt.Color;

public class Piece {

	//Coordinates detail where the piece is located on the game board
	public int xPos;
	public int yPos;
	public Color color;
	
	public Piece(int x, int y, Color c) {
		
		this.xPos = x;
		this.yPos = y;
		this.color = c;
	}
	
	public void setCoordinates(int x, int y) {
		
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getX() {
		
		return this.xPos;
	}
	
	public int getY() {
		
		return this.yPos;
	}
}
