import java.util.Scanner;

public class Ex1_2 {


    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        // Constants for time conversions
        final int MINUTES_IN_HOUR = 60;
        final int HOURS_IN_DAY = 24;
        final int DAYS_IN_YEAR = 365;

        // Read input from the user
        System.out.print("Input the number of minutes: ");
        long minutes = s1.nextLong();

        // Validate input
        if (minutes < 0) {
            System.out.println("The number of minutes cannot be negative.");
            return;
        }

        // Convert minutes to total days
        long totalDays = minutes / (MINUTES_IN_HOUR * HOURS_IN_DAY);

        // Convert total days to years and remaining days
        long years = totalDays / DAYS_IN_YEAR;
        long remainingDays = totalDays % DAYS_IN_YEAR;

        // Output the result
        System.out.println(minutes + " minutes is approximately " + years + " years and " + remainingDays + " days.");
    }
}
