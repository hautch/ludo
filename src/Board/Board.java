package Board;

import Board.Casas;
import Board.Piece;
import Control.Control;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Board extends JPanel {
	
	public static Piece pieces[][] = new Piece[4][4];
	public static Casas casas[][] = new Casas[15][15];
	//Moves the board down by 50 pxls
	private int yOrigin = 50;
	private int diceRollVal;
	private String s = "#fcf9ea";
	private Color backgroundColor = Color.decode(s);
	
	//Constructor sets each board piece and spot with the appropriate color and coordinates
	public Board() {
		
		//Game pieces setup
		
		for(int k = 0; k < 4; k++) {
			
			switch(k) {
			
			case(0):
				pieces[0][0] = new Piece(40, 40, Color.GREEN);
				pieces[0][1] = new Piece(40, 160, Color.GREEN);
				pieces[0][2] = new Piece(160, 40, Color.GREEN);
				pieces[0][3] = new Piece(160, 160, Color.GREEN);
			
			case(1):
				pieces[1][0] = new Piece(40, 400, Color.RED);
				pieces[1][1] = new Piece(40, 520, Color.RED);
				pieces[1][2] = new Piece(160, 400, Color.RED);
				pieces[1][3] = new Piece(160, 520, Color.RED);
				
			case(2):
				pieces[2][0] = new Piece(400, 40, Color.YELLOW);
				pieces[2][1] = new Piece(520, 40, Color.YELLOW);
				pieces[2][2] = new Piece(400, 160, Color.YELLOW);
				pieces[2][3] = new Piece(520, 160, Color.YELLOW);
	
			case(3):
				pieces[3][0] = new Piece(400, 400, Color.GREEN);
				pieces[3][1] = new Piece(520, 400, Color.GREEN);
				pieces[3][2] = new Piece(400, 520, Color.GREEN);
				pieces[3][3] = new Piece(520, 520, Color.GREEN);
				
			}
				
		}
			
		//Board setup
		for (int i = 0; i < 15; i++) {
			
			for(int j = 0; j < 15; j++) {
				
				casas[i][j] = new Casas(i, j);
				float rectX = casas[i][j].getX();
				float rectY = casas[i][j].getY();
				
				if(rectX <= 200 && rectY <= 320) {

					//Sets main green area
					if(rectY <= 200) {
						
						if(rectX == 40 || rectX == 160) {
							if(rectY == 40 || rectY == 160) {
								casas[i][j].setColor(Color.WHITE);
							}
							
							else {
								casas[i][j].setColor(Color.GREEN);
							}
						}
						
						else {
							casas[i][j].setColor(Color.GREEN);
						}
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
						
						if(rectX == 40 || rectX == 160) {
							
							if(rectY == 400 || rectY == 520) {
								
								casas[i][j].setColor(Color.WHITE);
							}
							
							else
								casas[i][j].setColor(Color.RED);
						}
						
						else
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
				
				else if(rectX >= 240 && rectY <= 200) {
					
					//Sets main yellow area
					if(rectX >= 360) {
						
						if(rectX == 400 || rectX == 520) {
							
							if(rectY == 40 || rectY == 160) {
								casas[i][j].setColor(Color.WHITE);
							}
							
							else
								casas[i][j].setColor(Color.YELLOW);
						}
						
						else
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
						
						if(rectX == 400 || rectX == 520) {
							
							if(rectY == 400 || rectY == 520) {
								casas[i][j].setColor(Color.WHITE);
							}
							
							else
								casas[i][j].setColor(Color.BLUE);
							
						}
						else 
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
				
				int rectX = casas[i][j].getX();
				int rectY = casas[i][j].getY();
				
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
		
		for(int i = 0; i < 4; i++) {
			
			String imgPath = null;
			
			if(i==0)
				imgPath = "/Users/rlveiga/eclipse-workspace/SuperLudo/assets/images/green-piece.png";
			
			else if(i==1)
				imgPath = "/Users/rlveiga/eclipse-workspace/SuperLudo/assets/images/red-piece.png";
			
			else if(i==2)
				imgPath = "/Users/rlveiga/eclipse-workspace/SuperLudo/assets/images/yellow-piece.png";
			
			else if(i==3)
				imgPath = "/Users/rlveiga/eclipse-workspace/SuperLudo/assets/images/blue-piece.png";
			
			System.out.println(imgPath);
			
			BufferedImage Piece1 = null;
			try {
				Piece1 = ImageIO.read(new File(imgPath));
			}
			catch(IOException e) {}
			g2d.drawImage(Piece1, pieces[i][0].getX(), pieces[i][0].getY() + this.yOrigin, 40, 40, null);
			
			BufferedImage Piece2 = null;
			try {
				Piece2 = ImageIO.read(new File(imgPath));
			}
			catch(IOException e) {}
			g2d.drawImage(Piece2, pieces[i][1].getX(), pieces[i][1].getY() + this.yOrigin, 40, 40, null);
			
			BufferedImage Piece3 = null;
			try {
				Piece3 = ImageIO.read(new File(imgPath));
			}
			catch(IOException e) {}
			g2d.drawImage(Piece3, pieces[i][2].getX(), pieces[i][2].getY() + this.yOrigin, 40, 40, null);
			
			BufferedImage Piece4 = null;
			try {
				Piece4 = ImageIO.read(new File(imgPath));
			}
			catch(IOException e) {}
			g2d.drawImage(Piece4, pieces[i][3].getX(), pieces[i][3].getY() + this.yOrigin, 40, 40, null);
			
		}
	
	}
}
