import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Database Application");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute positioning

        // Create and position labels
        JLabel label1 = new JLabel("Code:");
        JLabel label2 = new JLabel("Name:");
        JLabel label3 = new JLabel("Salary:");

        label1.setBounds(70, 70, 100, 30);
        label2.setBounds(70, 110, 100, 30);
        label3.setBounds(70, 150, 100, 30);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        // Create and position text fields
        JTextField codeField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField salaryField = new JTextField();

        codeField.setBounds(170, 70, 150, 25);
        nameField.setBounds(170, 110, 150, 25);
        salaryField.setBounds(170, 150, 150, 25);

        frame.add(codeField);
        frame.add(nameField);
        frame.add(salaryField);

        // Make the frame visible
        frame.setVisible(true);
    }
}
