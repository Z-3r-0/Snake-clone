import javax.swing.*;

public class Window {

    private final JFrame frame;

    Window() {
        this.frame = new JFrame("Grid Example");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 800);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}