import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private int x, y;
    private int size;
    private Color color;
    private CellType cellType;

    Cell(int x, int y, int size, Color color, CellType cellType) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.cellType = cellType;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        g.setColor(this.color);

        // We want square cells
        g.fillRect(this.x, this.y, this.size, this.size);

        // Draw the box
        g.setColor(Color.LIGHT_GRAY);

        g.drawRect(this.x, this.y, this.size, this.size);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() { return this.cellType; }
}
