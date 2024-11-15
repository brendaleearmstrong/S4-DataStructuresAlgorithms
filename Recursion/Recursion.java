package Recursion;

import java.util.Scanner;

public class Recursion {

    public static int sumOfNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNumbers(n - 1);
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "";
        }
        return decimalToBinary(decimal / 2) + (decimal % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer to find the sum of numbers from 1 to N: ");
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = sumOfNumbers(number);
            System.out.println("Sum of numbers from 1 to " + number + " is: " + sum);
        }

        System.out.print("Enter a decimal number to convert to binary: ");
        int decimalNumber = scanner.nextInt();
        if (decimalNumber < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            String binary = decimalToBinary(decimalNumber);
            binary = binary.isEmpty() ? "0" : binary;
            System.out.println("Binary representation of " + decimalNumber + " is: " + binary);
        }

        scanner.close();
    }
}
