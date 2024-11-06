package game;
public class GameOfLife {
    private Grid grid;
    private int generation;
    private boolean isRunning;

    public GameOfLife(int rows, int cols) {
        this.grid = new Grid(rows, cols);
        this.generation = 0;
        this.isRunning = false;
    }

    public void initialize() {
        grid.initializeGrid();
    }

    public void start() {
        this.isRunning = true;
        System.out.println("Game started.");
    }

    public void nextGeneration() {
        grid.updateGrid();
        generation++;
    }

    public void displayGrid() {
        System.out.println("Generation " + generation + ":");
        grid.display();
    }

    public void setInitialPattern(String pattern) {
    }

    public void runSimulation() {
        while (isRunning && !hasStabilized()) {
            displayGrid();
            nextGeneration();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hasStabilized() {
        return false;
    }
}
