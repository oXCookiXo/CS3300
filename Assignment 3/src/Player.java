
//Player class to represent the player class. Should store players name,
// the class should have the ability to make a guess (when implementing make
// it a random guess) between Han or Cho. Each player also score points while 
// making a correct guess.

import java.util.*;

public class Player {

	Scanner scan = new Scanner(System.in);

	static int counter = 0;
	int position = 0;
	Integer points;
	String name;
	String guess;

	// Constructor
	public Player() {
		points = 0; // Player points
		name = null; // Player Name
		guess = "Cho (even)"; // Cho = even, Han = odd
		counter++;
		position = counter;
	}

	// Get players name
	public String name() {

		System.out.print("Enter the " + position + " player's name: ");
		name = scan.next();

		return name;
	}

	// Player point increase
	public void increasePoint() {

		points++;
	}

	// Player guess
	public String guess() {
		int x = (int) (Math.random() * 100);

		if (x % 2 == 0) {
			guess = "Han (odd)";
		} else
			guess = "Cho (even)";

		return guess;
	}

}
