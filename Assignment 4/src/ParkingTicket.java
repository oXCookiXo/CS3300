/**
 * Created by oXCookiXo on 2/27/17.
 * 3. The ParkingTicket Class: This class should simulate a parking ticket. The class responsibilities are as follows:
 *      a) To report the make, model, color, and license plate number of the illegally parked Car.
 *      b) To report the amount of fine, which is $25 for the first hour or part of an hour that the car has illegally
 *         parked, plus $10 for every additional hour or part of an hour that the car is illegally parked.
 *      c) To report the name and badge number of the police officer issuing the ticket.
 */

import java.text.NumberFormat;
import java.util.Locale;

public class ParkingTicket {

    private double fine;

    //Default Constructor
    ParkingTicket() {

    }

    //report the name and badge number of the officer issuing the ticket
    void reportOfficer(PoliceOfficer policeOfficer) {
        System.out.println("Police Officer: " + policeOfficer.getName() + " Badge Number: " + policeOfficer.getBadgeNumber() + " Has issued a ticket for");
    }

    //Report make, model and license plate number
    void reportCar(ParkedCar parkedCar) {
        System.out.println(parkedCar.getMake() + " " + parkedCar.getModel() + " " + parkedCar.getLicenceNum());
    }

    //Report amount of fine, $25 for the first hour or part of an hour + $10 for additional hours or parts of hours
    void reportFine(ParkedCar parkedCar) {
        int time;


        //print out currency
        time = parkedCar.getMinParked() - parkedCar.getMinPurchased();
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        //Initial Fine
            fine = 25.00;
            time = time - 60;

        //Continuous fine per extra hour
        while (1 <= time ) {
            fine += 10.00;
            time  = time - 60;

        }
        System.out.println("Your fine is: " + fmt.format(fine));
    }


    //MUTATOR
    //Getter
    public double getFine() {
        return fine;
    }
}
