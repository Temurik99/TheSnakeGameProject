import java.awt.*;

public class Cell {
    private final int row, col;
    private boolean hasApple = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setApple(boolean val) {
        hasApple = val;
    }

    public boolean hasApple() {
        return hasApple;
    }



    public void draw(Graphics g) {
        int x = col * GamePanel.CELL_SIZE;
        int y = row * GamePanel.CELL_SIZE;
        g.setColor(Color.DARK_GRAY);
        g.drawRect(x, y, GamePanel.CELL_SIZE, GamePanel.CELL_SIZE);
        if (hasApple) {
            g.setColor(Color.RED);
            g.fillOval(x + 4, y + 4, GamePanel.CELL_SIZE - 8, GamePanel.CELL_SIZE - 8);
        }
    }
}

