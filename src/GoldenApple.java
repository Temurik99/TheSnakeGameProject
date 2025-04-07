import java.awt.*;

public class GoldenApple extends Apple {
    public GoldenApple(int row, int col) {
        super(row, col);
    }


    @Override
    public void draw(Graphics g) {
        int x = col * GamePanel.CELL_SIZE;
        int y = row * GamePanel.CELL_SIZE;
        g.setColor(Color.YELLOW);
        g.fillOval(x + 4, y + 4, GamePanel.CELL_SIZE - 8, GamePanel.CELL_SIZE - 8);
    }
}

