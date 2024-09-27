import java.util.Scanner;
public class EX2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Input an integer between 0 and 2000: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 2000) {
            System.out.println("Error: Number must be between 0 and 1000.");
            scanner.close();
            return;
        }

        int sumOfDigits = 0;
        int biggestDigit = 0;
        int tempNumber = number;

        // Process each digit
        while (tempNumber > 0) {
            int digit = tempNumber % 10; // Extract the last digit
            sumOfDigits += digit;
            if (digit > biggestDigit) {
                biggestDigit = digit; // Update the biggest digit
            }
            tempNumber /= 10; // Remove the last digit
        }

        // Print the results
        System.out.println("The sum of all digits in " + number + " is " + sumOfDigits);
        System.out.println("The biggest digit is " + biggestDigit);

    }
}
