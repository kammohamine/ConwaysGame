import game.GameOfLife;

public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(10, 10); // Exemple avec une grille 10x10
        game.initialize();
        game.start();
        game.runSimulation();
    }
}
