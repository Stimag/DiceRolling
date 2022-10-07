
public class YatzyDice extends Dice {

	
	public YatzyDice(String diceType) {
		super(diceType);
	}
	
	
	public int yatzyDiceRoll(int amountOfDices) {
			int totalDiceRollValue = 0;
			for(int i = 0; i < amountOfDices; i++) {
				totalDiceRollValue += diceRoll();
			}
			return totalDiceRollValue;
	}
	
}
