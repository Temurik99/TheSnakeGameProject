import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int CELL_SIZE = 20, COLS = 30, ROWS = 30;
    private Timer timer;
    private Snake snake;

    public GamePanel() {
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        snake = new Snake(ROWS/2, COLS/2);
        timer = new Timer(150, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();                // move based on current direction
        if (snake.checkSelfCollision()) {
            timer.stop();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP    -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_DOWN  -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_LEFT  -> snake.setDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
        }
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e)    {}
}


