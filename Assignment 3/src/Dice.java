// Dice class to represent a die.

public class Dice {

	private Integer dieRoll;

	// Constructor method
	public Dice() {

		dieRoll = 0;
	}

	// Method to simulate dieRoll
	public int roll() {

		dieRoll = (int) (Math.random() * 6) + 1;
		return dieRoll;
	}
}
