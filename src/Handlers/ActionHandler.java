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
	private int greenPosition = 0;
	private int yellowPosition = 13;
	private int bluePosition = 26;
	private int redPosition = 39;
	private int whosTurn = 0;
	
	public ActionHandler(Control control) {
		
		this.c = control;
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
					
					if((greenPosition + diceRollValue) > 51) 
						greenPosition = diceRollValue + (greenPosition - 52);
					
					else 
						greenPosition = greenPosition + diceRollValue;
					
					Board.pieces[0][0].setCoordinates(casasCaminhaveis[greenPosition].getX(), casasCaminhaveis[greenPosition].getY());
					whosTurn++;
					Control.mouseClickInfo.setText("Vez do jogador amarelo jogar");
					break;
				
				//Vez do jogador amarelo
				case 1:
					if((yellowPosition + diceRollValue) > 51) 
						yellowPosition = diceRollValue + (yellowPosition - 52);
					
					else
						yellowPosition = yellowPosition + diceRollValue;
					
					Board.pieces[2][0].setCoordinates(casasCaminhaveis[yellowPosition].getX(), casasCaminhaveis[yellowPosition].getY());
					whosTurn++;
					Control.mouseClickInfo.setText("Vez do jogador azul jogar");
					break;
					
				//Vez do jogador azul
				case 2:
					if((bluePosition + diceRollValue) > 51)
						bluePosition = diceRollValue + (bluePosition - 52);
					
					else
						bluePosition = bluePosition + diceRollValue;
					
					Board.pieces[3][0].setCoordinates(casasCaminhaveis[bluePosition].getX(), casasCaminhaveis[bluePosition].getY());
					whosTurn++;
					Control.mouseClickInfo.setText("Vez do jogador vermelho jogar");
					break;
					
				//Vez do jogador vermelho
				case 3:
					
					if((redPosition + diceRollValue) > 51) 
						redPosition = diceRollValue + (redPosition - 52);
					
					else 
						redPosition = redPosition + diceRollValue;
					
					Board.pieces[1][0].setCoordinates(casasCaminhaveis[redPosition].getX(), casasCaminhaveis[redPosition].getY());
					whosTurn = 0;
					Control.mouseClickInfo.setText("Vez do jogador verde jogar");
					break;
				
			}
			
			Control.gameBoard.repaint();
		}
	}
}
