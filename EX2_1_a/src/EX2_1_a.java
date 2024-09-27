15import java.util.Scanner;

public class EX2_1_a {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        String operator;
        double result;

        System.out.println("Basic Calculator");
        System.out.println("-----------------");

        // Get first number from the user
        System.out.print("Enter first number: ");
        num1 = scanner.nextDouble();

        // Get operator from the user
        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next();

        // Get second number from the user
        System.out.print("Enter second number: ");
        num2 = scanner.nextDouble();

        // Perform calculation based on operator
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
                System.out.println("Error: Invalid operator.");
                return;
        }

        // Output the result
        System.out.printf("Result: %.2f\n", result);

    }
}
