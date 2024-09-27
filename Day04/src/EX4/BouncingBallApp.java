package EX4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Ball");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setResizable(false);

            BouncingBallPanel panel = new BouncingBallPanel();
            frame.add(panel);
            frame.setVisible(true);

            // Start the animation thread
            new Thread(panel).start();
        });
    }
}

class BouncingBallPanel extends JPanel implements Runnable {
    private static final int BALL_SIZE = 30;
    private static final int BALL_SPEED = 5;
    private int x = 0;
    private int y = 0;
    private int xSpeed = BALL_SPEED;
    private int ySpeed = BALL_SPEED;

    public BouncingBallPanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void run() {
        while (true) {
            // Update ball position
            x += xSpeed;
            y += ySpeed;

            // Check for bouncing
            if (x <= 0 || x + BALL_SIZE >= getWidth()) {
                xSpeed = -xSpeed;
            }
            if (y <= 0 || y + BALL_SIZE >= getHeight()) {
                ySpeed = -ySpeed;
            }

            // Repaint the panel
            repaint();

            try {
                Thread.sleep(10); // Control the speed of the animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

