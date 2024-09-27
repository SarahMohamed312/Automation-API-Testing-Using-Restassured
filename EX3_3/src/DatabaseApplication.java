import javax.swing.*;
import java.awt.*;
public class DatabaseApplication {

       public static void main(String[] args) {
             // Create the main frame
             JFrame frame = new JFrame("Database Application");
             frame.setSize(800, 800);

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
             JButton save = new JButton("Save");
             save.setBounds(600, 70, 100, 25);
             frame.add(save);

             JButton update = new JButton("Update");
             update.setBounds(600, 100, 100, 25);
             frame.add(update);

             JButton delete = new JButton("Delete");
             delete.setBounds(600, 130, 100, 25);
             frame.add(delete);

             JButton clear = new JButton("Clear");
             clear.setBounds(600, 160, 100, 25);
             frame.add(clear);


             JButton exist = new JButton("Exit");
             exist.setBounds(600, 190, 100, 25);
             frame.add(exist);

             frame.setVisible(true);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       }}
//Using AWT farmework
/*

// Create the main frame
        Frame frame = new Frame("Database Application");
        frame.setSize(800, 400); // Size of the frame
        frame.setLayout(null);

        // Create and position labels
        Label label1 = new Label("Code:");
        Label label2 = new Label("Name:");
        Label label3 = new Label("Salary:");

        label1.setBounds(70, 70, 100, 30);
        label2.setBounds(70, 110, 100, 30);
        label3.setBounds(70, 150, 100, 30);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        // Create and position text fields
        TextField codeField = new TextField();
        TextField nameField = new TextField();
        TextField salaryField = new TextField();

        codeField.setBounds(170, 70, 150, 25);
        nameField.setBounds(170, 110, 150, 25);
        salaryField.setBounds(170, 150, 150, 25);

        frame.add(codeField);
        frame.add(nameField);
        frame.add(salaryField);

        // Create and position buttons
        Button saveButton = new Button("Save");
        saveButton.setBounds(600, 70, 100, 25);
        frame.add(saveButton);

        Button updateButton = new Button("Update");
        updateButton.setBounds(600, 100, 100, 25);
        frame.add(updateButton);

        Button deleteButton = new Button("Delete");
        deleteButton.setBounds(600, 130, 100, 25);
        frame.add(deleteButton);

        Button clearButton = new Button("Clear");
        clearButton.setBounds(600, 160, 100, 25);
        frame.add(clearButton);

        Button exitButton = new Button("Exit");
        exitButton.setBounds(600, 190, 100, 25);
        frame.add(exitButton);


        // Make the frame visible
        frame.setVisible(true);
 */