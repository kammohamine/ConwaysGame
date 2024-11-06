package game;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<List<Cell>> cells;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
        initializeGrid();
    }

    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }

    public void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell();
                if (Math.random() > 0.7) {
                    cell.setAlive(true);
                }
                row.add(cell);
            }
            cells.add(row);
        }
    }

    public Cell getCell(int x, int y) {
        return cells.get(x).get(y);
    }

    public int countLiveNeighbors(int x, int y) {
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignore la cellule elle-même
                int neighborX = x + i;
                int neighborY = y + j;
                if (isInBounds(neighborX, neighborY) && getCell(neighborX, neighborY).isAlive()) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public void updateGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = cells.get(i).get(j);
                int liveNeighbors = countLiveNeighbors(i, j);
                cell.determineNextState(liveNeighbors);
            }
        }
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.updateState();
            }
        }
    }

    public void display() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                System.out.print(cell.isAlive() ? "O " : ". ");
            }
            System.out.println();
        }
    }
}
