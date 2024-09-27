package Day05_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

public class PaintBrush extends JFrame {

    private Color currentColor = Color.BLACK;
    private ShapeType currentShape = ShapeType.RECTANGLE;
    private boolean isFreeHand = false;
    private boolean isDotted = false;
    private boolean isFilled = false;
    private BufferedImage canvasImage;
    private Graphics2D g2d;
    private Point startPoint;
    private Stack<BufferedImage> undoStack = new Stack<>();
    private boolean isEraser = false;

    private enum ShapeType {
        RECTANGLE, OVAL, LINE
    }

    public PaintBrush() {
        setTitle("Paint Brush");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize canvas
        canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g2d = canvasImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 800, 600);
        g2d.setColor(currentColor);

        // Toolbar panel
        JPanel toolbar = new JPanel();
        add(toolbar, BorderLayout.NORTH);

        // Color buttons
        JButton redButton = createColorButton("Red", Color.RED);
        JButton greenButton = createColorButton("Green", Color.GREEN);
        JButton blueButton = createColorButton("Blue", Color.BLUE);

        toolbar.add(redButton);
        toolbar.add(greenButton);
        toolbar.add(blueButton);

        // Shape buttons
        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(e -> currentShape = ShapeType.RECTANGLE);
        JButton ovalButton = new JButton("Oval");
        ovalButton.addActionListener(e -> currentShape = ShapeType.OVAL);
        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> currentShape = ShapeType.LINE);

        toolbar.add(rectangleButton);
        toolbar.add(ovalButton);
        toolbar.add(lineButton);

        // Free Hand Button
        JButton freeHandButton = new JButton("Free Hand");
        freeHandButton.addActionListener(e -> isFreeHand = !isFreeHand);
        toolbar.add(freeHandButton);

        // Eraser Button
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(e -> isEraser = !isEraser);
        toolbar.add(eraserButton);

        // Clear All Button
        JButton clearAllButton = new JButton("Clear All");
        clearAllButton.addActionListener(e -> clearAll());
        toolbar.add(clearAllButton);

        // Dotted Checkbox
        JCheckBox dottedCheckBox = new JCheckBox("Dotted");
        dottedCheckBox.addActionListener(e -> isDotted = dottedCheckBox.isSelected());
        toolbar.add(dottedCheckBox);

        // Filled Checkbox
        JCheckBox filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.addActionListener(e -> isFilled = filledCheckBox.isSelected());
        toolbar.add(filledCheckBox);

        // Undo Button
        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> undo());
        toolbar.add(undoButton);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveImage());
        toolbar.add(saveButton);

        // Open Button
        JButton openButton = new JButton("Open");
        openButton.addActionListener(e -> openImage());
        toolbar.add(openButton);

        // Drawing panel
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvasImage, 0, 0, null);
            }
        };
        drawingPanel.setPreferredSize(new Dimension(800, 600));
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                saveUndoState();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point endPoint = e.getPoint();
                if (isEraser) {
                    erase(startPoint, endPoint);
                } else {
                    drawShape(startPoint, endPoint);
                }
                repaint();
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isFreeHand) {
                    drawFreeHand(e.getPoint());
                }
                repaint();
            }
        });

        add(drawingPanel, BorderLayout.CENTER);
    }

    private JButton createColorButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(e -> currentColor = color);
        return button;
    }

    private void drawShape(Point start, Point end) {
        Graphics2D g2d = (Graphics2D) canvasImage.getGraphics();
        g2d.setColor(currentColor);
        if (isDotted) {
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        } else {
            g2d.setStroke(new BasicStroke(2));
        }
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);

        switch (currentShape) {
            case LINE:
                g2d.drawLine(start.x, start.y, end.x, end.y);
                break;
            case RECTANGLE:
                if (isFilled) {
                    g2d.fillRect(x, y, width, height);
                } else {
                    g2d.drawRect(x, y, width, height);
                }
                break;
            case OVAL:
                if (isFilled) {
                    g2d.fillOval(x, y, width, height);
                } else {
                    g2d.drawOval(x, y, width, height);
                }
                break;
        }
        g2d.dispose();
    }

    private void drawFreeHand(Point point) {
        Graphics2D g2d = (Graphics2D) canvasImage.getGraphics();
        g2d.setColor(currentColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(startPoint.x, startPoint.y, point.x, point.y);
        startPoint = point;
        g2d.dispose();
    }

    private void erase(Point start, Point end) {
        Graphics2D g2d = (Graphics2D) canvasImage.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
        g2d.setStroke(new BasicStroke(10)); // Eraser size
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
        g2d.fillRect(x, y, width, height);
        g2d.dispose();
    }

    private void clearAll() {
        saveUndoState();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
        repaint();
    }

    private void saveUndoState() {
        BufferedImage copy = new BufferedImage(canvasImage.getWidth(), canvasImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dCopy = copy.createGraphics();
        g2dCopy.drawImage(canvasImage, 0, 0, null);
        g2dCopy.dispose();
        undoStack.push(copy);
    }

    private void undo() {
        if (!undoStack.isEmpty()) {
            canvasImage = undoStack.pop();
            g2d = canvasImage.createGraphics();
            repaint();
        }
    }

    private void saveImage() {
        try {
            ImageIO.write(canvasImage, "png", new File("drawing.png"));
            JOptionPane.showMessageDialog(this, "Image saved!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving image.");
        }
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage loadedImage = ImageIO.read(fileChooser.getSelectedFile());
                canvasImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                g2d = canvasImage.createGraphics();
                g2d.drawImage(loadedImage, 0, 0, null);
                g2d.dispose();
                repaint();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening image.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaintBrush().setVisible(true));


    }}