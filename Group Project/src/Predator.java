/**
 * Created by oXCookiXo on 4/10/17.
 */


/**
 * Predator class
 */
public class Predator extends Organism {

    private Cell cell; //cell position of Predator

    //Constructor
    public Predator(Cell cell) {
        this.cell = cell;
    }


    /**
     * If a predator has not eaten a prey within the last three time steps, then at the end of the third time step,
     * it will starve and die. The predator should then be removed from the grid of cells. During one turn, all the
     * predators should move before the preys.
     */
    void Starve() {

    }
    Cell getCell() {
        return cell;
    }

    void setCell(Cell cell) {
        this.cell = cell;
    }

}
