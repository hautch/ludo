package Handler;

import Control.Control;
import java.awt.event.*;
import java.util.Random;

public class Handler implements ActionListener{
	
	Control c;
	public int diceRollValue;
	
	public Handler(Control control) {
		
		this.c = control;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Handles diceRoll click
		if(e.getSource() == Control.diceRoll) {
			Random rand = new Random();
			diceRollValue = rand.nextInt(6) + 1;
			Control.diceRollLabel.setText("Você jogou: " + diceRollValue);
			
		}
	}
}
