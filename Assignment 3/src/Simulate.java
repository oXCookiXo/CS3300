//Simulate class to simulate the game of five rounds. Here, you will create one 
// object of Dealer and two objects of the player class. The simulation should 
// display the final points, name of each player, and the name of the winner.

public class Simulate {
	public static void main(String[] args) {

		// Create Objects for Game
		Player p1 = new Player();
		Player p2 = new Player();
		Dealer dealer = new Dealer();

		// Ask for player info
		p1.name();
		p2.name();
		System.out.println("--------------------------------------");

		for (int i = 0; i < 5; i++) {

			System.out.println("Now Playing round " + (i + 1) + ".");
			dealer.roll();
			System.out.println("The dealer rolled " + dealer.roll1 + " and " + dealer.roll2 + ".");
			String outcome = dealer.choHan();
			System.out.println("Result: " + outcome);
			dealer.winner(outcome, p1, p2);

			System.out.println("---------------------------------");

		}

		System.out.println("Game over. Here are the results:");
		System.out.println(p1.name + ": " + p1.points + " points.");
		System.out.println(p2.name + ": " + p2.points + " points.");

		if (p1.points > p2.points) {
			System.out.println(p1.name + " is the grand winner!");
		} else if (p1.points < p2.points) {
			System.out.println(p2.name + " is the grand winner!");
		} else
			System.out.println("Tie game.");
	}
}
