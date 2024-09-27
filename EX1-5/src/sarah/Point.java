package sarah;

public class Point {
    private int x;
    private int y;

    // Constructor to initialize the coordinates
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to print the coordinates
    public void printCoordinates() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }
}