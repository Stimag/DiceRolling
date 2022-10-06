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
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIComponents implements ActionListener {
	private final String[] gamesArray = {"Regular Dice", "DnD", "Yatzy"};
	protected final Integer[] diceAmountArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	protected JButton diceRollButton;
	protected JComboBox<String> gameChoosingMenu;
	protected JComboBox<Integer> diceAmountMenu;
	protected JLabel diceRollText = new JLabel("");
	protected JLabel diceRollWithModifierText = new JLabel("");
	protected JFrame dndDiceFrame = new JFrame("Dice Rolling");
	protected JFrame regularDiceFrame = new JFrame("Dice Rolling");
	protected JFrame yatzyDiceFrame = new JFrame("Dice Rolling");
	
	
	public void addCommonComponentsToPanel(Container diceRollingPanel) {
	    diceRollingPanel.setLayout(new BoxLayout(diceRollingPanel, BoxLayout.Y_AXIS));
	    diceRollingPanel.setPreferredSize(new Dimension(500, 500));
	    
	    // Used for centering
	    diceRollingPanel.add(Box.createVerticalGlue());
	    
	    // Adding "Roll the dice" button
	    addDiceRollButton("Roll the dice", diceRollingPanel);
	     
	    // Creating space between dice roll button and "Dice rolled x"
	    addTextLabel(" ", diceRollingPanel);
	    // Adding "Dice rolled x" and "With modifier: y"
	    diceRollingPanel.add(diceRollText);
	    diceRollingPanel.add(diceRollWithModifierText);
	    // Centering "With modifier: x"
	    diceRollWithModifierText.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    // Adding dropdown menus with labels
	    addTextLabel(" ", diceRollingPanel);
	    addTextLabel("Choose game", diceRollingPanel);
	    addGameChoosingMenu(gamesArray, diceRollingPanel);
	}
	
	 
	public void addDiceRollButton(String text, Container panel) {
	    diceRollButton = new JButton(text);
	    diceRollButton.setFont(diceRollButton.getFont().deriveFont(Font.BOLD, 20f));
	    diceRollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    diceRollButton.setBorder(BorderFactory.createCompoundBorder(diceRollButton.getBorder(),
	            BorderFactory.createEmptyBorder(4, 8, 4, 8)));
	    diceRollButton.addActionListener(this);
	    panel.add(diceRollButton);
	}
	
	
	public void addGameChoosingMenu(String[] dropdownChoices, Container panel) {
		gameChoosingMenu = new JComboBox<>(dropdownChoices);
		gameChoosingMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		gameChoosingMenu.setMaximumSize(gameChoosingMenu.getPreferredSize());
		gameChoosingMenu.setFont(gameChoosingMenu.getFont().deriveFont(12f));
		gameChoosingMenu.addActionListener(this);
		panel.add(gameChoosingMenu);
	}
	 
	 
	public void addDiceAmountMenu(Integer[] dropdownChoices, Container panel) {
		diceAmountMenu = new JComboBox<>(dropdownChoices);
		diceAmountMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		diceAmountMenu.setMaximumSize(diceAmountMenu.getPreferredSize());
		diceAmountMenu.setFont(diceAmountMenu.getFont().deriveFont(Font.ROMAN_BASELINE, 12f));
		panel.add(diceAmountMenu);
	}
	
	
	public void addTextLabel(String text, Container panel) {
		JLabel textLabel = new JLabel("");
	    textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    textLabel.setText(text);
	    panel.add(textLabel);
	}
	
	
	// Used in GUIs
	public void actionPerformed(ActionEvent event) {
		
	}
}
