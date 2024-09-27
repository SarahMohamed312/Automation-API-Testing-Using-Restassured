import java.util.Scanner;

public class EX2_6 {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for the number of rows
            System.out.print("Enter the number of rows for the right-angled triangle: ");
            int rows = scanner.nextInt();

            // Validate the input
            if (rows <= 0) {
                System.out.println("Error: Number of rows must be a positive integer.");
                return;
            }


            for (int i = rows; i > 0; i--) {
                // Print leading spaces
                for (int j = 0; j < rows - i; j++) {
                    System.out.print(" ");
                }
                // Print stars
                for (int k = 0; k < i; k++) {
                    System.out.print("*");
                }
                // Move to the next line
                System.out.println();
            }
        }
    }
