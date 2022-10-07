
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DndDiceGUI extends GUIComponents implements ActionListener  {
	private final String[] diceTypeArray = {"d4", "d6", "d8", "d10", "d12", "d20", "d100"};
	private final Integer[] modifiersArray = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	private final String[] advantageArray = {"Advantage", "None", "Disadvantage"};
	private JComboBox<String> diceTypeMenu;
	private JComboBox<Integer> modifierMenu;
	private JComboBox<String> advantageAndDisadvantageMenu;
	private int amountOfDices;
	private String diceType;
	private int modifierValue;
	private DndDice dndDice;
	
	
    public void addComponentsToPanel(Container dndDicePanel) {
    	// Clearing panel when changing games
    	dndDicePanel.removeAll();
    	dndDicePanel.revalidate();
    	dndDicePanel.repaint();
    	
    	// Adding common components used in all GUIs
    	addCommonComponentsToPanel(dndDicePanel);
    	
    	// Adding dropdown menu for amount of dices to roll
    	addTextLabel(" ", dndDicePanel);
        addTextLabel("Amount of dices to roll", dndDicePanel);
        addDiceAmountMenu(diceAmountArray, dndDicePanel);
    	
        // Adding dropdown menu for dice types
    	addTextLabel(" ", dndDicePanel);
        addTextLabel("Dice type", dndDicePanel);
        this.addDiceTypeMenu(diceTypeArray, dndDicePanel);
        
        // Adding dropdown menu for modifier
        addTextLabel(" ", dndDicePanel);
        addTextLabel("Modifier", dndDicePanel);
        this.addModifierMenu(modifiersArray, dndDicePanel);
        
        // Adding dropdown menu for none, advantage or disadvantage
    	addTextLabel(" ", dndDicePanel);
        addTextLabel("Advantage & disadvantage", dndDicePanel);
        this.addAdvantageAndDisadvantageMenu(advantageArray, dndDicePanel);
       
        
        // Used for centering
        dndDicePanel.add(Box.createVerticalGlue());
    }
    
    
    public void actionPerformed(ActionEvent event) {
    	// Perform action when dice roll button is clicked
    	if(event.getSource() == diceRollButton) {
    		// Centering "Dice rolled x"
    		diceRollText.setAlignmentX(Component.CENTER_ALIGNMENT);
    		
    		// Setting dice type
    		diceType = (String) diceTypeMenu.getSelectedItem();
    		dndDice = new DndDice(diceType);
    		
    		// Setting modifier
    		modifierValue = (int) modifierMenu.getSelectedItem();
    		
    		// Setting advantage or disadvantage
    		String advantageOrNot = (String) advantageAndDisadvantageMenu.getSelectedItem();
    		if(advantageOrNot.equals("Advantage")) {
    			dndDice.diceRollWithAdvantage(modifierValue);
    		}
    		else if(advantageOrNot.equals("Disadvantage")) {
    			dndDice.diceRollWithDisadvantage(modifierValue);
    		}
    		
    		// Setting amount of dices to roll
    	    amountOfDices = (int) diceAmountMenu.getSelectedItem();
    	    this.diceRollText(); 
    	}
    	
    	// Choosing game and GUI to show
		String chosenGame = (String) gameChoosingMenu.getSelectedItem();
		if(chosenGame.equals("Regular Dice")) {
			dndDiceFrame.setVisible(false);
			Main.regularDiceGUI.createAndShowGUI();
		}
		else if(chosenGame.equals("Yatzy")) {
    		dndDiceFrame.setVisible(false);
			Main.yatzyGUI.createAndShowGUI();
		}
    }
    
    
    public void diceRollText() {
    	int diceRollValueWithModifier = dndDice.multipleDiceRollsWithModifier(amountOfDices, modifierValue);
    	
		if(amountOfDices == 1 && diceType.equals("d20") && diceRollValueWithModifier - modifierValue == 1) {
			diceRollText.setText("Critical fail!");
			diceRollWithModifierText.setText("With modifier: " + diceRollValueWithModifier);
		}
		else if(amountOfDices == 1 && diceType.equals("d20") && diceRollValueWithModifier - modifierValue == 20) {
			diceRollText.setText("Critical hit!");
			diceRollWithModifierText.setText("With modifier: " + diceRollValueWithModifier);
		} else {
			diceRollText.setText("Dice rolled " + (diceRollValueWithModifier - modifierValue));
			diceRollWithModifierText.setText("With modifier: " + diceRollValueWithModifier);	
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
        dndDiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addComponentsToPanel(dndDiceFrame.getContentPane());
        
        gameChoosingMenu.setSelectedIndex(1);
 
        dndDiceFrame.pack();
        dndDiceFrame.setVisible(true);
    }
}