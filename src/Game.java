import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    private final Window window;
    private final Grid grid;
    private final Snake snake;
    private final Timer timer;

    Game() {
        this.window = new Window();
        this.grid = new Grid(window.getFrame(), 11);
        this.snake = new Snake(grid);
        this.timer = new Timer(16, this);

        this.window.getFrame().add(grid);
        this.window.getFrame().revalidate();
    }

    public void start() {
        this.timer.start();
    }

    private void update() {
        snake.move();
    }

    private void draw() {
        this.window.getFrame().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        draw();
    }
}
