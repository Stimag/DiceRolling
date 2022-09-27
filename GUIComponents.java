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

public class GUIComponents implements ActionListener {
	private final String[] gamesArray = {"Regular dice", "DnD", "Yatzy"};
	private final Integer[] diceAmountArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	protected JButton diceRollButton;
	private JComboBox<String> gameChoosingMenu;
	protected JComboBox<Integer> diceAmountMenu;
	protected JLabel diceRollText = new JLabel("");
	
	
	 public void addCommonComponentsToPanel(Container diceRollPanel) {
        diceRollPanel.setLayout(new BoxLayout(diceRollPanel, BoxLayout.Y_AXIS));
        diceRollPanel.setPreferredSize(new Dimension(500, 400));

        // Used for centering
        diceRollPanel.add(Box.createVerticalGlue());
        
        // Adding button with "Roll the dice" text
        addDiceRollButton("Roll the dice", diceRollPanel);
        
        // Adding "Dice rolled x" with empty space over and under
        addTextLabel(" ", diceRollPanel);
        diceRollPanel.add(diceRollText);
        addTextLabel(" ", diceRollPanel);
        
        // Adding dropdown menus with labels
        addTextLabel(" ", diceRollPanel);
        addTextLabel("Choose game", diceRollPanel);
        addGameChoosingMenu(gamesArray, diceRollPanel);
        
        addTextLabel(" ", diceRollPanel);
        addTextLabel("Amount of dices to roll", diceRollPanel);
        addDiceAmountMenu(diceAmountArray, diceRollPanel);
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
    	gameChoosingMenu.setFont(gameChoosingMenu.getFont().deriveFont(Font.ROMAN_BASELINE, 12f));
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
	
	// Overridden in GUI classes
	public void actionPerformed(ActionEvent event) {
		
	}
}
