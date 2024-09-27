package Day05_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MoveTextApp extends JFrame {

    private int x = 100; // Initial X position of the text
    private int y = 100; // Initial Y position of the text
    private final int STEP = 10; // Number of pixels to move the text

    public MoveTextApp() {
        // Set up the frame
        setTitle("Move Text Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the custom panel for drawing text
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);

        // Add a key listener to handle arrow key inputs
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        x -= STEP; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += STEP; // Move right
                        break;
                    case KeyEvent.VK_UP:
                        y -= STEP; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        y += STEP; // Move down
                        break;
                }
                drawingPanel.repaint(); // Repaint the panel to reflect changes
            }
        });

        // Make the frame visible
        setVisible(true);
        setFocusable(true); // Make sure the frame can receive key events
    }

    // Custom JPanel to draw text
    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Hello Java", x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MoveTextApp());
    }
}
