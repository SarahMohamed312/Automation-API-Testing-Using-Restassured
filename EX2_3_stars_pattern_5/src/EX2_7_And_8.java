import java.util.Scanner;

public class EX2_7_And_8 {


    public static void main(String[] args) {

// Print equilateral triangle pattern
       /* System.out.print("Enter the number of rows for the equilateral triangle: ");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();

    // Validate the input
        if (rows <= 0) {
        System.out.println("Error: Number of rows must be a positive integer.");
        return;
    }

    // Print the equilateral triangle pattern
        for (int i = 1; i <= rows; i++) {
        // Print leading spaces for alignment
        for (int j = 1; j <= rows - i; j++) {
            System.out.print(" ");
        }
        // Print stars
        for (int k = 1; k <= (2 * i - 1); k++) {
            System.out.print("*");
        }
        // Move to the next line
        System.out.println();
    }*/
        // Print the inverted equilateral triangle pattern
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of rows
        System.out.print("Enter the number of rows for the inverted equilateral triangle: ");
        int rows = scanner.nextInt();

        // Validate the input
        if (rows <= 0) {
            System.out.println("Error: Number of rows must be a positive integer.");
            return;
        }


        for (int i = rows; i > 0; i--) {
            // Print leading spaces for alignment
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }


    }
}
