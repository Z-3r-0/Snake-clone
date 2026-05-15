import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Grid extends JPanel {

    private final int width;
    private final Cell[][] cells;

    Grid(JFrame window, int width) {
        this.width = width;
        this.cells = new Cell[width][width];

        int usableHeight = window.getHeight() - window.getInsets().top - window.getInsets().bottom;
        int usableWidth = window.getWidth() - window.getInsets().left - window.getInsets().right;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {

                int cellWidth = (Integer.min(usableWidth, usableHeight) / this.width);

                System.out.println(cellWidth);

                cells[i][j] = new Cell(i * cellWidth, j * cellWidth, cellWidth, new Color(100, 100, 100));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell == null) continue;

                cell.paintComponent(g);
            }
        }
    }
}
