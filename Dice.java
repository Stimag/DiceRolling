abstract class Dice {
	protected String diceType;
	private int diceRollValue;
    
	
    public Dice(String diceType) {
        this.diceType = diceType;
    }

    
    public int diceRoll() {
    	int minValue = 1;
    	int maxValue = 0;
    	
		 
    	if(this.diceType.equals("d4")) {
    		maxValue = 4;
    	} 
    	else if(this.diceType.equals("d6")) {
    		maxValue = 6;
    	}
    	else if(this.diceType.equals("d8")) {
    		maxValue = 8;
    	}
    	else if(this.diceType.equals("d10")) {
    		maxValue = 10;
    	}
    	else if(this.diceType.equals("d12")) {
    		maxValue = 12;
    	}
    	else if(this.diceType.equals("d20")) {
    		maxValue = 20;
    	}
    	else if(this.diceType.equals("d100")) {
    		maxValue = 100;
    	}

    	// Dice rolling
    	int diceRange = maxValue - minValue + 1;
    	this.diceRollValue = (int)(Math.random() * diceRange) + minValue;
        
    	
        return this.diceRollValue;
    }
    
}

