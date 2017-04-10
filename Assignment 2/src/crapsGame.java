import java.util.*;

public class crapsGame {
	
	static boolean userWantsToQuit = false;
	static boolean keepPlaying     = true;
	static double  balance         = 1000.00;
	static int     gameNumber      = 0;
	static int     points          = 0;
	
    public static void main (String[]args){
	   
    	Scanner scan = new Scanner(System.in);
	    
    	int sum         = 0;
    	int win		   = 0;
    	int lost 	   = 0;
    	int avg		   = 0;
    	int rolls       = 0;
    	double bet      = 0;
    	String choice   = "P";
	
	  do{
		   //Menu
		   System.out.print("Game of Craps\n");
		   System.out.print("P – Play one Game of Craps \n");
		   System.out.print("R - Print a summary of all the games played\n");
		   System.out.print("H - Help\n");
		   System.out.print("Q - Quit\n");

		   //Receive input for menu
		   choice = scan.next(); 
		   
		   //quite immediately if chosen
		   if(choice.equals("Q")||choice.equals("q")){
			   userWantsToQuit = true;
		   }
		   //otherwise continue with other options
		   else{
			  
			   if(choice.equals("P")||choice.equals("p")){
				   keepPlaying = true;
				   
				   //Current balance + bet amount
				   System.out.print("Current balance is: $"+ "" + balance + "\n");
				   System.out.print("How much do you want to bet: $");
				   
				   //Receive input for Bet amount
				   bet = scan.nextDouble(); 
				   
				   //Increment game number for the game
				   gameNumber++;
				   
				   System.out.print("\nGame "+ gameNumber + ": ");
				  
				   //First roll
				   sum = rollDice();
				   rolls++;
				   
				   //Have they won?
				   if (sum == 7 || sum == 11) {
					      bet += bet;
					      balance = balance + bet;
					      points = 0;
					      System.out.print(" <win>\n");
					      win++;
					      }
				   //have they lost?
				   else if(sum == 2 || sum == 3 || sum == 12) {
					      balance = balance - bet;
					      System.out.print(" <lose>\n");
					      lost++;
					      }
				   
				   //Continue rolling either for your "point" or lose with a 7
				   else{
					   int point = sum;
					   
					   
					   while(keepPlaying){
						   sum = rollDice();
						   rolls++;
						   //Did they win? (match point)
						   if (sum == point)
						   {
							   System.out.println(" <win>");
							   balance = balance + bet;
							   keepPlaying = false;
							   win++;
						   }
						   //Did they lose?(roll a 7)
						   else if(sum == 7)
						   {
							   System.out.println(" <lose>");
							   balance = balance - bet;
							   keepPlaying = false;
							   lost++;
						   }
					   }
				   }
				   
				   System.out.print("\nCurrent balance: "+ balance + "\n");
				   System.out.print("\n---------------------------------------------------------\n\n");
				   
			   }
			   else if(choice.equals("R")||choice.equals("r")){
				   
				   avg = rolls/gameNumber;
				   System.out.print("Total number of Games   wins   lost   average rolls\n");
				   System.out.print("\t" + gameNumber + "\t\t " + win + "\t " + lost + "\t   " + avg + "\n");  

				   
			   }
			   else if(choice.equals("H")||choice.equals("h")){
				   
				   System.out.print("Craps is a popular gambling game.The rules of the game are as follows:\n");
				   System.out.print("The player rolls 2 dice the first time (the “come out roll.”) \n");
				   System.out.print("If the 2 dice sum to 7 or 11 it is a “natural” and the player wins.\n");
				   System.out.print("If the sum of the 2 dice is 2, 3 or 12 then it is “craps” and the player loses.\n");
				   System.out.print("Any other sum on the first roll 4, 5, 6, 8, 9, or 10 becomes the player’s “point” \n");
				   System.out.print("The player then continues to roll the dice until either the player rolls the point again\n");
				   System.out.print("or until 7 is rolled. If the player rolls the point again then the player wins.\n");
				   System.out.print("If the player rolls 7 before rolling the point again then the player loses\n");
				   System.out.print("\n-----------------------------------\n\n");
				   
			   }
			   else if(choice.equals("Q") || choice.equals("q")){
				   userWantsToQuit = true;
				   
			   }
		   }
	   }while(!userWantsToQuit);	
	   scan.close();
	   System.out.print("Thanks for playing!");
}


// The rules of the game are as follows: The player rolls 2 dice the first time (the “come out roll”).  
public static int rollDice() 
{
	int die1 = 0;
	int die2 = 0;
	int rollTotal  = 0;
	
	die1 = (int)(Math.random()*6.0) + 1; //first die
	die2 = (int)(Math.random()*6.0) + 1; //second die
	rollTotal = die1 + die2; //sum of roll
   
   System.out.printf(" %d,", rollTotal);  //Prints the sum of both dice
   
   return rollTotal;
}


//
public static int points(int sum)
{  
   
	if(points == sum)
	{
		points = 200;
	}
	else if (sum >= 4 && sum <= 6) {  //Counts points based on your rolls
      points = sum;
   }
   
   else if (sum>=8 && sum<=10){
      points = sum;
   }
   
   return points;
}


}