package Day05_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    private int counter = 0; // Initial counter value
    private JLabel counterLabel;

    public CounterApp() {
        // Set up the frame
        setTitle("Counter Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color of the content pane to cyan
        getContentPane().setBackground(Color.CYAN);

        // Set layout for the frame
        setLayout(new FlowLayout()); // Simple layout

        // Create and add the counter label
        counterLabel = new JLabel("Counter: " + counter);
        add(counterLabel);

        // Create increment button
        JButton incrementButton = new JButton("Increment");
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                updateCounterLabel();
            }
        });
        add(incrementButton);

        // Create decrement button
        JButton decrementButton = new JButton("Decrement");
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                updateCounterLabel();
            }
        });
        add(decrementButton);

        // Make the frame visible
        setVisible(true);
    }

    private void updateCounterLabel() {
        counterLabel.setText("Counter: " + counter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CounterApp();
            }
        });
    }
}
