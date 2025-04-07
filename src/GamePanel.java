import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int CELL_SIZE = 20;
    public static final int COLS = 30;
    public static final int ROWS = 30;

    private Timer timer;
    private Cell[][] board;
    private Snake snake;
    private Apple apple;
    private Random rand = new Random();

    public GamePanel() {
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        board = new Cell[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = new Cell(r, c);
            }
        }
    }

    public void startGame() {
        snake = new Snake(ROWS/2, COLS/2);
        placeApple();
        timer = new Timer(100, this);
        timer.start();
    }

    private void placeApple() {
        int r, c;
        do {
            r = rand.nextInt(ROWS);
            c = rand.nextInt(COLS);
        } while (board[r][c].hasApple());
        apple = new Apple(r, c);
        board[r][c].setApple(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c].draw(g);
            }
        }
        snake.draw(g);
        apple.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (snake.move(board, apple)) {
            board[apple.getRow()][apple.getCol()].setApple(false);
            placeApple();
        }
        if (snake.checkSelfCollision()) {
            timer.stop();
            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Game Over! Score: " + snake.getLength(),
                    "Snake Game",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[] { "Restart" },
                    "Restart"
            );
            if (choice == 0) {
                resetGame();
            }
        }
        repaint();
    }

    // Add this helper to reset everything
    private void resetGame() {
        // Clear board apples
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c].setApple(false);
            }
        }
        startGame();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction current = snake.getDirection();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (current != Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (current != Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                }
            }
            case KeyEvent.VK_LEFT -> {
                if (current != Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (current != Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                }
            }
        }
    }
    @Override public void keyReleased(KeyEvent e) { }
    @Override public void keyTyped(KeyEvent e)    { }
}

