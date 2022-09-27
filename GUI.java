import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
	private RegularDice d6 = new RegularDice("d6");
    private JLabel regularDiceLabel = new JLabel("");
    private JFrame regularDiceFrame = new JFrame();
    private String[] dicesToChoose = {"Regular dice", "DnD", "Yatzy"};
    

    public GUI() {
        JButton rollDiceButton = new JButton("Roll the dice");
        rollDiceButton.addActionListener(this);
        
        JComboBox<String> jComboBox = new JComboBox<>(dicesToChoose);
        jComboBox.setBounds(100, 150, 140, 20);
        

        JPanel regularDicePanel = new JPanel();
        regularDicePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 150, 250));
        regularDicePanel.setLayout(new GridLayout(0, 1));
        regularDicePanel.add(rollDiceButton);
        regularDiceFrame.add(jComboBox);
        regularDicePanel.add(regularDiceLabel);
        
        
        
   
        regularDiceFrame.add(regularDicePanel, BorderLayout.CENTER);
      
        regularDiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regularDiceFrame.setTitle("GUI");
        regularDiceFrame.pack();
        regularDiceFrame.setVisible(true);
        
    }

    // Roll the dice
    public void actionPerformed(ActionEvent e) {
    	regularDiceLabel.setText("Dice rolled " + d6.regularDiceRoll());
    }


    public static void main(String[] args) {
        new GUI();
    }
}