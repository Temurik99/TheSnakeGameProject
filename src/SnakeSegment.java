import java.awt.*;

public class SnakeSegment extends GameObject {
    public SnakeSegment(int row, int col) { super(row, col); }
    @Override public void draw(Graphics g) {
        int x = col * GamePanel.CELL_SIZE, y = row * GamePanel.CELL_SIZE;
        g.setColor(Color.GREEN);
        g.fillRect(x, y, GamePanel.CELL_SIZE, GamePanel.CELL_SIZE);
    }
}

