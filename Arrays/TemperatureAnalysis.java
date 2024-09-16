package temperatureanalysis;

import java.util.Scanner;

public class temperatureanalysis {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many days of temperature data would you like to enter?");
        int numDays = getNumberOfDays();

        double[] temperatures = getTemperatures(numDays);
        double averageTemp = calculateAverage(temperatures);
        int daysAboveAverage = countDaysAboveAverage(temperatures, averageTemp);

        printResults(averageTemp, daysAboveAverage);

        scanner.close();
    }

    private static int getNumberOfDays() {
        int numDays;
        while (true) {
            try {
                numDays = scanner.nextInt();
                if (numDays > 0) {
                    return numDays;
                } else {
                    System.out.println("Number of days must be greater than 0. Please enter again:");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number:");
                scanner.next(); // clear the invalid input
            }
        }
    }

    private static double[] getTemperatures(int numDays) {
        double[] temperatures = new double[numDays];
        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ": ");
            while (true) {
                try {
                    temperatures[i] = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid temperature:");
                    scanner.next(); // clear the invalid input
                }
            }
        }
        return temperatures;
    }

    private static double calculateAverage(double[] temperatures) {
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.length;
    }

    private static int countDaysAboveAverage(double[] temperatures, double average) {
        int count = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                count++;
            }
        }
        return count;
    }

    private static void printResults(double averageTemp, int daysAboveAverage) {
        System.out.printf("Average temperature: %.2f\n", averageTemp);
        System.out.println("Number of days above average temperature: " + daysAboveAverage);
    }
}
