import javax.swing.*;
import java.awt.*;

public class MarqueeApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame instance
            JFrame frame = new JFrame("Continuous Marquee");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Create a MarqueePanel to display the scrolling text
            MarqueePanel marqueePanel = new MarqueePanel("Hello World! ");
            frame.add(marqueePanel, BorderLayout.CENTER);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}

class MarqueePanel extends JPanel implements Runnable {
    private final JLabel marqueeLabel;
    private int offset = 0;
    private final int scrollSpeed = 2; // Speed of scrolling

    public MarqueePanel(String text) {
        setLayout(null);
        setBackground(Color.BLACK);

        // Create a JLabel with the text
        marqueeLabel = new JLabel(text + text); // Duplicate text to ensure continuous scroll
        marqueeLabel.setForeground(Color.WHITE);
        marqueeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        // Calculate the initial bounds for the label
        int textWidth = marqueeLabel.getPreferredSize().width;
        marqueeLabel.setBounds(0, 20, textWidth * 2, 50); // Set the width to accommodate duplicated text

        add(marqueeLabel);

        // Start the scrolling thread
        new Thread(this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Update label's location based on offset
        marqueeLabel.setLocation(offset, marqueeLabel.getY());
    }

    @Override
    public void run() {
        int textWidth = marqueeLabel.getPreferredSize().width;
        while (true) {
            offset -= scrollSpeed; // Move text left
            if (offset + textWidth < 0) {
                offset = getWidth(); // Reset position when off-screen
            }
            repaint();
            try {
                Thread.sleep(20); // Adjust speed here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
