package Handlers;

import Control.Control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Board.*;

public class MouseHandler implements MouseListener{
	
	private Board b = new Board();
	private Casas[][] casas = Board.casas;
	private Casas[] casasCaminhaveis = Board.casasCaminhaveis;
	private int x;
	private int y;
	private int indexCasaSelecionadaX;
	private int indexCasaSelecionadaY;
	private int casaSelecionada;
	private int passos = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		this.x = e.getX();
		this.y = e.getY() - 50;
		this.indexCasaSelecionadaX = (int)this.x / 40;
		this.indexCasaSelecionadaY = (int)this.y / 40;
		Control.mouseClickInfo.setText("Clicou na casa " + "[" + this.indexCasaSelecionadaX + "]" + "[" + this.indexCasaSelecionadaY + "]");
		Board.pieces[0][0].setCoordinates(casasCaminhaveis[passos].getX(), casasCaminhaveis[passos].getY());
		Control.gameBoard.repaint();
		
		if(passos == 51)
			passos = 0;
		
		else
			passos++;*/
		/*this.casaSelecionada = (((int) this.y / 40) * 10) + ((int) this.x / 40);
		casa = Board.casas[11][11];
		if(casa.getColor() == Color.GREEN)
			Control.mouseClickInfo.setText("Clicou verde");
		else
			Control.mouseClickInfo.setText("Nao clicou verde");*/
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
