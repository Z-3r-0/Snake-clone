import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private final int x, y;
    private final int width;
    private Color color;

    Cell(int x, int y, int width, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.width);

        // Draw the box
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(this.x, this.y, this.width, this.width);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
