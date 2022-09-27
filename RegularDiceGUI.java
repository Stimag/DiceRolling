
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class RegularDiceGUI extends GUIComponents implements ActionListener {
	private final RegularDice d6 = new RegularDice("d6");
	
	public void addComponentsToPanel(Container diceRollPanel) {
		// Adding common components used in all GUIs
        addCommonComponentsToPanel(diceRollPanel);
        
        // Used for centering
        diceRollPanel.add(Box.createVerticalGlue());
    }
   
    
    @Override
    public void actionPerformed(ActionEvent event) {
    	// Perform action when dice roll button is clicked
    	if(event.getSource() == diceRollButton) {
    		diceRollText.setAlignmentX(Component.CENTER_ALIGNMENT);
    		int amountOfDices = (int) diceAmountMenu.getSelectedItem();
    		diceRollText.setText("Dice rolled " + d6.multipleDiceRolls(amountOfDices));
    	}
    }
 
    
    public void createAndShowGUI() {
        JFrame diceRollFrame = new JFrame("Dice Rolling");
        diceRollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentsToPanel(diceRollFrame.getContentPane());
 
        diceRollFrame.pack();
        diceRollFrame.setVisible(true);
    }
}