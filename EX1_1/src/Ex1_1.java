import java.util.Scanner;

import java.util.Scanner;
public class Ex1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read integer input from the user
        System.out.print("Input an integer between 0 and 1000: ");
        int number = scanner.nextInt();

        // Validate input range
        if (number < 0 || number > 1000) {
            System.out.println("The number is out of range. Please enter a number between 0 and 1000.");
            return;
        }

        // Calculate the sum of the digits
        int sum = 0;
        int temp = number;  // Use a temporary variable to process the digits

        while (temp > 0) {
            sum += temp % 10; // Add the last digit to sum
            temp /= 10;       // Remove the last digit
        }

        // Output the result
        System.out.println("The sum of all digits in " + number + " is " + sum);
    }
}
