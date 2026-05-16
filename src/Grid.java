import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Grid extends JPanel {

    private final int gridSize;
    private final Cell[][] cells;

    Grid(JFrame window, int gridSize) {
        this.gridSize = gridSize;
        this.cells = new Cell[gridSize][gridSize];

        int usableHeight = window.getHeight() - window.getInsets().top - window.getInsets().bottom;
        int usableWidth = window.getWidth() - window.getInsets().left - window.getInsets().right;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                int cellWidth = (Integer.min(usableWidth, usableHeight) / this.gridSize);

                cells[i][j] = new Cell(i * cellWidth, j * cellWidth, cellWidth, new Color(100, 100, 100), CellType.GRID);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Get the current actual size of THIS panel dynamically
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calculate the cell size based on the available space right now
        int cellWidth = Math.min(panelWidth, panelHeight) / this.gridSize;

        // Dynamically position and draw each cell
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = cells[i][j];
                if (cell == null) continue;

                // Update the cell's properties before painting it
                cell.setX(i * cellWidth);
                cell.setY(j * cellWidth);
                cell.setSize(cellWidth);

                cell.paintComponent(g);
            }
        }
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public int getGridSize() {
        return this.gridSize;
    }
}
