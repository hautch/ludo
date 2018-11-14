package Control;
import Board.*;
import Handlers.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Control {
	
	public static JFrame frame = new JFrame("Super Ludo");
	public static Board gameBoard = new Board();
	public static JButton diceRoll = new JButton("Jogar dado");
	public static JLabel diceRollLabel;
	public static JLabel mouseClickInfo;
	public final int LARG_DEFAULT = 600;
	public final int ALT_DEFAULT = 670;
	public static float mouseX;
	public static float mouseY;
	
	public Control() {
		
		//Setting up game frame 
		frame.setSize(new Dimension(LARG_DEFAULT, ALT_DEFAULT));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		//Setting up components and event listeners
		diceRollLabel = new JLabel("Jogue o dado para começar");
		diceRollLabel.setOpaque(true);
		diceRollLabel.setBorder(new EmptyBorder(10, 5, 10, 5));
		diceRollLabel.setBackground(Color.WHITE);
		diceRollLabel.setForeground(Color.BLACK);
		mouseClickInfo = new JLabel("Ações do mouse serão exibidas aqui.");
		
		diceRoll.addActionListener(new ActionHandler(this));
		
		//Adding components to main container
		frame.add(gameBoard);
		gameBoard.add(diceRoll);
		gameBoard.add(diceRollLabel);
		gameBoard.add(mouseClickInfo);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		Control newGame = new Control();
		
	}

}
