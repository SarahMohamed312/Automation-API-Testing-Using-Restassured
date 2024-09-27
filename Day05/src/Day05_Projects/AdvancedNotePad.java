package Day05_Projects;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

    public class AdvancedNotePad extends JFrame implements ActionListener {
        private JTextArea textArea;
        private JFileChooser fileChooser;

        public AdvancedNotePad() {
            // Set up the frame
            setTitle("Simple Text Editor");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create the text area
            textArea = new JTextArea();
            add(new JScrollPane(textArea), BorderLayout.CENTER);

            // Create the menu bar
            JMenuBar menuBar = new JMenuBar();

            // File menu
            JMenu fileMenu = new JMenu("File");
            JMenuItem openItem = new JMenuItem("Open");
            JMenuItem saveItem = new JMenuItem("Save");

            openItem.addActionListener(this);
            saveItem.addActionListener(this);

            fileMenu.add(openItem);
            fileMenu.add(saveItem);
            menuBar.add(fileMenu);

            // Edit menu
            JMenu editMenu = new JMenu("Edit");
            JMenuItem copyItem = new JMenuItem("Copy");
            JMenuItem cutItem = new JMenuItem("Cut");
            JMenuItem pasteItem = new JMenuItem("Paste");
            JMenuItem deleteItem = new JMenuItem("Delete");

            copyItem.addActionListener(this);
            cutItem.addActionListener(this);
            pasteItem.addActionListener(this);
            deleteItem.addActionListener(this);

            editMenu.add(copyItem);
            editMenu.add(cutItem);
            editMenu.add(pasteItem);
            editMenu.add(deleteItem);
            menuBar.add(editMenu);

            setJMenuBar(menuBar);

            // Initialize the file chooser
            fileChooser = new JFileChooser();

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Open")) {
                int returnValue = fileChooser.showOpenDialog(this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (command.equals("Save")) {
                int returnValue = fileChooser.showSaveDialog(this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (command.equals("Copy")) {
                textArea.copy();
            } else if (command.equals("Cut")) {
                textArea.cut();
            } else if (command.equals("Paste")) {
                textArea.paste();
            } else if (command.equals("Delete")) {
                int start = textArea.getSelectionStart();
                int end = textArea.getSelectionEnd();
                if (start != end) {
                    textArea.replaceRange("", start, end);
                }
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(AdvancedNotePad::new);
        }
    }

