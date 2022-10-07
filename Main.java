public class Main {
	public static final RegularDiceGUI regularDiceGUI = new RegularDiceGUI();
	public static final DndDiceGUI dndDiceGUI = new DndDiceGUI();
	public static final YatzyGUI yatzyGUI = new YatzyGUI();
	
	
    public static void main(String[] args) {
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                regularDiceGUI.createAndShowGUI();
            }
        });
    }
} 