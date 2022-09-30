

public class Main {
	public static final RegularDiceGUI regularDiceGUI = new RegularDiceGUI();
 
    public static void main(String[] args) {
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                regularDiceGUI.createAndShowGUI();
            }
        });
    }
} 