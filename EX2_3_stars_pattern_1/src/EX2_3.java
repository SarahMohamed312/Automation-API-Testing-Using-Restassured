import java.util.Scanner;

import java.util.Scanner;
public class EX2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of rows
        System.out.print("Enter the number of rows for the triangle: ");
        int rows = scanner.nextInt();

        // Validate the input
        if (rows <= 0) {
            System.out.println("Error: Number of rows must be a positive integer.");
            return;
        }

        // Print the triangle pattern
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
