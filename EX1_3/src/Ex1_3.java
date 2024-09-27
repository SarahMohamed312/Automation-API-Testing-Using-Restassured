import java.util.Scanner;

import java.util.Scanner;
public class Ex1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for conversion
        final double POUNDS_TO_KG_CONVERSION = 0.45359237;
        final double INCHES_TO_METERS_CONVERSION = 0.0254;

        // Read input from the user
        System.out.print("Input weight in pounds: ");
        double weightPounds = scanner.nextDouble();

        System.out.print("Input height in inches: ");
        double heightInches = scanner.nextDouble();

        // Convert weight and height to metric units
        double weightKg = weightPounds * POUNDS_TO_KG_CONVERSION;
        double heightMeters = heightInches * INCHES_TO_METERS_CONVERSION;

        // Calculate BMI
        double bmi = weightKg / (heightMeters * heightMeters);

        // Output the result
        System.out.println("Body Mass Index is " + bmi);
    }
}
