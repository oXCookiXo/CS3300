/**
 * Created by oXCookiXo on 2/27/17.
 * 1. The ParkedCar Class: This class should represent a parked car. The class’s responsibilities are as follows:
 *      a)To know the car’s make, model, color, license number, and the number of minutes the car has been parked
 */

public class ParkedCar {

    private String make, model, licenceNum;
    private int minParked;
    private ParkingMeter parkingMeter;

    //Default Constructor
    ParkedCar() {

        make         = " ";
        model        = " ";
        licenceNum   = " ";
        minParked    = 0;
        parkingMeter = new ParkingMeter();
    }

    //Constructor
    ParkedCar(String make, String model, String licenceNum, int minParked, int minPurchased) {

        this.make       = make;
        this.model      = model;
        this.licenceNum = licenceNum;
        this.minParked  = minParked;
        parkingMeter    = new ParkingMeter(minPurchased);
    }
    //MUTATOR
    // Setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicenceNum(String licenceNum) {
        this.licenceNum = licenceNum;
    }

    public void setMinParked(int minParked) {
        this.minParked = minParked;
    }

    public void setMinPurchased(int minPurchased) {
        parkingMeter.setMinPurchased(minPurchased);
    }

    //Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getLicenceNum() {
        return licenceNum;
    }

    public int getMinParked() {
        return minParked;
    }

    public int getMinPurchased() {
        return parkingMeter.getMinPurchased();
    }

    //Debugging Methods
    void whoAmI() {
        System.out.println("File shows: " + make + " " + model + " " + licenceNum + " " + minParked + " " + parkingMeter.getMinPurchased());
    }
}
