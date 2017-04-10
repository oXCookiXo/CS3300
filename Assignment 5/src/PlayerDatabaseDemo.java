import javax.xml.crypto.Data;
import java.util.Scanner;

/**
 * Created by oXCookiXo on 3/27/17.
 */
public class PlayerDatabaseDemo {

    public static void main(String[] args) {

        //Testing the copy constructor of Player
        Player p1 = new Player("Sam", 20, 1);
        Player p2 = new Player(p1);
        p1.setName("John"); //setName() is a mutator method
        System.out.println(p1.getName() == p2.getName()); //should be false //getName() is an accessor method


        PlayerDatabase Sim = new PlayerDatabase(2);


        //1. Use AddPlayer(String PlayersFile) to load players
        Sim.AddPlayer("PlayersFile.txt", 4);

        //2. Display number of players in the database
        Sim.DisplayPlayers();
        //3. You should display all the players in the database- their names,scores and shirt numbers
        // (one player per line)

        //4. Here you need to create a menu system that allows the user to select
        //   which option or method to invoke from the Class PlayerDatabase. Provide an option to
        //   allow the user to exit from the menu
        System.out.println("What would you like to do? :");

        //MENU
        //set choiceEntry to -1, this will make it to enter while loop
        int choiceEntry = -1;
        int subMenu = 0;
        Scanner scanChoice = new Scanner(System.in);


        do {
            System.out.println("Type the number you'd like to choose: ");
            System.out.println("1.Add/Remove Players");
            System.out.println("2.Display Players");
            System.out.println("3.Search for Players");
            System.out.println("0. Exit");
            if (scanChoice.hasNextInt())
                choiceEntry = scanChoice.nextInt();


            switch (choiceEntry) {
                case 1:
                    System.out.println("Choice 1");
                    do {
                        System.out.println("How would you like to edit players");
                        System.out.println("1. Add 1 player");
                        System.out.println("2. Import a list with players");
                        System.out.println("3. Remove Player By Name");
                        System.out.println("0. Exit");

                        subMenu = scanChoice.nextInt();

                        switch (subMenu) {
                            
                            case 1:
                                System.out.println("Add 1 player");
                               Sim.AddPlayer();
                                break;
                            case 2:
                                System.out.println("Import a list with players");
                                break;
                            case 3:
                                System.out.println("Remove Player By Name");
                                break;
                            case 0:
                                System.out.println("EXIT");
                                break;
                        }
                    } while (subMenu != 0);

                    break;
                case 2:
                    //do logic
                    System.out.println("choice 2");
                    break;
                case 3:
                    //do logic
                    System.out.println("choice 3");
                    break;
                case 0:
                    System.out.println("EXIT");
                    break;

            }
        } while (choiceEntry != 0);

        //5. After it exits from the menu system, display number of remaining
        //   players in the database. Then, display all the remaining players -their
        //   names, scores and shirt numbers in the database (one player per line)


    }
}
