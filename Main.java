

public class Main {
 
    public static void main(String[] args) {
    	
    	RegularDice rgdice = new RegularDice("d6");
    	
    	
    	GUI2 diceGUI = new GUI2();
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                diceGUI.createAndShowGUI();
            }
        });
    }
}