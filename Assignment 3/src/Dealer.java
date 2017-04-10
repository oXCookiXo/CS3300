//Dealer class to represent the dealer. The dealer should have the ability to
// roll two dice, report the value of the dice, and report whether the total 
// dice value is Cho or Han.

public class Dealer {

	// Create objects for game
	Dice d1 = new Dice();
	Dice d2 = new Dice();
	Integer rollTotal;
	Integer roll1;
	Integer roll2;

	public Dealer() {
		rollTotal = 0;
	}

	// Roll two dice
	public void roll() {
		roll1 = d1.roll();
		roll2 = d2.roll();
		rollTotal = roll1 + roll2;

	}

	// Check for winner
	public void winner(String outcome, Player p1, Player p2) {
		p1.guess();
		p2.guess();

		System.out.println("The player " + p1.name + " guessed " + p1.guess);
		if (p1.guess.equals(outcome)) {
			System.out.println("Awarding 1 point(s) to " + p1.name);
			p1.increasePoint();
		}
		System.out.println("The player " + p2.name + " guessed " + p2.guess);
		if (p2.guess.equals(outcome)) {
			System.out.println("Awarding 1 point(s) to " + p2.name);
			p2.increasePoint();
		}

	}

	// is it even (cho)? OR is it odd (han)?
	public String choHan() {

		if (rollTotal % 2 == 0) {
			return "Cho (even)";
		} else {
			return "Han (odd)";
		}
	}
}
