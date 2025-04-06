import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static final int CELL_SIZE = 20;
    public static final int COLS = 30;
    public static final int ROWS = 30;

    private Snake snake;

    public GamePanel() {
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.BLACK);
        snake = new Snake(ROWS/2, COLS/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
    }
}

