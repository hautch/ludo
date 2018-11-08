package Board;

import Board.Casas;
import Control.Control;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Board extends JPanel {
	
	public static Casas casas[][] = new Casas[15][15];
	//Moves the board down by 50 pxls
	private int yOrigin = 50;
	private int diceRollVal;
	private String s = "#fcf9ea";
	private Color backgroundColor = Color.decode(s);
	
	//Constructor sets each board piece with the appropriate color and coordinates
	public Board() {
		
		for (int i = 0; i < 15; i++) {
			
			for(int j = 0; j < 15; j++) {
				
				casas[i][j] = new Casas(i, j);
				float rectX = casas[i][j].getX();
				float rectY = casas[i][j].getY();
				
				if(rectX <= 200 && rectY <= 320) {

					//Sets main green area
					if(rectY <= 200) {
						casas[i][j].setColor(Color.GREEN);
					}
					
					//Sets green path
					else {
												
						if(rectX == 40 && rectY == 240) {
							casas[i][j].setColor(Color.GREEN);
						}
						
						else if((rectX >= 40 && rectX <= 200) && rectY == 280) {
							casas[i][j].setColor(Color.GREEN);
						}
						
						else {
							
							casas[i][j].setColor(Color.WHITE);
						}
					}
				}
				
				else if(rectX <= 320 && (rectY >= 360 && rectY <= 600)) {

					//Sets main red area
					if(rectX <= 200) {
						casas[i][j].setColor(Color.RED);
					}
					
					//Sets red path
					else {
						
						if(rectX == 240 && rectY == 520) {
							casas[i][j].setColor(Color.RED);
						}
						
						else if(rectY <= 520 && rectX == 280) {
							casas[i][j].setColor(Color.RED);
						}
						
						else {
							casas[i][j].setColor(Color.WHITE);
						}
					}
				}
				
				else if(rectX >= 200 && rectY <= 200) {
					
					//Sets main yellow area
					if(rectX >= 360) {
						casas[i][j].setColor(Color.YELLOW);
					}
					
					//Sets yellow path
					else {
						if(rectX == 320 && rectY == 40) {
							casas[i][j].setColor(Color.YELLOW);
						}
						
						else if(rectX == 280 && rectY >= 40) {
							casas[i][j].setColor(Color.YELLOW);
						}
						
						else {
							casas[i][j].setColor(Color.WHITE);
						}
					}
				}
				
				else if(rectX >= 360 && rectY >= 240){
					
					//Sets main blue area
					if(rectY >= 360) {
						casas[i][j].setColor(Color.BLUE);
					}
					
					//Sets blue path
					else {
						if(rectX == 520 && rectY == 320) {
							casas[i][j].setColor(Color.BLUE);
						}
						
						else if(rectX <= 520 && rectY == 280) {
							casas[i][j].setColor(Color.BLUE);
						}
						
						else {
							casas[i][j].setColor(Color.WHITE);
						}
					}
				}
				
				//Sets central area
				else {
					casas[i][j].setColor(Color.BLACK);
				}
			}
			
		}
	}
	
	//The paint method creates the board and repaints it upon game updates
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(backgroundColor);
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < 15; i++) {
			
			for(int j = 0; j < 15; j++) {
				
				float rectX = casas[i][j].getX();
				float rectY = casas[i][j].getY();
				
				Rectangle2D rect = new Rectangle2D.Double(rectX, rectY + this.yOrigin, 40, 40);

				if(rectX <= 200 && rectY <= 320) {

					//Paints main green area
					if(rectY <= 200) {
						g2d.setPaint(casas[i][j].getColor());
						g2d.fill(rect);
					}
					
					//Paints green path
					else {
												
						if(rectX == 40 && rectY == 240) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else if((rectX >= 40 && rectX <= 200) && rectY == 280) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
					}
				}
				
				
				else if(rectX <= 320 && (rectY >= 360 && rectY <= 600)) {

					//Paints main red area
					if(rectX <= 200) {
						g2d.setPaint(casas[i][j].getColor());
						g2d.fill(rect);	
					}
					
					//Paints red path
					else {
						
						if(rectX == 240 && rectY == 520) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else if(rectY <= 520 && rectX == 280) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
					}
				}
				
				else if(rectX >= 200 && rectY <= 200) {

					//Paints main yellow area
					if(rectX >= 360) {
						g2d.setPaint(casas[i][j].getColor());
						g2d.fill(rect);
					}
					
					//Paints yellow path
					else {
						if(rectX == 320 && rectY == 40) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else if(rectX == 280 && rectY >= 40) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
					}
				}
				
				else if(rectX >= 360 && rectY >= 240){

					//Paints main blue area
					if(rectY >= 360) {
						g2d.setPaint(casas[i][j].getColor());
						g2d.fill(rect);
					}
					
					//Paints blue path
					else {
						if(rectX == 520 && rectY == 320) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else if(rectX <= 520 && rectY == 280) {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(casas[i][j].getColor());
							g2d.fill(rect);
						}
					}
				}
				
				//Paints central area
				else {
					g2d.setPaint(casas[i][j].getColor());
					g2d.fill(rect);
				}
				
			}
		}
	
	}
}
