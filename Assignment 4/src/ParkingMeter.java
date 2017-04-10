/**
 * Created by oXCookiXo on 2/27/17.
 * 2. The ParkingMeter Class: This class should simulate a parking meter. An Object of ParkedCar will be parked near a ParkingMeter. The ParkedCar will purchase a certain amount of minutes using the parking meter. The class’s only responsibility is as follows:
 *      a)To know the number of minutes of parking time that has been purchased.
 */
public class ParkingMeter {

    private int minPurchased;

    //Default Constructor
    ParkingMeter() {
        minPurchased = 0;
    }

    //Constructor
    ParkingMeter(int minPurchased) {
        this.minPurchased = minPurchased;
    }

    public int getMinPurchased() {
        return minPurchased;
    }

    public void setMinPurchased(int minPurchased) {
        this.minPurchased = minPurchased;
    }
}
