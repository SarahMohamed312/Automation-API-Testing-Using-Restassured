package EX4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeApp {

    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("Date and Time Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        // Create a JLabel to display the date and time
        JLabel dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(dateTimeLabel, BorderLayout.CENTER);

        // Create a Timer to update the date and time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current date and time
                String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                // Update the label text
                dateTimeLabel.setText(currentDateTime);
            }
        });
        timer.start();

        frame.setVisible(true);
    }

    private static class LIGHT {
    }
}
