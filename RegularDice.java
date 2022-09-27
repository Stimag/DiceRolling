
public class RegularDice extends Dice {

	public RegularDice(String diceType) {
		super(diceType);
	}
	
	public int regularDiceRoll() {
		return diceRoll();
	}
	
	public int rollMultipleDice(int amount) {
		int totalDiceRollValue = 0;
		for(int i = 0; i < amount; i++) {
			totalDiceRollValue += regularDiceRoll();
		}
		return totalDiceRollValue;
	}
}
