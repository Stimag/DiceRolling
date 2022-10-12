
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class YatzyGUI extends GUIComponents implements ActionListener {
	private JToggleButton diceRollOne = new JToggleButton();
	private JToggleButton diceRollTwo = new JToggleButton();
	private JToggleButton diceRollThree = new JToggleButton();
	private JToggleButton diceRollFour = new JToggleButton();
	private JToggleButton diceRollFive = new JToggleButton();
	private JToggleButton diceRollSix = new JToggleButton();
	private RegularDice yatzyDice = new RegularDice("d6");
	
	
	public void addComponentsToPanel(Container yatzyDicePanel) {
		// Clearing panel when changing games
		yatzyDicePanel.removeAll();
		yatzyDicePanel.revalidate();
		yatzyDicePanel.repaint();
		
		// Adding common components used in all GUIs
		addCommonComponentsToPanel(yatzyDicePanel);
		
		// Making space between components
        addTextLabel(" ", yatzyDicePanel);
        
        // Creating horizontal line of toggle buttons for dice rolls
        Box buttonbox = Box.createHorizontalBox();
		this.addYatzyRolledDiceValueButton(diceRollOne, buttonbox);
		this.addYatzyRolledDiceValueButton(diceRollTwo, buttonbox);
		this.addYatzyRolledDiceValueButton(diceRollThree, buttonbox);
		this.addYatzyRolledDiceValueButton(diceRollFour, buttonbox);
		this.addYatzyRolledDiceValueButton(diceRollFive, buttonbox);
		this.addYatzyRolledDiceValueButton(diceRollSix, buttonbox);
        yatzyDicePanel.add(buttonbox);
        
        // Used for centering
        yatzyDicePanel.add(Box.createVerticalGlue());
    }
   
    
    public void actionPerformed(ActionEvent event) {
    	// Perform action when dice roll button is clicked
    	if(event.getSource() == diceRollButton) {
    		// Check if dice rolls are saved, roll if not
    		if(!diceRollOne.isSelected()) {
    			diceRollOne.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    		
    		if(!diceRollTwo.isSelected()) {
    			diceRollTwo.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    		
    		if(!diceRollThree.isSelected()) {
    			diceRollThree.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    		
    		if(!diceRollFour.isSelected()) {
    			diceRollFour.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    		
    		if(!diceRollFive.isSelected()) {
    			diceRollFive.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    		
    		if(!diceRollSix.isSelected()) {
    			diceRollSix.setText(String.valueOf(yatzyDice.multipleDiceRolls(1)));
    		}
    	}
    	
    	
    	// Choosing game and GUI to show
    	String chosenGame = (String) gameChoosingMenu.getSelectedItem();
    	if(chosenGame.equals("DnD")) {
    		yatzyDiceFrame.setVisible(false);
			Main.dndDiceGUI.createAndShowGUI();
		}
    	else if(chosenGame.equals("Regular Dice")) {
			yatzyDiceFrame.setVisible(false);
			Main.regularDiceGUI.createAndShowGUI();
		}
    } 
    
    
    public void addYatzyRolledDiceValueButton(JToggleButton specificDice, Container panel) {
        specificDice.setFont(specificDice.getFont().deriveFont(10f));
        specificDice.setAlignmentX(Component.CENTER_ALIGNMENT);
        specificDice.setBorder(BorderFactory.createCompoundBorder(specificDice.getBorder(),
                BorderFactory.createEmptyBorder(1, 2, 1, 2)));
        specificDice.setText("x");
        specificDice.addActionListener(this);
        panel.add(specificDice);
    }
 
    
    public void createAndShowGUI() {
    	yatzyDiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addComponentsToPanel(yatzyDiceFrame.getContentPane());
        
        gameChoosingMenu.setSelectedIndex(2);
 
        yatzyDiceFrame.pack();
        yatzyDiceFrame.setVisible(true);
    }
}
