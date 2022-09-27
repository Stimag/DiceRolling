
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
 
public class GUI2 implements ActionListener {
	private final String[] dicesToChoose = {"Regular dice", "DnD", "Yatzy"};
	private final String[] diceAmountToRoll = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private final RegularDice d6 = new RegularDice("d6");
	private JLabel diceRollText = new JLabel("");
	
	
    public void addComponentsToPane(Container diceRollPanel) {
        diceRollPanel.setLayout(new BoxLayout(diceRollPanel, BoxLayout.Y_AXIS));
        diceRollPanel.setPreferredSize(new Dimension(300, 300));

        // Used for centering
        diceRollPanel.add(Box.createVerticalGlue());
        
        // Adding button with "Roll the dice" text
        addDiceRollButton("Roll the dice", diceRollPanel);
        
        // Adding "Dice rolled x" with empty space over and under
        addTextLabel(" ", diceRollPanel);
        diceRollPanel.add(diceRollText);
        addTextLabel(" ", diceRollPanel);
        
        // Adding dropdown menus with labels
        addTextLabel("Choose game", diceRollPanel);
        addADropdownMenu(dicesToChoose, diceRollPanel);
        addTextLabel("Amount of dices to roll", diceRollPanel);
        addADropdownMenu(diceAmountToRoll, diceRollPanel);
        
        // Used for centering
        diceRollPanel.add(Box.createVerticalGlue());
    }
    
    public void actionPerformed(ActionEvent e) {
    	diceRollText.setAlignmentX(Component.CENTER_ALIGNMENT);
    	diceRollText.setText("Dice rolled " + d6.regularDiceRoll());
    }
 
    public void addDiceRollButton(String text, Container panel) {
        JButton diceRollButton = new JButton(text);
        diceRollButton.setFont(diceRollButton.getFont().deriveFont(Font.BOLD, 20f));
        diceRollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        diceRollButton.setBorder(BorderFactory.createCompoundBorder(diceRollButton.getBorder(),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        diceRollButton.addActionListener(this);
        panel.add(diceRollButton);
    }
    
    public void addADropdownMenu(String[] dropdownChoices, Container panel) {
    	JComboBox<String> dropDownMenu = new JComboBox<>(dropdownChoices);
    	dropDownMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    	dropDownMenu.setMaximumSize(dropDownMenu.getPreferredSize());
    	dropDownMenu.setFont(dropDownMenu.getFont().deriveFont(Font.ITALIC, 12f));
    	panel.add(dropDownMenu);
    }
    
    public void addTextLabel(String text, Container panel) {
    	JLabel textLabel = new JLabel("");
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setText(text);
        panel.add(textLabel);
    }
 
    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame diceRollFrame = new JFrame("Dice Rolling");
        diceRollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up the content pane.
        addComponentsToPane(diceRollFrame.getContentPane());
 
        //Display the window.
        diceRollFrame.pack();
        diceRollFrame.setVisible(true);
    }
}