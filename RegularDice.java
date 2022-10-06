
public class RegularDice extends Dice {

	public RegularDice(String diceType) {
		super(diceType);
	}
	
	public int multipleDiceRolls(int amountOfDices) {
		int totalDiceRollValue = 0;
		for(int i = 0; i < amountOfDices; i++) {
			totalDiceRollValue += diceRoll();
		}
		return totalDiceRollValue;
	}
}
  