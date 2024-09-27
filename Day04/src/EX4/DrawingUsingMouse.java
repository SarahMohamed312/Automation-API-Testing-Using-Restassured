package EX4;

import java.awt.*;
import java.awt.event.*;
// implements MouseListener
public class DrawingUsingMouse implements MouseListener, MouseMotionListener {
    Frame frame;
    Label l;

    DrawingUsingMouse (){

        // Create a frame
        frame = new Frame("MouseListener Example");

        // Create a label
        l = new Label("Test events");

        // Set the properties of label
        l.setBounds(70, 50, 250, 20);
        l.setAlignment(Label.CENTER);
        l.setFont(new Font("Serif", Font.BOLD, 18));
        l.setForeground(Color.blue);

        // Add label to the frame
        frame.add(l);

        // Add MouseListener to the frame
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);

        // Set the properties of frame
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DrawingUsingMouse ();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Graphics g = frame.getGraphics();
        g.setColor(Color.blue);
        g.fillOval(e.getX()-5, e.getY()-5, 10, 10);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = frame.getGraphics();
        g.setColor(Color.blue);
        g.fillOval(e.getX()-5, e.getY()-5, 10, 10);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}