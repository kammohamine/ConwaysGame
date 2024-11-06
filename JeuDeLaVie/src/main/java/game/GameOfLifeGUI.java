package game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeGUI extends JFrame {
    private final int CELL_SIZE = 20;
    private final Grid grid;
    private JPanel gridPanel;
    private Timer timer;

    public GameOfLifeGUI(int rows, int cols) {
        this.grid = new Grid(rows, cols);
        setTitle("Jeu de la vie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(cols * CELL_SIZE, rows * CELL_SIZE);
        setLayout(new BorderLayout());

        gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };
        gridPanel.setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
        add(gridPanel, BorderLayout.CENTER);

        grid.initializeGrid();

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.updateGrid();
                gridPanel.repaint();  // Rafraîchit l'affichage de la grille
            }
        });
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                Cell cell = grid.getCell(i, j);
                if (cell.isAlive()) {
                    g.setColor(Color.WHITE);  // Couleur des cellules vivantes
                } else {
                    g.setColor(Color.BLACK);  // Couleur des cellules mortes
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);  // Bordure de la grille
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public void startSimulation() {
        timer.start();
    }

    public static void main(String[] args) {
        GameOfLifeGUI gui = new GameOfLifeGUI(30, 30);  // Exemple avec une grille 30x30
        gui.setVisible(true);
        gui.startSimulation();
    }
}
