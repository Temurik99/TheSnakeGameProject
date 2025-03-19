import javax.swing.JFrame;

public class SampleFrame {

    public SampleFrame() {
        JFrame frame = new JFrame("Frame title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        // create a DisplayPanel object
        DisplayPanel panel = new DisplayPanel();

        // add it to the frame
        frame.add(panel);

        frame.setVisible(true);
    }
}
