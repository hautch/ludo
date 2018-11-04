package Board;

import Board.Casas;
import Control.Control;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Board extends JPanel {
	
	public static Casas casas[][] = new Casas[15][15];
	private double xOrigin = 50;
	private double yOrigin = 50;
	private int diceRollVal;
	private String s = "#fcf9ea";
	private Color backgroundColor = Color.decode(s);
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(backgroundColor);
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < 15; i++) {
			
			for(int j = 0; j < 15; j++) {
				
				casas[i][j] = new Casas(i, j);
				float rectX = casas[i][j].getX();
				float rectY = casas[i][j].getY();
				
				Rectangle2D rect = new Rectangle2D.Double(rectX, rectY , 40, 40);

				if(rectX <= 200 && rectY <= 320) {
					
					if(rectY <= 200) {
						g2d.setPaint(Color.GREEN);
						g2d.fill(rect);
					}
					
					else {
						
						if(rectX == 40 && rectY == 240) {
							g2d.setPaint(Color.GREEN);
							g2d.fill(rect);
						}
						
						else if((rectX >= 40 && rectX <= 200) && rectY == 280) {
							g2d.setPaint(Color.GREEN);
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(Color.WHITE);
							g2d.fill(rect);
						}
					}
				}
				
				else if(rectX <= 320 && (rectY >= 360 && rectY <= 600)) {
					
					if(rectX <= 200) {
						g2d.setPaint(Color.RED);
						g2d.fill(rect);	
					}
					
					else {
						
						if(rectX == 240 && rectY == 520) {
							g2d.setPaint(Color.RED);
							g2d.fill(rect);
						}
						
						else if(rectY <= 520 && rectX == 280) {
							g2d.setPaint(Color.RED);
							g2d.fill(rect);
						}
						
						else {
							g2d.setPaint(Color.WHITE);
							g2d.fill(rect);
						}
					}
				}
				
				else if(rectX >= 200 && rectY <= 200) {
					
					if(rectX >= 360) {
						g2d.setPaint(Color.YELLOW);
						g2d.fill(rect);
					}
					
					else if(rectX == 320 && rectY == 40) {
						g2d.setPaint(Color.YELLOW);
						g2d.fill(rect);
					}
					
					else if(rectX == 280 && rectY >= 40) {
						g2d.setPaint(Color.YELLOW);
						g2d.fill(rect);
					}
					
					else {
						g2d.setPaint(Color.WHITE);
						g2d.fill(rect);
					}
				}
				
				else if(rectX >= 360 && rectY >= 240){
					
					if(rectY >= 360) {
						g2d.setPaint(Color.BLUE);
						g2d.fill(rect);
					}
					
					else if(rectX == 520 && rectY == 320) {
						g2d.setPaint(Color.BLUE);
						g2d.fill(rect);
					}
					
					else if(rectX <= 520 && rectY == 280) {
						g2d.setPaint(Color.BLUE);
						g2d.fill(rect);
					}
					
					else {
						g2d.setPaint(Color.WHITE);
						g2d.fill(rect);
					}
				}
				
				else {
					g2d.setPaint(Color.BLACK);
					g2d.fill(rect);
				}
				
			}
		}
	
	}
}
