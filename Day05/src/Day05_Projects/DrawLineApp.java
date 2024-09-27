package Day05_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLineApp extends JFrame {

    private int startX, startY; // Starting point of the line
    private int endX, endY; // Ending point of the line
    private boolean isDragging = false; // Flag to check if dragging is in progress

    public DrawLineApp() {
        // Set up the frame
        setTitle("Draw Line Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);

        // Make the frame visible
        setVisible(true);
    }

    private class DrawingPanel extends JPanel {

        public DrawingPanel() {
            // Add mouse listener for drawing
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Start drawing
                    startX = e.getX();
                    startY = e.getY();
                    isDragging = true;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // End drawing
                    endX = e.getX();
                    endY = e.getY();
                    isDragging = false;
                    repaint(); // Repaint the panel to draw the line
                }
            });

            // Add mouse motion listener for drawing while dragging
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // Update the ending point as the mouse is dragged
                    endX = e.getX();
                    endY = e.getY();
                    repaint(); // Repaint the panel to update the line
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (isDragging || !isDragging && startX != endX && startY != endY) {
                g.drawLine(startX, startY, endX, endY);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawLineApp());
    }
}
