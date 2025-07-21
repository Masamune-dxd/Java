package ProgrammingChallenge;

import java.util.Scanner;

public class SumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.print("Enter an integer to add (or type '=' to finish): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("=")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                sum += number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or '=' to finish.");
            }
        }
        System.out.println("The sum of all integers is: " + sum);
        scanner.close();
    }
}