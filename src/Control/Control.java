package Control;
import Board.*;
import Handler.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Control {
	
	public static JFrame frame = new JFrame("Super Ludo");
	public Board gameBoard = new Board();
	public static JButton diceRoll = new JButton("Jogar dado");
	public static JLabel diceRollLabel;
	public final int LARG_DEFAULT = 900;
	public final int ALT_DEFAULT = 720;
	
	public Control() {
		
		//Setting up game frame 
		frame.setSize(new Dimension(LARG_DEFAULT, ALT_DEFAULT));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//Setting up components
		diceRollLabel = new JLabel("Jogue o dado para começar");
		diceRollLabel.setOpaque(true);
		diceRollLabel.setBorder(new EmptyBorder(10, 5, 10, 5));
		diceRollLabel.setBackground(Color.WHITE);
		diceRollLabel.setForeground(Color.BLACK);
		
		diceRoll.addActionListener(new Handler(this));
		
		//Adding components to main container
		gameBoard.add(diceRoll);
		gameBoard.add(diceRollLabel);
		frame.add(gameBoard);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		Control newGame = new Control();
		
	}
}
