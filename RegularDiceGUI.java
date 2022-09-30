
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
 
public class RegularDiceGUI extends GUIComponents implements ActionListener {
	private final RegularDice d6 = new RegularDice("d6");
	private DndDiceGUI dndDiceGUI = new DndDiceGUI();
	
	public void addComponentsToPanel(Container regularDicePanel) {
		regularDicePanel.removeAll();
		regularDicePanel.revalidate();
		regularDicePanel.repaint();
		
		// Adding common components used in all GUIs
        addCommonComponentsToPanel(regularDicePanel);
        
        // Used for centering
        regularDicePanel.add(Box.createVerticalGlue());
    }
   
    
    @Override
    public void actionPerformed(ActionEvent event) {
    	// Perform action when dice roll button is clicked
    	if(event.getSource() == diceRollButton) {
    		int amountOfDices = (int) diceAmountMenu.getSelectedItem();
    		
    		diceRollText.setAlignmentX(Component.CENTER_ALIGNMENT);
    		diceRollText.setText("Dice rolled " + d6.multipleDiceRolls(amountOfDices));
    	}
    	
    	// Choosing game
    	String chosenGame = (String) gameChoosingMenu.getSelectedItem();
    	if(chosenGame.equals("DnD")) {
    		regularDiceFrame.setVisible(false);
			dndDiceGUI.createAndShowGUI();
		}
    } 
 
    
    public void createAndShowGUI() {
        regularDiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addComponentsToPanel(regularDiceFrame.getContentPane());
        
        gameChoosingMenu.setSelectedIndex(0);
 
        regularDiceFrame.pack();
        regularDiceFrame.setVisible(true);
    }
}