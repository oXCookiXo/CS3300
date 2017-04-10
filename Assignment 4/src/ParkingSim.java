/**
 * Created by oXCookiXo on 2/27/17.
 * Write a demo class “ParkingSimulation” that will demonstrate how these classes interact.
 */

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.*;
import java.io.*;


public class ParkingSim {

    public static void main(String[] args) {

        int numTickets = 0;
        double fineTotal = 0;

        //First create an object of a Police Officer (just give the officer a name and badge number).
        PoliceOfficer PO = new PoliceOfficer("George");

        //Debugging
        //PO.whoAmI();

        //Read a file (car.txt) that contains information on a list of parked cars along with the parking meter.
        //* You should create objects that represent the parked cars and corresponding parking meters and store
        //* them in two separate data structures.
        ParkedCar[] parkedCars = readArray("car.txt");

        //Debugging
        // for(int i = 0; i < 20; i++){
        //      parkedCars[i].whoAmI();
        //  }

        double fine[] = new double[parkedCars.length];

        for (int i = 0; i < parkedCars.length; i++) {

            //The police officer should inspect each parked car and its corresponding meter and issue a parking ticket.
            //* If the car is parked legally, no parking ticket is issued.
            fine[i] = PO.examine(parkedCars[i], PO);

        }
        //* Display the parking tickets in ascending order of amount of fine.


        //print out currency
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);


        System.out.println("Today's Fines: ");
        for (int i = 0; i < parkedCars.length; i++) {
            //Sort array
            Arrays.sort(fine);

            //print only fined people
            if (fine[i] > 0) {
                //* Keep track of the number of cars that got a parking ticket. Display the count.
                numTickets++;
                //* Keep track of the total amount of money from all the parking tickets. Display the amount.
                fineTotal = fineTotal + fine[i];
                System.out.println(fmt.format(fine[i]));
            }
        }
        System.out.println("------------------");
        System.out.println(fmt.format(fineTotal) + " Total Fine");
        System.out.println("Total cars fined: " + numTickets);

        //Debugging
        //System.out.println(numTickets + "  " + fineTotal);
    }


    public static ParkedCar[] readArray(String file) {

        int ctr = 0;

        try {
            //Step 1:
            //Count how many lines there is

            Scanner s1 = new Scanner(new File(file));
            while (s1.hasNextLine()) {
                ctr = ctr + 1;
                s1.nextLine();
            }

            //Step 2:
            //Create array and read into it
            ParkedCar[] parkedCars = new ParkedCar[ctr];
            Scanner s2 = new Scanner(new File(file));
            for (int i = 0; i < ctr; i++) {

                String make = s2.next();
                String Model = s2.next();
                String LicenceNum = s2.next();
                int MinParked = Integer.valueOf(s2.next());
                int MinPurchased = Integer.valueOf(s2.next());

                parkedCars[i] = new ParkedCar(make, Model, LicenceNum, MinParked, MinPurchased);

            }
            return parkedCars;

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");

        }
        return null;
    }
}
