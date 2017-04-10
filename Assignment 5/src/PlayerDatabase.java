/**
 * Created by oXCookiXo on 3/27/17.
 */

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class PlayerDatabase {

    private Player[] players;
    private int numPlayers;


    //Initiate a new scanner
    Scanner in = new Scanner(System.in);

    public PlayerDatabase(int num) {
        numPlayers = num;// need to update this
        //when you add, //remove players.
        players = new Player[numPlayers];

    }


    //Add a new player to the PlayerDatabase through a series of inputs (from keyboard) from the user.
    public void AddPlayer() {
        System.out.println("Number of current Players: " + numPlayers);

        String nPlayer;

        System.out.println("How many players do you want to add? :");
        nPlayer = in.nextLine();

        // not more than 10 players in the database allowed
        if (numPlayers < 10) {
            int safetyCheck = numPlayers + Integer.parseInt(nPlayer);

            while (safetyCheck > 10) {
                System.out.println("Too many players. Retry: ");
                nPlayer = in.nextLine();
                safetyCheck = numPlayers + Integer.parseInt(nPlayer);
            }
            //If the safety test passes, then create an array and copy it into a new one


        }
        System.out.println("Number of Players: " + numPlayers);
    }

    //Add a set of players to the PlayerDatabase through a file.
    public void AddPlayer(String PlayersFile, int num) {
        //num is the number of players in the file.
        numPlayers = num;
        // not more than 10 players in the database allowed
        if (numPlayers < 10) {
            players = readArray(PlayersFile, num);
        }

    }

    //The File PlayersFile contains several lines, where each line is of the format
    //PlayerName score shirtnumber
    //Given a list of players, display players’ names, scores, and shirt number on the screen (one player per line).
    // THIS method should always display the players in descending order of their scores.
    public static Player[] readArray(String file, int num) {

        int ctr = 0;
        try {
            //Step 1:
            //Count how many lines there is
            Scanner s1 = new Scanner(new File(file));
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.nextLine();
            }

            int safetyCheck = num + ctr;

            if (safetyCheck > 10) {
                System.out.println("To many total players. MAX is 10: ");
                System.out.println("Try again");
                return null;

            } else {

                //Step 2:
                //Create array and read into it
                Player[] localPlayers = new Player[ctr];
                Scanner s2 = new Scanner(new File(file));
                for (int i = 0; i < ctr; i++) {

                    String Name = s2.next();
                    int Score = Integer.valueOf(s2.next());
                    int shirtNumber = Integer.valueOf(s2.next());

                    localPlayers[i] = new Player(Name, Score, shirtNumber);
                }
                return localPlayers;

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return null;
    }


    public void DisplayPlayers(Player[] players) {

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(players[i].Name + " " + players[i].Score + " " + players[i].Shirt + " ");
        }
    }

    //Allow the user to enter a player’s name, this method finds the player with that specific name in the
    // database and then displays that player’s name, score and shirt number.  This method should give
    // a “not found” message if the player wasn’t found in the database.

    public void SearchPlayersByName(String playerName) {

    }

    //Allow the user to enter a player’s shirt number, this method finds the player with that
    // specific shirt number in the database and then displays that player’s name, score and shirt number.
    // This method should give a “not found” message if the player wasn’t found in the database.

    public void SearchPlayersByshirt(int playerShirtNumber) {
    }

    //Allow the user to enter a player’s score, this method finds ALL THE players with that
    //specific score in the database and then returns all the matching players.
    // This method should give a message if no players were found.

    public Player[] SearchPlayersByScore(int playerScore) {

        return new Player[0];
    }

    //Allows the user to enter a player’s name and remove the player having that name from the database.
    // This method should give a message if no players were found.

    public void RemovePlayerByName() {

    }

    //Prints the player’s name, score, and shirt number contained in  PlayerDatabase
    public void DisplayPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(players[i].Name + " " + players[i].Score + " " + players[i].Shirt + " ");
        }

    }


}
