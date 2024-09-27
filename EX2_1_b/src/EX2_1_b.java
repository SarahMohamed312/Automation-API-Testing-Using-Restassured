import java.util.Scanner;

public class EX2_1_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        double num1, num2, result;
        String operator;

        System.out.println("Simple Calculator");
        System.out.println("------------------");
        System.out.println("Enter calculation (e.g., 70 + 30):");

        // Read the whole line of input from the user
        inputLine = scanner.nextLine();

        // Split the input line by spaces
        String[] items = inputLine.split(" ");

        // Check if the input is in the correct format
        if (items.length != 3) {
            System.out.println("Error: Invalid input format. Please use the format 'number1 operator number2'.");
            return;
        }

        try {
            // Parse the numbers and operator (convert a String to a double primitive type)
            num1 = Double.parseDouble(items[0]);
            operator = items[1];
            num2 = Double.parseDouble(items[2]);

            // Perform the calculation based on the operator
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    // Handle division by zero
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Error: Invalid operator. Please use +, -, *, or /.");
                    return;
            }

            // Output the result
            System.out.printf("The result is: %.2f\n", result);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please ensure that the numbers are valid.");
        }

    }
}
