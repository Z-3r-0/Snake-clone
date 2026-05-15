import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        Grid gridPanel = new Grid(frame, 10);

        frame.add(gridPanel);
        frame.revalidate();
        frame.repaint();
    }
}