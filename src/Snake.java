import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

enum Direction { UP, DOWN, LEFT, RIGHT }

public class Snake {
    private List<GameObject> segments = new ArrayList<>();
    private Direction dir = Direction.RIGHT;

    public Snake(int r, int c) {
        for (int i = 0; i < 3; i++) {
            segments.add(new SnakeSegment(r, c - i));
        }
    }

    public void setDirection(Direction d) { dir = d; }

    public void draw(Graphics g) {
        for (GameObject seg : segments) seg.draw(g);
    }

    public void move() {
        GameObject head = segments.get(0);
        int newR = head.row, newC = head.col;
        switch (dir) {
            case UP    -> newR--;
            case DOWN  -> newR++;
            case LEFT  -> newC--;
            case RIGHT -> newC++;
        }
        newR = (newR + GamePanel.ROWS) % GamePanel.ROWS;
        newC = (newC + GamePanel.COLS) % GamePanel.COLS;
        segments.add(0, new SnakeSegment(newR, newC));
        segments.remove(segments.size() - 1);
    }

    public boolean checkSelfCollision() {
        GameObject head = segments.get(0);
        for (int i = 1; i < segments.size(); i++) {
            if (head.row == segments.get(i).row && head.col == segments.get(i).col) {
                return true;
            }
        }
        return false;
    }
}


