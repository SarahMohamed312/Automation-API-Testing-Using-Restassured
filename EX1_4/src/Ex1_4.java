//Write a Java program that reads a number and displays the square, cube, and fourth powerimport java.util.Scanner;

import java.util.Scanner;
import java.lang.Math;
public class Ex1_4 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Read input from the user
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();

        // Calculate the square, cube, and fourth power
        double square = Math.pow(number, 2);
        double cube = Math.pow(number, 3);
        double fourthPower = Math.pow(number, 4);

        // Output the results
        System.out.println("The square of " + number + " is " + square);
        System.out.println("The cube of " + number + " is " + cube);
        System.out.println("The fourth power of " + number + " is " + fourthPower);
    }
}
