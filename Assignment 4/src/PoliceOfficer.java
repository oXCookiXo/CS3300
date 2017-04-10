/**
 * Created by oXCookiXo on 2/27/17.
 * 4. The PoliceOfficer Class:  This class should simulate a police officer inspecting parked cars. The class’s responsibilities are as follows:
 *      a) To know the Police Officer’s name and badge number.
 *      b) To examine a ParkedCar Object and a ParkingMeter Object, and determine whether the car’s time has expired.
 *      c) To issue a parking ticket (generate a ParkingTicket Object) if the car’s time has expired.
 */

import java.util.Random;

public class PoliceOfficer {

    private String name;
    private int badgeNumber;

    //Used only for creating a random badge number
    Random rand = new Random();
    //9999 is the maximum and the 1000 is our minimum
    int n = rand.nextInt(9999 - 1000) + 1000;

    //Default Constructor
    PoliceOfficer() {

        name = " ";
        badgeNumber = n;
    }
    //Constructor to assign name and badge number
    PoliceOfficer(String name, int badgeNumber){
        this.name = name;
        this.badgeNumber = badgeNumber;
    }
    //Constructor to assign name and create random badge number
    PoliceOfficer(String name){
        this.name = name;
        badgeNumber = n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getName() {
        return name;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }
    //Examine parkedCar Object AND Examine ParkingMeter Object
    public double  examine(ParkedCar parkedCar, PoliceOfficer policeOfficer){
        ParkingTicket parkingTicket = new ParkingTicket();

        if (parkedCar.getMinPurchased() > parkedCar.getMinParked()){
            //Used for debugging
            //System.out.println("Officer " + name + " has noticed your car is parked legally");
        }
        else if (parkedCar.getMinPurchased() < parkedCar.getMinParked()){
            //Issue parking ticket by generating ParkingTicket object
            System.out.println("Officer " + name + " has noticed a car is parked illegally");
            parkingTicket.reportOfficer(policeOfficer);
            parkingTicket.reportCar(parkedCar);
            parkingTicket.reportFine(parkedCar);
            System.out.println();

        }
        return parkingTicket.getFine();
    }


    //Debugging Methods
    void whoAmI() {
        System.out.println("I Am Officer " + name + " my badge number is " + badgeNumber);
    }
}
