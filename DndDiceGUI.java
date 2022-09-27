
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
 
public class DndDiceGUI extends GUIComponents implements ActionListener  {
	private final String[] diceTypeArray = {"d4", "d6", "d8", "d10", "d12", "d20", "d100"};
	private final Integer[] modifiersArray = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	private final String[] advantageArray = {"Advantage", "None", "Disadvantage"};
	private JComboBox<String> diceTypeMenu;
	private JComboBox<Integer> modifierMenu;
	private JComboBox<String> advantageAndDisadvantageMenu;
	
	
    public void addComponentsToPanel(Container diceRollPanel) {
        // Adding dropdown menu for dice types
    	addTextLabel(" ", diceRollPanel);
        addTextLabel("Dice type", diceRollPanel);
        addDiceTypeMenu(diceTypeArray, diceRollPanel);
        
        // Adding dropdown menu for modifier
        addTextLabel(" ", diceRollPanel);
        addTextLabel("Modifier", diceRollPanel);
        addModifierMenu(modifiersArray, diceRollPanel);
        
        // Adding dropdown menu for none, advantage or disadvantage
    	addTextLabel(" ", diceRollPanel);
        addTextLabel("Advantage & disadvantage", diceRollPanel);
        addAdvantageAndDisadvantageMenu(advantageArray, diceRollPanel);
        
        // Used for centering
        diceRollPanel.add(Box.createVerticalGlue());
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
    	// Perform action when dice roll button is clicked
    	if(event.getSource() == diceRollButton) {
    		diceRollText.setAlignmentX(Component.CENTER_ALIGNMENT);
    		
    		// Setting dice type
    		String diceType = (String) diceTypeMenu.getSelectedItem();
    		DndDice dndDice = new DndDice(diceType);
    		
    		// Setting modifier
    		int modifierValue = (int) modifierMenu.getSelectedItem();
    		
    		// Setting advantage or disadvantage
    		String advantageOrNot = (String) advantageAndDisadvantageMenu.getSelectedItem();
    		if(advantageOrNot.equals("Advantage")) {
    			dndDice.diceRollWithAdvantage(modifierValue);
    		}
    		else if(advantageOrNot.equals("Disadvantage")) {
    			dndDice.diceRollWithDisadvantage(modifierValue);
    		}
    		
    		// Setting amount of dices to roll
    		int amountOfDices = (int) diceAmountMenu.getSelectedItem();
    		diceRollText.setText("Dice rolled " + dndDice.multipleDiceRollsWithModifier(amountOfDices, modifierValue));
    	}
    }
 

    public void addDiceTypeMenu(String[] dropdownChoices, Container panel) {
    	diceTypeMenu = new JComboBox<>(dropdownChoices);
    	diceTypeMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    	diceTypeMenu.setMaximumSize(diceTypeMenu.getPreferredSize());
    	diceTypeMenu.setFont(diceTypeMenu.getFont().deriveFont(Font.ROMAN_BASELINE, 12f));
    	panel.add(diceTypeMenu);
    }
    
    public void addModifierMenu(Integer[] dropdownChoices, Container panel) {
    	modifierMenu = new JComboBox<>(dropdownChoices);
    	modifierMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    	modifierMenu.setMaximumSize(modifierMenu.getPreferredSize());
    	modifierMenu.setSelectedIndex(5);
    	modifierMenu.setFont(modifierMenu.getFont().deriveFont(Font.ROMAN_BASELINE, 12f));
    	panel.add(modifierMenu);
    }
    
    
    public void addAdvantageAndDisadvantageMenu(String[] dropdownChoices, Container panel) {
    	advantageAndDisadvantageMenu = new JComboBox<>(dropdownChoices);
    	advantageAndDisadvantageMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    	advantageAndDisadvantageMenu.setMaximumSize(advantageAndDisadvantageMenu.getPreferredSize());
    	advantageAndDisadvantageMenu.setSelectedIndex(1);
    	advantageAndDisadvantageMenu.setFont(advantageAndDisadvantageMenu.getFont().deriveFont(Font.ROMAN_BASELINE, 12f));
    	panel.add(advantageAndDisadvantageMenu);
    }
    
    
    public void createAndShowGUI() {
        JFrame diceRollFrame = new JFrame("Dice Rolling");
        diceRollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addCommonComponentsToPanel(diceRollFrame.getContentPane());
        addComponentsToPanel(diceRollFrame.getContentPane());
 
        diceRollFrame.pack();
        diceRollFrame.setVisible(true);
    }
}