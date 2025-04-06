import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> segments = new ArrayList<>();

    public Snake(int startRow, int startCol) {
        // three segments in a row
        for (int i = 0; i < 3; i++) {
            segments.add(new SnakeSegment(startRow, startCol - i));
        }
    }

    public void draw(Graphics g) {
        for (GameObject seg : segments) {
            seg.draw(g);
        }
    }
}

