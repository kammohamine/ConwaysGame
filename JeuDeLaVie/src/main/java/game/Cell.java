package game;

public class Cell {
    private boolean isAlive;
    private boolean nextState;

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void determineNextState(int liveNeighbors) {
        if (isAlive) {
            nextState = (liveNeighbors == 2 || liveNeighbors == 3);
        } else {
            nextState = (liveNeighbors == 3);
        }
    }

    public void updateState() {
        isAlive = nextState;
    }
}
