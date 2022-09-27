
public class DndDice extends Dice {
	
	public DndDice(String diceType) {
		super(diceType);
	}
	
	
	public int diceRollWithModifier(int modifier) {
    	return diceRoll() + modifier;
    }
    
    
    // Highest dice roll counts
    public int diceRollWithAdvantage(int modifier) {
    	int diceRollOne = diceRoll() + modifier;
    	int diceRollTwo = diceRoll() + modifier;
    	
    	if(diceRollOne < diceRollTwo) {
    		return diceRollTwo;
    	}
    	else {
    		return diceRollOne;
    	}
    }
    
    
    // Lowest dice roll counts
    public int diceRollWithDisadvantage(int modifier) {
    	int diceRollOne = diceRoll() + modifier;
    	int diceRollTwo = diceRoll() + modifier;
    	
    	if(diceRollOne < diceRollTwo) {
    		return diceRollOne;
    	}
    	else {
    		return diceRollTwo;
    	}
    }
    
    public String toString() {
    	return "Dice rolled: ";
    }
}
