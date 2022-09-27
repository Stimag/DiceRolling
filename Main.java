

public class Main {
 
    public static void main(String[] args) {
    	
    	//RegularDice rgdice = new RegularDice("d6");
    	
    	
    	//RegularDiceGUI regGUI = new RegularDiceGUI();
    	DndDiceGUI dndGUI = new DndDiceGUI();
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                dndGUI.createAndShowGUI();
            }
        });
    }
}