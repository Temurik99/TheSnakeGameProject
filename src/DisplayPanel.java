import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

// this class is a subclass of JPanel
public class DisplayPanel extends JPanel {

    public DisplayPanel() { }

    /* the system calls the paintComponent method automatically when
       you add the DisplayPanel to the frame in order to "paint it" onto
       the frame (i.e. display it); NEVER call this method explicitly!! */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // always put this

        // set font and color of text
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);

        // display red text at position x = 50, y = 30;
        // note that (0, 0) is TOP LEFT corner (not bottom left),
        // and +x direction is to the right, and +y direction is DOWN (not up)
        g.drawString("This is the display panel!", 50, 50);
    }
}
