/**
 * Created by oXCookiXo on 4/10/17.
 */


//Prey class

public class Prey extends Organism{

    private Cell cell; //cell position of Prey

    //Constructor
    public Prey(Cell cell) {
        this.cell = cell;
    }

    Cell getCell() {
        return cell;
    }

    void setCell(Cell cell) {
        this.cell = cell;
    }
}