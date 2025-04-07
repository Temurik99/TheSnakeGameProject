import java.util.ArrayList;
import java.util.List;

enum Direction { UP, DOWN, LEFT, RIGHT }

public class Snake {
    private List<GameObject> segments = new ArrayList<>();
    private Direction dir = Direction.RIGHT;

    public Snake(int startRow, int startCol) {
        for (int i = 0; i < 3; i++) {
            segments.add(new SnakeSegment(startRow, startCol - i));
        }
    }

    public void setDirection(Direction d) {
        dir = d;
    }

    public int getLength() {
        return segments.size();
    }

    public void draw(java.awt.Graphics g) {
        for (GameObject seg : segments) {
            seg.draw(g);
        }
    }

    public boolean move(Cell[][] board, Apple apple) {
        GameObject head = segments.get(0);
        int newRow = head.getRow();
        int newCol = head.getCol();

        switch (dir) {
            case UP    -> newRow--;
            case DOWN  -> newRow++;
            case LEFT  -> newCol--;
            case RIGHT -> newCol++;
        }

        newRow = (newRow + GamePanel.ROWS) % GamePanel.ROWS;
        newCol = (newCol + GamePanel.COLS) % GamePanel.COLS;

        segments.add(0, new SnakeSegment(newRow, newCol));

        if (newRow == apple.getRow() && newCol == apple.getCol()) {
            return true;
        } else {
            segments.remove(segments.size() - 1);
            return false;
        }
    }

    public boolean checkSelfCollision() {
        GameObject head = segments.get(0);
        for (int i = 1; i < segments.size(); i++) {
            if (head.getRow() == segments.get(i).getRow()
                    && head.getCol() == segments.get(i).getCol()) {
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return dir;
    }

}

