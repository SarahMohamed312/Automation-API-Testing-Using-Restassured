package EX4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Lamp extends JPanel {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Lamp Drawing");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom panel to the frame
        Lamp_Panel lampPanel = new Lamp_Panel();
        frame.add(lampPanel);

        // Set the frame visibility
        frame.setVisible(true);
    }
}

class Lamp_Panel extends JPanel implements ActionListener {
    private Color lightColor = Color.YELLOW;
    private Timer timer;
    private boolean transitioningToWhite = true;

    public Lamp_Panel() {
        // Set up the timer to update the light color
        timer = new Timer(50, this); // Adjust the delay for animation speed
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLamp(g);
    }

    private void drawLamp(Graphics g) {
        // Draw lamp light
        g.setColor(lightColor);
        g.fillOval(132, 150, 30, 30); // Light part of the lamp

        // Draw the lamp base
        g.setColor(Color.DARK_GRAY);
        g.fillRect(80, 250, 135, 20); // Base rectangle

        // Draw the lamp post
        g.drawLine(125, 250, 125, 160); // Left post
        g.drawLine(175, 250, 175, 160); // Right post

        // Draw the lamp shade (arcs)
        g.drawArc(85, 157, 130, 50, -65, 312); // Bottom arc of the shade
        g.drawArc(85, 87, 130, 50, 62, 58); // Top arc of the shade

        // Draw the lamp support lines
        g.drawLine(85, 177, 119, 89); // Left support line
        g.drawLine(215, 177, 181, 89); // Right support line

        // Draw red parts (decorative elements)
        g.setColor(Color.RED);
        g.fillArc(78, 120, 40, 40, 63, -174); // Left red arc
        g.drawOval(120, 96, 40, 40); // Center red oval
        g.fillArc(173, 100, 40, 40, 110, 180); // Right red arc
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Animate the light color between yellow and white
        if (transitioningToWhite) {
            // Transition to white
            lightColor = lightColor.brighter();
            if (lightColor.getRed() >= 255) {
                transitioningToWhite = false;
            }
        } else {
            // Transition back to yellow
            lightColor = lightColor.darker();
            if (lightColor.getRed() <= 255) {
                transitioningToWhite = true;
            }
        }
        repaint(); // Repaint the
    }}