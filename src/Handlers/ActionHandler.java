package Handlers;

import Board.*;
import Control.Control;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class ActionHandler implements ActionListener{
	
	Control c;
	private Board b = new Board();
	public int diceRollValue = 0;
	public boolean diceWasRolled = false;
	private Casas[] casasCaminhaveis = Board.casasCaminhaveis;
	private int[] positions = {1, 14, 27, 40};
	private int[] piecesOnBoard = {1, 1, 1, 1};
//	private int positions[0] = 1;
//	private int positions[1] = 14;
//	private int positions[2] = 27;
//	private int positions[3] = 40;
	private int whosTurn = 0;
	
	public ActionHandler(Control control) {
		
		this.c = control;
	}

	public void handleFive(int player) {
		
		Control.diceRollLabel.setText("Você jogou o 5");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Handles diceRoll click
		if(e.getSource() == Control.diceRoll) {
			
			Random rand = new Random();
			diceRollValue = rand.nextInt(6) + 1;
			Control.diceRollLabel.setText("Você jogou: " + diceRollValue);
			
			switch(whosTurn) {
			
				//Vez do jogador verde
				case 0:
					
					if(diceRollValue == 5) {
						this.handleFive(0);
						whosTurn++;
						Control.mouseClickInfo.setText("Vez do jogador amarelo jogar");
						break;
					}
					
					else {
						casasCaminhaveis[positions[0]].setIsOccupied();
						
						if((positions[0] + diceRollValue) > 51) 
							positions[0] = diceRollValue + (positions[0] - 52);
						
						else 
							positions[0] = positions[0] + diceRollValue;
						
						if(casasCaminhaveis[positions[0]].getIsOccupied() && (casasCaminhaveis[positions[0]].getPlayerId() != 3)) {
							System.out.println("Casa ocupada");
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador amarelo jogar");
							break;
						}
						
						else {
							casasCaminhaveis[positions[0]].setIsOccupied();
							casasCaminhaveis[positions[0]].setPlayerId(0);
							Board.pieces[0][0].setCoordinates(casasCaminhaveis[positions[0]].getX(), casasCaminhaveis[positions[0]].getY());
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador amarelo jogar");
							break;
						}
					}
				
				//Vez do jogador amarelo
				case 1:
					
					if(diceRollValue == 5) {
						this.handleFive(1);
						whosTurn++;
						Control.mouseClickInfo.setText("Vez do jogador azul jogar");
						break;
					}
					
					else {
						casasCaminhaveis[positions[1]].setIsOccupied();
						
						if((positions[1] + diceRollValue) > 51) 
							positions[1] = diceRollValue + (positions[1] - 52);
						
						else
							positions[1] = positions[1] + diceRollValue;
						
						if(casasCaminhaveis[positions[1]].getIsOccupied() && (casasCaminhaveis[positions[1]].getPlayerId() != 3)) {
							System.out.println("Casa ocupada");
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador azul jogar");
							break;
						}
						
						else {
							casasCaminhaveis[positions[1]].setIsOccupied();
							casasCaminhaveis[positions[1]].setPlayerId(0);
							Board.pieces[1][0].setCoordinates(casasCaminhaveis[positions[1]].getX(), casasCaminhaveis[positions[1]].getY());
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador azul jogar");
							break;
						}
					}
					
				//Vez do jogador azul
				case 2:
					
					if(diceRollValue == 5) {
						this.handleFive(2);
						whosTurn++;
						Control.mouseClickInfo.setText("Vez do jogador vermelho jogar");
						break;
					}
					
					else {
						casasCaminhaveis[positions[2]].setIsOccupied();
						
						if((positions[2] + diceRollValue) > 51)
							positions[2] = diceRollValue + (positions[2] - 52);
						
						else
							positions[2] = positions[2] + diceRollValue;
						
						if(casasCaminhaveis[positions[2]].getIsOccupied() && (casasCaminhaveis[positions[2]].getPlayerId() != 3)) {
							System.out.println("Casa ocupada");
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador vermelho jogar");
							break;
						}
						
						else {
							casasCaminhaveis[positions[2]].setIsOccupied();
							casasCaminhaveis[positions[2]].setPlayerId(0);
							Board.pieces[2][0].setCoordinates(casasCaminhaveis[positions[2]].getX(), casasCaminhaveis[positions[2]].getY());
							whosTurn++;
							Control.mouseClickInfo.setText("Vez do jogador vermelho jogar");
							break;
						}
					}
					
				//Vez do jogador vermelho
				case 3:
					
					if(diceRollValue == 5) {
						this.handleFive(3);
						whosTurn = 0;
						Control.mouseClickInfo.setText("Vez do jogador verde jogar");
						break;
					}
					
					else {
						casasCaminhaveis[positions[3]].setIsOccupied();
						
						if((positions[3] + diceRollValue) > 51) 
							positions[3] = diceRollValue + (positions[3] - 52);
						
						else 
							positions[3] = positions[3] + diceRollValue;
						
						if(casasCaminhaveis[positions[3]].getIsOccupied() && (casasCaminhaveis[positions[3]].getPlayerId() != 3)) {
							System.out.println("Casa ocupada");
							whosTurn = 0;
							Control.mouseClickInfo.setText("Vez do jogador verde jogar");
							break;
						}
						
						else {
							casasCaminhaveis[positions[3]].setIsOccupied();
							casasCaminhaveis[positions[3]].setPlayerId(0);
							Board.pieces[3][0].setCoordinates(casasCaminhaveis[positions[3]].getX(), casasCaminhaveis[positions[3]].getY());
							whosTurn = 0;
							Control.mouseClickInfo.setText("Vez do jogador verde jogar");
							break;
						}
					
					}
				
			}
			
			Control.gameBoard.repaint();
		}
	}
}
