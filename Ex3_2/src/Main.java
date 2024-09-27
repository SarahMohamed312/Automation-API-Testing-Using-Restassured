import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {


        // Create the main frame
        JFrame frame = new JFrame("Available Fonts");
        frame.setSize(800, 600);
        FontListPanel fontListPanel = new FontListPanel();
        frame.add(fontListPanel);

        // Set the frame visibility
        frame.setVisible(true);
    }
}
class FontListPanel extends JPanel {

    public FontListPanel() {
        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Get all available fonts
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        // Create a JTextArea to display fonts
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 12));

        // Append each font name to the JTextArea with its corresponding font
        for (String fontName : fontNames) {
            textArea.append(fontName + "\n");
            textArea.setFont(new Font(fontName, Font.PLAIN, 16));
            textArea.append("This is sample text in " + fontName + "\n\n");
        }

        // Add the JTextArea to the panel inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
    }
}
