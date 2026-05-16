import java.awt.*;
import java.util.LinkedList;

enum Orientation {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

public class Snake {
    private int size;
    private Orientation orientation;
    private final LinkedList<Cell> body;
    private final Grid grid;

    public Snake(Grid grid) {
        this.size = 3; // Starting with a length of 3 to make wrapping visible!
        this.orientation = Orientation.RIGHT;
        this.grid = grid;
        this.body = new LinkedList<>();

        int middle = grid.getGridSize() / 2;
        Cell[][] cells = grid.getCells();

        // Initialize snake segments horizontally in the middle row
        for (int i = 0; i < size; i++) {
            Cell c = cells[middle - i][middle];
            c.setColor(new Color(0, 255, 0));
            c.setCellType(CellType.SNAKE);
            this.body.addLast(c); // Head is first element, trailing tail segments follow
        }
    }

    public void setOrientation(Orientation orientation) {
        // Prevent reversing directly into oneself
        if ((this.orientation == Orientation.UP && orientation == Orientation.DOWN) ||
                (this.orientation == Orientation.DOWN && orientation == Orientation.UP) ||
                (this.orientation == Orientation.LEFT && orientation == Orientation.RIGHT) ||
                (this.orientation == Orientation.RIGHT && orientation == Orientation.LEFT)) {
            return;
        }
        this.orientation = orientation;
    }

    public void move() {
        Cell currentHead = body.getFirst();
        Cell[][] cells = grid.getCells();
        int totalCells = grid.getGridSize();

        int headI = -1, headJ = -1;

        // Locating current head index positions
        for (int i = 0; i < totalCells; i++) {
            for (int j = 0; j < totalCells; j++) {
                if (cells[i][j] == currentHead) {
                    headI = i;
                    headJ = j;
                    break;
                }
            }
        }

        int nextI = headI;
        int nextJ = headJ;

        switch (this.orientation) {
            case UP:    nextJ--; break;
            case DOWN:  nextJ++; break;
            case LEFT:  nextI--; break;
            case RIGHT: nextI++; break;
        }

        // --- Modulus Teleportation Logic ---
        nextI = (nextI + totalCells) % totalCells;
        nextJ = (nextJ + totalCells) % totalCells;

        Cell nextHeadCell = cells[nextI][nextJ];

        // Self-collision detection
        if (nextHeadCell.getCellType() == CellType.SNAKE && nextHeadCell != body.getLast()) {
            System.out.println("Game Over! You bit your tail.");
            return;
        }

        // Update new head
        nextHeadCell.setColor(new Color(0, 255, 0));
        nextHeadCell.setCellType(CellType.SNAKE);
        body.addFirst(nextHeadCell);

        // Manage tail trimming
        if (body.size() > this.size) {
            Cell tail = body.removeLast();
            tail.setColor(new Color(50, 50, 50)); // Match standard grid background
            tail.setCellType(CellType.GRID);
        }
    }
}