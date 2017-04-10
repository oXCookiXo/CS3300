/**
 * Created by oXCookiXo on 4/10/17.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PredatorPreySimGUI class
 */
public class PredatorPreySimGUI {

    protected static int predatorCount = 0;
    protected static int preyCount = 0;
    protected static int rowCellsCount = -1;
    protected static int columnCellsCount = -1;
    protected static int timeStepsCount = -1;
    protected static Cell cellsGrid[][];
    protected static Prey preys[];
    protected static Predator predators[];
    protected static Random rand = new Random();

    /**
     * creates and shows GUI
     */
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Predator Prey Simulation GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(400, 400));
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(6, 2, 1, 1);
        panel.setLayout(gridLayout);
        JLabel predatorCountLabel = new JLabel("Initial Predator Count:");
        JLabel preyCountLabel = new JLabel("Initial Prey Count:");
        JLabel rowCellsCountLabel = new JLabel("Row Cells Count:");
        JLabel columnCellsCountLabel = new JLabel("Column Cells Count:");
        JLabel timeStepsCountLabel = new JLabel("Time Steps Count:");
        JTextField predatorCountField = new JTextField();
        JTextField preyCountField = new JTextField();
        JTextField rowCellsCountField = new JTextField();
        JTextField columnCellsCountField = new JTextField();
        JTextField timeStepsCountField = new JTextField();
        JButton simulateButton = new JButton("Simulate");
        JButton positionsButton = new JButton("Positions");
        simulateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (predatorCountField.getText().equals("") || preyCountField.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please enter values in fields");
                } else {
                    predatorCount = Integer.parseInt(predatorCountField.getText());
                    preyCount = Integer.parseInt(preyCountField.getText());
                    rowCellsCount = Integer.parseInt(rowCellsCountField.getText());
                    columnCellsCount = Integer.parseInt(columnCellsCountField.getText());
                    timeStepsCount = Integer.parseInt(timeStepsCountField.getText());
                    try {
                        cellsGrid = new Cell[rowCellsCount][columnCellsCount];
                        initializeCellsGrid();
                        preys = new Prey[preyCount];
                        predators = new Predator[predatorCount];
                        initializePreys();
                        initializePredators();
                        simulate();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        positionsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                showPositions();
            }
        });
        panel.add(predatorCountLabel, 0, 0);
        panel.add(predatorCountField, 0, 1);
        panel.add(preyCountLabel, 1, 0);
        panel.add(preyCountField, 1, 1);
        panel.add(rowCellsCountLabel, 2, 0);
        panel.add(rowCellsCountField, 2, 1);
        panel.add(columnCellsCountLabel, 3, 0);
        panel.add(columnCellsCountField, 3, 1);
        panel.add(timeStepsCountLabel, 4, 0);
        panel.add(timeStepsCountField, 4, 1);
        panel.add(simulateButton);
        panel.add(positionsButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    //initialize prey
    protected static void initializePreys() throws Exception {
        // TODO Auto-generated method stub
        int preyInitialized = 0;
        if (preyCount <= rowCellsCount * columnCellsCount) {
            for (int i = 0; i < preyCount; i++) {
                int row = rand.nextInt(rowCellsCount);
                //System.out.println(row);
                int col = rand.nextInt(columnCellsCount);
                //System.out.println(col);
                if (cellsGrid[row][col].label.equals("Empty")) {
                    cellsGrid[row][col].label = "Prey";
                    Prey prey = new Prey(cellsGrid[row][col]);
                    preys[i] = prey;
                    preyInitialized++;
                }
            }
            preyCount = preyInitialized;
            System.out.println("Prey initialized:" + preyCount);
        } else
            throw new Exception("Illegal Prey Count!!! Can't initialize.");
    }

    //initialize predators
    protected static void initializePredators() throws Exception {
        // TODO Auto-generated method stub
        int predatorInitialized = 0;
        if (predatorCount <= rowCellsCount * columnCellsCount) {
            for (int i = 0; i < predatorCount; i++) {
                int row = rand.nextInt(rowCellsCount);
                //System.out.println(row);
                int col = rand.nextInt(columnCellsCount);
                //System.out.println(col);
                if (cellsGrid[row][col].label.equals("Empty")) {
                    cellsGrid[row][col].label = "Predator";
                    Predator predator = new Predator(cellsGrid[row][col]);
                    predators[i] = predator;
                    predatorInitialized++;
                }
            }
            predatorCount = predatorInitialized;
            System.out.println("Predator initialized:" + predatorCount);
        } else
            throw new Exception("Illegal Predator Count!!! Can't initialize.");
    }

    //shows positions in cell grid
    protected static void showPositions() {
        // TODO Auto-generated method stub
        for (int i = 0; i < rowCellsCount; i++) {
            for (int j = 0; j < columnCellsCount; j++) {
                if (cellsGrid[i][j].label.equals("Predator")) {
                    System.out.print("x ");
                } else if (cellsGrid[i][j].label.equals("Prey")) {
                    System.out.print("o ");
                } else if (cellsGrid[i][j].label.equals("Empty")) {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    //Performs simulation
    private static void simulate() {
        System.out.println("Performing simulation");

    }

    //initializes cells grid
    private static void initializeCellsGrid() {
        for (int i = 0; i < rowCellsCount; i++) {
            for (int j = 0; j < columnCellsCount; j++) {
                Cell cell = new Cell(i, j, "Empty");
                cellsGrid[i][j] = cell;
            }
        }
    }

    public static void main(String[] args) {
        PredatorPreySimGUI.createAndShowGUI();
    }

}