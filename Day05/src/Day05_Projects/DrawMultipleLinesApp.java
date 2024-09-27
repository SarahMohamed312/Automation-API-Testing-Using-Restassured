package Day05_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawMultipleLinesApp extends JFrame {

    private List<Line> lines = new ArrayList<>(); // List to store all drawn lines
    private Line currentLine; // The line being drawn currently

    public DrawMultipleLinesApp() {
        // Set up the frame
        setTitle("Draw Multiple Lines Application");
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
                    // Start drawing a new line
                    currentLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Finish drawing the current line and store it
                    if (currentLine != null) {
                        currentLine.setEndX(e.getX());
                        currentLine.setEndY(e.getY());
                        lines.add(currentLine);
                        currentLine = null; // Reset the current line
                        repaint(); // Repaint the panel to show all lines
                    }
                }
            });

            // Add mouse motion listener for drawing while dragging
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // Update the current line's end point as the mouse is dragged
                    if (currentLine != null) {
                        currentLine.setEndX(e.getX());
                        currentLine.setEndY(e.getY());
                        repaint(); // Repaint the panel to update the line
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw all stored lines
            for (Line line : lines) {
                g.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
            }
            // Draw the current line being dragged
            if (currentLine != null) {
                g.drawLine(currentLine.getStartX(), currentLine.getStartY(), currentLine.getEndX(), currentLine.getEndY());
            }
        }
    }

    private static class Line {
        private int startX, startY, endX, endY;

        public Line(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int getStartX() { return startX; }
        public int getStartY() { return startY; }
        public int getEndX() { return endX; }
        public int getEndY() { return endY; }

        public void setEndX(int endX) { this.endX = endX; }
        public void setEndY(int endY) { this.endY = endY; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawMultipleLinesApp());
    }
}
