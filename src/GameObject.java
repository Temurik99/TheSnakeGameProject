import java.awt.*;

public abstract class GameObject {
    protected int row, col;

    public GameObject(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getRow() { return row; }
    public int getCol() { return col; }

    public abstract void draw(Graphics g);
}

